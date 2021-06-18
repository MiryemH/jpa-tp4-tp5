package core.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe qui représente une banque
 * @author Miryem HRARTI
 */
@Entity
@Table(name="BANQUE")
public class Banque {
    /**
     * Une banque possède un identifiant, un nom et une liste de clients
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_BANQUE", nullable = false)
    private long id;
    @Column(name="NOM", nullable = false)
    private String nom;
    @OneToMany(mappedBy = "banque", cascade = CascadeType.ALL)
    private Set<Client> clients ;

    /**
     * Constructeur par défaut
     */
    public Banque() {
        clients = new HashSet<>();
    }

    /**
     *
     * @return l'id de la banque
     */
    public long getId() {
        return id;
    }

    /**
     * modifie l'id de la banque
     * @param id nouveau id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return le nom de la banque
     */
    public String getNom() {
        return nom;
    }

    /**
     * modifie le nom de la banque
     * @param nom nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return la liste des clients de la banque
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * modifie la liste des clients de la banque
     * @param clients nouvelle liste de clients
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id: " + id +
                ", nom: " + nom + "}";
    }
}
