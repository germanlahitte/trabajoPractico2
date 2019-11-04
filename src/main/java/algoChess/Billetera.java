package algoChess;
import excepciones.NoAlcanzanLasMonedasException;

public class Billetera {
    private int puntosDisponibles;

    public Billetera() {
        this.puntosDisponibles = 20;
    }
    public Object comprar(Class pieza, Equipo equipo) {
        int costoPieza;
        Object piezaNueva;
        piezaNueva = new Soldado(equipo);
   //     costoPieza = pieza.getCosto();
   //     if (costoPieza >= this.puntosDisponibles) {
   //       piezaNueva = pieza.getConstructor(Equipo.class).newInstance(equipo);
   //     } else {
   //         throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
   //     }
        return piezaNueva;

    }

}

