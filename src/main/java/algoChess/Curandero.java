package algoChess;

public class Curandero extends Pieza {
    public Curandero(Equipo equipo) {
        super(2, 75, equipo, 15, 0);
    }

    @Override
    public void atacar(Pieza objetivo) {
        this.puedeCurar(objetivo);
    }
    private void puedeCurar(Pieza objetivo){
        if(objetivo.getBando() == this.equipo && objetivo.getClass()!=Catapulta.class){
            objetivo.curadaDesde(this.ubicacion,this.arma);
        }

    }
}

