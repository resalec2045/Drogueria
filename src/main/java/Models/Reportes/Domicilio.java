package Models.Reportes;

public class Domicilio {

    private String coddomicilio;
    private String horaenvio;
    private String direccion;
    private String fechafacturacion;
    private String total;

    public Domicilio(String coddomicilio, String horaenvio, String direccion, String fechafacturacion, String total) {
        this.coddomicilio = coddomicilio;
        this.horaenvio = horaenvio;
        this.direccion = direccion;
        this.fechafacturacion = fechafacturacion;
        this.total = total;
    }

    public String getCoddomicilio() {
        return coddomicilio;
    }

    public void setCoddomicilio(String coddomicilio) {
        this.coddomicilio = coddomicilio;
    }

    public String getHoraenvio() {
        return horaenvio;
    }

    public void setHoraenvio(String horaenvio) {
        this.horaenvio = horaenvio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechafacturacion() {
        return fechafacturacion;
    }

    public void setFechafacturacion(String fechafacturacion) {
        this.fechafacturacion = fechafacturacion;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "coddomicilio=" + coddomicilio + ", horaenvio=" + horaenvio + ", direccion=" + direccion + ", fechafacturacion=" + fechafacturacion + ", total=" + total + '}';
    }

}
