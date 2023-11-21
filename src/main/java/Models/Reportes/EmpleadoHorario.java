package Models.Reportes;

public class EmpleadoHorario {

    private String nombre;
    private String tipohorario;

    public EmpleadoHorario(String nombre, String tipohorario) {
        this.nombre = nombre;
        this.tipohorario = tipohorario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipohorario() {
        return tipohorario;
    }

    public void setTipohorario(String tipohorario) {
        this.tipohorario = tipohorario;
    }

    @Override
    public String toString() {
        return "EmpleadoHorario{" + "nombre=" + nombre + ", tipohorario=" + tipohorario + '}';
    }

}
