package program;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import entity.*;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Main extends javax.swing.JFrame {

    private static ItemDAO ItemDAO;
    private static OrderDAO OrderDAO;

    public Main() {
        initComponents();
        refreshItemsTable();
        refreshOrdersTable();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTabbedPaneDonutShop = new javax.swing.JTabbedPane();
        jPanelItem = new javax.swing.JPanel();
        jScrollPaneItem = new javax.swing.JScrollPane();
        jTableItem = new javax.swing.JTable();
        jTextFieldItemID = new javax.swing.JTextField();
        jTextFieldItemName = new javax.swing.JTextField();
        jTextFieldItemTopping = new javax.swing.JTextField();
        jTextFieldItemFilling = new javax.swing.JTextField();
        jLabelItemFilling = new javax.swing.JLabel();
        jTextFieldItemPrice = new javax.swing.JTextField();
        jLabelItemPrice = new javax.swing.JLabel();
        jLabelItemTopping = new javax.swing.JLabel();
        jLabelItemName = new javax.swing.JLabel();
        jLabelItemID = new javax.swing.JLabel();
        jButtonInsertItem = new javax.swing.JButton();
        jButtonUpdateItem = new javax.swing.JButton();
        jButtonDeleteItem = new javax.swing.JButton();
        jPanelOrder = new javax.swing.JPanel();
        jScrollPaneOrder = new javax.swing.JScrollPane();
        jTableOrder = new javax.swing.JTable();
        jTextFieldOrderID = new javax.swing.JTextField();
        jLabelOrderID = new javax.swing.JLabel();
        jLabelOrderItemID = new javax.swing.JLabel();
        jTextFieldOrderItemID = new javax.swing.JTextField();
        jTextFieldOrderPrice = new javax.swing.JTextField();
        jLabelOrderPrice = new javax.swing.JLabel();
        jLabelOrderDateTime = new javax.swing.JLabel();
        jButtonInsertOrder = new javax.swing.JButton();
        jButtonUpdateOrder = new javax.swing.JButton();
        jButtonDeleteOrder = new javax.swing.JButton();
        jLabelOrderItemName = new javax.swing.JLabel();
        jTextFieldOrderItemName = new javax.swing.JTextField();
        dateTimePickerOrderDateTime = new com.github.lgooddatepicker.components.DateTimePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("oak Donut");
        setResizable(false);

        jTabbedPaneDonutShop.setName("Item");

        jTableItem.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "ID", "Name", "Topping", "Filling", "Price"
                }
        ));
        jTableItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableItemMouseClicked(evt);
            }
        });
        jScrollPaneItem.setViewportView(jTableItem);

        jLabelItemFilling.setText("Filling");
        jLabelItemTopping.setText("Topping");
        jLabelItemName.setText("Name");
        jLabelItemID.setText("ID");
        jLabelItemPrice.setText("Price");

        jButtonInsertItem.setText("Insert");
        jButtonInsertItem.addActionListener(evt -> jButtonInsertItemActionPerformed(evt));

        jButtonUpdateItem.setText("Update");
        jButtonUpdateItem.addActionListener(evt -> jButtonUpdateItemActionPerformed(evt));

        jButtonDeleteItem.setText("Delete");
        jButtonDeleteItem.addActionListener(evt -> jButtonDeleteItemActionPerformed(evt));

        javax.swing.GroupLayout jPanelItemLayout = new javax.swing.GroupLayout(jPanelItem);
        jPanelItem.setLayout(jPanelItemLayout);
        jPanelItemLayout.setHorizontalGroup(
                jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelItemID)
                                        .addComponent(jLabelItemName)
                                        .addComponent(jLabelItemTopping)
                                        .addComponent(jLabelItemFilling)
                                        .addComponent(jLabelItemPrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldItemName)
                                        .addComponent(jTextFieldItemID)
                                        .addComponent(jTextFieldItemTopping)
                                        .addComponent(jTextFieldItemFilling)
                                        .addComponent(jTextFieldItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonInsertItem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonUpdateItem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPaneItem, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanelItemLayout.setVerticalGroup(
                jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelItemLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPaneItem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelItemLayout.createSequentialGroup()
                                                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelItemID)
                                                        .addComponent(jTextFieldItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonInsertItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelItemName)
                                                        .addComponent(jTextFieldItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonUpdateItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelItemTopping)
                                                        .addComponent(jTextFieldItemTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelItemFilling)
                                                        .addComponent(jTextFieldItemFilling, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelItemPrice)
                                                        .addComponent(jTextFieldItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPaneDonutShop.addTab("Item", jPanelItem);

        jTableOrder.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Order ID", "Items", "Order Price", "Order Date Time", "Item List"
                }
        ));
        jTableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrderMouseClicked(evt);
            }
        });
        jScrollPaneOrder.setViewportView(jTableOrder);

        jLabelOrderID.setText("Order ID");
        jLabelOrderItemID.setText("Item IDs (comma-separated)");
        jLabelOrderPrice.setText("Order Price");
        jLabelOrderDateTime.setText("Order Date Time");
        jLabelOrderItemName.setText("Item Name (display only)");

        jButtonInsertOrder.setText("Insert");
        jButtonInsertOrder.addActionListener(evt -> jButtonInsertOrderActionPerformed(evt));

        jButtonUpdateOrder.setText("Update");
        jButtonUpdateOrder.addActionListener(evt -> jButtonUpdateOrderActionPerformed(evt));

        jButtonDeleteOrder.setText("Delete");
        jButtonDeleteOrder.addActionListener(evt -> jButtonDeleteOrderActionPerformed(evt));

        javax.swing.GroupLayout jPanelOrderLayout = new javax.swing.GroupLayout(jPanelOrder);
        jPanelOrder.setLayout(jPanelOrderLayout);
        jPanelOrderLayout.setHorizontalGroup(
                jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelOrderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelOrderID)
                                        .addComponent(jLabelOrderItemID)
                                        .addComponent(jLabelOrderPrice)
                                        .addComponent(jLabelOrderDateTime)
                                        .addComponent(jLabelOrderItemName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldOrderID)
                                        .addComponent(jTextFieldOrderItemID)
                                        .addComponent(jTextFieldOrderPrice)
                                        .addComponent(dateTimePickerOrderDateTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldOrderItemName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonInsertOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                        .addComponent(jButtonUpdateOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                        .addComponent(jButtonDeleteOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPaneOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanelOrderLayout.setVerticalGroup(
                jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelOrderLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPaneOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelOrderLayout.createSequentialGroup()
                                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelOrderID)
                                                        .addComponent(jTextFieldOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonInsertOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelOrderItemID)
                                                        .addComponent(jTextFieldOrderItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonUpdateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelOrderPrice)
                                                        .addComponent(jTextFieldOrderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelOrderDateTime)
                                                        .addComponent(dateTimePickerOrderDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelOrderItemName)
                                                        .addComponent(jTextFieldOrderItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPaneDonutShop.addTab("Order", jPanelOrder);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneDonutShop));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneDonutShop));

        pack();
        setLocationRelativeTo(null);
    }

    private void jTableItemMouseClicked(java.awt.event.MouseEvent evt) {
        int i = jTableItem.getSelectedRow();
        TableModel model = jTableItem.getModel();
        jTextFieldItemID.setText(model.getValueAt(i, 0).toString());
        jTextFieldItemName.setText(model.getValueAt(i, 1).toString());
        jTextFieldItemTopping.setText(model.getValueAt(i, 2).toString());
        jTextFieldItemFilling.setText(model.getValueAt(i, 3).toString());
        jTextFieldItemPrice.setText(model.getValueAt(i, 4).toString());
    }

    private void jTableOrderMouseClicked(java.awt.event.MouseEvent evt) {
        int i = jTableOrder.getSelectedRow();
        TableModel model = jTableOrder.getModel();

        jTextFieldOrderID.setText(model.getValueAt(i, 0).toString());
        jTextFieldOrderItemID.setText(model.getValueAt(i, 1).toString());
        jTextFieldOrderPrice.setText(model.getValueAt(i, 2).toString());

        String date = model.getValueAt(i, 3).toString();

        LocalDate date1 = LocalDate.of(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)),
                Integer.parseInt(date.substring(8, 10))
        );
        LocalTime time1 = LocalTime.of(
                Integer.parseInt(date.substring(11, 13)),
                Integer.parseInt(date.substring(14, 16))
        );

        dateTimePickerOrderDateTime.datePicker.setDate(date1);
        dateTimePickerOrderDateTime.timePicker.setTime(time1);

        jTextFieldOrderItemName.setText(model.getValueAt(i, 4).toString());
    }

    private void jButtonInsertItemActionPerformed(java.awt.event.ActionEvent evt) {
        if (!jTextFieldItemID.getText().isEmpty()) {
            int ID = Integer.parseInt(jTextFieldItemID.getText().trim());
            String Name = jTextFieldItemName.getText().trim();
            String Topping = jTextFieldItemTopping.getText().trim();
            String Filling = jTextFieldItemFilling.getText().trim();
            String Price = jTextFieldItemPrice.getText().trim();

            primaryKeyViolationItem(ID);
            addItem(ID, Name, Topping, Filling, Price);
            refreshItemsTable();
            clearItemTextFields();
        } else {
            alert("ID cannot be empty");
        }
    }

    private void jButtonUpdateItemActionPerformed(java.awt.event.ActionEvent evt) {
        if (!jTextFieldItemID.getText().isEmpty()) {
            int ID = Integer.parseInt(jTextFieldItemID.getText().trim());
            String Name = jTextFieldItemName.getText().trim();
            String Topping = jTextFieldItemTopping.getText().trim();
            String Filling = jTextFieldItemFilling.getText().trim();
            String Price = jTextFieldItemPrice.getText().trim();

            Item old = getItem(ID);
            if (old.getItemID() != -1) {
                updateItem(ID, Name, Topping, Filling, Price);
                refreshItemsTable();
            } else {
                alert("Item does not exist", "Update error");
            }
        } else {
            alert("ID cannot be empty", "Update error");
        }
    }

    private void jButtonDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {
        if (!jTextFieldItemID.getText().isEmpty()) {
            int ID = Integer.parseInt(jTextFieldItemID.getText().trim());
            String Name = jTextFieldItemName.getText().trim();
            String Topping = jTextFieldItemTopping.getText().trim();
            String Filling = jTextFieldItemFilling.getText().trim();
            String Price = jTextFieldItemPrice.getText().trim();

            Item it = getItem(ID);
            if (it.getItemID() != -1) {
                int option = JOptionPane.showConfirmDialog(rootPane,
                        "Are you sure you want to delete?", "Delete confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    deleteItem(ID, Name, Topping, Filling, Price);
                    refreshItemsTable();
                    clearItemTextFields();
                }
            } else {
                alert("Item does not exist", "Delete error");
            }
        } else {
            alert("ID cannot be empty", "Delete error");
        }
    }

    private void jButtonInsertOrderActionPerformed(java.awt.event.ActionEvent evt) {
        if (!jTextFieldOrderID.getText().isEmpty()) {

            int ID = Integer.parseInt(jTextFieldOrderID.getText().trim());
            int price = Integer.parseInt(jTextFieldOrderPrice.getText().trim());
            String date = dateTimePickerOrderDateTime.datePicker.getDateStringOrEmptyString()
                    + " " + dateTimePickerOrderDateTime.timePicker.getTimeStringOrEmptyString()
                    + ":00.0";

            String raw = jTextFieldOrderItemID.getText().trim();
            String[] ids = raw.split(",");

            List<Item> items = new ArrayList<>();
            for (String s : ids) {
                int itemId = Integer.parseInt(s.trim());
                Item it = getItem(itemId);
                if (it.getItemID() == -1) {
                    alert("Item ID " + itemId + " does not exist.", "Foreign Key");
                    return;
                }
                items.add(it);
            }

            primaryKeyViolationOrder(ID);

            Order order = new Order(ID, price, date);
            order.getItems().addAll(items);

            OrderDAO.insert(order);
            refreshOrdersTable();
            clearOrderTextFields();

        } else {
            alert("Order ID cannot be empty", "Insert error");
        }
    }

    private void jButtonUpdateOrderActionPerformed(java.awt.event.ActionEvent evt) {
        if (!jTextFieldOrderID.getText().isEmpty()) {

            int ID = Integer.parseInt(jTextFieldOrderID.getText().trim());
            int price = Integer.parseInt(jTextFieldOrderPrice.getText().trim());
            String date = dateTimePickerOrderDateTime.datePicker.getDateStringOrEmptyString()
                    + " " + dateTimePickerOrderDateTime.timePicker.getTimeStringOrEmptyString()
                    + ":00.0";

            String raw = jTextFieldOrderItemID.getText().trim();
            String[] ids = raw.split(",");

            List<Item> items = new ArrayList<>();
            for (String s : ids) {
                int itemId = Integer.parseInt(s.trim());
                Item it = getItem(itemId);
                if (it.getItemID() == -1) {
                    alert("Item ID " + itemId + " does not exist.", "Foreign Key");
                    return;
                }
                items.add(it);
            }

            Order existing = getOrder(ID);
            if (existing.getID() != -1) {

                Order order = new Order(ID, price, date);
                order.getItems().addAll(items);

                OrderDAO.update(order);
                refreshOrdersTable();

            } else {
                alert("Order does not exist", "Update error");
            }

        } else {
            alert("Order ID cannot be empty", "Update error");
        }
    }

    private void jButtonDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {
        if (!jTextFieldOrderID.getText().isEmpty()) {

            int ID = Integer.parseInt(jTextFieldOrderID.getText().trim());
            int price = Integer.parseInt(jTextFieldOrderPrice.getText().trim());
            String date = dateTimePickerOrderDateTime.datePicker.getDateStringOrEmptyString()
                    + " " + dateTimePickerOrderDateTime.timePicker.getTimeStringOrEmptyString()
                    + ":00.0";

            Order existing = getOrder(ID);
            if (existing.getID() != -1) {

                int option = JOptionPane.showConfirmDialog(rootPane,
                        "Are you sure you want to delete?",
                        "Delete confirmation",
                        JOptionPane.YES_NO_OPTION);

                if (option == 0) {
                    Order order = new Order(ID, price, date);
                    OrderDAO.delete(order);
                    refreshOrdersTable();
                    clearOrderTextFields();
                }

            } else {
                alert("Order does not exist", "Delete error");
            }

        } else {
            alert("Order ID cannot be empty", "Delete error");
        }
    }

    private void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    private void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    private void foreignKeyViolationOrder(int id) {
        if (getItem(id).getItemID() == -1) {
            alert("Item ID does not exist", "Foreign Key Violation");
        }
    }

    private void primaryKeyViolationItem(int id) {
        if (getItem(id).getItemID() != -1) {
            alert("Another Item already exists with the same ID.", "Primary Key Violation");
        }
    }

    private void primaryKeyViolationOrder(int id) {
        if (getOrder(id).getID() != -1) {
            alert("Another Order already exists with the same ID.", "Primary Key Violation");
        }
    }

    private static void addItem(int id, String Name, String Topping, String Filling, String Price) {
        Item it = new Item(id, Name, Topping, Filling, Price);
        ItemDAO.insert(it);
    }

    private static void updateItem(int id, String Name, String Topping, String Filling, String Price) {
        Item it = new Item(id, Name, Topping, Filling, Price);
        ItemDAO.update(it);
    }

    private static void deleteItem(int id, String Name, String Topping, String Filling, String Price) {
        Item it = new Item(id, Name, Topping, Filling, Price);
        ItemDAO.delete(it);
    }

    static Item getItem(int id) {
        Optional<Item> it = ItemDAO.get(id);
        return it.orElseGet(() -> new Item(-1, "Non-exist", "Non-exist", "Non-exist", "Non-exist"));
    }

    private static void addOrder(Order order) {
        OrderDAO.insert(order);
    }

    static Order getOrder(int id) {
        Optional<Order> order = OrderDAO.get(id);
        return order.orElseGet(() -> new Order(-1, -1, "Non-exist"));
    }

    private void clearItemTextFields() {
        jTextFieldItemID.setText("");
        jTextFieldItemName.setText("");
        jTextFieldItemTopping.setText("");
        jTextFieldItemFilling.setText("");
        jTextFieldItemPrice.setText("");
    }

    private void clearOrderTextFields() {
        jTextFieldOrderID.setText("");
        jTextFieldOrderItemID.setText("");
        jTextFieldOrderPrice.setText("");
        jTextFieldOrderItemName.setText("");
    }

    private void refreshItemsTable() {
        List<Item> items = ItemDAO.getAll();
        DefaultTableModel model = (DefaultTableModel) jTableItem.getModel();
        model.setRowCount(0);

        for (Item it : items) {
            Object[] row = new Object[5];
            row[0] = it.getItemID();
            row[1] = it.getItemName();
            row[2] = it.getTopping();
            row[3] = it.getFilling();
            row[4] = it.getPrice();
            model.addRow(row);
        }
    }

    private void refreshOrdersTable() {
        List<Order> orders = OrderDAO.getAll();
        DefaultTableModel model = (DefaultTableModel) jTableOrder.getModel();
        model.setRowCount(0);

        for (Order order : orders) {

            // Build item description
            StringBuilder sb = new StringBuilder();
            for (Item it : order.getItems()) {
                sb.append(it.getItemID())
                        .append(" (")
                        .append(it.getItemName())
                        .append("), ");
            }
            String itemString = sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";

            model.addRow(new Object[]{
                    order.getID(),
                    itemString,
                    order.getPrice(),
                    order.getDateTime(),
                    itemString
            });
        }
    }


    public static void main(String args[]) {
        ItemDAO = new ItemDAO();
        OrderDAO = new OrderDAO();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePickerOrderDateTime;
    private javax.swing.JButton jButtonDeleteItem;
    private javax.swing.JButton jButtonDeleteOrder;
    private javax.swing.JButton jButtonInsertItem;
    private javax.swing.JButton jButtonInsertOrder;
    private javax.swing.JButton jButtonUpdateItem;
    private javax.swing.JButton jButtonUpdateOrder;
    private javax.swing.JLabel jLabelItemFilling;
    private javax.swing.JLabel jLabelItemName;
    private javax.swing.JLabel jLabelItemID;
    private javax.swing.JLabel jLabelItemTopping;
    private javax.swing.JLabel jLabelItemPrice;
    private javax.swing.JLabel jLabelOrderItemID;
    private javax.swing.JLabel jLabelOrderItemName;
    private javax.swing.JLabel jLabelOrderDateTime;
    private javax.swing.JLabel jLabelOrderID;
    private javax.swing.JLabel jLabelOrderPrice;
    private javax.swing.JPanel jPanelItem;
    private javax.swing.JPanel jPanelOrder;
    private javax.swing.JScrollPane jScrollPaneItem;
    private javax.swing.JScrollPane jScrollPaneOrder;
    private javax.swing.JTabbedPane jTabbedPaneDonutShop;
    private javax.swing.JTable jTableItem;
    private javax.swing.JTable jTableOrder;
    private javax.swing.JTextField jTextFieldItemFilling;
    private javax.swing.JTextField jTextFieldItemName;
    private javax.swing.JTextField jTextFieldItemID;
    private javax.swing.JTextField jTextFieldItemTopping;
    private javax.swing.JTextField jTextFieldItemPrice;
    private javax.swing.JTextField jTextFieldOrderItemID;
    private javax.swing.JTextField jTextFieldOrderItemName;
    private javax.swing.JTextField jTextFieldOrderID;
    private javax.swing.JTextField jTextFieldOrderPrice;

}
