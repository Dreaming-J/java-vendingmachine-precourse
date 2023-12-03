package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VendingMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"300,환타", "100,콜라"})
    void 상품_구매_테스트(int amount, String name) {
        CoinBox coinBox = CoinBoxGenerator.generateCoinBox(300);
        Stock stock = StockGenerator.generateStock("[콜라,200,2];[사이다,100,1]");
        Money inputAmount = new Money(amount);
        VendingMachine vendingMachine = new VendingMachine(coinBox, stock, inputAmount);

        assertThatThrownBy(() -> vendingMachine.sellProduct(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"[콜라,200,2];[사이다,500,1]-300-콜라", "[콜라,200,1]-1000-콜라"}, delimiter = '-')
    void 구매_종료_테스트(String productDatas, int amount, String name) {
        CoinBox coinBox = CoinBoxGenerator.generateCoinBox(300);
        Stock stock = StockGenerator.generateStock(productDatas);
        Money inputAmount = new Money(amount);
        VendingMachine vendingMachine = new VendingMachine(coinBox, stock, inputAmount);

        vendingMachine.sellProduct(name);
        assertFalse(vendingMachine.isContinue());
    }
}
