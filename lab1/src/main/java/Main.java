import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.paint.Color;

public class Main extends Application {
    final Color GREEN_TOXIC = new Color(0.5, 0.95, 0.3, 1.0);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                130.0, 40.0,
                150.0, 125.0,
                170.0, 50.0,
                250.0, 80.0,
                220.0,  150.0,
                150.0, 125.0,
                200.0, 180.0,
                140.0, 230.0,
                90.0, 170.0,
                150.0, 125.0,
                75.0, 140.0,
                50.0, 60.0,
                130.0, 40.0
        });

        root.getChildren().add(polygon);
        polygon.setFill(GREEN_TOXIC);
        polygon.setStrokeWidth(5.0);
        polygon.setStroke(GREEN_TOXIC);

        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(new Double[]{
                100.0, 90.0,
                200.0, 100.0,
                145.0, 177.0,
                100.0, 90.0
        });

        root.getChildren().add(polyline);
        polyline.setStroke(Color.PURPLE);
        polyline.setStrokeWidth(5.0);

        scene.setFill(Color.RED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
