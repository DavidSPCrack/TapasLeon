package es.examen.david.sancho.tapasleon;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ConsultaBar extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_bar);

        Intent intent = getIntent();
        int barPos = intent.getIntExtra("bar_id", 0);

        Bares bares = Bares.getInstance();
        Bar bar = bares.get(barPos);

        TextView name = (TextView) findViewById(0);
        TextView address = (TextView) findViewById(0);

        name.setText(bar.getName());
        address.setText(bar.getAddress());
    }

}
