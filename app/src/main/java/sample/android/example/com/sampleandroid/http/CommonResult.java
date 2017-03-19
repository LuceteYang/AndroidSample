package sample.android.example.com.sampleandroid.http;

/**
 * Created by sanghwan on 2017. 3. 14..
 */

public class CommonResult<T> {
    private int code;
    private T result;


    public int getCode() {
        return code;
    }
    public T getResult() {
        return result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
