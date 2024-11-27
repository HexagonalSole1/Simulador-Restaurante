package org.example.views;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.dsl.FXGL;

import static com.almasb.fxgl.dsl.FXGL.entityBuilder;

public class Humans {

    public static Entity crearRecepcionista(double x, double y) {
        return entityBuilder()
                .at(x, y)
                .viewWithBBox("recepcionista.png") // Imagen ubicada en assets.textures
                .buildAndAttach();
    }

    public static Entity crearMesero(double x, double y) {
        return entityBuilder()
                .at(x, y)
                .viewWithBBox("mesera.png") // Imagen del mesero
                .buildAndAttach();
    }

    public static Entity crearChef(double x, double y) {
        return entityBuilder()
                .at(x, y)
                .viewWithBBox("chef.png") // Imagen del chef
                .buildAndAttach();
    }

    public static Entity crearComensal(double x, double y, String nombre) {
        return entityBuilder()
                .at(x, y)
                .viewWithBBox("cliente.png") // Imagen del comensal
                .buildAndAttach();
    }

    public static void crearMesa(int i, int i1) {
    }
}
