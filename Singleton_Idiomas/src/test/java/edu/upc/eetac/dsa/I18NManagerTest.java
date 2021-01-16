package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class I18NManagerTest {


    final static Logger log = Logger.getLogger(I18NManagerTest.class.getName());
    I18NManager i18n;

    @Before
    public void setUp(){
        i18n = I18NManager.getInstance();
    }

    @After
    public void tearDown(){
        i18n = null;
    }


    //Castellano
    @Test
    public void testFileSpanish(){
        try {
            String datal1 = i18n.getInstance().getString("es", "l1");
            assertEquals("Coche", datal1);
            String datal2 = i18n.getInstance().getString("es", "l2");
            assertEquals("Casa", datal2);
        }
        catch(Exception e){
            log.warn("The file doesn't exist!! : " +e.getMessage());
        }
    }

    //Ingles
    @Test
    public void testFileEnglish(){
        try {
            String datal1 = i18n.getInstance().getString("en", "l1");
            assertEquals("Car", datal1);
            String datal2 = i18n.getInstance().getString("en", "l2");
            assertEquals("House", datal2);
        }
        catch(Exception e){
            log.warn("The file doesn't exist!! : " +e.getMessage());
        }
    }

    //Catalan
    @Test
    public void testFileCatalan(){
        try {
            String datal1 = i18n.getInstance().getString("ca", "l1");
            assertEquals("Cotxe", datal1);
            String datal2 = i18n.getInstance().getString("ca", "l2");
            assertEquals("Casa", datal2);
        }
        catch(Exception e){
            log.warn("The file doesn't exist!! : " +e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testFileAndException() throws Exception {
        String datal1 = i18n.getInstance().getString("ru", "l1");
        assertEquals("Car", datal1);
    }

}
