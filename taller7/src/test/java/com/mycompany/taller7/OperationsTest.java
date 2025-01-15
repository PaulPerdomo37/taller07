/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.taller7;


import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author CltControl
 */
public class OperationsTest {

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Starting Operations tests...");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Operations tests completed.");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Starting a test case...");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test case completed.");
    }

    @Test
    void testMakeFormulaLongitud() {
    String formula = Operations.MakeFormula();
    assertTrue(formula.length()<=11);
    //la formula siempre tiene 11 caracteres
    }

    @Test
    void  testSolveNull(){
        assertThrows(IllegalArgumentException.class, () -> Operations.Solve(null));
    }

    /**
     * Test of MakeFormula method, ensuring formula format validity.
     */

    @Test
    public void testMakeFormula() {
        System.out.println("MakeFormula");
        String formula = Operations.MakeFormula();

        // Verificar que la fórmula no esté vacía
        assertFalse(formula.isEmpty(), "Formula no debe ser vacia");

        // Verificar que empiece con un número
        assertTrue(Character.isDigit(formula.charAt(0)), "Formula debe iniciar con un numero");

        // Verificar que termine con un número
        assertTrue(Character.isDigit(formula.charAt(formula.length() - 1)), "Formula debe terminar con un numero");

        // Verificar alternancia básica entre operadores y números
        for (int i = 1; i < formula.length() - 1; i++) {
            char current = formula.charAt(i);
            char previous = formula.charAt(i - 1);

            if ("+-*/".indexOf(current) >= 0) {
                assertTrue(Character.isDigit(previous), "La formula debe tener un operador entre numeros");
            }
            if (Character.isDigit(current)) {
                assertTrue("+-*/".indexOf(previous) >= 0 || Character.isDigit(previous),
                        "No pueden haber dos operadores seguidos");
            }
        }

        System.out.println("Generated formula: " + formula);
    }

    @Test
    public void testSolve() {
        System.out.println("Solve");

        // Test con formulas que conozco la respuesta
        assertEquals("3+3=6", Operations.Solve("3+3"));
        assertEquals("10-4=6", Operations.Solve("10-4"));
        assertEquals("5*3=15", Operations.Solve("5*3"));
        assertEquals("8/2=4", Operations.Solve("8/2"));
    }


    /**
     * Test for division by zero, ensuring appropriate exception handling.
     */

    @Test
    public void testDivisionByZero() {
        System.out.println("Probar que de error dividido para 0");
        assertThrows(ArithmeticException.class, () -> Operations.Solve("5/0"));

    }
    @Test
   public void testSolveFormato() {
    String formula = Operations.MakeFormula();
    String result = Operations.Solve(formula);
    assertTrue(result.contains("="), "la solucción deberia contener = : " + result);

    
    // Verificar que el resultado evaluado sea un número válido después del '='
    String[] parts = result.split("=");
    assertEquals(2, parts.length, "La solucioón debe contener la formula y la solucion separados por =");
    
    try {
        Integer.parseInt(parts[1]);
    } catch (NumberFormatException e) {
        fail("El resultado no es un entero: " + parts[1]);
    }
}
}
