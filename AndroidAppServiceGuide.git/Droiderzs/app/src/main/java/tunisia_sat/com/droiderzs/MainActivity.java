package tunisia_sat.com.droiderzs;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Guesmi on 25/11/2015.
 */
public class MainActivity extends android.support.v7.app.AppCompatActivity {

    private Toolbar toolbar;
    public static TabLayout tabLayout;
    private ViewPager viewPager;
    public static FragmentManager fragmentManager;
    boolean a_jour=false;
    private static final String url = "http://192.168.23.1:8081/GuideMe/api";// kol wa7ed wel ip mte3ou
    ArrayList<Destination> listDest;
    int []tabIcons={R.drawable.rest,R.drawable.coffe,R.drawable.hotel,R.drawable.club} ;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vp_holder);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        fragmentManager = getSupportFragmentManager();

        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        new GetDestination(this,url).execute();

    }

    void setUpVp(ViewPager viewPager){
        ViewPagerAdapter adapter=new ViewPagerAdapter( getSupportFragmentManager());
        adapter.addFrag( new Frag1(),null);
        adapter.addFrag(new Frag1(),null);
        adapter.addFrag(new Frag1(), "cinemas");
        adapter.addFrag(new Frag1(), "hotels");
        viewPager.setAdapter(adapter);

    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<Fragment>();
        private final List<String> mFragmentTitleList = new ArrayList<String>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // return mFragmentTitleList.get(position);
            Drawable image = ContextCompat.getDrawable(MainActivity.this, tabIcons[position]);
            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
            SpannableString sb = new SpannableString(" ");
            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return sb;
        }
    }
    private class GetDestination extends AsyncTask<Void, Void, ArrayList<Destination>> {

        Context context;
        ProgressDialog pDialog;
        private  String url;
        final String tag_id="id";
        final String tag_lat="lat";
        final String tag_lng="lng";
        final String tag_nom="nom";
        final String tag_numT="numT";
        final String tag_img="img";
        final String tag_desc="desc";
        final String tag_adresse="adresse";
        final String tag_type="type";
        final String tag_tableau="destinations";


        JSONArray destinations = null;
        ArrayList<HashMap<String, String>> jsonList;

        public GetDestination(Context context,String url){this.context=context;this.url=url;}
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Please wait... :P");
            pDialog.setCancelable(false);
            pDialog.show();
            jsonList = new ArrayList<HashMap<String, String>>();
        }

        @Override
        protected ArrayList<Destination> doInBackground(Void... arg0) {
            ServiceHandler sh = new ServiceHandler();

            final String jsonStr = sh.makeCall(url, 4*1000);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    destinations = new JSONArray(jsonStr);

                    listDest = new ArrayList<Destination>();

                    for (int i = 0; i < destinations.length(); i++) {
                        JSONObject c = destinations.getJSONObject(i);
                        Log.d("aaaa", c.toString());
                        int id = c.getInt(tag_id);
                        double lat=c.getDouble(tag_lat);
                        double lng=c.getDouble(tag_lng);
                        String nom=c.getString(tag_nom);
                        String numT=c.getString(tag_numT);
                        String img=c.getString(tag_img);
                        String desc=c.getString(tag_desc);
                        String adresse=c.getString(tag_adresse);
                        String type=c.getString(tag_type);
                        Destination d=new Destination(id,lat,lng,nom,numT,img,desc,adresse,type);
                        listDest.add(d);

                    }
                    return listDest;
                } catch (JSONException e) { e.printStackTrace();  return null;}
                catch (NumberFormatException e){e.printStackTrace();return  null;}
            } else {
                Log.e("ServiceHandler", "erreur lors de la réception de données");

            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Destination> result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            setUpVp(viewPager);
            tabLayout.setupWithViewPager(viewPager);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                tabLayout.getTabAt(i).setIcon(tabIcons[i]);
            }

            if(result!=null){
                Toast.makeText(context, "données recus !!", Toast.LENGTH_SHORT).show();
                a_jour=true;
            }
            else
                Toast.makeText(context,"impossible de se connecter au serveur",Toast.LENGTH_SHORT).show();
        }

    }
    public ArrayList<Destination> getListDest(){
        return listDest;
    }

}


