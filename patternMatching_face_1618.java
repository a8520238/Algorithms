/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
示例 1：
输入： pattern = "abba", value = "dogcatcatdog"
输出： true
 */

class patternMatching_face_1618 {
    public boolean patternMatching(String pattern, String value) {
        int count_a = 0, count_b = 0;
        for (char c: pattern.toCharArray()) {
            if (c == 'a') {
                count_a++;
            } else {
                count_b++;
            }
        }
        if (count_b > count_a) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            char[] arr = pattern.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] == 'a'? 'b': 'a';
            }
            pattern = new String(arr);
        }
        if (value.length() == 0) {
            return count_b == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }

        for (int lenA = 0; lenA * count_a <= value.length(); lenA++) {
            int rest = value.length() - lenA * count_a;
            if ((count_b == 0 && rest == 0) || (count_b != 0) && rest % count_b == 0) {
                int lenB = count_b == 0? 0: rest / count_b;
                int pos = 0;
                boolean f = true;
                String valueA = "", valueB = "";
                for (char c: pattern.toCharArray()) {
                    if (c == 'a') {
                        String cur = value.substring(pos, pos + lenA);
                        if (valueA.length() == 0) {
                            valueA = cur;
                        }
                        if (!valueA.equals(cur)) {
                            f = false;
                            break;
                        }
                        pos += lenA;
                    } else {
                        String cur = value.substring(pos, pos + lenB);
                        if (valueB.length() == 0) {
                            valueB = cur;
                        }
                        if (!valueB.equals(cur)) {
                            f = false;
                            break;
                        }
                        pos += lenB;
                    }
                }
                if (f && !valueA.equals(valueB)) {
                    return true;
                }
            }
        }
        return false;
    }
}

