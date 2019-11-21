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

        ArrayList<Pieza> piezasVecinasAliadas = new ArrayList<>();
        ArrayList<Pieza> piezasVecinasEnemigas = new ArrayList<>();
        this.filtrarVecinos(piezasVecinasAliadas,piezasVecinasEnemigas);

        if ((piezasVecinasAliadas.size() == 0) && (piezasVecinasEnemigas.size() > 0))
            this.equiparEspada();
        else {
            for (Pieza aliada : piezasVecinasAliadas) {
                aliada.escoltar(this);
            }
        }
    }

    private void filtrarVecinos(ArrayList<Pieza> aliadas,ArrayList<Pieza> enemigas){
        ArrayList<Pieza> vecinas = this.casillero.piezasVecinas();

        for(Pieza pieza:vecinas){
            if(pieza.soyAliado(this.equipo)){
                aliadas.add(pieza);
            } else {
                enemigas.add(pieza);
            }
        }
    }
}
