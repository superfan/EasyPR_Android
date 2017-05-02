package com.aiseminar.platerecognizer.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.aiseminar.platerecognizer.AppConstant;
import com.aiseminar.platerecognizer.R;

public class ShowPicActivity extends Activity {

    private ImageView img;
    private int picWidth;
    private int picHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pic);

        picWidth = getIntent().getIntExtra(AppConstant.KEY.PIC_WIDTH, 0);
        picHeight = getIntent().getIntExtra(AppConstant.KEY.PIC_HEIGHT, 0);
        img = (ImageView)findViewById(R.id.img);
        img.setImageURI(Uri.parse(getIntent().getStringExtra(AppConstant.KEY.IMG_PATH)));
        img.setLayoutParams(new RelativeLayout.LayoutParams(picWidth, picHeight));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            Intent intent = new Intent(ShowPicActivity.this, Camera2Activity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}