package algoChess.Piezas;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Direccion;

public class Soldado extends Pieza implements Movible{
    private static int costo = 1;

    public Soldado(Equipo equipo) {

        super(1, 100, equipo);
        this.agregarArma(10,0);

    }
    public void atacar(Pieza objetivo){
        //objetivo.atacadaDesde(this.casillero, this.arma);
        }
        @Override
    protected void agregarArma(int danio,int DanioADistancia){
        this.arma = new ArmaSoldado();
        }

    @Override
    public void puedoCurarme(Casillero ubicacion, Arma arma) {
        //this.curadaDesde(ubicacion,arma);
    }


    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }
}
