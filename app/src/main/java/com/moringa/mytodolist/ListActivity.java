package com.moringa.mytodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText itemET;
    private Button btn;
    private ListView itemList;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        itemET = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.add_btn);
        itemList = findViewById(R.id.item_list);

        items = FileHelper.readData(this);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_btn:
                String itemEntered = itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");

                Toast.makeText(ListActivity.this, "Item Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}