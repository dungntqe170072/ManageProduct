package Views;

import Views.Components.Form;

public class SearchProductPage extends Page {
     public SearchProductPage() {
          super("Search Product");
     }

     public SearchProductPage(String title) {
          super(title);
     }

     @Override
     public void body() {
          choses = new String[] { "Search", "Cancel" };
          String[] args = { "Name" };
          Form form = new Form(choses, args);
          form.display();
          super.args = form.getArgs();
          super.selection = form.getSelection();
     }
}
