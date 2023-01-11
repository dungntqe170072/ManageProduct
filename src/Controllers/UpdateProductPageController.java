package Controllers;

import Views.UpdatePage;
import Views.Components.Message;

public class UpdateProductPageController extends PageController {

     public UpdateProductPageController() {
          super(new UpdatePage());
     }

     @Override
     public void executed() {
          Message message = new Message();
          switch (selection) {
               case 1:
                    try {
                         store.update(
                                   Integer.parseInt(args.get("ID")),
                                   args.get("Name").length() != 0 ? args.get("Name") : null,
                                   args.get("Unit Price").length() != 0
                                             ? Integer.parseInt(args.get("Unit Price"))
                                             : null,
                                   args.get("Quantity").length() != 0
                                             ? Integer.parseInt(args.get("Quantity"))
                                             : null,
                                   args.get("Status").length() != 0 ? args.get("Status")
                                             : null);
                         message = new Message("Success", "Update successful!");
                    } catch (RuntimeException e) {
                         message = new Message("Fail", e.getMessage());
                    } finally {
                         message.display();
                    }
                    break;

               case 2:
                    try {
                         store.delete(Integer.parseInt(args.get("ID")));
                         message = new Message("Success", "Delete successful!");
                    } catch (RuntimeException e) {
                         message = new Message("Fail", e.getMessage());
                    } finally {
                         message.display();
                    }
                    break;
               default:
                    break;
          }
          selection = -1;
     }
}
