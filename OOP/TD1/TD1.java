
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

        Cinema UGC = new Cinema(3);
        UGC.changerFilmSalle(0, "Trop cool.com", 4.2);
        UGC.changerFilmSalle(1, "github.com/alexandrelam", 8.8);
        UGC.changerFilmSalle(2, "je suis un lion pas un mouton je suis comme baba", 11);
        System.out.println(UGC);
        System.out.println(UGC.titreFilmDispoPourGroupe(4));
    }
}