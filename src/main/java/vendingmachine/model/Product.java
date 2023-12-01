package vendingmachine.model;

import static vendingmachine.message.ErrorMsg.PRICE_OF_PRODUCT_ERROR;

public record Product(String name, int price) {

    private static final int MIN_PRICE = 100;
    private static final int UNIT_PRICE = 10;

    public Product {
        validate(price);
    }

    private void validate(int price) {
        if (price < MIN_PRICE || price % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_OF_PRODUCT_ERROR.toString());
        }
    }
}
