package Character;

import Character.Weapon.Weapon;

import java.util.List;
import java.util.ArrayList;

abstract public class Character implements Fighting {
    private String nom, image;
    private int life, strength;
    protected List<Weapon> weapons = new ArrayList<Weapon>();
    private Object secondary;

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void hit() {
        System.out.println("Je tape à " + getStrength());
    }

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

    public Object getSecondary() {
        return secondary;
    }

    public void setSecondary(Object secondary) {
        this.secondary = secondary;
    }

    @Override
    public String toString() {
        return "nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                ", life=" + life +
                ", strength=" + strength +
                ", weapons=" + weapons +
                ", secondary=" + secondary +
                '}';
    }

    public Character(String nom, String image, int life, int strength) {
        this.nom = nom;
        this.image = image;
        this.life = life;
        this.strength = strength;
    }

    public Character(String nom) {
        this.nom = nom;
    }

    public Character() {
    }
}
