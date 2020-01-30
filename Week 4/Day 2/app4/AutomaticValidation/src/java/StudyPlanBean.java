import javax.faces.bean.ManagedBean;

@ManagedBean(name="studyPlanBean")
public class StudyPlanBean
{
   private String[] languages = { "Java", "C", "C++", "C#", "Phyton" };
   private String email;
   private String favoriteLanguage;
   private String secondFavoriteLanguage;
   private boolean highExperience;
   private boolean knowsJamesGosling;
      
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
      this.email = email;
   }

   public String getFavoriteLanguage() {
      return favoriteLanguage;
   }

   public void setFavoriteLanguage(String favoriteLanguage) {
      this.favoriteLanguage = favoriteLanguage;
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
      if (isKnowsJamesGosling())
      {
         return "jamesGosling"; // goes to servlet
      }
      else
         
         /* If high experience is selected recommend he should learn all languages in list 
            except the ones he already knows. If not recommend just 2 languages outside the
            ones he knows.
         */
         
         return "studyPlan";  
   }
}