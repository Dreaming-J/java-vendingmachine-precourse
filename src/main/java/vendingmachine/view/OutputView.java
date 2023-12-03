package vendingmachine.view;

import static vendingmachine.message.ViewMsg.PRINT_COIN_BOX;

import vendingmachine.model.CoinBox;

public class OutputView {

    public static void printError(String error) {
        System.out.printf("[ERROR] %s%n", error);
    }

    public void printCoinBox(CoinBox coinBox) {
        System.out.println(PRINT_COIN_BOX);
        System.out.println(coinBox);
    }
}
