package by.kooks.mobile.action;

import by.kooks.mobile.comparator.ChainedComparator;
import by.kooks.mobile.entity.AbstractMobileTariff;
import by.kooks.mobile.entity.Company;
import by.kooks.mobile.entity.MobileOperator;
import com.sun.media.sound.InvalidDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class TariffAction {
    private static final Logger LOGGER = LogManager.getLogger(TariffAction.class);
    private MobileOperator mobileOperator;

    public TariffAction(MobileOperator mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public MobileOperator getMobileOperator() {
        return mobileOperator;
    }

    public int calculateClients() {
        int individualClients = mobileOperator.getClients().size();
        int companiesStuff = 0;
        for (Company corp : mobileOperator.getCompanies()) {
            companiesStuff += corp.getWorkers().size();}
        LOGGER.log(Level.INFO, "Total clients quantity is " + (companiesStuff+individualClients));
        return companiesStuff+individualClients;
            }
    public void sortTariffs(Comparator<AbstractMobileTariff>... comparators) {
        ChainedComparator<AbstractMobileTariff> chain = new ChainedComparator<>();
        mobileOperator.getAllTariffs().sort(chain.getChain(comparators));
    }
    public AbstractMobileTariff searchOptimalTariff(double minMinutePrice, double maxMinutePrice) throws InvalidDataException {
        for (AbstractMobileTariff tariff : mobileOperator.getAllTariffs()) {
            if (tariff.getMinutePrice() >= minMinutePrice && tariff.getMinutePrice() <= maxMinutePrice) {
                LOGGER.log(Level.INFO, tariff);
                return tariff;
            }
        }
        LOGGER.log(Level.ERROR, "Company doesn't have a tariff with such parameters");
        throw new InvalidDataException("Company doesn't have a tariff with such parameters");
    }
}
