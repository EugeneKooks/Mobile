package by.kooks.mobile.factory;

import by.kooks.mobile.entity.AbstractMobileTariff;
import by.kooks.mobile.entity.IndividualPersonTariff;
import by.kooks.mobile.entity.TariffType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IndividualPersonTariffFactoryTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"individual more_calls 20 1 5 2 240 50 500", new IndividualPersonTariff(TariffType.MORE_CALLS, 20, 1, 5, 2, 240, 50, 500)},
                {"individual more_traffic 20 5 1 2 60 50 4000", new IndividualPersonTariff(TariffType.MORE_TRAFFIC, 20, 5, 1, 2, 60, 50, 4000)},
        });
    }
        private TariffFactory factory = IndividualPersonTariffFactory.getInstance();
        private String line;
        private IndividualPersonTariff individualPersonTariff;

        public IndividualPersonTariffFactoryTest(String line, IndividualPersonTariff individualPersonTariff) {
            this.line = line;
            this.individualPersonTariff = individualPersonTariff;
        }
        @Test
        public void createTariffTest(){
            AbstractMobileTariff actual = factory.createTariff(line);
            Assert.assertEquals(individualPersonTariff, actual);
        }
    }
