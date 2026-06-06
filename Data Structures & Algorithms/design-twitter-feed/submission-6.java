public class Twitter {

    private int time;
    private Map<Integer, List<int[]>> tweetMap;   // userId -> list of [time, tweetId]
    private Map<Integer, Set<Integer>> followMap; // userId -> followees
    private static final int FEED_SIZE = 10;

    public Twitter() {
        this.time = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // ensure the user follows themself
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        // maxHeap by time (latest first)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        for (int followeeId : followMap.get(userId)) {
            if (!tweetMap.containsKey(followeeId)) continue;
            for (int[] tweet : tweetMap.get(followeeId)) {
                maxHeap.offer(tweet);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < FEED_SIZE) {
            res.add(maxHeap.poll()[1]);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
