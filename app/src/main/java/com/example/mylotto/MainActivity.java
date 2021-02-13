package com.example.mylotto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner sp_lotto;
    private Button btn_lotto;
    private RecyclerView recyclerView;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lotto = (Button)findViewById(R.id.btn_lotto);
        sp_lotto = (Spinner)findViewById(R.id.sp_lotto);
        recyclerView = (RecyclerView)findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        spinnerSet();
        lottoSet();
    }
    // Set Lotto Number
    public void lottoSet(){
        Lotto_adapter adapter = new Lotto_adapter(this);
        btn_lotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.removeItem();
                recyclerView.setAdapter(adapter);
                adapter.addItem(num);     // Make Random 6Numbers "num" times
            }
        });
    }
    // Set Spinner for make Lotto times
    public void spinnerSet(){
        SpinnerItem spinnerItem = new SpinnerItem();

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, spinnerItem.getList());
        sp_lotto.setAdapter(arrayAdapter);

        sp_lotto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                num = spinnerItem.getList().get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}