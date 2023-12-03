package vendingmachine.controller;

import static vendingmachine.util.Repeat.repeat;

import vendingmachine.model.CoinBox;
import vendingmachine.model.CoinBoxGenerator;
import vendingmachine.model.Stock;
import vendingmachine.model.StockGenerator;
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
        CoinBox coinBox = createCoinBox();
        outputView.printCoinBox(coinBox);
        Stock stock = createStock();
    }

    private CoinBox createCoinBox() {
        return repeat(() -> {
            int amount = inputView.readVendingMachineAmount();
            return CoinBoxGenerator.generateCoinBox(amount);
        });
    }

    private Stock createStock() {
        return repeat(() -> {
            String productDatas = inputView.readStock();
            return StockGenerator.generateStock(productDatas);
        });
    }
}
