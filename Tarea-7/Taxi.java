import java.util.Scanner;
/* 
Nombre: Taxi
Objetivo: Clase hija de transporte que almacena los taxis
*/
public class Taxi extends Transporte {
    private String placa;
    private String tipoCarro;
/*
Nombre: Taxi(constructor por defecto)
Objetivo; inicializar los atributos de un objeto de tipo taxi
Entrada: Nada
Salida: 
*/
    Taxi () {
        super();
        this.placa = new String();
        this.tipoCarro = new String();

    }
  /* 
Nombre: Taxi(constructor con parametros)
Objetivo; inicializar los atributos a partir de variables especificas
Entrada:placa, tipoCarro, numeroSerial, tipoCombustible, tipo, cantPasajeros, peso, nivelCombustible, valorPasaje
Salida: 
*/
    Taxi (String placa, String tipoCarro, String numeroSerial, String tipoCombustible, String tipo, int cantPasajeros, double peso, String nivelCombustible, String valorPasaje ) {
        super(numeroSerial, tipoCombustible, tipo, cantPasajeros, peso, nivelCombustible);
        this.placa = placa;
        this.tipoCarro = tipoCarro;

    }
/* 
Nombre: peso_vehiculo
Objetivo; retornar peso del vehiculo si ya fue ingresado, si no imprimir un error que pida ingresar el peso
Entrada: Nada
Salida: Double
*/
    public double peso_vehiculo() {
        if (super.getPeso() > 0) {
            return super.getPeso();
        }
        else {
            System.out.println("No hay peso registrado, por favor registrelo");

        }
        return super.getPeso();

    }

/* 
Nombre: Valor cobrar
Objetivo: retornar el valor a cobrar en formata String
Entrada: Nada
Salida: String valorCobrar
*/
    public static String valor_cobrar() {
        
      /*int tarifaUnd, numeroTaximetro, valorCobrar;
        Scanner elScanner1 = new Scanner(System.in);
        Scanner elScanner2 = new Scanner(System.in);

        System.out.println("Ingrese el la tarifa por unidad del taximetro");
        tarifaUnd = elScanner1.nextInt();
        System.out.println("Ingrese el numero en el taximetro");
        numeroTaximetro = elScanner2.nextInt();
        valorCobrar = numeroTaximetro*tarifaUnd;

        System.out.println("Valor a cobrar"+valorCobrar);
      */
      
      String valorCobrar = "El valor a cobrar es el que marque el taximetro conforme a la tarifa del día";
      
        return valorCobrar;

    }
  
  public void setPlaca(String placa) {
    this.placa = placa;
  }
  
  public void setTipoCarro(String tipoCarro) {
    this.tipoCarro = tipoCarro;
  }

  public String getPlaca() {
    return placa;
  }
  
  public String getTipoCarro() {
    return tipoCarro;
  }
}