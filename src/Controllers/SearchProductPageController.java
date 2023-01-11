package Controllers;

import Views.SearchProductPage;
import Views.Components.Table;

public class SearchProductPageController extends PageController {
     public SearchProductPageController() {
          super(new SearchProductPage());
     }

     @Override
     public void executed() {
          if (selection == 1) {
               Table table = new Table("Products",
                         store.search(args.get("Name")).toArray(),
                         "Have no any Product");
               table.display();
          }
          selection = -1;
     }
}
