public class CorporateTariffFactory extends TariffFactory<CorporateTariff>{
    private static CorporateTariffFactory factory = new CorporateTariffFactory();
    private CorporateTariffFactory(){}

    public static CorporateTariffFactory getInstance() {
        return factory;
    }
    public CorporateTariff createTariff(String line) {
        String[] tariff = line.split("\\s");
        TariffType tariffType = TariffType.stringToName(tariff[1]);
        int minutePrice = Integer.parseInt(tariff[2]);
        int messagePrice = Integer.parseInt(tariff[3]);
        int connectionPrice = Integer.parseInt(tariff[4]);
        int megabytePrice = Integer.parseInt(tariff[5]);
        int includedFreeMinutes = Integer.parseInt(tariff[6]);
        int includedFreeMessages = Integer.parseInt(tariff[7]);
        int includedFreeMegabytes = Integer.parseInt(tariff[8]);
        String owner = tariff[9];

        return new CorporateTariff(tariffType, minutePrice, messagePrice, connectionPrice, megabytePrice, includedFreeMinutes, includedFreeMessages, includedFreeMegabytes, owner );
    }
}
