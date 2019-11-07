package algoChess.Ubicacion;

import algoChess.Equipos.Equipo;
import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyDisponibilidad;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyLibre;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyOcupado;

public class Casillero { //TODO :falta  --- incompatibilidad posicion-casillero

    private Posicion ubicacion;
    private Equipo bando;
    private StrategyDisponibilidad estado;
    private Pieza ocupante;

    public Casillero(Posicion ubicacion,Equipo bando){
        this.ubicacion = ubicacion;
        this.bando = bando;
        this.desocupar();
    }

    public void ubicar(Pieza estaPieza){
        if(estaPieza.ubicar(bando))
            this.estado.agregarPieza(estaPieza,this);
    }

    public void desocupar(){
        this.ocupante = null;
        this.estado = new StrategyLibre();
    }

    public void ocupar(Pieza aAsignar){
        this.ocupante = aAsignar;
        this.estado = new StrategyOcupado();
    }

    public Posicion siguiente(Direccion enUnaDireccion){
      return  ubicacion.siguiente(enUnaDireccion);
    }

    public void agregarPieza(Pieza aAgregar){
        this.estado.agregarPieza(aAgregar,this);
    }

    public void quitarPieza(){
        this.estado.quitarPieza(this);
    }

    public int distancia(Casillero otroCasillero){
       return otroCasillero.distanciaA(this.ubicacion);
    }

    private int distanciaA(Posicion unaPosicion){
        return unaPosicion.distanciaA(this.ubicacion);
    }

    //TODO
    public float calcularDanio(Equipo equipo){
        return equipo.bajoAtaque(this.bando);
    }

}
