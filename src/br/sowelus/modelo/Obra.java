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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author sowelus
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//fornece herança para outras classes
@Table(name = "obra")
public abstract class Obra implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_obra", sequenceName = "seq_obra_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_obra", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotBlank(message = "O titulo deve ser informado")
    @Length(max = 80, message = "O titulo não deve ter mais que {max} caracteres")
    @Column(name = "titulo", length = 80, nullable = false)
    private String titulo;
    
    @Length(max = 80, message = "O subtitulo não deve ter mais que {max} caracteres")
    @Column(name = "subtitulo", length = 80)
    private String subtitulo;
 
    
    @NotNull(message = "A quantidade de parcelas deve ser informada")
    @Column(name = "quantidade_exemplar", nullable = false)
    private Integer quantidadeExemplar;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;
    
    @ManyToOne
    @JoinColumn(name = "editora", referencedColumnName = "codigo", nullable = false)
    private Editora editora;
  
    @ManyToOne
    @JoinColumn(name = "genero", referencedColumnName = "codigo", nullable = false)
    private Genero genero;
    
    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "codigo", nullable = false)
    private Categoria categoria;
    
   @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AutorObras> autor_obras = new ArrayList<>();
        //telefones e mapeado em pessoa, pois pertencem a ele
    
        
    public Obra() {
    }

    public void adicionarAutorObras(AutorObras obj){
        obj.setObra(this);
        this.autor_obras.add(obj);
    }
    
    public void removerAutorObras(int index){
        this.autor_obras.remove(index);
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the subtitulo
     */
    public String getSubtitulo() {
        return subtitulo;
    }

    /**
     * @param subtitulo the subtitulo to set
     */
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    /**
     * @return the quantidadeExemplar
     */
    public Integer getQuantidadeExemplar() {
        return quantidadeExemplar;
    }

    /**
     * @param quantidadeExemplar the quantidadeExemplar to set
     */
    public void setQuantidadeExemplar(Integer quantidadeExemplar) {
        this.quantidadeExemplar = quantidadeExemplar;
    }

    /**
     * @return the anoLancamento
     */
    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @param anoLancamento the anoLancamento to set
     */
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.codigo);
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
        final Obra other = (Obra) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return titulo;
    }

    /**
     * @return the autor_obras
     */
    public List<AutorObras> getAutor_obras() {
        return autor_obras;
    }

    /**
     * @param autor_obras the autor_obras to set
     */
    public void setAutor_obras(List<AutorObras> autor_obras) {
        this.autor_obras = autor_obras;
    }

}