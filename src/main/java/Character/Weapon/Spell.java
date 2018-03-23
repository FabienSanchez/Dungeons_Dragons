package Character.Weapon;

public class Spell extends Weapon {
    public Spell(String nom) {
        super(nom);
    }

    public Spell() {
    }

    @Override
    public String toString() {

        return "Spell{" +
                super.toString();
    }
}
