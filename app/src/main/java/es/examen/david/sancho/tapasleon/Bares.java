package es.examen.david.sancho.tapasleon;

import java.util.ArrayList;

/**
 * Created by usuario.apellido on 06/03/2015.
 *
 * @author david.sancho
 */
public class Bares {

    private static Bares instance;
    private ArrayList<Bar> bares;

    private Bares() {
        bares = new ArrayList<>();
        add(new Bar("El rebote", "gran vía 3"));
        add(new Bar("La competencia", "ave maria 23"));
        add(new Bar("Casa Blas", "Plaza España 3"));
        add(new Bar("Dominos pizza", "Fuencarral 34"));
        add(new Bar("Burguer Queen", "Montera 12"));
        add(new Bar("La celtica", "Alcala 35"));
    }

    public static Bares getInstance() {
        if (instance == null) {
            instance = new Bares();
        }
        return instance;
    }

    public void add(Bar bar) {
        bares.add(bar);
    }

    public void remove(int i) {
        bares.remove(i);
    }

    public Bar get(int i) {
        return bares.get(i);
    }

    public ArrayList<String> getList() {
        ArrayList<String> lista = new ArrayList<>();
        for (Bar bar : bares) {
            lista.add(bar.getName());
        }
        return lista;
    }

}
