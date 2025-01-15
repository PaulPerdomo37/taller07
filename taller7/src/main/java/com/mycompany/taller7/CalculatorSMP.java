/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller7;

import java.rmi.server.Operation;

/**
 *
 * @author CltControl
 */
public class CalculatorSMP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String question = Operations.MakeFormula();
        System.out.println(question);
        String ret = Operations.Solve(question);
        System.out.println(ret);
        
        
    }
    
}
