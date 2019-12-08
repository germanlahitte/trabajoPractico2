package modelo.juego;
import modelo.ProveedorConstantes;
import modelo.equipos.Equipo;
import modelo.piezas.*;

import excepciones.NoAlcanzanLasMonedasException;

public class Billetera {
    private int puntosDisponibles;

    public Billetera(int credito) {

        this.puntosDisponibles = credito;
    }

    public int getPuntosDisponibles() {
        return puntosDisponibles;
    }

    public boolean tieneSaldo() {
        return (this.puntosDisponibles>0);
    }

    public Soldado comprarSoldado(Equipo bando){
        int costoPieza = ProveedorConstantes.costoSoldado();

        if(costoPieza > this.puntosDisponibles){
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }

        this.puntosDisponibles -= costoPieza;

        return new Soldado(bando);
    }

    public Jinete comprarJinete(Equipo bando){
        int costoPieza = ProveedorConstantes.costoJinete();

        if(costoPieza > this.puntosDisponibles){
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }

        this.puntosDisponibles -= costoPieza;

        return new Jinete(bando);
    }

    public Curandero comprarCurandero(Equipo bando){
        int costoPieza = ProveedorConstantes.costoCurandero();

        if(costoPieza > this.puntosDisponibles){
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }

        this.puntosDisponibles -= costoPieza;

        return new Curandero(bando);
    }

    public Catapulta comprarCatapulta(Equipo bando){
        int costoPieza = ProveedorConstantes.costoCatapulta();

        if(costoPieza > this.puntosDisponibles){
            throw new NoAlcanzanLasMonedasException("No alcanzan las monedas para realizar la compra");
        }

        this.puntosDisponibles -= costoPieza;

        return new Catapulta(bando);
    }

}

