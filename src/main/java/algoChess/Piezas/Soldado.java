package algoChess.Piezas;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Direccion;

public class Soldado extends Pieza implements Movible{
    private static int costo = 1;

    public Soldado(Equipo equipo) {

        super(100, equipo);
        this.agregarArma(10,0);

    }

    public static int getCosto() {
        return costo;
    }

    @Override
    public void mover(Direccion direccion) {
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

    public void atacar(Pieza objetivo){
        objetivo.atacadaDesde(this.casillero, this.arma);}
        @Override
    protected void agregarArma(int danio,int DanioADistancia){
        this.arma = new ArmaSoldado(danio,DanioADistancia);
        }

    @Override
    public void puedoCurarme(Casillero ubicacion, Arma arma) {
        this.curadaDesde(ubicacion,arma);
    }

}
