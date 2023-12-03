package vendingmachine.view;

import static vendingmachine.message.ViewMsg.PRINT_COIN_BOX;
import static vendingmachine.message.ViewMsg.PRINT_ERROR;
import static vendingmachine.message.ViewMsg.PRINT_INPUT_AMOUNT;

import vendingmachine.model.CoinBox;
import vendingmachine.model.Money;

public class OutputView {

    public static void printError(String error) {
        System.out.printf(PRINT_ERROR.toString(), error);
    }

    public void printCoinBox(CoinBox coinBox) {
        System.out.println(PRINT_COIN_BOX);
        System.out.println(coinBox);
    }

    public void printInputAmount(Money inputAmount) {
        System.out.printf(PRINT_INPUT_AMOUNT.toString(), inputAmount);
    }
}
