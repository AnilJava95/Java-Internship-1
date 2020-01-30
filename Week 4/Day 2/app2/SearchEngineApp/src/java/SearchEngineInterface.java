import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="searchEngineInterface")
public class SearchEngineInterface
{
   ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
   
   private String[] searchEngines = { "Google", "Yahoo", "Bing" };
   private String searchString = "";
   private String searchEngine;
   
   
   public SearchEngineInterface()
   {
      
   }

   public String getSearchString() {
      return searchString;
   }

   public void setSearchString(String searchString) {
      this.searchString = searchString;
   }

   public String[] getSearchEngines() {
      return searchEngines;
   }

   public void setSearchEngines(String[] searchEngines) {
      this.searchEngines = searchEngines;
   }

   public String getSearchEngine() {
      return searchEngine;
   }

   public void setSearchEngine(String searchEngine) {
      this.searchEngine = searchEngine;
   }
   
   public String action() throws IOException
   {
      switch (searchEngine)
      {
         case "Google":
            searchString = "https://www.google.com.tr/search?q=" + searchString;
            externalContext.redirect(searchString);
            return searchString;
         case "Yahoo":
            searchString = "https://search.yahoo.com/search?p=" + searchString;
            externalContext.redirect(searchString);
         case "Bing":
            searchString = "https://www.bing.com/search?q=" + searchString;
            externalContext.redirect(searchString);
      }
      
      return "error";
   }
}
