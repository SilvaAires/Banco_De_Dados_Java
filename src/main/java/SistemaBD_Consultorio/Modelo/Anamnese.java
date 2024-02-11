package SistemaBD_Consultorio.Modelo;

public class Anamnese {
    private int id;
    private String descricao;

    public Anamnese() {
    }

    public Anamnese(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return "id: " + this.id + " descricao: " + this.descricao;
    }
    
}
