package com.pawan.topic_3;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    AutoCompleteTextView etBatch;
    Spinner spCountry;
    Button btnSave;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);


        btnSave=findViewById(R.id.btnSave);
        tvResult=findViewById(R.id.tvResult);

        spCountry=findViewById(R.id.spCountry);


        String country[]={"Nepal","India","China"};
        ArrayAdapter adapter=new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,country
                );
        spCountry.setAdapter(adapter);

        String batch[]={"22 C","22 D","20 A","20 B"};

        etBatch=findViewById(R.id.etBatch);
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(this,android.R.layout.select_dialog_item,batch);

        etBatch.setAdapter(stringArrayAdapter);
        etBatch.setThreshold(1);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, batch, country;

                name=etName.getText().toString();
                country=spCountry.getSelectedItem().toString();
                batch=etBatch.getText().toString();

                tvResult.append("name: "+ name +" country: " +country+" batch: "+batch+"\n");


            }
        });
    }
}
