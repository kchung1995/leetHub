class Twitter {
    
    private List<HashSet<Integer> > followingInfo = new ArrayList<>(501);
    private List<List<Integer> > tweets = new ArrayList<>(501);

    public Twitter() {
        for (int i = 0; i <= 500; i++) {
            HashSet<Integer> temp = new HashSet<>();
            temp.add(i);
            followingInfo.add(temp);
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Integer> newTweet = new ArrayList<>();
        newTweet.add(userId);
        newTweet.add(tweetId);
        tweets.add(newTweet);
        System.out.println("tweet " + tweetId + " has been created by " + userId);
        return;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        
        for (int i = tweets.size() - 1; i >= 0; i--) {
            // check if current tweet has been posted by follower
            int currentTweetBy = tweets.get(i).get(0);
            int currentTweetId = tweets.get(i).get(1);
            if (!followingInfo.get(userId).contains(currentTweetBy)) {
                continue;
            }
            newsFeed.add(currentTweetId);
            if (newsFeed.size() >= 10) break;
        }
        System.out.println("returning newsFeed for " + userId);
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        followingInfo.get(followerId).add(followeeId);
        System.out.println(followerId + " is now following " + followeeId);
        return;
    }
    
    public void unfollow(int followerId, int followeeId) {
        followingInfo.get(followerId).remove(followeeId);
        System.out.println(followerId + " is now unfollowing " + followeeId);
        return;
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