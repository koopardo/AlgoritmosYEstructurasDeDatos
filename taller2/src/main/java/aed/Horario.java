package aed;

public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        int res = this.hora;
        return res;
    }

    public int minutos() {
        int res = this.minutos;
        return res;
    }

    @Override
    public String toString() {
        StringBuffer stringDinamico = new StringBuffer();
        stringDinamico.append(this.hora + ":" + this.minutos);
        String res = stringDinamico.toString();
        return res;
    }

    @Override
    public boolean equals(Object otro) {
        boolean res = false;
        if (otro instanceof Horario) {
            Horario otroHorario = (Horario) otro;
            res = this.hora == otroHorario.hora && this.minutos == otroHorario.minutos;
        }
        return res;
    }

}
