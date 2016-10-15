package com.example.evgenia.noteslist2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;

/**
 * Created by Evgenia on 14.10.2016.
 */
public class ListFactory implements RemoteViewsService.RemoteViewsFactory {
    private final static String LOG_TAG = "ListFactory";

    private ArrayList<ListNoteObj> notes = new ArrayList<>();
    private int notesAmount = 10;
    private Context context;


    public ListFactory(Context context, Intent intent) {
        notes = new ArrayList<>();
        this.context = context;
    }

    @Override
    public void onCreate() {
        for(int i = 0; i < notesAmount; i++){
            notes.add(new ListNoteObj(i, false, "text" + (i+1)));
        }
        Log.d(LOG_TAG, "onCreate : create list items from beginning");
    }

    @Override
    public void onDataSetChanged() {
        Log.d(LOG_TAG, "onDataSetChanged");
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        Log.d(LOG_TAG, "getViewAt");
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.item);
        ListNoteObj note = notes.get(position);
        initViews(rv, note);
        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        Log.d(LOG_TAG, "getLoadingView");
        return null;
    }

    @Override
    public int getViewTypeCount() {
        Log.d(LOG_TAG, "getViewTypeCount");
        return 1;
    }

    @Override
    public long getItemId(int position) {
        Log.d(LOG_TAG, "getItemId");
        return notes.get(position).hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    protected void initViews(RemoteViews rv, ListNoteObj note){
        rv.setTextViewText(R.id.text, note.getText());
        if(note.isDone()){
            rv.setImageViewResource(R.id.button, R.drawable.check);
        }else{
            rv.setImageViewResource(R.id.button, R.drawable.check_off);
        }
    }

}
