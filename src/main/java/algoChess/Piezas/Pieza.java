package algoChess.Piezas;

import algoChess.Armas.*;
import algoChess.Ubicacion.*;
import algoChess.Equipos.*;

public abstract class Pieza { //TODO :falta

   private static int costo;
    private float vida;
    protected Equipo equipo;
    protected Casillero ubicacion;
    protected Arma arma;

    public static int getCosto(){
        return Pieza.costo;
    }

    public Pieza(int costo, float vida, Equipo equipo){
        this.costo = costo;
        this.vida = vida;
        this.equipo = equipo;
    }

    public boolean ubicar(Equipo bando){
       return this.equipo.ubicar(bando);
    }

    public void ocupar(Casillero esteCasillero){
        this.ubicacion = esteCasillero;
    }

    protected void desocupar(){
        this.ubicacion.desocupar();
    }

    public int distanciaA(Casillero unCasillero){
       return unCasillero.distancia(ubicacion);
    }

    public void mover(Casillero destino){
       destino.agregarPieza(this);
    }

   protected abstract void  atacar(Pieza objetivo);

    public void atacadaDesde(Casillero unCasillero, Arma unArma){
       quitarVida(unArma.atacar(this, unCasillero.distancia(this.ubicacion)));
    }

    public void quitarVida(float danio){
        this.hacerseDanio(this.ubicacion.calcularDanio(equipo) * danio);
    }

    public void hacerseDanio(float danio){
        if(this.vida < danio) {
            this.vida = 0;
        } else {
            this.vida -= danio;
        };
    }
    public float vidaRestante(){
        return vida;
    }

    public void curadaDesde(Casillero unCasillero, Arma unArma){
        agregarVida(unArma.atacar(this,unCasillero.distancia(this.ubicacion)));
    }
    protected void agregarVida(float vida){
        this.vida += vida;
    }

    protected Equipo getBando(){
        return this.equipo;
    }

    protected abstract void agregarArma(int danio,int danioADistancia);

}
