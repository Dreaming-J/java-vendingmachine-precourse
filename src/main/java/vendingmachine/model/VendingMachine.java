package vendingmachine.model;

public class VendingMachine {

    private final CoinBox coinBox;
    private final Stock stock;
    private final Money inputAmount;

    public VendingMachine(CoinBox coinBox, Stock stock, Money inputAmount) {
        this.coinBox = coinBox;
        this.stock = stock;
        this.inputAmount = inputAmount;
    }

    public Product buyProduct(String name) {
        Product product = stock.pop(name, inputAmount);
        inputAmount.minus(product.price());
        return product;
    }

    public boolean isOver() {
        return stock.isSoldOut() || cantBuy();
    }

    private boolean cantBuy() {
        return stock.findWithMinPrice()
                .cantBuy(inputAmount);
    }

    public CoinBox getChange() {
        return coinBox.createChange(inputAmount);
    }
}
