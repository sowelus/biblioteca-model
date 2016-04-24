
package br.sowelus.testes;

import br.sowelus.jpa.EntityManagerUtil;
import br.sowelus.modelo.Periodico;
import br.sowelus.modelo.Editora;
import br.sowelus.modelo.Genero;
import br.sowelus.modelo.Categoria;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistirPeriodico {
    EntityManager em;    
    
    public TestePersistirPeriodico() {
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
            Periodico p = new Periodico();
            p.setDescricao("Esta revista");            
            p.setVolume(5);  
            p.setNumero(2);  
            p.setEdicao(2);  
            p.setDatae(new GregorianCalendar(2013, Calendar.MAY, 21));
    
            p.setTitulo("Revista Kpop");            
            p.setSubtitulo("Kpop e a era da musica");
            p.setEditora(em.find(Editora.class, 4));
            p.setGenero(em.find(Genero.class, 1));
            p.setCategoria(em.find(Categoria.class, 2));
            p.setQuantidadeExemplar(2);
            p.setAnoLancamento(2013);
              
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

