package algochess.armas;

import algochess.ProveedorConstantes;

public class ArmaSoldado extends Arma {

    public ArmaSoldado() {
        super(ProveedorConstantes.armaSoldado(), Rango.cercano());
    }
}
