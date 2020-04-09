package com.example.covid_19;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;




@SuppressLint("AppCompatCustomView")
public class Typewriter extends TextView {
    private CharSequence mText;
    private int mIndex;
    private int arrIndex = 0;
    private long mDelay = 500; //Default 500ms delay




    public Typewriter(Context context) {
        super(context);
    }

    public Typewriter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if (mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            } else {
      /*          if(SEARCH_VENDOR_ARRAY==null || SEARCH_VENDOR_ARRAY.size()==0)return;
                if(arrIndex==(SEARCH_VENDOR_ARRAY.size()-1))animateText(0);
                else animateText(arrIndex+1);*/

            }
        }
    };

    public void animateText(int i) {
       /* if(SEARCH_VENDOR_ARRAY!=null && i<SEARCH_VENDOR_ARRAY.size()) {
            arrIndex = i;
            mText = SEARCH_VENDOR_ARRAY.get(i);
            mIndex = 0;
            setText("");
            mHandler.removeCallbacks(characterAdder);
            mHandler.postDelayed(characterAdder, mDelay);
        }*/
    }

    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }
}
