package sample.android.example.com.sampleandroid.http;

import sample.android.example.com.sampleandroid.http.vo.Obj;
import sample.android.example.com.sampleandroid.config.Config;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by sanghwan on 2017. 3. 14..
 */

public interface ApiService {
    public static final String API_URL = Config.SERVER_IP;

    /*    CookieManager cookieManager = new CookieManager();
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS) //set time out
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(logging) //set logging
            .build();*/
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .client(okHttpClient) // what your http environment is
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("get")
    Call<CommonResult<Obj>> getTest(@Query("postId") int postId);

    @FormUrlEncoded
    @POST("post")
    Call<ResponseBody> postTest(@Field("postId") int postId);

    @Headers("wenwo-token: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MjIsImlhdCI6MTQ4OTQwMjg5OSwiZXhwIjoxNDkxOTk0ODk5fQ.LSevQPAzjFlwCpr3aUCX72GeYsguWT2fiV9paZmctgA")
    @GET("header")
    Call<ResponseBody> headerTest(@Query("postId") int postId);

    @Multipart
    @POST("form")
    Call<ResponseBody> formTest(@Field("postId") int postId);




}



