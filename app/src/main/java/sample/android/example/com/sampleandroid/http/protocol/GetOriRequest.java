package sample.android.example.com.sampleandroid.http.protocol;


import android.content.Context;

import sample.android.example.com.sampleandroid.http.CommonResult;
import sample.android.example.com.sampleandroid.http.vo.Obj;
import retrofit2.Call;

/**
 * Created by sanghwan on 2017. 3. 15..
 */

public class GetOriRequest extends BaseRequest {
    public void getTest(ResultListener classListener, int number) {
        Call<CommonResult<Obj>> contributorCall = apiService.getTest(number);
        send(contributorCall,classListener);
    };
}
