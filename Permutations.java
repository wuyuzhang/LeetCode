/**
 * Created by Yuzhang on 1/30/17.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Permutations {
    public List<String> permutation(String set) {
        List<String> list = new ArrayList<>();
        if (set == null) {
            return list;
        }
        char[] setArray = set.toCharArray();
        helper(list, setArray, 0);
        return list;
    }

    private void helper(List<String> list, char[] setArray, int index) {
        if (index == setArray.length) {
            list.add(new String(setArray));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < setArray.length; i++) {
            if (set.add(setArray[i])) {
                swap(setArray, i, index);
                helper(list, setArray, index + 1);
                swap(setArray, i, index);
            }
        }
    }

    private void swap(char[] array, int i, int index) {
        char temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }



    public static void main(String args[]) {
        Permutations permut = new Permutations();
        String str = "abbc";
        List<String> result = permut.permutation(str);
        System.out.print(result);
    }

}
