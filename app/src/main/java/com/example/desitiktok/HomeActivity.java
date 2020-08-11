package com.example.desitiktok;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {
    private ImageView sound_dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        init();

    }

    private void init() {

        sound_dis=(ImageView) findViewById(R.id.disc);
        Glide.with(this).load(R.drawable.disc).into(sound_dis);

        //////////////////////////////////////
        if(Build.VERSION.SDK_INT>=19 && Build.VERSION.SDK_INT<21){
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,true);
        }
        if(Build.VERSION.SDK_INT>=19){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
        if(Build.VERSION.SDK_INT>=21){
            setWindowFlag(this,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
    public static void setWindowFlag(Activity activity,final int bits, boolean on){
        Window win=activity.getWindow();
        WindowManager.LayoutParams winParams=win.getAttributes();
        if(on){
            winParams.flags |=bits;
        }
        else{
            winParams.flags&=~bits;
        }
        win.setAttributes(winParams);
    }
}
