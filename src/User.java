public class User {
    public int rank = -8;
    public int progress = 0;

    public void incProgress(int activityRank)
    {
        if (activityRank > 8 || activityRank < -8)
            throw new IllegalArgumentException("argument is out of range");


    }
}
