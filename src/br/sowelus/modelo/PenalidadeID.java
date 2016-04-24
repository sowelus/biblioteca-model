
package br.sowelus.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
//esta classe sera embutida em outra classe que é uam entidade (mas ela nao e entidade sozinha)
        //agira como atributos de um id composto
@Embeddable
public class PenalidadeID implements Serializable {
    @NotNull(message = "O numero de penalidades deve ser informado")
    @Column(name = "numero_penalidade", nullable = false)
    private Integer numeroPenalidade;
    @NotNull(message = "O emprestimo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "emprestimo", referencedColumnName = "codigo", nullable = false)
    private Emprestimo emprestimo;

    public PenalidadeID() {
    }

    /**
     * @return the numeroPenalidade
     */
    public Integer getNumeroPenalidade() {
        return numeroPenalidade;
    }

    /**
     * @param numeroPenalidade the numeroPenalidade to set
     */
    public void setNumeroPenalidade(Integer numeroPenalidade) {
        this.numeroPenalidade = numeroPenalidade;
    }

    /**
     * @return the emprestimo
     */
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    /**
     * @param emprestimo the emprestimo to set
     */
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.numeroPenalidade);
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
        final PenalidadeID other = (PenalidadeID) obj;
        if (!Objects.equals(this.numeroPenalidade, other.numeroPenalidade)) {
            return false;
        }
        return true;
    } 
  


}
