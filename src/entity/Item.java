package entity;
/**
 *
 * @author Gokhan
 */
public class Item
{
    private int ItemID;
    private String ItemName;
    private String topping;
    private String filling;
    private String price;

    public Item(int ItemID, String ItemName, String topping, String filling,  String price)
    {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.topping = topping;
        this.filling = filling;
        this.price = price;
    }

    public int getItemID() {
        return ItemID;
    }

    public String getItemName() {
        return ItemName;
    }
    

    public String getTopping() {return topping;}
    public String getFilling() {return filling;}
    public String getPrice() {return price;}

    @Override
    public String toString() {
        return "Item{" + "ItemID=" + ItemID + ", ItemName=" + ItemName + ", topping=" + topping +  ", filling=" + filling + ", price=" + price + '}';
    }
}
