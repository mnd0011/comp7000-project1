package sms.launcher;

import sms.user_credentials.UserCredentialsController;
import sms.user_credentials.UserCredentialsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModuleLauncherController
{
    public ModuleLauncherView view;

    public  ModuleLauncherController(ModuleLauncherView view)
    {
        this.view = view;

        view.buyerModuleAccess.addActionListener(new BuyerModuleAccess());
        view.salesModuleAccess.addActionListener(new SalesModuleAccess());
        view.cssModuleAccess.addActionListener(new CssModuleAccess());
    }

    class BuyerModuleAccess implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent actionEvent)
        {
            UserCredentialsView userCredentialsView = new UserCredentialsView();
            UserCredentialsController userCredentialsController = new UserCredentialsController(userCredentialsView, "Buyer");
            JFrame frame = new JFrame("UserCredentials");
            frame.setContentPane(userCredentialsView.userCredentialsPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        }
    }

    class SalesModuleAccess implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            UserCredentialsView userCredentialsView = new UserCredentialsView();
            UserCredentialsController userCredentialsController = new UserCredentialsController(userCredentialsView,"Sales");
            JFrame frame = new JFrame("UserCredentials");
            frame.setContentPane(userCredentialsView.userCredentialsPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        }
    }

    class CssModuleAccess implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            UserCredentialsView userCredentialsView = new UserCredentialsView();
            UserCredentialsController userCredentialsController = new UserCredentialsController(userCredentialsView,"CSS");
            JFrame frame = new JFrame("UserCredentials");
            frame.setContentPane(userCredentialsView.userCredentialsPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
