
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author sowelus
 */
@Entity
@Table(name = "autor")
public class Autor implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotBlank(message = "O sobrenome deve ser informado")
    @Length(max = 50, message = "O sobrenome não deve ter mais que {max} caracteres")
    @Column(name = "sobrenome", length = 50, nullable = false)
    private String sobrenome;
    
    @Length(max = 50, message = "O nome artístico não deve ter mais do que {max} caracteres")
    @Column(name = "nome_artistico", length = 50)
    private String nomeArtistico;
    
    @Length(max = 50, message = "o País não deve ter mais do que {max} caracteres")
    @Column(name = "pais", length = 50)
    private String pais;
    
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AutorObras> autor_obras = new ArrayList<>();
    

    public Autor() {
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
     * @return the nomeArtistico
     */
    public String getNomeArtistico() {
        return nomeArtistico;
    }

    /**
     * @param nomeArtistico the nomeArtistico to set
     */
    public void setNomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
    
}
