package vendingmachine.model;

import static vendingmachine.message.ErrorMsg.AMOUNT_ERROR;

import java.util.Map;

public class CoinBoxGenerator {

    private static final int UNIT_COIN = 10;

    public static CoinBox generateCoinBox(int totalAmount) {
        validate(totalAmount);
        Map<Coin, Integer> coinBox = Coin.createCoinMap();

        do {
            Coin coin = Coin.pickRandomCoin(totalAmount);
            totalAmount -= coin.getAmount();
            coinBox.put(coin, coinBox.getOrDefault(coin, 0) + 1);
        } while (totalAmount > 0);

        return new CoinBox(coinBox);
    }

    private static void validate(int totalAmount) {
        if (totalAmount % UNIT_COIN != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR.toString());
        }
    }
}
