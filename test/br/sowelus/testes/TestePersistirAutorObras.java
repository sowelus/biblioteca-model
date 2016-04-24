
package br.sowelus.testes;

import br.sowelus.jpa.EntityManagerUtil;
import br.sowelus.modelo.Obra;
import br.sowelus.modelo.Autor;
import br.sowelus.modelo.AutorObras;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author jorge
 */
public class TestePersistirAutorObras {
    
    EntityManager em;
    
    public TestePersistirAutorObras() {
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
            Obra ob = em.find(Obra.class, 1);
            AutorObras ab = new AutorObras();
            ab.setTipo(1);
            ab.setObra(em.find(Obra.class, 1));
            ab.setAutor(em.find(Autor.class, 1));
            ob.adicionarAutorObras(ab);
            em.getTransaction().begin();
            em.persist(ob);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
