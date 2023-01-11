package Views;

import java.util.Map;

public abstract class Page {
     protected String title;
     protected String[] choses;
     protected int selection;

     protected Map<String, String> args;

     public Page() {
     }

     public Page(String title) {
          this.title = title;
     }

     public String[] getChoses() {
          if (choses != null)
               return choses;
          return new String[0];
     }

     public Map<String, String> getArgs() {
          return args;
     }

     public int getSelection() {
          return selection;
     }

     public void display() {
          System.out.println("====================");
          System.out.println((title == null || title.isEmpty()) ? "PAGE" : title.toUpperCase());
          System.out.println("********************");
          body();
          System.out.println("********************");
          System.out.println("====================");
     }

     protected abstract void body();
}
