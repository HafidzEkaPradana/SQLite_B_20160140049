package com.hafidz99.sqlite_20160140049;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.hafidz99.sqlite_20160140049.database.DBController;
import com.hafidz99.sqlite_20160140049.database.Teman;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {
    private TextInputEditText tNama,tTelpon;
    private Button btSave;
    String nm,tlp;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        tNama = (TextInputEditText) findViewById(R.id.tietNama);
        tTelpon = (TextInputEditText) findViewById(R.id.tietTelpon);
        btSave = (Button) findViewById(R.id.buttonSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tNama.getText().toString().equals("")||tTelpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Data belum selesai !", Toast.LENGTH_SHORT).show();
                }else {
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String,String>qvalue = new HashMap<>();
                    qvalue.put("nama",nm);
                    qvalue.put("telpon",tlp);

                    controller.insertData(qvalue);
                    callHome();
                }
            }
        });

    }
    public void callHome(){
        Intent intent = new Intent(TemanBaru.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}