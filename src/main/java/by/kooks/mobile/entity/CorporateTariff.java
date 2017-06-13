public class CorporateTariff extends AbstractMobileTariff {
    private int includedFreeMinutes;
    private int includedFreeMessages;
    private int includedFreeMegabytes;
    private String owner;
    public CorporateTariff(TariffType tariffType,int subscriptionFee, int minutePrice,int megabytePrice, int messagePrice,
                            int includedFreeMinutes, int includedFreeMessages,
                           int includedFreeMegabytes, String owner) {
        super(tariffType, subscriptionFee,minutePrice,  megabytePrice, messagePrice);
        this.includedFreeMinutes = includedFreeMinutes;
        this.includedFreeMessages = includedFreeMessages;
        this.includedFreeMegabytes = includedFreeMegabytes;
        this.owner = owner;
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
    public String getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CorporateTariff)) return false;
        if (!super.equals(o)) return false;

        CorporateTariff that = (CorporateTariff) o;

        if (getIncludedFreeMinutes() != that.getIncludedFreeMinutes()) return false;
        if (getIncludedFreeMessages() != that.getIncludedFreeMessages()) return false;
        if (getIncludedFreeMegabytes() != that.getIncludedFreeMegabytes()) return false;
        return getOwner() != null ? getOwner().equals(that.getOwner()) : that.getOwner() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getIncludedFreeMinutes();
        result = 31 * result + getIncludedFreeMessages();
        result = 31 * result + getIncludedFreeMegabytes();
        result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%nTariff name: %s %nprice per minute: %d %nprice per message: %d %nprice for connection: %d %n" +
                        "included free minutes: %d %nincluded free messages: %d %nincluded free traffic: %d %owner is: %d", getTariffType(), getMinutePrice(),
                getMessagePrice(), getSubscriptionPrice(), includedFreeMinutes, includedFreeMessages,includedFreeMegabytes,owner);
}}
