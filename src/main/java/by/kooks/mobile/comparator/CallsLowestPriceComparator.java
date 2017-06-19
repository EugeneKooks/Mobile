package by.kooks.mobile.comparator;

import by.kooks.mobile.entity.AbstractMobileTariff;

import java.util.Comparator;

public class CallsLowestPriceComparator implements Comparator<AbstractMobileTariff> {
    @Override
    public int compare(AbstractMobileTariff firstTariff, AbstractMobileTariff secondTariff) {
        return firstTariff.getMinutePrice() > secondTariff.getMinutePrice()? 1: firstTariff.getMinutePrice() < secondTariff.getMinutePrice()? -1 : 0;
    }
}