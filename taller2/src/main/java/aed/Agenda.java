package aed;

public class Agenda {
    private Fecha fecha;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        this.fecha = new Fecha(fechaActual);
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        StringBuffer stringDinamico = new StringBuffer();
        stringDinamico.append(this.fecha + "\n" + "=====\n");
        for (int i = 0; i < this.recordatorios.longitud(); i++) {
            if (this.recordatorios.obtener(i).fecha().equals(this.fecha)) {
                stringDinamico.append(this.recordatorios.obtener(i).toString() + "\n");
            }
        }
        String res = stringDinamico.toString();
        return res;
    }

    public void incrementarDia() {
        this.fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        Fecha res = new Fecha(this.fecha);
        return res;
    }

}
