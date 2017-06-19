package by.kooks.mobile.validator;

import org.junit.Assert;
import org.junit.Test;


public class InputDataValidatorTest {

    private InputDataValidator validator = new InputDataValidator();
    @Test
    public void correctInputData(){
        String data = "corporate international_business 200 0 0 0 1200 600 16000 delloite";
        Assert.assertTrue(validator.validator(data));
    }
    @Test
    public void inCorrectInputData(){
        String data = "uiuytuytur666666666";
        Assert.assertFalse(validator.validator(data));
    }
}
