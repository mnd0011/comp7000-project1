package sms;

import sms.customer.CustomerModel;
import sms.product.ProductModel;
import sms.purchase.PurchaseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CachedDataAdapter implements IDataAccess
{
    Map<Integer, ProductModel> cachedProducts = new HashMap<>();    
    Map<Integer, CustomerModel> cachedCustomers = new HashMap<>();
    Map<Integer, PurchaseModel> cachedPurchases = new HashMap<>();
    IDataAccess adapter;

    public CachedDataAdapter(IDataAccess adapter) {
        this.adapter = adapter;
    }


    @Override
    public void connect(String path) { this.adapter.connect(path); }


    @Override
    public void saveProduct(ProductModel product)
    {
        adapter.saveProduct(product);
        cachedProducts.put(product.mProductID, product);
    }

    @Override
    public void saveCustomer(CustomerModel customer)
    {
        adapter.saveCustomer(customer);
        cachedCustomers.put(customer.mCustomerID, customer);
    }

    @Override
    public void savePurchase(PurchaseModel purchase)
    {
        adapter.savePurchase(purchase);
        cachedPurchases.put(purchase.mPurchaseID, purchase);
    }

    @Override
    public ArrayList<ProductModel> loadAllProducts()
    {
        ArrayList<ProductModel> products = new ArrayList<ProductModel>();
        for (int i =0; i < cachedProducts.size(); i++)
        {
            products.add(cachedProducts.get(i));

        }
        return products;
    }

    @Override
    public ArrayList<CustomerModel> loadAllCustomers()
    {
        ArrayList<CustomerModel> customers = new ArrayList<CustomerModel>();
        for (int i =0; i < cachedCustomers.size(); i++)
        {
            customers.add(cachedCustomers.get(i));

        }
        return customers;
    }
}
