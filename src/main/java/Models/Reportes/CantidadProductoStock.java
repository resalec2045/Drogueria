package Models.Reportes;

public class CantidadProductoStock {

    int codinventario;
    String producto;
    int cantidad_en_stock;

    public CantidadProductoStock(int codinventario, String producto, int cantidad_en_stock) {
        this.codinventario = codinventario;
        this.producto = producto;
        this.cantidad_en_stock = cantidad_en_stock;
    }

    public int getCodinventario() {
        return codinventario;
    }

    public void setCodinventario(int codinventario) {
        this.codinventario = codinventario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad_en_stock() {
        return cantidad_en_stock;
    }

    public void setCantidad_en_stock(int cantidad_en_stock) {
        this.cantidad_en_stock = cantidad_en_stock;
    }

    @Override
    public String toString() {
        return "CantidadProductoStock{" +
                "codinventario=" + codinventario +
                ", producto='" + producto + '\'' +
                ", cantidad_en_stock=" + cantidad_en_stock +
                '}';
    }
}
