package Character.Weapon;

abstract public class Weapon {
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "nom='" + nom + '\'' +
                '}';
    }

    Weapon(String nom) {
        this.nom = nom;
    }

    Weapon() {
    }
}
