/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.controller;

import escola.model.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class operacoes {
    
    public void CadastrarAluno(String nomeDoAluno, String TurmaDoAluno, String CursoDoAluno) throws SQLException {
        Connection conn;
        conn = new ConexaoMySQL().connectBD();
           
        String sql = "INSERT INTO alunos (Nome, turma, curso) VALUES (?, ?, ?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, nomeDoAluno);
		statement.setString(2, TurmaDoAluno);
		statement.setString(3, CursoDoAluno);
		statement.executeUpdate();
    }

    
    public List<Aluno> consultarTodos() throws SQLException {
        
       Connection conn;
       conn = new ConexaoMySQL().connectBD();
        
        String sql = "SELECT * FROM alunos order by Id ";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List alunos = new ArrayList<>();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("Nome");
			String turma = resultSet.getString("turma");
			String curso = resultSet.getString("curso");
			alunos.add(new Aluno(id, nome, turma, curso));
		}
		return alunos;
    }


     public void excluir(int id) throws SQLException {
        Connection conn;
        conn = new ConexaoMySQL().connectBD();
       
        String sql = "DELETE FROM alunos WHERE id = ?";
	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setInt(1, id);
	statement.executeUpdate();
    }

     public Aluno consultarPorId(int id) throws SQLException {
            Connection conn;
            conn = new ConexaoMySQL().connectBD();
            	String sql = "SELECT * FROM alunos WHERE id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			String nome = resultSet.getString("Nome");
			String turma = resultSet.getString("turma");
			String curso = resultSet.getString("curso");
			Aluno aluno = new Aluno(id, nome, turma, curso);
                        return aluno;
		}
                
                Aluno aluno = new Aluno(0, "Aluno não  encotrado", "", "");
                return aluno;
       
     }
	
}
