package by.kooks.mobile.entity;

public class IndividualPersonTariff extends AbstractMobileTariff {
    private int includedFreeMinutes;
    private int includedFreeMessages;
    private int includedFreeMegabytes;

    public IndividualPersonTariff(TariffType tariffType, int subscriptionFee, int minutePrice, int
            megabytePrice, int messagePrice, int includedFreeMinutes, int includedFreeMessages, int includedFreeMegabytes) {
        super(tariffType, subscriptionFee,minutePrice, messagePrice,  megabytePrice);
        this.includedFreeMinutes = includedFreeMinutes;
        this.includedFreeMessages = includedFreeMessages;
        this.includedFreeMegabytes = includedFreeMegabytes;
    }

    public int getIncludedFreeMinutes() {
        return includedFreeMinutes;
    }

    public int getIncludedFreeMessages() {
        return includedFreeMessages;
    }

    public int getIncludedFreeMegabytes() {
        return includedFreeMegabytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IndividualPersonTariff)) return false;
        if (!super.equals(o)) return false;

        IndividualPersonTariff that = (IndividualPersonTariff) o;

        if (getIncludedFreeMinutes() != that.getIncludedFreeMinutes()) return false;
        if (getIncludedFreeMessages() != that.getIncludedFreeMessages()) return false;
        return !(getIncludedFreeMegabytes() != that.getIncludedFreeMegabytes());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getIncludedFreeMinutes();
        result = 31 * result + getIncludedFreeMessages();
        result = 31 * result + getIncludedFreeMegabytes();
        return result;
    }
    @Override
    public String toString() {
        return String.format("%nTariff name: %s  %nprice for subscription: %d %nprice per minute: %d %nprice per message: %d %nprice per megabyte: %d" +
                        "%nincluded free minutes: %d %nincluded free messages: %d %nincluded free traffic: %d", getTariffType(), getSubscriptionPrice(), getMinutePrice(),
                getMessagePrice(),getMegabytePrice(), includedFreeMinutes, includedFreeMessages,includedFreeMegabytes);
    }
    }

