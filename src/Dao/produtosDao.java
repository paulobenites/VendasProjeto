/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Jdbc.conectionFactory;
import Model.fornecedores;
import Model.produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public void alterar(produtos obj){
        try{
            String sql ="update tb_produtos set descricao=?,preco=?,qtd_estoque=?,for_id=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setInt(5, obj.getId());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto alterado com Sucesso!");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }
    public void excluir(produtos obj){
        try{
            String sql = "delete from tb_produtos where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto excluido com Sucesso!");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro" + erro );
        }
    }
    public List<produtos> listaProdutos() {
        try {
            List<produtos> lista = new ArrayList<>();
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                          +"inner join tb_fornecedores as f on (p.for_id = f.id)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos obj = new produtos();
                fornecedores f = new fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                f.setName(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }
}
