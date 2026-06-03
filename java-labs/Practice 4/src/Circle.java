import javax.swing.JFrame;
import java.awt.*;


public class Circle extends Shape{
    final int x = 80, y = 80, width = 150, height = 150;
//    private Color color;
//    public Circle(Color color){
//            this.color = color;
//    }

    private String color;
    public Circle(String color){
        this.color = color;
    }

    @Override public void draw(){
        DrawCircle drawCircle = new DrawCircle();
        drawCircle.paint(drawCircle.getGraphics());
    }

    private class DrawCircle extends JFrame{
        private DrawCircle(){
            setSize(400,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);
        }

        @Override public void paint(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            if(color.toString().equals("green"))g2d.setPaint(java.awt.Color.green);
            else if(color.toString().equals("red"))g2d.setPaint(java.awt.Color.red);
            else if(color.toString().equals("blue"))g2d.setPaint(java.awt.Color.blue);
            else if(color.toString().equals("yellow"))g2d.setPaint(java.awt.Color.yellow);

            g2d.fillOval(x,y,width,height);
        }
    }
}
