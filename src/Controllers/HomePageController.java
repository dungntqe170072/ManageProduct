package Controllers;

import Views.HomePage;

public class HomePageController extends PageController {

     public HomePageController() {
          super(new HomePage());
     }

     @Override
     public void executed() {
          PageController pageController;
          switch (selection) {
               case 1:
                    pageController = new CreatePageController();
                    pageController.run();
                    break;

               case 2:
                    pageController = new CheckExistPageController();
                    pageController.run();
                    break;

               case 3:
                    pageController = new SearchProductPageController();
                    pageController.run();
                    break;

               case 4:
                    pageController = new UpdateProductPageController();
                    pageController.run();
                    break;

               case 5:
                    pageController = new SavePageController();
                    pageController.run();
                    break;

               case 6:
                    pageController = new PrintPageController();
                    pageController.run();
                    break;

               case 7:
                    System.exit(0);

               default:
                    pageController = new HomePageController();
                    break;
          }
     }
}
