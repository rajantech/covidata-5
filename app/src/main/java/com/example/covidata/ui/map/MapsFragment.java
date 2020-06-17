package com.example.covidata.ui.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covidata.MainActivity;
import com.example.covidata.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MapsFragment extends Fragment {

    TextView countryName,totalConfirmedcases,todayCases,totalDeaths,todayDeaths,totalRecovered,totalActive,totalCritical,
            totalCasesPerOneMillion,totalDeathsPerOneMillion,totalTests,totaltestsPerMillion;
    private RequestQueue mQueue;
    private StringRequest request;
    String country;
    private GoogleMap mMap;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            final ArrayList<LatLng> a= new ArrayList<>();
            ArrayList<String> title = new ArrayList<>();

            a.add(new LatLng(33.93911,  67.709953));
            title.add("Afghanistan");

            a.add(new LatLng(41.153332 ,20.168331));
            title.add("Albania");

            a.add(new LatLng(28.033886,    1.659626   ));
            title.add("Algeria");

            a.add(new LatLng(42.546245 ,1.601554));
            title.add("Andorra");

            a.add(new LatLng(-11.202692,   17.873887));
            title.add("Angola");

            a.add(new LatLng(18.220554,    -63.068615));
            title.add("Anguilla");

            a.add(new LatLng(17.060816 ,-61.796428));
            title.add("Antigua and Barbuda");

            a.add(new LatLng(-38.416097,   -63.616672));
            title.add("Argentina");

            a.add(new LatLng(  40.069099, 45.038189));
            title.add("Armenia");

            a.add(new LatLng(12.52111, -69.968338));
            title.add("Aruba");

            a.add(new LatLng(-25.84    ,131.42));
            title.add("Australia");

            a.add(new LatLng(47.516231 ,14.550072));
            title.add("Austria");

            a.add(new LatLng(40.143105,    47.576927));
            title.add("Azebaijan");

            a.add(new LatLng(25.03428  ,-77.39628));
            title.add("Bahamas");

            a.add(new LatLng(25.930414 ,50.637772));
            title.add("Bahrain");

            a.add(new LatLng(23.684994 ,90.356331));
            title.add("Bangladesh");

            a.add(new LatLng(13.193887 ,-59.543198));
            title.add("Barbados");

            a.add(new LatLng(53.709807 ,27.953389));
            title.add("Belarus");

            a.add(new LatLng(50.503887 ,4.469936));
            title.add("Belgium");

            a.add(new LatLng(17.189877 ,-88.49765));
            title.add("Belize");

            a.add(new LatLng(  9.3076897,2.315834));
            title.add("Benin");

            a.add(new LatLng(32.366859,    - 64.683647));
            title.add("Bermuda");

            a.add(new LatLng(27.514162 ,90.433601));
            title.add("Bhutan");

            a.add(new LatLng(-16.290154,   -63.588653));
            title.add("Bolvia");

            a.add(new LatLng(43.915886,    17.679076));
            title.add("Bosnia");

            a.add(new LatLng(  -22.328474 ,24.684866));
            title.add("Botswana");

            a.add(new LatLng(-14.235004,   -51.92528));
            title.add("Brazil");

            a.add(new LatLng(18.420695,    -64.639968));
            title.add("British Virgin Islands");

            a.add(new LatLng(4.535277  ,114.727669));
            title.add("Brunei");

            a.add(new LatLng(42.733883 ,25.48583));
            title.add("Bulgaria");

            a.add(new LatLng(12.238333 ,-1.561593));
            title.add("Burkina Faso");

            a.add(new LatLng(-3.373056 ,29.918886));
            title.add("Burundi");

            a.add(new LatLng(16.002082,    -24.013197));
            title.add("Cabo Verde");

            a.add(new LatLng(12.5657, 104.9910));
            title.add("Cambodia");

            a.add(new LatLng(7.369722, 12.354722));
            title.add("Cameroon");

            a.add(new LatLng(56.130366 ,-106.346771));
            title.add("Canada");

            a.add(new LatLng(12.2,-68.26));
            title.add("Carribbean Netherlands");

            a.add(new LatLng(19.5,-80.5));
            title.add("Cayman Islands");

            a.add(new LatLng(6.611111  ,20.939444));
            title.add("Central African Republic");

            a.add(new LatLng(15.454166,    18.732207));
            title.add("Chad");

            a.add(new LatLng(49.21,-2.13));
            title.add("Channel Islands");

            a.add(new LatLng(  -35.675147 ,-71.542969));
            title.add("Chile");

            a.add(new LatLng(35.86166, 104.195397));
            title.add("China");

            a.add(new LatLng(41.902916 ,12.453389));
            title.add("Holy See(Vatican City State)");

            a.add(new LatLng(15.199999,    -86.241905));
            title.add("Honduras");

            a.add(new LatLng(22.396428,    114.109497));
            title.add("Hong Kong");

            a.add(new LatLng(47.162494 ,19.503304));
            title.add("Hungary");

            a.add(new LatLng(64.963051,    -19.020835));
            title.add("Iceland");

            a.add(new LatLng(20.593684 ,78.96288));
            title.add("India");

            a.add(new LatLng(-0.789275,    113.921327));
            title.add("Indonesia");

            a.add(new LatLng(  32.427908  ,53.688046));
            title.add("Iran");

            a.add(new LatLng(33.223191 ,43.679291));
            title.add("Iraq");

            a.add(new LatLng(53.41291, -8.24389));
            title.add("Ireland");

            a.add(new LatLng(  54.236107  ,-4.548056));
            title.add("Isle of Man");

            a.add(new LatLng(31.046051,    34.851612));
            title.add("Israel");

            a.add(new LatLng(41.87194, 12.56738));
            title.add("Italy");

            a.add(new LatLng(18.109581 ,-77.297508));
            title.add("Jamaica");

            a.add(new LatLng(36.204824,    138.252924));
            title.add("Japan");

            a.add(new LatLng(30.585164 ,36.238414));
            title.add("Jordan");

            a.add(new LatLng(48.019573 ,66.923684));
            title.add("Kazakhstan");

            a.add(new LatLng(-0.023559 ,37.906193));
            title.add("Kenya");

            a.add(new LatLng(29.31166, 47.481766));
            title.add("Kuwait");

            a.add(new LatLng(41.20438  ,74.766098));
            title.add("Kyrgyzstan");

            a.add(new LatLng(18,105));
            title.add("Lao People's Democratic Republic");

            a.add(new LatLng(56.879635,    24.603189));
            title.add("Latvia");

            a.add(new LatLng(33.854721,    35.862285));
            title.add("Lebanon");

            a.add(new LatLng(-29.609988,   28.233608));
            title.add("Lesotho");

            a.add(new LatLng(6.428055  ,-9.429499));
            title.add("Liberia");

            a.add(new LatLng(25,17));
            title.add("Libyan Arab Jamahririya");

            a.add(new LatLng(47.166,   9.555373));
            title.add("Liechtenstein");

            a.add(new LatLng(55.169438 ,23.881275));
            title.add("Lithuania");

            a.add(new LatLng(  49.815273, 6.129583));
            title.add("Luxembourg");

            a.add(new LatLng(0,0));
            title.add("MS Zaandam");

            a.add(new LatLng(22.198745,    113.543873));
            title.add("Macao");

            a.add(new LatLng(41.608635,    21.745275));
            title.add("Macedonia");

            a.add(new LatLng(-18.766947,   46.869107));
            title.add("Madagascar");

            a.add(new LatLng(-13.254308,   34.301525));
            title.add("Malawi");

            a.add(new LatLng(  4.210484,  101.975766 ));
            title.add("Malaysia");

            a.add(new LatLng(3.202778, 73.22068   ));
            title.add("Maldives");

            a.add(new LatLng(17.570692,    -3.996166  ));
            title.add("Mali");

            a.add(new LatLng(35.937496 ,14.375416 ));
            title.add("Malta");

            a.add(new LatLng(14.641528 ,-61.024174));
            title.add("Martinique");

            a.add(new LatLng(21.00789, -10.940835 ));
            title.add("Mauritania");

            a.add(new LatLng(-20.10389, 57.57028));
            title.add("Mauritius");

            a.add(new LatLng(-12.83333,45.1667));
            title.add("Mayotte");

            a.add(new LatLng(23.634501 ,-102.552784));
            title.add("Mexico");

            a.add(new LatLng(47.411631,    28.369885));
            title.add("Moldova");

            a.add(new LatLng(43.750298,    7.412841));
            title.add("Monaco");

            a.add(new LatLng(46.862496,    103.846656));
            title.add("Mongolia");

            a.add(new LatLng(42.708678,    19.37439   ));
            title.add("Montenegro");

            a.add(new LatLng(16.75,-62.2));
            title.add("Montaserrat");

            a.add(new LatLng(  31.791702, -7.09262));
            title.add("Morocco");

            a.add(new LatLng(-18.665695,   35.529562));
            title.add("Mozambique");

            a.add(new LatLng(21.913965,    95.956223));
            title.add("Myanmar");

            a.add(new LatLng(-22.95764 ,18.49041));
            title.add("Namibia");

            a.add(new LatLng(28.394857 ,84.124008));
            title.add("Nepal");

            a.add(new LatLng(52.132633 ,5.291266  ));
            title.add("Netherlands");

            a.add(new LatLng(  -20.904305 ,165.618042));
            title.add("New Caledonia");

            a.add(new LatLng(-40.900557    ,174.885971));
            title.add("New Zealand");

            a.add(new LatLng(  12.865416, -85.207229));
            title.add("Nicaragua");

            a.add(new LatLng(  17.607789  ,8.081666));
            title.add("Niger");

            a.add(new LatLng(9.081999, 8.675277));
            title.add("Nigeria");

            a.add(new LatLng(60.472024,    8.468946));
            title.add("Norway");

            a.add(new LatLng(21.512583 ,55.923255 ));
            title.add("Oman");

            a.add(new LatLng(30.375321 ,69.345116));
            title.add("Pakistan");

            a.add(new LatLng(31.952162,    35.233154));
            title.add("Palestine");

            a.add(new LatLng(8.537981, -80.782127));
            title.add("Panama");

            a.add(new LatLng(-6.314993 ,143.95555));
            title.add("Papua New Guinea");

            a.add(new LatLng(-23.442503    ,-58.443832));
            title.add("Paraguay");

            a.add(new LatLng(-9.189967,    -75.015152));
            title.add("Peru");

            a.add(new LatLng(12.879721,    121.774017));
            title.add("Phillippines");

            a.add(new LatLng(51.919438,    19.145136));
            title.add("Poland");

            a.add(new LatLng(39.399872 ,-8.224454));
            title.add("Portugal");

            a.add(new LatLng(25.354826,    51.183884));
            title.add("Qatar");

            a.add(new LatLng(45.943161 ,24.96676));
            title.add("Romania");

            a.add(new LatLng(61.52401, 105.318756 ));
            title.add("Russia");

            a.add(new LatLng(-1.940278,    29.873888));
            title.add("Rwanda");

            a.add(new LatLng(-21.115141,   55.536384));
            title.add("Reunion");

            a.add(new LatLng(37,127.5));
            title.add("S. Korea");

            a.add(new LatLng(17.3333,-62.75));
            title.add("Saint Kitts and Nevis");

            a.add(new LatLng(13.909444,    -60.978893));
            title.add("Saint Lucia");

            a.add(new LatLng(18.11,-63.03));
            title.add("Saint Martin");

            a.add(new LatLng(46.941936,    -56.27111));
            title.add("Saint Pierre Miquelon");

            a.add(new LatLng(12.984305,    -61.287228));
            title.add("Saint Vincent and the Grenadines");

            a.add(new LatLng(43.94236  ,12.457777 ));
            title.add("Saint Marino");

            a.add(new LatLng(0.18636   ,6.613081));
            title.add("Sao Tome and Principe");

            a.add(new LatLng(23.885942,    45.079162));
            title.add("Saudi Arabia");

            a.add(new LatLng(14.497401,    -14.452362 ));
            title.add("Senegal");

            a.add(new LatLng(44.016521,    21.005859));
            title.add("Serbia");

            a.add(new LatLng(-4.679574,    55.491977  ));
            title.add("Seychelles");

            a.add(new LatLng(8.460555, -11.779889));
            title.add("Sierra Leone");

            a.add(new LatLng(1.352083, 103.819836));
            title.add("Singapore");

            a.add(new LatLng(18.02,-63.06));
            title.add("Sint Maarten");

            a.add(new LatLng(48.669026 ,19.699024));
            title.add("Slovakia");

            a.add(new LatLng(46.151241,    14.995463  ));
            title.add("Slovenia");

            a.add(new LatLng(5.152149, 46.199616));
            title.add("Somalia");

            a.add(new LatLng(-30.559482    ,22.937506));
            title.add("South Africa");

            a.add(new LatLng(12.862807,    30.217636  ));
            title.add("South Sudan");

            a.add(new LatLng(40.463667,    -3.74922));
            title.add("Spain");

            a.add(new LatLng(7.873054, 80.771797));
            title.add("Sri Lanka");

            a.add(new LatLng(17.89,-62.82));
            title.add("St. Barth");

            a.add(new LatLng(15,30));
            title.add("Sudan");

            a.add(new LatLng(3.919305  ,-56.027783));
            title.add("Suriname");

            a.add(new LatLng(-26.522503,   31.465866));
            title.add("Swaziland");

            a.add(new LatLng(60.128161 ,18.643501));
            title.add("Sweden");

            a.add(new LatLng(47,8));
            title.add("Switzerland");

            a.add(new LatLng(34.802075,    38.996815));
            title.add("Syrian Arab Republic");

            a.add(new LatLng(23.69781, 120.960515));
            title.add("Taiwan");

            a.add(new LatLng(38.861034 ,71.276093));
            title.add("Tajikistan");

            a.add(new LatLng(  -6.369028  ,34.888822));
            title.add("Tanzania");

            a.add(new LatLng(15.870032 ,100.992541    ));
            title.add("Thailand");

            a.add(new LatLng(-8.874217,    125.727539 ));
            title.add("Timor-Leste");

            a.add(new LatLng(8.619543  ,0.824782));
            title.add("Togo");

            a.add(new LatLng(10.691803 ,-61.222503));
            title.add("Trinidad and Tobago");

            a.add(new LatLng(33.886917,    9.537499));
            title.add("Tunisia");

            a.add(new LatLng(38.963745,    35.243322));
            title.add("Turkey");

            a.add(new LatLng(21.694025,    -71.797928));
            title.add("Turuks and Caicos Islands");

            a.add(new LatLng(24,54));
            title.add("UAE");

            a.add(new LatLng(37.09024, -95.712891));
            title.add("USA");

            a.add(new LatLng(1.373333, 32.290275));
            title.add("Uganda");

            a.add(new LatLng(48.379433,    31.16558));
            title.add("Ukraine");

            a.add(new LatLng(-32.522779,   -55.765835));
            title.add("Uruguay");

            a.add(new LatLng(41.377491 ,64.585262));
            title.add("Uzebkistan");

            a.add(new LatLng(6.42375   ,-66.58973));
            title.add("Venezuela");

            a.add(new LatLng(14.058324,    108.277199 ));
            title.add("Vietnam");

            a.add(new LatLng(24.5,-13));
            title.add("Western Sahara");

            a.add(new LatLng(15.552727 ,48.516388));
            title.add("Yemen");

            a.add(new LatLng(-13.133897,   27.849332));
            title.add("Zambia");

            a.add(new LatLng(-19.015438,   29.154857));
            title.add("Zimbabwe");




            // LatLng NewCastle=new LatLng(-32.916668,151.750000);
            for(int i=0; i<a.size();i++) {
                mMap.addMarker(new MarkerOptions().position(a.get(i)).title(title.get(i)));
                // mMap.moveCamera(CameraUpdateFactory.newLatLng(a.get(i)));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

                    @Override
                    public boolean onMarkerClick(Marker marker) {
                       // Toast.makeText(getContext(), "place name is "+ marker.getTitle(), Toast.LENGTH_LONG).show();
                        loadCountryData(marker.getTitle());
                        return false;
                    }
                });
            }


        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         View v=  inflater.inflate(R.layout.fragment_maps, container, false);

        countryName=v.findViewById(R.id.countryname);
        totalConfirmedcases=v.findViewById(R.id.totalCases);
        todayCases=v.findViewById(R.id.newCases);
        totalDeaths=v.findViewById(R.id.totalDeaths);
        todayDeaths=v.findViewById(R.id.newdeaths);
        totalRecovered=v.findViewById(R.id.totalRecovered);
        totalActive=v.findViewById(R.id.activecases);
        totalCritical=v.findViewById(R.id.totalCritical);
        totalCasesPerOneMillion=v.findViewById(R.id.casesperonemillion);
        totalDeathsPerOneMillion=v.findViewById(R.id.deathsperonemillion);
        totalTests=v.findViewById(R.id.totaltests);
        totaltestsPerMillion=v.findViewById(R.id.totaltestsperonemillion);


        mQueue = Volley.newRequestQueue(getContext());

        loadCountryData("World");



        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }



    private void loadCountryData(final String title) {

        request = new StringRequest(Request.Method.GET, "https://coronavirus-19-api.herokuapp.com/countries/"+title, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject=new JSONObject(response);
                    countryName.setText(jsonObject.getString("country"));
                    totalConfirmedcases.setText(jsonObject.getString("cases"));
                    todayCases.setText(jsonObject.getString("todayCases"));
                    totalDeaths.setText(jsonObject.getString("deaths"));
                    todayDeaths.setText(jsonObject.getString("todayDeaths"));
                    totalRecovered.setText(jsonObject.getString("recovered"));
                    totalActive.setText(jsonObject.getString("active"));
                    totalCritical.setText(jsonObject.getString("critical"));
                    totalCasesPerOneMillion.setText(jsonObject.getString("casesPerOneMillion"));
                    totalDeathsPerOneMillion.setText(jsonObject.getString("deathsPerOneMillion"));
                    totalTests.setText(jsonObject.getString("totalTests"));
                    totaltestsPerMillion.setText(jsonObject.getString("testsPerOneMillion"));




                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(),"Unable to find the Country"+title,Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        }){

        };

        mQueue.add(request);


    }


}