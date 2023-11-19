package Models.Reportes;

public class EmpleadoSalario {

    int persona_idpersona;
    int cargo_codcargo;
    int horastrabajadas;
    int empleado_persona_idpersona;
    int salario;

    public EmpleadoSalario(int persona_idpersona, int cargo_codcargo, int horastrabajadas, int empleado_persona_idpersona, int salario) {
        this.persona_idpersona = persona_idpersona;
        this.cargo_codcargo = cargo_codcargo;
        this.horastrabajadas = horastrabajadas;
        this.empleado_persona_idpersona = empleado_persona_idpersona;
        this.salario = salario;
    }

    public int getPersona_idpersona() {
        return persona_idpersona;
    }

    public void setPersona_idpersona(int persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }

    public int getCargo_codcargo() {
        return cargo_codcargo;
    }

    public void setCargo_codcargo(int cargo_codcargo) {
        this.cargo_codcargo = cargo_codcargo;
    }

    public int getHorastrabajadas() {
        return horastrabajadas;
    }

    public void setHorastrabajadas(int horastrabajadas) {
        this.horastrabajadas = horastrabajadas;
    }

    public int getEmpleado_persona_idpersona() {
        return empleado_persona_idpersona;
    }

    public void setEmpleado_persona_idpersona(int empleado_persona_idpersona) {
        this.empleado_persona_idpersona = empleado_persona_idpersona;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "EmpleadoSalario{" +
                "persona_idpersona=" + persona_idpersona +
                ", cargo_codcargo=" + cargo_codcargo +
                ", horastrabajadas=" + horastrabajadas +
                ", empleado_persona_idpersona=" + empleado_persona_idpersona +
                ", salario=" + salario +
                '}';
    }
}
