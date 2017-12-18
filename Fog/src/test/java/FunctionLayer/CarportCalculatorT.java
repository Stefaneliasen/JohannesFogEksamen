/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

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
 * @author Mathias BJ
 */
public class CarportCalculatorT {

    public CarportCalculatorT() {
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
     * Test of brædderForOgBag method, of class CarportCalculator.
     */
        @Test
        public void testBrædderForOgBagLength() throws Exception {
            System.out.println("br\u00e6dderForOgBag");
            int length = 600;
            int width = 400;
            int height = 200;
            CarportCalculator instance = new CarportCalculator();
            int expResult = 405;
            int result = instance.brædderForOgBag(length, width, height).getLength();
            assertEquals(expResult, result);
        }
        @Test
        public void testBrædderForOgBagAmount() throws Exception {
            System.out.println("br\u00e6dderForOgBag");
            int length = 600;
            int width = 400;
            int height = 200;
            CarportCalculator instance = new CarportCalculator();
            int expResult = 2;
            int result = instance.brædderForOgBag(length, width, height).getAmount();
            assertEquals(expResult, result);
        }

    /**
     * Test of brædderSiderne method, of class CarportCalculator.
     */
    @Test
    public void testBrædderSiderneAmount() throws Exception {
        System.out.println("br\u00e6dderSiderne");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 2;
        int result = instance.brædderSiderne(length, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testBrædderSiderneLength() throws Exception {
        System.out.println("br\u00e6dderSiderne");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 600;
        int result = instance.brædderSiderne(length, width, height).getLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of oversternBrædderForenden method, of class CarportCalculator.
     */
    @Test
    public void testOversternBrædderForendenAmount() throws Exception {
        System.out.println("oversternBr\u00e6dderForenden");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 1;
        int result = instance.oversternBrædderForenden(length, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testOversternBrædderForendenLength() throws Exception {
        System.out.println("oversternBr\u00e6dderForenden");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 405;
        int result = instance.oversternBrædderForenden(length, width, height).getLength();
        assertEquals(expResult, result);
    }
    /**
     * Test of oversternBrædderSiderne method, of class CarportCalculator.
     */
    @Test
    public void testOversternBrædderSiderneAmount() throws Exception {
        System.out.println("oversternBr\u00e6dderSiderne");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 2;
        int result = instance.oversternBrædderSiderne(length, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testOversternBrædderSiderneLength() throws Exception {
        System.out.println("oversternBr\u00e6dderSiderne");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 600;
        int result = instance.oversternBrædderSiderne(length, width, height).getLength();
        assertEquals(expResult, result);
    }
    /**
     * Test of remISider method, of class CarportCalculator.
     */
    @Test
    public void testRemISiderAmount() throws Exception {
        System.out.println("remISider");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 2;
        int result = instance.remISider(length, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testRemISiderLength() throws Exception {
        System.out.println("remISider");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 400;
        int result = instance.remISider(length, width, height).getLength();
        assertEquals(expResult, result);
    }
    /**
     * Test of spaer method, of class CarportCalculator.
     */
    @Test
    public void testSpaerLength() throws Exception {
        System.out.println("testSpaerLength");
        int length = 600;
        int width = 300;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = width;
        int result = instance.spaer(length, width, height).getLength();
        assertEquals(expResult, result);
    }

    @Test
    public void testSpaerAmount() throws Exception {
        System.out.println("testSpaerAmount");
        int length = 600;
        int width = 300;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 11;
        int result = instance.spaer(length, width, height).getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of stolper method, of class CarportCalculator.
     */
    @Test
    public void testStolper() throws Exception {
        System.out.println("stolper");
        int length = 1000;
        int width = 600;
        int height = 200;
        int sLength = 0;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 8;
        int result = instance.stolper(length, width, height, sLength).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testStolperMedSkur() throws Exception {
        System.out.println("stolper");
        int length = 1000;
        int width = 600;
        int height = 200;
        int sLength = 400;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 12;
        int result = instance.stolper(length, width, height, sLength).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testVandbrætSideAmount() throws Exception {
        System.out.println("vandbr\u00e6tSide");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 4;
        int result = instance.vandbrætSide(length, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testVandbrætSideLength() throws Exception {
        System.out.println("vandbr\u00e6tSide");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 600;
        int result = instance.vandbrætSide(length, width, height).getLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of vandbrætFor method, of class CarportCalculator.
     */
    @Test
    public void testVandbrætForAmount() throws Exception {
        System.out.println("vandbr\u00e6tFor");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 2;
        int result = instance.vandbrætFor(length, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testVandbrætForLength() throws Exception {
        System.out.println("vandbr\u00e6tFor");
        int length = 600;
        int width = 400;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 400;
        int result = instance.vandbrætFor(length, width, height).getLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of tagPladeStor method, of class CarportCalculator.
     */
    @Test
    public void testTagPladeStor() throws Exception {
        System.out.println("tagPladeStor");
        int length = 1000;
        int width = 600;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 6;
        int result = instance.tagPladeStor(length, width, height).getAmount();
        assertEquals(expResult, result);
    }

    @Test
    public void testTagPladeLille() throws Exception {
        System.out.println("tagPladeLille");
        int length = 500;
        int width = 300;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 3;
        int result = instance.tagPladeLille(length, width, height).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testTagPladeSkruer() throws Exception {
        System.out.println("tagPladeSkruer");
        int length = 1000;
        int width = 600;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 4;
        int result = instance.tagPladeSkruer(length, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testHulbaand() throws Exception {
        System.out.println("hulbaand");
        int length = 1000;
        int width = 600;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 3;
        int result = instance.hulbaand(length, width, height).getAmount();
        assertEquals(expResult, result);
    }

    @Test
    public void testUniversalBeslagHøjre() throws Exception {
        System.out.println("universalBeslagH\u00f8jre");
        int length = 1000;
        int width = 600;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 18;
        int result = instance.universalBeslagHøjre(length, width, height).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testUniversalBeslagVenstre() throws Exception {
        System.out.println("universalBeslagVenstre");
        int length = 1000;
        int width = 600;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 18;
        int result = instance.universalBeslagVenstre(length, width, height).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testSkruerSternOgVandbræt() throws Exception {
        System.out.println("skruerSternOgVandbr\u00e6t");
        int length = 1000;
        int width = 600;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 1;
        int result = instance.skruerSternOgVandbræt(length, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testUniversalOgHulbaandSkruer() throws Exception {
        System.out.println("universalOgHulbaandSkruer");
        int length = 1000;
        int width = 600;
        int height = 200;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 3;
        int result = instance.universalOgHulbaandSkruer(length, width, height).getAmount();
        assertEquals(expResult, result);
    }

    @Test
    public void testBræddeboltAmount() throws Exception {
        System.out.println("br\u00e6ddebolt");
        int length = 1000;
        int width = 600;
        int height = 200;
        int sLength = 500;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 24;
        int result = instance.bræddebolt(length, width, height, sLength).getAmount();
        assertEquals(expResult, result);
    }

    @Test
    public void testFirkantskiver() throws Exception {
        System.out.println("firkantskiver");
        int length = 1000;
        int width = 600;
        int height = 200;
        int sLength = 500;
        CarportCalculator instance = new CarportCalculator();
        int expResult = 24;
        int result = instance.firkantskiver(length, width, height, sLength).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
