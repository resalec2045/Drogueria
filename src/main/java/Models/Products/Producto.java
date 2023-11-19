package Models.Products;

public class Producto {

    private Integer codproducto;
    private String nombre;
    private String descripcion;
    private Integer inventario;
    private Double precio;

    public Producto(Integer codproducto, String nombre, String descripcion, Integer inventario, Double precio) {
        this.codproducto = codproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inventario = inventario;
        this.precio = precio;
    }

    public Producto() {
    }

    public Integer getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(Integer codproducto) {
        this.codproducto = codproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
