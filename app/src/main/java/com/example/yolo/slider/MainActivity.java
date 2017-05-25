package com.example.yolo.slider;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SlideUp.OnFragmentInteractionListener{

    private FrameLayout mFrameLayout;
    private TextView mTextView,lTextView;
    private SlideUp slideUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameLayout=(FrameLayout)findViewById(R.id.frameLayout);
        mTextView = (TextView) findViewById(R.id.textView);
        lTextView = (TextView) findViewById(R.id.textView2);
        slideUp = new SlideUp();
    }

    public void SlideUpText(View view){

        mTextView.setVisibility(view.GONE);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.slide_up_anim,0);
        transaction.add(R.id.frameLayout,slideUp);
        transaction.commit();
    }

    public void SlideDownText(View view){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.slide_down_anim,0);
        transaction.remove(slideUp);
        transaction.commit();
        mTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
