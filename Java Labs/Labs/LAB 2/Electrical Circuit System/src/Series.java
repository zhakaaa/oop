public class Series extends Circuit {
    private double resistance;
    private double potentialDiff;
    public Series(Circuit A, Circuit B) {
        resistance = A.getResistance() + B.getResistance();
    }

    @Override public double getResistance(){return resistance;}
    @Override public double getPotentialDiff(){return potentialDiff;}
    @Override public void applyPotentialDiff(double V){this.potentialDiff = V;}
}
