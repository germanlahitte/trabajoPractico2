package algoChess.Piezas;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCurandero;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Direccion;

public class Curandero extends Pieza implements Movible {
    public Curandero(Equipo equipo) {
        super(2, 75, equipo);
        this.agregarArma(new ArmaCurandero());
    }


    /*
    @Override
    public void atacar(Pieza objetivo) {
       // this.puedeCurar(objetivo);
    }

     */

    /*
    @Override
    protected void agregarArma(int danio, int danioADistancia) {
        //this.arma = new ArmaCurandero(danio,danioADistancia);

    }
    */

    @Override
    public void puedoCurarme(Casillero ubicacion, Arma arma) {
    //this.curadaDesde(ubicacion,arma);
    }

    private void puedeCurar(Pieza objetivo){
        //if(objetivo.ubicar(this.getBando())){
        //objetivo.puedoCurarme(this.casillero,this.arma);
        //}
    }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

}

