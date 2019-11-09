package algoChess.Ubicacion;

import algoChess.Equipos.Equipo;
import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyDisponibilidad;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyLibre;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyOcupado;

public class Casillero { //TODO :falta  --- incompatibilidad posicion-casillero

    private Posicion posicion;
    private Equipo equipo;
    private StrategyDisponibilidad disponibilidad;
    private Pieza pieza;
    private Tablero tablero;

    public Casillero(Posicion posicion,Equipo equipo  ){
        this.posicion = posicion;
        this.equipo = equipo;
        this.desocupar();
    }

    public Casillero(Posicion posicion, Tablero tablero){
        this.tablero = tablero;
        this.posicion = posicion;
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

    //// Agregar Tablero, ver si se hace en el constructor
    public void agregarTablero(Tablero tablero){
        this.tablero = tablero;
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

}
