
/**
 * TD1
 */
public class TD1 {

    public static void main(String[] args) {
        Salle Descartes = new Salle(1, true, 30, 5);
        Descartes.renommerFilm("Le prince de Bel Air");
        System.out.println(Descartes);
        System.out.println(Descartes.vendrePlace(4, false));
        System.out.println(Descartes);
        System.out.println(Descartes.chiffreAffaireVentes());

        Cinema UGC = new Cinema(5);
        System.out.println(UGC);
    }
}