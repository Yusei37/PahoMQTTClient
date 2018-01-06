package com.example.yusei.pahomqttclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.example.yusei.pahomqttclient.R;

public class SubActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edt_sub;
    private Spinner qoSList;
    private Button btn_sub;
    private Button btn_unsub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edt_sub = (EditText) findViewById(R.id.edt_subtopic);
        qoSList = (Spinner) findViewById(R.id.QoSList);
        qoSList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] qos = getResources().getStringArray(R.array.QoS);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_sub.setOnClickListener(this);
        btn_unsub = (Button) findViewById(R.id.btn_unsub);
        btn_unsub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MyMessageBean myMessage = new MyMessageBean();
        myMessage.setTopic(edt_sub.getText().toString());
        myMessage.setQos(qoSList.getSelectedItemPosition());
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_sub:
                myMessage.setAction(1);
                intent.putExtra("MyMessageBean", myMessage);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_unsub:
                myMessage.setAction(2);
                intent.putExtra("MyMessageBean", myMessage);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
