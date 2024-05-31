import java.util.ArrayList;

/*
Nombre: Transmilenio
Objetivo: Clase hija de transporte que almacena a los transminlenios
*/
public class Transmilenio extends Transporte {

    private String placa;
    private String numeroBus;
    public ArrayList <String> paraderos = new ArrayList <String>();
    
/* 
Nombre: trasmilenio(constructor)
Objetivo: inicializar los atributos de un objeto de tipo trasmilenio
Entrada: Nada
Salida: 
*/

    Transmilenio () {
        super();
        this.placa=new String();
        this.numeroBus=new String();
        
    }
/* 
Nombre: trasmilenio(constructor)
Objetivo: inicializar los atributos a partir de variables especificas
Entrada: placa, numeroBus, numeroSerial, tipoCombustible, tipo, cantPasajeros, peso, nivelCombustible, valorPasaje
Salida: 
*/
    Transmilenio (String placa, String numeroBus, String numeroSerial, String tipoCombustible, String tipo, int cantPasajeros, double peso, String nivelCombustible, double valorPasaje ) {
        super(numeroSerial, tipoCombustible, tipo, cantPasajeros, peso, nivelCombustible);
        this.placa = placa;
        this.numeroBus = numeroBus;
        


    }

/*
Nombre: peso del vehiculo
Objetivo: Sobre cargar el el método peso vehículo y convertir el peso en toneladas a kilogramos
Entrada: Nada
Salida: Double
*/
    public double pesoVehiculo(){
        return ((super.getPeso())*1000000);
    }


  public void setPlaca (String placa) {
    this.placa = placa;
  }

  public void setNumeroBus (String numeroBus) {
    this.numeroBus = numeroBus;
  }

  public String getPlaca() {
    return placa;
  }
  
  public String getNumeroBus() {
    return numeroBus;
  }

  /*
Nombre: valor pasaje
Objetivo; retornar el valor del pasaje
Entrada: Nada
Salida: Double
*/
  public double valor_pasaje() {
    double pasaje = 2650;
    return pasaje;
  }


}