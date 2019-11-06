package algoChess;

public class Catapulta extends Pieza {

    public Catapulta(Equipo equipo) {
        super(5, 50, equipo, 0, 20);
    }
    @Override
    protected void atacar(Pieza objetivo) {
        objetivo.atacadaDesde(this.ubicacion, this.arma);
    }
}
