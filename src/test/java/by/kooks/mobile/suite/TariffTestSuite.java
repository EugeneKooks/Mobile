package by.kooks.mobile.suite;

import by.kooks.mobile.action.TariffActionTest;
import by.kooks.mobile.creator.MobileOperatorCreatorTest;
import by.kooks.mobile.factory.CorporateTariffFactoryTest;
import by.kooks.mobile.factory.IndividualPersonTariffFactoryTest;
import by.kooks.mobile.reader.TariffDataReaderTest;
import by.kooks.mobile.validator.InputDataValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TariffDataReaderTest.class,
        CorporateTariffFactoryTest.class,
        IndividualPersonTariffFactoryTest.class,
        MobileOperatorCreatorTest.class,
        TariffActionTest.class,
        InputDataValidatorTest.class
})
public class TariffTestSuite {
}
