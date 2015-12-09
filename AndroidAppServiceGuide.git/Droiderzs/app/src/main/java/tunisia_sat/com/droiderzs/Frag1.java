package tunisia_sat.com.droiderzs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Guesmi on 25/11/2015.
 */
public class Frag1 extends Fragment {

    public Frag1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        LayoutInflater lf = getActivity().getLayoutInflater();
        View view=lf.inflate(R.layout.f1, container, false);
           return  view;
    }



}
