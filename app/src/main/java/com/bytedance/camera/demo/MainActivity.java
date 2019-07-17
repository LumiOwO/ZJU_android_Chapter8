package com.bytedance.camera.demo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bytedance.camera.demo.utils.Utils;

public class MainActivity extends AppCompatActivity {

    public static final int PERMISSION_DENY = 9;
    private static final int CODE_CUSTOM_CAMERA = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_picture).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TakePictureActivity.class));
        });

        findViewById(R.id.btn_camera).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RecordVideoActivity.class));
        });

        findViewById(R.id.btn_custom).setOnClickListener(v -> {
            startActivityForResult(new Intent(MainActivity.this, CustomCameraActivity.class)
                , CODE_CUSTOM_CAMERA);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE_CUSTOM_CAMERA && resultCode == PERMISSION_DENY)
            Toast.makeText(this, "权限申请失败", Toast.LENGTH_SHORT).show();
    }
}
