/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.flywaydb.core.Flyway;

/**
 *
 * @author Gokhan
 */
public class DB {
    private static final String DB_URL = "jdbc:derby:RestaurantDB;create=true;";
    private static final String MIGRATION_DIR = "db.migrations";
    private static DB instance = null;

    private Connection mConnection;

    private DB() throws SQLException {

        // 1. Load Embedded Derby Driver BEFORE Flyway or JDBC is used
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Derby EmbeddedDriver successfully loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ERROR: Derby Embedded Driver not found in classpath!", e);
        }

        // 2. Run migrations BEFORE opening main connection
        migrateDb();

        // 3. Now safely open the main connection
        mConnection = DriverManager.getConnection(DB_URL);
        System.out.println("Connected to Derby Embedded Database!");
    }

    /**
     * Singleton instance
     */
    public static DB getInstance() {
        if (instance == null) {
            try {
                instance = new DB();
            } catch (SQLException ex) {
                System.err.println("Database Error: " + ex.toString());
                System.exit(1);
            }
        }
        return instance;
    }

    /**
     * INSERT, UPDATE, DELETE
     */
    public int executeUpdate(String sql) throws SQLException {
        return mConnection.createStatement().executeUpdate(sql);
    }

    /**
     * SELECT without parameters
     */
    public ResultSet executeQuery(String sql) throws SQLException {
        return mConnection.createStatement().executeQuery(sql);
    }

    /**
     * SELECT with parameters
     */
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return mConnection.prepareStatement(sql);
    }

    /**
     * Run Flyway SQL migrations (table creation, initial data, etc.)
     */
    private void migrateDb() {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Flyway: Derby driver missing!", e);
        }

        try {
            Flyway flyway = new Flyway();
            flyway.setDataSource(DB_URL, null, null); // embedded mode has no username/password
            flyway.setLocations(MIGRATION_DIR);       // SQL files go in /src/main/resources/db/migrations or your configured folder
            flyway.migrate();

            System.out.println("Flyway migration completed successfully!");
        } catch (Exception e) {
            throw new RuntimeException("Flyway migration FAILED: " + e.getMessage(), e);
        }
    }
}
