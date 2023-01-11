package Views;

import Views.Components.Menu;

public class SavePage extends Page {

     public SavePage() {
          super("Save To File");
     }

     public SavePage(String title) {
          super(title);
     }

     @Override
     public void body() {
          Menu menu = new Menu("Do you want save to Product.dat?", new String[] { "Yes", "No" });
          menu.display();
          selection = menu.getSelection();
     }

}
