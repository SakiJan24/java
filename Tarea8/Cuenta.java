/*
Clase abstracta cuenta
Objetivo: Es la clase padre
*/
public abstract class Cuenta {
    private String cliente;
    private double saldoDisponible;

  /*
Nombre: Constructor por defecto cuenta
Objetivo: Inicializar las variables por defecto
Entrada: Ninguna
Salida: Ninguna
  */
    Cuenta() {
        this.cliente = new String();
        this.saldoDisponible = 0.0;
    }
/*
Nombre: Constructor Cuenta
Objetivo: Asignar valores a las variables cliente y saldoDisponible
Entrada: Cliente y saldoDisponible
Salida: Ninguna
  */
    Cuenta (String cliente, double saldoDisponible) {
        this.cliente = cliente;
        this.saldoDisponible = saldoDisponible;

    }
  /*
Nombre: calcular_saldo
Objetivo: método abstracto que calcula el saldo de la cuenta conforme a la clase hija
Entrada: Ninguna
Salida: Ninguna
  */
    public abstract double calcular_saldo();
/*
Nombre: Consignar
Objetivo: Consignar dinero conforme el cliente pide
Entrada: valorConsignar
Salida: Ninguna
  */
    public void consignar(double valorConsignar) {
        System.out.println("Se consignó el valor de " + valorConsignar);
        this.saldoDisponible = this.saldoDisponible - valorConsignar;
    }
/*
Nombre: Retirar 
Objetivo: Retirar dinero de la cuenta conforme pide el cliente
Entrada: valorRetirar
Salida: Ninguna
  */
    public double retirar(double valorRetirar) {
        if(saldoDisponible >= valorRetirar ) {
            System.out.println("Transacción válida, reciba su dinero: ");
            this.saldoDisponible = this.saldoDisponible - valorRetirar;
          
            return valorRetirar;
        }
        else {
            System.out.println("Lo sentimos, no cuenta con el dinero suficiente para esta transacción");
            return 0.0;
        }
    }

  
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public String getCliente() {
        return cliente;
    }
}