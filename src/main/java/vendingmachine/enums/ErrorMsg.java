package vendingmachine.enums;

public enum ErrorMsg {
    ERROR_PREFIX("[ERROR] "),
    ERROR_MSG_MONEY_IS_INTEGER("숫자를 입력해주세요."),
    ERROR_MSG_MONEY_IS_POSITIVE("양수를 입력해주세요."),
    ERROR_MSG_MONEY_IS_DIVIDED_10("10으로 나누어 떨어지는 숫자를 입력해주세요."),
    ERROR_MSG_PRODUCT_INPUT_SIZE_IS_3("각 상품의 상품명, 가격, 수량만 입력해주세요."),
    ERROR_MSG_PRODUCT_PRICE_IS_OVER_100("각 상품의 가격은 100원 이상으로 입력해주세요."),
    ERROR_MSG_PRODUCT_COUNT_IS_OVER_0("각 상품의 수량은 최소 1개 이상으로 입력해주세요."),
    ERROR_MSG_PRODUCT_IS_NOT_IN_CATALOG("해당 상품은 판매하지 않습니다."),
    ERROR_MSG_PRODUCT_HAS_NOT_STOCK("해당 상품은 재고가 존재하지 않습니다."),
    ERROR_MSG_PRODUCT_IS_OVER_CHANGE("해당 상품을 구입하기에 비용이 부족합니다."),
    ERROR_MSG_PRODUCT_IS_DUPLICATED("동일한 상품명은 가능하지 않습니다.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
