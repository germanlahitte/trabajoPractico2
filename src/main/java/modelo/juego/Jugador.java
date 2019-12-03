package modelo.juego;

import modelo.equipos.Equipo;
import modelo.piezas.*;

import java.util.ArrayList;

public class Jugador {
    private static int credito = 20;
    private String nombre;
    private Equipo bando;
    private Billetera billetera;
    private ArrayList<Pieza> piezas;


    public Jugador(String nombre, Equipo bando) {
        this.nombre = nombre;
        this.bando = bando;
        this.billetera = new Billetera(credito);
        this.piezas = new ArrayList<>();

    }

    public Equipo getEquipo() {
        return this.bando;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCredito() {
        return this.billetera.getPuntosDisponibles();
    }

    public void agregarPieza(Pieza pieza){
        piezas.add(pieza);
    }

    public Pieza comprarSoldado()  {
        Soldado soldadoNuevo = this.billetera.comprarSoldado(this.bando);
        this.agregarPieza(soldadoNuevo);
        return soldadoNuevo;
    }

    public Pieza comprarJinete() {
        Jinete jineteNuevo = this.billetera.comprarJinete(this.bando);
        this.agregarPieza(jineteNuevo);
        return jineteNuevo;
    }

    public Pieza comprarCatapulta() {
        Catapulta catapultaNueva = this.billetera.comprarCatapulta(this.bando);
        this.agregarPieza(catapultaNueva);
        return catapultaNueva;
    }
    public Pieza comprarCurandero() {
       Curandero curanderoNuevo = this.billetera.comprarCurandero(this.bando);
       this.agregarPieza(curanderoNuevo);
       return curanderoNuevo;
    }

    //metodo usado para test
    public int getCantidadDePiezas() {
        return this.piezas.size();
    }

    //Si un jugador se quedo sin piezas es perdedor
    public boolean esPerdedor(){
        piezas.removeIf(pieza -> pieza.vida() == 0);
        return (piezas.size() ==0);
    }

    public boolean tieneSaldo() {
       return (this.billetera.tieneSaldo());
    }

    public void comprar(Tienda tienda) {
        /*Acá pasa algo*/

        tienda.venta();
    }
}
