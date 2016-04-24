
package br.sowelus.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "penalidade")
public class Penalidade implements Serializable {
    @EmbeddedId
    private PenalidadeID penalidadeID;
   
    @Column(name = "valor_multa", columnDefinition = "numeric(12,2)")
    private Double valorMulta;
    
    @Column(name = "dias_debito")
    private Integer diasDebito;
   

    public Penalidade() {
    }

    /**
     * @return the penalidadeID
     */
    public PenalidadeID getPenalidadeID() {
        return penalidadeID;
    }

    /**
     * @param penalidadeID the penalidadeID to set
     */
    public void setPenalidadeID(PenalidadeID penalidadeID) {
        this.penalidadeID = penalidadeID;
    }

    /**
     * @return the valorMulta
     */
    public Double getValorMulta() {
        return valorMulta;
    }

    /**
     * @param valorMulta the valorMulta to set
     */
    public void setValorMulta(Double valorMulta) {
        this.valorMulta = valorMulta;
    }

    /**
     * @return the diasDebito
     */
    public Integer getDiasDebito() {
        return diasDebito;
    }

    /**
     * @param diasDebito the diasDebito to set
     */
    public void setDiasDebito(Integer diasDebito) {
        this.diasDebito = diasDebito;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.penalidadeID);
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
        final Penalidade other = (Penalidade) obj;
        if (!Objects.equals(this.penalidadeID, other.penalidadeID)) {
            return false;
        }
        return true;
    }

}