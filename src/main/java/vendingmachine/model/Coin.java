package vendingmachine.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final int ZERO = 0;

    private final int amount;
    private int count;
    private int change;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getCount() {
        return this.count;
    }

    public int getChange() {
        return this.change;
    }

    public void plusCount() {
        this.count++;
    }

    public void minusCount() {
        this.count--;
    }

    public void plusChange() {
        this.change++;
    }

    public static List<Integer> getAmountListBelowInputValue(int value) {
        return Stream.of(values())
                .filter(coin -> coin.amount <= value)
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    public static Coin getCoinByMatchingAmount(int value) {
        return Stream.of(values())
                .filter(coin -> coin.amount == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<Coin> getCoinListWithCountOverZero() {
        return Stream.of(values())
                .filter(coin -> coin.change > ZERO)
                .collect(Collectors.toList());
    }
}
