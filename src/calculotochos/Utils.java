package calculotochos;

/**
 *
 * @author MAX
 * Constantes y funciones comunes
 */
public class Utils {
    public static double DEN_AL_6063 = 0.00269; //Densidas Aluminio 6063 en gr/mm3
    
    public static double areaCirculo(double diametro){
        return Math.PI * Math.pow((diametro/2), 2);
    }
    
    public static double round(double val, int places) {
		long factor = (long) Math.pow(10, places);
		val = val * factor;
		long tmp = Math.round(val);
		return tmp / factor;
	}
    public static double calcularPeso(int largo, double area){
        return area * largo * DEN_AL_6063;
    }
}
