import java.util.Comparator;

public class SubscriptionLowestPriceComparator implements Comparator<AbstractMobileTariff> {
    @Override
    public int compare(AbstractMobileTariff firstTariff, AbstractMobileTariff secondTariff) {
        return firstTariff.getSubscriptionPrice() < secondTariff.getSubscriptionPrice()? 1: firstTariff.getSubscriptionPrice() > secondTariff.getSubscriptionPrice()? -1 : 0;
    }
}