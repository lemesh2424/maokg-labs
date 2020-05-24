import javax.media.j3d.*;
import javax.vecmath.Color3f;
import java.awt.Color;

public class Utils {

    public static Appearance getDumbbellAppearence() {
        Appearance ap = new Appearance();

        Color3f emissive = new Color3f(new Color(0, 0, 0));
        Color3f ambient = new Color3f(Color.CYAN);
        Color3f diffuse = new Color3f(Color.MAGENTA);
        Color3f specular = new Color3f(new Color(0, 0, 0));

        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));

        return ap;
    }
}