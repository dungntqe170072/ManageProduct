package Views;

import Views.Components.Menu;
import Views.Components.Table;

public class PrintPage extends Page {
     private String[] value;

     public PrintPage() {
          super("Print All From File");
          this.value = null;
     }

     public PrintPage(String title, String[] value) {
          super(title);
          this.value = (String[]) value.clone();
     }

     public PrintPage(Object[] value) {
          this();
          this.value = new String[value.length];
          for (int i = 0; i < value.length; i++) {
               this.value[i] = value[i].toString();
          }
     }

     @Override
     public void body() {
          choses = new String[] { "Yes", "No" };
          Table table = new Table("Products", value);
          table.display();
     }

}
