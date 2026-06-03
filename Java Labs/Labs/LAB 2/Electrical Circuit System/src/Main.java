public class Main {
    public static void main(String[] args) {
        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);
        Circuit f = new Series(a, b);
        System.out.println("R1 = " + "R2 = " + f.getResistance());
        Circuit g = new Parallel(c, d);
        System.out.println("R2 = " + g.getResistance());
        Circuit h = new Series(g, e);
        System.out.println("R3 = " + h.getResistance());
        Circuit circuit = new Parallel(h, f);
        System.out.println("R = " + circuit.getResistance());
        double R = circuit.getResistance();
        System.out.println("Equivalent Resistance = " + R);
        circuit.applyPotentialDiff(10);

        System.out.println("Current = " + circuit.getCurrent());
        System.out.println("Voltage = " + circuit.getPotentialDiff());
        System.out.println("Power = " + circuit.getPower());
    }
}