package Controllers;

import java.util.Map;

import Models.Store;
import Views.Page;
import Views.Components.Menu;

public abstract class PageController {
     protected String title;
     protected String[] choese;
     protected int selection;
     protected Map<String, String> args;
     protected String[] value;

     protected Page page;

     protected static Store store = new Store();

     public PageController(Page page) {
          this.page = page;
     }

     public abstract void executed();

     public void run() {
          while (true) {
               do {
                    page.display();
                    selection = page.getSelection();
                    args = page.getArgs();
                    executed();
               } while (selection <= page.getChoses().length && selection != -1);
               Menu menu = new Menu("Do you want go back to Home page", new String[] { "Yes", "No" });
               menu.display();
               if (menu.getSelection() == 1)
                    break;
          }
     }
}
