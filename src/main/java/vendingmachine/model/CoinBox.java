package vendingmachine.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.StringJoiner;

public class CoinBox {

    private static final String LINE_BREAK = "\n";
    private static final String STRING_FORMAT = "%s - %d개";
    private final Map<Coin, Integer> coinBox;

    public CoinBox(Map<Coin, Integer> coinBox) {
        this.coinBox = coinBox;
    }

    public CoinBox createChange(Money inputAmount) {
        Map<Coin, Integer> change = new EnumMap<>(Coin.class);

        for (Coin coin : coinBox.keySet()) {
            Money money = new Money(coin);
            while (canPop(coin) & inputAmount.compareTo(money) >= 0) {
                change.put(coin, change.getOrDefault(coin, 0) + 1);
                coinBox.put(coin, coinBox.get(coin) - 1);
                inputAmount.minus(money);
            }
        }

        return new CoinBox(change);
    }

    private boolean canPop(Coin coin) {
        return coinBox.get(coin) != 0;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(LINE_BREAK);
        coinBox.forEach((coin, count) -> stringJoiner.add(String.format(STRING_FORMAT, coin, count)));
        return stringJoiner.toString();
    }
}
