package algochess.Armas;

import algochess.FactoryConstantes;

public class ArmaSoldado extends Arma {

    public ArmaSoldado() {
        super(FactoryConstantes.armaSoldado(), Rango.cercano());
    }
}
