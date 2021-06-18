package core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe qui représente un Livret A et qui hérite de Compte
 *
 * @author Miryem HRARTI
 */
@Entity
@Table(name="LIVRETS_A")
public class LivretA extends Compte{
    /**
     * un livret A est caractérisé aussi par le taux
     */
    @Column(name="TAUX")
    private double taux;

    /**
     * Constructeur par défaut
     */
    public LivretA() {
        super();
    }

    /**
     * Constructeur créant un compte avec un numéro et un solde
     *
     * @param numero du compte: Livret A
     * @param solde  du compte: Livret A
     * @param taux du compte: Livret A
     */
    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    /**
     *
     * @return le taux du livret A
     */
    public double getTaux() {
        return taux;
    }

    /**
     * modifie le taux du livret A
     * @param taux
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    /**
     *
     * @return une description du compte LivretA en concaténant
     * ses attributs hérités de Compte et le taux
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Taux: " + taux ;
    }
}
