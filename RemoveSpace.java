/**
 * Created by Yuzhang on 1/30/17.
 */
public class RemoveSpace {
    public String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                continue;
            }
            array[end] = array[i];
            end++;
        }
        if (end > 0 && array[end - 1] == ' ') {
            return new String(array, 0, end - 1);
        }
        return new String(array, 0, end);
    }

    public static void main(String args[]) {
        RemoveSpace solution = new RemoveSpace();
        String input = "   ab cdef  ";
        String result = solution.removeSpaces(input);
        System.out.println(result);
    }
}
