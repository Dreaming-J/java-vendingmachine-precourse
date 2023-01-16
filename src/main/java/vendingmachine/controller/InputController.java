package vendingmachine.controller;

import vendingmachine.utils.InputValidator;
import vendingmachine.view.InputView;

import java.util.List;

public class InputController {

    private final InputValidator inputValidator = new InputValidator();
    private final InputView inputView = new InputView();

    public int inputBalance() {
        try {
            int balance = inputView.readBalance();
            inputValidator.validateMoney(balance);

            return balance;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return inputBalance();
        }
    }

    public List<List<String>> inputProducts() {
        try {
            List<List<String>> products = inputView.readProducts();
            inputValidator.validateProducts(products);

            return products;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputProducts();
        }
    }

    public int inputChange() {
        try {
            int change = inputView.readChange();
            inputValidator.validateMoney(change);

            return change;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputChange();
        }
    }

    public String inputPuchase() {
        return inputView.readPurchase();
    }
}
