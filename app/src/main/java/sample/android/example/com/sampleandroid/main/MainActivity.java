package sample.android.example.com.sampleandroid.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.firebase.iid.FirebaseInstanceId;

import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.android.example.com.sampleandroid.R;
import sample.android.example.com.sampleandroid.common.Dlog;
import sample.android.example.com.sampleandroid.config.PropertyManager;
import sample.android.example.com.sampleandroid.db.Test;
import sample.android.example.com.sampleandroid.http.CommonResult;
import sample.android.example.com.sampleandroid.http.protocol.GetOriRequest;
import sample.android.example.com.sampleandroid.http.protocol.GetRequest;
import sample.android.example.com.sampleandroid.http.vo.Obj;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements GetRequest.Result12Listener, GetOriRequest.ResultListener<Obj> {

    private static final String TAG = "MainActivity";
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String token = FirebaseInstanceId.getInstance().getToken();
        Dlog.d("dddd   "+token);
        realm =  Realm.getDefaultInstance();
        Toast.makeText(getApplicationContext(),"Property "+ PropertyManager.getInstance().getToken(),Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Realm size"+ String.valueOf(realm.where(Test.class).findAll().size()),Toast.LENGTH_SHORT).show();

    }
    @OnClick(R.id.btn_get)
    void btnGet() {
        new GetOriRequest().getTest(MainActivity.this,666);
    }

    @OnClick(R.id.btn_post)
    void btnPost(){
    }

    @OnClick(R.id.btn_form)
    void btnForm(){
        PropertyManager.getInstance().setToken("form");
        realm.beginTransaction();
        Test ing = realm.createObject(Test.class);
        ing.setTest("dddd");
        realm.commitTransaction();
    }
    @OnClick(R.id.btn_header)
    void btnHeader(){
    }

    @Override
    public void onResult12Loaded(CommonResult<Obj> result) {
        if(result.getCode()==300){
            Toast.makeText(getApplicationContext(),String.valueOf(result.getCode())+" "+result.getResult().getHttps(),Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),String.valueOf(result.getCode())+" "+result.getResult().getHttps(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResultLoaded(CommonResult<Obj> result) {
        if(result.getCode()==300){
            Toast.makeText(getApplicationContext(),String.valueOf(result.getCode())+" "+result.getResult().getHttps(),Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),String.valueOf(result.getCode())+" "+result.getResult().getHttps(),Toast.LENGTH_SHORT).show();
        }
    }


}
