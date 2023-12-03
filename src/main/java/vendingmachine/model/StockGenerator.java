package vendingmachine.model;

import static vendingmachine.message.ErrorMsg.STOCK_ERROR;
import static vendingmachine.util.TypeConverter.toInt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StockGenerator {

    private static final String SEMI_COLON = ";";
    private static final String COMMA = ",";
    private static final String REGEX = "^(\\[[가-힣]+,[0-9]+,[1-9]{1}[0-9]*\\])(;\\[[가-힣]+,[0-9]+,[1-9]{1}[0-9]*\\])*$";

    public static Stock generateStock(String productDatas) {
        validate(productDatas);

        Map<Product, Integer> stock = new HashMap<>();
        for (List<String> productData : manufactureProducts(productDatas)) {
            String name = productData.get(0);
            Money price = new Money(toInt(productData.get(1)));
            int quantity = toInt(productData.get(2));

            stock.put(new Product(name, price), quantity);
        }

        return new Stock(stock);
    }

    private static void validate(String productDatas) {
        if (!Pattern.matches(REGEX, productDatas)) {
            throw new IllegalArgumentException(STOCK_ERROR.toString());
        }
    }

    private static List<List<String>> manufactureProducts(String productDatas) {
        return Stream.of(productDatas.split(SEMI_COLON))
                .map(StockGenerator::manufactureProduct)
                .toList();
    }

    private static List<String> manufactureProduct(String productData) {
        productData = productData.substring(1, productData.length() - 1);
        return List.of(productData.split(COMMA));
    }
}
