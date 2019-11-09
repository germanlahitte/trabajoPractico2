package algoChess;
import algoChess.Equipos.Equipo;
import algoChess.Piezas.Catapulta;
import algoChess.Piezas.Curandero;
import algoChess.Piezas.Jinete;
import algoChess.Piezas.Soldado;
import excepciones.NoAlcanzanLasMonedasException;

public class Billetera {
    private int puntosDisponibles;

    public Billetera(int credito) {

        this.puntosDisponibles = credito;
    }

    public Soldado comprarSoldado(Equipo bando){
        int costoPieza = Soldado.getCosto();

        if(costoPieza > this.puntosDisponibles){
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }

        this.puntosDisponibles -= costoPieza;

        return new Soldado(bando);
    }

    public Jinete comprarJinete(Equipo bando){
        int costoPieza = Jinete.getCosto();

        if(costoPieza > this.puntosDisponibles){
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }

        this.puntosDisponibles -= costoPieza;

        return new Jinete(bando);
    }

    public Curandero comprarCurandero(Equipo bando){
        int costoPieza = Curandero.getCosto();

        if(costoPieza > this.puntosDisponibles){
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }

        this.puntosDisponibles -= costoPieza;

        return new Curandero(bando);
    }

    public Catapulta comprarCatapulta(Equipo bando){
        int costoPieza = Catapulta.getCosto();

        if(costoPieza > this.puntosDisponibles){
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }

        this.puntosDisponibles -= costoPieza;

        return new Catapulta(bando);
    }




}

