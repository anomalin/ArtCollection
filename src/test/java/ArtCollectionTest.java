import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Art;
import se.yrgo.domain.Artist;


public class ArtCollectionTest {
    private static SessionFactory sessionfactory = null;


    private static SessionFactory getSessionFactory() {
        if(sessionfactory == null) {
            Configuration config = new Configuration();
            config.configure();
            sessionfactory = config.buildSessionFactory();
        }
        return sessionfactory;
    }

    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();

        Artist samuel = new Artist("A101", "Samuel Petersson");
        Artist janolof = new Artist("A102", "Janolof Bengtsson");
        Art beach = new Art("At the beach", "Photography");
        Art car = new Art("Parked car", "Photography");
        Art garage = new Art("Parking garage", "Photography");
        Art woods = new Art("In the woods", "Oil on canvas");
        Art sculpture = new Art("Old Hollywood", "Sculpture");
        samuel.addArtWorkToList(beach);
        samuel.addArtWorkToList(car);
        samuel.addArtWorkToList(garage);
        janolof.addArtWorkToList(woods);
        janolof.addArtWorkToList(sculpture);
        session.save(samuel);
        session.save(janolof);
        session.save(beach);
        session.save(car);
        session.save(garage);
        session.save(woods);
        session.save(sculpture);

         //Code for getting a specific instance from the db.
        Artist photographer = session.get(Artist.class,1);
        System.out.println("Artist: " + photographer.getName());
        for (Art art : photographer.getPiecesOfArt()) {
            System.out.println(art.toString());
        }

        tran.commit();
        session.close();
    }
}
