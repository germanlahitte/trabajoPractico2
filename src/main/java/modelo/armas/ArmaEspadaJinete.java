package modelo.armas;

import modelo.ProveedorConstantes;

public class ArmaEspadaJinete extends Arma {

    public ArmaEspadaJinete() {
        super(ProveedorConstantes.armaEspadaJinete(), Rango.cercano());
    }

    @Override
    public String getNombre() {
        return ProveedorConstantes.nombreArmaJineteCercano();
    }
}
