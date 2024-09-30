package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        Integer res = this.dia;
        return res;
    }

    public Integer mes() {
        Integer res = this.mes;
        return res;
    }

    @Override
    public String toString() {
        StringBuffer stringDinamico = new StringBuffer();
        stringDinamico.append(this.dia + "/" + this.mes);
        String res = stringDinamico.toString();
        return res;
    }

    @Override
    public boolean equals(Object otra) {
        boolean res = false;
        if (otra instanceof Fecha) {
            Fecha otraFecha = (Fecha) otra;
            res = this.dia == otraFecha.dia && this.mes == otraFecha.mes;
        }
        return res;
    }

    public void incrementarDia() {
        if (diasEnMes(this.mes) == this.dia) {
            this.dia = 1;
            this.mes = this.mes + 1;
            if (this.mes > 12) {
                this.mes = 1;
            }
        } else {
            this.dia = this.dia + 1;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
