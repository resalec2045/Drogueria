package Models.Reportes;

public class InventarioProducto {

    int codinventario;
    String nombreproducto;
    String fecha;
    String responsable;
    String nombre;
    int cantidad;

    public InventarioProducto(int codinventario, String nombreproducto, String fecha, String responsable, String nombre, int cantidad) {
        this.codinventario = codinventario;
        this.nombreproducto = nombreproducto;
        this.fecha = fecha;
        this.responsable = responsable;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getCodinventario() {
        return codinventario;
    }

    public void setCodinventario(int codinventario) {
        this.codinventario = codinventario;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "InventarioProducto{" +
                "codinventario=" + codinventario +
                ", nombreproducto='" + nombreproducto + '\'' +
                ", fecha='" + fecha + '\'' +
                ", responsable='" + responsable + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
