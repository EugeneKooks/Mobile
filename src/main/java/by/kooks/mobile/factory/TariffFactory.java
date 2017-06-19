package by.kooks.mobile.factory;

import by.kooks.mobile.entity.AbstractMobileTariff;

public abstract class TariffFactory<T extends AbstractMobileTariff> {

    public abstract T createTariff(String line);
}