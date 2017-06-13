import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class MobileOperatorCreatorTest {

    private ArrayList<String> inputOperator;
    private MobileOperatorCreator mobileOperatorCreator = new MobileOperatorCreator();

    public MobileOperatorCreatorTest(ArrayList<String> inputOperator) {
        this.inputOperator = inputOperator;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ArrayList<>(Arrays.asList("individual more_traffic 20 5 1 2 60 50 4000", "individual more_calls 20 1 5 2 240 50 500", "individual mixed 30 3 3 3 60 50 300"))},
                {new ArrayList<>(Arrays.asList("corporate international_business 200 0 0 0 1200 600 16000 delloite", "corporate in_corporation_free 100 1 1 1 600 200 8000 evroopt", "corporate small_business 40 2 2 2 300 100 4000 kapitoshka"))},

        });
    }

    @Test
    public void createOperator() throws Exception {
        MobileOperator operator = mobileOperatorCreator.createOperator(inputOperator);
        Assert.assertFalse(operator.getAllTariffs().isEmpty());
    }
}