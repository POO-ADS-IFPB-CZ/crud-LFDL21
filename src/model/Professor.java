package model;

import java.io.Serializable;
import java.util.Objects;

//Não esquecer de implementar Serializable
public class Professor implements Serializable {

    //Não esquecer da versão
    private static final long serialVersionUID = 1L;
    private String cpf;
    private String nome;
    private String formacao;

    public Professor(String cpf, String nome, String formacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.formacao = formacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", formacao='" + formacao + '\'' +
                '}';
    }

    //Não esquecer do equals e hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(cpf, professor.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
