package algoChess.Ubicacion;

import algoChess.Equipos.Equipo;
import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyDisponibilidad;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyLibre;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyOcupado;

public class Casillero { //TODO :falta  --- incompatibilidad posicion-casillero

    private Posicion posicion;
    private Equipo bando;
    private StrategyDisponibilidad disponibilidad;
    private Pieza pieza;

    public Casillero(Posicion posicion,Equipo bando){
        this.posicion = posicion;
        this.bando = bando;
        this.desocupar();
    }

    public void ubicar(Pieza estaPieza){
        if(estaPieza.ubicar(bando))
            this.disponibilidad.agregarPieza(estaPieza,this);
    }

    public void desocupar(){
        this.pieza = null;
        this.disponibilidad = new StrategyLibre();
    }

    public void ocupar(Pieza aAsignar){
        this.pieza = aAsignar;
        this.disponibilidad = new StrategyOcupado();
    }

    public Posicion siguiente(Direccion enUnaDireccion){
      return  posicion.siguiente(enUnaDireccion);
    }

    public void agregarPieza(Pieza aAgregar){
        this.disponibilidad.agregarPieza(aAgregar,this);
    }

    public void quitarPieza(){
        this.disponibilidad.quitarPieza(this);
    }

    public int distanciaA(Casillero casillero){
       return casillero.distanciaA(this.posicion);
    }

    public int distanciaA(Posicion posicion){
        return posicion.distanciaA(this.posicion);
    }

    //TODO
    public float calcularDanio(Equipo equipo){
        return equipo.bajoAtaque(this.bando);
    }

}
