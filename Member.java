import java.io.Serializable;

class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private int memberId;
    private String name;
    private int age;
    private Membership membership;

    public Member(int memberId, String name, int age, Membership membership) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.membership = membership;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public String getMemberDetails() {
        String membershipInfo;
        String feeInfo;

        if (membership != null) {
            membershipInfo = membership.getMembershipName();
            feeInfo = String.valueOf(membership.calculateFee());
        } else {
            membershipInfo = "No membership assigned";
            feeInfo = "N/A";
        }

        return "ID: " + memberId +
               "\nName: " + name +
               "\nAge: " + age +
               "\nMembership: " + membershipInfo +
               "\nMonthly Fee: " + feeInfo;
    }
}