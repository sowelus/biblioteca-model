
package br.sowelus.testes;

import br.sowelus.jpa.EntityManagerUtil;
import br.sowelus.modelo.Autor;
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
public class TestePersistirAutor {
    EntityManager em;    
    
    public TestePersistirAutor() {
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
            Autor a = new Autor();
            a.setNome("Jeon");            
            a.setSobrenome("Jeongguk");            
            a.setNomeArtistico("Jungkook");            
            a.setPais("South Korea");            
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

