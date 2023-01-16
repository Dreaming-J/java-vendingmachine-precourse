package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static vendingmachine.enums.ErrorMsg.ERROR_PREFIX;
import static vendingmachine.enums.ErrorMsg.ERROR_MSG_PRODUCT_IS_NOT_IN_CATALOG;
import static vendingmachine.enums.ErrorMsg.ERROR_MSG_PRODUCT_HAS_NOT_STOCK;
import static vendingmachine.enums.ErrorMsg.ERROR_MSG_PRODUCT_IS_OVER_CHANGE;

public class Vendingmachine {

    private static final int ZERO = 0;

    private List<String> nameProduct = new ArrayList<>();
    private List<Integer> priceProduct = new ArrayList<>();
    private List<Integer> countProduct = new ArrayList<>();
    private int change;

    public void divideBalnceToCoin(int balance) {
        do {
            int coin = Randoms.pickNumberInList(Coin.getAmountListBelowInputValue(balance));
            balance -= coin;
            Coin.getCoinByMatchingAmount(coin).plusCount();
        } while (balance > ZERO);
    }

    public void createProducts(List<List<String>> products) {
        for (List<String> product : products) {
            nameProduct.add(product.get(0));
            priceProduct.add(Integer.parseInt(product.get(1)));
            countProduct.add(Integer.parseInt(product.get(2)));
        }
    }

    public void sellProduct(String product) {
        int indexProduct = nameProduct.indexOf(product);
        change -= priceProduct.get(indexProduct);
        countProduct.set(indexProduct, countProduct.get(indexProduct) - 1);
    }

    public boolean canSelling() {
        int totalStockAvailable = 0;

        for (int i = 0; i < nameProduct.size(); i++) {
            if (priceProduct.get(i) <= change) {
                totalStockAvailable += countProduct.get(i);
            }
        }

        return totalStockAvailable > ZERO;
    }

    public void validateProductCanSale(String product) {
        int indexProduct = nameProduct.indexOf(product);
        if (!nameProduct.contains(product)) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_PRODUCT_IS_NOT_IN_CATALOG.get());
        }
        if (this.countProduct.get(indexProduct) == ZERO) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_PRODUCT_HAS_NOT_STOCK.get());
        }
        if (this.priceProduct.get(indexProduct) > change) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_PRODUCT_IS_OVER_CHANGE.get());
        }
    }

    public void changeToCoin() {
        int remainChange = this.change;
        for (Coin coin : Coin.values()) {
            while (coin.getAmount() <= remainChange && coin.getCount() > ZERO) {
                coin.plusChange();
                coin.minusCount();
                remainChange -= coin.getAmount();
            }
        }
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getChange() {
        return this.change;
    }
}
