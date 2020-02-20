import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * 找不同
 * 
 * 题目描述：
 *      给定两个字符串 s 和 t，它们只包含小写字母。
        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
        请找出在 t 中被添加的字母。


        输入：
        s = "abcd"
        t = "abcde"

        输出：
        e
 * 
 */

class findDifference_389 {
// //方法一 流输入 HashMap
//     static Map<Character, Integer> map = new HashMap<>();
//     public static char findTheDifference(String s, String t) {
//         for (char str1 : s.toCharArray()) {
//             map.put(str1, map.getOrDefault(str1, 0) + 1);
//         }
//         //将List<String> 转为 List<Character>
//         List<Character> list = Arrays.asList(t).stream()
//             .flatMapToInt(String::chars).mapToObj(i -> (char)i).collect(Collectors.toList());
//         return list.stream().filter(a -> f(a)).collect(Collectors.toList()).toArray(new Character[0])[0];
//     }

//     //filter函数
//     private static boolean f(char a) {
//         if (map.getOrDefault(a, 0) > 0) {
//             map.put(a, map.get(a) - 1);
//             return false;
//         }
//         return true;
//     }

//方法二 利用异或
    public static char findTheDifference(String s, String t) {
        char res = t.charAt(t.length()-1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "abcd";
        String t = "adceb";
        char res = findDifference_389.findTheDifference(s, t);
        System.out.println(res);
    }
}