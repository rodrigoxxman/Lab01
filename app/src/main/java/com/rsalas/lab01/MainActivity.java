package com.rsalas.lab01;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {

    Button b_prev, b_next;

    ImageSwitcher imageSwitcher;

    Integer[] images = {R.drawable.trhps1, R.drawable.clockworkorange2, R.drawable.freaks3, R.drawable.bladerunner4, R.drawable.tist5,
            R.drawable.fightclub6, R.drawable.clerks7, R.drawable.heavymetal8, R.drawable.haroldandmaude9, R.drawable.officespace10};
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView= new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(
                        new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.out);

        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        b_prev = (Button) findViewById(R.id.b_prev);
        b_next = (Button) findViewById(R.id.b_next);

        b_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i > 0){
                    i--;
                    imageSwitcher.setImageResource(images[i]);
                }
            }
        });

        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < images.length - 1){
                    i++;
                    imageSwitcher.setImageResource(images[i]);
                }
            }
        });
    }
}
