class Twitter {
    
    HashMap<Integer, Set<Integer>> userFollowings;
    HashMap<Integer, List<Pair<Integer, Integer>>> userPostings;
    int time;

    public Twitter() {
        userFollowings = new HashMap<>();
        userPostings = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Pair<Integer, Integer>> postings = userPostings.getOrDefault(userId, new ArrayList<>());
        postings.add(new Pair<>(tweetId, time++));
        userPostings.put(userId, postings);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> p2.getValue() - p1.getValue());
        //get user's own postings
        List<Pair<Integer, Integer>> ownPostings = userPostings.getOrDefault(userId, new ArrayList<>());
        for (Pair<Integer, Integer> post: ownPostings) pq.add(post);
        //get postings from each of the user's following
        Set<Integer> followings = userFollowings.getOrDefault(userId, new HashSet<>());
        for (int following: followings) {
            List<Pair<Integer, Integer>> postings = userPostings.getOrDefault(following, new ArrayList<>());
            for (Pair<Integer, Integer> p: postings) pq.add(p);
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
            if (res.size() == 10) break;
        }
        return res;
    }

    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followings = userFollowings.getOrDefault(followerId, new HashSet<>());
        followings.add(followeeId);
        userFollowings.put(followerId, followings);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followings = userFollowings.getOrDefault(followerId, new HashSet<>());
        followings.remove(followeeId);
        userFollowings.put(followerId, followings);
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