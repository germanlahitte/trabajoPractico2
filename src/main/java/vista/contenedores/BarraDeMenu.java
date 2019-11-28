package vista.contenedores;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;
import vista.eventos.OpcionPantallaCompletaEventHandler;
import vista.eventos.OpcionSalirEventHandler;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage escenario){
        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAbrir = new MenuItem("Abrir");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(escenario, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(opcionAbrir,new SeparatorMenuItem(),opcionSalir);
        menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo,menuVer);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }

}