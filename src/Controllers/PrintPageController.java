package Controllers;

import Views.PrintPage;

public class PrintPageController extends PageController {

     public PrintPageController() {
          super(new PrintPage(store.getAll().toArray()));
     }

     @Override
     public void executed() {
          selection = -1;
     }
}
