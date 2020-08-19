package com.neusoft.debing.intenttent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Detai extends AppCompatActivity {

    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai);

        textView =findViewById(R.id.textView2);
        editText =findViewById(R.id.editText);
        //接受并查看intent
        Intent intent =getIntent();
        String str = intent.getStringExtra("data");//获取数据
        textView.setText(str);

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String str =editText.getText().toString();//获取内容，toString转换成字符串
                i.putExtra("param",str);//放入内容
                setResult(1,i);//送回内容
                finish();//关闭当前页面
            }
        });
    }


}
