package org.example.views.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.dsl.FXGL;

public class ComensalComponent extends Component {

    private double destinoX;
    private double destinoY;

    public void moveToMesa(double mesaX, double mesaY) {
        this.destinoX = mesaX;
        this.destinoY = mesaY;
        // Puedes agregar lógica para mover al comensal con animaciones, si lo deseas.
    }

    public void salirDelRestaurante() {
        // Lógica para hacer que el comensal salga
        System.out.println("El comensal ha salido del restaurante.");
        // Podrías eliminar la entidad si es necesario:
        FXGL.getGameWorld().removeEntity(entity);
    }

    @Override
    public void onUpdate(double tpf) {
        // Aquí puedes actualizar el movimiento del comensal hacia la mesa
        double x = entity.getX();
        double y = entity.getY();

        // Movimiento simple hacia la mesa
        if (x < destinoX) {
            x += 2; // Velocidad en el eje X
        } else if (x > destinoX) {
            x -= 2;
        }

        if (y < destinoY) {
            y += 2; // Velocidad en el eje Y
        } else if (y > destinoY) {
            y -= 2;
        }

        // Actualiza la posición
        entity.setPosition(x, y);
    }
}
