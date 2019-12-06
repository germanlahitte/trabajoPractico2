package modelo.armas;

import modelo.ProveedorConstantes;

public class ArmaSoldado extends Arma {

    public ArmaSoldado() {
        super(ProveedorConstantes.armaSoldado(), Rango.cercano());
    }

    @Override
    public String getNombre() {
        return ProveedorConstantes.nombreArmaSoldado();
    }
}
