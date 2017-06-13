import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CorporateTariffFactoryTest {

    private TariffFactory factory = CorporateTariffFactory.getInstance();
    private String line;
    private CorporateTariff corporateTariff;

    public CorporateTariffFactoryTest(String line, CorporateTariff corporateTariff) {
        this.line = line;
        this.corporateTariff = corporateTariff;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"corporate international_business 200 0 0 0 1200 600 16000 delloite", new CorporateTariff(TariffType.INTERNATIONAL_BUSINESS, 200, 0, 0, 0, 1200, 600, 16000, "delloite")},
                {"corporate small_business 40 2 2 2 300 100 4000 kapitoshka", new CorporateTariff(TariffType.SMALL_BUSINESS, 40, 2, 2, 2, 300, 100, 4000, "kapitoshka")},

        });
    }

    @Test
    public void createTariffTest() throws Exception {
        AbstractMobileTariff actual = factory.createTariff(line);
        Assert.assertEquals(corporateTariff, actual);
    }
}