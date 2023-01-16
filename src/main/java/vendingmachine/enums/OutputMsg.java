package vendingmachine.enums;

public enum OutputMsg {
    WON("원"),
    HYPON(" - "),
    COUNT("개"),
    CHANGE("잔돈"),
    OUTPUT_MSG_HOLDING_COINS_OF_VENDINGMACHINE("자판기가 보유한 동전"),
    OUTPUT_MSG_CHANGE("투입 금액: ");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
