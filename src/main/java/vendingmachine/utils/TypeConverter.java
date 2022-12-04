package vendingmachine.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static vendingmachine.enums.ErrorMsg.*;

public class TypeConverter {

    private static final String SEMI_COLON = ";";
    private static final String COMMA = ",";

    public int StringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_MONEY_IS_INTEGER.get());
        }
    }

    public List<List<String>> StringToStrListList(String input) {
        List<List<String>> newList = new ArrayList<>();

        for (String value : StringToStrList(input)) {
            String tempValue = value.replace("[", "");
            tempValue = tempValue.replace("]", "");
            newList.add(Stream.of(tempValue.split(COMMA))
                    .collect(Collectors.toList()));
        }

        return newList;
    }

    private List<String> StringToStrList(String input) {
        return Stream.of(input.split(SEMI_COLON))
                .collect(Collectors.toList());
    }
}
