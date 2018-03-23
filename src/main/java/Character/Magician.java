package Character;


public class Magician extends Character {
    @Override
    public String toString() {
        return "Magician{" +
                super.toString();
    }

    Magician(String nom, String image, int life, int strength) {
        super(nom, image, life, strength);
    }

    Magician(String nom) {
        super(nom);
    }

    Magician() {
    }
}