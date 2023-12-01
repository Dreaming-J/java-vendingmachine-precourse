package vendingmachine.model;

import static vendingmachine.message.ErrorMsg.AMOUNT_ERROR;

public class Money implements Comparable<Money> {

    private static final int MIN_PRICE = 100;
    private static final int UNIT_PRICE = 10;
    private static final String STRING_FORMAT = "%s원";
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

    @Override
    public String toString() {
        return String.format(STRING_FORMAT, amount);
    }

    @Override
    public int compareTo(Money o) {
        return amount - o.amount;
    }
}
