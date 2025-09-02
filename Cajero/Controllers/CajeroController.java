package Controllers;

import Models.CajeroModel;
import Views.CajeroViews;

public class CajeroController {
    private CajeroModel model;
    private CajeroViews view;
    private boolean sistemaActivo;

    public CajeroController(CajeroModel model, CajeroViews view) {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }

    public void  iniciarSistema() {
        view.mostrarBienvenida();
        while (sistemaActivo) {
            if (autenticarUsuario()) {
                ejecutarMenuPrincipal();
            } else {
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar nuestro cajero");
    }
    private boolean autenticarUsuario(){
        String numeroCuenta= view.solicitarNumeroCuenta();
        String pin  = view.solicitarPin();
        return model.auntenticar(numeroCuenta, pin);
    }
    private void ejecutarMenuPrincipal() {
        boolean sessionActiva=true;
        while (sessionActiva) {
            view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion= view.leerOpcion();
            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                    case 2:
                        realizarRetiro();
                        break;
                        case 3:
                            realizarDeposito();
                            break;
                            case 4:
                                realizarTransferencia();
                            case 9:
                                break;
                default:
                    break;
            }
        }

    }
    public void consultarSaldo() {
        double saldo= model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }
    public void realizarRetiro() {
        double cantidad= view.solicitarcantidad("Retirar");
        if (cantidad<0){
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarRetiro(cantidad)) {
            view.mostrarMensaje("Saldo retirado con exito");
        } else{
            view.mostrarMensaje("Fondos insuficiente");
        }
    }
    public void realizarDeposito(){
        double cantidad= view.solicitarcantidad("Deposito");
        if (cantidad<0){
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarDeposito(cantidad)) {
            view.mostrarMensaje("Saldo depositado con exito");
        }else {
            view.mostrarMensaje("Error al proceder el deposito");
        }
    }
    public void realizarTransferencia() {
        double cantidad= view.solicitarcantidad("Transferencia");
        if (cantidad<0){
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarTransferencia(cantidad)) {
            view.mostrarMensaje("Saldo transferido con exito");
        }else {
            view.mostrarMensaje("Error al proceder el transferencia");
        }
    }
}

