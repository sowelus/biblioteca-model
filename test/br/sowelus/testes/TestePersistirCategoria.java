
package br.sowelus.testes;

import br.sowelus.jpa.EntityManagerUtil;
import br.sowelus.modelo.Categoria;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sowelus
 */
public class TestePersistirCategoria {
    EntityManager em;    
    
    public TestePersistirCategoria() {
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
            Categoria a = new Categoria();
            a.setDescricao("Tecnologias");
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

