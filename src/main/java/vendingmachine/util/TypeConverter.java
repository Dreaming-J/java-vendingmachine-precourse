package vendingmachine.util;

import static vendingmachine.Message.ErrorMsg.CONVERTING_NUMBER_ERROR;

public class TypeConverter {

    public static int toInt(String data) {
        try {
            return Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERTING_NUMBER_ERROR.toString());
        }
    }
}
