package algoChess;

public class Pieza { //TODO :falta

    private static int costo;
    private float vida;
    private Equipo equipo;
    private Casillero ubicacion;
    private Arma arma;

    public static int costo(){
        return Pieza.costo;
    }

    protected void ocupar(Casillero esteCasillero){
        this.ubicacion = esteCasillero;
    }

    protected void desocupar(){
        this.ubicacion.desocupar();
    }

    protected void atacar(Pieza objetivo){
        objetivo.atacadaDesde(this.ubicacion, this.arma);
    }

    protected void atacadaDesde(Casillero unCasillero, Arma unArma){
       quitarVida(unArma.atacar(this, unCasillero.distancia(this.ubicacion)));
    }

    protected void quitarVida(float danio){
        this.hacerseDanio(this.ubicacion.calcularDanio(equipo) * danio);
    }

    protected void hacerseDanio(float danio){
        this.vida -= danio;
    }
}
