public class Parallel extends Circuit {
    private double resistance;
    private double potentialDiff;
    public Parallel(Circuit A, Circuit B) {
        resistance = 1 / ( ( 1/A.getResistance() ) + ( 1/B.getResistance() ) );
    }

    @Override public double getResistance(){return resistance;}
    @Override public double getPotentialDiff(){return potentialDiff;}
    @Override public void applyPotentialDiff(double V){this.potentialDiff = V;}

}
