package calculotochos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author MAX Constantes y funciones comunes
 */
public class Utils {

    public static double DEN_AL_6063 = 0.00269; //Densidas Aluminio 6063 en gr/mm3

    public static double areaCirculo(double diametro) {
        return Math.PI * Math.pow((diametro / 2), 2);
    }

    public static String round(double val, int places) {
        String f;
        f = "#.";
        for(int i = 0; i < places; i++){
            f += "0";
        }
        DecimalFormat df = new DecimalFormat(f);
        return df.format(val);
    }

    public static double calcularPeso(int largo, double area) {
        return area * largo * DEN_AL_6063;
    }
    
    public static String getDate(){
        Date d = new Date();
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dtf.format(d);
    }
    
    public static Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        } else {
            BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            icon.paintIcon(null, image.getGraphics(), 0, 0);
            return image;
        }
    }
}
