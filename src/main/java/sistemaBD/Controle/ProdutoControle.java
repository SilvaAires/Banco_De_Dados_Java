/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBD.Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sistemaBD.Modelo.Produto;
import sistemabd.Conexao;

/**
 *
 * @author dboemo
 */
public class ProdutoControle {

    public String incluiProduto(Produto prod) {

        String retorno = "";
        String sql = "INSERT INTO \"Produto\"(nome, valor) VALUES (?, ?);";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, prod.getNome());
            ps.setDouble(2, prod.getValor());

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

    public String AlteraProduto(Produto prod) {

        String retorno = "";
        String sql = "UPDATE \"Produto\" SET nome=?, valor=?  WHERE codigo =?;";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, prod.getNome());
            ps.setDouble(2, prod.getValor());
            ps.setInt(3, prod.getCodigo());
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

    public List<Produto> ListarProdutos() {
        List<Produto> listap = new ArrayList<Produto>();
        String sql = "select * from \"Produto\"";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setCodigo(rs.getInt("codigo"));
                prod.setNome(rs.getString("nome"));
                prod.setValor(rs.getDouble("valor"));
                listap.add(prod);
            }

        } catch (Exception ex) {
            System.out.println("Erro "+ex.getMessage());
        }
        return listap;
    }
}
