package com.example.aplikacjazarzdzaniadlugiem;
import android.content.Context;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;


public class ServiceClient {
    /**
     * Client połączenia z serwerem
     */
    private MobileServiceClient mClient;
    private Context mContext;
    private String mMobileBackendUrl = "https://aplikacjazarzadzaniadlugiem.azurewebsites.net";

    public MobileServiceTable<Uzytkownicy> getmUzytkownikTable() {
        return mUzytkownikTable;
    }

    private MobileServiceTable<Uzytkownicy> mUzytkownikTable;

    public MobileServiceTable<Dlugi> getmDlugTable() {
        return mDlugTable;
    }

    private MobileServiceTable<Dlugi> mDlugTable;



    private static ServiceClient mInstance;

    /**
     * Prywatny konstruktor tworzy instancje MobileServiceClient
     *
     * @param context
     * @throws MalformedURLException
     */
    private ServiceClient(Context context) throws MalformedURLException {
        mContext = context;
        mClient = new MobileServiceClient(mMobileBackendUrl, mContext);
        mUzytkownikTable = mClient.getTable(Uzytkownicy.class);
        mDlugTable= mClient.getTable(Dlugi.class);

    }

    /**
     * Inicjalizacja statyczna obiektu ServiceClient jeśli nie istnieje
     *
     * @param context
     * @throws MalformedURLException
     */
    public static void Initialize(Context context) throws MalformedURLException {

             if (mInstance == null) {
                    mInstance = new ServiceClient(context);
             }

    }


    public MobileServiceClient getClient() {
        return mClient;
    }
    public static ServiceClient getmInstance()
    {
        return mInstance;
    }





}
