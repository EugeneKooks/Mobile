package by.kooks.mobile.comparator;

import by.kooks.mobile.entity.AbstractMobileTariff;

import java.util.Comparator;

public class TrafficLowestPriceComparator implements Comparator<AbstractMobileTariff> {
    @Override
    public int compare(AbstractMobileTariff firstTariff, AbstractMobileTariff secondTariff) {
        return firstTariff.getMegabytePrice() > secondTariff.getMegabytePrice()? 1: firstTariff.getMegabytePrice() < secondTariff.getMegabytePrice()? -1 : 0;
    }
}