package com.example.dneprovdanila.stack_overflow_android;

import com.example.dneprovdanila.stack_overflow_android.POJO.API;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APiService {
    //@GET("questions?order=desc&sort=activity&tagged=android&site=stackoverflow")
    @GET("questions?")


    //String link = "https://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged=android&site=stackoverflow";
    //String link2 = "sort=activity&tagged=android&site=stackoverflow";


    Observable<API> getproductdata(@Query("pagesize") int pagesize,
                                   @Query("order") String desc,
                                   @Query("sort") String activity,
                                   @Query("tagged") String android,
                                   @Query("site") String stackoverflow);
}
