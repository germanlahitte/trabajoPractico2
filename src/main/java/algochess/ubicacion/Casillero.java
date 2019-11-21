package algochess.ubicacion;

import algochess.equipos.Equipo;
import algochess.piezas.Batallon;
import algochess.piezas.Pieza;
import algochess.ubicacion.alcanzado.StrategyAlcanzado;
import algochess.ubicacion.alcanzado.StrategyNoQuemado;
import algochess.ubicacion.alcanzado.StrategyQuemado;
import algochess.ubicacion.ocupacion.StrategyDisponibilidad;
import algochess.ubicacion.ocupacion.StrategyLibre;
import algochess.ubicacion.ocupacion.StrategyOcupado;
import excepciones.CasilleroOcupadoException;

import java.util.ArrayList;

public class Casillero {

    private Posicion posicion;
    private Equipo equipo;
    private StrategyDisponibilidad disponibilidad;
    private StrategyAlcanzado alcanzado;
    private Pieza pieza;
    private Tablero tablero;

    public Casillero(Posicion posicion,Equipo equipo,Tablero tablero){
        this.tablero = tablero;
        this.posicion = posicion;
        this.equipo = equipo;
        this.noQuemado();
        this.desocupar();
    }

    public double calcularDanio(Equipo equipo){
        return this.equipo.atacar(equipo);
    }

    // Ubicar pieza en casillero, chequea equipos
    public void ubicar(Pieza pieza){
        this.agregarPieza(pieza.ubicarCon(this.equipo));
    }

    /// Agrega Pieza delega en strategyDisponibilidad
    public void agregarPieza(Pieza pieza){
        this.disponibilidad.agregarPieza(pieza,this);
    }

    // asigna pieza y desocupa
    public void asignarPieza(Pieza pieza){
        this.pieza = pieza;
        this.disponibilidad = new StrategyOcupado();
        this.pieza.ocuparCasillero(this);
    }

    public void desocupar(){
        this.pieza = null;
        this.disponibilidad = new StrategyLibre();
    }

    ///// Delegacion en posicion y direccion
    public Casillero siguiente(Direccion enDireccion){
        return this.tablero.casilleroEn(this.posicion.siguiente(enDireccion));
    }
    public int distanciaA(Casillero casillero){
       return casillero.distanciaA(this.posicion);
    }
    public int distanciaA(Posicion posicion){
        return posicion.distanciaA(this.posicion);
    }
    public Posicion posicion(){return this.posicion;}

    public void agregarPieza(Pieza soldado, Batallon batallon, Direccion direccion) {
        try {
            this.disponibilidad.agregarPieza(soldado, this);
        } catch (CasilleroOcupadoException ocupado) {
            batallon.moverOtra(this.pieza,soldado,direccion);
        }
    }

    public Pieza getPieza() { return this.pieza; }

    private ArrayList<Casillero> vecinos(){
        ArrayList<Casillero> vecinos = new ArrayList<>();
        ArrayList<Direccion> direcciones = new ArrayList<>();
        direcciones.add(Direccion.norte());
        direcciones.add(Direccion.sur());
        direcciones.add(Direccion.este());
        direcciones.add(Direccion.oeste());
        direcciones.add(Direccion.norEste());
        direcciones.add(Direccion.norOeste());
        direcciones.add(Direccion.surEste());
        direcciones.add(Direccion.surOeste());
        for(Direccion direccion:direcciones){
            vecinos.add(this.siguiente(direccion));
        }
        return vecinos;
    }

    public ArrayList<Pieza> piezasVecinas(){
        ArrayList<Casillero> vecinos = this.vecinos();
        ArrayList<Pieza> piezasVecinas = new ArrayList<>();
        for(Casillero vecino:vecinos)
            if (!(null == vecino.getPieza())) {
                piezasVecinas.add(vecino.getPieza());
            }
        return piezasVecinas;
    }

    private ArrayList<Casillero> casillerosVecinosOcupados(){
        ArrayList<Pieza> piezasVecinas = this.piezasVecinas();
        ArrayList<Casillero> casillerosVecinos = new ArrayList<>();
        for(Pieza pieza:piezasVecinas){
            casillerosVecinos.add(pieza.casillero());
        }
        return casillerosVecinos;
    }

    public void bombardeo(int danio) {
        this.alcanzado.quemar(danio,this);
    }

    public void quemar(int danio) {
        this.disponibilidad.quemar(danio,this);
    }

    public void propagar(int danio) {
        this.quemado();
        ArrayList<Casillero> vecinos = this.casillerosVecinosOcupados();
        for(Casillero vecino:vecinos){
            vecino.bombardeo(danio);
        }
    }

    public void altoElFuego() {
       this.tablero.altoElFuego();
    }

    public void noQuemado() {
        this.alcanzado = new StrategyNoQuemado();
    }

    public void quemado(){
        this.alcanzado = new StrategyQuemado();
    }
}
