package algoChess;

public class Casillero { //TODO :falta

    private Posicion ubicacion;
    private Equipo bando;
    private Disponibilidad estado;
    private Pieza ocupante;

    public Casillero(Posicion ubicacion,Equipo bando){
        this.ubicacion = ubicacion;
        this.bando = bando;
        this.desocupar();
    }

    public void desocupar(){
        this.ocupante = null;
        this.estado = new Libre();
    }

    public void ocupar(Pieza aAsignar){
        this.ocupante = aAsignar;
        this.estado = new Ocupado();
    }

    public void agregarPieza(Pieza aAgregar){
        this.estado.agregarPieza(aAgregar,this);
    }

    public void quitarPieza(){
        this.estado.quitarPieza(this);
    }

    public int distancia(Casillero otroCasillero){
       return otroCasillero.distanciaA(this.ubicacion);
    }

    private int distanciaA(Posicion unaPosicion){
        return unaPosicion.distanciaA(this.ubicacion);
    }

    //TODO
    public float calcularDanio(Equipo equipo){
        float danio=0;
        return danio;
    }
}
