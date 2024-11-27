package org.example.controllers;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Point2D;

public class ComensalController {
    private Entity comensalEntity;

    // Constructor vacío para evitar inicialización temprana
    public ComensalController() {}

    // Método para inicializar al comensal dentro del ciclo de vida de FXGL
    public void crearComensal(String nombre, double x, double y) {
        this.comensalEntity = FXGL.entityBuilder()
                .at(x, y)
                .viewWithBBox("cliente.png") // Imagen del comensal
                .buildAndAttach();
    }

    // Método para mover al comensal visualmente
    public void mover(double x, double y) {
        FXGL.animationBuilder()
                .duration(javafx.util.Duration.seconds(1))
                .translate(comensalEntity)
                .to(new Point2D(x, y))
                .build()
                .start();
    }

}
