package algoChess.Piezas;

import algoChess.Armas.*;
import algoChess.Ubicacion.*;
import algoChess.Equipos.*;
import algoChess.Vida;

public abstract class Pieza { //TODO :falta

   private static int costo;
   private Vida vida;
   protected Equipo equipo;
   protected Casillero casillero;
   protected Arma arma;

    public Pieza(float vida, Equipo equipo){
        this.vida = new Vida(vida);
        this.equipo = equipo;
    }


    // Se ubica en el mapa
    public Pieza ubicarCon(Equipo equipo){
        return this.equipo.ubicarCon(equipo,this);
    }

    // Arma
    protected void agregarArma(Arma arma){
        this.arma=arma;
    }

    // Ataque
    public void atacadaDesde(Casillero casillero, Arma arma) {
        arma.atacarA(this, casillero.distanciaA(this.casillero));
    }
    public void atacar(Pieza pieza){
        pieza.atacadaDesde(this.casillero,this.arma);
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


