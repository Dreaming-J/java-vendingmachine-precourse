package vendingmachine.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import vendingmachine.view.OutputView;

public class Repeat {

    public static void repeat(Runnable inputReader) {
        while (true) {
            try {
                inputReader.run();
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public static <T> T repeat(Supplier<T> inputReader) {
        while (true) {
            try {
                return inputReader.get();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public static <T> void repeat(Consumer<T> inputReader, T parameter) {
        while (true) {
            try {
                inputReader.accept(parameter);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public static <T, R> R repeat(Function<T, R> inputReader, T parameter) {
        while (true) {
            try {
                return inputReader.apply(parameter);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}