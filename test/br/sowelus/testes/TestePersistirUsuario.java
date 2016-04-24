/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sowelus.testes;

import br.sowelus.jpa.EntityManagerUtil;
import br.sowelus.modelo.Usuario;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sowelus
 */
public class TestePersistirUsuario {
    EntityManager em;   

 
    public TestePersistirUsuario() {
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
            Usuario u = new Usuario();
            u.setNome("Jeon");            
            u.setSobrenome("Jeongguk");            
            u.setEmail("kook@ibighit.com");            
            u.setSenha("jiminabs");   
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

