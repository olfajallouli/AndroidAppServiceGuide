package tunisia_sat.com.droiderzs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Guesmi on 25/11/2015.
 */
public class Frag1 extends Fragment {

    ListView listView;
    TextView textView;

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
        listView=(ListView) view.findViewById(R.id.lv);
        textView=(TextView)view.findViewById(R.id.text123);
        List<Destination> list=((MainActivity)getActivity()).getListDest();
        String ch="";
        for(int i=0;i<list.size();i++) ch+=list.get(i).toString();
        textView.setText(ch);
           return  view;
    }



}
