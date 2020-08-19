package com.neusoft.debing.intenttent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public  class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                //Intent显示调用
              //  1.创建一个Intent
                Intent q =new Intent();
              // 2.指定当前的应用程序上下文以及要启动的Activity；设置要跳转的目的地
                q.setClass(this,Detai.class);
              // 3.指定当前的应用程序上下文以及要启动的Activity；启动新的actibity
                startActivity(q);//启动新的actibity
                break;
            case R.id.button2:
                //Intent显示调用
                Intent i =new Intent(this, Detai.class);
                i.putExtra("data","打开包裹，查看里面信息！");//放数据
                startActivityForResult(i,1);
                break;

            //隐式调用
            case R.id.button4:
                // 1. 调用搜索引擎（无法访问谷歌搜索引擎）
                Intent w =new Intent();//实例化Intent
                w.setAction(Intent.ACTION_WEB_SEARCH);//指定动作
                w.putExtra(SearchManager.QUERY,"安卓 intent使用方法");//设置数据
                startActivity(w);//启动这个应用
                break;
            case R.id.button5:
                // 2. 打开网址（网址一定是http开头）
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.button6:
                //3.显示地图
                Uri uri =Uri.parse("geo:38.899533,-77.036476");
                Intent it =new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
                break;
            case R.id.button7:
                //4.拨打电话
                Uri uri1 =Uri.parse("tel:13568942542");
                Intent e =new Intent(Intent.ACTION_DIAL,uri1);
                startActivity(e);
                break;
            case R.id.button8:
                //5.编辑短信
                Uri uri2 =Uri.parse("smsto:10086");
                Intent r =new Intent(Intent.ACTION_SENDTO,uri2);
                r.putExtra("sms_body","你已经欠费，请尽快充值！");
                startActivity(r);
                break;
        }
    }
    //再次接收返回的内容
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            String str =data.getStringExtra("param");//获取内容
            TextView textView =findViewById(R.id.textView);//显示到textview
            textView.setText(str);
        }
    }
}
