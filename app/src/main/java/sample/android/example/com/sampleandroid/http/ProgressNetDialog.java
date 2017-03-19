package sample.android.example.com.sampleandroid.http;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import sample.android.example.com.sampleandroid.R;

/**
 * Created by sanghwan on 2017. 3. 17..
 */

public class ProgressNetDialog extends Dialog {
    public ProgressNetDialog(Context context) {
        // Dialog 배경을 투명 처리 해준다.
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(android.view.WindowManager.LayoutParams.MATCH_PARENT, android.view.WindowManager.LayoutParams.MATCH_PARENT);
//        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
//        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
//        getWindow().setAttributes(lpWindow);
        //getWindow().setBackgroundDrawable(this.getContext().getResources().getDrawable(R.drawable.common_back_dialog));

        setContentView(R.layout.dialog_progress);
        //   ((AnimationDrawable) (findViewById(R.id.animationImage)).getBackground()).start();

    }

}