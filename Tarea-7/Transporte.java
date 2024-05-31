//import java.util.LinkedList;

/* 
Nombre: Transporte
Objetivo: Clase padre bajo la que crea transmilenio y taxi
*/
public class Transporte {
    private String numeroSerial;
    private String tipoCombustible;
    private String tipo;
    private int cantPasajeros;
    private double peso;



/* 
Nombre: Primer construtor por defecto
Objetivo: dejar los valores en null, 0 o crear espacio en memoria para String
Entrada: Nada
Salida: Nada
*/
    Transporte () {
        this.numeroSerial = new String();
        this.tipoCombustible = new String ();
        this.tipo = new String();
        this.cantPasajeros = 0;
        //this.peso = 0.0;
       
    }

/* 
Nombre: Segundo constructor por defecto
Objetivo: Agregar los valores que el usuario quiere annadir al objeto
Entrada: numeroSerial, tipoCombustible, tipo, cantPasajeros, peso, nivelCombustible
Salida: 
*/
    Transporte (String numeroSerial, String tipoCombustible, String tipo, int cantPasajeros, double peso, String nivelCombustible) {
        this.numeroSerial = numeroSerial;
        this.tipoCombustible = tipoCombustible;
        this.tipo = tipo;
        this.cantPasajeros = cantPasajeros;
        this.peso = peso;
        
    }

/*
Nombre: nivel de combustible
Objetivo: Retornar el nivel de combustible acutal del vehiculo
Entrada: Nada
Salida: String con el nivel de combustible
*/
    public String nivel_de_combustible() {
        String nivelCombustible = "El nivel de combustible está bien";
        return nivelCombustible;

    }

 /*
Nombre: peso vehiculo
Objetivo: Retornar el peso del vehiculo, sin embargo, si el peso es menor o igual a cero (no puede ser posible ) se retorna un enunciado de que no peso registrado o esta registrado de manera incorrecta
Entrada: nada
Salida: Double peso
*/ 
    public double peso_vehiculo() {
        if (this.peso > 0) {
            return peso*1000;
        }
        else {
            System.out.println("No hay peso registrado, por favor registrelo");

        }
        return peso*1000;

    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

  
    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }


    public double getPeso() {
        return peso;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }
}