package Views.Components;

public class Table {
     private String title;
     private String[] value;
     private String nonContent;

     public Table() {
     }

     public Table(String title, Object[] value, String nonContent) {
          this(title, value);
          this.nonContent = nonContent;
     }

     public Table(String title, Object[] value) {
          this.title = title;
          this.value = new String[value.length];
          for (int i = 0; i < value.length; i++) {
               this.value[i] = value[i].toString();
          }
     }

     public void display() {
          System.out.println("====================");
          System.out.println(title.toUpperCase());
          System.out.println("--------------------");
          if (value.length != 0) {
               for (int i = 0; i < value.length; i++) {
                    System.out.println((i + 1) + ". " + value[i].toString());
               }
          } else {
               System.out.println(nonContent != null ? nonContent : ("Don't have " + title.toLowerCase() + "here!"));
          }
          System.out.println("====================");
     }
}
