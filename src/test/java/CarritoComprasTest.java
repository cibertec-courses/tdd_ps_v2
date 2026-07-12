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

    /// EL total con 10% de descuento se calcula correctamente
    @Test
    @DisplayName("El total con 10% de descuento se calcula correctamente")
    void deberiaAplicarElDescuentoSobreElSubtotal(){
        carrito.agregarProductos(100.0, 2);
        double total = carrito.calcularTotalConDescuento(10);
        assertEquals(180.0, total);
    }

    /// EL carrito cuenta con la cantidad de items agregados
    @Test
    @DisplayName("El carrito cuenta con la cantidad de items agregados")
    void deberiaContarItemsAgregados(){
        carrito.agregarProductos(40.0, 1);
        carrito.agregarProductos(50.0, 2);
        carrito.agregarProductos(60.0, 3);

        int items = carrito.contarItems();

        assertEquals(3, items);

    }

}