package sg.edu.rp.c346.id20029699.l13_numberofgraduates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv =findViewById(R.id.ListView);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Graduates> alGrad = new ArrayList<Graduates>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=eb8b932c-503c-41e7-b513-114cffbe2338&limit=10", new JsonHttpResponseHandler() {

            String course;
            int year;
            String number;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {

                    JSONObject firstObj = response.getJSONObject("result");
                    JSONArray jsonArrRecords = firstObj.getJSONArray("records");
                    for(int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjRecord = jsonArrRecords.getJSONObject(i);
                        course = jsonObjRecord.getString("type_of_course");
                        year = jsonObjRecord.getInt("year");
                        number = jsonObjRecord.getString("no_of_graduates");
                        Graduates grad = new Graduates(number, course, year);
                        alGrad.add(grad);
                    }
                }
                catch(JSONException e){

                }
                //POINT X – Code to display List View
                CustomArrayAdapter adapter = new CustomArrayAdapter(MainActivity.this, R.layout.row,alGrad);
                lv.setAdapter(adapter);

            }//end onSuccess
        });
    }//end onResume

}