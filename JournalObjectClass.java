package com.journalapp.samuel.journalapp.model_class;

/**
 * Created by SAMUEL on 6/26/2018.
 */

public class JournalObjectClass {
    public String thought_title;
    public String thought_quick_descr;
    public String thought_date;
    public String thought_content;

    public JournalObjectClass(String thought_title, String thought_quick_descr, String thought_date, String thought_content) {
        this.thought_title = thought_title;
        this.thought_quick_descr = thought_quick_descr;
        this.thought_date = thought_date;
        this.thought_content = thought_content;
    }

    public String getThought_title() {
        return thought_title;
    }

    public void setThought_title(String thought_title) {
        this.thought_title = thought_title;
    }

    public String getThought_quick_descr() {
        return thought_quick_descr;
    }

    public void setThought_quick_descr(String thought_quick_descr) {
        this.thought_quick_descr = thought_quick_descr;
    }

    public String getThought_date() {
        return thought_date;
    }

    public void setThought_date(String thought_date) {
        this.thought_date = thought_date;
    }

    public String getThought_content() {
        return thought_content;
    }

    public void setThought_content(String thought_content) {
        this.thought_content = thought_content;
    }
}
