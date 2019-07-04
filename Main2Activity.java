package com.example.lenovo.myhealth;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class Main2Activity extends AppCompatActivity implements AIListener {

    AIService aiService;
    TextView tv;
    //private static final int RECORD_REQUEST_CODE=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        if (bundle !=null){
            if (bundle.getString("bot")!=null){
                Toast.makeText(getApplicationContext(), "chatdata:"+bundle.getString("bot"), Toast.LENGTH_SHORT).show();
            }
        }

        tv=findViewById(R.id.textView);
        int permission= ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        if (permission != PackageManager.PERMISSION_GRANTED){
            makeRequest();

        }
        final AIConfiguration config = new AIConfiguration("50cbd573ff5d47a894c4de5001466487",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        aiService = AIService.getService(this, config);
        aiService.setListener(this);
    }


    protected void makeRequest(){

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 101: {
                if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            }
        }
    }


    public void buttonClicked(View v){

        aiService.startListening();

    }

    @Override
    public void onResult(AIResponse result) {
        Result result1=result.getResult();
        tv.setText("Query"+result1.getResolvedQuery()+"action:"+result1.getAction());


    }

    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
