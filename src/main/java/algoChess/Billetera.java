package algoChess;
import excepciones.NoAlcanzanLasMonedasException;

public class Billetera {
    private int puntosDisponibles;

    public Billetera(int credito) {

        this.puntosDisponibles = credito;
    }
    //public Object comprar(Class pieza,  Equipo equipo) {
    //    Object piezaNueva = new Soldado(equipo);
        //int costoPieza = piezaNueva.getCosto();
        //if (costoPieza >= this.puntosDisponibles) {
        //} else {
        //    throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        //}
     //   return piezaNueva;

    public Soldado comprarSoldado(Equipo bando){
        int costoPieza = Soldado.getCosto();
        Soldado soldadoNuevo;
        if(costoPieza<=this.puntosDisponibles){
            soldadoNuevo = new Soldado(bando);
        }else{
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }
        return soldadoNuevo;
    }
    public Jinete comprarJinete(Equipo bando){
        int costoPieza = Jinete.getCosto();
        Jinete jineteNuevo;
        if(costoPieza<=this.puntosDisponibles){
            jineteNuevo = new Jinete(bando);
        }else{
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }
        return jineteNuevo;
    }

    public Curandero comprarCurandero(Equipo bando){
        int costoPieza = Curandero.getCosto();
        Curandero curanderoNuevo;
        if(costoPieza<=this.puntosDisponibles){
            curanderoNuevo = new Curandero(bando);
        }else{
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }
        return curanderoNuevo;
    }

    public Catapulta comprarCatapulta(Equipo bando){
        int costoPieza = Catapulta.getCosto();
        Catapulta catapultaNueva;
        if(costoPieza<=this.puntosDisponibles){
            catapultaNueva = new Catapulta(bando);
        }else{
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }
        return catapultaNueva;
    }




}

