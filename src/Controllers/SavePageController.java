package Controllers;

import Views.SavePage;
import Views.Components.Message;

public class SavePageController extends PageController {

     public SavePageController() {
          super(new SavePage());
     }

     @Override
     public void executed() {
          if (selection == 1) {
               Message message = new Message();
               try {
                    store.saveToFile();
                    message = new Message("Success", "Save to file Successful!");
               } catch (RuntimeException e) {
                    message = new Message("Fail", e.getMessage());
               } finally {
                    message.display();
               }
          }
          selection = -1;
     }

}
