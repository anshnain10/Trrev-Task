package com.example.trrevtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class getList extends AppCompatActivity {
    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    List<Pojo2> pojolist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_list);
        apiInterface=RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getList.this));
        CustomAdapter ca=new CustomAdapter(pojolist,getList.this);
        recyclerView.setAdapter(ca);
        apiInterface.getMethod().enqueue(new Callback <DataPojo>() {
            @Override
            public void onResponse(Call<DataPojo> call, Response<DataPojo> response) {
                if (response.isSuccessful()){
                    pojolist.addAll(response.body().getData());
                    ca.notifyDataSetChanged();
                    System.out.println(response);

//                    Toast.makeText(getList.this, "List not empty" , Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<DataPojo> call, Throwable t) {
                Toast.makeText(getList.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(t.getLocalizedMessage());

            }
        });
    }

}