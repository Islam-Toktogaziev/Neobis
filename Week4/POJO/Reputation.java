public class Reputation {
    private long reputationID;
    private String reputation;

    public Reputation() {
    }

    public Reputation(long reputationID, String reputation) {
        this.reputationID = reputationID;
        this.reputation = reputation;
    }

    public long getReputationID() {
        return reputationID;
    }

    public void setReputationID(long reputationID) {
        this.reputationID = reputationID;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }
}
