package by.kooks.mobile.factory;

import by.kooks.mobile.entity.IndividualPersonTariff;
import by.kooks.mobile.entity.TariffType;

public class IndividualPersonTariffFactory extends TariffFactory<IndividualPersonTariff> {
    private static IndividualPersonTariffFactory factory = new IndividualPersonTariffFactory();
    private IndividualPersonTariffFactory(){}
    public static IndividualPersonTariffFactory getInstance() {
        return factory;
    }
        public IndividualPersonTariff createTariff(String line) {
        String[] tariff = line.split(" ");
        TariffType tariffType = TariffType.valueOf(tariff[1].toUpperCase());
        int minutePrice = Integer.parseInt(tariff[2]);
        int messagePrice = Integer.parseInt(tariff[3]);
        int connectionPrice = Integer.parseInt(tariff[4]);
        int megabytePrice = Integer.parseInt(tariff[5]);
        int includedFreeMinutes = Integer.parseInt(tariff[6]);
        int includedFreeMessages = Integer.parseInt(tariff[7]);
        int includedFreeMegabytes = Integer.parseInt(tariff[8]);
        return new IndividualPersonTariff(tariffType, minutePrice, messagePrice, connectionPrice, megabytePrice, includedFreeMinutes, includedFreeMessages, includedFreeMegabytes );
    }
}

