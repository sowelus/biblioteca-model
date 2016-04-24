
package br.sowelus.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "livro")
public class Livro extends Obra implements Serializable{
     
    @NotBlank(message = "A descricao deve ser informada")
    @Length(max = 100, message = "A descricao não deve ter mais que {max} caracteres")
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    
    @NotNull(message = "A quantidade de paginas deve ser informada")
    @Column(name = "quantidade_paginas", nullable = false)
    private Integer quantPaginas;  
            
    public Livro() {
        
    }
    

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the quantPaginas
     */
    public Integer getQuantPaginas() {
        return quantPaginas;
    }

    /**
     * @param quantPaginas the quantPaginas to set
     */
    public void setQuantPaginas(Integer quantPaginas) {
        this.quantPaginas = quantPaginas;
    }
   
}
