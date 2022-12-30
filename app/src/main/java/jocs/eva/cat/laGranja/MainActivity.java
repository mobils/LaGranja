package jocs.eva.cat.laGranja;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


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

        VideoView mVideoView = findViewById(R.id.video);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.findtheball);
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();


        //TODO: Exercici 1: Afegeix 3 imatges més amb 3 sons i diferents animacions
        // per ampliar l'exercici.



    }
    @Override
    public void onClick(View view) {
        /*
        Relacionem l'animació amb la imatge clicada
         */
        Animation animacio = AnimationUtils.loadAnimation(this, R.anim.mover);
        view.startAnimation(animacio);

        //TODO: Exercici 2: Modifica les animacions, crea 2 o 3 fitxers d'animacions
        // i fes que apareguin de forma aleatòria cada cop que es clica un animal.

        /*Reproduim el so
         */
        /* Sons descarregats de:
        https://freesound.org/people/peawormsworth/sounds/174472/
        https://freesound.org/people/rafash1306/sounds/404238/
        https://freesound.org/people/InspectorJ/sounds/339326/
        https://freesound.org/people/Bidone/sounds/66762/
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

                mp.release();  //Important per alliberar recursos
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //TODO: Hauriem de parar la música i tornar a  inicialitzar-la al onStart
        //mp.stop();
    }

    //TODO: Faltaria implementar el mètode onResume i que la música s'aturi si s'obre una altra aplicació.

    //TODO: EXERCICI 3: Afegeix una nova activitat com haviem fet el About on s'expliqui una
    // frase sobre el joc, autors, etc. I que s'obre des d'un menu o amb un botó
    // Després faltaria implementar el mètode onResume i que la música s'aturi si s'obre
    // aquesta segona activitat.

}
