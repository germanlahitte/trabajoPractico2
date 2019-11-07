package algoChess;

public class Vida {

    protected float vida;
    protected float vidaMaxima;

    public Vida(float vida) {
        this.vidaMaxima = vida;
        this.vida = vida;
    }

    public void restarVida(double vida){
        this.vida -= vida;
        if(this.vida < 0) {
            this.vida = 0;
        }
    }

    public void curarVida(double vida){
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
