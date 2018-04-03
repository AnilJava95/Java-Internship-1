package javaapplication1;

public class Class1
{
   public static void method1() throws ArithmeticException
   {
      try
      {
         int x = 1 / 0;
      } catch (ArithmeticException AE)
      {
         throw new ArithmeticException("Diivide by zero");
      }
   }
}