package algoChess.Piezas;

import algoChess.Armas.*;
import algoChess.Ubicacion.*;
import algoChess.Equipos.*;
import algoChess.Vida;

public abstract class Pieza { //TODO :falta

   private static int costo;
   private Vida vida;
    protected Equipo equipo;
//    protected Casillero ubicacion;
    protected Casillero casillero;
    protected Arma arma;

    public static int getCosto(){
        return Pieza.costo;
    }

    public Pieza(int costo, float vida, Equipo equipo){
        this.costo = costo;
        this.vida = new Vida(vida);
        this.equipo = equipo;
        //this.arma = new Arma(danio,danioADistacia);
       // this.arma = arma;
    }

    public Pieza(Casillero casillero){
        this.casillero = casillero;

    }
/*
    public boolean ubicar(Equipo bando){
       return this.equipo.ubicar(bando);
    }

    public void ocupar(Casillero esteCasillero){
        this.ubicacion = esteCasillero;
    }

    protected void desocupar(){
        this.ubicacion.desocupar();
    } */

   /* protected void atacar(Pieza objetivo){
        objetivo.atacadaDesde(this.ubicacion, this.arma);
    }*/


   /*
    public void atacadaDesde(Casillero unCasillero, Arma unArma){
       quitarVida(unArma.atacarA(this, unCasillero.distanciaA(this.casillero)));
    }*/



    /*
    public void curadaDesde(Casillero unCasillero, Arma unArma){
        agregarVida(unArma.atacarA(this,unCasillero.distanciaA(this.casillero)));
    }*/

    /*
    protected void agregarVida(float vida){
        this.vida += vida;
    }*/


    // No usamos este metodo
    public int distanciaA(Casillero unCasillero){
        return unCasillero.distanciaA(casillero);
    }


    public void mover(Casillero destino){
        destino.agregarPieza(this);
    }

    protected abstract void  atacar(Pieza objetivo);

    protected Equipo getBando(){
        return this.equipo;
    }


    public abstract void puedoCurarme(Casillero ubicacion,Arma arma);


    // Arma

    protected void agregarArma(Arma arma){
        this.arma=arma;
    }

    // Ataque

    public void atacadaDesde(Casillero casillero, Arma arma) {
        this.arma.atacarA(this, casillero.distanciaA(this.casillero));
    }

    //  Vida
    public void quitarVida(double danio){
        this.hacerseDanio(this.casillero.calcularDanio(equipo) * danio);
    }

    public void hacerseDanio(double  danio){
        this.vida.restarVida(danio);
        }

    public float vida(){
        return this.vida.vida();
    }

    public void curarse(float vida){

        this.vida.curarVida(vida);
    }


    // Desocupa casillero
    public void desocuparCasillero(){
        this.casillero.desocupado();
    }

    // Ocupa casillero
    public void ocuparCasillero(Casillero casillero){
        this.desocuparCasillero();
        this.casillero = casillero;
    }


    public void asignarCasillero(Casillero casillero){
        this.casillero = casillero;
    }


    // Posicion para tests

    public Posicion posicion(){
        return this.casillero.posicion();
    }

}


