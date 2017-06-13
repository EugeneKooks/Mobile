import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class TariffManager {
    private static final Logger LOGGER = LogManager.getLogger(TariffManager.class);
    private MobileOperator mobileOperator;

    public TariffManager(MobileOperator mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public MobileOperator getMobileOperator() {
        return mobileOperator;
    }

    public int calculateClients() {
        int individualClients = mobileOperator.getClients().size();
        int companiesStuff =0;
        for (Company corp : mobileOperator.getCompanies()) {
            companiesStuff += corp.getWorkers().size();}
        LOGGER.log(Level.INFO, "Total clients quantity is " + (companiesStuff+individualClients));
        return companiesStuff+individualClients;
            }
    public void sortTariffs(Comparator<AbstractMobileTariff>... comparators) {
        ChainedComparator<AbstractMobileTariff> chain = new ChainedComparator<>();
        mobileOperator.getTariffs().sort(chain.getChain(comparators));
    }
}
