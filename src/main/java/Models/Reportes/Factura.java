package Models.Reportes;

public class Factura {

    private String codFactura;
    private String fechaFacturacion;
    private String total;

    public Factura(String codFactura, String fechaFacturacion, String total) {
        this.codFactura = codFactura;
        this.fechaFacturacion = fechaFacturacion;
        this.total = total;
    }

    public String getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    public String getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(String fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    @Override
    public String toString() {
        return "Factura{" + "codFactura=" + codFactura + ", fechaFacturacion=" + fechaFacturacion + ", total=" + total + '}';
    }
}
