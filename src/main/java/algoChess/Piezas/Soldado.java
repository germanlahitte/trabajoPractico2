package algoChess.Piezas;

import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.Equipo;

public class Soldado extends Pieza {
    private static int costo = 1;

    public Soldado(Equipo equipo) {

        super(1, 100, equipo);
        this.agregarArma(10,0);

    }
    public void atacar(Pieza objetivo){
        objetivo.atacadaDesde(this.ubicacion, this.arma);}
        @Override
    protected void agregarArma(int danio,int DanioADistancia){
        this.arma = new ArmaSoldado(danio,DanioADistancia);
        }
}
