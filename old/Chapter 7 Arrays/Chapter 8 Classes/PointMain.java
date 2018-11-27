public class PointMain {

   public static void main(String[] args) {
      
      // create two Point objects;
      Point p1 = new Point(7, 2);
      
      Point p2 = new Point(4, 3);
      
      Point p3 = new Point();
      
      System.out.println("p1 is " + p1);
      
      p1.translate(3, 5);
      
      System.out.println("p1 is " + p1);
      System.out.println("p2 is " + p2);
      System.out.println("p3 is " + p3);

      System.out.printf("p1 distance from origin = %.2f\n", p1.distanceFromOrigin());
      System.out.printf("p2 distance from origin = %.2f\n", p2.distanceFromOrigin());
      
      System.out.printf("p1 distance from p2 = %.2f\n", p1.distance(p2));
      
   }
}