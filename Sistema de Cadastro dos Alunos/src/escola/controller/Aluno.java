/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.controller;

/**
 *
 * @author Dell
 */
public class Aluno {
    private int Id;
    private String nome;
    private String turma;
    private String curso;

    public Aluno(int Id, String nome, String turma, String curso) {
        this.Id = Id;
        this.nome = nome;
        this.turma = turma;
        this.curso = curso;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
    
}
