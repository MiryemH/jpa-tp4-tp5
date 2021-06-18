package core.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe qui représente Client
 *
 * @author Miryem HRARTI
 */
@Entity
@Table(name="CLIENTS")
public class Client {
    /**
     * Un client est caractérisé par un id, nom, prénom, date de naissance, adresse postale
     * une banque ou il y a ses comptes
     * et une liste de comptes que possède le client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CLI", nullable = false, insertable = false, updatable = false)
    private long id;
    @Column(name="NOM", nullable = false)
    private String nom;
    @Column(name="PRENOM", nullable = false)
    private String prenom;
    @Column(name="DATE_NAIS", nullable = false)
    private LocalDate dateNaissance;
    @Embedded
    private Adresse adresse;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_BANQUE")
    private Banque banque;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="CLIENTS_COMPTES",
            joinColumns = @JoinColumn(name="ID_CLIENT", referencedColumnName = "ID_CLI"),
            inverseJoinColumns = @JoinColumn(name="ID_COMPTE", referencedColumnName = "ID_COM"))
    private Set<Compte> mesComptes = new HashSet<>();

    /**
     * Constructeur par défaut
     */
    public Client() {
    }

    /**
     * Constructeur avec paramètres: crée un client avec nom, prenom, dateNaissance
     * @param nom du client
     * @param prenom du client
     * @param dateNaissance du client
     */

    public Client(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    /**
     *
     * @return l'ID du client
     */
    public long getId() {
        return id;
    }

    /**
     * modifie l'ID du client
     * @param id nouveau id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return le nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * modifie le nom du client
     * @param nom nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return le prénom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * modifie le prénom du client
     * @param prenom nouveau prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return la date de naissance du client
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * modifie la date de naissance
     * @param dateNaissance nouvelle date de naissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     *
     * @return l'adresse du client
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * modifie l'adresse du client
     * @param adresse nouvelle adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     *
     * @return la banque ou le client a ses comptes
     */
    public Banque getBanque() {
        return banque;
    }

    /**
     * modifie la banque
     * @param banque nouvelle banque
     */
    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    /**
     *
     * @return la liste de ses comptes
     */
    public Set<Compte> getMesComptes() {
        return mesComptes;
    }

    /**
     * modifie les comptes du client
     * @param mesComptes nouvelle liste de comptes
     */
    public void setMesComptes(Set<Compte> mesComptes) {
        this.mesComptes = mesComptes;
    }

    /**
     *
     * @return la description d'un client sous forme de chaine de
     * caractères en concaténant les attributs du client: nom, prenom
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "ID:" + id +
                ", " + prenom +
                " " + nom.toUpperCase() +
                ", Né(e) le: " + dateNaissance +
                ", \n" + adresse +
                ", \n Banque: " + banque.getNom() +"}";
    }
}
