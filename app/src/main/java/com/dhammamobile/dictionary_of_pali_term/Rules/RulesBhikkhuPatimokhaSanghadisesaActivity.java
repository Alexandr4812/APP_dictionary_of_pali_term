package com.dhammamobile.dictionary_of_pali_term.Rules;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.concurrent.TimeUnit;


public class RulesBhikkhuPatimokhaSanghadisesaActivity extends BaseActivityClass {

    private TextView textView;
    private String textToAnimate;

    private TextView textMaxTimeSanghadisesa;
    private TextView textCurrentPositionSanghadisesa;

    private Button buttonStartSanghadisesa;
    private Button buttonStopSanghadisesa;
    private Button buttonRewindSanghadisesa;
    private Button buttonFastForwardSanghadisesa;
    private Button buttonHomeSanghadisesa;
    private Button buttonBackSanghadisesa;
    private Button buttonPauseSanghadisesa;

    private SeekBar seekBarSanghadisesa;
    private MediaPlayer mediaPlayer;
    private final Handler threadHandler = new Handler();

    private ScrollView scrollTextSanghadisesa1;
    private ScrollView scrollTextSanghadisesa2;
    private ScrollView scrollTextSanghadisesa3;
    private ScrollView scrollTextSanghadisesa4;
    private ScrollView scrollTextSanghadisesa5;
    private ScrollView scrollTextSanghadisesa6;
    private ScrollView scrollTextSanghadisesa7;
    private ScrollView scrollTextSanghadisesa8;
    private ScrollView scrollTextSanghadisesa9;
    private ScrollView scrollTextSanghadisesa10;
    private ScrollView scrollTextSanghadisesa11;
    private ScrollView scrollTextSanghadisesa12;
    private ScrollView scrollTextSanghadisesa13;

    private int flagSanghadisesa1;
    private int flagSanghadisesa2;
    private int flagSanghadisesa3;
    private int flagSanghadisesa4;
    private int flagSanghadisesa5;
    private int flagSanghadisesa6;
    private int flagSanghadisesa7;
    private int flagSanghadisesa8;
    private int flagSanghadisesa9;
    private int flagSanghadisesa10;
    private int flagSanghadisesa11;
    private int flagSanghadisesa12;
    private int flagSanghadisesa13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_sanghadisesa);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView = findViewById(R.id.textViewHintSangkhadisesa);
        textToAnimate = getString(R.string.textViewHintParajika);

        animateText();

        this.textMaxTimeSanghadisesa = findViewById(R.id.textMaxTimeSanghadisesa);
        this.textCurrentPositionSanghadisesa = findViewById(R.id.textCurrentPositionSanghadisesa);

        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);
        this.buttonStopSanghadisesa = findViewById(R.id.buttonStopSanghadisesa);
        this.buttonPauseSanghadisesa = findViewById(R.id.buttonPauseSanghadisesa);
        this.buttonRewindSanghadisesa = findViewById(R.id.buttonRewindSanghadisesa);
        this.buttonFastForwardSanghadisesa = findViewById(R.id.buttonFastForwardSanghadisesa);

        this.scrollTextSanghadisesa1 = findViewById(R.id.viewScrollSanghadisesaText1);
        this.scrollTextSanghadisesa2 = findViewById(R.id.viewScrollSanghadisesaText2);
        this.scrollTextSanghadisesa3 = findViewById(R.id.viewScrollSanghadisesaText3);
        this.scrollTextSanghadisesa4 = findViewById(R.id.viewScrollSanghadisesaText4);
        this.scrollTextSanghadisesa5 = findViewById(R.id.viewScrollSanghadisesaText5);
        this.scrollTextSanghadisesa6 = findViewById(R.id.viewScrollSanghadisesaText6);
        this.scrollTextSanghadisesa7 = findViewById(R.id.viewScrollSanghadisesaText7);
        this.scrollTextSanghadisesa8 = findViewById(R.id.viewScrollSanghadisesaText8);
        this.scrollTextSanghadisesa9 = findViewById(R.id.viewScrollSanghadisesaText9);
        this.scrollTextSanghadisesa10 = findViewById(R.id.viewScrollSanghadisesaText10);
        this.scrollTextSanghadisesa11 = findViewById(R.id.viewScrollSanghadisesaText11);
        this.scrollTextSanghadisesa12 = findViewById(R.id.viewScrollSanghadisesaText12);
        this.scrollTextSanghadisesa13 = findViewById(R.id.viewScrollSanghadisesaText13);

        this.seekBarSanghadisesa = findViewById(R.id.seekBarSanghadisesa);

        this.buttonStartSanghadisesa.setOnClickListener(v -> {

            if(mediaPlayer.isPlaying()) {
                return;
            }

            int duration = mediaPlayer.getDuration();
            int currentPosition = mediaPlayer.getCurrentPosition();

            if(currentPosition== 0)  {
                seekBarSanghadisesa.setMax(duration);
                String maxTimeString = millisecondsToString(duration);
                textMaxTimeSanghadisesa.setText(maxTimeString);
            } else if(currentPosition== duration)  {
                mediaPlayer.reset();
            }

            RulesBhikkhuPatimokhaSanghadisesaActivity.UpdateSeekBarThread updateSeekBarThread= new RulesBhikkhuPatimokhaSanghadisesaActivity.UpdateSeekBarThread();
            threadHandler.postDelayed(updateSeekBarThread,100);

            mediaPlayer.start();
            seekBarSanghadisesa.setVisibility(View.VISIBLE);
            textMaxTimeSanghadisesa.setVisibility(View.VISIBLE);
            textCurrentPositionSanghadisesa.setVisibility(View.VISIBLE);
            buttonStopSanghadisesa.setVisibility(View.VISIBLE);
            buttonRewindSanghadisesa.setVisibility(View.VISIBLE);
            buttonFastForwardSanghadisesa.setVisibility(View.VISIBLE);
            buttonPauseSanghadisesa.setVisibility(View.VISIBLE);
            buttonStartSanghadisesa.setVisibility(View.INVISIBLE);
        });

        this.buttonStopSanghadisesa.setOnClickListener(view -> {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
            seekBarSanghadisesa.setVisibility(View.INVISIBLE);
            textMaxTimeSanghadisesa.setVisibility(View.INVISIBLE);
            textCurrentPositionSanghadisesa.setVisibility(View.INVISIBLE);
            buttonStopSanghadisesa.setVisibility(View.INVISIBLE);
            buttonRewindSanghadisesa.setVisibility(View.INVISIBLE);
            buttonFastForwardSanghadisesa.setVisibility(View.INVISIBLE);
            buttonPauseSanghadisesa.setVisibility(View.INVISIBLE);
            buttonStartSanghadisesa.setVisibility(View.VISIBLE);
        });

        this.buttonPauseSanghadisesa.setOnClickListener(view -> {
            mediaPlayer.pause();
            buttonStopSanghadisesa.setVisibility(View.INVISIBLE);
            buttonStartSanghadisesa.setVisibility(View.VISIBLE);
        });

        this.buttonRewindSanghadisesa.setOnClickListener(v -> doRewind( ));
        this.buttonFastForwardSanghadisesa.setOnClickListener(v -> doFastForward( ));
    }

    protected void onResume() {
        super.onResume();
    }

    private void animateText() {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(2000); // Продолжительность анимации в миллисекундах
        animator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            String partialText = textToAnimate.substring(0, animatedValue);
            textView.setText(partialText);
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // Анимация завершена
            }
        });
        animator.start();
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
        this.mediaPlayer.pause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
        this.mediaPlayer.pause();
    }

    public void toRulesPatimokhaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaActivity.class);
    }

    public void toSanghadisesaAbout(View view) {
        mediaPlayer = changeSong();
        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaAbout);
        scrollText.setVisibility(View.VISIBLE);
        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText1(View view) {
        this.flagSanghadisesa1 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa1.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText2(View view) {
        this.flagSanghadisesa2 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa2.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText3(View view) {
        this.flagSanghadisesa3 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa3.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText4(View view) {
        this.flagSanghadisesa4 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa4.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText5(View view) {
        this.flagSanghadisesa5 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa5.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText6(View view) {
        this.flagSanghadisesa6 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa6.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText7(View view) {
        this.flagSanghadisesa7 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa7.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText8(View view) {
        this.flagSanghadisesa8 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa8.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText9(View view) {
        this.flagSanghadisesa9 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa9.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText10(View view) {
        this.flagSanghadisesa10 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa10.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText11(View view) {
        this.flagSanghadisesa11 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa11.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText12(View view) {
        this.flagSanghadisesa12 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa12.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText13(View view) {
        this.flagSanghadisesa13 = 1;
        mediaPlayer = changeSong();

        this.scrollTextSanghadisesa13.setVisibility(View.VISIBLE);

        this.buttonBackSanghadisesa = findViewById(R.id.buttonliveToPatimokhaSanghadisesa);
        this.buttonHomeSanghadisesa = findViewById(R.id.buttonliveHomeFromSanghadisesa);
        this.buttonStartSanghadisesa = findViewById(R.id.buttonPlaySanghadisesa);

        this.buttonBackSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.VISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.VISIBLE);
    }

    public void toBackButtonSanghadisesa(View view) {
        ScrollView scrollTextAboutSanghadisesa = findViewById(R.id.viewScrollSanghadisesaAbout);
        this.flagSanghadisesa1 = 0;
        this.flagSanghadisesa2 = 0;
        this.flagSanghadisesa3 = 0;
        this.flagSanghadisesa4 = 0;
        this.flagSanghadisesa5 = 0;
        this.flagSanghadisesa6 = 0;
        this.flagSanghadisesa7 = 0;
        this.flagSanghadisesa8 = 0;
        this.flagSanghadisesa9 = 0;
        this.flagSanghadisesa10 = 0;
        this.flagSanghadisesa11 = 0;
        this.flagSanghadisesa12 = 0;
        this.flagSanghadisesa13 = 0;

        this.scrollTextSanghadisesa1.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa2.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa3.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa4.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa5.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa6.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa7.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa8.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa9.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa10.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa11.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa12.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa13.setVisibility(View.INVISIBLE);
        scrollTextAboutSanghadisesa.setVisibility(View.INVISIBLE);

        this.buttonBackSanghadisesa.setVisibility(View.INVISIBLE);
        this.buttonHomeSanghadisesa.setVisibility(View.INVISIBLE);
        this.buttonStartSanghadisesa.setVisibility(View.INVISIBLE);
        this.buttonStopSanghadisesa.setVisibility(View.INVISIBLE);
        this.buttonPauseSanghadisesa.setVisibility(View.INVISIBLE);
        this.buttonRewindSanghadisesa.setVisibility(View.INVISIBLE);
        this.buttonFastForwardSanghadisesa.setVisibility(View.INVISIBLE);
        this.seekBarSanghadisesa.setVisibility(View.INVISIBLE);
        this.textMaxTimeSanghadisesa.setVisibility(View.INVISIBLE);
        this.textCurrentPositionSanghadisesa.setVisibility(View.INVISIBLE);

        this.mediaPlayer.pause();
    }

    private MediaPlayer changeSong () {
        MediaPlayer result = new MediaPlayer();
        if (this.flagSanghadisesa1 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_1);
        }
        else if (this.flagSanghadisesa2 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_2);
        }
        else if (this.flagSanghadisesa3 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_3);
        }
        else if (this.flagSanghadisesa4 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_4);
        }
        else if (this.flagSanghadisesa5 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_5);
        }
        else if (this.flagSanghadisesa6 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_6);
        }
        else if (this.flagSanghadisesa7 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_7);
        }
        else if (this.flagSanghadisesa8 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_8);
        }
        else if (this.flagSanghadisesa9 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_9);
        }
        else if (this.flagSanghadisesa10 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_10);
        }
        else if (this.flagSanghadisesa11 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_11);
        }
        else if (this.flagSanghadisesa12 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_12);
        }
        else if (this.flagSanghadisesa13 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_13);
        }
        return result;
    }

    private String millisecondsToString(int milliseconds)  {
        long seconds =  TimeUnit.MILLISECONDS.toSeconds((long) milliseconds) ;
        return seconds + " sec";
    }

    private void doRewind( )  {
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        int SUBTRACT_TIME = 5000;

        if(currentPosition - SUBTRACT_TIME > 0 )  {
            this.mediaPlayer.seekTo(currentPosition - SUBTRACT_TIME);
        }
    }

    private void doFastForward( )  {
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        int duration = this.mediaPlayer.getDuration();
        int ADD_TIME = 5000;

        if(currentPosition + ADD_TIME < duration)  {
            this.mediaPlayer.seekTo(currentPosition + ADD_TIME);
        }
    }

    class UpdateSeekBarThread implements Runnable {

        public void run()  {
            int currentPosition = mediaPlayer.getCurrentPosition();
            String currentPositionStr = millisecondsToString(currentPosition);
            textCurrentPositionSanghadisesa.setText(currentPositionStr);

            seekBarSanghadisesa.setProgress(currentPosition);

            threadHandler.postDelayed(this, 50);
        }
    }
    public void toSanghadisesaDetail1(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaDetail1Activity.class);
        this.mediaPlayer.pause();
    }

    public void toSanghadisesaDetail2(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaDetail2Activity.class);
        this.mediaPlayer.pause();
    }

    public void toSanghadisesaDetail3(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaDetail3Activity.class);
        this.mediaPlayer.pause();
    }

    public void toSanghadisesaDetail4(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaDetail4Activity.class);
        this.mediaPlayer.pause();
    }

    public void toSanghadisesaDetail8(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaDetail8Activity.class);
        this.mediaPlayer.pause();
    }

    public void toSanghadisesaDetail10(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaDetail10Activity.class);
        this.mediaPlayer.pause();
    }
}