package offer;

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class FirstAppearingOnce_54 {
    //Insert one char from stringstream
    private Set<Character> set = new HashSet<>();
    private Queue<Character> queue = new LinkedList<>();
    
    public void Insert(char ch)
    {
        if (set.contains(ch)) {
            set.remove(ch);
        } else {
            set.add(ch);
            queue.add(ch);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char res = '#';
        while (!queue.isEmpty()) {
            if (!set.contains(queue.peek())) {
                queue.poll();
            } else {
                res = queue.peek();
                break;
            }
        }
        return res;
    }
}