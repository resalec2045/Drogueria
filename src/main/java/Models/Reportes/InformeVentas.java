package Models.Reportes;

public class InformeVentas {

    int codproducto;
    String producto;
    String categoria;
    int cantidad_vendida;
    int total_venta;

    public InformeVentas(int codproducto, String producto, String categoria, int cantidad_vendida, int total_venta) {
        this.codproducto = codproducto;
        this.producto = producto;
        this.categoria = categoria;
        this.cantidad_vendida = cantidad_vendida;
        this.total_venta = total_venta;
    }

    public int getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(int codproducto) {
        this.codproducto = codproducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(int cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public int getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(int total_venta) {
        this.total_venta = total_venta;
    }

    @Override
    public String toString() {
        return "InformeVentas{" +
                "codproducto=" + codproducto +
                ", producto='" + producto + '\'' +
                ", categoria='" + categoria + '\'' +
                ", cantidad_vendida=" + cantidad_vendida +
                ", total_venta=" + total_venta +
                '}';
    }
}
