package Views.Components;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
     private String title;
     private String[] choses;
     private int selection;

     Scanner sc = new Scanner(System.in);

     public Menu() {
     }

     public Menu(String title, String[] choses) {
          this.title = title;
          this.choses = choses;
     }

     public Menu(String[] choses) {
          this.choses = choses;
     }

     public int getSelection() {
          return selection;
     }

     public void display() {
          if (title != null)
               System.out.println(title.toUpperCase());
          for (int i = 0; i < choses.length; i++)
               System.out.println((i + 1) + ". " + choses[i]);
          getSeclect();
     }

     public void getSeclect() {
          System.out.println("--------------------");
          System.out.print("Enter your select: ");
          while (true) {
               try {
                    selection = sc.nextInt();
                    sc.nextLine();
                    break;
               } catch (InputMismatchException e) {
                    System.err.println("Enter the integer plese!");
               }
          }
     }
}
