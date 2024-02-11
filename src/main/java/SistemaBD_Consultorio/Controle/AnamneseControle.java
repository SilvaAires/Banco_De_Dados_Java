package SistemaBD_Consultorio.Controle;

import SistemaBD_Consultorio.Conexao;
import SistemaBD_Consultorio.Modelo.Anamnese;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnamneseControle {

    public String incluiProduto(Anamnese ana) {
        String retorno = "";
        String sql = "INSERT INTO \"Produto\"(nome, valor) VALUES (?, ?);";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, ana.getDescricao());
            ps.setDouble(2, ana.getId());

            if (ps.executeUpdate() > 0) {
                retorno = "Inclusão realizada ";
            } else {
                retorno = "Erro ao incluir";
            }
        } catch (Exception ex) {
            retorno = "Erro ao tentar incluir :" + ex.getMessage();
        }
        return retorno;
    }

    public String AlteraProduto(Anamnese prod) {

        String retorno = "";
        String sql = "UPDATE \"Produto\" SET nome=?, valor=?  WHERE codigo =?;";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, prod.getDescricao());
            ps.setInt(2, prod.getId());
            if (ps.executeUpdate() > 0) {
                retorno = "Alteração realizada ";
            } else {
                retorno = "Erro ao tentar alterar";
            }
        } catch (Exception ex) {
            retorno = "Erro Alteração " + ex.getMessage();

        }
        return retorno;
    }

    public String ExcluiProduto(int i) {

        String retorno = "";
        String sql = "delete from \"Produto\" where codigo=?";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setInt(1, i);
            if (ps.executeUpdate() > 0) {
                retorno = "Exclusão realizada ";
            } else {
                retorno = "Erro ao tentar excluir";
            }
        } catch (Exception ex) {
            retorno = "Erro Excluir " + ex.getMessage();

        }
        return retorno;
    }

    public List<Anamnese> ListarProdutos() {
        List<Anamnese> listap = new ArrayList<Anamnese>();
        String sql = "select * from \"Produto\"";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Anamnese ana = new Anamnese();
                ana.setId(rs.getInt("codigo"));
                ana.setDescricao(rs.getString("nome"));
                listap.add(ana);
            }

        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return listap;
    }
}
