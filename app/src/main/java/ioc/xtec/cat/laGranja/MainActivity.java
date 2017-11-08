package ioc.xtec.cat.laGranja;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//mètode onClick
    public void onClickImatgeAnimal(View v) {
        /*
        Relacionem l'animació amb la imatge clicada
         */
        Animation animacio = AnimationUtils.loadAnimation(this, R.anim.girarescalar);
        v.startAnimation(animacio);




        /*Reproduim el so
         */
        MediaPlayer so = null;
        switch (v.getId()) {
            case R.id.imageView1:
                so = MediaPlayer.create(this, R.raw.anec);
                break;
            case R.id.imageView2:
                so = MediaPlayer.create(this, R.raw.gat);
                break;
            case R.id.imageView3:
                so = MediaPlayer.create(this, R.raw.cavall);
                break;
            case R.id.imageView4:
                so = MediaPlayer.create(this, R.raw.gos);
                break;
            case R.id.imageView5:
                so = MediaPlayer.create(this, R.raw.porc);
                break;
            case R.id.imageView6:
                so = MediaPlayer.create(this, R.raw.vaca);
                break;
        }

        so.start();

        // Alliberar el MediaPlayer quan acabi de reproduir la pista d'àudio
        so.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                //.stop();
                mp.release();
                //mp = null;
            }
        });
    }
}
