package vendingmachine.enums;

public enum InputMsg {
    INPUT_MSG_VENDINGMACHINE_BALANCE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_MSG_PRODUCTS_INFORMATION("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_MSG_CHANGE("투입 금액을 입력해 주세요."),
    INPUT_MSG_PURCHASE("구매할 상품명을 입력해 주세요.");

    private final String message;

    InputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
