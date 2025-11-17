package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ItemDAO implements DAO<Item> {

    public ItemDAO() {}

    private List<Item> Items;

    @Override
    public Optional<Item> get(int id) {
        DB db = DB.getInstance();
        try {
            String sql = "SELECT ITEM_ID, ITEM_NAME, TOPPING, FILLING, PRICE FROM ITEMS WHERE ITEM_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Item item = null;

            if (rs.next()) {
                item = new Item(
                        rs.getInt("ITEM_ID"),
                        rs.getString("ITEM_NAME"),
                        rs.getString("TOPPING"),
                        rs.getString("FILLING"),
                        rs.getString("PRICE")   // PRICE = VARCHAR
                );
            }
            return Optional.ofNullable(item);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return Optional.empty();
        }
    }

    @Override
    public List<Item> getAll() {
        DB db = DB.getInstance();
        Items = new ArrayList<>();

        try {
            String sql = "SELECT ITEM_ID, ITEM_NAME, TOPPING, FILLING, PRICE FROM ITEMS";
            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("ITEM_ID"),
                        rs.getString("ITEM_NAME"),
                        rs.getString("TOPPING"),
                        rs.getString("FILLING"),
                        rs.getString("PRICE")   // PRICE = VARCHAR
                );
                Items.add(item);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return Items;  // never return null
    }

    @Override
    public void insert(Item item) {
        DB db = DB.getInstance();

        try {
            String sql = "INSERT INTO ITEMS (ITEM_ID, ITEM_NAME, TOPPING, FILLING, PRICE) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);

            stmt.setInt(1, item.getItemID());
            stmt.setString(2, item.getItemName());
            stmt.setString(3, item.getTopping());
            stmt.setString(4, item.getFilling());
            stmt.setString(5, item.getPrice());   // PRICE = VARCHAR

            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new Item was inserted successfully!");
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void update(Item item) {
        DB db = DB.getInstance();

        try {
            String sql = "UPDATE ITEMS SET ITEM_NAME=?, TOPPING=?, FILLING=?, PRICE=? WHERE ITEM_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);

            stmt.setString(1, item.getItemName());
            stmt.setString(2, item.getTopping());
            stmt.setString(3, item.getFilling());
            stmt.setString(4, item.getPrice());   // PRICE = VARCHAR
            stmt.setInt(5, item.getItemID());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Item was updated successfully!");
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(Item item) {
        DB db = DB.getInstance();

        try {
            String sql = "DELETE FROM ITEMS WHERE ITEM_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, item.getItemID());

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An Item was deleted successfully!");
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        List<String> headers = new ArrayList<>();

        try {
            String sql = "SELECT ITEM_ID, ITEM_NAME, TOPPING, FILLING, PRICE FROM ITEMS WHERE 1=0";
            ResultSet rs = db.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();
            int numberCols = rsmd.getColumnCount();

            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return headers;
    }
}
