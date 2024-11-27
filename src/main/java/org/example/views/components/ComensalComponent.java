package org.example.views.components;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;

public class ComensalComponent extends Component {

    public void moveToMesa(double x, double y) {
        entity.translateTowards(new Point2D(x, y), 100); // Velocidad
    }

    public void salirDelRestaurante() {
        entity.translateTowards(new Point2D(-100, entity.getY()), 100); // Movimiento hacia fuera
    }
}

