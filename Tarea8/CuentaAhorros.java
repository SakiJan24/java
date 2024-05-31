/*
Nombre: Clase Cuenta ahorros
Objetivo: Clase hija de clase Cuenta 
  */
public class CuentaAhorros extends Cuenta {

    public double porcentajeInteres;
/*
Nombre: Constructor por defecto CuentaAhorros
Objetivo: Inicializar las variables por defecto
Entrada: Ninguna
Salida: Ninguna
  */
    CuentaAhorros () {
        super();
        this.porcentajeInteres = 0.0;
    }
/*
Nombre: Constructor CuentaAhorros
Objetivo: Asignar valores a los atributos de la clase
Entrada: Cliente, saldoDisponible, porcentajeInteres
Salida: Ninguna
  */
    CuentaAhorros (String cliente, double saldoDisponible, double porcentajeInteres) {
        super(cliente,saldoDisponible);
        this.porcentajeInteres = porcentajeInteres;

    }
/*
Nombre: calcular_saldo
Objetivo: Calcular el saldo de la cuenta multiplicando el saldo actual por el interés, y sumándole el saldo
Entrada: Ninguna
Salida: Ninguna
  */
    public double calcular_saldo(){
        return ((super.getSaldoDisponible()*porcentajeInteres) + super.getSaldoDisponible() );
    }

    public void setPorcentajeInteres(double porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }

    public double getPorcentajeInteres() {
        return porcentajeInteres;
    }
}