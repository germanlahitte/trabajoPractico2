package algochess.UbicacionTest;

import algochess.ubicacion.Direccion;
import algochess.ubicacion.Posicion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DireccionTest {

    @Test
     void testDireccionDevuelveDireccionNorte() {
        Direccion norte = Direccion.norte();
        assertEquals(norte.getHorizontal(), 0);
        assertEquals(norte.getVertical(), 1);
    }

    @Test
     void direccionDevuelveDireccionSur() {
        Direccion norte = Direccion.sur();
        assertEquals(norte.getHorizontal(), 0);
        assertEquals(norte.getVertical(), -1);
    }

    @Test
     void direccionDevuelveDireccionEste() {
        Direccion norte = Direccion.este();
        assertEquals(norte.getHorizontal(), 1);
        assertEquals(norte.getVertical(), 0);
    }
    @Test
     void direccionDevuelveDireccionOeste() {
        Direccion norte = Direccion.oeste();
        assertEquals(norte.getHorizontal(), -1);
        assertEquals(norte.getVertical(), 0);
    }

    @Test
     void direccionDevuelveDireccionNoreste() {
        Direccion norte = Direccion.norEste();
        assertEquals(norte.getHorizontal(), 1);
        assertEquals(norte.getVertical(), 1);
    }

    @Test
     void direccionDevuelveDireccionNoroeste() {
        Direccion norte = Direccion.norOeste();
        assertEquals(norte.getHorizontal(), -1);
        assertEquals(norte.getVertical(), 1);
    }

    @Test
     void direccionDevuelveDireccionSureste() {
        Direccion norte = Direccion.surEste();
        assertEquals(norte.getHorizontal(), 1);
        assertEquals(norte.getVertical(), -1);
    }

    @Test
     void direccionDevuelveDireccionSuroeste() {
        Direccion norte = Direccion.surOeste();
        assertEquals(norte.getHorizontal(), -1);
        assertEquals(norte.getVertical(), -1);
    }

    @Test
     void testProximaPosicionEnNorteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.norte().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
     void testProximaPosicionEnSurTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.sur().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
     void testProximaPosicionEnEsteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.este().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
     void testProximaPosicionEnOesteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.oeste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
     void testProximaPosicionEnNoresteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.norEste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
     void testProximaPosicionEnNoroesteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.norOeste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
     void testProximaPosicionEnSuroesteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.surOeste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
     void testProximaPosicionEnSuresteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.surEste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
     void testProximaPosicionEnNorteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.norte().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()+1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal());

    }

    @Test
     void testProximaPosicionEnSurDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.sur().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()-1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal());

    }

    @Test
     void testProximaPosicionEnEsteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.este().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical());
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()+1);

    }

    @Test
     void testProximaPosicionEnOesteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.oeste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical());
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()-1);
    }

    @Test
     void testProximaPosicionEnNoresteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.norEste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()+1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()+1);
    }

    @Test
     void testProximaPosicionEnNoroesteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.norOeste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()+1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()-1);
    }

    @Test
     void testProximaPosicionEnSuresteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.surEste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()-1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()+1);
    }

    @Test
     void testProximaPosicionEnSuroesteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.surOeste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()-1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()-1);
    }

}