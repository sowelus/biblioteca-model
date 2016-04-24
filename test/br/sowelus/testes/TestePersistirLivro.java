
package br.sowelus.testes;

import br.sowelus.jpa.EntityManagerUtil;
import br.sowelus.modelo.Obra;
import br.sowelus.modelo.Livro;
import br.sowelus.modelo.Editora;
import br.sowelus.modelo.Genero;
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
public class TestePersistirLivro {
    EntityManager em;    
    
    public TestePersistirLivro() {
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
            Livro l = new Livro();
            l.setDescricao("Este Livro");            
            l.setQuantPaginas(80);  
            
            l.setTitulo("A Saga das Dimensões");            
            l.setSubtitulo("Volume 1");
            l.setEditora(em.find(Editora.class, 4));
            l.setGenero(em.find(Genero.class, 1));
            l.setCategoria(em.find(Categoria.class, 2));
            l.setQuantidadeExemplar(1);
            l.setAnoLancamento(1991);
         
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

