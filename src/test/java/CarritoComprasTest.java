import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarritoComprasTest {

    private CarritoCompras carrito;

    @BeforeEach
    void configurar(){
        carrito = new CarritoCompras();
    }

    /// El subtotal suma correctamente varios productos
    @Test
    @DisplayName("El subtotal de un carrito suma correctamente varios productos")
    void deberiaCalcularELsubtotalConVariosProductos(){
        carrito.agregarProductos(30.0, 2);
        carrito.agregarProductos(40.0, 1);
        double subtotal = carrito.calcularSubtotal();
        assertEquals(100.0, subtotal);
    }

    /// El subtotal de un carrito vacio es 0
    @Test
    @DisplayName("El subtotal de un carrito vacio es 0")
    void deberiaRetornarCeroCUandoElCarritEstaVacio(){
        double subtotal = carrito.calcularSubtotal();
        assertEquals(0.0, subtotal);
    }


}