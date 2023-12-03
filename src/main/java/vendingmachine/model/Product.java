package vendingmachine.model;

public record Product(String name, Money price) {

    public boolean cantBuy(Money amount) {
        return price().compareTo(amount) > 0;
    }
}
