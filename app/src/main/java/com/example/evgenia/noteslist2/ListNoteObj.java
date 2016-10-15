package com.example.evgenia.noteslist2;

/**
 * Created by Evgenia on 14.10.2016.
 */
public class ListNoteObj {
    private int orderNum;
    private boolean done;
    private String text;

    public ListNoteObj(int orderNum, String text, boolean done){

    }

    public ListNoteObj(int orderNum, boolean done, String text) {
        this.orderNum = orderNum;
        this.done = done;
        this.text = text;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public boolean isDone() {
        return done;
    }

    public String getText() {
        return text;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setText(String text) {
        this.text = text;
    }
}
