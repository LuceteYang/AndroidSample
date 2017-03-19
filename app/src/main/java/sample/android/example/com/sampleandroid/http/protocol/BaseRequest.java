package sample.android.example.com.sampleandroid.http.protocol;

import android.content.Context;
import android.content.DialogInterface;

import sample.android.example.com.sampleandroid.http.ApiService;
import sample.android.example.com.sampleandroid.http.CommonResult;
import sample.android.example.com.sampleandroid.http.ProgressNetDialog;
import sample.android.example.com.sampleandroid.http.vo.Obj;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sanghwan on 2017. 3. 17..
 */

public class BaseRequest<T> {
    private ProgressNetDialog progressDialog;
    final ApiService apiService = ApiService.retrofit.create(ApiService.class);

    void send(Call<CommonResult<T>> call, final ResultListener listener){
        showLoading((Context)listener);
        call.enqueue(new Callback<CommonResult<T>>() {
            @Override
            public void onResponse(Call<CommonResult<T>> call, Response<CommonResult<T>> response) {
                hideLoading();
                listener.onResultLoaded(response.body());
            }

            @Override
            public void onFailure(Call<CommonResult<T>> call, Throwable t) {
                hideLoading();
                CommonResult<Obj> result = new CommonResult<Obj>();
                result.setCode(400);
                listener.onResultLoaded(result);
            }
        });
    }

    private void showLoading(Context context) {
        //로딩 다이어로그
        if (progressDialog == null) {
            progressDialog = new ProgressNetDialog(context);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    try {
                        Thread.interrupted(); //강제 종료.
                    } catch (Exception e) {
                    }
                }
            });
            progressDialog.show();
        } else if (!progressDialog.isShowing()) {
            progressDialog.show();
        }

    }

    private void hideLoading() {
        //로딩 다이어로그 숨기기
        try {
            if (progressDialog != null) progressDialog.dismiss();
        } catch (Exception e) {
        }
    }

    public interface ResultListener<T> {
        void onResultLoaded(CommonResult<T> result);
    }
}
