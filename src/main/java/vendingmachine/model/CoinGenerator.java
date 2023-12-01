package vendingmachine.model;

import static vendingmachine.message.ErrorMsg.AMOUNT_ERROR;

import java.util.ArrayList;
import java.util.List;

public class CoinGenerator {

    private static final int UNIT_COIN = 10;

    public static List<Coin> generateRandomCoins(int totalAmount) {
        validate(totalAmount);
        List<Coin> coins = new ArrayList<>();

        do {
            Coin coin = Coin.pickRandomCoin(totalAmount);
            totalAmount -= coin.getAmount();
            coins.add(coin);
        } while (totalAmount > 0);

        return coins.stream()
                .sorted()
                .toList();
    }

    private static void validate(int totalAmount) {
        if (totalAmount % UNIT_COIN != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR.toString());
        }
    }
}
