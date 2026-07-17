class BasicMembership extends Membership {
    private static final long serialVersionUID = 1L;

    public BasicMembership() {
        super("Basic", 1000);
    }

    @Override
    public double calculateFee() {
        return monthlyFee;
    }
}