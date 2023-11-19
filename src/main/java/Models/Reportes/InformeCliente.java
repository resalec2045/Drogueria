package Models.Reportes;

public class InformeCliente {
    int persona_idpersona;
    String fecharegistro;
    String estado;
    String descripcion;

    public InformeCliente(int persona_idpersona, String fecharegistro, String estado, String descripcion) {
        this.persona_idpersona = persona_idpersona;
        this.fecharegistro = fecharegistro;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public int getPersona_idpersona() {
        return persona_idpersona;
    }

    public void setPersona_idpersona(int persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
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

    @Override
    public String toString() {
        return "InformeCliente{" +
                "persona_idpersona=" + persona_idpersona +
                ", fecharegistro='" + fecharegistro + '\'' +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
