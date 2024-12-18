/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.controller;

import escola.model.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class Excluir {
    public void excluirAluno(int id) throws SQLException {
        Connection conn;
        conn = new ConexaoMySQL().connectBD();
       
        String sql = "DELETE FROM alunos WHERE id = ?";
	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setInt(1, id);
	statement.executeUpdate();
    }
}
