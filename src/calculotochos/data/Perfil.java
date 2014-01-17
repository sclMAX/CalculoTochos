package calculotochos.data;

import calculotochos.Utils;
import com.db4o.config.annotations.Indexed;

/**
 *
 * @author Maxi
 */
public class Perfil {

    @Indexed
    private String id;
    public String nombre;
    public double area;
    public int largoComercial;
    public int salidas;
    public int tochoMedida;

    public Perfil(String id, String nombre, double area, int largoComercial, int salidas) {
        this.id = id;
        this.nombre = nombre;
        this.area = area;
        this.largoComercial = largoComercial;
        this.salidas = salidas;
    }

    public Perfil() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters ">   
    public double getPeso(int largo) {
        return getArea() * largo * Utils.DEN_AL_6063;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the largoComercial
     */
    public int getLargoComercial() {
        return largoComercial;
    }

    /**
     * @param largoComercial the largoComercial to set
     */
    public void setLargoComercial(int largoComercial) {
        this.largoComercial = largoComercial;
    }

    /**
     * @return the salidas
     */
    public int getSalidas() {
        return salidas;
    }

    /**
     * @param salidas the salidas to set
     */
    public void setSalidas(int salidas) {
        this.salidas = salidas;
    }

    @Override
    public String toString() {
        return id;
    }

    /**
     * @return the tochoMedida
     */
    public int getTochoMedida() {
        return tochoMedida;
    }

    /**
     * @param tochoMedida the tochoMedida to set
     */
    public void setTochoMedida(int tochoMedida) {
        this.tochoMedida = tochoMedida;
    }

    //</editor-fold>
}
