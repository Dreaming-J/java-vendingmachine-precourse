package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String STRING_FORMAT = "%d원";
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static Coin pickRandomCoin(int totalAmount) {
        int amount = Randoms.pickNumberInList(amountsBelowTotalAmount(totalAmount));

        return Stream.of(values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static List<Integer> amountsBelowTotalAmount(int totalAmount) {
        return Stream.of(values())
                .map(coin -> coin.amount)
                .filter(amount -> amount <= totalAmount)
                .toList();
    }

    public static Map<Coin, Integer> createCoinMap() {
        Map<Coin, Integer> coinMap = new EnumMap<>(Coin.class);

        Stream.of(values())
                .forEach(coin -> coinMap.put(coin, 0));

        return coinMap;
    }

    @Override
    public String toString() {
        return String.format(STRING_FORMAT, amount);
    }
}
