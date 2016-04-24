
package br.sowelus.modelo;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "periodico")
public class Periodico extends Obra implements Serializable{

    
    @NotBlank(message = "A descricao deve ser informada")
    @Length(max = 100, message = "A descricao não deve ter mais que {max} caracteres")
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    
    @NotNull(message = "A edicao deve ser informada")
    @Column(name = "edicao", nullable = false)
    private Integer edicao;  

    @NotNull(message = "O numero deve ser informado")
    @Column(name = "numero", nullable = false)
    private Integer numero;  
    
    @NotNull(message = "O volume deve ser informado")
    @Column(name = "volume", nullable = false)
    private Integer volume;  
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "datae",nullable = false)
    private Calendar datae;    
   
    
    public Periodico() {
        
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
     * @return the edicao
     */
    public Integer getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the volume
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * @return the datae
     */
    public Calendar getDatae() {
        return datae;
    }

    /**
     * @param datae the datae to set
     */
    public void setDatae(Calendar datae) {
        this.datae = datae;
    }

  

}
