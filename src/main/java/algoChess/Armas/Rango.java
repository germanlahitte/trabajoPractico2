package algoChess.Armas;

public class Rango {

    private static Rango cercano;
    private static Rango mediano;
    private static Rango lejano;


    static {
        cercano = new Rango(1, 2);
        mediano = new Rango(3, 5);
        lejano = new Rango(6, 20);

    }

    private int minimo;
    private int maximo;

    private Rango(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public static Rango cercano() {
        return cercano;
    }

    public static Rango mediano() {
        return mediano;
    }

    public static Rango lejano() {
        return lejano;
    }


    public boolean enRango(int distancia){
        return (this.minimo <= distancia && distancia <= this.maximo);
    }
}
