package hfad.com.myspaceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import hfad.com.myspaceapp.PeopleInSpace.PeopleInSpaceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void peopleOnSpaceButtonClick(View view){
        Intent intent = new Intent(MainActivity.this, PeopleInSpaceActivity.class);
        startActivity(intent);
    }
}
