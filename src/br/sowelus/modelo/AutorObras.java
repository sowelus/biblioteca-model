
package br.sowelus.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "autor_obras")
public class AutorObras implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_autor_obras", 
            sequenceName = "seq_autor_obras_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_autor_obras", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull(message = "O tipo deve ser informado")
    @Column(name = "tipo", nullable = false)
    private Integer tipo;    
     
    @NotNull(message = "O autor deve ser informada")
    @ManyToOne
    @JoinColumn(name = "autor_codigo",referencedColumnName = "codigo", nullable = false)
    private Autor autor;
    
    @NotNull(message = "A obra deve ser informada")
    @ManyToOne
    @JoinColumn(name = "obra_codigo", referencedColumnName = "codigo", nullable = false)
    private Obra obra;
    
    public AutorObras() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

      
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.codigo);
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
        final AutorObras other = (AutorObras) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }


}
