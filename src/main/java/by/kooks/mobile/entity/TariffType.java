import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum  TariffType {

    MORE_TRAFFIC, MORE_CALLS, MIXED, IN_CORPORATION_FREE, SMALL_BUSINESS, INTERNATIONAL_BUSINESS, TARIFF;
    private static Logger logger = LogManager.getLogger(TariffType.class);

    public static TariffType stringToName(String name) {
        try {
            return TariffType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARN, "Incorrect tariff name\n:" + name + ". Set by default.");
            return TariffType.TARIFF;
        }
    }
}
