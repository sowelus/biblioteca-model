/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sowelus.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author sowelus
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotBlank(message = "O sobrenome deve ser informado")
    @Length(max = 50, message = "O sobrenome não deve ter mais que {max} caracteres")
    @Column(name = "sobrenome", length = 50, nullable = false)    
    private String sobrenome;
    
    @NotBlank(message = "O e-mail deve ser informado")
    @Length(max = 50, message = "O e-mail não deve ter mais que {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)    
    private String email;
    
    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 15, message = "a senha não deve ter mais que {max} caracteres")
    @Column(name = "senha", length = 15, nullable = false)    
    private String senha;
    
    @ManyToMany
        @JoinTable(name = "usuarios_emprestimos",
            joinColumns = 
            @JoinColumn(name = "usuario", referencedColumnName = "codigo", 
                    nullable = false), 
             //referencia o lado da lista
            inverseJoinColumns = 
            @JoinColumn(name = "emprestimo", referencedColumnName = "codigo", 
                    nullable = false))
    private List<Emprestimo> usuariosEmprestimos = new ArrayList<>();
    

    public Usuario() {
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public List<Emprestimo> getUsuariosEmprestimos() {
        return usuariosEmprestimos;
    }

    public void setUsuariosEmprestimos(List<Emprestimo> usuariosEmprestimos) {
        this.usuariosEmprestimos = usuariosEmprestimos;
    }

   
    
    
    
    
    
}
