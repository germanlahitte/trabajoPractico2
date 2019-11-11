package algoChess.Armas;

public class ArmaEspadaJinete extends Arma {

    private static int danio = 5;

    public ArmaEspadaJinete() {
        super(danio, Rango.cercano());
    }
}
