package com.dhammamobile.dictionary_of_pali_term;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

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

    private int flagSanghadisesa1;
    private int flagSanghadisesa2;
    private int flagSanghadisesa3;
    private int flagSanghadisesa4;
    private int flagSanghadisesa5;
    private int flagSanghadisesa6;
    private int flagSanghadisesa7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_sanghadisesa);

        setWindowFlagsFullscreenAndNoLimits();

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

    public void toBackButtonSanghadisesa(View view) {
        ScrollView scrollTextAboutSanghadisesa = findViewById(R.id.viewScrollSanghadisesaAbout);
        this.flagSanghadisesa1 = 0;
        this.flagSanghadisesa2 = 0;
        this.flagSanghadisesa3 = 0;
        this.flagSanghadisesa4 = 0;
        this.flagSanghadisesa5 = 0;
        this.flagSanghadisesa6 = 0;
        this.flagSanghadisesa7 = 0;

        this.scrollTextSanghadisesa1.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa2.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa3.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa4.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa5.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa6.setVisibility(View.INVISIBLE);
        this.scrollTextSanghadisesa7.setVisibility(View.INVISIBLE);
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
            result = MediaPlayer.create(this, R.raw.sanghadisesa_1);
        }
        else if (this.flagSanghadisesa6 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_2);
        }
        else if (this.flagSanghadisesa7 == 1) {
            result = MediaPlayer.create(this, R.raw.sanghadisesa_3);
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
}