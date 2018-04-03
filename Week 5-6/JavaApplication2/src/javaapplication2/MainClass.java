package javaapplication2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import java.lang.annotation.Annotation;

// Annotation Food
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Food
{
   public double price();
}

// Annotation Time
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Time
{
   public int takes();
}

// Class Pizza
@Food(price = 22.5)
class Pizza
{
   @Time(takes = 10)
   public void Prepare()
   {
      
   }
   
   @Time(takes = 20)
   public void Cook()
   {
      
   }
   
   @Time(takes = 15)
   public void Send()
   {
      
   }
}

// Class Kebab
@Food(price = 12.5)
class Kebab
{
   @Time(takes = 12)
   public void Prepare()
   {
      
   }
   
   @Time(takes = 20)
   public void Cook()
   {
      
   }
   
   @Time(takes = 10)
   public void Send()
   {
      
   }
}

// Class Sushi
@Food(price = 30)
class Sushi
{
   @Time(takes = 30)
   public void Prepare()
   {
      
   }
   
   @Time(takes = 0)
   public void Cook()
   {
      
   }
   
   @Time(takes = 20)
   public void Send()
   {
      
   }
}

public class MainClass
{
   public static void main(String[] args)
   {
      Class<Pizza> pizza = Pizza.class;
      Class<Kebab> kebab = Kebab.class;
      Class<Sushi> sushi = Sushi.class;
         
      if (pizza.isAnnotationPresent(Food.class))
      {
         Annotation annotation = pizza.getAnnotation(Food.class);
         Food food = (Food) annotation;
         
         System.out.printf("Pizza price: %s%n", food.price());
      }
      
      if (kebab.isAnnotationPresent(Food.class))
      {
         Annotation annotation = kebab.getAnnotation(Food.class);
         Food food = (Food) annotation;
         
         System.out.printf("Kebab price: %s%n", food.price());
      }
      
      if (sushi.isAnnotationPresent(Food.class))
      {
         Annotation annotation = sushi.getAnnotation(Food.class);
         Food food = (Food) annotation;
         
         System.out.printf("Sushi price: %s%n", food.price());
      }
   }
}