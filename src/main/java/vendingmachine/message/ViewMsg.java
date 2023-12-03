package vendingmachine.message;

public enum ViewMsg {
    READ_VENDING_MACHINE_AMOUNT("자판기가 보유하고 있는 금액을 입력해 주세요.");

    private final String message;

    ViewMsg(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
