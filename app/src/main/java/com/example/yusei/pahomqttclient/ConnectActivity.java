package com.example.yusei.pahomqttclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ConnectActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edt_host;
    private EditText edt_port;
    private EditText edt_username;
    private EditText edt_password;
    private EditText edt_clientid;
    private EditText edt_keepalive;
    private EditText edt_timeout;
    private CheckBox cb_cleansession;
    private Button btn_connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        edt_host = (EditText) findViewById(R.id.edt_host);
        edt_port = (EditText) findViewById(R.id.edt_port);
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_password = (EditText) findViewById(R.id.edt_password);
        edt_clientid = (EditText) findViewById(R.id.edt_clientid);
        edt_keepalive = (EditText) findViewById(R.id.edt_keepalive);
        edt_timeout = (EditText) findViewById(R.id.edt_timeout);
        cb_cleansession = (CheckBox) findViewById(R.id.cb_cleansession);
        btn_connect = (Button) findViewById(R.id.btn_connect);
        btn_connect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MQTTBean mqtt = new MQTTBean();
        mqtt.setHost("tcp://" + edt_host.getText().toString() + ":" + edt_port.getText().toString());
        mqtt.setUsername(edt_username.getText().toString());
        mqtt.setPassword(edt_password.getText().toString());
        mqtt.setClientID(edt_clientid.getText().toString());
        mqtt.setKeepalive(Integer.valueOf(edt_keepalive.getText().toString()));
        mqtt.setTimeout(Integer.valueOf(edt_timeout.getText().toString()));
        mqtt.setCleanSession(cb_cleansession.isChecked());
        switch (v.getId()) {
            case R.id.btn_connect:
                Intent intent = new Intent();
                intent.putExtra("MQTTBean", mqtt);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
