import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {

    private final List<Double> items = new ArrayList<>();

    public void agregarProductos(double precioUnitario, int cantidad){
        if(cantidad< 1 || precioUnitario < 0){
            throw new IllegalArgumentException("Cantidad o precio invalida");
        }
        items.add(precioUnitario * cantidad);
    }

    public double calcularSubtotal(){
        double subtotal=0;
        for (double item : items){
            subtotal += item;
        }
        return subtotal;
    }

    public double calcularTotalConDescuento(double porcentaje){
        double subtotal = calcularSubtotal();
        return subtotal - (subtotal * porcentaje) /100;
    }

    public int contarItems(){
        return items.size();

    }}
