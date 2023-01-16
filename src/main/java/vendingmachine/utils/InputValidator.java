package vendingmachine.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.enums.ErrorMsg.*;

public class InputValidator {

    private static final int ZERO = 0;
    private static final int MIN_PRICE_OF_PRODUCT = 100;
    private static final int UNIT_PRICE_OF_PRODUCT = 10;

    TypeConverter typeConverter = new TypeConverter();

    public void validateMoney(int money) {
        if (isNotPositive(money)) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_MONEY_IS_POSITIVE.get());
        }
        if (isNotDivided10(money)) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_MONEY_IS_DIVIDED_10.get());
        }
    }

    public void validateProducts(List<List<String>> products) {
        validateProductName(products);

        for (List<String> product : products) {
            if (isNotListSizeThree(product)) {
                throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_PRODUCT_INPUT_SIZE_IS_3.get());
            }
            validateProductPrice(product.get(1));
            validateProductCount(product.get(2));
        }
    }

    private void validateProductName(List<List<String>> products) {
        List<String> name = new ArrayList<>();

        for (List<String> product : products) {
            name.add(product.get(0));
        }

        if (hasDuplicateName(name)) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_PRODUCT_IS_DUPLICATED.get());
        }
    }

    private void validateProductPrice(String price) {
        int convertPrice = typeConverter.StringToInt(price);

        if (isNotPriceOver100(convertPrice)) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_PRODUCT_PRICE_IS_OVER_100.get());
        }
        if (isNotDivided10(convertPrice)) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_MONEY_IS_DIVIDED_10.get());
        }
    }

    private void validateProductCount(String count) {
        int convertCount = typeConverter.StringToInt(count);

        if (isNotPositive(convertCount)) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_PRODUCT_COUNT_IS_OVER_0.get());
        }
    }

    private boolean isNotPositive(int balance) {
        return balance <= ZERO;
    }

    private boolean isNotDivided10(int balance) {
        return balance % UNIT_PRICE_OF_PRODUCT != ZERO;
    }

    private boolean hasDuplicateName(List<String> name) {
        return name.size() != name.stream().distinct().count();
    }

    private boolean isNotListSizeThree(List<String> product) {
        return product.size() != 3;
    }

    private boolean isNotPriceOver100(int price) {
        return price < MIN_PRICE_OF_PRODUCT;
    }
}
