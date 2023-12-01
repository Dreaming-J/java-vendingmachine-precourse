package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StockGeneratorTest {

    @ParameterizedTest(name = "[{index}] {0}")
    @ValueSource(strings = {
            "[콜라,1500,]",
            "[콜라,,10]",
            "[,1500,10]",
            "(콜라,1500,10)",
            "[콜라,1500,10],[사이다:1000,20]",
            "[콜라,1500,0]",
            "[콜라,50,1]",
            "[콜라,101,1]"})
    void 재고_생성_테스트(String data) {
        assertThatThrownBy(() -> StockGenerator.generateStock(data))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
