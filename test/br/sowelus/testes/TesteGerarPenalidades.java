package br.sowelus.testes;

import br.sowelus.modelo.Emprestimo;
import br.sowelus.modelo.Penalidade;
import br.sowelus.jpa.EntityManagerUtil;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TesteGerarPenalidades {

    EntityManager em;

    public TesteGerarPenalidades() {
    }

    @Before
    public void setUp() {                       
        em = em = EntityManagerUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        
        
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Emprestimo v = em.find(Emprestimo.class,1);
            v.inserirPenalidades(2);
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
