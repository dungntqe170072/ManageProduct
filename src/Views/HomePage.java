package Views;

import Views.Components.Menu;

public class HomePage extends Page {
     public HomePage(String title) {
          super(title);
     }

     public HomePage() {
          super("Home Page");
     }

     @Override
     public void body() {
          choses = new String[] {
                    "Create a Product",
                    "Check exits Product",
                    "Search product's information by Name",
                    "Update Product",
                    "Save Products to file",
                    "Print list Products from the file",
                    "Exit"
          };
          Menu menu = new Menu(choses);
          menu.display();
          super.selection = menu.getSelection();
     }
}
