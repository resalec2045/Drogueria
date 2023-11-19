package Models.Reportes;

public class InformeTrabajoEmpleados {

    int persona_idpersona;
    String nombre_empleado;
    int horas_trabajadas;

    public InformeTrabajoEmpleados(int persona_idpersona, String nombre_empleado, int horas_trabajadas) {
        this.persona_idpersona = persona_idpersona;
        this.nombre_empleado = nombre_empleado;
        this.horas_trabajadas = horas_trabajadas;
    }

    public int getPersona_idpersona() {
        return persona_idpersona;
    }

    public void setPersona_idpersona(int persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public int getHoras_trabajadas() {
        return horas_trabajadas;
    }

    public void setHoras_trabajadas(int horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }

    @Override
    public String toString() {
        return "InformeTrabajoEmpleados{" +
                "persona_idpersona=" + persona_idpersona +
                ", nombre_empleado='" + nombre_empleado + '\'' +
                ", horas_trabajadas=" + horas_trabajadas +
                '}';
    }
}
