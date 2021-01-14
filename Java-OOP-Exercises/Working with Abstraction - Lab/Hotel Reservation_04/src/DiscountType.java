public enum DiscountType {
    VIP(20),
    SecondVisit(10),
    None(0);

    private int percent;

    DiscountType(int percent){
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}
