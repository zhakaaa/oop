public class Resistor  extends Circuit{
    private double resistance;
    private double potentialDifference;

    public Resistor(double resistance){
        this.resistance = resistance;
    }

    @Override public double getResistance(){return resistance;}
    @Override public double getPotentialDiff(){return potentialDifference;}
    @Override public void applyPotentialDiff(double V){this.potentialDifference = V;}

    public void setPotentialDiff(double potentialDifference){
        this.potentialDifference = potentialDifference;}



}
