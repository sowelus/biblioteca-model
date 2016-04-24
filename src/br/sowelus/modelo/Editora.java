
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

/**
 *
 * @author sowelus
 */
@Entity
@Table(name = "editora")
public class Editora implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_editora", sequenceName = "seq_editora_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_editora", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotBlank(message = "A Razão Social deve ser informada")
    @Length(max = 50, message = "A Razão Social não deve ter mais que {max} caracteres")
    @Column(name = "razao_social", length = 50, nullable = false)
    private String razaoSocial;
    
    @NotBlank(message = "O endereco deve ser informado")
    @Length(max = 50, message = "O endereco não deve ter mais que {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)    
    private String endereco;
    
    @NotBlank(message = "O telefone comercial deve ser informado")
    @Length(max = 50, message = "O telefone comercial não deve ter mais que {max} caracteres")
    @Column(name = "telefone_comercial", length = 50, nullable = false)    
    private String telefoneComercial;
    
    @NotBlank(message = "A url do site deve ser informada")
    @Length(max = 50, message = "a url do site não deve ter mais que {max} caracteres")
    @Column(name = "url_site", length = 50, nullable = false)    
    private String urlSite;

    public Editora() {
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
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefoneComercial
     */
    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    /**
     * @param telefoneComercial the telefoneComercial to set
     */
    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    /**
     * @return the urlSite
     */
    public String getUrlSite() {
        return urlSite;
    }

    /**
     * @param urlSite the urlSite to set
     */
    public void setUrlSite(String urlSite) {
        this.urlSite = urlSite;
    }

        
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Editora other = (Editora) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getRazaoSocial();
    }
    
    
}
