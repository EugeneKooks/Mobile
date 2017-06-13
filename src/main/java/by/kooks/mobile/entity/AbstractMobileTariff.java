public abstract class AbstractMobileTariff {
    private TariffType tariffType;
    private int minutePrice;
    private int messagePrice;
    private int subscriptionPrice;
    private int megabytePrice;
    AbstractMobileTariff(TariffType tariffType , int minutePrice, int messagePrice, int subscriptionPrice, int
            megabytePrice) {
        this.tariffType = tariffType;
        this.minutePrice = minutePrice;
        this.messagePrice = messagePrice;
        this.subscriptionPrice = subscriptionPrice;
        this.megabytePrice = megabytePrice;
    }
    public TariffType getTariffType() {
        return tariffType;
    }
    public int getMinutePrice(){
        return minutePrice;
    }
    public int getMessagePrice(){
        return messagePrice;
    }
    public int getSubscriptionPrice() {
        return subscriptionPrice;
    }
    public int getMegabytePrice() {
        return megabytePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractMobileTariff)) return false;

        AbstractMobileTariff that = (AbstractMobileTariff) o;

        if (getMinutePrice() != that.getMinutePrice()) return false;
        if (getMessagePrice() != that.getMessagePrice()) return false;
        if (getSubscriptionPrice() != that.getSubscriptionPrice()) return false;
        if (getMegabytePrice() != that.getMegabytePrice()) return false;
        return getTariffType() == that.getTariffType();
    }

    @Override
    public int hashCode() {
        int result = getTariffType().hashCode();
        result = 31 * result + getMinutePrice();
        result = 31 * result + getMessagePrice();
        result = 31 * result + getSubscriptionPrice();
        result = 31 * result + getMegabytePrice();
        return result;
    }
}
