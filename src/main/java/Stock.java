import java.io.*;
import java.util.ArrayList;

public class Stock {

    private int id,stock_quantity;
    private String name;

    public Stock() {
    }

    public Stock(int id, String name, int stock_quantity) {
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



    public static void serializeStock(ArrayList<Stock> product_list)
    {




        try {

            FileOutputStream fileOut =
                    new FileOutputStream("products.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(product_list);
            out.close();
            fileOut.close();
            System.out.printf("Schedule generated successfully!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static ArrayList<Stock> deserializeStocks()
    {
        ArrayList<Stock> prodList= new ArrayList();
        try {
            FileInputStream fileIn = new FileInputStream("products.ser");
            ObjectInputStream object_input = new ObjectInputStream(fileIn);
            prodList =  (ArrayList<Stock>) object_input.readObject();
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
