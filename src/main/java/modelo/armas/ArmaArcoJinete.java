package modelo.armas;

import modelo.ProveedorConstantes;

public class ArmaArcoJinete extends Arma {

    public ArmaArcoJinete() {
        super(ProveedorConstantes.armaArcoJinete(), Rango.mediano());
    }

    @Override
    public String getNombre() {
        return ProveedorConstantes.nombreArmaJineteLejano();
    }
}
