package vendingmachine.controller;

import static vendingmachine.util.Repeat.repeat;

import vendingmachine.model.CoinBox;
import vendingmachine.model.CoinBoxGenerator;
import vendingmachine.view.InputView;

public class MainController {

    private final InputView inputView;

    public MainController() {
        inputView = new InputView();
    }

    public void start() {
        createVendingMachine();
    }

    private void createVendingMachine() {
        CoinBox coinBox = repeat(() -> {
            int amount = inputView.readVendingMachineAmount();
            return CoinBoxGenerator.generateCoinBox(amount);
        });
        
    }
}
