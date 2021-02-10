import java.util.ArrayList; // import the ArrayList class

public class Cinema {
    private Salle[] sallesArr;

    public Cinema(int nbSalles) {
        this.sallesArr = new Salle[nbSalles];
        for (int i = 0; i < nbSalles; i++) {
            sallesArr[i] = new Salle(i);
        }
    }

    public double ventesGlobales() {
        double res = 0;
        for (Salle salle : this.sallesArr) {
            res += salle.chiffreAffaireVentes();
        }
        return res;
    }

    private int getSalleIndexViaNumero(int numeroSalle) {
        int index = -1;
        for (int i = 0; i < this.sallesArr.length; i++) {
            if (this.sallesArr[i].getNumeroSalle() == numeroSalle) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("La salle n'existe pas !");
        }
        return index;
    }

    public void changerFilmSalle(int numeroSalle, String nouveauTitre, double nouveauPrix) {
        int indexSalle = getSalleIndexViaNumero(numeroSalle);
        this.sallesArr[indexSalle].renommerFilm(nouveauTitre);
        this.sallesArr[indexSalle].changerTarif(nouveauPrix);
    }

    public void remizeZeroGlobale() {
        for (Salle salle : this.sallesArr) {
            salle.remiseAZero();
        }
    }

    public ArrayList titreFilmDispoPourGroupe(int tailleGroupe) {
        ArrayList<String> res = new ArrayList<String>();
        for (Salle salle : this.sallesArr) {
            if (salle.nbPlaceLibres() >= tailleGroupe) {
                res.add(salle.getTitreFilm());
            }
        }
        return res;
    }

    public String toString() {
        String res = "Nombre de salles : " + sallesArr.length;
        for (Salle salle : this.sallesArr) {
            res += "\n";
            res += salle;
        }
        return res;
    }
}
