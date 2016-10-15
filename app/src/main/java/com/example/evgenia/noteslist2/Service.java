package com.example.evgenia.noteslist2;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViewsService;

/**
 * Created by Evgenia on 14.10.2016.
 */
public class Service extends RemoteViewsService {
    private final static String LOG_TAG = "Service";
    private ListFactory factory;
    public Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "onBind");
       return super.onBind(intent);
    }

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Log.d(LOG_TAG, "onGetViewFactory");
        return new ListFactory(getApplicationContext(), intent);
    }
}
