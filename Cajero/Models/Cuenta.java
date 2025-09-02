package Models;

public class Cuenta {
    private String numeroCuenta;
    private String pin;
    private double saldo;
    private String titular;
    public Cuenta(String numeroCuenta, String pin, double saldoInicial, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldoInicial;
        this.titular = titular;
    }
    public String getNumeroCuenta() { return numeroCuenta;}
    public String getPin() { return pin;}
    public double getSaldo() { return saldo;}
    public String getTitular() { return titular;}
    public boolean validarPin(String pinIngresado) {
        return pin.equals(pinIngresado);
    }
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= this.saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
    public boolean depositar(double cantidad) {
        if (cantidad > 0 && cantidad <= this.saldo) {
            saldo += cantidad;
            return true;
        }
        return false;
    }
    public boolean transferir(double cantidad) {
        if (cantidad > 0 && cantidad <= this.saldo) {

            saldo -= cantidad;

            return true;
        }
        return false;
    }
}
//Servicios, caridad,