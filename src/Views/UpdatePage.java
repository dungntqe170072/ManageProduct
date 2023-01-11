package Views;

import Views.Components.Form;
import Views.Components.Menu;

public class UpdatePage extends Page {
     public UpdatePage() {
          super("Update Page");
     }

     public UpdatePage(String title) {
          super(title);
     }

     @Override
     public void body() {
          choses = new String[] {
                    "Update",
                    "Delete",
                    "Go back"
          };
          Menu menu = new Menu(choses);
          Form form;
          menu.display();
          selection = menu.getSelection();
          switch (selection) {
               case 1:
                    form = new Form(
                              "Update",
                              new String[] {
                                        "Update",
                                        "Cancel"
                              },
                              new String[] {
                                        "ID",
                                        "Name",
                                        "Unit Price",
                                        "Quantity",
                                        "Status"
                              });
                    form.display();
                    args = form.getArgs();
                    if (form.getSelection() == 0)
                         selection = 3;
                    break;

               case 2:
                    form = new Form(new String[] { "ID" });
                    form.display();
                    args = form.getArgs();
                    menu = new Menu(("Are you want delete " + args.get("ID") + " ?"), new String[] { "Yes", "No" });
                    menu.display();
                    if (menu.getSelection() == 2) {
                         selection = 3;
                         return;
                    }
                    break;

               default:
                    break;
          }
     }
}
