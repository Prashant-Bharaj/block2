package com.blogspot.psbapplications.block2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display GUI defined in activity_main.xml file
        setContentView(R.layout.activity_main);

        //retrieve the reference to listView
        ListView listView = findViewById(R.id.listView);

        // Make an adapter class object
        // build an adapter to feed the list with the content of an array of strings
        // (defined in the res/values/strings.xml file), and where each string will be
        // rendered as a TextView (as defined by the built-in simple_list_item_1 layout).
        final ArrayAdapter<CharSequence> adapterAnimal = ArrayAdapter.createFromResource(this,
                R.array.animalArray,android.R.layout.simple_list_item_1);

        // set an adapter to listView
        listView.setAdapter(adapterAnimal);

        // Attach a listener to the listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // retrieve the message to be  displayed in the appropriate language
                String messagePart1 = getString(R.string.toastMessage);

                //
                String messagePart2 = (String) adapterAnimal.getItem(i);

                Toast.makeText(getApplicationContext(),messagePart1+" " +messagePart2,Toast.LENGTH_SHORT).show();

            }
        });
    }
}