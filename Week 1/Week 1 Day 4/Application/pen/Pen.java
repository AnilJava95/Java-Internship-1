/*
 * Author's name and email: Anil Erturk, anilerturk1@gmail.com
 * Program description: Application1.
 * Latest version: 13:43 06/07/2017.
 * Older versions: 
 */

// bu kodu klasorleriyle birlikte koy koyacagin yere

package pen;

import java.util.Scanner;
import rectangle.Rectangle;
import circle.Circle;

public class Pen
{
   public void drawRectangle(Rectangle r)
   {
      double rectangleArea = r.getHeight() * r.getWidth();
      System.out.printf("Area of rectangle is: %f", rectangleArea);
   }
   
   public void drawCircle(Circle c)
   {
      double circleArea = Math.PI + Math.pow(c.getRadius(), 2);
      System.out.printf("Area of circle is: %f", circleArea);
   }
   
   /*public void changeColorRectangle(String color, Rectangle r)
   {
      r.setColor(color);
   }
   
   public void changeColorCircle(String color, Circle c)
   {
      c.setColor(color);
   }*/
   
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      Rectangle r = new Rectangle(5, 5, "yellow");
      Circle c = new Circle(6, "black");
      Pen p = new Pen();
      
      p.drawRectangle(r);
      System.out.println();
      p.drawCircle(c);
      System.out.printf("%nColor of rectangle: %s", r.getColor());
      System.out.printf("%nColor of circle: %s", c.getColor());
      
      r.setColor("black");
      c.setColor("green");
      
      System.out.printf("%nColor of rectangle after set method: %s", r.getColor());
      System.out.printf("%nColor of circle after set method: %s%n", c.getColor());
   }
}