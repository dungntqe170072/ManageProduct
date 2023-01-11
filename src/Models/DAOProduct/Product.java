package Models.DAOProduct;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product> {
     private static final long serialVersionUID = 414996794811734108L;

     private int id;
     private String name;
     private Integer unitPrice;
     private Integer quantity;
     private boolean status;

     public Product() {
     }

     public Product(int id, String name, Integer unitPrice, Integer quantity, Boolean status) {
          this.id = id;
          this.name = name;
          this.unitPrice = unitPrice;
          this.quantity = quantity;
          this.status = status;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public Integer getUnitPrice() {
          return unitPrice;
     }

     public void setUnitPrice(int unitPrice) {
          this.unitPrice = unitPrice;
     }

     public Integer getQuantity() {
          return quantity;
     }

     public void setQuantity(int quantity) {
          this.quantity = quantity;
     }

     public Boolean isStatus() {
          return status;
     }

     public void setStatus(boolean status) {
          this.status = status;
     }

     @Override
     public String toString() {
          return "ID=" + id + ", Name=" + name + ", Unit Price=" + unitPrice + ", Quantity=" + quantity
                    + ", Status=" + (status ? "Available" : "Non available") + "]";
     }

     @Override
     public int compareTo(Product o) {
          if (this.quantity < o.quantity)
               return 1;
          else if (this.quantity > o.quantity)
               return -1;
          else if (this.quantity == o.quantity)
               if (this.unitPrice < o.unitPrice)
                    return -1;
               else if (this.unitPrice > o.unitPrice)
                    return 1;
          return 0;
     }
}
