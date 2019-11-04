package algoChess;

import java.util.HashMap;
import java.util.Map;

public class Tablero {
   private Map<Posicion,Casillero> casilleros;

   public Tablero(){
       casilleros = new HashMap<Posicion, Casillero>();
       for(int x = 1;x <= 20;x++){
           for(int y = 1;y <= 20;y++){
               Posicion posicion = new Posicion(x,y);
               Casillero casillero = new Casillero(posicion);
               casilleros.put(posicion,casillero);
           }
       }
   }

    public int getCantidadDeCasilleros(){
      return casilleros.size();
    }
}
