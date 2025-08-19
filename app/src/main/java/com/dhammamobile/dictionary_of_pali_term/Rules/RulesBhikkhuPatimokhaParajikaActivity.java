package com.dhammamobile.dictionary_of_pali_term.Rules;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.os.Handler;
import android.widget.TextView;


import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.concurrent.TimeUnit;

public class RulesBhikkhuPatimokhaParajikaActivity extends BaseActivityClass {
    private TextView textView;
    private String textToAnimate;

    private TextView textMaxTimeParajika;
    private TextView textCurrentPositionParajika;

    private Button buttonStartParajika;
    private Button buttonStopParajika;
    private Button buttonRewindParajika;
    private Button buttonFastForwardParajika;
    private Button buttonHomeParajika;
    private Button buttonBackParajika;
    private Button buttonPauseParajika;

    private SeekBar seekBarParajika;
    private MediaPlayer mediaPlayer;
    private final Handler threadHandler = new Handler();

    private ScrollView scrollTextParajika1;
    private ScrollView scrollTextParajika2;
    private ScrollView scrollTextParajika3;
    private ScrollView scrollTextParajika4;

    private int flagParajika1;
    private int flagParajika2;
    private int flagParajika3;
    private int flagParajika4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_parajika);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textView = findViewById(R.id.textViewHintParajika);
        textToAnimate = getString(R.string.textViewHintParajika);

        animateText();

        this.textMaxTimeParajika = findViewById(R.id.textMaxTimeParajika);
        this.textCurrentPositionParajika = findViewById(R.id.textCurrentPositionParajika);

        this.buttonStartParajika = findViewById(R.id.buttonPlayParajika);
        this.buttonStopParajika = findViewById(R.id.buttonStopParajika);
        this.buttonPauseParajika = findViewById(R.id.buttonPauseParajika);
        this.buttonRewindParajika = findViewById(R.id.buttonRewindParajika);
        this.buttonFastForwardParajika = findViewById(R.id.buttonFastForwardParajika);

        this.scrollTextParajika1 = findViewById(R.id.viewScrollPatimokhaParajika1);
        this.scrollTextParajika2 = findViewById(R.id.viewScrollPatimokhaParajika2);
        this.scrollTextParajika3 = findViewById(R.id.viewScrollPatimokhaParajika3);
        this.scrollTextParajika4 = findViewById(R.id.viewScrollPatimokhaParajika4);

        this.seekBarParajika = findViewById(R.id.seekBarParajika);

        this.buttonStartParajika.setOnClickListener(v -> {

            if(mediaPlayer.isPlaying()) {
                return;
            }

            int duration = mediaPlayer.getDuration();
            int currentPosition = mediaPlayer.getCurrentPosition();

            if(currentPosition== 0)  {
                seekBarParajika.setMax(duration);
                String maxTimeString = millisecondsToString(duration);
                textMaxTimeParajika.setText(maxTimeString);
            } else if(currentPosition== duration)  {
                mediaPlayer.reset();
            }

            UpdateSeekBarThread updateSeekBarThread= new UpdateSeekBarThread();
            threadHandler.postDelayed(updateSeekBarThread,100);

            mediaPlayer.start();
            seekBarParajika.setVisibility(View.VISIBLE);
            textMaxTimeParajika.setVisibility(View.VISIBLE);
            textCurrentPositionParajika.setVisibility(View.VISIBLE);
            buttonStopParajika.setVisibility(View.VISIBLE);
            buttonRewindParajika.setVisibility(View.VISIBLE);
            buttonFastForwardParajika.setVisibility(View.VISIBLE);
            buttonPauseParajika.setVisibility(View.VISIBLE);
            buttonStartParajika.setVisibility(View.INVISIBLE);
        });

        this.buttonStopParajika.setOnClickListener(view -> {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
            seekBarParajika.setVisibility(View.INVISIBLE);
            textMaxTimeParajika.setVisibility(View.INVISIBLE);
            textCurrentPositionParajika.setVisibility(View.INVISIBLE);
            buttonStopParajika.setVisibility(View.INVISIBLE);
            buttonRewindParajika.setVisibility(View.INVISIBLE);
            buttonFastForwardParajika.setVisibility(View.INVISIBLE);
            buttonPauseParajika.setVisibility(View.INVISIBLE);
            buttonStartParajika.setVisibility(View.VISIBLE);
        });

        this.buttonPauseParajika.setOnClickListener(view -> {
            mediaPlayer.pause();
            buttonStopParajika.setVisibility(View.INVISIBLE);
            buttonStartParajika.setVisibility(View.VISIBLE);
        });

        this.buttonRewindParajika.setOnClickListener(v -> doRewind( ));
        this.buttonFastForwardParajika.setOnClickListener(v -> doFastForward( ));
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

    public void toParajikkaAbout(View view){
        mediaPlayer = changeSong();
        this.buttonBackParajika = findViewById(R.id.buttonliveToPatimokhaParajika);
        this.buttonHomeParajika = findViewById(R.id.buttonliveHomeFromParajika);
        ScrollView scrollTextAboutParajika = findViewById(R.id.viewScrollParajikaAbout);
        scrollTextAboutParajika.setVisibility(View.VISIBLE);
        this.buttonBackParajika.setVisibility(View.VISIBLE);
        this.buttonHomeParajika.setVisibility(View.VISIBLE);
    }

    public void toBhikhuPatimokhaParajika1(View view) {
        this.flagParajika1 = 1;
        mediaPlayer = changeSong();

        this.scrollTextParajika1.setVisibility(View.VISIBLE);

        this.buttonBackParajika = findViewById(R.id.buttonliveToPatimokhaParajika);
        this.buttonHomeParajika = findViewById(R.id.buttonliveHomeFromParajika);
        this.buttonStartParajika = findViewById(R.id.buttonPlayParajika);

        this.buttonBackParajika.setVisibility(View.VISIBLE);
        this.buttonHomeParajika.setVisibility(View.VISIBLE);
        this.buttonStartParajika.setVisibility(View.VISIBLE);
    }

    public void toBhikhuPatimokhaParajika2(View view) {
        this.flagParajika2 = 1;
        mediaPlayer = changeSong();

        this.scrollTextParajika2.setVisibility(View.VISIBLE);

        this.buttonBackParajika = findViewById(R.id.buttonliveToPatimokhaParajika);
        this.buttonHomeParajika = findViewById(R.id.buttonliveHomeFromParajika);
        this.buttonStartParajika = findViewById(R.id.buttonPlayParajika);

        this.buttonBackParajika.setVisibility(View.VISIBLE);
        this.buttonHomeParajika.setVisibility(View.VISIBLE);
        this.buttonStartParajika.setVisibility(View.VISIBLE);
    }

    public void toBhikhuPatimokhaParajika3(View view) {
        this.flagParajika3 = 1;
        mediaPlayer = changeSong();

        this.scrollTextParajika3.setVisibility(View.VISIBLE);

        this.buttonBackParajika = findViewById(R.id.buttonliveToPatimokhaParajika);
        this.buttonHomeParajika = findViewById(R.id.buttonliveHomeFromParajika);
        this.buttonStartParajika = findViewById(R.id.buttonPlayParajika);

        this.buttonBackParajika.setVisibility(View.VISIBLE);
        this.buttonHomeParajika.setVisibility(View.VISIBLE);
        this.buttonStartParajika.setVisibility(View.VISIBLE);
    }

    public void toBhikhuPatimokhaParajika4(View view) {
        this.flagParajika4 = 1;
        mediaPlayer = changeSong();

        this.scrollTextParajika4.setVisibility(View.VISIBLE);

        this.buttonBackParajika = findViewById(R.id.buttonliveToPatimokhaParajika);
        this.buttonHomeParajika = findViewById(R.id.buttonliveHomeFromParajika);
        this.buttonStartParajika = findViewById(R.id.buttonPlayParajika);

        this.buttonBackParajika.setVisibility(View.VISIBLE);
        this.buttonHomeParajika.setVisibility(View.VISIBLE);
        this.buttonStartParajika.setVisibility(View.VISIBLE);
    }

    public void tobackParajikaAct(View view) {
        ScrollView scrollTextAboutParajika = findViewById(R.id.viewScrollParajikaAbout);
        this.flagParajika1 = 0;
        this.flagParajika2 = 0;
        this.flagParajika3 = 0;
        this.flagParajika4 = 0;

        this.scrollTextParajika1.setVisibility(View.INVISIBLE);
        this.scrollTextParajika2.setVisibility(View.INVISIBLE);
        this.scrollTextParajika3.setVisibility(View.INVISIBLE);
        this.scrollTextParajika4.setVisibility(View.INVISIBLE);
        scrollTextAboutParajika.setVisibility(View.INVISIBLE);

        this.buttonBackParajika.setVisibility(View.INVISIBLE);
        this.buttonHomeParajika.setVisibility(View.INVISIBLE);
        this.buttonStartParajika.setVisibility(View.INVISIBLE);
        this.buttonStopParajika.setVisibility(View.INVISIBLE);
        this.buttonPauseParajika.setVisibility(View.INVISIBLE);
        this.buttonRewindParajika.setVisibility(View.INVISIBLE);
        this.buttonFastForwardParajika.setVisibility(View.INVISIBLE);
        this.seekBarParajika.setVisibility(View.INVISIBLE);
        this.textMaxTimeParajika.setVisibility(View.INVISIBLE);
        this.textCurrentPositionParajika.setVisibility(View.INVISIBLE);

        this.mediaPlayer.pause();
    }

    private MediaPlayer changeSong () {
        MediaPlayer result = new MediaPlayer();
        if (this.flagParajika1 == 1) {
            result = MediaPlayer.create(this, R.raw.parajika_1);
        }
        else if (this.flagParajika2 == 1) {
            result = MediaPlayer.create(this, R.raw.parajika_2);
        }
        else if (this.flagParajika3 == 1) {
            result = MediaPlayer.create(this, R.raw.parajika_3);
        }
        else if (this.flagParajika4 == 1) {
            result = MediaPlayer.create(this, R.raw.parajika_4);
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


    public void toParajikaDetail(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaParajikaDetailActivity.class);
        this.mediaPlayer.pause();
    }

    public void toParajika2Detail(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaParajikaDetail2Activity.class);
        this.mediaPlayer.pause();
    }

    public void toParajika3Detail(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaParajikaDetail3Activity.class);
        this.mediaPlayer.pause();
    }

    public void toParajika4Detail(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaParajikaDetail4Activity.class);
        this.mediaPlayer.pause();
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaActivity.class);
    }

    public void toRulesPatimokhaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaActivity.class);
    }

    class UpdateSeekBarThread implements Runnable {

        public void run()  {
            int currentPosition = mediaPlayer.getCurrentPosition();
            String currentPositionStr = millisecondsToString(currentPosition);
            textCurrentPositionParajika.setText(currentPositionStr);

            seekBarParajika.setProgress(currentPosition);

            threadHandler.postDelayed(this, 50);
        }
    }
}