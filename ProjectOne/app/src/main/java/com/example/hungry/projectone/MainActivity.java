package com.example.hungry.projectone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    protected String names[] = {"AA1", "AA2"};
    protected ListView showInfoListView;
    protected Spinner spinnerNames;
    protected List<TableInfo> listTableInfo;
    private Button addButton, sendButton;
    private EditText fromEditText, toEditText, qtyEditText;
    private int from, to, qty,totalSum=0;
    private String code;
    ArrayAdapter arrayAdapter;
    TextView totalSumTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listTableInfo = new ArrayList<>();
        spinnerNames = (Spinner) findViewById(R.id.spinner);
        showInfoListView = (ListView) findViewById(R.id.listInfo);
        showInfoListView.setAdapter(new ShowListInfoAdaptor(listTableInfo));
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, names);
        fromEditText = (EditText) findViewById(R.id.editext_From);
        toEditText = (EditText) findViewById(R.id.editext_To);
        qtyEditText = (EditText) findViewById(R.id.editext_Qty);
        fromEditText.setText("100");
        qtyEditText.setText("1");
        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
        sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(this);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerNames.setAdapter(arrayAdapter);
        totalSumTextView=(TextView)findViewById(R.id.textViewTotleSum);
        spinnerNames.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       code=names[position];
    }

    int calculateTotal(int from, int to, int qty) {
        int total = 0;
        total=((to+1)-from)*qty;
        if(total<0) total=total*(-1);
        return total;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendButton:

                break;
            case R.id.addButton:
                addData();
                break;
        }
    }

    private void addData() {
        TableInfo tableInfo = new TableInfo();
        tableInfo.setFrom(Integer.parseInt(fromEditText.getText().toString()));
        Log.d("From", fromEditText.getText().toString());
        if (toEditText.getText().toString().length() > 0 && toEditText.getText().toString() != "")
            tableInfo.setTo(Integer.parseInt(toEditText.getText().toString()));
        else tableInfo.setTo(Integer.parseInt(fromEditText.getText().toString()));//else set to
        Log.d("To", toEditText.getText().toString());
        tableInfo.setQty(Integer.parseInt(qtyEditText.getText().toString()));
        Log.d("Qty", qtyEditText.getText().toString());
        tableInfo.setCode(code);
        int theTotal=calculateTotal(tableInfo.getFrom(),tableInfo.getTo(),tableInfo.getQty());
        totalSum=totalSum+theTotal;
        tableInfo.setTotal(theTotal);
        totalSumTextView.setText(""+totalSum);
        tableInfo.setTotalSum(totalSum);
        listTableInfo.add(tableInfo);

        arrayAdapter.notifyDataSetChanged();
    }

    private class ShowListInfoAdaptor extends BaseAdapter {
        List<TableInfo> listTableInfo;
        public ShowListInfoAdaptor(List<TableInfo> listTableInfo) {
            updateResults(listTableInfo);
        }
        public void updateResults(List<TableInfo> results) {
            listTableInfo = results;
            //Triggers the list update
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            if (listTableInfo.isEmpty()) return 0;
            else return listTableInfo.size();
        }

        @Override
        public Object getItem(int position) {
            return listTableInfo.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
              LayoutInflater layoutInflater=getLayoutInflater();
              View view=layoutInflater.inflate(R.layout.activity_showinfo, null);
            TextView fromTextView=(TextView)view.findViewById(R.id.textViewFrom);
            TextView codeTextView=(TextView)view.findViewById(R.id.textViewCode);
            TextView toTextView=(TextView)view.findViewById(R.id.textViewTo);
            TextView qtyTextView=(TextView)view.findViewById(R.id.textViewQty);
            TextView totalTextView=(TextView)view.findViewById(R.id.textViewTotal);
            fromTextView.setText(""+listTableInfo.get(position).getFrom());
            toTextView.setText(""+listTableInfo.get(position).getTo());
            codeTextView.setText(listTableInfo.get(position).getCode());
            qtyTextView.setText(""+listTableInfo.get(position).getQty());
            totalTextView.setText(""+listTableInfo.get(position).getTotal());
            return view;
        }

        @Override
        public void notifyDataSetChanged() {
         super.notifyDataSetChanged();
        }
    }
}
