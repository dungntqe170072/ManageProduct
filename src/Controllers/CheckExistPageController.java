package Controllers;

import Views.CheckExistPage;
import Views.Components.Message;

public class CheckExistPageController extends PageController {

     public CheckExistPageController() {
          super(new CheckExistPage());
     }

     @Override
     public void executed() {
          switch (selection) {
               case 1:
                    Message message = new Message(
                              store.checkExist(Integer.parseInt(args.get("ID")))
                                        ? "Exist Product"
                                        : "No Product Found!");
                    message.display();
                    break;
               case 2:
                    selection = -1;
                    break;

               default:
                    break;
          }
     }
}
