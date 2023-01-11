package Controllers;

import Views.CreatePage;
import Views.Components.Message;

public class CreatePageController extends PageController {
     public CreatePageController() {
          super(new CreatePage());
     }

     @Override
     public void executed() {
          if (selection == 1) {
               Message message;
               try {
                    store.create(
                              Integer.parseInt(args.get("ID")),
                              args.get("Name"),
                              Integer.parseInt(args.get("Unit Price")),
                              Integer.parseInt(args.get("Quantity")),
                              args.get("Status"));
                    message = new Message("Success", "Create product successfuly!");
               } catch (Exception e) {
                    message = new Message("Error", e.getMessage());
                    message.display();
               }
          }
          selection = -1;
     }

}
