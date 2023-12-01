package vendingmachine.Message;

public enum ErrorMsg {
    PRICE_OF_PRODUCT_ERROR("유효하지 않은 가격입니다. 다시 입력해주세요.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
