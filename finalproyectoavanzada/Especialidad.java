/*
Nombre: Especialidad
Objetivo: Es la clase especialidad en dónde se guarda la especialidad del médico y la universidad dónde la hizo
Entrada: Por medio de set se asigna la la especialidad y la universidad que son Strings.
Salida: Por medio de los gets se puede retornar el String especialidad y universidad
*/
import javax.swing.*;
import java.util.Scanner;
import java.lang.Object;
public class Especialidad {

    private String especialidad = new String();
    private String universidad = new String();

    Especialidad(String especialidad) {

      this.especialidad = especialidad;
      

    }

    Especialidad(String especialidad, String universidad)  {
      this.especialidad = especialidad;
      this.universidad = universidad;
    }

    public void setEspecialidad() {
        Scanner elScanner1 = new Scanner(System.in);
        System.out.println("Ingrese la especialidad");
        this.especialidad = elScanner1.nextLine();

    }
  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }
  

    public void setUniversidad() {
        Scanner elScanner3 = new Scanner(System.in);
        System.out.println("Ingrese la universidad");
        this.universidad = elScanner3.nextLine();

    }
  
  public void setUniversidad(String universidad) {
    this.universidad = universidad;
    
  }
  
    public String getEspecialidad() {
        return especialidad;
    }

    public String getUniversidad() {
        return universidad;
    }

}
