package com.example.macstudent.carparkingsystem;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class InstructionActivity extends Activity {

    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
       myWebView = (WebView) findViewById(R.id.webViewInstruction);
        myWebView.loadUrl("file:///android_asset/instruction.html");
    }
}