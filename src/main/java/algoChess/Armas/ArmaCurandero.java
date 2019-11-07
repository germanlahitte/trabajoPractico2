package algoChess.Armas;


import algoChess.Piezas.Pieza;

public class ArmaCurandero extends Arma {


    public ArmaCurandero() {
        super(15, Rango.cercano());
    }


    public void atacarA(Pieza unaPieza, int distancia) {

        if(rango.enRango(distancia)){
            unaPieza.curarse(this.danio);
        }
        unaPieza.curarse(0);
    }

}
