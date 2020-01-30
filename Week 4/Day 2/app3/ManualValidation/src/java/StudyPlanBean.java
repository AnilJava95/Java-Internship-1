import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name="studyPlanBean")
public class StudyPlanBean
{
   private String[] languages = { "Java", "C", "C++", "C#", "Python" };
   private String email;
   private String favoriteLanguage;
   private String secondFavoriteLanguage;
   private boolean highExperience;
   private boolean knowsJamesGosling;
   
   FacesContext context = FacesContext.getCurrentInstance();
   FacesMessage emailMessage = new FacesMessage("Enter a value");
   FacesMessage favoriteLanguageMessage = new FacesMessage("Enter a value");
   
   public StudyPlanBean()
   {
      
   }

   public String[] getLanguages() {
      return languages;
   }

   public void setLanguages(String[] languages) {
      this.languages = languages;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      if (email == null || email.equals(""))
      {
         context.addMessage(email, emailMessage);
      }
      else
      {
         this.email = email;
      }
   }

   public String getFavoriteLanguage() {
      return favoriteLanguage;
   }

   public void setFavoriteLanguage(String favoriteLanguage) {
      if (favoriteLanguage == null || favoriteLanguage.equals(""))
      {
         context.addMessage(favoriteLanguage, favoriteLanguageMessage);
      }
      else
      {
         this.favoriteLanguage = favoriteLanguage;
      }
   }

   public String getSecondFavoriteLanguage() {
      return secondFavoriteLanguage;
   }

   public void setSecondFavoriteLanguage(String secondFavoriteLanguage) {
      this.secondFavoriteLanguage = secondFavoriteLanguage;
   }

   public boolean isHighExperience() {
      return highExperience;
   }

   public void setHighExperience(boolean highExperience) {
      this.highExperience = highExperience;
   }

   public boolean isKnowsJamesGosling() {
      return knowsJamesGosling;
   }

   public void setKnowsJamesGosling(boolean knowsJamesGosling) {
      this.knowsJamesGosling = knowsJamesGosling;
   }
   
   public String action()
   {
      try
      {
         if (isKnowsJamesGosling())
         {
            return "jamesGosling"; // goes to servlet
         }
         else if ( !((email == null) || email.equals("")) && !((favoriteLanguage == null) || favoriteLanguage.equals("")) )
         {


            return "studyPlan";

            /* If high experience is selected recommend he should learn all languages in list 
            except the ones he already knows. If not recommend just 2 languages outside the
            ones he knows.
            */
         }
         else
         {
            return "";
         }
      }
      catch (NullPointerException e)
      {
         System.err.println(e);
         return "";
      }
   }
}