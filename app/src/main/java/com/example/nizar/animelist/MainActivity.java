package com.example.nizar.animelist;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.textclassifier.TextLinks;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rvCatagory)
    RecyclerView rvCatagory;
    AnimeAdapter adapter;
    private ProgressDialog dialog;
    private static final String JSON_URL ="https://animeyou.net/api/home.php";

    final ArrayList<Anime> animex = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new AnimeAdapter(this);


        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.show();

        loadAnime();
    }

    private void loadAnime() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray animeArray = object.getJSONArray("data");

                    for (int i = 0; i < animeArray.length(); i++) {
                        JSONObject animeObject = animeArray.getJSONObject(i);

                        Anime animeItem = new Anime(
                                animeObject.getString("judul"),
                                animeObject.getString("gambar"),
                                animeObject.getString("tanggal"),
                                animeObject.getString("genre")
                        );
                        animex.add(animeItem);
                    }
                    dialog.dismiss();
                    rvCatagory.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapter.setListAnime(animex);
                    rvCatagory.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },



                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}



    /*private class DemoAsync extends AsyncTask<String, Void,ArrayList<Anime>> {
        private static final String TAG = "TAG";

        @Override
        protected ArrayList<Anime> doInBackground(String...strings) {

            final ArrayList<Anime> animes = new ArrayList<>();
            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    JSON_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {

                        JSONObject jsonData = new JSONObject(response);
                        JSONArray jsonArray = jsonData.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject animeObj = jsonArray.getJSONObject(i);
                            Anime anime = new Anime(animeObj);
                            animes.add(anime);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }
            });

            return  animes;
        }


        @Override
        protected void onPostExecute(ArrayList<Anime> anime) {
            for (int i = 0 ; i<anime.size();i++){
                Log.d(TAG, "onPostExecute: "+anime.get(i).getJudul());
            }
            super.onPostExecute(anime);
            rvCatagory.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            adapter.setListAnime(anime);
            rvCatagory.setAdapter(adapter);
        }
    }*/

