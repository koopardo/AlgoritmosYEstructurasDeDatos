package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        Horario res = this.horario;
        return res;
    }

    public Fecha fecha() {
        Fecha res = new Fecha(this.fecha);
        return res;
    }

    public String mensaje() {
        String res = this.mensaje;
        return res;
    }

    @Override
    public String toString() {
        StringBuffer stringDinamico = new StringBuffer();
        stringDinamico.append(this.mensaje + " @ " + this.fecha + " " + this.horario);
        String res = stringDinamico.toString();
        return res;
    }

    @Override
    public boolean equals(Object otro) {
        boolean res = false;
        if (otro instanceof Recordatorio) {
            Recordatorio otroRecordatorio = (Recordatorio) otro;
            res = this.mensaje == otroRecordatorio.mensaje && this.fecha.equals(otroRecordatorio.fecha)
            && this.horario.equals(otroRecordatorio.horario);
        }
        return res;
    }

}
