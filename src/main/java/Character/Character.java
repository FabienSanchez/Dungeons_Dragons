package Character;

abstract public class Character {
    private String nom, image;
    private int life, strength;
    private Object weapon, secondary;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Object getWeapon() {
        return weapon;
    }

    public void setWeapon(Object weapon) {
        this.weapon = weapon;
    }

    public Object getSecondary() {
        return secondary;
    }

    public void setSecondary(Object secondary) {
        this.secondary = secondary;
    }

    @Override
    public String toString() {
        return "Character{" +
                "nom='" + getNom() + '\'' +
                ", image='" + getImage() + '\'' +
                ", life=" + getLife() +
                ", strength=" + getStrength() +
                ", weapon=" + getWeapon() +
                ", secondary=" + getSecondary() +
                '}';
    }
}
