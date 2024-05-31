
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.lang.Boolean;
import java.lang.Double;
public class Internista extends Med {
    private String tipo = "INTERNISTA";
    private int start = 6;
    private int end = 20;
   // private String [] dias = new String [5];
    Especialidad especialidad = new Especialidad("Medicina Interna");
  //  LinkedList <Fecha> calendario; Esto va pa Med

    Internista() {
      super();
    }

    Internista(String nombre, int id, int valorHora) {

        super(nombre, id, valorHora);    

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    public Especialidad getEspecialidad() {
      return especialidad;
    }


//actualizar disponibilidad
  
    public LinkedList<Fecha> getCalendario() {
        return calendario;
    }

    public void setCalendario(LinkedList<Fecha> calendario) {
        this.calendario = calendario;
    }
 
    public void setUniversidad (String universidad) {
      this.especialidad.setUniversidad(universidad);
    }
/*
  Nombre: añadir fecha
  Entrada: objeto de clase Fecha
  Salida: Ninguna
  Objetivo: agregar un objeto de la clase fecha en una lista 
*/

    public void añadir_fecha(Fecha laFecha) {
      calendario.add(laFecha);
    }
  /*
  Nombre: leer disponibilidad
  Entrada: Ninguna
  Salida: Ninguna
  Objetivo: a partir del archivo titulado con el id de un medico en especifico, lee  este archivo y cada linea la convierte en un arreglo de String, lo cual a su vez pemite crear una lista la cual contiene las horas disponibles para pedir cita y si estan ocupadas o no a partir de un bool.
*/
    @Override
  
    public void leer_disponibilidad() {

      try {
        FileReader fr = new FileReader(super.getId()+".txt");
        BufferedReader br = new BufferedReader(fr);
        String linea;
        String [] separador1;
        String [] separador2;
        String [] separador3;

        while((linea = br.readLine()) != null) {
          
          Fecha laFecha = new Fecha();
          separador1 = linea.split(";");
          laFecha.setDia(Integer.parseInt(separador1[0]));
          separador2 = separador1[1].split(",");
          
          for(int i = 0; i < ((this.end - this.start)*2); i++ ) {
            
            Cita laCita = new Cita();
            separador3 = separador2[i].split("-");
            laCita.setHora(separador3[0]);
            //System.out.println(separador3[0]+"-"+separador3[1]);
            laCita.setDisponible(Boolean.parseBoolean(separador3[1]));
            laFecha.añadir_cita(laCita);
            
          }
          this.calendario.add(laFecha);
        }
        
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
/*
  Nombre: verificar disponibilidad
  Entrada: entero fecha
  Salida: bool
  Objetivo: retorna un bool el cual dice si hay citas disponibles para un dia ingresado como int
*/
    @Override 
    public boolean verificar_disponibilidad(int fecha) {
      boolean cosa = false;
      for(Fecha fechita: super.calendario) {
        if(fecha == fechita.getDia()) {
          for(Cita citica: fechita.agenda) {
            if(citica.getDisponible() == true) {
              cosa = true;
              //System.out.println("Si hay cita");
            }
          }
        }
      }
      if(cosa == true) {
        //System.out.println("Si hay citas disponibles para este día");
      }
      else {
       // System.out.println("No hay citas disponibles para este día");
      }
      return cosa;
      
    }

/*
  Nombre: Calcular valor cita
  Entrada: entero
  Salida: double
  Objetivo: retornar el valor de la cita medica a partir del entero que entra, el cual son los minutos que duro la cita y se multiplica por el valor hora que cobra el medico con el cual tuvo la cita
*/
    @Override
    public double calcular_valor_cita(int minutos) {
        return (double)((super.getValorHora())*(minutos));


    }
/*
  Nombre: crear disponibilidad
  Entrada: Ninguno
  Salida: Ninguno
  Objetivo: crear un archivo que tiene como nombre el id de un medico, en este segun el tipo de medico escribira el numero de dia y las horas que este tipo de medico tiene disponible, cada una de estas seguidas de un bool con valor true, ya que en este momento se esta creando desde 0, sin ninguna cita creada aun. y excluira los dias que coincidan con ser sabado o domingo, asumiendo que esos dias no atienden ninguno de los medicos
*/
    @Override
    public void crear_disponibilidad() {
      try {
        FileWriter fw = new FileWriter((super.getId()+".txt"));
        
        int repeticion = 0;
        for(int i = 1; i < 31; i++) {
         int c=(i%7);  //variable auxiliar para eliminar los dias sabados y domingos en el caso que el mes empiece en lunes
        //  System.out.println(c);
          if ((c!=6)&&(c!=0)){
        //   System.out.println(c);
            fw.write(i+";");
            Fecha laFecha = new Fecha();
             //System.out.println("SI entra a al función");
            for(double j = 0; j < (this.end-this.start)*2; j++) {
            //System.out.println("Holaaaaa");
              Cita laCita = new Cita();
            laCita.setCita(String.valueOf(((this.start+j)/2)+3), true);
           // System.out.println("Esta es la hora de la cita rey"+laCita.getHora() );
            fw.write(String.valueOf(laCita.getHora())+"-"+String.valueOf(laCita.getDisponible())+",");
            //System.out.println(laCita.getHora());
            laFecha.añadir_cita(laCita);
          }
          fw.write("\n");
          laFecha.setDia(i);
          this.añadir_fecha(laFecha);
        
          }
        }  
        fw.close();
      } catch (Exception i) {
        i.printStackTrace();
    }  
}
/*
  Nombre: escribir disponibiliddad
  Entrada: Ninguna
  Salida: Ninguna
  Objetivo: crea un archivo con el id del medico internista, este escribira los dias y las horas que tiene dicho medico disponible
*/
  public void escribir_disponibilidad() {
      try {
        FileWriter fw = new FileWriter((super.getId()+".txt"));
        
        int repeticion = 0;
        for(Fecha laFechota: this.calendario) {
          fw.write(laFechota.getDia()+";");  //System.out.println("SI entra a al función");
          for(Cita citica: laFechota.agenda) {
            fw.write(String.valueOf(citica.getHora())+"-"+String.valueOf(citica.getDisponible())+",");
            //System.out.println(laCita.getHora());
          }
          fw.write("\n");
        }  
        fw.close();
      } catch (Exception i) {
        i.printStackTrace();
    }  
}
/*
  Nombre: escribir datos
  Entrada: Ninguna
  Salida: Ninguna
  Objetivo: crea o abre un archivo titulado "Medicos.txt", el cual almacena a los medicos y todos sus atributos separandolos por ',' y  ';' segun el formato que se definio para usar en otros metodos
*/
  public void escribir_datos() {

      try {

            FileWriter fw = new FileWriter("Medicos.txt", true);
        
            fw.write(this.tipo + "," +Integer.toString(super.getId()) + ",");

            fw.write(super.getNombre() + ",");
            fw.write( super.getValorHora()+";");
            fw.write( this.especialidad.getEspecialidad() + "," +this.especialidad.getUniversidad());
              
           
              
            
            fw.write("\n");
            fw.close();
            

        } catch (Exception e) {

            System.out.println("Error");
            e.printStackTrace();
        }
    }
  @Override
  public void modificar_disponibilidad(int dia, double hora) {

    for(Fecha fechita: super.calendario) {
      if(fechita.getDia() == dia) {
        for(Cita laCita: fechita.agenda) {

          if(Double.parseDouble(laCita.getHora()) == hora) {
            laCita.setDisponible(false);
          }
          
        }
      }
      
    }
    this.escribir_disponibilidad();
    
  }
}
  



