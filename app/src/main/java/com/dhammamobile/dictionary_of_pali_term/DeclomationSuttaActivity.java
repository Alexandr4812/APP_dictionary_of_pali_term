package com.dhammamobile.dictionary_of_pali_term;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.os.Handler;
import android.widget.TextView;


import java.util.concurrent.TimeUnit;

public class DeclomationSuttaActivity extends BaseActivityClass {

    private TextView textMaxTime;
    private TextView textCurrentPosition;

    private Button buttonStart;
    private Button buttonStop;
    private Button buttonRewind;
    private Button buttonFastForward;
    private Button buttonHome;
    private Button buttonBack;
    private Button buttonPause;

    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    private final Handler threadHandler = new Handler();

    private ScrollView scrollText;
    private ScrollView scrollTextMangala;
    private ScrollView scrollTextRatana;
    private ScrollView scrollTextGirimananda;

    private int flagMettaSutta;
    private int flagMangalaSutta;
    private int flagRatanaSutta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_sutta);

       // setWindowFlagsFullscreenAndNoLimits();

        this.textMaxTime = findViewById(R.id.textMaxTime);
        this.textCurrentPosition = findViewById(R.id.textCurrentPosition);

        this.buttonStart = findViewById(R.id.buttonPlayMettaSutta);
        this.buttonStop = findViewById(R.id.buttonStopMettaSutta);
        this.buttonPause = findViewById(R.id.buttonPauseMettaSutta);
        this.buttonRewind = findViewById(R.id.buttonRewindMettaSutta);
        this.buttonFastForward = findViewById(R.id.buttonFastForward);

        this.scrollText = findViewById(R.id.suttaScrollTextMetta);
        this.scrollTextMangala = findViewById(R.id.suttaScrollTextSuttaMangala);
        this.scrollTextRatana = findViewById(R.id.suttaScrollTextRatana);
        this.scrollTextGirimananda = findViewById(R.id.suttaScrollTextGirimananda);

        this.seekBar = findViewById(R.id.seekBar);

        this.buttonStart.setOnClickListener(v -> {

            if(mediaPlayer.isPlaying()) {
                return;
            }

            int duration = mediaPlayer.getDuration();
            int currentPosition = mediaPlayer.getCurrentPosition();

            if(currentPosition== 0)  {
                seekBar.setMax(duration);
                String maxTimeString = millisecondsToString(duration);
                textMaxTime.setText(maxTimeString);
            } else if(currentPosition== duration)  {
                mediaPlayer.reset();
            }

            UpdateSeekBarThread updateSeekBarThread= new UpdateSeekBarThread();
            threadHandler.postDelayed(updateSeekBarThread,100);

            mediaPlayer.start();
            seekBar.setVisibility(View.VISIBLE);
            textMaxTime.setVisibility(View.VISIBLE);
            textCurrentPosition.setVisibility(View.VISIBLE);
            buttonStop.setVisibility(View.VISIBLE);
            buttonRewind.setVisibility(View.VISIBLE);
            buttonFastForward.setVisibility(View.VISIBLE);
            buttonPause.setVisibility(View.VISIBLE);
            buttonStart.setVisibility(View.INVISIBLE);
        });

        this.buttonStop.setOnClickListener(view -> {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
            seekBar.setVisibility(View.INVISIBLE);
            textMaxTime.setVisibility(View.INVISIBLE);
            textCurrentPosition.setVisibility(View.INVISIBLE);
            buttonStop.setVisibility(View.INVISIBLE);
            buttonRewind.setVisibility(View.INVISIBLE);
            buttonFastForward.setVisibility(View.INVISIBLE);
            buttonPause.setVisibility(View.INVISIBLE);
            buttonStart.setVisibility(View.VISIBLE);
        });

        this.buttonPause.setOnClickListener(view -> {
            mediaPlayer.pause();
            buttonStop.setVisibility(View.INVISIBLE);
            buttonStart.setVisibility(View.VISIBLE);
        });

        this.buttonRewind.setOnClickListener(v -> doRewind( ));
        this.buttonFastForward .setOnClickListener(v -> doFastForward( ));
    }


    public void toMainAct(View view){
        this.mediaPlayer.pause();
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toMainActextra(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toDeclomation(View view){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

    public void toDeclomaciyaSuttaMetta(View view) {
        this.flagMettaSutta = 1;
        mediaPlayer = changeSong();

        this.scrollText.setVisibility(View.VISIBLE);

        this.buttonBack = findViewById(R.id.buttonliveToDeclomationSutta);
        this.buttonHome = findViewById(R.id.buttonliveHomeFromMettaSutta);
        this.buttonStart = findViewById(R.id.buttonPlayMettaSutta);

        this.buttonBack.setVisibility(View.VISIBLE);
        this.buttonHome.setVisibility(View.VISIBLE);
        this.buttonStart.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaSuttaMangala(View view) {
        this.flagMangalaSutta = 1;
        mediaPlayer = changeSong();

        this.scrollTextMangala.setVisibility(View.VISIBLE);

        this.buttonBack = findViewById(R.id.buttonliveToDeclomationSutta);
        this.buttonHome = findViewById(R.id.buttonliveHomeFromMettaSutta);
        this.buttonStart = findViewById(R.id.buttonPlayMettaSutta);

        this.buttonBack.setVisibility(View.VISIBLE);
        this.buttonHome.setVisibility(View.VISIBLE);
        this.buttonStart.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaSuttaRatana(View view) {
        this.flagRatanaSutta = 1;
        mediaPlayer = changeSong();

        this.scrollTextRatana.setVisibility(View.VISIBLE);

        this.buttonBack = findViewById(R.id.buttonliveToDeclomationSutta);
        this.buttonHome = findViewById(R.id.buttonliveHomeFromMettaSutta);
        this.buttonStart = findViewById(R.id.buttonPlayMettaSutta);

        this.buttonBack.setVisibility(View.VISIBLE);
        this.buttonHome.setVisibility(View.VISIBLE);
        this.buttonStart.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaSuttaGirimananda(View view) {
        //this.flagGirimanandaSutta = 1;
        //mediaPlayer = changeSong();

        this.scrollTextGirimananda.setVisibility(View.VISIBLE);

        this.buttonBack = findViewById(R.id.buttonliveToDeclomationSutta);
        this.buttonHome = findViewById(R.id.buttonliveHomeFromMettaSutta);
        this.buttonStart = findViewById(R.id.buttonPlayMettaSutta);

        this.buttonBack.setVisibility(View.VISIBLE);
        this.buttonHome.setVisibility(View.VISIBLE);
        //this.buttonStart.setVisibility(View.VISIBLE);
    }

    public void tobackDeclomationSutta(View view) {
        this.flagMettaSutta = 0;
        this.flagMangalaSutta = 0;
        this.flagRatanaSutta = 0;
        //this.flagGirimanandaSutta = 0;


        this.scrollText.setVisibility(View.INVISIBLE);
        this.scrollTextMangala.setVisibility(View.INVISIBLE);
        this.scrollTextRatana.setVisibility(View.INVISIBLE);
        this.scrollTextGirimananda.setVisibility(View.INVISIBLE);

        this.buttonBack.setVisibility(View.INVISIBLE);
        this.buttonHome.setVisibility(View.INVISIBLE);
        this.buttonStart.setVisibility(View.INVISIBLE);
        this.buttonStop.setVisibility(View.INVISIBLE);
        this.buttonPause.setVisibility(View.INVISIBLE);
        this.buttonRewind.setVisibility(View.INVISIBLE);
        this.buttonFastForward.setVisibility(View.INVISIBLE);
        this.seekBar.setVisibility(View.INVISIBLE);
        this.textMaxTime.setVisibility(View.INVISIBLE);
        this.textCurrentPosition.setVisibility(View.INVISIBLE);

        this.mediaPlayer.pause();
    }

    private MediaPlayer changeSong () {
        MediaPlayer result = new MediaPlayer();
        if (this.flagMettaSutta == 1) {
            result = MediaPlayer.create(this, R.raw.karaniyamettasutta);
        }
        else if (this.flagMangalaSutta == 1) {
            result = MediaPlayer.create(this, R.raw.mangala);
        }
        else if (this.flagRatanaSutta == 1) {
            result = MediaPlayer.create(this, R.raw.ratana);
        }
//        else if (this.flagGirimanandaSutta == 1) {
//            result = MediaPlayer.create(this, R.raw.girimanandasutta);
//        }
        return result;
    }

    private String millisecondsToString(int milliseconds)  {
        long seconds =  TimeUnit.MILLISECONDS.toSeconds(milliseconds);
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
            textCurrentPosition.setText(currentPositionStr);

            seekBar.setProgress(currentPosition);

            threadHandler.postDelayed(this, 50);
        }
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
        this.mediaPlayer.pause();
    }

}