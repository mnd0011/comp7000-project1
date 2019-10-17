package sms;

import sms.customer.CustomerModel;
import sms.product.ProductModel;
import sms.purchase.PurchaseModel;

import java.util.ArrayList;

public interface IDataAccess
{
    public void connect(String path);
    public void saveProduct(ProductModel product);
    public void savePurchase(PurchaseModel purchase);
    public void saveCustomer(CustomerModel customer);
    public ArrayList<ProductModel> loadAllProducts();
    public ArrayList<CustomerModel> loadAllCustomers();
}