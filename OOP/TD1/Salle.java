/**
 * Salle
 */
public class Salle {

    private int numeroSalle;
    private int capaciteSalle;
    private String titreFilm;
    private Boolean is3D;
    private int nbPlaceTarifNormal = 0;
    private int nbPlaceTarifReduit = 0;
    private double tarifPlaceNormal;

    public Salle(int numeroSalle, Boolean is3D, int capaciteSalle, double tarifPlaceNormal) {
        this.numeroSalle = numeroSalle;
        this.is3D = is3D;
        this.capaciteSalle = capaciteSalle;
        this.tarifPlaceNormal = tarifPlaceNormal;
    }

    public Salle(int numeroSalle) {
        this.is3D = false;
        this.numeroSalle = numeroSalle;
        this.capaciteSalle = 100;
        this.tarifPlaceNormal = 7;
    }

    public void remiseAZero() {
        this.nbPlaceTarifNormal = 0;
        this.nbPlaceTarifReduit = 0;
    }

    public void renommerFilm(String nouveauTitre) {
        this.titreFilm = nouveauTitre;
    }

    public String getFilm() {
        return this.titreFilm;
    }

    public double getTarifPrixNormal() {
        return this.tarifPlaceNormal;
    }

    public double getTarifPrixReduit() {
        // Le prix réduit correspond à 60% du prix normal
        return this.tarifPlaceNormal * 0.6;
    }

    public int nbPlaceVendues() {
        return this.nbPlaceTarifNormal + this.nbPlaceTarifReduit;
    }

    public int nbPlaceLibres() {
        return this.capaciteSalle - nbPlaceVendues();
    }

    public Boolean isComplet() {
        return nbPlaceLibres() <= 0;
    }

    public double chiffreAffaireVentes() {
        return this.tarifPlaceNormal * this.nbPlaceTarifNormal + this.getTarifPrixReduit() * this.nbPlaceTarifReduit;
    }

    public double vendrePlace(int nbPlace, Boolean isTarifReduit) {
        double res = 0;
        if (isTarifReduit) {
            this.nbPlaceTarifReduit += nbPlace;
            res = getTarifPrixReduit() * nbPlace;
        } else {
            this.nbPlaceTarifNormal += nbPlace;
            res = getTarifPrixNormal() * nbPlace;
        }
        return res;

    }

    public String toString() {
        String res = "Salle n " + this.numeroSalle + " : " + this.titreFilm;
        if (is3D) {
            res += " en 3D.";
        } else {
            res += ".";
        }
        if (isComplet()) {
            res += " Complet.";
        } else {
            res += " Plus que " + this.nbPlaceLibres() + " places libres.";
        }
        return res;
    }
}