package es.examen.david.sancho.tapasleon;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import java.util.ArrayList;

/**
 * Created by usuario.apellido on 06/03/2015.
 *
 * @author david.sancho
 */
public class BaresFragment extends ListFragment {



    public BaresFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_bares, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        final FragmentActivity fa = getActivity();


        final ProgressBar pb = (ProgressBar) fa.findViewById(R.id.progressBar);

        AsyncTask<Void, Integer, Bares> asyncTask = new AsyncTask<Void, Integer, Bares>() {
            @Override
            protected Bares doInBackground(Void... params) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Bares bares = Bares.getInstance();
                return bares;
            }

            @Override
            protected void onPostExecute(Bares bares) {
                ArrayList<String> lista = bares.getList();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(fa, android.R.layout.simple_list_item_1, lista);
                setListAdapter(adapter);
                pb.setVisibility(View.GONE);
            }
        };
        asyncTask.execute((Void) null);
    }
}
