package sample.android.example.com.sampleandroid.http.protocol;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;

import sample.android.example.com.sampleandroid.http.ProgressNetDialog;
import sample.android.example.com.sampleandroid.http.vo.Obj;
import sample.android.example.com.sampleandroid.http.ApiService;
import sample.android.example.com.sampleandroid.http.CommonResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sanghwan on 2017. 3. 15..
 */

public class GetRequest {
    private Result12Listener listener;
    final ApiService apiService = ApiService.retrofit.create(ApiService.class);
    public void getTest(Result12Listener classListener, int number) {
        listener = classListener;
        Call<CommonResult<Obj>> contributorCall = apiService.getTest(number);
        contributorCall.enqueue(new Callback<CommonResult<Obj>>() {
            @Override
            public void onResponse(Call<CommonResult<Obj>> call, Response<CommonResult<Obj>> response) {
                listener.onResult12Loaded(response.body());
            }

            @Override
            public void onFailure(Call<CommonResult<Obj>> call, Throwable t) {
                CommonResult<Obj> result = new CommonResult<Obj>();
                result.setCode(400);
                result.setResult(new Obj());
                result.getResult().setHttps(String.valueOf(t.getMessage()));
                listener.onResult12Loaded(result);
            }
        });
    };
    public interface Result12Listener {
        void onResult12Loaded(CommonResult<Obj> result);
    }
}
