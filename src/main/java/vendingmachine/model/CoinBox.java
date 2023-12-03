package vendingmachine.model;

import java.util.Map;
import java.util.StringJoiner;

public class CoinBox {

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
        StringJoiner stringJoiner = new StringJoiner("\n");
        coinBox.forEach((coin, count) -> stringJoiner.add(String.format("%s - %d개", coin, count)));
        return stringJoiner.toString();
    }
}
