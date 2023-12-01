package vendingmachine.model;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CoinGeneratorTest {

    @Test
    void 코인_생성_테스트() {
        List<Coin> coins = CoinGenerator.generateRandomCoins(100);
        System.out.println(coins);
    }
}
