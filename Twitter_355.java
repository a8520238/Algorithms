import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Twitter_355 {

    //这么写效率略低， 官方的写法是 全局时间戳 + 优先队列/链表合并
    private Map<Integer, Set<Integer>> userMap;
    private List<Pair<Integer, Integer>> twitterList;

    /** Initialize your data structure here. */
    public Twitter_355() {
        userMap = new HashMap<>();
        twitterList = new ArrayList<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            Set<Integer> set = new HashSet<Integer>();
            userMap.put(userId, set);
        }
        twitterList.add(0, new Pair<Integer, Integer> (userId, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> follow = userMap.get(userId);
        int n = 0;
        for (Pair<Integer, Integer> pair: twitterList) {
            if (follow.contains(pair.getKey()) || pair.getKey() == userId) {
                res.add(pair.getValue());
                n++;
            }
            if (n == 10) {
                break;
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!userMap.containsKey(followerId)) {
            Set<Integer> set = new HashSet<>();
            userMap.put(followerId, set);
        }
        Set<Integer> follow = userMap.get(followerId);
        if (follow == null) {
            return;
        }
        follow.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> follow = userMap.get(followerId);
        if (follow == null) {
            return;
        }
        follow.remove(followeeId);
    }

    class Pair<T, U> {
        private T key;
        private U value;
        public Pair(T a, U b) {
            key = a;
            value = b;
        }
        public T getKey() {
            return key;
        }
        public U getValue() {
            return value;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */