import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SymbolBalance implements SymbolBalanceInterface {
    private String filePath;

    @Override
    public void setFile(String filename) {
        filePath = filename;
    }

    @Override
    public BalanceError checkFile() {
        MyStack<Character> stack = new MyStack<>();
        int lineNumber = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char currentSymbol = (char) currentChar;

                if (currentSymbol == '\n') {
                    lineNumber++;
                }

                if (currentSymbol == '/' && reader.ready()) {
                    char nextChar = (char) reader.read();
                    if (nextChar == '*') {
                        stack.push('*');
                    } else {
                        reader.reset();
                    }
                }

                if (currentSymbol == '*' && reader.ready()) {
                    char nextChar = (char) reader.read();
                    if (nextChar == '/') {
                        if (stack.isEmpty()) {
                            return new EmptyStackError(lineNumber);
                        }
                        stack.pop();
                    } else {
                        reader.reset();
                    }
                }

                if (stack.isEmpty()) {
                    if (isOpeningSymbol(currentSymbol)) {
                        stack.push(currentSymbol);
                    } else if (isClosingSymbol(currentSymbol)) {
                        return new MismatchError(lineNumber, currentSymbol, ' ');
                    }
                } else {
                    if (isOpeningSymbol(currentSymbol)) {
                        stack.push(currentSymbol);
                    } else if (isClosingSymbol(currentSymbol)) {
                        char topElement = stack.peek();
                        if (isMatchingPair(topElement, currentSymbol)) {
                            stack.pop();
                        } else {
                            return new MismatchError(lineNumber, currentSymbol, topElement);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!stack.isEmpty()) {
            return new NonEmptyStackError(stack.peek(), stack.size());
        }

        return null;
    }

    private boolean isOpeningSymbol(char symbol) {
        return symbol == '{' || symbol == '(' || symbol == '[';
    }

    private boolean isClosingSymbol(char symbol) {
        return symbol == '}' || symbol == ')' || symbol == ']';
    }

    private boolean isMatchingPair(char opening, char closing) {
        return (opening == '{' && closing == '}') ||
                (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']');
    }
}