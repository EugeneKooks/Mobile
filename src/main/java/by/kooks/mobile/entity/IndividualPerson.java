package by.kooks.mobile.entity;

public class IndividualPerson {
    private AbstractMobileTariff tariff;
    private String number;
    public AbstractMobileTariff getTariff() {
        return tariff;
    }
    public String getNumber() {
        return number;
    }
    public void setTariff(AbstractMobileTariff tariff) {
        this.tariff = tariff;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
