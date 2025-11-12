package entity;
/**
 *
 * @author Gokhan
 */
public class Order
{
    private int ID;
    private int price;
    private String dateTime;
    private String itemName;
    private int customerID;

    public Order(int ID, int price, String dateTime, String itemName, int customerID)
    {
        this.ID = ID;
        this.price = price;
        this.dateTime = dateTime;
        this.itemName = itemName;
        this.customerID = customerID;
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

    public String getItemName() {
        return itemName;
    }

    public int getCustomerID() {
        return customerID;
    }

    @Override
    public String toString() {
        return "Order{" + "ID=" + ID + ", price=" + price + ", dateTime=" + dateTime + ", itemName=" + itemName + ", customerID=" + customerID + '}';
    }
}
