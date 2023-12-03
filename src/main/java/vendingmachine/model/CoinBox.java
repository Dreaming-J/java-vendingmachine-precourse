package vendingmachine.model;

import java.util.Map;
import java.util.StringJoiner;

public class CoinBox {

    private static final String LINE_BREAK = "\n";
    private static final String STRING_FORMAT = "%s - %d개";
    private final Map<Coin, Integer> coinBox;

    public CoinBox(Map<Coin, Integer> coinBox) {
        this.coinBox = coinBox;
    }

    public void trim() {
        coinBox.forEach((coin, count) -> {
            if (count == 0) {
                coinBox.remove(coin);
            }
        });
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(LINE_BREAK);
        coinBox.forEach((coin, count) -> stringJoiner.add(String.format(STRING_FORMAT, coin, count)));
        return stringJoiner.toString();
    }
}
