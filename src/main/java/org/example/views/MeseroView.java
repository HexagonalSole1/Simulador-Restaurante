package org.example.views;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.geometry.Point2D;

public class MeseroView {
    private Entity meseroEntity;

    public MeseroView() {}

    // Crear la entidad visual del mesero
    public void crearMesero(String nombre, double x, double y) {
        this.meseroEntity = FXGL.entityBuilder()
                .at(x, y)
                .viewWithBBox("mesera.png") // Imagen del mesero
                .buildAndAttach();
    }

    // Método para mover al mesero visualmente
    public void mover(double x, double y) {
        FXGL.animationBuilder()
                .duration(javafx.util.Duration.seconds(100)) // Duración del movimiento
                .translate(meseroEntity) // Entidad a mover
                .to(new Point2D(x, y)) // Nueva posición
                .build()
                .start();
    }

    public Entity getEntity() {
        return meseroEntity;
    }
}
