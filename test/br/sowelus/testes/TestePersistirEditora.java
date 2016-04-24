
package br.sowelus.testes;

import br.sowelus.jpa.EntityManagerUtil;
import br.sowelus.modelo.Editora;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sowelus
 */
public class TestePersistirEditora {
    EntityManager em;   

 
    public TestePersistirEditora() {
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
            Editora u = new Editora();
            u.setRazaoSocial("Rocco");            
            u.setEndereco("São Paulo");            
            u.setTelefoneComercial("549999900");            
            u.setUrlSite("www.rocco.com.br");   
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

