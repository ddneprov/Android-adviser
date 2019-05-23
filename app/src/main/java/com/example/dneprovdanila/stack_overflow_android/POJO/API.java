package com.example.dneprovdanila.stack_overflow_android.POJO;

import com.example.dneprovdanila.stack_overflow_android.POJO.Item;

import java.util.ArrayList;

public class API {
    private ArrayList<Item> items;
    private Boolean has_more;
    private Integer quota_max;
    private Integer quota_remaining;



    public ArrayList<Item> getItems() {
        return items;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public Integer getQuota_max() {
        return quota_max;
    }

    public Integer getQuota_remaining() {
        return quota_remaining;
    }

}
