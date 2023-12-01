package vendingmachine.model;

import static vendingmachine.message.ErrorMsg.ORDER_ERROR;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VendingMachine {

    private final List<Coin> coins;
    private final Map<Product, Integer> stock;
    private final Money inputAmount;

    public VendingMachine(List<Coin> coins, Map<Product, Integer> stock, Money inputAmount) {
        this.coins = coins;
        this.stock = stock;
        this.inputAmount = inputAmount;
    }

    public Money getInputAmount() {
        return inputAmount;
    }

    public Product buyProduct(String name) {
        Product product = findProduct(name);

        if (product.price().compareTo(inputAmount) > 0) {
            throw new IllegalArgumentException(ORDER_ERROR.toString());
        }

        stock.put(product, stock.get(product) - 1);
        return product;
    }

    private Product findProduct(String name) {
        return stock.keySet()
                .stream()
                .filter(product -> Objects.equals(product.name(), name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ORDER_ERROR.toString()));
    }
}
