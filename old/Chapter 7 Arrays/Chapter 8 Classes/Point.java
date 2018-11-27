public class Point {

   private int x;
   private int y;
   
   public Point(int x, int y) {
      setLocation(x, y);
   }
   
   public Point() {
      this(0, 0);
   }
   
   public String toString() {
      return "(" + x + ", " + y + ")";
   }
   
   public double distanceFromOrigin() {
      return Math.sqrt(x * x + y * y);
   }
   
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
   
   public double distance(Point other) {
      return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
   }
   
   public int quadrant() {
      if(x == 0 || y == 0)
         return 0;
      else if(x > 0 && y > 0)
         return 1;
      else if(x < 0 && y > 0)
         return 2;
      else if(x < 0 && y < 0)
         return 3;
      else
         return 4;
   }
   
   public int manhattanDistance(Point other) {
      return Math.abs(other.x - x) + Math.abs(other.y - y);
   }
   
   public void flip() {
      int temp = -x;
      x = -y;
      y = temp;
   }
   
   public boolean isVertical(Point other) {
      if(x == other.x)
         return true;
      return false;
   }
   
   public double slope(Point other) {
      if(x == other.x)
         throw new IllegalArgumentException();
      return (double)(other.y - y) / (other.x - x);
   }
   
   public void setLocation(int newX, int newY) {
      x = newX;
      y = newY;
   }
   
    public void translate(int dx, int dy) {
      setLocation(x + dx, y + dy);
   }
}