import java.io.FileWriter;

public abstract class  Usuario {
  //usuarios.txt
  //citas.txt
    String email = new String();
    String nombre = new String();
    String id = new String();

  Usuario () {
    
  }
  Usuario (String email, String nombre, String id) {
        this.email = email;
        this.nombre = nombre;
        this.id = id;
  }
  public String getemail(){
    return this.email;
  }
  
  public String getNombre(){
    return this.nombre;
  }
  public String getId(){
    return this.id;
  }
  public void setEmail(String email){
    this.email=email;
  }
  public void seNombre(String nombre){
    this.nombre=nombre;
  }
  public void setId(String id){
    this.id=id;
  }
/*
  Nombre: escribir datos
  Entrada: ninguna
  Salida: ninguna
  Objetivo: metodo abstracto
*/
   public abstract void escribir_datos();
  
}
