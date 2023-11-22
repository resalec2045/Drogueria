package Models.Reportes;

public class ClienteCompra {

    private String persona_idpersona;
    private String nombre;
    private String total_compras;
    private String producto_nombre;

    public ClienteCompra(String persona_idpersona, String nombre, String total_compras, String producto_nombre) {
        this.persona_idpersona = persona_idpersona;
        this.nombre = nombre;
        this.total_compras = total_compras;
        this.producto_nombre = producto_nombre;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public String getPersona_idpersona() {
        return persona_idpersona;
    }

    public void setPersona_idpersona(String persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTotal_compras() {
        return total_compras;
    }

    public void setTotal_compras(String total_compras) {
        this.total_compras = total_compras;
    }

    @Override
    public String toString() {
        return "ClienteCompras{" + "persona_idpersona=" + persona_idpersona + ", nombre=" + nombre + ", total_compras=" + total_compras + '}';
    }

}
