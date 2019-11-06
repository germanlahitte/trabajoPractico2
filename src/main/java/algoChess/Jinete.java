package algoChess;

public class Jinete extends Pieza {

    public Jinete(Equipo equipo) {
        super(3, 100, equipo, 5, 15);
    }

    @Override
    protected void atacar(Pieza objetivo) {
        objetivo.atacadaDesde(this.ubicacion, this.arma);
    }
}
