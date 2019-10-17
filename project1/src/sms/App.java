package sms;

import sms.storemgr.StoreManager;

public class App
{
    public static void main(String[] args)
    {
        StoreManager.getInstance().run();
    }
}
