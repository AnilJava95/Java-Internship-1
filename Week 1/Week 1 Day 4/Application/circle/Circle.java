package circle;

public class Circle
{
   private double radius;
   private String color;

   public Circle(int radius, String color) {
      this.radius = radius;
      this.color = color;
   }

   public void setRadius(int radius) {
      this.radius = radius;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public double getRadius() {
      return radius;
   }

   public String getColor() {
      return color;
   }
}