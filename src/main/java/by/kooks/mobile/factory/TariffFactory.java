public abstract class TariffFactory<T extends AbstractMobileTariff> {

    public abstract T createTariff(String line);
}