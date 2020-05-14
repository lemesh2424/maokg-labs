import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] Args) {
        launch(Args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 800, 800);

        drawBush(group);
        drawHat(group);
        drawLeg(group);
        drawLegPart(group);
        drawNeck(group);

        Path line = new Path();
        line.getElements().addAll(
                new MoveTo(85, 130),
                new CubicCurveTo(85, 155, 300, 157, 335, 130),
                new CubicCurveTo(335, 130, 210, 150, 85, 130)
        );
        line.setFill(Color.rgb(249, 133, 141));
        group.getChildren().add(line);

        drawBile(group);

        primaryStage.setScene(scene);
        primaryStage.show();
        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(2000), group);
        translateTransition.setFromX(50);
        translateTransition.setToX(350);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);

        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(3000), group);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);

        ScaleTransition scaleTransition =
                new ScaleTransition(Duration.millis(2000), group);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition =
                new ParallelTransition();
        parallelTransition.getChildren().addAll(
                translateTransition,
                rotateTransition,
                scaleTransition
        );

        parallelTransition.play();
    }

    public void drawLeg(Group group) {
        Path leg = new Path();
        leg.getElements().addAll(
                new MoveTo(170, 210),
                new QuadCurveTo(150, 354, 190, 358),
                new CubicCurveTo(210, 358, 250, 358, 215, 212)
        );
        leg.setFill(Color.WHITE);
        leg.setStroke(Color.BLACK);
        group.getChildren().add(leg);
    }

    public void drawNeck(Group group) {
        Path neck = new Path();
        neck.setFill(Color.WHITE);
        neck.getElements().addAll(
                new MoveTo(180, 153),
                new LineTo(165, 200),
                new QuadCurveTo(150, 210, 150, 215),
                new LineTo(165, 215),
                new QuadCurveTo(170, 220, 179, 219),
                new QuadCurveTo(182, 215, 185, 215),
                new QuadCurveTo(200, 228, 205, 222),
                new LineTo(220, 222),
                new QuadCurveTo(220, 219, 235, 215),
                new LineTo(235, 207),
                new QuadCurveTo(220, 175, 220, 153)
        );
        group.getChildren().add(neck);
    }

    public void drawBush(Group group) {
        Path green1 = new Path();
        green1.getElements().addAll(
                new MoveTo(150, 90),
                new CubicCurveTo(165, 50, 180, 35, 180, 90)
        );

        Rectangle r = new Rectangle(0, 0, 800, 800);
        r.setFill(Color.rgb(236, 254, 141));
        group.getChildren().addAll(r);

        Rectangle r1 = new Rectangle(100, 200, 100, 100);
        r1.setFill(Color.rgb(177, 246, 12));
        group.getChildren().addAll(r1);

        Rectangle r2 = new Rectangle(225, 270, 50, 100);
        r2.setFill(Color.rgb(177, 246, 12));
        group.getChildren().addAll(r2);

        Path green11 = new Path();
        green11.getElements().addAll(
                new MoveTo(130, 250),
                new QuadCurveTo(155, 240, 180, 280),
                new QuadCurveTo(155, 300, 130, 250)
        );

        green11.setStroke(Color.BLACK);
        green11.setFill(Color.rgb(184, 250, 17));
        group.getChildren().add(green11);

        Path green12 = new Path();
        green12.getElements().addAll(
                new MoveTo(130, 250),
                new QuadCurveTo(155, 300, 180, 285),
                new QuadCurveTo(140, 350, 130, 250)
        );

        green12.setStroke(Color.BLACK);
        green12.setFill(Color.rgb(96, 238, 11));
        group.getChildren().add(green12);


        Path green13 = new Path();
        green13.getElements().addAll(
                new MoveTo(70, 260),
                new LineTo(100, 240),
                new QuadCurveTo(105, 265, 110, 280),
                new LineTo(110, 290),
                new LineTo(100, 302),
                new LineTo(85, 295),
                new LineTo(85, 275),
                new LineTo(70, 260)
        );

        green13.setStroke(Color.BLACK);
        green13.setFill(Color.rgb(96, 157, 7));
        group.getChildren().add(green13);

        Path green14 = new Path();
        green14.getElements().addAll(
                new MoveTo(100, 302),
                new LineTo(85, 309),
                new QuadCurveTo(85, 335, 115, 335),
                new QuadCurveTo(115, 310, 145, 305),
                new LineTo(145, 297),
                new LineTo(150, 297),
                new LineTo(145, 285),
                new QuadCurveTo(110, 290, 100, 302)

        );
        green14.setStroke(Color.BLACK);
        green14.setFill(Color.rgb(175, 245, 11));
        group.getChildren().add(green14);

        Path green15 = new Path();
        green15.getElements().addAll(
                new MoveTo(115, 335),
                new QuadCurveTo(115, 310, 145, 305),
                new QuadCurveTo(150, 315, 163, 307),
                new QuadCurveTo(163, 354, 190, 358),
                new QuadCurveTo(185, 385, 163, 390),
                new QuadCurveTo(160, 375, 150, 380),
                new QuadCurveTo(120, 385, 125, 350)
        );

        Path green16 = new Path();
        green16.getElements().addAll(
                new MoveTo(190, 358),
                new QuadCurveTo(163, 354, 235, 330),
                new QuadCurveTo(260, 330, 235, 358),
                new QuadCurveTo(285, 372, 260, 385),
                new CubicCurveTo(235, 365, 240, 390, 163, 390)
        );

        Path green17 = new Path();
        green17.getElements().addAll(
                new MoveTo(375, 381),
                new LineTo(375, 350),
                new LineTo(295, 342),
                new LineTo(295, 280),
                new QuadCurveTo(270, 225, 250, 220),
                new LineTo(250, 200),
                new LineTo(225, 190),
                new QuadCurveTo(233, 187, 233, 147),
                new CubicCurveTo(190, 147, 225, 360, 165, 395),
                new LineTo(233, 395),
                new QuadCurveTo(240, 387, 260, 389),
                new LineTo(270, 384),
                new CubicCurveTo(289, 385, 296, 394, 305, 386),
                new CubicCurveTo(323, 389, 350, 394, 375, 381)
        );

        green15.setStroke(Color.BLACK);
        green15.setFill(Color.rgb(94, 158, 5));
        group.getChildren().add(green15);

        green16.setStroke(Color.BLACK);
        green16.setFill(Color.rgb(118, 126, 12));
        group.getChildren().add(green16);

        green17.setStroke(Color.BLACK);
        green17.setFill(Color.rgb(94, 163, 0));
        group.getChildren().add(green17);

        Path green18 = new Path();
        green17.getElements().addAll(
                new MoveTo(235, 340),
                new CubicCurveTo(235, 310, 245, 295, 238, 280),
                new CubicCurveTo(265, 250, 245, 302, 260, 317),
                new CubicCurveTo(255, 330, 245, 350, 235, 340)
        );

        green18.setStroke(Color.BLACK);
        green18.setFill(Color.rgb(169, 242, 0));
        group.getChildren().add(green18);

        Path green19 = new Path();
        green19.getElements().addAll(
                new MoveTo(325, 350),
                new QuadCurveTo(370, 360, 370, 325),
                new QuadCurveTo(360, 295, 315, 305)
        );

        Path green20 = new Path();
        green20.getElements().addAll(
                new MoveTo(315, 305),
                new QuadCurveTo(348, 295, 343, 288),
                new QuadCurveTo(305, 288, 315, 305)
        );

        green19.setStroke(Color.BLACK);
        green19.setFill(Color.rgb(174, 235, 20));
        group.getChildren().add(green19);

        green20.setStroke(Color.BLACK);
        green20.setFill(Color.rgb(106, 236, 45));
        group.getChildren().add(green20);

        Path green10 = new Path();
        green10.getElements().addAll(
                new MoveTo(150, 210),
                new QuadCurveTo(140, 225, 148, 240),
                new QuadCurveTo(140, 250, 155, 265),
                new LineTo(165, 270),
                new QuadCurveTo(180, 210, 150, 210)
        );

        green10.setStroke(Color.BLACK);
        green10.setFill(Color.rgb(83, 153, 8));
        group.getChildren().add(green10);

        green1.setStroke(Color.BLACK);
        green1.setFill(Color.rgb(105, 232, 27));
        group.getChildren().add(green1);

        Path green3 = new Path();
        green3.getElements().addAll(
                new MoveTo(200, 35),
                new CubicCurveTo(200, 110, 170, 33, 200, 35)
        );
        green3.setStroke(Color.BLACK);
        green3.setFill(Color.rgb(105, 232, 27));
        group.getChildren().add(green3);

        Path green2 = new Path();
        green2.getElements().addAll(
                new MoveTo(180, 35),
                new CubicCurveTo(210, 15, 200, 70, 180, 70),
                new QuadCurveTo(175, 45, 180, 35)
        );
        green2.setStroke(Color.BLACK);
        green2.setFill(Color.rgb(177, 246, 12));
        group.getChildren().add(green2);


        Path green4 = new Path();
        green4.getElements().addAll(
                new MoveTo(100, 140),
                new CubicCurveTo(173, 145, 135, 160, 100, 180),
                new QuadCurveTo(95, 160, 100, 140)
        );

        green4.setStroke(Color.BLACK);
        green4.setFill(Color.rgb(177, 246, 12));
        group.getChildren().add(green4);

        Path green5 = new Path();
        green5.getElements().addAll(
                new MoveTo(95, 200),
                new CubicCurveTo(95, 160, 102, 170, 105, 190)
        );

        Path green6 = new Path();
        green6.getElements().addAll(
                new MoveTo(105, 190),
                new CubicCurveTo(95, 190, 50, 220, 105, 265),
                new QuadCurveTo(108, 215, 105, 190)
        );

        green5.setStroke(Color.BLACK);
        green5.setFill(Color.rgb(106, 148, 52));
        group.getChildren().add(green5);

        green6.setStroke(Color.BLACK);
        green6.setFill(Color.rgb(184, 237, 25));
        group.getChildren().add(green6);

        Path green7 = new Path();
        green7.getElements().addAll(
                new MoveTo(110, 215),
                new QuadCurveTo(102, 169, 102, 180),
                new QuadCurveTo(140, 145, 170, 145),
                new QuadCurveTo(150, 175, 110, 215)
        );

        green7.setStroke(Color.BLACK);
        green7.setFill(Color.rgb(106, 148, 52));
        group.getChildren().add(green7);

        Path green9 = new Path();
        green9.getElements().addAll(
                new MoveTo(180, 175),
                new QuadCurveTo(165, 200, 150, 210),
                new QuadCurveTo(140, 245, 108, 240),
                new QuadCurveTo(108, 215, 108, 200)
        );

        green9.setStroke(Color.BLACK);
        green9.setFill(Color.rgb(69, 243, 1));
        group.getChildren().add(green9);

        Path green8 = new Path();
        green8.getElements().addAll(
                new MoveTo(170, 145),
                new QuadCurveTo(95, 220, 180, 175),
                new QuadCurveTo(180, 145, 170, 145)
        );

        green8.setStroke(Color.BLACK);
        green8.setFill(Color.rgb(173, 242, 11));
        group.getChildren().add(green8);
    }

    public void drawHat(Group group) {
        Path hat = new Path();

        double x = 1.0;
        hat.setStrokeWidth(1 * x);
        hat.setFill(Color.rgb(205, 20, 26));

        hat.setStrokeWidth(1 * x);

        hat.getElements().addAll(
                new MoveTo(95 * x, 145 * x),
                new ArcTo(10.0, 10.0, 0, 100, 120, false, true),
                new QuadCurveTo(130, 105, 150, 90),
                new CubicCurveTo(170, 60, 250, 60, 250, 90),
                new QuadCurveTo(260, 105, 320, 120),
                new ArcTo(10, 10, 0, 325, 145, false, true),
                new QuadCurveTo(210, 160, 95, 145)
        );
        group.getChildren().add(hat);
    }

    public void drawLegPart(Group group) {
        Path partLeg = new Path();
        partLeg.getElements().addAll(
                new MoveTo(216, 222),
                new LineTo(220, 223),
                new QuadCurveTo(250, 340, 217, 350)
        );
        partLeg.setFill(Color.WHITE);
        partLeg.setStroke(Color.BLACK);
        group.getChildren().add(partLeg);
    }

    public void drawBile(Group group) {
        Path bile1 = new Path();
        bile1.getElements().addAll(
                new MoveTo(143, 97),
                new QuadCurveTo(146, 92, 149, 97)
        );
        bile1.setStroke(Color.WHITE);
        bile1.setFill(Color.WHITE);
        group.getChildren().add(bile1);

        Path bile2 = new Path();
        bile2.getElements().addAll(
                new MoveTo(130, 105),
                new QuadCurveTo(133, 100, 141, 107),
                new QuadCurveTo(135, 107, 128, 105)

        );
        bile2.setStroke(Color.WHITE);
        bile2.setFill(Color.WHITE);
        group.getChildren().add(bile2);

        Path bile3 = new Path();
        bile3.getElements().addAll(
                new MoveTo(120, 115),
                new QuadCurveTo(123, 121, 131, 121),

                new CubicCurveTo(135, 120, 131, 125, 117, 120),
                new QuadCurveTo(112, 117, 120, 115)
        );
        bile3.setStroke(Color.WHITE);
        bile3.setFill(Color.WHITE);
        group.getChildren().add(bile3);

        Path bile4 = new Path();
        bile4.getElements().addAll(
                new MoveTo(108, 127),
                new QuadCurveTo(125, 127, 125, 137),

                new QuadCurveTo(108, 137, 108, 127)
        );
        bile4.setStroke(Color.WHITE);
        bile4.setFill(Color.WHITE);
        group.getChildren().add(bile4);

        Path bile5 = new Path();
        bile5.getElements().addAll(
                new MoveTo(140, 132),
                new QuadCurveTo(143, 124, 160, 130),

                new QuadCurveTo(150, 133, 140, 132)
        );
        bile5.setStroke(Color.WHITE);
        bile5.setFill(Color.WHITE);
        group.getChildren().add(bile5);

        Path bile6 = new Path();
        bile6.getElements().addAll(
                new MoveTo(140, 120),
                new CubicCurveTo(140, 116, 143, 112, 146, 120),

                new QuadCurveTo(146, 123, 140, 120)
        );
        bile6.setStroke(Color.WHITE);
        bile6.setFill(Color.WHITE);
        group.getChildren().add(bile6);


        Path bile7 = new Path();
        bile7.getElements().addAll(
                new MoveTo(160, 121),
                new QuadCurveTo(170, 126, 180, 131),

                new QuadCurveTo(170, 131, 160, 121)
        );
        bile7.setStroke(Color.WHITE);
        bile7.setFill(Color.WHITE);
        group.getChildren().add(bile7);


        Path bile8 = new Path();
        bile8.getElements().addAll(
                new MoveTo(155, 105),
                new QuadCurveTo(157, 108, 165, 108),

                new CubicCurveTo(166, 113, 157, 115, 155, 105)
        );
        bile8.setStroke(Color.WHITE);
        bile8.setFill(Color.WHITE);
        group.getChildren().add(bile8);


        Path round = new Path();
        round.getElements().addAll(
                new MoveTo(150, 90),
                new CubicCurveTo(200, 110, 235, 97, 240, 80)
        );
        group.getChildren().add(round);

        Path bile9 = new Path();
        bile9.getElements().addAll(
                new MoveTo(155, 95),

                new CubicCurveTo(158, 93, 161, 95, 155, 95)
        );
        bile9.setStroke(Color.WHITE);
        bile9.setFill(Color.WHITE);
        group.getChildren().add(bile9);


        Path bile10 = new Path();
        bile10.getElements().addAll(
                new MoveTo(166, 100),

                new CubicCurveTo(171, 95, 176, 105, 166, 100)
        );
        bile10.setStroke(Color.WHITE);
        bile10.setFill(Color.WHITE);
        group.getChildren().add(bile10);

        Path bile11 = new Path();
        bile11.getElements().addAll(
                new MoveTo(176, 110),

                new CubicCurveTo(196, 115, 196, 123, 186, 115),
                new CubicCurveTo(183, 115, 176, 115, 176, 110)
        );
        bile11.setStroke(Color.WHITE);
        bile11.setFill(Color.WHITE);
        group.getChildren().add(bile11);

        Path bile12 = new Path();
        bile12.getElements().addAll(
                new MoveTo(180, 140),


                new CubicCurveTo(182, 135, 188, 135, 190, 140)
        );
        bile12.setStroke(Color.WHITE);
        bile12.setFill(Color.WHITE);
        group.getChildren().add(bile12);


        Path bile13 = new Path();
        bile13.getElements().addAll(
                new MoveTo(205, 107),


                new CubicCurveTo(220, 97, 218, 100, 205, 110)
        );
        bile13.setStroke(Color.WHITE);
        bile13.setFill(Color.WHITE);
        group.getChildren().add(bile13);

        Path bile14 = new Path();
        bile14.getElements().addAll(
                new MoveTo(205, 117),


                new CubicCurveTo(220, 105, 218, 110, 205, 120)
        );
        bile14.setStroke(Color.WHITE);
        bile14.setFill(Color.WHITE);
        group.getChildren().add(bile14);

        Path bile15 = new Path();
        bile15.getElements().addAll(
                new MoveTo(205, 127),


                new CubicCurveTo(210, 127, 215, 120, 220, 127)
        );
        bile15.setStroke(Color.WHITE);
        bile15.setFill(Color.WHITE);
        group.getChildren().add(bile15);
        Path bile16 = new Path();
        bile16.getElements().addAll(
                new MoveTo(205, 132),


                new CubicCurveTo(217, 137, 220, 132, 220, 137),
                new CubicCurveTo(210, 137, 205, 137, 205, 132)
        );
        bile16.setStroke(Color.WHITE);
        bile16.setFill(Color.WHITE);
        group.getChildren().add(bile16);

        Path bile17 = new Path();
        bile17.getElements().addAll(
                new MoveTo(225, 102),


                new CubicCurveTo(240, 92, 238, 95, 225, 105)
        );
        bile17.setStroke(Color.WHITE);
        bile17.setFill(Color.WHITE);
        group.getChildren().add(bile17);

        Path bile18 = new Path();
        bile18.getElements().addAll(
                new MoveTo(225, 107),


                new CubicCurveTo(240, 102, 238, 105, 225, 110)
        );
        bile18.setStroke(Color.WHITE);
        bile18.setFill(Color.WHITE);
        group.getChildren().add(bile18);

        Path bile19 = new Path();
        bile19.getElements().addAll(
                new MoveTo(225, 117),


                new CubicCurveTo(230, 114, 238, 115, 230, 120)
        );
        bile19.setStroke(Color.WHITE);
        bile19.setFill(Color.WHITE);
        group.getChildren().add(bile19);

        Path bile20 = new Path();
        bile20.getElements().addAll(
                new MoveTo(225, 124),


                new CubicCurveTo(230, 124, 238, 135, 230, 135)
        );
        bile20.setStroke(Color.WHITE);
        bile20.setFill(Color.WHITE);
        group.getChildren().add(bile20);

        Path bile21 = new Path();
        bile21.getElements().addAll(
                new MoveTo(241, 110),


                new CubicCurveTo(256, 99, 254, 110, 241, 110)
        );
        bile21.setStroke(Color.WHITE);
        bile21.setFill(Color.WHITE);
        group.getChildren().add(bile21);
        Path bile22 = new Path();
        bile22.getElements().addAll(
                new MoveTo(251, 126),


                new CubicCurveTo(266, 115, 265, 126, 256, 126)
        );
        bile22.setStroke(Color.WHITE);
        bile22.setFill(Color.WHITE);
        group.getChildren().add(bile22);
        Path bile33 = new Path();
        bile33.getElements().addAll(
                new MoveTo(266, 134),


                new CubicCurveTo(281, 123, 281, 134, 271, 134)
        );
        bile33.setStroke(Color.WHITE);
        bile33.setFill(Color.WHITE);
        group.getChildren().add(bile33);
        Ellipse bile23 = new Ellipse(85, 133, 3, 1);
        bile23.setFill(Color.WHITE);
        group.getChildren().add(bile23);
        Ellipse bile24 = new Ellipse(98, 141, 3, 1);
        bile24.setFill(Color.WHITE);
        group.getChildren().add(bile24);
        Ellipse bile25 = new Ellipse(128, 137, 3, 1);
        bile25.setFill(Color.WHITE);
        group.getChildren().addAll(bile25);
        Ellipse bile26 = new Ellipse(140, 140, 9, 1);
        bile26.setFill(Color.WHITE);
        group.getChildren().add(bile26);
        Ellipse bile27 = new Ellipse(180, 145, 8, 1);
        bile27.setFill(Color.WHITE);
        group.getChildren().add(bile27);
        Ellipse bile28 = new Ellipse(220, 143, 8, 1);
        bile28.setFill(Color.WHITE);
        group.getChildren().add(bile28);
        Ellipse bile29 = new Ellipse(245, 145, 6, 1);
        bile29.setFill(Color.WHITE);
        group.getChildren().add(bile29);
        Ellipse bile30 = new Ellipse(265, 143, 4, 1);
        bile30.setFill(Color.WHITE);
        group.getChildren().add(bile30);
        Ellipse bile31 = new Ellipse(300, 138, 4, 1);
        bile31.setFill(Color.WHITE);
        group.getChildren().add(bile31);
        Ellipse bile32 = new Ellipse(330, 130, 3, 1);
        bile32.setFill(Color.WHITE);
        group.getChildren().add(bile32);
        Path leg2 = new Path();
        leg2.getElements().addAll(
                new MoveTo(290, 240),
                new CubicCurveTo(290, 340, 240, 380, 300, 380),
                new CubicCurveTo(360, 380, 315, 340, 305, 240)
        );
        leg2.setFill(Color.WHITE);
        leg2.setStroke(Color.BLACK);
        group.getChildren().add(leg2);
        Circle circle = new Circle(300, 250, 40);
        circle.setFill(Color.rgb(245, 1, 14));
        Circle circle1 = new Circle(290, 235, 3);
        circle1.setFill(Color.WHITE);
        Circle circle2 = new Circle(267, 235, 3);
        circle2.setFill(Color.WHITE);
        Circle circle3 = new Circle(285, 217, 3);
        circle3.setFill(Color.WHITE);
        Circle circle4 = new Circle(300, 212, 3);
        circle4.setFill(Color.WHITE);
        Circle circle5 = new Circle(325, 227, 3);
        circle5.setFill(Color.WHITE);
        Circle circle6 = new Circle(335, 250, 3);
        circle6.setFill(Color.WHITE);
        Circle circle7 = new Circle(320, 245, 3);
        circle7.setFill(Color.WHITE);
        Circle circle8 = new Circle(305, 265, 3);
        circle8.setFill(Color.WHITE);
        Circle circle9 = new Circle(290, 280, 3);
        circle9.setFill(Color.WHITE);
        Circle circle10 = new Circle(270, 260, 3);
        circle10.setFill(Color.WHITE);
        group.getChildren().add(circle);
        group.getChildren().add(circle1);
        group.getChildren().add(circle2);
        group.getChildren().add(circle3);
        group.getChildren().add(circle4);
        group.getChildren().add(circle5);
        group.getChildren().add(circle6);
        group.getChildren().add(circle7);
        group.getChildren().add(circle8);
        group.getChildren().add(circle9);
        group.getChildren().add(circle10);
    }
}