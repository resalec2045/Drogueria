package Models.turnos;

public class Turnos {

    int codturno;
    String tipohorario;
    int empleado_persona_idpersona;

    public Turnos(int codturno, String tipohorario, int empleado_persona_idpersona) {
        this.codturno = codturno;
        this.tipohorario = tipohorario;
        this.empleado_persona_idpersona = empleado_persona_idpersona;
    }

    public int getCodturno() {
        return codturno;
    }

    public void setCodturno(int codturno) {
        this.codturno = codturno;
    }

    public String getTipohorario() {
        return tipohorario;
    }

    public void setTipohorario(String tipohorario) {
        this.tipohorario = tipohorario;
    }

    public int getEmpleado_persona_idpersona() {
        return empleado_persona_idpersona;
    }

    public void setEmpleado_persona_idpersona(int empleado_persona_idpersona) {
        this.empleado_persona_idpersona = empleado_persona_idpersona;
    }

    @Override
    public String toString() {
        return "Turnos{" +
                "codturno=" + codturno +
                ", tipohorario='" + tipohorario + '\'' +
                ", empleado_persona_idpersona=" + empleado_persona_idpersona +
                '}';
    }
}
