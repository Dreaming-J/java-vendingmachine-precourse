package vendingmachine.model;

import org.junit.jupiter.api.Test;

public class CoinBoxGeneratorTest {

    @Test
    void 코인_생성_테스트() {
        CoinBox coinBox = CoinBoxGenerator.generateCoinBox(100);
        System.out.println(coinBox);
        System.out.println("\n" + coinBox.createChange(new Money(230)));
    }
}
