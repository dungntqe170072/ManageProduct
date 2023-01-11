package Views.Components;

public class Message {
     private String title;
     private String message;

     public Message(String title, String message) {
          this.title = title;
          this.message = message;
     }

     public Message(String title) {
          this.title = title;
     }

     public Message() {
     }

     public void display() {
          System.out.println("====================");
          System.out.println(title.toUpperCase());
          System.out.println("--------------------");
          if (message != null) {
               System.out.println(message);
               System.out.println("--------------------");
          }
          System.out.println("====================");
     }
}
