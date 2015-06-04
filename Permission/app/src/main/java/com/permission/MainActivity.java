package com.databinding;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_PHONE = 0;
    private static final int PERMISSION_CAMERA = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                        == PackageManager.PERMISSION_GRANTED) {
                } else {
                    requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE},
                            PERMISSION_REQUEST_PHONE);
                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                            PERMISSION_CAMERA);

                }
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_PHONE_STATE},
                        PERMISSION_CAMERA);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
