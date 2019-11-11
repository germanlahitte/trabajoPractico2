package algoChess.Armas;

import algoChess.FactoryConstantes;

public class ArmaSoldado extends Arma {

    public ArmaSoldado() {
        super(FactoryConstantes.armaSoldado(), Rango.cercano());
    }
}
