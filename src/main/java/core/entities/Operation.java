package core.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Classe qui représente une adresse postale d'une personne
 *
 * @author Miryem HRARTI
 */
@Entity
@Table(name="OPERATIONS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
    /**
     * Une opération sur un compte est caractérisée par
     * un id, une date ou l'opération a eu lieu, un montant et un motif
     * et le compte sur lequel a été effectuée
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_OP", nullable = false)
    private long id;
    @Column(name="DATE_OP", nullable = false)
    private LocalDate date;
    @Column(name="MONTANT", nullable = false)
    private double montant;
    @Column(name="MOTIF", nullable = false)
    private String motif;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_COM")
    private Compte compte;

    /**
     * Constructeur par défaut
     */
    public Operation(){

    }

    /**
     * Constructeurs avec arguments
     * @param date de l'opération bancaire
     * @param montant de l'opération bancaire
     * @param motif de l'opération bancaire
     * @param compte sur lequel l'opération est effectuée
     */
    public Operation(LocalDate date, double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    /**
     *
     * @return l'ID de l'opération
     */
    public long getId() {
        return id;
    }

    /**
     * modifie l'ID de l'opération
     * @param id nouveau ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return la date ou l'opération bancaire a eu lieu
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * modifie la date ou l'opération bancaire a eu lieu
     * @param date nouvelle date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * @return le montant de l'opération bancaire
     */
    public double getMontant() {
        return montant;
    }

    /**
     * modifie le montant de l'opération bancaire
     * @param montant le nouveau montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     *
     * @return le motif de l'opération bancaire
     */
    public String getMotif() {
        return motif;
    }

    /**
     * modifie le motif  de l'opération bancaire
     * @param motif le nouveau motif
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     *
     * @return le compte bancaire sur lequel est appliquée l'opération
     */
    public Compte getCompte() {
        return compte;
    }

    /**
     * modifie le compte  bancaire sur lequel est appliquée l'opération
     * @param compte nouveau compte
     */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    /**
     *
     * @return une chaine de caractère: description d'une opération
     * en concaténant ses attributs date de fin, montant, motif et compte
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()+ "---->"+
                " Date: " + date +
                ", Montant:" + montant +
                "€, Motif='" + motif +
                ", " + compte +"}";
    }
}
