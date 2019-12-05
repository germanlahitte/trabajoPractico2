package modelo.piezas;

import excepciones.PiezaNoPuedeAtacar;
import modelo.armas.*;
import modelo.ubicacion.*;
import modelo.equipos.*;

import java.util.ArrayList;

public abstract class Pieza {

    protected Equipo equipo;
    protected Casillero casillero;
    protected Arma arma;
    private Vida vida;

    public Pieza(float vida, Equipo equipo) {
        this.vida = new Vida(vida);
        this.equipo = equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public abstract String getNombre();

    // Se ubica en el mapa
    public Pieza ubicarCon(Equipo equipo) {
        return this.equipo.ubicarCon(equipo, this);
    }

    // Arma
    void agregarArma(Arma arma) {
        this.arma = arma;
    }

    // Ataque
    public void atacadaDesde(Casillero casillero, Arma arma) {
        arma.atacarA(this, casillero.distanciaA(this.casillero));
    }

    public void atacar(Pieza pieza) {
        if (pieza.soyAliado(this.equipo)) {
            throw new PiezaNoPuedeAtacar("No puedes atacar aliados");
        } else {
            pieza.atacadaDesde(this.casillero, this.arma);
        }
    }

    //  Vida
    public float getVida() {
        return this.vida.vida();
    }

    public void quitarVida(double danio) {
        this.hacerseDanio(this.casillero.calcularDanio(equipo) * danio);
        if (this.getVida()==0) {
            this.desocuparCasillero();
        }
    }

    public void hacerseDanio(double danio) {
        this.vida.restarVida(danio);
    }

    public void curarse(float vida) {
        this.vida.curarVida(vida);
    }


    public void desocuparCasillero() {
        this.casillero.desocupar();
    }

    // Ocupa casillero
    public void ocuparCasillero(Casillero casillero) {
        if (this.casillero != null)
            this.desocuparCasillero();
        asignarCasillero(casillero);
    }

    public void asignarCasillero(Casillero casillero) {
        this.casillero = casillero;
    }

    // Posicion para tests
    public Posicion getPosicion() {
        return this.casillero.getPosicion();
    }

    // Implementar o lanzar NoSoyUnSoldadoExcepcion
    public void enlistarse(Equipo equipoDeUnSoldado, Soldado capitan) {
    }

    public void enlistar(Pieza pieza) {
    }

    public Casillero getCasillero() {
        return this.casillero;
    }

    void soyAliado(Equipo equipo, ArrayList<Pieza> aliadas, ArrayList<Pieza> enemigas) {
        equipo.soyAliado(this.equipo, aliadas, enemigas, this);
    }

    boolean soyAliado(Equipo equipo) {
        return equipo.soyAliado(this.equipo);
    }

    public void escoltar(Jinete unJinete) {
    }
}


