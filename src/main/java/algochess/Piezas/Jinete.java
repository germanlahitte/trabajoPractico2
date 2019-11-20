package algochess.Piezas;

import algochess.Armas.ArmaArcoJinete;
import algochess.Armas.ArmaEspadaJinete;
import algochess.Equipos.Equipo;
import algochess.FactoryConstantes;
import algochess.Ubicacion.Direccion;

import java.util.ArrayList;
import java.util.Iterator;

public class Jinete extends Pieza implements Movible{
    private static int costo = 3;

    public Jinete(Equipo equipo) {
        super(FactoryConstantes.vidaJinete(), equipo);
        this.equiparArco();
    }

    public static int getCosto() { return costo; }

    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

    public void atacar(Pieza pieza) {
        this.equiparArma();
        super.atacar(pieza);
    }
    // Cambiar arma
    public void equiparArco(){
        this.agregarArma(new ArmaArcoJinete());
    }

    public void equiparEspada(){
        this.agregarArma(new ArmaEspadaJinete());
    }

    private void equiparArma() {
        ArrayList<Pieza> piezasVecinas = this.casillero.piezasVecinas();
        ArrayList<Pieza> piezasVecinasAliadas = new ArrayList<>();
        ArrayList<Pieza> piezasVecinasEnemigas = new ArrayList<>();

        for(Pieza pieza:piezasVecinas){
            if(pieza.soyAliado(this.equipo)){
                piezasVecinasAliadas.add(pieza);
            } else {
                piezasVecinasEnemigas.add(pieza);
            }
        }

        if ((piezasVecinasAliadas.size() == 0) && (piezasVecinasEnemigas.size() > 0))
            this.equiparEspada();
        else {
            for (Pieza aliada : piezasVecinasAliadas) {
                aliada.escoltar(this);
            }
        }
    }
}
