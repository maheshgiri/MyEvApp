package com.example.hungry.projectone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener,View.OnClickListener{
protected String names[]={"AA1","AA2"};
protected ListView showInfoListView;
protected Spinner spinnerNames;
protected List<TableInfo> listTableInfo;
private Button addButton, sendButton;
private EditText fromEditText,toEditText,qtyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listTableInfo=new ArrayList<>();
        spinnerNames=(Spinner)findViewById(R.id.spinner);
        showInfoListView=(ListView)findViewById(R.id.listInfo);
        showInfoListView.setAdapter(new ShowListInfoAdaptor());
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,names);
        fromEditText=(EditText)findViewById(R.id.editext_From);
        toEditText=(EditText)findViewById(R.id.editext_To);
        qtyEditText=(EditText)findViewById(R.id.editext_Qty);
        addButton=(Button)findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
        sendButton =(Button)findViewById(R.id.sendButton);
        sendButton.setOnClickListener(this);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerNames.setAdapter(arrayAdapter);
        spinnerNames.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
int calculateTotal(int from,int to,int qty){
 int total=0;
    
    return total;
}
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sendButton:

                break;
            case R.id.addButton:

                break;
        }
    }

    private class ShowListInfoAdaptor extends BaseAdapter {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
