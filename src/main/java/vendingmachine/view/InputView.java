package vendingmachine.view;

import static vendingmachine.message.ViewMsg.PRINT_NAME_OF_PRODUCT;
import static vendingmachine.message.ViewMsg.READ_INPUT_AMOUNT;
import static vendingmachine.message.ViewMsg.READ_STOCK;
import static vendingmachine.message.ViewMsg.READ_VENDING_MACHINE_AMOUNT;
import static vendingmachine.util.TypeConverter.toInt;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readVendingMachineAmount() {
        System.out.println(READ_VENDING_MACHINE_AMOUNT);
        return toInt(Console.readLine());
    }

    public String readStock() {
        System.out.println(READ_STOCK);
        return Console.readLine();
    }

    public int readInputAmount() {
        System.out.println(READ_INPUT_AMOUNT);
        return toInt(Console.readLine());
    }

    public String readNameOfProduct() {
        System.out.println(PRINT_NAME_OF_PRODUCT);
        return Console.readLine();
    }
}
