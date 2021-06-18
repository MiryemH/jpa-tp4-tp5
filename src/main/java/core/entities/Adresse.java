package core.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe qui représente une adresse postale d'une personne
 *
 * @author Miryem HRARTI
 */


@Embeddable
public class Adresse {
    /**
     * Une adresse est caractérisé par un N° et libellé de rue
     * un code postal et une ville
     */
    @Column(name="NUMERO", nullable = false)
    private int numero;
    @Column(name="RUE", nullable = false)
    private String rue;
    @Column(name="CODE_POSTAL", nullable = false)
    private int codePostal;
    @Column(name="VILLE", nullable = false)
    private String ville;

    /**
     * Constructeur par défaut
     */
    public Adresse() {
    }

    /**
     * Constructeur avec paramètres
     * @param numero de la rue
     * @param rue nom de la rue
     * @param codePostal
     * @param ville
     */
    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
   /**
     *
     * @return le numéro de la rue
     */
    public int getNumero() {
        return numero;
    }

    /**
     * modifie le N° de la rue
     * @param numero nouveau N° de la rue
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return le nom de la rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * modifie le nom de la rue
     * @param rue nouveau nom de la rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     *
     * @return le code postal de l'adresse postale
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * modifie le code postal de l'adresse postale
     * @param codePostal nouveau code Postal
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    /**
     *
     * @return la ville de l'adresse postale
     */
    public String getVille() {
        return ville;
    }

    /**
     * modifie la ville de l'adresse postale
     * @param ville nouvelle ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     *
     * @return une description de l'adresse postale en concaténant les
     * différents champs: N°, rue, code postal, ville
     */
    @Override
    public String toString() {
        return "Habite à: " + numero +
                " " + rue + ", " + codePostal + " " + ville.toUpperCase() ;
    }
}
