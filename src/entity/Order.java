package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gokhan
 */
public class Order
{
    private int ID;
    private int price;
    private String dateTime;
    private List<Item> items;

    public Order(int ID, int price, String dateTime)
    {
        this.ID = ID;
        this.price = price;
        this.dateTime = dateTime;
        this.items = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public String getDateTime() {
        return dateTime;
    }

    public List<Item> getItems() {
        return items;
    }


    @Override
    public String toString() {
        return "Order{" + "ID=" + ID + ", price=" + price + ", dateTime=" + dateTime + ", items=" + items + '}';
    }
}
