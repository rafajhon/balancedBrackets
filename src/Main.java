import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    private static char[][] tokenValid = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public static void main(String[] args) {
        List<String> inSequense = Arrays.asList("{{}}({})", "(){}[]", "[{()}](){}", "[]{()", "[{)]");
        inSequense.forEach(sequence ->
                System.out.println(String.format("%s is %s", sequence, isValid(sequence) ? "valid" : "not valid")));

    }


    private static boolean isValid(String inSequense) {
        Stack<Character> characterStack = new Stack<>();
        for (char character : inSequense.toCharArray()) {
            if (isOpen(character)) {
                characterStack.push(character);
            } else if (characterStack.isEmpty() || !matchedPair(characterStack.pop(), character)) {
                return false;
            }

        }
        return characterStack.isEmpty();
    }

    private static boolean matchedPair(Character tokenOpen, char tokenClose) {
        for (char[] pairToken : tokenValid) {
            if (pairToken[0] == tokenOpen)
                return pairToken[1] == tokenClose;
        }
        return false;
    }

    private static boolean isOpen(char character) {
        for (char[] pairToken : tokenValid) {
            if (pairToken[0] == character)
                return true;
        }
        return false;
    }
}
