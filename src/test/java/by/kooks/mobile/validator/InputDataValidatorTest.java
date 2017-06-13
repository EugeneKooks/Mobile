import org.junit.Assert;
import org.junit.Test;


public class InputDataValidatorTest {

    private InputDataValidator validator = new InputDataValidator();

    @Test
    public void correctLine() throws Exception {
        String line = "corporate international_business 200 0 0 0 1200 600 16000 delloite";
        Assert.assertTrue(validator.validator(line));
    }

    @Test
    public void inCorrectLine() throws Exception {
        String line = "dfhff5555";
        Assert.assertFalse(validator.validator(line));
    }
}
