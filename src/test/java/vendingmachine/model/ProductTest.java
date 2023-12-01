package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void 상품_가격_테스트() {
        assertThatThrownBy(() -> new Product("name", 50))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Product("name", 101))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
