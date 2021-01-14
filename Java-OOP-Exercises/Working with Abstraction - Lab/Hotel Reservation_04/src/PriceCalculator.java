public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private DiscountType discountType;

    PriceCalculator(double pricePerDay, int numberOfDays, Season season, DiscountType discountType){
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double getTotalPrice(double pricePerDay, int numberOfDays, Season season, DiscountType discountType){
        return (pricePerDay * numberOfDays * season.getValue()) - ((pricePerDay * numberOfDays * season.getValue()) * (discountType.getPercent() / 100.0));
    }
}
