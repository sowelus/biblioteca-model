
package br.sowelus.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author sowelus
 */
@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_emprestimo", sequenceName = "seq_emprestimo_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_emprestimo", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull(message = "A data de saída deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_saida", nullable = false)
    private Calendar dataSaida;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_retorno")
    private Calendar dataRetorno;

    @NotNull(message = "A previsão de devolução deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "previsao_devolucao", nullable = false)
    private Calendar previsaoDevolucao;
    
    @NotNull(message = "A classificacao deve ser informada")
    @Column(name = "classificacao", nullable = false)
    private Integer classificacao;
    
    @NotNull(message = "A renovacao deve ser informada")
    @Column(name = "renovacao", nullable = false)
    private Integer renovacao;
    
    @ManyToMany
        @JoinTable(name = "usuarios_emprestimos",
            joinColumns = 
            @JoinColumn(name = "emprestimo", referencedColumnName = "codigo", 
                    nullable = false), 
             //referencia o lado da lista
            inverseJoinColumns = 
            @JoinColumn(name = "usuario", referencedColumnName = "codigo", 
                    nullable = false))
    private List<Usuario> usuariosEmprestimos = new ArrayList<>();
    
    // o valor em mappedBy refere-se ao atributo 
    // da classe parcela que faz referencia a classe venda
    // no caso ele se encontra dentro do atributo parcelaID
    @OneToMany(mappedBy = "penalidadeID.emprestimo", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Penalidade> penalidades = new ArrayList<>();
        
    
    public Emprestimo() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Calendar getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Calendar dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Calendar getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Calendar dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public Calendar getPrevisaoDevolucao() {
        return previsaoDevolucao;
    }

    public void setPrevisaoDevolucao(Calendar previsaoDevolucao) {
        this.previsaoDevolucao = previsaoDevolucao;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getRenovacao() {
        return renovacao;
    }

    public void setRenovacao(Integer renovacao) {
        this.renovacao = renovacao;
    }

    public List<Usuario> getUsuariosEmprestimos() {
        return usuariosEmprestimos;
    }

    public void setUsuariosEmprestimos(List<Usuario> usuariosEmprestimos) {
        this.usuariosEmprestimos = usuariosEmprestimos;
    }
   public void inserirPenalidades(int diasDebito){
        Double valorMulta = 2.5, valorTotal;
          valorTotal = valorMulta * diasDebito;
          
            Penalidade p = new Penalidade();
            PenalidadeID id = new PenalidadeID();
            id.setNumeroPenalidade(this.penalidades.size() + 1);
            id.setEmprestimo(this);
            p.setPenalidadeID(id);
             
            p.setDiasDebito(diasDebito);
            p.setValorMulta(valorTotal);
            this.penalidades.add(p);
        }
     
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
 
}