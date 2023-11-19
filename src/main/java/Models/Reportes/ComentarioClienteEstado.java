package Models.Reportes;

public class ComentarioClienteEstado {

    int codticket;
    String estado;
    String descripcion;
    String solucion;
    int id_cliente;
    String nombre_cliente;

    public ComentarioClienteEstado(int codticket, String estado, String descripcion, String solucion, int id_cliente, String nombre_cliente) {
        this.codticket = codticket;
        this.estado = estado;
        this.descripcion = descripcion;
        this.solucion = solucion;
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
    }

    public int getCodticket() {
        return codticket;
    }

    public void setCodticket(int codticket) {
        this.codticket = codticket;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    @Override
    public String toString() {
        return "ComentarioClienteEstado{" +
                "codticket=" + codticket +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", solucion='" + solucion + '\'' +
                ", id_cliente=" + id_cliente +
                ", nombre_cliente='" + nombre_cliente + '\'' +
                '}';
    }
}
