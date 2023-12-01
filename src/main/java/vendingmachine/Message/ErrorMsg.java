package vendingmachine.Message;

public enum ErrorMsg {
    CONVERTING_NUMBER_ERROR("유효하지 않은 숫자입니다. 다시 입력해주세요."),
    PRICE_OF_PRODUCT_ERROR("유효하지 않은 가격입니다. 다시 입력해주세요."),
    STOCK_ERROR("유효하지 않은 재고 형식입니다. 다시 입력해주세요.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
