package vendingmachine.message;

public enum ViewMsg {
    PRINT_ERROR("[ERROR] %s%n"),
    READ_VENDING_MACHINE_AMOUNT("자판기가 보유하고 있는 금액을 입력해 주세요."),
    PRINT_COIN_BOX("자판기가 보유한 동전"),
    READ_STOCK("상품명과 가격, 수량을 입력해 주세요."),
    READ_INPUT_AMOUNT("투입 금액을 입력해 주세요."),
    PRINT_INPUT_AMOUNT("투입 금액: %s"),
    PRINT_NAME_OF_PRODUCT("구매할 상품명을 입력해 주세요."),
    PRINT_CHANGE("잔돈");

    private static final String LINE_BREAK = "\n";
    private final String message;

    ViewMsg(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        if (this == PRINT_ERROR) {
            return message;
        }

        return LINE_BREAK + message;
    }
}
