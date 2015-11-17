/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dibresoft.persistencia;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luciano.lourenco
 */
public class ConnectionFactoryTest {
  
  public ConnectionFactoryTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of openConection method, of class ConnectionFactory.
   */
  @Test
  public void testOpenConection() {
    System.out.println("openConection");
    ConnectionFactory instance = new ConnectionFactory();
    instance.openConection();
    
    
  }

   @Test
  public void testCloseConection() {
    System.out.println("openConection");
    ConnectionFactory instance = new ConnectionFactory();
    instance.openConection();
    instance.closeConection();
    
  }
  
  
}
