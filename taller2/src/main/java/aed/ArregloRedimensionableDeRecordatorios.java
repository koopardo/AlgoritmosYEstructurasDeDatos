package aed;
import java.util.ArrayList;

class ArregloRedimensionableDeRecordatorios {
    private ArrayList<Recordatorio> recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new ArrayList<Recordatorio>();
    }

    public int longitud() {
        int res = this.recordatorios.size();
        return res;
    }

    public void agregarAtras(Recordatorio i) {
        this.recordatorios.add(i);
    }

    public Recordatorio obtener(int i) {
        Recordatorio res = this.recordatorios.get(i);
        return res;
    }

    public void quitarAtras() {
        this.recordatorios.remove(this.recordatorios.size()-1);
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.recordatorios.set(indice, valor);
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.recordatorios = new ArrayList<Recordatorio>();
        for (int i = 0; i < vector.longitud(); i++) {
            this.recordatorios.add(vector.obtener(i));
        }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios res = new ArregloRedimensionableDeRecordatorios(this);
        return res;
    }
}
