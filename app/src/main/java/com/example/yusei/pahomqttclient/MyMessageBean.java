package com.example.yusei.pahomqttclient;

import java.io.Serializable;

/**
 * Created by yusei on 2018/1/6
 */
public class MyMessageBean implements Serializable {

    private String topic;
    private int Qos;
    private String Content;
    private int action;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getQos() {
        return Qos;
    }

    public void setQos(int qos) {
        Qos = qos;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
