package org.example.controllers;

import org.example.views.MeseroView;

public class MeseroController {
    private final MeseroView meseroView;

    public MeseroController(MeseroView meseroView) {
        this.meseroView = meseroView;
    }

    // Lógica para mover al mesero a una mesa específica
    public void moverAMesa(double x, double y) {
        System.out.println("Moviendo al mesero a la posición: (" + x + ", " + y + ")");
        meseroView.mover(x, y); // Solicita a la vista que realice el movimiento
    }
}
