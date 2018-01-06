package com.example.yusei.pahomqttclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PubActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edt_pub;
    private Spinner qoSList2;
    private EditText edt_pubmessage;
    private Button btn_pub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub);
        edt_pub = (EditText) findViewById(R.id.edt_pubtopic);
        qoSList2 = (Spinner) findViewById(R.id.QoSList2);
        qoSList2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] qos = getResources().getStringArray(R.array.QoS);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        edt_pubmessage = (EditText) findViewById(R.id.edt_pubmessage);
        btn_pub = (Button) findViewById(R.id.btn_pub);
        btn_pub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MyMessageBean myMessage = new MyMessageBean();
        myMessage.setTopic(edt_pub.getText().toString());
        myMessage.setQos(qoSList2.getSelectedItemPosition());
        myMessage.setContent(edt_pubmessage.getText().toString());
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_pub:
                myMessage.setAction(3);
                intent.putExtra("MyMessageBean", myMessage);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
