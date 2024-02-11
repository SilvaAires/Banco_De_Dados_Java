/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabd;

import sistemaBD.Controle.ProdutoControle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import sistemaBD.Modelo.Produto;

/**
 *
 * @author dboemo
 */
public class sistemaBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Produto produto = new Produto();
//        produto.setNome("Porcelanato 1X1");
//        produto.setValor(100);
        ProdutoControle prodC = new ProdutoControle();
//        System.out.println(prodC.incluiProduto(produto));
//        produto.setNome("milheiro de tijolo");
//        produto.setValor(800);
//        System.out.println(prodC.incluiProduto(produto));
        for (Produto prod:prodC.ListarProdutos()){
            System.out.println("Código "+prod.getCodigo());
            System.out.println("Nome "+prod.getNome());
            System.out.println("Valor "+prod.getValor());
        }
        
        
 
    } 
}
