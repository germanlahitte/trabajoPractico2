package algoChess;
import excepciones.NoAlcanzanLasMonedasException;

public class Billetera {
    private int puntosDisponibles;

    public Billetera(int credito) {

        this.puntosDisponibles = credito;
    }

    public Object comprar(Class pieza,  Equipo equipo) {
        Object piezaNueva = new Soldado(equipo);
        //int costoPieza = piezaNueva.getCosto();
        //if (costoPieza >= this.puntosDisponibles) {
        //} else {
        //    throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        //}
        return piezaNueva;

    }

}

