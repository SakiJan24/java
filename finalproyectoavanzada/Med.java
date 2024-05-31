import java.util.LinkedList;
import java.util.Scanner;
import java.lang.Integer;

/*
Nombre: Medico
Objetivo: Tener una clase en la que se pueda tener la información de un médico
Entrada: Por medio de sets y gets, o, el constructor, asignar el nombre, Id, especialidad1 y especialidad2 del médico
Salida: Salida, por medio de los gets se pueden retornar todos los ítems mencionadas en Entrada.
*/
public abstract class Med {
    private String nombre = new String();
    private int id = 0;
    LinkedList <Fecha> calendario = new LinkedList <Fecha>();
  
    
    // aprender a instanciar, sin medir instancias
    private int valorHora;

    Med () {
      
    }
  
    Med(String nombre, int id, int valorHora) {

        this.id = id;
        this.nombre = nombre;
        this.valorHora = valorHora;
      


    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;

    }

    public int getValorHora() {
        return this.valorHora;
    }

    public void setCalendario( LinkedList <Fecha> calendario) {
      this.calendario = calendario;
    }
/* 
Nombre: añadir cita
Entrada: objeto de la clase Fecha 
Salida: Ninguna
Objetivo: agregar a la linked list calendario el objeto de la clase fecha que entro al metodo
*/
    public void annadir_cita(Fecha laFecha) {
      this.calendario.add(laFecha);
    }

    public abstract String getTipo();
    public abstract void leer_disponibilidad();
    public abstract Especialidad getEspecialidad();
    public abstract void crear_disponibilidad();
    public abstract boolean verificar_disponibilidad(int fecha);
    public abstract double calcular_valor_cita(int minutos);
    public abstract void modificar_disponibilidad(int dia, double hora);
    public abstract void escribir_datos();
}