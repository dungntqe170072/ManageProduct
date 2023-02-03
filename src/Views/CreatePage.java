package Views;

import Views.Components.Form;

public class CreatePage extends Page {
     public CreatePage(String title) {
          super(title);
     }

     public CreatePage() {
          title = "Create";
     }

     @Override
     public void body() {
          choses = new String[] { "Create", "Cancel" };
          String[] args = {
                    "ID",
                    "Name",
                    "Unit Price",
                    "Quantity",
                    "Status(available/not available)"
          };
          Form form = new Form(choses, args);
          form.display();
          super.args = form.getArgs();
          super.selection = form.getSelection();
     }
}
