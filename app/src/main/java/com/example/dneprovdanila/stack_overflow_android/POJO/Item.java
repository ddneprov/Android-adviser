package com.example.dneprovdanila.stack_overflow_android.POJO;

import java.util.ArrayList;

public class Item {


    private ArrayList<String> tags;

    private Owner owner;

    private Boolean is_answered;
    private Integer view_count;
    private Integer answer_count;
    private Integer score;
    private Long last_activity_date;
    private Long creation_date;
    private Long last_edit_date;
    private  Integer question_id;
    private String link;
    private String title;

    public ArrayList<String> getTags() {
        return tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public Boolean getIs_answered() {
        return is_answered;
    }

    public Integer getView_count() {
        return view_count;
    }

    public Integer getAnswer_count() {
        return answer_count;
    }

    public Integer getScore() {
        return score;
    }

    public Long getLast_activity_date() {
        return last_activity_date;
    }

    public Long getCreation_date() {
        return creation_date;
    }

    public Long getLast_edit_date() {
        return last_edit_date;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }
}
