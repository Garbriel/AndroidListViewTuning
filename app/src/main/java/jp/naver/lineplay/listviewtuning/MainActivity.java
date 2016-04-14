package jp.naver.lineplay.listviewtuning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import jp.naver.lineplay.listviewtuning.Activity.ListView1Activity;
import jp.naver.lineplay.listviewtuning.Activity.ListView2Activity;
import jp.naver.lineplay.listviewtuning.Activity.ListView3Activity;
import jp.naver.lineplay.listviewtuning.Activity.ListView4Activity;
import jp.naver.lineplay.listviewtuning.Activity.ListView5Activity;
import jp.naver.lineplay.listviewtuning.Activity.ListView6Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.btn1:
                i = new Intent(this, ListView1Activity.class);
                startActivity(i);
                break;
            case R.id.btn2:
                i = new Intent(this, ListView2Activity.class);
                startActivity(i);
                break;
            case R.id.btn3:
                i = new Intent(this, ListView3Activity.class);
                startActivity(i);
                break;
            case R.id.btn4:
                i = new Intent(this, ListView4Activity.class);
                startActivity(i);
                break;
            case R.id.btn5:
                i = new Intent(this, ListView5Activity.class);
                startActivity(i);
                break;
            case R.id.btn6:
                i = new Intent(this, ListView6Activity.class);
                startActivity(i);
                break;
        }
    }
}
