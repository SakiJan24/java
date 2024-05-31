import java.io.FileWriter;
public class Paciente extends Usuario {

  Paciente () {
    super();
  }
  @Override
  /*
Nombre: escribir datos
Entrada: ninguna
Salida:  ninguna
Objetivo: escribir los datos del nuevo usuario  en el archivo "Usuarios.txt"

  */
  public void escribir_datos(){

    try{
          FileWriter fw = new FileWriter("Usuarios.txt",true);
      fw.write(this.email+","+this.nombre+","+this.id);

      
    }catch (Exception e) {

            System.out.println("Error");
            e.printStackTrace();
        }
  

  }
}