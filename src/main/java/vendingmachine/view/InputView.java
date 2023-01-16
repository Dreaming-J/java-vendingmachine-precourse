package vendingmachine.view;

import vendingmachine.utils.TypeConverter;
import static vendingmachine.enums.InputMsg.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    TypeConverter typeConverter = new TypeConverter();

    public int readBalance() {
        System.out.println(INPUT_MSG_VENDINGMACHINE_BALANCE.get());
        return typeConverter.StringToInt(Console.readLine());
    }

    public List<List<String>> readProducts() {
        System.out.println("\n" + INPUT_MSG_PRODUCTS_INFORMATION.get());
        return typeConverter.StringToStrListList(Console.readLine());
    }

    public int readChange() {
        System.out.println("\n" + INPUT_MSG_CHANGE.get());
        return typeConverter.StringToInt(Console.readLine());
    }

    public String readPurchase() {
        System.out.println(INPUT_MSG_PURCHASE.get());
        return Console.readLine();
    }
}
