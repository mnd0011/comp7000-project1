package sms;

import sms.customer.CustomerModel;
import sms.product.ProductModel;
import sms.purchase.PurchaseModel;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class SQLiteDataAdapter implements IDataAccess
{
    Connection conn = null;
    public void connect(String connectionString)
    {
        try
        {

            String url = "jdbc:sqlite:" + connectionString;
            conn = DriverManager.getConnection(url);

            JOptionPane.showMessageDialog(null,"Connection to SQLite has been established.",
                    "Store Management System",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void saveProduct(ProductModel product)
    {
        try
        {
            String sql = "INSERT INTO Products ('Name','Description', 'Price', 'Quantity')" +
                            "VALUES ('"+product.mName+"','"+product.mDescription+"','"+product.mPrice+"','"+product.mQuantity+"')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Product Added!","Store Management System",JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Store Management System",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void savePurchase(PurchaseModel purchase)
    {
        try
        {
            String sql = "INSERT INTO Purchases ('Date','PurchaseID','CustomerID', 'ProductID', 'Price', 'Quantity'," +
                    "'Cost','Tax','TotalCost')" +
                    "VALUES ('"+purchase.mDate+"','"+purchase.mPurchaseID+"','"+purchase.mCustomerID+"'," +
                    "'"+purchase.mProductID+"','"+purchase.mPrice+"','"+purchase.mQuantity+"','"+purchase.mCost+"'," +
                    "'"+purchase.mTax+"','"+purchase.mTotalCost+"')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Purchase Added!","Store Management System",JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Store Management System",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveCustomer(CustomerModel customer)
    {
        try
        {
            String sql = "INSERT INTO Customers ('Name','Address', 'Email', 'Phone')" +
                    "VALUES ('" + customer.mName + "','" + customer.mAddress + "','" + customer.mEmail + "','" + customer.mPhone + "')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Customer Added!", "Store Management System", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Store Management System", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<ProductModel> loadAllProducts()
    {
        try
        {
            ArrayList<ProductModel> products = new ArrayList<ProductModel>();

            String sql = "SELECT * FROM Products";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int productID = rs.getInt("ProductID");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price"); //type is real in db
                int qty = rs.getInt("Quantity");
                products.add(new ProductModel(productID,name,description,price,qty));
            }
            return products;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error loading Products." + e.getMessage());
            return null;
        }
    }

    public ArrayList<CustomerModel> loadAllCustomers()
    {
        try
        {
            ArrayList<CustomerModel> customers = new ArrayList<CustomerModel>();

            String sql = "SELECT * FROM Customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int customerID = rs.getInt("CustomerID");
                String name = rs.getString("Name");
                String phone = rs.getString("Phone");
                String address = rs.getString("Address");
                String email = rs.getString("Email");
                customers.add(new CustomerModel(customerID,name,phone,address,email));
            }
            return customers;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error loading Customers." + e.getMessage());
            return null;
        }
    }
}
