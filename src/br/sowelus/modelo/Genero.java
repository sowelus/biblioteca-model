
package br.sowelus.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "genero")
public class Genero implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_genero", sequenceName = "seq_genero_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_genero", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotBlank(message = "A descricao deve ser informada")
    @Length(max = 50, message = "A descricao não deve ter mais que {max} caracteres")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    public Genero() {
        
    }

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
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.codigo);
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
        final Genero other = (Genero) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }       
    
    
}
