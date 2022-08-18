package com.github.youssefagagg.paint;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;


public class FreePaint extends MyShape {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int pointCount = 1;
    private int x;
    private Point2D[] points = new Point2D[2000];

    Image brush = createBrush(1.0, Color.TEAL);
    double brushWidthHalf = brush.getWidth() / 2.0;
    double brushHeightHalf = brush.getHeight() / 2.0;

    public FreePaint() {

        super();
    }

    public  Image createImage(Node node) {

        WritableImage wi;

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(getColor());

        int imageWidth = (int) node.getBoundsInLocal().getWidth();
        int imageHeight = (int) node.getBoundsInLocal().getHeight();

        wi = new WritableImage(imageWidth, imageHeight);
        node.snapshot(parameters, wi);

        return wi;

    }

    public  Image createBrush(double radius, Color color) {

        // create gradient image with given color
        Circle brush = new Circle(getStrokeWidth());

        RadialGradient gradient1 = new RadialGradient(0, 0, 0, 0, getStrokeWidth(), false, CycleMethod.NO_CYCLE, new Stop(0, getColor().deriveColor(1, 1, 1, 0.3)), new Stop(1, getColor().deriveColor(1, 1, 1, 0)));

        brush.setFill(gradient1);

        // create image
        return createImage(brush);

    }

    public FreePaint(int x1, int x2, int y1, int y2, Color color, int sw) {
        super(x1, x2, y1, y2, color, sw);


    }

    @Override
    public void draw(GraphicsContext g) {
        points[0] = new Point2D(getXCoordinateFirstPoint(), getYCoordinateFirstPoint());

        if (pointCount < points.length) {
            points[pointCount++] = new Point2D(getXCoordinateSecondPoint(), getYCoordinateSecondPoint());

        }

        x = getStrokeWidth() + 5;
        for (int i = 0; i < pointCount - 1; i++)
            bresenhamLine(points[i].getX(), points[i].getY(), points[i + 1].getX(), points[i + 1].getY(), g);


    }

    // https://de.wikipedia.org/wiki/Bresenham-Algorithmus
    private void bresenhamLine(double x0, double y0, double x1, double y1, GraphicsContext g) {
        double dx = Math.abs(x1 - x0), sx = x0 < x1 ? 1. : -1.;
        double dy = -Math.abs(y1 - y0), sy = y0 < y1 ? 1. : -1.;
        double err = dx + dy, e2; /* error value e_xy */

        while (true) {
            g.drawImage(brush, x0 - brushWidthHalf, y0 - brushHeightHalf);
            if (x0 == x1 && y0 == y1) break;
            e2 = 2. * err;
            if (e2 > dy) {
                err += dy;
                x0 += sx;
            } /* e_xy+e_x > 0 */
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            } /* e_xy+e_y < 0 */
        }
    }

    @Override
    public String toString() {
        return "free paint";
    }

}
