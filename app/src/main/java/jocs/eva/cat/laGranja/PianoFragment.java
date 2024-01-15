package jocs.eva.cat.laGranja;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PianoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PianoFragment extends Fragment implements  View.OnTouchListener, View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button bt_do, bt_re;


    public PianoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PianoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PianoFragment newInstance(String param1, String param2) {
        PianoFragment fragment = new PianoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_piano, container, false);
        bt_do =v.findViewById(R.id.vw_bt_do);
        bt_re =v.findViewById(R.id.vw_bt_re);

        //bt_do.setOnHoverListener(this); //No funciona en pantalles de mòbils.
        bt_do.setOnClickListener(this);
        bt_re.setOnClickListener(this);
        bt_re.setOnTouchListener(this);

        return v;
        //TODO: Exercici 4: Ja tens creat un disseny de piano, importa els fitxers dels sons i fes que soni
        // Has d'inflar el fragment on vulguis, o al MainActivity o en un altre.
        // Decideix si vols que les tecles del piano sonin quan cliques o quan passes per sobre (onHoverListener)

    }

    @Override
    public boolean onHover(View v, MotionEvent event) {
        /*Només un animation per view, si es volen fer més, afegirles al xml dins un <selector>*/

        Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rota);

        //v.startAnimation(animation);
        //bt_do.startAnimation(animation);
        return false;
    }

    @Override
    public void onClick(View view) {
        Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rota);
        MediaPlayer so = null;
        switch (view.getId()) {
            case R.id.vw_bt_do:
                so = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.notac); break;
            case R.id.vw_bt_re:
                so = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.notad); break;
                //view.startAnimation(animation);
            default:
                so = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.notad); break;
        }
        so.start();
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rota);

        view.startAnimation(animation);
        return false;
    }
}