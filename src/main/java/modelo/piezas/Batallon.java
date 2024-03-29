package modelo.piezas;

import excepciones.BatallonSoldadosInsuficientes;
import modelo.ubicacion.Direccion;
import excepciones.CasilleroOcupadoException;

import java.util.ArrayList;

public class Batallon implements Movible {

    private Soldado capitan;
    private ArrayList<Soldado> tropa;
    private ArrayList<Pieza> yaMovieron;

    public Batallon(Soldado soldado){
        this.capitan = soldado;
        this.romperFilas();
    }

    public void enlistar(Soldado soldado){
        tropa.add(soldado);
    }

    public boolean pertenece(Pieza soldado) {
        return (tropa.contains(soldado));
    }

    public void mover(Direccion enDireccion){
        if(!enMarcha()) {
            throw new BatallonSoldadosInsuficientes();
        } else {
            this.moverRestantes(enDireccion);
        }
    }

    public void moverOtra(Pieza pieza, Pieza soldado, Direccion direccion) {
        if(!pertenece(pieza)) {
            throw new CasilleroOcupadoException("Casillero Ocupado");
        }
        ((Soldado) pieza).mover(direccion, this);
        ((Soldado) soldado).mover(direccion,this);
        yaMovieron.add(pieza);
    }

    private void moverRestantes(Direccion enDireccion){
        for(Pieza soldado:tropa){
            try {
                if(!yaMovieron.contains(soldado)) {
                    ((Soldado)soldado).mover(enDireccion,this);
                    yaMovieron.add(soldado);
                }
            } catch (CasilleroOcupadoException ocupado) {
                yaMovieron.add(soldado);
            }

        }
    }

    private boolean enMarcha(){
        tropa.removeIf(soldado -> capitan.getCasillero().distanciaA(soldado.getCasillero()) > 1);

        return (tropa.size() > 2);
    }

    private void romperFilas(){
        this.tropa = new ArrayList<>();
        enlistar(capitan);
        this.yaMovieron = new ArrayList<>();
    }
}
