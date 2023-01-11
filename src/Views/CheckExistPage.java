package Views;

import Views.Components.Form;

public class CheckExistPage extends Page {

     public CheckExistPage() {
          super("Check Exist Page");
     }

     public CheckExistPage(String title) {
          super(title);
     }

     @Override
     public void body() {
          Form form = new Form(new String[] { "Continue", "Cancel" }, new String[] { "ID" });
          form.display();
          args = form.getArgs();
          selection = form.getSelection();
     }
}