class PremiumMembership extends Membership {
    private static final long serialVersionUID = 1L;

    public PremiumMembership() {
        super("Premium", 2000);
    }

    @Override
    public double calculateFee() {
        return monthlyFee + 500;
    }
}