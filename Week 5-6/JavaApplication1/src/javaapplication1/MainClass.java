package javaapplication1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MainClass
{
   public static void main(String[] args) throws IOException
   {
      try
      {
         Class2.method2();
      } catch (ArithmeticException AE)
      {
         try
         {
            throw new CustomException("Divide by zero v2", AE);
         } catch (Exception e)
         {
            Logger logger = Logger.getLogger("MyLog");  
            FileHandler fh; 
            
            fh = new FileHandler("D:\\Computer Engineering\\6- Java\\4- Java Programs\\"
               + "- Other Code\\OBSS\\Week 5-6\\JavaApplication1/output/error.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
            
            logger.info("ArithmeticException");  
         }
      }
   }
   
   public static class CustomException extends Exception
   {
      public CustomException(String s, Throwable t)
      {
         super(s, t);
      }
   }
}