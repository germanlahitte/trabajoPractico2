package vista.contenedores;

import controlador.botones.HandlerBotonComprarCatapulta;
import controlador.botones.HandlerBotonComprarCurandero;
import controlador.botones.HandlerBotonComprarJinete;
import controlador.botones.HandlerBotonComprarSoldado;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.juego.Juego;
import modelo.juego.Observer;
import vista.botones.*;

public class MenuTienda extends VBox implements Observer {

        private Juego partida;

        public MenuTienda(Juego partida){

            this.partida = partida;

            this.setSpacing(60);

            Button botonComprarSoldado = new Button();
            VistaBotonComprarSoldado vistaBotonComprarSoldado = new VistaBotonComprarSoldado(botonComprarSoldado);
            HandlerBotonComprarSoldado eventoComprarSoldado = new HandlerBotonComprarSoldado(partida);
            botonComprarSoldado.setOnAction(eventoComprarSoldado);

            Button botonComprarJinete = new Button();
            VistaBotonComprarJinete vistaBotonComprarJinete = new VistaBotonComprarJinete(botonComprarJinete);
            HandlerBotonComprarJinete eventoComprarJinete = new HandlerBotonComprarJinete(partida);
            botonComprarJinete.setOnAction(eventoComprarJinete);

            Button botonComprarCurandero = new Button();
            VistaBotonComprarCurandero vistaBotonComprarCurandero = new VistaBotonComprarCurandero(botonComprarCurandero);
            HandlerBotonComprarCurandero eventoComprarCurandero = new HandlerBotonComprarCurandero(partida);
            botonComprarCurandero.setOnAction(eventoComprarCurandero);

            Button botonComprarCatapulta = new Button();
            VistaBotonComprarCatapulta vistaBotonComprarCatapulta = new VistaBotonComprarCatapulta(botonComprarCatapulta);
            HandlerBotonComprarCatapulta eventoComprarCatapulta = new HandlerBotonComprarCatapulta(partida);
            botonComprarCatapulta.setOnAction(eventoComprarCatapulta);

            VBox contenedorVacio = new VBox();

            this.getChildren().addAll(contenedorVacio,botonComprarSoldado,botonComprarJinete,botonComprarCurandero,botonComprarCatapulta);

        }

        @Override
        public void change(){
                this.getChildren().clear();
                this.avanzar();
        }

        private void avanzar(){
            Button botonJugar = new Button();
            VistaBotonJugar vistaBotonJugar = new VistaBotonJugar(botonJugar);
            //Falta un handler
            this.getChildren().addAll(botonJugar);
        }
}
