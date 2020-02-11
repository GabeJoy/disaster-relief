import org.junit.Test;
import static org.junit.Assert.assertEquals;

class mainClassTest {
    @Test
    public void testConversionFtoC() throws Throwable{
        mainClass underTest = new mainClass();
        double temperature = 80.0d;
        String unit = "";
        double result = underTest.tempConversion(temperature,unit);

        assertEquals(176.0d, result, 0.0);

    }

    @Test
    public void testConversionCtoF() throws Throwable{
        mainClass underTest = new mainClass();
        double temperature = 80.0d;
        String unit = "F";
        double result = underTest.tempConversion(temperature,unit);

        assertEquals(26.6d, result, 0.5);

    }

}
