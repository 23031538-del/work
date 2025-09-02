package Views;
import java.util.Scanner;

public class CajeroViews {
    private Scanner scanner;
    public CajeroViews() {
        scanner = new Scanner(System.in);
    }public void mostrarBienvenida(){
        System.out.println("========================================");
        System.out.println("Bienvenido al Cajero Automatico del banco del bajio");
        System.out.println("========================================");
    }
    public String solicitarNumeroCuenta(){
        System.out.println("Ingresar el Numero de Cuenta: ");
        return scanner.nextLine();
    }
    public String solicitarPin(){
        System.out.println("Ingresar el PIN: ");
        return scanner.nextLine();
    }
    public void mostrarMenuPrincipal(String titular){
        System.out.println("========================================");
        System.out.println("Bienvenid@ " + titular);
        System.out.println("========================================");
        System.out.println("1. Ingresar Cuenta");
        System.out.println("2. Retirar");
        System.out.println("3, Depositar");
        System.out.println("4. Transferir");

        System.out.println("9. Salir");
    }
    public int leerOpcion(){
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            return -1;
        }
    }
    public void mostrarSaldo(double saldo){
        System.out.println("========================================");
        System.out.println("Tu Saldo es: $" + saldo);
        System.out.println("========================================");
    }
    public double solicitarcantidad (String operacion){
        System.out.println("Ingresa la cantidad a " + operacion + ": ");
        try {
            return Double.parseDouble(scanner.nextLine());
        }catch (NumberFormatException e){
            return -1;
        }
    }
    public void mostrarMensaje(String mensaje){
        System.out.println("======" + mensaje);
    }
    //error y exito
    //salir cerrar
}
