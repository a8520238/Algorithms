/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */

package offer;
//Stringbuffer
public class replaceSpace_2 {
    public String replaceSpace(StringBuffer str) {
    	StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                buffer.append("%20");
            }
            else {
                buffer.append(str.charAt(i));
            }
        }
        return buffer.toString();
    }
}