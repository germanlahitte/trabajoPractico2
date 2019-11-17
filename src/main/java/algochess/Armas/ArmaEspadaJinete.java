package algochess.Armas;

import algochess.FactoryConstantes;

public class ArmaEspadaJinete extends Arma {

    public ArmaEspadaJinete() {
        super(FactoryConstantes.armaEspadaJinete(), Rango.cercano());
    }
}
