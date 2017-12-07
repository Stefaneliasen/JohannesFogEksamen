/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.ProductMapper;
import entity.Material;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arne
 */
public class CarportCalculatorTes {
    
    public CarportCalculatorTes() {
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
     * Test of main method, of class CarportCalculator.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        CarportCalculator.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stk1 method, of class CarportCalculator.
     */
    @Test
    public void testStk1() throws Exception {
        System.out.println("stk1");
        int length = 0;
        int width = 0;
        int height = 0;
        CarportCalculator instance = new CarportCalculator();
        Material expResult = null;
        Material result = instance.brædderForOgBag(length, width, height);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stk2 method, of class CarportCalculator.
     */
    @Test
    public void testStk2() throws Exception {
        System.out.println("stk2");
        int length = 0;
        int width = 0;
        int height = 0;
        CarportCalculator instance = new CarportCalculator();
        Material expResult = null;
        Material result = instance.brædderSiderne(length, width, height);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stk3 method, of class CarportCalculator.
     */
    @Test
    public void testStk3() throws Exception {
        System.out.println("stk3");
        int length = 0;
        int width = 0;
        int height = 0;
        CarportCalculator instance = new CarportCalculator();
        Material expResult = null;
        Material result = instance.oversternBrædderForenden(length, width, height);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stk4 method, of class CarportCalculator.
     */
    @Test
    public void testStk4() throws Exception {
        System.out.println("stk4");
        int length = 0;
        int width = 0;
        int height = 0;
        CarportCalculator instance = new CarportCalculator();
        Material expResult = null;
        Material result = instance.oversternBrædderSiderne(length, width, height);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stk5 method, of class CarportCalculator.
     */
    @Test
    public void testStk5() throws Exception {
        System.out.println("stk5");
        int length = 600;
        int width = 300;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        Material expResult = null;
        Material result = instance.remISider(length, width, height);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stk6 method, of class CarportCalculator.
     */
    @Test
    public void testStk6Amount() throws Exception {
        System.out.println("stk6");
        int length = 600;
        int width = 300;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 11;
        int result = instance.spaer(length, width, height).getAmount();
        assertEquals(expResult, result);
       
    }
     @Test
    public void testStk6Length() throws Exception {
        System.out.println("stk6");
        ProductMapper pm = new ProductMapper();
        int length = 600;
        int width = 300;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        Material expResult = new Material(pm.getMaterialById(5).getPname(), pm.getMaterialById(5).getPrice());
        Material result = instance.spaer(length, width, height);
        assertEquals(expResult, result);
        expResult.equals(result);
       
    }

//    /**
//     * Test of stk7 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk7() throws Exception {
//        System.out.println("stk7");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk7(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk8 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk8() throws Exception {
//        System.out.println("stk8");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk8(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk9 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk9() throws Exception {
//        System.out.println("stk9");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk9(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk10 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk10() throws Exception {
//        System.out.println("stk10");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk10(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk11 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk11() throws Exception {
//        System.out.println("stk11");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk11(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk12 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk12() throws Exception {
//        System.out.println("stk12");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk12(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk13 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk13() throws Exception {
//        System.out.println("stk13");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk13(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk14 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk14() throws Exception {
//        System.out.println("stk14");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk14(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk15 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk15() throws Exception {
//        System.out.println("stk15");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk15(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk16 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk16() throws Exception {
//        System.out.println("stk16");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk16(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk17 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk17() throws Exception {
//        System.out.println("stk17");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk17(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk18 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk18() throws Exception {
//        System.out.println("stk18");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk18(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stk19 method, of class CarportCalculator.
//     */
//    @Test
//    public void testStk19() throws Exception {
//        System.out.println("stk19");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        Material expResult = null;
//        Material result = instance.stk19(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of flatRoofMaterial method, of class CarportCalculator.
//     */
//    @Test
//    public void testFlatRoofMaterial() throws Exception {
//        System.out.println("flatRoofMaterial");
//        int length = 0;
//        int width = 0;
//        int height = 0;
//        CarportCalculator instance = new CarportCalculator();
//        ArrayList<Material> expResult = null;
//        ArrayList<Material> result = instance.flatRoofMaterial(length, width, height);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
