package es.examen.david.sancho.tapasleon;

/**
 * Created by usuario.apellido on 28/11/2014.
 */
public class Bar {

    private String name;
    private String address;

    public Bar(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return getName();
    }
}
