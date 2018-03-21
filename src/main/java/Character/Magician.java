package Character;


public class Magician extends Character {
    @Override
    public String toString() {
        return "Magician{" +
                super.toString();
    }

    public Magician(String nom, String image, int life, int strength) {
        super(nom, image, life, strength);
    }

    public Magician(String nom) {
        super(nom);
    }

    public Magician() {
    }
}