
//hecho por Nicolás Arciniegas y por Isaac Janica
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        LinkedList <Cuenta> cuentas = new LinkedList<Cuenta>();

        System.out.println("Hello world!");
        CuentaAhorros laCuentaAhorros = new CuentaAhorros();
        CuentaCorriente laCuentaCorriente = new CuentaCorriente();
        laCuentaAhorros.setCliente("Gonzalo");
        laCuentaAhorros.setSaldoDisponible(1200000);
        laCuentaAhorros.setPorcentajeInteres(0.13); // toca pensar este método porque es el interés por el valor de la cuenta más el valor de la cuenta

        laCuentaAhorros.retirar(200000);
      
        laCuentaCorriente.setCliente("Pablo");
        laCuentaCorriente.setSaldoDisponible(900000);
        laCuentaCorriente.setValorSobreGiro(400000);

        cuentas.add(laCuentaAhorros);
        cuentas.add(laCuentaCorriente);
        String auxiliar;
        String [] arreglo;
        for(Cuenta cuentica: cuentas) {
          auxiliar = String.valueOf(cuentica.getClass());
          arreglo = auxiliar.split(" ");
      
          System.out.println("Su saldo de " + arreglo[1] + " es de "+cuentica.calcular_saldo());
          
        }

    

//Profe, en uno de los métodos de calcular saldo tenemos un error, sin embargo, es un error contable el cuál no se puede resolver a menos de que se modifiquen los requirimientos del mismo, si acaso, el día de mañana (después del parcial), le explicamos cuál era este error contable
    }
}