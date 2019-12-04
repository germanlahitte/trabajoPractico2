package vista.contenedores;

import controlador.botones.HandlerBotonComprarCatapulta;
import controlador.botones.HandlerBotonComprarCurandero;
import controlador.botones.HandlerBotonComprarJinete;
import controlador.botones.HandlerBotonComprarSoldado;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.juego.Ronda;
import vista.botones.VistaBotonComprarCatapulta;
import vista.botones.VistaBotonComprarCurandero;
import vista.botones.VistaBotonComprarJinete;
import vista.botones.VistaBotonComprarSoldado;

public class MenuTienda extends VBox {

        public MenuTienda(Ronda ronda){

            this.setSpacing(60);

            Button botonComprarSoldado = new Button();
            VistaBotonComprarSoldado vistaBotonComprarSoldado = new VistaBotonComprarSoldado(botonComprarSoldado);
            HandlerBotonComprarSoldado eventoComprarSoldado = new HandlerBotonComprarSoldado(ronda);
            botonComprarSoldado.setOnAction(eventoComprarSoldado);

            Button botonComprarJinete = new Button();
            VistaBotonComprarJinete vistaBotonComprarJinete = new VistaBotonComprarJinete(botonComprarJinete);
            HandlerBotonComprarJinete eventoComprarJinete = new HandlerBotonComprarJinete(ronda);
            botonComprarJinete.setOnAction(eventoComprarJinete);

            Button botonComprarCurandero = new Button();
            VistaBotonComprarCurandero vistaBotonComprarCurandero = new VistaBotonComprarCurandero(botonComprarCurandero);
            HandlerBotonComprarCurandero eventoComprarCurandero = new HandlerBotonComprarCurandero(ronda);
            botonComprarCurandero.setOnAction(eventoComprarCurandero);

            Button botonComprarCatapulta = new Button();
            VistaBotonComprarCatapulta vistaBotonComprarCatapulta = new VistaBotonComprarCatapulta(botonComprarCatapulta);
            HandlerBotonComprarCatapulta eventoComprarCatapulta = new HandlerBotonComprarCatapulta(ronda);
            botonComprarCatapulta.setOnAction(eventoComprarCatapulta);

            VBox contenedorVacio = new VBox();

            this.getChildren().addAll(contenedorVacio,botonComprarSoldado,botonComprarJinete,botonComprarCurandero,botonComprarCatapulta);

        }
}
