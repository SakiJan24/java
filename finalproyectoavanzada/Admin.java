import java.io.FileWriter;
public class Admin extends Usuario {
  private int contrasenna =11112020;

  Admin() {
    super();
  }
  public void setContrasenna(int contrasenna) {
    this.contrasenna = contrasenna;
  }

  public int getContrasenna () {
    return contrasenna;
  }
/* 
Nombre: escribir datos
Entrada: Ninguna
Salida: Ninguna
Objetivo: en el archivo "ElAdmin.txt" guarda la informacion de los usuarios administrados, los cuales son los atributos de un objeto de la clase admin.

*/
  @Override   
  public void escribir_datos(){

    try{
          FileWriter fw = new FileWriter("ElAdmin.txt",true);
      fw.write(this.email+","+this.nombre+","+this.id+","+this.contrasenna);

      
    }catch (Exception e) {

            System.out.println("Error");
            e.printStackTrace();
        }
  

  }

}