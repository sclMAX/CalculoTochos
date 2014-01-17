package calculotochos.data;

/**
 *
 * @author Maxi
 */
public class Tocho {
    public int diametro;
    public int largo;

    public Tocho(int diametro, int largo) {
        this.diametro = diametro;
        this.largo = largo;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    /**
     * @return the diametro
     */
    public int getDiametro() {
        return diametro;
    }

    /**
     * @param diametro the diametro to set
     */
    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    /**
     * @return the largo
     */
    public int getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(int largo) {
        this.largo = largo;
    }
    //</editor-fold>

    int getDiametor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
