/*
Nombre: Clase CuentaCorriente
Objetivo: Hija de la clase Cuenta 
  */

public class CuentaCorriente extends Cuenta {

    private double valorSobreGiro;
/*
Nombre: Constructor por defecto CuentaCorriente
Objetivo: Inicializar las variables por defecto
Entrada: Ninguna
Salida: Ninguna
*/
    CuentaCorriente() {
        super();
        this.valorSobreGiro = 0.0;
    }

/*
Nombre: Constructor CuentaCorriente
Objetivo: Asignar valores a los atributos dentro de la clase
Entrada: cliente, saldoDisponible, valorSobreGiro
Salida: Ninguna
  */
    CuentaCorriente(String cliente, double saldoDisponible, double valorSobreGiro) {
        super(cliente,saldoDisponible);
        this.valorSobreGiro = valorSobreGiro;

    }
/*
Nombre: calcular_saldo
Objetivo: Calcular el saldo dentro de la sumando el saldo disponible más el sobregiro
Entrada: Ninguna
Salida: Ninguna
  */
    public double calcular_saldo() {
        return (super.getSaldoDisponible()+this.valorSobreGiro);
    }

    public void setValorSobreGiro(double valorSobreGiro) {
        this.valorSobreGiro = valorSobreGiro;
    }

    public double getValorSobreGiro() {
        return valorSobreGiro;
    }

}