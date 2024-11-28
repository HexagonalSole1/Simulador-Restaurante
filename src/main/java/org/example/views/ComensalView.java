package org.example.views;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.dsl.FXGL;
import org.example.views.components.ComensalComponent;

public class ComensalView {

    private Entity comensal;

    public ComensalView(double startX, double startY) {
        this.comensal = FXGL.entityBuilder()
                .at(startX, startY) // Posición inicial
                .view("cliente.png") // Imagen
                .with(new ComensalComponent()) // Agrega el componente
                .buildAndAttach();
    }

    public void moverAMesa(double mesaX, double mesaY) {
        comensal.getComponent(ComensalComponent.class).moveToMesa(mesaX, mesaY);
    }

    public void salir() {
        comensal.getComponent(ComensalComponent.class).salirDelRestaurante();
    }
}

