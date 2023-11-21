package Models.Reportes;

public class ClienteCompra {

    private String persona_idpersona;
    private String nombre;
    private String total_compras;

    public ClienteCompra(String persona_idpersona, String nombre, String total_compras) {
        this.persona_idpersona = persona_idpersona;
        this.nombre = nombre;
        this.total_compras = total_compras;
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
