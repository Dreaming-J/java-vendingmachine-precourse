package vendingmachine.model;

import static vendingmachine.message.ErrorMsg.ORDER_ERROR;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class Stock {

    private final Map<Product, Integer> stock;

    public Stock(Map<Product, Integer> stock) {
        this.stock = stock;
    }

    public Product pop(String name, Money inputAmount) {
        Product product = findProduct(name);
        validatePop(product, inputAmount);
        return pop(product);
    }

    private Product pop(Product product) {
        stock.put(product, stock.get(product) - 1);

        if (stock.get(product) == 0) {
            stock.remove(product);
        }

        return product;
    }

    private Product findProduct(String name) {
        return stock.keySet()
                .stream()
                .filter(o -> Objects.equals(o.name(), name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ORDER_ERROR.toString()));
    }

    private void validatePop(Product product, Money inputAmount) {
        if (stock.get(product) == 0) {
            throw new IllegalArgumentException(ORDER_ERROR.toString());
        }

        if (product.cantBuy(inputAmount)) {
            throw new IllegalArgumentException(ORDER_ERROR.toString());
        }
    }

    public boolean isSoldOut() {
        return stock.keySet()
                .isEmpty();
    }

    public Product findWithMinPrice() {
        return stock.keySet()
                .stream()
                .min(Comparator.comparing(Product::price))
                .get();
    }
}
