package SistemaBD_Consultorio.Modelo;

public class Consulta {
    private int id;
    private Medico medico;
    private Paciente paciente;
    private Anamnese anamnese;
    private CID cid;

    public Consulta() {
    }

    public Consulta(int id, Medico medico, Paciente paciente, Anamnese anamnese, CID cid) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.anamnese = anamnese;
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }

    public CID getCid() {
        return cid;
    }

    public void setCid(CID cid) {
        this.cid = cid;
    }

    public String toString() {
        return "id: " + this.id + " medico: " + this.medico + " paciente: " + this.paciente + 
                " anamnese: " + this.anamnese + " cid: " + this.cid ;
    }
}
