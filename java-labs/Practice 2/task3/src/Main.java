public class Main {
    public static void main(String[] args) {
        Time time = new Time(16, 5, 2);
        System.out.println(time.toStandard());
        System.out.println(time.toUniversal());

        Time time2 = new Time(23, 8, 2);
        System.out.println(time2.toStandard());
        System.out.println(time2.toUniversal());

        Time time3 = new Time(16, 25, 34);

        time2.add(time3);
    }
}