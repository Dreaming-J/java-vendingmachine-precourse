package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static Coin pickRandomCoin(int totalAmount) {
        int amount = Randoms.pickNumberInList(amountsBelowTotalAmount(totalAmount));

        return Stream.of(Coin.values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static List<Integer> amountsBelowTotalAmount(int totalAmount) {
        return Stream.of(Coin.values())
                .map(coin -> coin.amount)
                .filter(amount -> amount <= totalAmount)
                .toList();
    }
}
