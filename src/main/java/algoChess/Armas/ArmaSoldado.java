package algoChess.Armas;

public class ArmaSoldado extends Arma {

    private static int danio = 10;

    public ArmaSoldado() {
        super(danio, Rango.cercano());
    }
}
