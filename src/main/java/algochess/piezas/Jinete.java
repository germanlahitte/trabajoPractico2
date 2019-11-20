package algochess.piezas;

import algochess.armas.ArmaArcoJinete;
import algochess.armas.ArmaEspadaJinete;
import algochess.equipos.Equipo;
import algochess.ProveedorConstantes;
import algochess.ubicacion.Direccion;

import java.util.ArrayList;

public class Jinete extends Pieza implements Movible{

    public Jinete(Equipo equipo) {
        super(ProveedorConstantes.vidaJinete(), equipo);
        this.equiparArco();
    }

    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

    public void atacar(Pieza pieza) {
        this.equiparArma();
        super.atacar(pieza);
    }
    // Cambiar arma
    void equiparArco(){
        this.agregarArma(new ArmaArcoJinete());
    }

    private void equiparEspada(){
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
