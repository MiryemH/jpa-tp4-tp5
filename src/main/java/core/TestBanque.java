package core;

import core.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

/**
 * Tester la création des tables
 * @author Miryem HRARTI
 */
public class TestBanque {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maConfig");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        System.out.println("--------------------------------- Création deux Clients  avec 1 compte ---------------");
        Adresse adresse = new Adresse(127,"Rue des Pivoines",14123,"IFS");
        Banque banque = new Banque();
        banque.setNom("BNP PARIBAS");
        manager.persist(banque);
        Client madame = new Client("JORT-MARCEL", "Léna", LocalDate.of(1988,9,19));
        Client monsieur = new Client("MARCEL", "Alfred", LocalDate.of(1978,8,4));
        madame.setAdresse(adresse);
        monsieur.setAdresse(adresse);
        madame.setBanque(banque);
        monsieur.setBanque(banque);
        manager.persist(madame);
        manager.persist(monsieur);
        //ajouter le client à la liste des clients de la banque
        banque.setClients(Set.of(madame, monsieur));
        //Créer un compte
        Compte compteCommun = new LivretA("MJ887898-LIVA",30000,0.3);
        manager.persist(compteCommun);
        //madame.setMesComptes(Set.of(compteCommun));
        //monsieur.setMesComptes(Set.of(compteCommun));
        compteCommun.setClients(Set.of(madame,monsieur));

        System.out.println(compteCommun);
        Set<Client> clientsCompteCommun = compteCommun.getClients();
        if(clientsCompteCommun != null){
            clientsCompteCommun.stream().forEach(client -> System.out.println(client));
        }
        else
            System.out.println("Aucun client n'est attaché à ce compte commun");


        System.out.println("--------------------------------- Création d'un client avec deux comptes ---------------");
        //Créer une adresse
        adresse = new Adresse(3,"Impasse des Alpes",92123,"Noisy Le Grand");
        //Créer un Client
        Client client = new Client("DUPONT", "Xavier", LocalDate.of(1966,06,19));
        client.setAdresse(adresse);
        banque = new Banque();
        banque.setNom("Caisse D'Epargne");
        manager.persist(banque);
        client.setBanque(banque);
        manager.persist(client);
        //ajouter le client à la liste des clients de la banque
        banque.setClients(Set.of(client));

        Compte livretA = new LivretA("DX660619-LIVA",15000,0.3);
        Compte assuranceVie = new AssuranceVie("DX660619-ASSVIE", 25000,0.15,LocalDate.of(2023,12,31));
        manager.persist(livretA);
        manager.persist(assuranceVie);
        client.setMesComptes(Set.of(livretA, assuranceVie));

        //REMARQUE: Par rapport au virement, nous avons discuté et j'ai donné l'exemple de ma banque ou je ne pourrais pas
        // faire des retraits sur mon compte LivretA ou assurance de Vie en faisant un virement.
        // En fait lorsque je fais un virement ca sera forcément pour ajouter un montant et non pas faire un retrait
        // Nous avons discuté de ca et tu m'as dit de le laisser comme ca
        // vu que Moulay a posé la question si c'est le virement est un retrait

        //Créer deux virements sur le compte Epargne
        Operation vir1 = new Virement(LocalDate.of(2021,01,05), 500, "Epargne Mensuelle",livretA, "Salmane DRAFATE");
        manager.persist(vir1);
        Virement vir2 = new Virement(LocalDate.of(2021,02,05), 300, "Epargne Mensuelle",livretA, "Salmane DRAFATE");
        manager.persist(vir2);
        livretA.setOperations(Set.of(vir1,vir2));
        //mettre à jour le solde du compte
        Set<Operation> mesOperations = livretA.getOperations();
        if(mesOperations != null){
            for(Operation op : mesOperations)
                livretA.setSolde(livretA.getSolde() + op.getMontant());
        }
        else
                System.out.println("Aucune opération effectuée sur ce compte");



            //Créer trois operations  sur le compte Assurance Vie
        Operation op1 = new Operation(LocalDate.of(2019,01,05), 2400, "Pour Salmane & Yasser",assuranceVie);
        manager.persist(op1);
        Operation op2 = new Operation(LocalDate.of(2020,01,05), 2400, "Pour Salmane & Yasser",assuranceVie);
        manager.persist(op2);
        Operation op3 = new Operation(LocalDate.of(2021,01,05), 2400, "Pour Salmane & Yasser",assuranceVie);
        manager.persist(op3);
        assuranceVie.setOperations(Set.of(op1,op2,op3));
        mesOperations = assuranceVie.getOperations();
        //mettre à jour le solde
        if(mesOperations != null){
            for(Operation opp : mesOperations)
                assuranceVie.setSolde(assuranceVie.getSolde() + opp.getMontant());
        }
        else
            System.out.println("Aucune opération effectuée sur ce compte");



            //Afficher les infos de clients
        System.out.println(client);
        Set<Compte> mesComptes = client.getMesComptes();
        System.out.println("-------------------Comptes de "+ client.getPrenom() + " " + client.getNom() + "----------------------------------------");
        if (mesComptes != null) {
            for(Compte compte: mesComptes){
                System.out.println(compte);
                Set<Operation> operations = compte.getOperations();
                if(operations != null)
                    operations.stream().forEach(operation -> System.out.println(operation));
            }
        }
        else
            System.out.println("Aucun compte n'est associé au client N°: " + client.getId());

        transaction.commit();
        manager.close();

    }
}
