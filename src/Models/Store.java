package Models;

import java.util.List;
import java.util.stream.Collectors;

import Models.DAOProduct.*;
import Models.DataAccessObject.IDataAccessObject;

public class Store {
     private static IDataAccessObject<Product> products;

     public Store() {
          products = new DaoProduct();
     }

     public void create(int id, String name, double price, int quantity, String status) {
          if (!products.getAll().stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
               if (name.indexOf(' ') != -1 || name.length() < 5)
                    throw new RuntimeException("Name is Invalid!");
               if (!(0 <= price && price <= 10000))
                    throw new RuntimeException("Price is Invalid!");
               if (!(0 <= quantity && quantity <= 1000))
                    throw new RuntimeException("Quantity is Invalid!");
               if (status == null
                         || (!status.equalsIgnoreCase("available") && !status.equalsIgnoreCase("not available")))
                    throw new RuntimeException("Status is Invalid!");
               products.create(new Product(id, name, price, quantity, status.equalsIgnoreCase("available")));
          }
     }

     public void update(int id, String name, Double price, Integer quantity, String status) {
          if (name.indexOf(' ') != -1 || name.length() < 5)
               throw new RuntimeException("Name is Invalid!");
          if (!(0 <= price && price <= 10000))
               throw new RuntimeException("Price is Invalid!");
          if (!(0 <= quantity && quantity <= 1000))
               throw new RuntimeException("Quantity is Invalid!");
          if (!status.equalsIgnoreCase("available") && !status.equalsIgnoreCase("not available"))
               throw new RuntimeException("Status is Invalid!");

          products.update(new Product(id, name, price, quantity, status.equalsIgnoreCase("available")));

     }

     public void delete(int id) {
          products.delete(products.get(id).get());
     }

     public void saveToFile() {
          products.save();
     }

     public List<Product> getAll() {
          return products.getAll().stream().sorted().collect(Collectors.toList());
     }

     public List<Product> search(String name) {
          return products.getAll().stream().filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
     }

     public boolean checkExist(int ID) {
          return products.get(ID).isPresent();
     }
}