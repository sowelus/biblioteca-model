package br.sowelus.testes;

import br.sowelus.jpa.EntityManagerUtil;
import br.sowelus.modelo.Usuario;
import br.sowelus.modelo.Emprestimo;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirUsuariosEmprestimos {    
    
    EntityManager em;

    public TestePersistirUsuariosEmprestimos() {
        
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
    public void teste() {
        boolean exception = false;
        try {
            Usuario obj = em.find(Usuario.class, 4);
            Emprestimo e = em.find(Emprestimo.class, 1);
            obj.getUsuariosEmprestimos().add(e);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}  
