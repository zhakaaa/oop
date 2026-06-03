import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
    final int x = 80, y = 80, width = 150, height = 150;
    String color;
    public Rectangle(String color){
        this.color = color;
    }
    @Override public void draw(){
        Tutorial tutorial = new Tutorial();
        tutorial.paint(tutorial.getGraphics());
    }

    private class Tutorial extends JFrame{
        private Tutorial(){
//            setTitle("Circle");
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
            g2d.fillRect(x,y,width,height);
        }
    }
}
