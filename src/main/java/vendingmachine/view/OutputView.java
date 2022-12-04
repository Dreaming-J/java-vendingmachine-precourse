package vendingmachine.view;

import vendingmachine.model.Coin;

import java.util.List;

import static vendingmachine.enums.OutputMsg.*;

public class OutputView {

    public void printHoldingCoins() {
        System.out.println("\n" + OUTPUT_MSG_HOLDING_COINS_OF_VENDINGMACHINE.get());
        for (Coin coin : Coin.values()) {
            System.out.println(coin.getAmount() + WON.get() + HYPON.get() + coin.getCount() + COUNT.get());
        }
    }

    public void printChange(int change) {
        System.out.println("\n" + OUTPUT_MSG_CHANGE.get() + change + WON.get());
    }

    public void printChangeToCoin() {
        System.out.println(CHANGE.get());

        List<Coin> changeCoinList = Coin.getCoinListWithCountOverZero();
        for (Coin coin : changeCoinList) {
            System.out.println(coin.getAmount() + WON.get() + HYPON.get() + coin.getChange() + COUNT.get());
        }
    }
}
