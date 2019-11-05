package excepciones;

public class NoAlcanzanLasMonedasException extends RuntimeException {
    public NoAlcanzanLasMonedasException(String no_alcanzan_las_monedas_para_realizar_la_compra){
        super(no_alcanzan_las_monedas_para_realizar_la_compra);
    }
}
