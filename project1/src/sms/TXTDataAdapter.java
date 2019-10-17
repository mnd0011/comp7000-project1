package sms;

import sms.customer.CustomerModel;
import sms.product.ProductModel;
import sms.purchase.PurchaseModel;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class TXTDataAdapter implements IDataAccess
{
    Map<Integer, ProductModel> products = new HashMap<>();
    Map<Integer, CustomerModel> customers = new HashMap<>();
    Map<Integer, PurchaseModel> purchases = new HashMap<>();

    public void connect(String path)
    {
        try
        {
            Scanner scanner = new Scanner(new FileReader(new File(path)));
            if(path.contains("Products"))
            {
                while (scanner.hasNext())
                {
                    ProductModel product = new ProductModel();
                    product.mProductID = scanner.nextInt();
                    scanner.nextLine();
                    product.mName = scanner.nextLine();
                    product.mDescription = scanner.nextLine();
                    product.mPrice = scanner.nextDouble();
                    product.mQuantity = scanner.nextInt();

                    products.put(product.mProductID, product);
                    JOptionPane.showMessageDialog(null, "Product added!");
                }
            }
            else if(path.contains("Customers"))
            {
                while (scanner.hasNext())
                {
                    CustomerModel customer = new CustomerModel();
                    customer.mCustomerID = scanner.nextInt();
                    scanner.nextLine();
                    customer.mName = scanner.nextLine();
                    customer.mAddress = scanner.nextLine();
                    customer.mPhone = scanner.nextLine();
                    customer.mEmail = scanner.nextLine();

                    customers.put(customer.mCustomerID, customer);
                    JOptionPane.showMessageDialog(null, "Customer added!");
                }
            }
            else if(path.contains("Purchases"))
            {
                while (scanner.hasNext())
                {
                    PurchaseModel purchase = new PurchaseModel();
                    purchase.mDate = scanner.nextLine();
                    purchase.mPurchaseID = scanner.nextInt();
                    purchase.mCustomerID = scanner.nextInt();
                    purchase.mProductID = scanner.nextInt();
                    scanner.nextLine();
                    purchase.mPrice = scanner.nextDouble();
                    purchase.mQuantity = scanner.nextInt();
                    purchase.mCost = scanner.nextDouble();
                    purchase.mTax = scanner.nextDouble();
                    purchase.mTotalCost = scanner.nextDouble();

                    purchases.put(purchase.mPurchaseID, purchase);
                    JOptionPane.showMessageDialog(null, "Purchase added!");
                }
            }
            scanner.close();
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Error reading the text file." + e.getMessage());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error reading the text file." + e.getMessage());
        }
    }

    @Override
    public void saveProduct(ProductModel product) {
    }

    @Override
    public void saveCustomer(CustomerModel customer) {
    }

    @Override
    public void savePurchase(PurchaseModel purchase) {
    }

    @Override
    public ArrayList<ProductModel> loadAllProducts(){
        return null;
    }

    @Override
    public ArrayList<CustomerModel> loadAllCustomers(){
        return null;
    }
}