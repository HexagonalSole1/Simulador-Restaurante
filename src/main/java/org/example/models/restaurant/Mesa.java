package org.example.models.restaurant;

public class Mesa {
    private int numeroMesa;
    private boolean disponibilidad = true;
    private boolean isClean = true;

    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public boolean isDisponible() {
        return disponibilidad && isClean;
    }

    public void ocuparMesa() {
        disponibilidad = false;
    }

    public void liberarMesa() {
        disponibilidad = true;
    }

    public boolean isClean() {
        return isClean;
    }

    public void limpiarMesa() {
        isClean = true;
    }

    public void ensuciarMesa() {
        isClean = false;
    }
}
