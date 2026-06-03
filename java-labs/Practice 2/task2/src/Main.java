class StartTriangle{
    int width;

    public StartTriangle(int width){
        this.width = width;
    }

    public String drawTriangle(){
        String triangle = "";
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                if(i >= j){
                    triangle += "[*]";
                }
            }
            triangle += '\n';
        }
        return triangle;
    }
}
public class Main {
    public static void main(String[] args) {
        StartTriangle st = new StartTriangle(5);
        System.out.println(st.drawTriangle());
    }
}