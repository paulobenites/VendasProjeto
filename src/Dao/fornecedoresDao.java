/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Jdbc.conectionFactory;
import Model.fornecedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class fornecedoresDao {
    
    private Connection con;

    public fornecedoresDao() {
        this.con = new conectionFactory().getConnetion();
    }
    
    public void cadastrarFornecedores(fornecedores obj) {
        try {
            String sql = "insert into tb_fornecedores(nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?) ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());

            stmt.execute();
            stmt.close();

            JOptionPane.showInputDialog(null, "Cadastro com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showInputDialog(null, "Erro!" + erro);
        }
    }
}
