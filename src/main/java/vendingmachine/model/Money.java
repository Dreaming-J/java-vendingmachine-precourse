package vendingmachine.model;

import static vendingmachine.message.ErrorMsg.AMOUNT_ERROR;

public class Money {

    private static final int MIN_PRICE = 100;
    private static final int UNIT_PRICE = 10;
    private int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < MIN_PRICE || amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR.toString());
        }
    }

    public int getAmount() {
        return amount;
    }

    public void minus(int amount) {
        this.amount -= amount;
    }
}
