package algoChess.Piezas;

import algoChess.Armas.*;
import algoChess.Ubicacion.*;
import algoChess.Equipos.*;

public abstract class Pieza { //TODO :falta

   private static int costo;
    private float vida;
    protected Equipo equipo;
//    protected Casillero ubicacion;
    protected Casillero casillero;
    protected Arma arma;

    public static int getCosto(){
        return Pieza.costo;
    }

    public Pieza(int costo, float vida, Equipo equipo){
        this.costo = costo;
        this.vida = vida;
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

// No usamos este metodo
    public int distanciaA(Casillero unCasillero){
       return unCasillero.distanciaA(casillero);
    }


    public void mover(Casillero destino){
       destino.agregarPieza(this);
    }

   /* protected void atacar(Pieza objetivo){
        objetivo.atacadaDesde(this.ubicacion, this.arma);
    }*/
   protected abstract void  atacar(Pieza objetivo);

   /*
    public void atacadaDesde(Casillero unCasillero, Arma unArma){
       quitarVida(unArma.atacarA(this, unCasillero.distanciaA(this.casillero)));
    }*/



    /*
    public void curadaDesde(Casillero unCasillero, Arma unArma){
        agregarVida(unArma.atacarA(this,unCasillero.distanciaA(this.casillero)));
    }*/

    protected void agregarVida(float vida){
        this.vida += vida;
    }
    protected Equipo getBando(){
        return this.equipo;
    }

    protected abstract void agregarArma(int danio,int danioADistancia);

    public abstract void puedoCurarme(Casillero ubicacion,Arma arma);




    //  Vida
    public void quitarVida(double danio){
        this.hacerseDanio(this.casillero.calcularDanio(equipo) * danio);
    }

    public void hacerseDanio(double  danio){
        this.vida -= danio;
        if(this.vida < 0) {
            this.vida = 0;
        }
    }
    public float vida(){
        return vida;
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


