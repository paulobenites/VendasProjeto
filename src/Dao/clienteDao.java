package Dao;

import Jdbc.conectionFactory;
import Model.cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class clienteDao {
    
    private Connection con;
    
    public clienteDao(){
    this.con = new conectionFactory().getConnetion();
    }
    
    public void cadastrarCliente(cliente obj){
        try {
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                                                 +"values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getName());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getUf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showInputDialog(null,"Cadastro com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showInputDialog(null,"Erro!"+erro);
        }
    }
    public void alterarCliente(){
    }
    public void excluirCliente(){
    }
}
