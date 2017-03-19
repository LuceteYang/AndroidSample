package sample.android.example.com.sampleandroid.db;

import io.realm.RealmObject;

/**
 * Created by sanghwan on 2017. 3. 19..
 */

public class Test extends RealmObject {
    String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}

