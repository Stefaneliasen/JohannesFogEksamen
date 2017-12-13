package FunctionLayer;

import entity.Material;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShedCalculatorT {
    
    public ShedCalculatorT() {
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

    @Test
    public void testLægteBagsideDør() throws Exception {
        System.out.println("l\u00e6gteBagsideD\u00f8r");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 1;
        int result = instance.lægteBagsideDør(sLength, width, height).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of løsholtergavl method, of class ShedCalculator.
     */
    @Test
    public void testLøsholtergavl() throws Exception {
        System.out.println("l\u00f8sholtergavl");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 12;
        int result = instance.løsholtergavl(sLength, width, height).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testLøsholterside() throws Exception {
        System.out.println("l\u00f8sholterside");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 4;
        int result = instance.løsholterside(sLength, width, height).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testRemmeISider() throws Exception {
        System.out.println("remmeISider");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 1;
        int result = instance.remmeISider(sLength, width, height).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testBrætTilSkur() throws Exception {
        System.out.println("br\u00e6tTilSkur");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 400;
        int result = instance.brætTilSkur(sLength, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testYderBeklædningSkruerTilSkur() throws Exception {
        System.out.println("yderBekl\u00e6dningSkruerTilSkur");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 4;
        int result = instance.yderBeklædningSkruerTilSkur(sLength, width, height).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testInderBeklædningSkruerTilSkur() throws Exception {
        System.out.println("inderBekl\u00e6dningSkruerTilSkur");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 4;
        int result = instance.inderBeklædningSkruerTilSkur(sLength, width, height).getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testStalddørsgrebTilSkur() throws Exception {
        System.out.println("staldd\u00f8rsgrebTilSkur");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 1;
        int result = instance.stalddørsgrebTilSkur(sLength, width, height).getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testTHængselTilSkur() throws Exception {
        System.out.println("tH\u00e6ngselTilSkur");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 2;
        int result = instance.tHængselTilSkur(sLength, width, height).getAmount();
        assertEquals(expResult, result);
        }

    @Test
    public void testVinkelBeslagTilSkur() throws Exception {
        System.out.println("vinkelBeslagTilSkur");
        int sLength = 500;
        int width = 500;
        int height = 200;
        ShedCalculator instance = new ShedCalculator();
        int expResult = 32;
        int result = instance.vinkelBeslagTilSkur(sLength, width, height).getAmount();
        assertEquals(expResult, result);
    }
}
