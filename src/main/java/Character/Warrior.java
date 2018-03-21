package Character;

public class Warrior extends Character {
    @Override
    public String toString() {
        return "Warrior{" +
                super.toString();
    }

    public Warrior(String nom, String image, int life, int strength) {
        super(nom, image, life, strength);
    }

    public Warrior(String nom) {
        super(nom);
    }

    public Warrior() {
    }
}