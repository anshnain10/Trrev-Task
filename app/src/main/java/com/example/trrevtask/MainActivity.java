package com.example.trrevtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String [] Gender={"MALE","FEMALE","OTHERS"};
    private AutoCompleteTextView autoCompleteTextView;
    private Button button,button2;
    private EditText editName, editPhone, editGender, editEmail, editAddress,editDepartment;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView=findViewById(R.id.editGender);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, Gender);
        autoCompleteTextView.setThreshold(0);
        autoCompleteTextView.setAdapter(adapter);
        editName=findViewById(R.id.editName);
        editPhone=findViewById(R.id.editPhone);
        editGender=findViewById(R.id.editGender);
        editDepartment=findViewById(R.id.editDepartment);
        editEmail=findViewById(R.id.editEmail);
        editAddress=findViewById(R.id.editAddress);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,getList.class);
                startActivity(intent);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editName.getText().toString();
                String phone=editPhone.getText().toString();
                String gender=editGender.getText().toString();
                String email=editEmail.getText().toString();
                String address=editAddress.getText().toString();
                String id=editDepartment.getText().toString();
                apiInterface=RetrofitInstance.getRetrofit().create(ApiInterface.class);
                Call<Model> call= apiInterface.postMethod(Integer.valueOf(id),name,phone,gender,email,address);
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Toast.makeText(MainActivity.this, "Data Posted Successfully...", Toast.LENGTH_SHORT).show();
                        System.out.println("1"+response.body().getOtp());
                        System.out.println("2"+response.body().getMessage());
                        System.out.println("3"+response.body().getStatus());
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}