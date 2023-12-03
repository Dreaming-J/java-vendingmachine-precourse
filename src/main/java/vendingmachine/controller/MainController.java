package vendingmachine.controller;

import static vendingmachine.util.Repeat.repeat;

import vendingmachine.model.CoinBox;
import vendingmachine.model.CoinBoxGenerator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        createVendingMachine();
    }

    private void createVendingMachine() {
        CoinBox coinBox = repeat(() -> {
            int amount = inputView.readVendingMachineAmount();
            return CoinBoxGenerator.generateCoinBox(amount);
        });
        outputView.printCoinBox(coinBox);
    }
}
