package Dao;

import Jdbc.conectionFactory;
import Model.cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class clienteDao {

    private Connection con;

    public clienteDao() {
        this.con = new conectionFactory().getConnetion();
    }

    public void cadastrarCliente(cliente obj) {
        try {
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            stmt.execute();
            stmt.close();

            JOptionPane.showInputDialog(null, "Cadastro com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showInputDialog(null, "Erro!" + erro);
        }
    }

    public void alterarCliente(cliente obj) {
        try {
            String sql = "update tb_clientes set nome =?,rg =?,cpf =?,email =?,telefone =?,celular =?,cep =?,endereco =?,numero =?,complemento =?,bairro =?,cidade =?,estado =? where id =?";
                   

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showInputDialog(null, "Alterado com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showInputDialog(null, "Erro!" + erro);
        }
    }

    public void excluirCliente(cliente obj) {
        try {
            String sql = "delete from tb_clientes where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
          
            stmt.execute();
            stmt.close();

            JOptionPane.showInputDialog(null, "Excluido com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showInputDialog(null, "Erro!" + erro);
        }
    }

    public List<cliente> listaClientes() {
        try {
            List<cliente> lista = new ArrayList<>();
            String sql = "Select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente obj = new cliente();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }
    //buscar cliente
    
    public List<cliente> buscarClientePorNome(String nome) {
        try {
            List<cliente> lista = new ArrayList<>();
            String sql = "Select * from tb_clientes where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                cliente obj = new cliente();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    public cliente buscaPorNome(String nome){
        try {
            String sql = "Select * from tb_clientes where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            cliente obj = new cliente();
            
            if(rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }
            return obj;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não Encontrado" );
            return null;
        }
    }
}
