package Models.Reportes;

public class ProveedorCompania {

    String nombreCompania;

    public ProveedorCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }
    @Override
    public String toString() {
        return "ProveedorComania{" + "nombreCompania=" + nombreCompania + '}';
    }

}

