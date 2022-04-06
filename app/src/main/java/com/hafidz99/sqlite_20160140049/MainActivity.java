package com.hafidz99.sqlite_20160140049;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hafidz99.sqlite_20160140049.adapter.TemanAdapter;
import com.hafidz99.sqlite_20160140049.database.DBController;
import com.hafidz99.sqlite_20160140049.database.Teman;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TemanAdapter temanAdapter;
    private ArrayList<Teman> temanArrayList;
    private FloatingActionButton fab;

    DBController controller = new DBController(this);
    String id,nm,tlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.floatingButton);
        BacaData();
        recyclerView = findViewById(R.id.recycleView);
        temanAdapter = new TemanAdapter(temanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(temanAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TemanBaru.class);
                startActivity(intent);
            }
        });

    }
    public void BacaData(){
        ArrayList<HashMap<String ,String>> daftarTeman = controller.getAllTeman();
        temanArrayList = new ArrayList<>();
        for(int i=0; i<daftarTeman.size();i++){
            Teman teman = new Teman();

            teman.setId(daftarTeman.get(i).get("id").toString());
            teman.setNama(daftarTeman.get(i).get("nama").toString());
            teman.setTelpon(daftarTeman.get(i).get("telpon").toString());

            temanArrayList.add(teman);
        }
    }
}