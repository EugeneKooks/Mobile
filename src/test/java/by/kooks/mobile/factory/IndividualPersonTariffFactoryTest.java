import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IndividualPersonTariffFactoryTest {


        private TariffFactory factory = IndividualPersonTariffFactory.getInstance();
        private String line;
        private IndividualPersonTariff individualPersonTariff;

        public IndividualPersonTariffFactoryTest(String line, IndividualPersonTariff individualPersonTariff) {
            this.line = line;
            this.individualPersonTariff = individualPersonTariff;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"individual more_calls 20 1 5 2 240 50 500", new IndividualPersonTariff(TariffType.MORE_CALLS, 20, 1, 5, 2, 240, 50, 500)},
                    {"individual more_traffic 20 5 1 2 60 50 4000", new IndividualPersonTariff(TariffType.MORE_TRAFFIC, 20, 5, 1, 2, 60, 50, 4000)},

            });
        }

        @Test
        public void createTariffTest() throws Exception {
            AbstractMobileTariff actual = factory.createTariff(line);
            Assert.assertEquals(individualPersonTariff, actual);
        }
    }
