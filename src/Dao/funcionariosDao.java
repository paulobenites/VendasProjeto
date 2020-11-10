
package Dao;

import Jdbc.conectionFactory;
import Model.funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class funcionariosDao {
    
     private Connection con;

    public funcionariosDao() {
        this.con = new conectionFactory().getConnetion();
    }
    
    public void cadastrarFuncionarios(funcionarios obj) {
        try {
            String sql = "insert into tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            stmt.execute();
            stmt.close();

            JOptionPane.showInputDialog(null, "Cadastro com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showInputDialog(null, "Erro!" + erro);
        }
    }
    
}
