package Time;

public class Time implements Comparable<Time> {
    @Override
    public int compareTo(Time time) {
        if(this.hour == time.hour){
            if(this.minute == time.minute){
                if(this.second == time.second) return 0;
                else if(this.second > time.second) return 1;
                else return -1;
            }
            else if(this.minute > time.minute) return 1;
            else return -1;
        }
        else if(this.hour > time.hour) return 1;
        else return -1;
    }

    int hour;
    int minute;
    int second;

    public Time(int hour, int minute, int second){
        if(0 <= hour && hour <= 24) this.hour = hour;
        if(0 <= minute && minute <= 59 ) this.minute = minute;
        if(0 <= second && second <= 59 ) this.second = second;
        else{
            System.out.println("Invalid time");
        }
    }

    private String Hour(){
        if(hour < 10) return "0"+ hour;
        else return Integer.toString(hour);
    }

    private String Minute(){
        if(minute < 10) return "0" + minute;  // при конкатенации компилятор сама преобразовывает числовое значение в строки?
        else return Integer.toString(minute);
    }

    private String Second(){
        if(second < 10) return "0" + second;
        else return Integer.toString(second);
    }

    public String toUniversal(){
        return Hour()+":"+Minute()+":"+Second();
    }

    public String toStandard(){
        int counter = 0;
        for (int i = 12; i < hour; i++){
            counter++;
        }
        if(0 <= hour && hour <= 11) return Hour()+":"+Minute()+":"+Second() + " AM";
        else return counter +":"+Minute()+":"+Second() + " PM";
    }

    public void add(Time time) {
        System.out.println(time.toStandard());
        System.out.println(time.toUniversal());
    }
}