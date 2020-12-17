/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Jdbc.conectionFactory;
import Model.produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class produtosDao {
     private Connection con;

    public produtosDao() {
        this.con = new conectionFactory().getConnetion();
    }
    public void cadastrar(produtos obj){
        try {
            String sql = "insert into tb_produtos(descricao,preco,qtd_estoque,for_id) values(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showInputDialog(null, "Cadastro com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showInputDialog(null, "Erro!" + erro);
        }
 
    
    }   
    
}
