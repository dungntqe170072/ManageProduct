package Views.Components;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Form {
     private String title;
     private String[] choses;
     private Map<String, String> args;

     private String[] titleArgs;

     private int selection;
     Scanner sc = new Scanner(System.in);

     public Form() {
     }

     public Form(String title, String[] choses, String[] args) {
          this(choses, args);
          this.title = title;
     }

     public Form(String[] choses, String[] args) {
          this.choses = choses;
          titleArgs = args.clone();
     }

     public Form(String[] args) {
          this.titleArgs = args.clone();
     }

     public Map<String, String> getArgs() {
          return args;
     }

     public int getSelection() {
          return selection;
     }

     public void display() {
          // System.out.println("====================");
          System.out.println("--------------------");
          if (title != null) {
               System.out.println(title.toUpperCase());
               System.out.println("--------------------");
          }
          if (titleArgs.length != 0) {
               try {
                    if (titleArgs != null && titleArgs.length != 0) {
                         this.args = new HashMap<>();
                         for (String titleArg : titleArgs) {
                              System.out.print(titleArg + ": ");
                              this.args.put(titleArg, sc.nextLine());
                         }
                    }
               } catch (Exception e) {
                    e.printStackTrace();
               }
          }
          System.out.println("--------------------");
          if (choses != null && choses.length != 0) {
               for (int i = 0; i < choses.length; i++) {
                    System.out.println((i + 1) + ". " + choses[i]);
               }
               getSeclect();
               System.out.println("--------------------");
          }
     }

     public void getSeclect() {
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
