package core.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe abstraite qui représente un compte bancaire
 *
 * @author Miryem HRARTI
 */
@Entity
@Table(name="COMPTES")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class  Compte {
    /**
     * Un compte bancaire est caractérisé par un ID, un numero et un solde
     * une liste d'opérations et liste de clients possédant ce compte
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_COM", nullable = false)
    private long id;
    @Column(name="NUMERO", nullable = false)
    private String numero;
    @Column(name="SOLDE", nullable = false)
    private double solde;
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
    private Set<Operation> operations = new HashSet<>();
    //@ManyToMany(mappedBy="mesComptes")// maitre esclave
    @ManyToMany
    @JoinTable(name="CLIENTS_COMPTES",
            joinColumns = @JoinColumn(name="ID_COMPTE", referencedColumnName = "ID_COM"),
            inverseJoinColumns = @JoinColumn(name="ID_CLIENT", referencedColumnName = "ID_CLI"))
    private Set<Client> clients = new HashSet<>();

    /**
     * Constructeur par défaut
     */
    public Compte() {
    }

    /**
     * Constructeur créant un compte avec un numéro et un solde
     * @param numero du compte
     * @param solde du compte
     */
    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    /**
     *
     * @return l'ID du compte
     */
    public long getId() {
        return id;
    }

    /**
     * modifie l'ID du compte
     * @param id nouveau ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return le N° du compte
     */
    public String getNumero() {
        return numero;
    }

    /**
     * modifie le N° du compte
     * @param numero nouveau N°
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return le solde du compte
     */
    public double getSolde() {
        return solde;
    }

    /**
     * modifie le solde du compte
     * @param solde le nouveau solde
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     *
     * @return la liste des opérations effectuées sur le compte
     */
    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * modifie opérations effectuées sur le compte
     * @param operations la nouvelle liste des opértaions
     */
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    /**
     *
     * @return la liste des clients qui détiennent le compte
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * modifie la liste des clients qui détiennent le compte
     * @param clients nouvelle liste des clients
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    /**
     *
     * @return une description du compte en concaténant
     *   ses attributs  numéro et solde
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()+ "---->" +
                "N°: " + numero + '\'' +
                ", Solde: " + solde + "€";
    }
}
