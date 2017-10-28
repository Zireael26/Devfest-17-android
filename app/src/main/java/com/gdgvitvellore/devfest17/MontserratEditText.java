package com.gdgvitvellore.devfest17;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by tanmay on 20/1/17.
 */

public class MontserratEditText extends android.support.v7.widget.AppCompatEditText {
    public MontserratEditText(Context context) {
        super(context);
        init();
    }

    public MontserratEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MontserratEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Regular.ttf");
            setTypeface(tf);
        }
    }

}
