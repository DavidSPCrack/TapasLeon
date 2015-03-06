package es.examen.david.sancho.tapasleon;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<Bar> bares;
    private ArrayAdapter<Bar> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bares = new ArrayList<Bar>();
        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<Bar>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        adapter.add(new Bar("El rebote", "gran vía 3"));
        adapter.add(new Bar("La competencia", "ave maria 23"));
        adapter.add(new Bar("Casa Blas", "Plaza España 3"));
        adapter.add(new Bar("Dominos pizza", "Fuencarral 34"));
        adapter.add(new Bar("Burguer Queen", "Montera 12"));
        adapter.add(new Bar("La celtica", "Alcala 35"));

        Log.v(TAG, "Event onCreate");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void saveButton(View v) {
        Log.v(TAG, "Event onClick");
        EditText name = (EditText) findViewById(R.id.name);
        EditText address = (EditText) findViewById(R.id.address);
        String sName = name.getText().toString();
        String sAddress = address.getText().toString();

        String message = String.format(getString(R.string.toast), sName, sAddress);

        Bar bar = new Bar(sName, sAddress);
        adapter.add(bar);

        name.getText().clear();
        address.getText().clear();

        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
