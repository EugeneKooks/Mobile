import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TariffDataReaderTest.class,
        CorporateTariffFactoryTest.class,
        IndividualPersonTariffFactoryTest.class,
        MobileOperatorCreatorTest.class,
        TariffManagerTest.class,
        InputDataValidatorTest.class
})
public class TariffTestSuite {
}
