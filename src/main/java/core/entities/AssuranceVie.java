package core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Classe qui représente un compte sous forme Assurance vie et qui hérite de Compte
 *
 * @author Miryem HRARTI
 */
@Entity
@Table(name="ASSURANCES_VIE")
public class AssuranceVie extends Compte{
    /**
     * une assurance de vie possède une date de fin et un taux
     */
    @Column(name="DATE_FIN", nullable = false)
    private LocalDate dateFin;
    @Column(name="TAUX")
    private double taux;

    /**
     * Constructeur par défaut
     */
    public AssuranceVie() {
        super();
    }

    /**
     * Constructeur créant un compte avec un numéro et un solde
     *
     * @param numero du compte: Assurance Vie
     * @param solde  du compte: Assurance Vie
     * @param dateFin date de fin de l'assurance vie
     * @param taux taux du compte de l'assurance Vie
     */
    public AssuranceVie(String numero, double solde, double taux, LocalDate dateFin) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    /**
     *
     * @return la date de fin de l'assurance vie
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * modifie la date de fin de l'assurance vie
     * @param dateFin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     *
     * @return taux de l'assurance  vie
     */
    public double getTaux() {
        return taux;
    }

    /**
     * modifie le taux de l'assurance  vie
     * @param taux nouveau taux
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    /**
     *
     * @return une description du compte en concaténant
     *    ses attributs  hérités de la classe Compte + taux et date de fin
     */
    @Override
    public String toString() {
        return super.toString()+
                ", Date de fin: " + dateFin +
                ", Taux=" + taux ;
    }
}
