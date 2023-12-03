package vendingmachine.controller;

import static vendingmachine.util.Repeat.repeat;

import vendingmachine.model.CoinBox;
import vendingmachine.model.CoinBoxGenerator;
import vendingmachine.model.Money;
import vendingmachine.model.Stock;
import vendingmachine.model.StockGenerator;
import vendingmachine.model.VendingMachine;
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
        VendingMachine vendingMachine = createVendingMachine();
        buyProduct(vendingMachine);
        quitVendingMachine(vendingMachine);
    }

    private void quitVendingMachine(VendingMachine vendingMachine) {
        outputView.printInputAmount(vendingMachine.getInputAmount());
    }

    private void buyProduct(VendingMachine vendingMachine) {
        while (vendingMachine.isContinue()) {
            repeat(() -> {
                outputView.printInputAmount(vendingMachine.getInputAmount());
                String name = inputView.readNameOfProduct();
                vendingMachine.sellProduct(name);
            });
        }
    }

    private VendingMachine createVendingMachine() {
        CoinBox coinBox = createCoinBox();
        outputView.printCoinBox(coinBox);
        Stock stock = createStock();
        Money inputAmount = createInputAmount();

        return new VendingMachine(coinBox, stock, inputAmount);
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

    private Money createInputAmount() {
        return repeat(() -> {
            int inputAmount = inputView.readInputAmount();
            return new Money(inputAmount);
        });
    }
}
