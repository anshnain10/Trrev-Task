package com.example.trrevtask;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("filmdial_app/public/api/auth/get_department")
    Call<DataPojo> getMethod();

    @FormUrlEncoded


    @POST("filmdial_app/public/api/auth/register")
    Call<Model> postMethod(@Field("department_id") int department_id, @Field("name") String name, @Field("phone") String job, @Field("gender") String gender, @Field("email") String email, @Field("address") String address);

}
