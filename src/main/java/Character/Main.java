package Character;

import Character.Weapon.Spell;
import Character.Weapon.Sword;
import Character.Weapon.Weapon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static String str;
    private static int i;
    private static char chr;
    private static List<Character> characters = new ArrayList<Character>();
    private static List<Weapon> weapons = new ArrayList<Weapon>();

    public static void main(String[] agrs) {
        boolean quit = false;

        do {
            System.out.println(
                    "Menu :" +
                            "\n\t1 - Créer des personnages" +
                            "\n\t2 - Créer des armes" +
                            "\n\t3 - Afficher les personnages" +
                            "\n\t4 - Menu personnage" +
                            "\n\t5 - Arène" +
                            "\n\n\t7 - Quitter");

            switch (intChoice()) {
                case 1:
                    loopCreateChar();
                    break;
                case 2:
                    loopCreateWeap();
                    break;
                case 3:
                    listCharacters();
                    break;
                case 4:
                    menuCharacter();
                    break;
                case 5:
                    arena(selectCharacter());
                    break;
                case 7:
                    quit = true;
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (!quit);
    }

    // Utilitaire

    private static int intChoice() {
        int result = -1;
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
        }
        sc.nextLine();
        return result;
    }

    // Personnage

    private static void menuCharacter() {
        boolean quit = false;
        Character character = selectCharacter();

        if (character != null) {
            do {
                System.out.println(
                        "Menu :" +
                                "\n\t1 - Afficher les stats" +
                                "\n\t2 - Editer les stats" +
                                "\n\t3 - Menu armes" +
                                "\n\t4 - Attaquer" +
                                "\n\t5 - Supprimer le personnage" +
                                "\n\n\t7 - Retour");

                switch (intChoice()) {
                    case 1:
                        System.out.println(character.toString());
                        break;
                    case 2:
                        editCharacter(character);
                        break;
                    case 3:
                        editWeapon(character);
                        break;
                    case 4:
                        System.out.println("Niveau d'attaque :");
                        character.hit(intChoice());
                        break;
                    case 5:
                        boolean sure = false;
                        do {
                            System.out.println(
                                    "Êtes vous sur de vouloir supprimer ce personnage ? O/N");
                            switch (sc.nextLine().charAt(0)) {
                                case 'O':
                                    characters.remove(character);
                                    character = null;
                                    sure = true;
                                    quit = true;
                                    break;
                                case 'N':
                                    sure = true;
                                    break;
                                default:
                                    System.out.println("Choix invalide");
                                    break;
                            }
                        } while (!sure);
                        break;
                    case 7:
                        quit = true;
                        break;
                    default:
                        System.out.println("Choix invalide");
                        break;
                }
            } while (!quit);
        }
    }

    private static void loopCreateChar() {
        do {
        } while (createCharacter());
    }

    private static boolean createCharacter() {
        String name, image;
        int life, strength;
        Character character;

        switch (chooseType()) {
            case 1: //Guerrier
                switch (chooseConstructor()) {
                    case 1: //tout
                        System.out.println("Nom :");
                        name = sc.nextLine();
                        System.out.println("Image :");
                        image = sc.nextLine();
                        System.out.println("Vie :");
                        life = sc.nextInt();
                        System.out.println("Force :");
                        strength = sc.nextInt();
                        character = new Warrior(name, image, life, strength);
                        characters.add(character);
                        break;
                    case 2: //nom
                        System.out.println("Nom :");
                        name = sc.nextLine();
                        character = new Warrior(name);
                        characters.add(character);
                        break;
                    case 3: //vide
                        character = new Warrior();
                        characters.add(character);
                        break;
                    case 4: // retour
                        return false;
                }
                break;
            case 2: //Magicien
                switch (chooseConstructor()) {
                    case 1: //tout
                        System.out.println("Nom :");
                        name = sc.nextLine();
                        System.out.println("Image :");
                        image = sc.nextLine();
                        System.out.println("Vie :");
                        life = sc.nextInt();
                        System.out.println("Force :");
                        strength = sc.nextInt();
                        character = new Magician(name, image, life, strength);
                        characters.add(character);
                        break;
                    case 2: //nom
                        System.out.println("Nom :");
                        name = sc.nextLine();
                        character = new Magician(name);
                        characters.add(character);
                        break;
                    case 3: //vide
                        character = new Magician();
                        characters.add(character);
                        break;
                    case 4: // retour
                        return false;
                }
                break;
            case 3: //retour
                return false;

        }
        return true;
    }

    private static int chooseType() {
        do {
            System.out.println(
                    "Creation de personnage :" +
                            "\n\t1 - Guerrier" +
                            "\n\t2 - Magicien" +
                            "\n\t3 - Retour");

            switch (intChoice()) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (true);
    }

    private static int chooseConstructor() {
        do {
            System.out.println("Personnalisation :" +
                    "\n\t1 - Tout" +
                    "\n\t2 - Nom" +
                    "\n\t3 - Vide" +
                    "\n\t4 - Annuler");

            switch (intChoice()) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (true);
    }

    private static Character selectCharacter() {
        Character character = null;
        boolean quit = false;
        do {
            if (characters.size() > 0) {
                System.out.println("Selectioner un personnage :");
                listCharacters();
                System.out.println("\t" + characters.size() + " - Retour");
                str = sc.nextLine();
                if (str.equals(Integer.toString(characters.size()))) {
                    quit = true;
                } else {
                    try {
                        i = Integer.parseInt(str);
                        try {
                            character = characters.get(i);
                            quit = true;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Le personnage n'existe pas");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez saisir un chiffre");
                    }
                }
            } else {
                System.out.println("Il n'y as pas de personnage");
                if (createCharacter()) {
                    character = characters.get(0);
                }
                quit = true;
            }
        } while (!quit);
        return character;
    }

    private static void editCharacter(Character character) {
        boolean quit = false;

        if (!(character == null)) {
            do {
                System.out.println(
                        "Modifier : " +
                                "\n\t1 - Nom : " + character.getNom() +
                                "\n\t2 - Image : " + character.getImage() +
                                "\n\t3 - Vie : " + character.getLife() +
                                "\n\t4 - Force : " + character.getStrength() +
                                "\n\t7 - Retour");

                switch (intChoice()) {
                    case 1:
                        System.out.println("Nouveau nom :");
                        str = sc.nextLine();
                        character.setNom(str);
                        System.out.println(character.getNom());
                        break;
                    case 2:
                        System.out.println("Nouvelle image :");
                        str = sc.nextLine();
                        character.setImage(str);
                        System.out.println(character.getImage());
                        break;
                    case 3:
                        System.out.println("Nouvelle vie :");
                        i = intChoice();
                        character.setLife(i);
                        System.out.println(character.getLife());
                        break;
                    case 4:
                        System.out.println("Nouvelle force :");
                        i = intChoice();
                        character.setStrength(i);
                        System.out.println(character.getStrength());
                        break;
                    case 7:
                        quit = true;
                        break;
                    default:
                        System.out.println("Choix invalide");
                        break;
                }
            } while (!quit);
        }
    }

    private static void listCharacters() {
        for (int i = 0; i < characters.size(); i++) {
            System.out.println("\t" + i + " - " + characters.get(i).toString());
        }
    }

    // Armes

    private static void loopCreateWeap() {
        do {
        } while (createWeapon());
    }

    private static boolean createWeapon() {
        boolean quit = false;
        do {
            System.out.println(
                    "Creation d'une arme :" +
                            "\n\t1 - Epée" +
                            "\n\t2 - Sort" +
                            "\n\t3 - Retour");
            switch (intChoice()) {
                case 1:
                    System.out.println("Choisissez un nom : ");
                    Sword sword = new Sword(sc.nextLine());
                    weapons.add(sword);
                    return true;
                case 2:
                    System.out.println("Choisissez un nom : ");
                    Spell spell = new Spell(sc.nextLine());
                    weapons.add(spell);
                    return true;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (!quit);
        return false;
    }

    private static List<Weapon> sortWeapon(Class clazz) {
        List<Weapon> sortedList = new ArrayList<Weapon>();
        for (Weapon weapon : weapons) {
            if (clazz.isInstance(weapon)) {
                sortedList.add(weapon);
            }
        }
        return sortedList;
    }

    private static void listWeapons(List weapons) {
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println("\t" + i + " - " + weapons.get(i).toString());
        }
    }

    private static Weapon selectWeapon(Class clazz) {
        Weapon weapon = null;
        boolean quit = false;
        do {
            List<Weapon> weapons = sortWeapon(clazz);
            if (weapons.size() > 0) {
                System.out.println("Selectionner une arme :");
                listWeapons(weapons);
                System.out.println("\t" + weapons.size() + " - Retour");
                str = sc.nextLine();
                if (str.equals(Integer.toString(weapons.size()))) {
                    quit = true;
                } else {
                    try {
                        i = Integer.parseInt(str);
                        try {
                            weapon = weapons.get(i);
                            quit = true;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("L'arme n'existe pas");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez saisir un chiffre");
                    }
                }
            } else {
                System.out.println("Il n'y as pas d'armes");
                if (!createWeapon()) {
                    quit = true;
                }
            }
        } while (!quit);
        return weapon;
    }

    private static void removeWeapon(Character character) {
        boolean quit = false;
        do {
            List<Weapon> weapons = character.getWeapons();
            if (weapons.size() > 0) {
                System.out.println("Selectionner une arme à enlever :");
                listWeapons(weapons);
                System.out.println("\t" + weapons.size() + " - Retour");
                str = sc.nextLine();
                if (str.equals(Integer.toString(weapons.size()))) {
                    quit = true;
                } else {
                    try {
                        i = Integer.parseInt(str);
                        try {
                            weapons.remove(i);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("L'arme n'existe pas");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez saisir un chiffre");
                    }
                }
            } else {
                System.out.println("Il n'y as pas d'armes à enlever");
                quit = true;
            }
        } while (!quit);
    }

    private static void editWeapon(Character character) {
        boolean quit = false;

        Class clazz = Weapon.class;
        if (character instanceof Warrior) {
            clazz = Sword.class;
        } else if (character instanceof Magician) {
            clazz = Spell.class;
        }

        do {
            System.out.println(
                    "Menu :" +
                            "\n\t1 - Créer des armes" +
                            "\n\t2 - Ajouter une arme" +
                            "\n\t3 - Enlever une arme" +
                            "\n\n\t7 - Quitter");

            switch (intChoice()) {
                case 1:
                    loopCreateWeap();
                    break;
                case 2:
                    Weapon weapon = selectWeapon(clazz);
                    if (weapon != null) {
                        if (!character.getWeapons().contains(weapon)) {
                            character.addWeapon(weapon);
                        } else {
                            System.out.println(character.getNom() + " possède déjà " + weapon.getNom());
                        }
                    }
                    break;
                case 3:
                    removeWeapon(character);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (!quit);
    }

    // Combat

    private static void arena(Character character) {
        boolean quit = false;

        do {
            System.out.println(
                    "Arène :" +
                            "\n\t1 - Taper" +
                            "\n\t2 - ..." +
                            "\n\t3 - Retour");

            switch (intChoice()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (!quit);
    }

}
