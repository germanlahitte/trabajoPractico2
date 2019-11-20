package algochess.Piezas;

import algochess.Armas.*;
import algochess.Ubicacion.*;
import algochess.Equipos.*;

public abstract class Pieza {

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
        if(!pieza.soyAliado(this.equipo))
            pieza.atacadaDesde(this.casillero,this.arma);
    }

    //  Vida
    public float vida(){
        return this.vida.vida();
    }
    public void quitarVida(double danio){
        this.hacerseDanio(this.casillero.calcularDanio(equipo) * danio);
    }
    public void hacerseDanio(double  danio){
        this.vida.restarVida(danio);
        }
    public void curarse(float vida){
        this.vida.curarVida(vida);
    }


    public void desocuparCasillero(){ this.casillero.desocupar(); }

    // Ocupa casillero
    public void ocuparCasillero(Casillero casillero){
        if(this.casillero!=null)
            this.desocuparCasillero();
        asignarCasillero(casillero);
    }

    public void asignarCasillero(Casillero casillero){
        this.casillero = casillero;
    }

    // Posicion para tests
    public Posicion posicion(){
        return this.casillero.posicion();
    }

    // Implementar o lanzar NoSoyUnSoldadoExcepcion
    public void enlistarse(Equipo equipoDeUnSoldado, Soldado capitan) { }

    public void enlistar(Pieza pieza) { }

    public Casillero casillero() { return this.casillero; }

    public boolean soyAliado(Equipo equipo) {return equipo.soyAliado(this.equipo);}

    public void escoltar(Jinete unJinete) { }
}


