package Models.DAOProduct;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Models.DataAccessObject.IDataAccessObject;

public class DaoProduct implements IDataAccessObject<Product> {
     private List<Product> products;

     public DaoProduct() {
          load();
          if (products == null) {
               products = new ArrayList<>();
          }
     }

     @Override
     public void create(Product product) {
          products.add(product);
          save();
     }

     @Override
     public void delete(Product product) {
          if (!products.remove(product)) {
               throw new RuntimeException("Product Not Found!");
          }
          save();
     }

     @Override
     public Optional<Product> get(int ID) {
          load();
          return products.stream().filter(p -> p.getId() == ID).findFirst();
     }

     @Override
     public List<Product> getAll() {
          load();
          return products;
     }

     @Override
     public void load() {
          File file = new File(Paths.get("db", "product.dat").toAbsolutePath().toString());
          try {
               if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
               }
               try (FileInputStream fis = new FileInputStream(file)) {
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    products = (List<Product>) ois.readObject();
               }
          } catch (IOException e) {
               products = new ArrayList<>();
          } catch (ClassNotFoundException e) {
               e.printStackTrace();
          }
     }

     @Override
     public void save() {
          File file = new File(Paths.get("db", "product.dat").toAbsolutePath().toString());
          try (FileOutputStream fos = new FileOutputStream(file)) {
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(products);
          } catch (IOException e) {
               throw new RuntimeException("Can not save to File");
          }
     }

     @Override
     public void update(Product product) {
          try {
               get(product.getId()).ifPresent(p -> {
                    p.setName(product.getName() != null ? product.getName() : p.getName());
                    p.setQuantity(product.getQuantity() != null ? product.getQuantity() : p.getQuantity());
                    p.setStatus(product.isStatus() != null ? product.isStatus() : p.isStatus());
                    p.setUnitPrice(product.getUnitPrice() != null ? product.getUnitPrice() : p.getUnitPrice());
               });
          } catch (NullPointerException e) {
               throw new RuntimeException("Product not Found!");
          }
          save();
     }

}
