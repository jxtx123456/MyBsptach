package com.jsean.mybspatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jsean.lib_bspatch.BsPatchUtil;

import java.io.File;
import java.io.IOException;

import ha.excited.BigNews;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView tv = findViewById(R.id.tv_version);
//        tv.setText("当前版本：" + BuildldConfig.VERSION_NAME);
    }


    public void onUpdate(View view) {
        new AsyncTask<Void, Void, File>() {

            @SuppressLint("StaticFieldLeak")
            @Override
            protected File doInBackground(Void... voids) {
//                String patchPath = new File(Environment.getExternalStorageDirectory(),
//                        "patch.diff").getAbsolutePath();
//                String oldApkPath = getApplicationInfo().sourceDir;
//                File newApk = new File(Environment.getExternalStorageDirectory(), "new.apk");
//                if (!newApk.exists()) {
//                    try {
//                        newApk.createNewFile();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                doPatchNative(oldApkPath, newApk.getAbsolutePath(), patchPath);

                String oldApkPath = Environment.getExternalStorageDirectory()+"/testApk/nhykt-v1.1.13-vc16_Build077.apk";
                String newApkPath = Environment.getExternalStorageDirectory()+"/testApk/new.apk";
                String patchPath = Environment.getExternalStorageDirectory()+"/testApk/13_14.patch";
//                boolean make = BigNews.make(oldApkPath, newApkPath, patchPath);
//                if (make){
//                    return new File(newApkPath);
//                }
//
//                return null;

                BsPatchUtil bsPatchUtil=new BsPatchUtil();
                bsPatchUtil.bsPatch(oldApkPath, patchPath,newApkPath);
                return new File(newApkPath);

            }

            @Override
            protected void onPostExecute(File newApk) {
                //安装
                if (newApk==null || !newApk.exists()) {
                    return;
                }
                Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                if (Build.VERSION.SDK_INT >= 24) { //Android 7.0及以上
//                    // 参数2 清单文件中provider节点里面的authorities ; 参数3  共享的文件,即apk包的file类
//                    Uri apkUri = FileProvider.getUriForFile(MainActivity.this,
//                            getApplicationInfo().packageName + ".provider", newApk);
//                    //对目标应用临时授权该Uri所代表的文件
//                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                    intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
//                } else {
//                    intent.setDataAndType(Uri.fromFile(newApk),
//                            "application/vnd.android.package-archive");
//                }
//                startActivity(intent);
            }
        }.execute();
    }

//    private native void doPatchNative(String oldApkPath, String newApkPath, String patchPath);
}