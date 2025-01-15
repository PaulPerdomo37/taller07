/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.taller7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author CltControl
 */
public class OperationsTest {
    
    public OperationsTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    void testMakeFormulaLongitud() {
    String formula = Operations.MakeFormula();
    assertTrue(formula.length()<=11);
    //la formula siempre tiene 11 caracteres
    }

    /**
     * Test of MakeFormula method, of class Operations.
     */
    

    /**
     * Test of Solve method, of class Operations.
     */
    
    
    


}
