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

    public Pieza(int costo, float vida, Equipo equipo,int danio,int danioADistacia){
        this.costo = costo;
        this.vida = vida;
        this.equipo = equipo;
        this.arma = new Arma(danio,danioADistacia);
    }

    protected void ocupar(Casillero esteCasillero){
        this.ubicacion = esteCasillero;
    }

    protected void desocupar(){
        this.ubicacion.desocupar();
    }

    protected int distanciaA(Casillero unCasillero){
       return unCasillero.distancia(ubicacion);
    }

    protected void mover(Casillero destino){
       destino.agregarPieza(this);
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

        if(this.vida < danio) {
            this.vida = 0;
        } else {
            this.vida -= danio;
        };
    }


}
