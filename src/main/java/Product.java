import java.io.*;
import java.util.ArrayList;

public class Product implements java.io.Serializable {
    private int id,stock_quantity;
    private String name;

    public Product() {
    }

    public Product(int id, String name, int stock_quantity) {
        this.id = id;
        this.name = name;
        this.stock_quantity = stock_quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void serializeProduct(ArrayList<Product> product_list)
    {




        try {

            FileOutputStream fileOut =
                    new FileOutputStream("products.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(product_list);
            out.close();
            fileOut.close();
            System.out.printf("Product added successfully!\n\n");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public ArrayList<Product> deserializeProducts()
    {
        ArrayList<Product> prodList= new ArrayList();
        try {
            FileInputStream fileIn = new FileInputStream("products.ser");
            ObjectInputStream object_input = new ObjectInputStream(fileIn);
            prodList =  (ArrayList<Product>) object_input.readObject();
            object_input.close();
            fileIn.close();
        } catch (IOException i) {
            //i.printStackTrace();
            System.out.println("No product available yet");
            return prodList;
        } catch (ClassNotFoundException c) {
            System.out.println("Membere class not found");
            c.printStackTrace();
            return prodList;
        }

        System.out.println("Deserialized products...");


        return prodList;
    }

}
