public class DecreaseProductPriceCommand implements Command{
    private final Product product;
    private final int amount;

    public DecreaseProductPriceCommand(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public void executeAction() {
        this.product.decreasePrice(this.amount);
        System.out.print(String.format("The price for the %s has been decreased by %d$.%n",
                this.product.getName(), this.amount));
    }
}
