package com.licoba.niuofflinedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import com.niutrans.translator.Translator;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private  static  final  int  REQUEST_EXTERNAL_STORAGE  =  1;
    private  static  String[]  PERMISSIONS_STORAGE  =  {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
    };
    public String text = "how are you ?";
    public  static  void  Permissions(Activity activity)  {
        //  Check  if  we  have  write  permission
        int  permission_write  =  ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int  permission_state  =  ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.READ_PHONE_STATE);

        if  (permission_write  !=  PackageManager.PERMISSION_GRANTED  ||
                permission_state  !=  PackageManager.PERMISSION_GRANTED)  {
            //  We  don't  have  permission  so  prompt  the  user
            ActivityCompat.requestPermissions(activity,  PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }

    @Override
    protected  void  onCreate(Bundle  savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Permissions(this);	//  获取读取设备文件的相关权限
        File f  =  Environment.getExternalStorageDirectory();    //  获得设备的根目录路径
        TextView tTitle=(TextView)findViewById(R.id.tTitle);

        Translator  handler  =  new Translator();
        boolean  init_result  =  handler.load("en",  "ja",  getApplicationContext());

        if(init_result)  {
            String output  =  handler.translate(text);
            System.out.println(output);
            tTitle.append("初始化成功!\n\n");

            tTitle.append("翻译原文："+text+"\n\n");

            tTitle.append("翻译结果："+output+"\n\n");
        }
        else{
            tTitle.append("初始化失败!\n\n");
        }

        handler.unload();
    }
}