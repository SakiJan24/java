// Hecho por Nicolás Arciniegas e Isaac Janica
public class Main {
    public static void main(String[] args) {


        Taxi elTaxi = new Taxi( "placa",  "tipoCarro",  "numeroSerial",  "tipoCombustible", " tipo",  4,  2,  "nivelCombustible",  "valorPasaje" );
        System.out.println(elTaxi.peso_vehiculo());
        

       // elTaxi.valor_cobrar();
        Transmilenio elTransmilenio = new Transmilenio("placa", "numeroBus",  "numeroSerial",  "tipoCombustible",  "tipo", 100, 20, "4", 2650 );
        System.out.println(elTransmilenio.getPeso());
        System.out.println(elTransmilenio.pesoVehiculo());
    }
}