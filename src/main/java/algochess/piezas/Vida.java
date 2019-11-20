package algochess.piezas;

public class Vida {

    protected float vida;
    private float vidaMaxima;

    Vida(float vida) {
        this.vidaMaxima = vida;
        this.vida = vida;
    }

    void restarVida(double vida){
        this.vida -= vida;
        if(this.vida < 0) {
            this.vida = 0;
        }
    }

    void curarVida(double vida){
        if(this.vida == 0) {  return;    }
        this.vida += vida;
        if(this.vida > this.vidaMaxima) {
            this.vida = this.vidaMaxima;
        }
    }

    public float vida(){
        return this.vida;
    }
}
