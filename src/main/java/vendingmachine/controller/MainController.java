package vendingmachine.controller;

import vendingmachine.model.Vendingmachine;
import vendingmachine.view.OutputView;

import java.util.List;

public class MainController {

    InputController inputController = new InputController();
    Vendingmachine vendingmachine = new Vendingmachine();
    OutputView outputView = new OutputView();

    public void initMachine() {
        int balance = inputController.inputBalance();
        vendingmachine.divideBalnceToCoin(balance);
        outputView.printHoldingCoins();

        List<List<String>> products = inputController.inputProducts();
        vendingmachine.createProducts(products);

        accessUser();
    }

    public void accessUser() {
        int change = inputController.inputChange();
        vendingmachine.setChange(change);

        checkSellAvailable();
        returnChange();
    }

    public void checkSellAvailable() {
        if (vendingmachine.canSelling()) {
            startSelling();
        }
    }

    public void startSelling() {
        try {
            outputView.printChange(vendingmachine.getChange());
            String purchase = inputController.inputPuchase();
            vendingmachine.validateProductCanSale(purchase);

            sellingProcess(purchase);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startSelling();
        }
    }

    public void sellingProcess(String purchase) {
        vendingmachine.sellProduct(purchase);

        checkSellAvailable();
    }

    public void returnChange() {
        vendingmachine.changeToCoin();
        outputView.printChange(vendingmachine.getChange());
        outputView.printChangeToCoin();
    }
}
