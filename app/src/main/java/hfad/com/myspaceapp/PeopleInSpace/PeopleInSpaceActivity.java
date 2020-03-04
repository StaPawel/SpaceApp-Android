package hfad.com.myspaceapp.PeopleInSpace;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import hfad.com.myspaceapp.R;
import hfad.com.myspaceapp.Retrofit.BuildRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PeopleInSpaceActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_in_space);

        textView = (TextView) findViewById(R.id.peopleInSpaceTextView);
        ListView peopleInSpaceListView;
        Retrofit retrofit = BuildRetrofit.getRetrofitClient();

        PeopleInSpaceApi peopleInSpaceApi = retrofit.create(PeopleInSpaceApi.class);

        Call call = peopleInSpaceApi.getPeopleInSpace();

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                PeopleInSpace peopleInSpace = (PeopleInSpace) response.body();
                textView.append("Number of people in Space: " + peopleInSpace.getNumberOfPeople());
                textView.append("\n" + "People in Space: ");

                List<PeopleList> peopleFromSpaceList = peopleInSpace.getPeopleList();

                String [] peopleString = new String[peopleFromSpaceList.size()];

                for(int i = 0; i < peopleString.length; i++){
                    peopleString[i] = peopleFromSpaceList.get(i).getName();
                }

                ArrayAdapter<String> itemsAdapter =
                        new ArrayAdapter<String>(PeopleInSpaceActivity.this, android.R.layout.simple_list_item_1, peopleString);
                ListView peopleInSpaceListView = (ListView) findViewById(R.id.listPeople);
                peopleInSpaceListView.setAdapter(itemsAdapter);

                AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = (String) parent.getItemAtPosition(position);

                        Toast.makeText(getApplicationContext(),
                                "Position: " + item,
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                };
                peopleInSpaceListView.setOnItemClickListener(itemClickListener);



                //Below ArrayAdapter get all object (name and craft in the same time)
                /*ArrayAdapter<PeopleList> itemsAdapter =
                        new ArrayAdapter<PeopleList>(PeopleInSpaceActivity.this, android.R.layout.simple_list_item_1, peopleFromSpaceList);
                ListView peopleInSpaceListView = (ListView) findViewById(R.id.listPeople);
                peopleInSpaceListView.setAdapter(itemsAdapter);*/


            }
            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });



    }
}
