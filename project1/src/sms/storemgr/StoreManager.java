package sms.storemgr;

import sms.IDataAccess;
import sms.SQLiteDataAdapter;
import sms.TXTDataAdapter;
import sms.launcher.ModuleLauncherController;
import sms.launcher.ModuleLauncherView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class StoreManager
{
    IDataAccess adapter;
    ModuleLauncherView mView;
    ModuleLauncherController mController;

    static StoreManager instance = null;

    public static StoreManager getInstance()
    {
        if (instance == null) {
            instance = new StoreManager();
            instance.setup();
        }
        return instance;
    }

    public IDataAccess getDataAccess() { return adapter; }

    private void setup()
    {
        JOptionPane.showMessageDialog(null,"Hello! Please select a database/text file to proceed",
                "Store Management System",JOptionPane.PLAIN_MESSAGE);

        String connectionString = getDbPath();

        if(!connectionString.isEmpty())
        {
            try
            {
                if(connectionString.contains("db"))
                {
                    adapter = new SQLiteDataAdapter();
                    adapter.connect(connectionString);

                    mView = new ModuleLauncherView();
                    mController = new ModuleLauncherController(mView);
                    JFrame frame = new JFrame("ModuleLauncher");
                    frame.setContentPane(mView.mainFrame);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.pack();
                    frame.setVisible(true);
                }
                else if (connectionString.contains("txt"))
                {
                    adapter = new TXTDataAdapter();
                    JOptionPane.showMessageDialog(null,"Please ensure that your text file is named correctly ('Customers' or 'Products').",
                            "Store Management System",JOptionPane.WARNING_MESSAGE);
                    adapter.connect(connectionString);
                }
            }
            catch (Exception ex)
            {
                adapter = null;
            };
        }
        else
            JOptionPane.showMessageDialog(null,"No database/text file selected.", "Store Management System",JOptionPane.PLAIN_MESSAGE);
    }

    public void run()
    {
        if(mView != null) mView.mainFrame.setVisible(true);
    }

    private static String getDbPath()
    {
        JFileChooser dbChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("databases, text files", "db", "txt");
        dbChooser.setFileFilter(filter);
        int returnVal = dbChooser.showOpenDialog(null);
        String connectionString = "";

        if(returnVal == JFileChooser.APPROVE_OPTION)
            connectionString = dbChooser.getSelectedFile().getAbsolutePath();

        return connectionString;
    }

}