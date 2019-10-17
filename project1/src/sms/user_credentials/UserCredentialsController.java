package sms.user_credentials;

import sms.customer.AddCustomerController;
import sms.customer.AddCustomerView;
import sms.product.AddProductController;
import sms.product.AddProductView;
import sms.purchase.AddPurchaseController;
import sms.purchase.AddPurchaseView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserCredentialsController
{
    public UserCredentialsView view;

    public UserCredentialsController(UserCredentialsView view, String label)
    {
        this.view = view;
        this.view.lblModule.setText(label);

        view.loginButton.addActionListener(new LoginButtonController());
    }

    class LoginButtonController implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            JFrame frame = null;
            if(view.lblModule.getText() == "Buyer")
            {
                AddProductView addProductView = new AddProductView();
                AddProductController addProductController = new AddProductController(addProductView);
                frame = new JFrame("AddProductView");
                frame.setContentPane(addProductView.addProductPanel);
            }
            else if(view.lblModule.getText() == "CSS")
            {
                    AddCustomerView addCustomerView = new AddCustomerView();
                    AddCustomerController addCustomerController = new AddCustomerController(addCustomerView);
                    frame = new JFrame("AddCustomerView");
                    frame.setContentPane(addCustomerView.addCustomerPanel);
            }
            else if(view.lblModule.getText() == "Sales")
            {
                AddPurchaseView addPurchaseView = new AddPurchaseView();
                AddPurchaseController addCustomerController = new AddPurchaseController(addPurchaseView);
                addPurchaseView.run();
                //frame = new JFrame("AddPurchaseView");
                //frame.setContentPane(addPurchaseView.run());
            }
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
