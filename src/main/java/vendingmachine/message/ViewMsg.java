package vendingmachine.message;

public enum ViewMsg {
    PRINT_ERROR(false, "[ERROR] %s%n"),
    READ_VENDING_MACHINE_AMOUNT(false, "자판기가 보유하고 있는 금액을 입력해 주세요."),
    PRINT_COIN_BOX(true, "자판기가 보유한 동전"),
    READ_STOCK(true, "상품명과 가격, 수량을 입력해 주세요."),
    READ_INPUT_AMOUNT(true, "투입 금액을 입력해 주세요."),
    PRINT_INPUT_AMOUNT(true, "투입금액: %s"),
    PRINT_NAME_OF_PRODUCT(true, "구매할 상품명을 입력해 주세요.");

    private static final String LINE_BREAK = "\n";
    private final boolean isLineBreak;
    private final String message;

    ViewMsg(boolean isLineBreak, String message) {
        this.isLineBreak = isLineBreak;
        this.message = message;
    }

    @Override
    public String toString() {
        if (isLineBreak) {
            return LINE_BREAK + message;
        }

        return message;
    }
}
