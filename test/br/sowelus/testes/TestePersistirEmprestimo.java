package br.sowelus.testes;

import br.sowelus.jpa.EntityManagerUtil;
import br.sowelus.modelo.Usuario;
import br.sowelus.modelo.Emprestimo;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirEmprestimo {
    
    EntityManager em;
    
    public TestePersistirEmprestimo() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        Boolean exception = false;
        try {
            Emprestimo pf = new Emprestimo();
            pf.setDataSaida(Calendar.getInstance());
            pf.setDataRetorno(null);
            pf.setPrevisaoDevolucao(new GregorianCalendar(2016, Calendar.MAY, 3));
            pf.setClassificacao(2);
            pf.setRenovacao(0);            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
