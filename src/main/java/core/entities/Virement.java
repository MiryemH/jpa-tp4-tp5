package core.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Classe qui représente un virement (type d'opération bancaire)
 *
 * @author Miryem HRARTI
 */
@Entity
@Table(name="VIREMENTS")
public class Virement extends Operation{
    /**
     * un virement possède un bénéficiaire + plus : date ou effectué le virement,
     * le montant et le motif hérités de la classe Operation
     */
    @Column(name="BENEFICIAIRE", nullable = false)
    private String beneficiare;

    /**
     * Constructeur par défaut
     */
    public Virement() {
    }

    /**
     * Constructeurs avec arguments
     *
     * @param date    de l'opération bancaire
     * @param montant de l'opération bancaire
     * @param motif   de l'opération bancaire
     * @param compte  sur lequel l'opération est effectuée
     * @param beneficiare à qui adressé le virement
     */
    public Virement(LocalDate date, double montant, String motif, Compte compte, String beneficiare) {
        super(date, montant, motif, compte);
        this.beneficiare = beneficiare;
    }

    /**
     *
     * @return le nom du bénéficiaire du virement
     */
    public String getBeneficiare() {
        return beneficiare;
    }

    /**
     * modifie le nom du bénéficiaire du virement
     * @param beneficiare nouveau nom du bénéficiaire
     */
    public void setBeneficiare(String beneficiare) {
        this.beneficiare = beneficiare;
    }
}
