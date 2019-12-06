package modelo;

public class ProveedorConstantes {

    private static int LADO_DEL_TABLERO = 20;
    private static int DESPLAZAMIENTO_MAXIMO = 1;

    private static int CREDITO_INICIAL = 20;

    private static int COSTO_SOLDADO = 1;
    private static int COSTO_JINETE = 3;
    private static int COSTO_CURANDERO = 2;
    private static int COSTO_CATAPULTA = 5;

    private static int DANIO_ARMA_SOLADO = 10;
    private static int DANIO_ARMA_JINETE_ESPADA = 5;
    private static int DANIO_ARMA_JINETE_ARCO = 15;
    private static int DANIO_ARMA_CATAPULTA = 20;
    private static int DANIO_ARMA_CURANDERO = 15;

    private static int VIDA_SOLDADO = 100;
    private static int VIDA_JINETE = 100;
    private static int VIDA_CATAPULTA = 50;
    private static int VIDA_CURANDERO = 75;
    private static int VIDA_ALAMBRADO = 0;

    private static String NOMBRE_EQUIPO_A = "Rojo";
    private static String NOMBRE_EQUIPO_B = "Azul";
    private static String ARMA_JINETE_LEJANO = "Arco y flecha";
    private static String ARMA_JINETE_CERCANO = "Espada";
    private static String ARMA_SOLDADO = "Espada";
    private static String ARMA_CATAPULTA = "Bola de fuego";
    private static String ARMA_CURANDERO = "Báculo";



    public static int ladoDelTablero() {
        return LADO_DEL_TABLERO;
    }

    public static int desplazamientoMaximo() {
        return DESPLAZAMIENTO_MAXIMO;
    }

    public static int armaSoldado() {
        return DANIO_ARMA_SOLADO;
    }

    public static int armaEspadaJinete() {
        return DANIO_ARMA_JINETE_ESPADA;
    }

    public static int armaArcoJinete() {
        return DANIO_ARMA_JINETE_ARCO;
    }

    public static int armaCatapulta() {
        return DANIO_ARMA_CATAPULTA;
    }

    public static int armaCurandero() {
        return DANIO_ARMA_CURANDERO;
    }

    public static int vidaSoldado() {
        return VIDA_SOLDADO;
    }

    public static int vidaJinete() {
        return VIDA_JINETE;
    }

    public static int vidaCatapulta() {
        return VIDA_CATAPULTA;
    }

    public static int vidaCurandero() {
        return VIDA_CURANDERO;
    }

    public static int vidaAlambrado() {
        return VIDA_ALAMBRADO;
    }

    public static int costoSoldado() {
        return COSTO_SOLDADO;
    }

    public static int costoJinete() {
        return COSTO_JINETE;
    }

    public static int costoCurandero() {
        return COSTO_CURANDERO;
    }

    public static int costoCatapulta() {
        return COSTO_CATAPULTA;
    }

    public static String nombreEquipoA() {
        return NOMBRE_EQUIPO_A;
    }

    public static String nombreEquipoB() {
        return NOMBRE_EQUIPO_B;
    }

    public static String nombreArmaJineteLejano() {
        return ARMA_JINETE_LEJANO;
    }

    public static String nombreArmaJineteCercano() {
        return ARMA_JINETE_CERCANO;
    }

    public static String nombreArmaSoldado() {
        return ARMA_SOLDADO;
    }

    public static String nombreArmaCatapulta() {
        return ARMA_CATAPULTA;
    }

    public static String nombreArmaCurandero() {
        return ARMA_CURANDERO;
    }

    public static int creditoInicial() {
        return CREDITO_INICIAL;
    }
}


