import java.awt.*;

public class Graphics {

   public static void main(String[] args) {
      
      
      DrawingPanel panel = new DrawingPanel(200, 100);
      
      panel.setBackground(Color.CYAN);
      
      Graphics2D g = panel.getGraphics();
      //g.drawLine(25, 75, 100, 25);
      //g.drawLine(100, 25, 175, 75);
      //g.drawLine(25, 75, 175, 75);
      
      
      // cordinated then width & height - x, y, width, height
      //g.drawRect(25, 50, 20, 20);
      //g.drawRect(150, 10, 40, 20);
      
      //g.setColor(Color.WHITE);
      
      //g.drawOval(50, 25, 20, 20);
      //g.fillOval(150, 50, 40, 20);
      
      
      loop1(g);
      
      
   }

   public static void loop1(Graphics2D g) {
      for(int i = 0; i < 4; i++) {
         g.setColor(Color.WHITE);
         g.fillOval(i * 50, i * 25, 50, 25);
         g.setColor(Color.BLACK);
         g.drawRect(i * 50, i * 25, 50, 25);
      }
   }

}