package com.example.sharewherever;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String TAG = "Nasif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onSharedIntent();
    }
    private void onSharedIntent() {
        Intent receivedIntent = getIntent();
        String receivedAction = receivedIntent.getAction();
        String receivedType = receivedIntent.getType();

        if (receivedAction.equals(Intent.ACTION_SEND)) {
            if (receivedType.startsWith("text/")) {
                String receivedText = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);

                if (receivedText != null) {
                    Log.d(TAG, "onSharedIntent: " + receivedText);
                    AlertDialog alert = new AlertDialog.Builder(this)
                            .setTitle("Received text")
                            .setMessage("Test")

                            .setPositiveButton(receivedText, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                }
            }
//            else if (receivedType.startsWith("image/")) {
//
//                Uri receivedUri = (Uri) receivedIntent.getParcelableExtra(Intent.EXTRA_STREAM);
//
//                if (receivedUri != null) {
//
//                }
//            }

        } else if (receivedAction.equals(Intent.ACTION_MAIN)) {
            Log.e(TAG, "onSharedIntent: nothing shared" );
            setTheme(R.style.AppTheme);
            setContentView(R.layout.activity_main);
        }
    }
}