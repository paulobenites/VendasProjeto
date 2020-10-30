/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class testaConexao {
    public static void main(String[] args) {
        try {
            new conectionFactory().getConnetion();
            JOptionPane.showMessageDialog(null,"Conectado com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"Ops"+ erro);
        }
    }
    
}
