package DB;

import Resources.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eee on 14.05.2017.
 */
public class Database {
    private static final String IP = "127.0.0.1";
    private static final String PORT = "5432";
    private static final String DB = "mary92";

    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty321";

    private static final String Category_TableName = "Category";
    private static final String CategoryID_ColumnName = "category_id";
    private static final String CategoryName_ColumnName = "category_name";


    private static final String Client_TableName = "Clients";
    private static final String ClientID_ColumnName = "client_id";
    private static final String ClientName_ColumnName = "client_name";
    private static final String ClientAddress_ColumnName = "address";
    private static final String ClientPhone_ColumnName = "clientt_phone";


    private static final String Courier_TableName = "Couriers";
    private static final String CourierID_ColumnName = "courier_id";
    private static final String CourierName_ColumnName = "courier_name";
    private static final String CourierIsWorking_ColumnName = "courier_status";
    private static final String CourierPhone_ColumnName = "courier_phone";


    private static final String Product_TableName = "Product";
    private static final String ProductID_ColumnName = "product_id";
    private static final String ProductCategory_ColumnName = "category_id";
    private static final String ProductName_ColumnName = "product_name";
    private static final String ProductConsist_ColumnName = "consist";
    private static final String ProductPrice_ColumnName = "price";
    private static final String ProductMeasure_ColumnName = "measure";

    static Connection connection;
    public static void Connect() throws SQLException {
        connection = DriverManager
                .getConnection("jdbc:postgresql://" + IP + ":" + PORT + "/" + DB,
                        USER, PASSWORD);
        connection.setAutoCommit(false);
    }

    public static List<Category> GetCategories() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM " + Category_TableName + ";" );

        List<Category> l = new ArrayList<>();
        while (rs.next()){
            String name = rs.getString(CategoryName_ColumnName);
            int id = rs.getInt(CategoryID_ColumnName);

            Category cat = new Category(id);
            cat.setName(name);
            l.add(cat);
        }
        rs.close();
        stmt.close();
        return l;
    }

    public static void UpdateCategories(List<Category> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Category car : categories){
            stmt.executeUpdate("UPDATE " + Category_TableName + " SET " + CategoryName_ColumnName + " = '" + car.getName() + "' where " + CategoryID_ColumnName + " = " + car.getID());
        }
        connection.commit();
        stmt.close();
    }

    public static List<Category> AddCategories(List<Category> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Category car : categories){
            stmt.executeUpdate("INSERT INTO " + Category_TableName + " (" + CategoryName_ColumnName + ") VALUES ('" + car.getName() + "');", Statement.RETURN_GENERATED_KEYS);
        }
        ResultSet rs = stmt.getGeneratedKeys();
        int i = 0;
        if (rs != null && rs.next()) {
            categories.get(i).setID(rs.getInt(1));

        }
        connection.commit();
        stmt.close();

        return categories;
    }

    public static void RemoveCategories(List<Category> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Category car : categories){
            stmt.executeUpdate("DELETE FROM " + Category_TableName + " where " + CategoryID_ColumnName + " = " + car.getID());
        }
        connection.commit();
        stmt.close();
    }


    public static List<Client> GetClients() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM " + Client_TableName + ";" );

        List<Client> l = new ArrayList<>();
        while (rs.next()){
            String name = rs.getString(ClientName_ColumnName);
            String address = rs.getString(ClientAddress_ColumnName);
            String phone = rs.getString(ClientPhone_ColumnName);
            int id = rs.getInt(ClientID_ColumnName);

            Client cat = new Client();
            cat.setID(id);
            cat.setName(name);
            cat.setAddress(address);
            cat.setPhone(phone);
            l.add(cat);
        }
        rs.close();
        stmt.close();
        return l;
    }

    public static void UpdateClients(List<Client> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Client car : categories){
            stmt.executeUpdate("UPDATE " + Client_TableName + " SET " +
                    ClientName_ColumnName + " = '" + car.getName() + "', "+
                    ClientAddress_ColumnName + "= '" + car.getAddress() + "', " +
                    ClientPhone_ColumnName + "= '" + car.getPhone() + "' where " + ClientID_ColumnName + " = " + car.getID());
        }
        connection.commit();
        stmt.close();
    }

    public static List<Client> AddClients(List<Client> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Client car : categories){
            stmt.executeUpdate("INSERT INTO " + Client_TableName + " (" + ClientName_ColumnName + ", " + ClientPhone_ColumnName + ", " + ClientAddress_ColumnName + ") VALUES ( " +
                    "'" + car.getName() + "', " +
                    "'" + car.getPhone() + "',  " +
                    "'" + car.getAddress() + "'" + " );", Statement.RETURN_GENERATED_KEYS);
        }
        ResultSet rs = stmt.getGeneratedKeys();
        int i = 0;
        if (rs != null && rs.next()) {
            categories.get(i).setID(rs.getInt(1));

        }
        connection.commit();
        stmt.close();

        return categories;
    }

    public static void RemoveClients(List<Client> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Client car : categories){
            stmt.executeUpdate("DELETE FROM " + Client_TableName + " where " + ClientID_ColumnName + " = " + car.getID());
        }
        connection.commit();
        stmt.close();
    }


    public static List<Courier> GetCouriers() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM " + Courier_TableName + ";" );

        List<Courier> l = new ArrayList<>();
        while (rs.next()){
            String name = rs.getString(CourierName_ColumnName);
            Boolean isWorking = rs.getBoolean(CourierIsWorking_ColumnName);
            String phone = rs.getString(CourierPhone_ColumnName);
            int id = rs.getInt(CourierID_ColumnName);

            Courier cat = new Courier();
            cat.setID(id);
            cat.setName(name);
            cat.isWorking = isWorking;
            cat.setPhone(phone);
            l.add(cat);
        }
        rs.close();
        stmt.close();
        return l;
    }

    public static void UpdateCouriers(List<Courier> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Courier car : categories){
            stmt.executeUpdate("UPDATE " + Courier_TableName + " SET " +
                    CourierName_ColumnName + " = '" + car.getName() + "', "+
                    CourierIsWorking_ColumnName + "= '" + car.isWorking + "', " +
                    CourierPhone_ColumnName + "= '" + car.getPhone() + "' where " + CourierID_ColumnName + " = " + car.getID());
        }
        connection.commit();
        stmt.close();
    }

    public static List<Courier> AddCouriers(List<Courier> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Courier car : categories){
            stmt.executeUpdate("INSERT INTO " + Courier_TableName + " (" + CourierName_ColumnName + ", " + CourierPhone_ColumnName + ", " + CourierIsWorking_ColumnName + ") VALUES ( " +
                    "'" + car.getName() + "', " +
                    "'" + car.getPhone() + "', " +
                    "'" + car.isWorking + "'" + " );", Statement.RETURN_GENERATED_KEYS);
        }
        ResultSet rs = stmt.getGeneratedKeys();
        int i = 0;
        if (rs != null && rs.next()) {
            categories.get(i).setID(rs.getInt(1));

        }
        connection.commit();
        stmt.close();

        return categories;
    }

    public static void RemoveCouriers(List<Courier> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Courier car : categories){
            stmt.executeUpdate("DELETE FROM " + Courier_TableName + " where " + CourierID_ColumnName + " = " + car.getID());
        }
        connection.commit();
        stmt.close();
    }

    public static List<Product> GetProducts() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM " + Product_TableName + ";" );

        List<Category> categories = GetCategories();
        List<Product> l = new ArrayList<>();
        while (rs.next()){
            String name = rs.getString(ProductName_ColumnName);
            int categoryid = rs.getInt(ProductCategory_ColumnName);
            String consist = rs.getString(ProductConsist_ColumnName);
            String measure = rs.getString(ProductMeasure_ColumnName);
            double price = rs.getDouble(ProductPrice_ColumnName);
            int id = rs.getInt(ProductID_ColumnName);

            Product cat = new Product();
            cat.setID(id);
            cat.setName(name);
            cat.setConsist(consist);
            try{
                cat.setMeasure(Measure.valueOf(measure));
            }catch (Exception e) { }
            cat.setPrice(price);
            for (Category category : categories){
                if( category.getID() == categoryid ) {
                    cat.setCategory(category);
                    break;
                }
            }
            l.add(cat);
        }
        rs.close();
        stmt.close();
        return l;
    }

    public static void UpdateProducts(List<Product> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Product car : categories){
            String additional = "";
            if(car.getCategory() != null){
                additional += ProductCategory_ColumnName + "= '" + car.getCategory().getID() + "', ";
            }
            if(car.getMeasure() != null){
                additional += ProductMeasure_ColumnName + "= '" + car.getMeasure().name() + "', ";
            }
            stmt.executeUpdate("UPDATE " + Product_TableName + " SET " +
                    ProductName_ColumnName + " = '" + car.getName() + "', "+
                    ProductConsist_ColumnName + "= '" + car.getConsist() + "', " +
                    ProductPrice_ColumnName + "= '" + car.getPrice() + "', " +
                    additional +  "' where " + ProductID_ColumnName + " = " + car.getID());
        }
        connection.commit();
        stmt.close();
    }

    public static List<Product> AddProducts(List<Product> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Product car : categories){
            String additionalName = "";
            String additional = "";

            if(car.getCategory() != null){
                additionalName += ProductCategory_ColumnName + ", ";
                additional += "'" + car.getCategory().getID() + "', ";
            }
            if(car.getMeasure() != null){
                additionalName += ProductMeasure_ColumnName + ", ";
                additional += "'" + car.getMeasure().name() + "', ";
            }

            stmt.executeUpdate("INSERT INTO " + Product_TableName + " (" + ProductName_ColumnName + ", " + ProductConsist_ColumnName + ", " + additionalName + ProductPrice_ColumnName + ") VALUES ( " +
                    "'" + car.getName() + "', " +
                    "'" + car.getConsist() + "', " +
                    additional +
                    "'" + car.getPrice() + "'" + " );", Statement.RETURN_GENERATED_KEYS);
        }
        ResultSet rs = stmt.getGeneratedKeys();
        int i = 0;
        if (rs != null && rs.next()) {
            categories.get(i).setID(rs.getInt(1));

        }
        connection.commit();
        stmt.close();

        return categories;
    }

    public static void RemoveProducts(List<Product> categories) throws SQLException {
        Statement stmt = connection.createStatement();

        for(Product car : categories){
            stmt.executeUpdate("DELETE FROM " + Courier_TableName + " where " + CourierID_ColumnName + " = " + car.getID());
        }
        connection.commit();
        stmt.close();
    }
}
