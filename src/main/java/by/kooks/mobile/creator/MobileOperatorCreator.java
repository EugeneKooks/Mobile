package by.kooks.mobile.creator;

import by.kooks.mobile.entity.AbstractMobileTariff;
import by.kooks.mobile.entity.MobileOperator;
import by.kooks.mobile.factory.CorporateTariffFactory;
import by.kooks.mobile.factory.IndividualPersonTariffFactory;

import java.util.ArrayList;

public class MobileOperatorCreator {
    public MobileOperator createOperator(ArrayList<String> tariffs) {
        MobileOperator operator = new MobileOperator();
        for (String tariff : tariffs) {
            if (tariff.substring(0, tariff.indexOf(" ")).equals("corporate")) {
                AbstractMobileTariff corporateTariff = CorporateTariffFactory.getInstance().createTariff(tariff);
                operator.addTariff(corporateTariff);
            } else {
                AbstractMobileTariff individualPersonTariff = IndividualPersonTariffFactory.getInstance().createTariff(tariff);
                operator.addTariff(individualPersonTariff);
            }
        }
        return operator;
    }
}
