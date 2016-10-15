package com.example.evgenia.noteslist2;


import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Created by Evgenia on 14.10.2016.
 */
public class MainWidget extends AppWidgetProvider {
    private final static String LOG_TAG = "MainWidget";
    public MainWidget() {
        super();
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(LOG_TAG, "onUpdate");
        for (int i : appWidgetIds) {
            RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget);
            setList(context, i, rv);

            setListClick(context, i, rv);


//            Intent intent = new Intent(context, MainWidget.class);
//            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
//            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            appWidgetManager.updateAppWidget(i, rv);
        }
    }

    protected void setList(Context context, int appWidgetId, RemoteViews rv){
        Intent adapter = new Intent(context, Service.class);
        adapter.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        rv.setRemoteAdapter(R.id.list, adapter);
    }

    protected void updateText(){

    }
    protected void setListClick(Context context, int appWidgetId, RemoteViews rv){
        Intent intent = new Intent(context, enterTextActivity.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_CONFIGURE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, appWidgetId, intent, 0);
        rv.setPendingIntentTemplate(R.id.list, pendingIntent);
    }



    @Override
    public void onEnabled(Context context) {
        Log.d(LOG_TAG, "onEnabled");
        super.onEnabled(context);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(LOG_TAG, "onReceive");
        super.onReceive(context, intent);
    }

    @Override
    public void onDisabled(Context context) {
        Log.d(LOG_TAG, "onDisabled");
        super.onDisabled(context);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(LOG_TAG, "onDeleted");
        super.onDeleted(context, appWidgetIds);
    }

}

