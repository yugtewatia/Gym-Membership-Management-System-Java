import java.io.Serializable;

abstract class Membership implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String membershipName;
    protected double monthlyFee;

    public Membership(String name, double fee) {
        this.membershipName = name;
        this.monthlyFee = fee;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public abstract double calculateFee();
}