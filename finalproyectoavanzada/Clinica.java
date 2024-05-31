import java.util.LinkedList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.lang.String;
public class Clinica {
  /* 
  String usuarioAdmin = new String();
    String contrasenna = new String();
*/ // esto debe ser una Clase
    //LinkedList<Usuario> pacientes = new LinkedList<Usuario>();
    private Admin elAdmin = new Admin();
    LinkedList<Med> personalMedico = new LinkedList<Med>();

    Clinica() {


    }
/*
    Clinica(String usuarioAdmin, String contrasenna) {
        this.usuarioAdmin = usuarioAdmin;
        this.contrasenna = contrasenna;

    }
*/
  public Admin getAdmin() {
    return elAdmin;
  }
/* 
Nombre: crear medico
Objetivo: ninguna
Entrada: ninguna
Salida: pide al usuario de la aplicacion que ingrese toda la informacion necesaria para crear un medico
  */

    public void crear_medico() {
        Scanner elTipo = new Scanner(System.in);
        Scanner elTipo2 = new Scanner(System.in);
        String tipo;
        int cantEspecialidades;
        System.out.println("Cordial saludo, en este momento va a agregar un médico, por favor diga si es Internista o pediatra");
      // acá se debe ingresar la fecha del día antes que nada
        tipo = String.valueOf(elTipo.nextLine());
        tipo = tipo.toUpperCase();
      //aca toca poner un try catch en caso de que pongan un numero
        if (tipo.equals("INTERNISTA") == true) {
          
            Internista nuevoInterno = new Internista();
            System.out.println("Ingrese el nombre");
            tipo = String.valueOf(elTipo.nextLine());
            nuevoInterno.setNombre(String.valueOf(tipo));
            System.out.println("Ingrese id");
            tipo = String.valueOf(elTipo.nextLine());
            nuevoInterno.setId((Integer.parseInt(tipo)));
            //System.out.println("sdñlfjsflk:  "+ nuevoInterno.getId());
            System.out.println("Ingrese valor hora");
            tipo = String.valueOf(elTipo.nextLine());
            nuevoInterno.setValorHora((Integer.parseInt(tipo)));
            System.out.println("Ingrese la universidad de la especialidad");
            tipo = String.valueOf(elTipo.nextLine());
            nuevoInterno.setUniversidad(tipo);
            nuevoInterno.escribir_datos();
            nuevoInterno.crear_disponibilidad();
          //System.out.println("Lo que muestra el calendario"+nuevoInterno.getCalendario().get(0).getAgenda().get(0).getDisponible());
            personalMedico.add(nuevoInterno);
          

        }
          
        else if (tipo.equals("PEDIATRA") == true) {
          Pediatra nuevoPediatra = new Pediatra();
          
          System.out.println("Ingrese el nombre");
          tipo = String.valueOf(elTipo.nextLine());
          nuevoPediatra.setNombre(String.valueOf(tipo));
          System.out.println("Ingrese id");
          tipo = String.valueOf(elTipo.nextLine());
          nuevoPediatra.setId((Integer.parseInt(tipo)));
          //System.out.println("sdñlfjsflk:  "+ nuevoInterno.getId());
          System.out.println("Ingrese valor hora");
          tipo = String.valueOf(elTipo.nextLine());
nuevoPediatra.setValorHora((Integer.parseInt(tipo)));
          System.out.println("Ingrese la universidad de la especialidad");
          tipo = String.valueOf(elTipo.nextLine());
          nuevoPediatra.setUniversidad(tipo);
          nuevoPediatra.escribir_datos();
          nuevoPediatra.crear_disponibilidad();
          personalMedico.add(nuevoPediatra);
          
        }
    

    }
  /* 
Nombre: eliminar medico
Entrada: Ninguna
Salida: Ninguna
Objetivo: elimina un medico especifico  de la lista de personal medico y del archivo "Medicos.txt"
*/
  public void eliminar_medico() {
    Scanner elScanner1 = new Scanner(System.in);
    Scanner elScanner2 = new Scanner(System.in);
    String id;
    int i = 0;
    System.out.println("Ingrese el id del medico que desea eliminar");
    
    id = elScanner1.nextLine();

    for(Med despedido: personalMedico) {
      if(despedido.getId() == Integer.parseInt(id)) {
        try {
          File myObj = new File(id+".txt");
          myObj.delete();
          personalMedico.remove(i);
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
      i++;
    }
    
  }
    
    
      
/*
  Nombre: cargar medico
  Entrada: ninguno
  Salida: ninguno
  Objetivo: leer el archivo "Medicos.txt" para sacar la informacion de los medicos de este, crear objetos de la clase med, y luego meterlos a una lista titulada personal medico
*/

  
    public void cargar_medicos() {

      
      try {
        FileReader fr = new FileReader("Medicos.txt");
        BufferedReader br = new BufferedReader(fr);
        String linea;
        String [] separador;
        String [] infoGeneral;
        String [] especialidades;
        
        
        while((linea = br.readLine()) != null) {
          //System.out.println("Muestrese rey" + String.valueOf(linea));
          separador = linea.split(";");
          //System.out.println("A ver que muestra"+separador[1]);
          infoGeneral = separador[0].split(",");
         // System.out.println(separador[1]);
          especialidades = separador[1].split(",");
          if(infoGeneral[0].equals("INTERNISTA")) {
            Internista elNuevo = new Internista(infoGeneral[2], Integer.parseInt(infoGeneral[1]), Integer.parseInt(infoGeneral[3])); // nombre, id, valor hora
            String universidad = new String(especialidades[1]);
            elNuevo.setUniversidad(universidad);
            //System.out.println(elNuevo.getEspecialidad().getUniversidad()); 
            elNuevo.leer_disponibilidad();
        
            
            
            
            personalMedico.add(elNuevo);
        //    elNuevo.escribir_datos();
          }

          else if(infoGeneral[0].equals("PEDIATRA")) {
            separador = linea.split(";");
            infoGeneral = separador[0].split(",");
            //System.out.println(separador[1]);
            especialidades = separador[1].split(",");
            Pediatra elNuevo = new Pediatra(infoGeneral[2], Integer.parseInt(infoGeneral[1]), Integer.parseInt(infoGeneral[3]) );
            String universidad = new String(especialidades[1]);
            elNuevo.setUniversidad(universidad);  
            elNuevo.leer_disponibilidad();
            personalMedico.add(elNuevo);
            
            
          
          }
          
        } 
       
      }catch(Exception e) {
          e.printStackTrace();
      }
    }
/*
  Nombre: agendar cita
  Entrada: String especialidad, entero fecha, String hora
  Salida: linked list de la clase med
  Objetivo: retorna una lista con los medicos que cumplen con las condiciones de especialidad, fecha y hora disponible para asi agendar la cita y que el usuario escoga cual de estos quiere con lo atienda
*/
  
  public LinkedList <Med> agendar_cita(String especialidad, int fecha, String hora){
    //System.out.println("Si entra a la func");
    hora.replace(":30",".5");//para que el usuario pueda escribir por ejemplo 7:30 y que el metodo lo cambie de una vez por 7.5 lo cual facilitara compararlo con el archivo
    //System.out.println("Si entra despues de hora"+hora);
    LinkedList <Med> definitivos = new LinkedList <Med>();
    //System.out.println(this.personalMedico.get(0).getNombre());
    for(Med dotor: personalMedico) {
      //System.out.println("Entra a dotor");
      String compara = new String("class ");
      compara = compara.concat(especialidad);
      compara = compara.toUpperCase(); // CLASS INTERNISTA O CLASS PEDIATRA
    
      // System.out.println(compara);
      //System.out.println(String.valueOf((dotor.getClass())).toUpperCase());
      if(compara.equals(String.valueOf((dotor.getClass())).toUpperCase()) ) {
        //System.out.println("Entra a fechita");
        for(Fecha fechita: dotor.calendario) {
         // System.out.println("Entra al calendario");
          if((fechita.getDia() == fecha)&& dotor.verificar_disponibilidad(fecha)) {
            //System.out.println("Si entra a disponiblidad");
            for(Cita laCita: fechita.agenda) {
             // System.out.println(laCita.getHora()+"   "+laCita.getDisponible());
              if((laCita.getHora().equals(hora)) && laCita.getDisponible()) {
                definitivos.add(dotor);
                
              }
            }
            
          }
        }
      }
    }
    for(int i = 0; i < definitivos.size(); i++) {
      System.out.println((i+1)+"."+"El Medico: "+ definitivos.get(i).getNombre()+" de la universidad "+ definitivos.get(i).getEspecialidad().getUniversidad());
      
    }

    Scanner elScanner = new Scanner(System.in);
    String medicoEscogido;
    System.out.println("Los tres pueden atenderle el "+ fecha + " a las "+ hora );
    System.out.println("Ingrese el nombre del medico que queire que le atienda");
    medicoEscogido = elScanner.nextLine();
    medicoEscogido = medicoEscogido.toUpperCase();
    for(int i = 0; i < definitivos.size(); i++) {
      if(medicoEscogido.equals(definitivos.get(i).getNombre().toUpperCase())) {
        definitivos.get(i).modificar_disponibilidad(fecha, Double.parseDouble(hora));
        
      }
    }
    
    
    return definitivos;
    
    
  
  }
/*
  Nombre: reescribir medicos
  Entrada: Ninguna
  Salida: Ninguna
  Objetivo: toma la lista personal medico de la clase med y la sobreescribe en el archivo "Medicos.txt"
*/
  public void reescribir_medicos(){
    try {
      FileWriter fw = new FileWriter("Medicos.txt");
      for(Med dotor: personalMedico) {
        fw.write(dotor.getTipo() + "," +Integer.toString(dotor.getId()) + ",");
        fw.write(dotor.getNombre() + ",");
        fw.write( dotor.getValorHora()+";");
        fw.write( dotor.getEspecialidad().getEspecialidad() + "," +dotor.getEspecialidad().getUniversidad());
        fw.write("\n");
      }
      fw.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
    
  }
    /* 
Nombre: asistir cita
Entrada: Ninguna
Salida: Ninguna
Objetivo: solicita el nombre del doctor para asi verificar aque asistio a la cita programada y tambien dependiendo del doctor cobra lo que vale la consulta
*/

  public void asistir_cita() {
    Scanner elScanner1 = new Scanner(System.in);
    String nombre;
    System.out.print("Por favor, para asistir a la cita ingrese el nombre del doctor que se le asigno");
    nombre = elScanner1.nextLine();
    

    for(Med dotor: personalMedico) {
      if(nombre.equals(dotor.getNombre())) {
        System.out.println("Confirmado, por favor ingrese "+(0.5*dotor.getValorHora())+" pesos");
        
      }
    }
  }
}
