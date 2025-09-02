package Models;
import java.util.HashMap;
import java.util.Map;

public class CajeroModel {
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;

    public CajeroModel() {
        cuentas = new HashMap<>();
        inicializarCuentas();
    }

    private void inicializarCuentas() {
        cuentas.put("12345", new Cuenta("12345", "1111", 50000.80, "Juan Perez"));
        cuentas.put("5468", new Cuenta("5468", "2222", 3455.90, "Maria Perez"));
        cuentas.put("4356", new Cuenta("4356", "3333", 7895.33, "Roberto Martinez"));
        cuentas.put("9823", new Cuenta("9823", "4444", 755.50, "Julio Ramos"));
    }

    public boolean auntenticar(String numeroCuenta, String pin) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarPin(pin)) {
            this.cuentaActual = cuenta;
            return true;
        }
        return false;
    }

    public Cuenta getCuentaActual() {
        return this.cuentaActual;
    }

    public double consultarSaldo() {
        return this.cuentaActual != null ? this.cuentaActual.getSaldo() : 0;
    }

    public boolean realizarRetiro(double cantidad) {
        return cuentaActual != null && this.cuentaActual.retirar(cantidad);
    }

    public boolean realizarDeposito(double cantidad) {
        return cuentaActual != null && this.cuentaActual.depositar(cantidad);

    }
    public boolean realizarTransferencia(double cantidad) {
        return cuentaActual != null && this.cuentaActual.transferir(cantidad);
    }
}


