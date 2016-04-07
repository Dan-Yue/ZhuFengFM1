package com.cain.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.cain.listviewdemo.adapter.MessageAdapter;
import com.cain.listviewdemo.model.ChatMessage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_View);
        List<ChatMessage> messages = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ChatMessage message = new ChatMessage("小红","你好");
            if (i%3==0){
                message.setIsOut(true);
            }
            messages.add(message);
        }
        MessageAdapter adapter = new MessageAdapter(this,messages);
        listView.setAdapter(adapter);
    }
}
