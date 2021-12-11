package ioc.xtec.cat.laGranja;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageView1).setOnClickListener(this);
        findViewById(R.id.imageView2).setOnClickListener(this);
        findViewById(R.id.imageView3).setOnClickListener(this);
        findViewById(R.id.imageView4).setOnClickListener(this);
        findViewById(R.id.imageView5).setOnClickListener(this);
        findViewById(R.id.imageView6).setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        /*
        Relacionem l'animació amb la imatge clicada
         */
        Animation animacio = AnimationUtils.loadAnimation(this, R.anim.mover);
        view.startAnimation(animacio);




        /*Reproduim el so
         */
        /* Sons descarregats de:
        https://freesound.org/people/peawormsworth/sounds/174472/
        https://freesound.org/people/rafash1306/sounds/404238/

         */
        MediaPlayer so = null;
        switch (view.getId()) {
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



    //TODO: Faltaria implementar el mètode onResume i que la música s'aturi si s'obre
    // una altra aplicació.

}
