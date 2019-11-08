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
        Jinete jineteNuevo;
        if(costoPieza<=this.puntosDisponibles){
            jineteNuevo = new Jinete(bando);
            this.puntosDisponibles -= costoPieza;
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
            this.puntosDisponibles -= costoPieza;
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
            this.puntosDisponibles -= costoPieza;
        }else{
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }
        return catapultaNueva;
    }




}

