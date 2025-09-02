package Views;

import Controllers.CajeroController;
import Models.CajeroModel;

public class CajeroAutomatico {
    public static void main(String[] args) {
        CajeroModel model=new CajeroModel();
        CajeroViews view=new CajeroViews();
        CajeroController controller=new CajeroController(model,view);
        controller.iniciarSistema();
    }
}
