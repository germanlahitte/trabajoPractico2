package algoChess.UbicacionTest;

import algoChess.Ubicacion.Direccion;
import algoChess.Ubicacion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DireccionTest {



    @Test
    public void testDireccionDevuelveDireccionNorte() {

        Direccion norte = Direccion.norte();
        assertEquals(norte.getHorizontal(), 0);
        assertEquals(norte.getVertical(), 1);
    }

    @Test
    public void direccionDevuelveDireccionSur() {

        Direccion norte = Direccion.sur();
        assertEquals(norte.getHorizontal(), 0);
        assertEquals(norte.getVertical(), -1);
    }

    @Test
    public void direccionDevuelveDireccionEste() {

        Direccion norte = Direccion.este();
        assertEquals(norte.getHorizontal(), 1);
        assertEquals(norte.getVertical(), 0);
    }
    @Test
    public void direccionDevuelveDireccionOeste() {

        Direccion norte = Direccion.oeste();
        assertEquals(norte.getHorizontal(), -1);
        assertEquals(norte.getVertical(), 0);
    }

    @Test
    public void direccionDevuelveDireccionNoreste() {

        Direccion norte = Direccion.norEste();
        assertEquals(norte.getHorizontal(), 1);
        assertEquals(norte.getVertical(), 1);
    }

    @Test
    public void direccionDevuelveDireccionNoroeste() {

        Direccion norte = Direccion.norOeste();
        assertEquals(norte.getHorizontal(), -1);
        assertEquals(norte.getVertical(), 1);
    }

    @Test
    public void direccionDevuelveDireccionSureste() {

        Direccion norte = Direccion.surEste();
        assertEquals(norte.getHorizontal(), 1);
        assertEquals(norte.getVertical(), -1);
    }

    @Test
    public void direccionDevuelveDireccionSuroeste() {

        Direccion norte = Direccion.surOeste();
        assertEquals(norte.getHorizontal(), -1);
        assertEquals(norte.getVertical(), -1);
    }

    @Test
    public void testProximaPosicionEnNorteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.norte().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
    public void testProximaPosicionEnSurTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.sur().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
    public void testProximaPosicionEnEsteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.este().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
    public void testProximaPosicionEnOesteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.oeste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
    public void testProximaPosicionEnNoresteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.norEste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
    public void testProximaPosicionEnNoroesteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.norOeste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
    public void testProximaPosicionEnSuroesteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.surOeste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
    public void testProximaPosicionEnSuresteTieneDistanciaUnoALaPrimera() {
        Posicion posicion = new Posicion(1, 1);
        Posicion nuevaPosicion = Direccion.surEste().proximaPosicion(posicion);
        assertEquals(nuevaPosicion.distanciaA(posicion), 1);
    }

    @Test
    public void testProximaPosicionEnNorteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.norte().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()+1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal());

    }

    @Test
    public void testProximaPosicionEnSurDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.sur().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()-1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal());

    }

    @Test
    public void testProximaPosicionEnEsteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.este().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical());
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()+1);

    }

    @Test
    public void testProximaPosicionEnOesteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.oeste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical());
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()-1);
    }

    @Test
    public void testProximaPosicionEnNoresteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.norEste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()+1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()+1);
    }

    @Test
    public void testProximaPosicionEnNoroesteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.norOeste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()+1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()-1);
    }

    @Test
    public void testProximaPosicionEnSuresteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.surEste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()-1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()+1);
    }

    @Test
    public void testProximaPosicionEnSuroesteDevuelvePosicionCorrecta() {
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionNorte = Direccion.surOeste().proximaPosicion(posicion);
        assertEquals(posicionNorte.getVertical(),posicion.getVertical()-1);
        assertEquals(posicionNorte.getHorizontal(),posicion.getHorizontal()-1);
    }

}