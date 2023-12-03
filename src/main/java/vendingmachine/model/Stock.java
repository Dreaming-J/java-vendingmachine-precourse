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
        Product product = stock.keySet()
                .stream()
                .filter(o -> Objects.equals(o.name(), name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ORDER_ERROR.toString()));

        validatePop(product, inputAmount);
        stock.put(product, stock.get(product) - 1);
        return product;
    }

    public void validatePop(Product product, Money inputAmount) {
        if (stock.get(product) == 0) {
            throw new IllegalArgumentException(ORDER_ERROR.toString());
        }

        if (product.price().compareTo(inputAmount) > 0) {
            throw new IllegalArgumentException(ORDER_ERROR.toString());
        }
    }

    public boolean isSoldOut() {
        return stock.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum() == 0;
    }

    public Money findMinPrice() {
        return stock.keySet()
                .stream()
                .map(Product::price)
                .min(Comparator.comparing(x -> x))
                .get();
    }
}
