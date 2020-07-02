public class Reputation {
    private long reputationID;
    private long customerID;
    private String reputation;

    public Reputation() {
    }

    public Reputation(long reputationID, long customerID, String reputation) {
        this.reputationID = reputationID;
        this.customerID = customerID;
        this.reputation = reputation;
    }

    public long getReputationID() {
        return reputationID;
    }

    public void setReputationID(long reputationID) {
        this.reputationID = reputationID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }
}
