package Models.Reportes;

public class VentasMes {

    String mes;
    String totalVentas;

    public VentasMes(String mes, String totalVentas) {
        this.mes = mes;
        this.totalVentas = totalVentas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(String totalVentas) {
        this.totalVentas = totalVentas;
    }

    @Override
    public String toString() {
        return "VentasMes{" +
                "mes='" + mes + '\'' +
                ", totalVentas='" + totalVentas + '\'' +
                '}';
    }
}
