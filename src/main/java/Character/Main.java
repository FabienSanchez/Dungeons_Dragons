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
    private static List<Character> characters = new ArrayList<Character>();
    private static List<Weapon> weapons = new ArrayList<Weapon>();

    public static void main(String[] agrs) {
        boolean quit = false;

        do {
            System.out.println(
                    "Menu :" +
                            "\n\t1 - Créer un personnage" +
                            "\n\t2 - Afficher les personnages" +
                            "\n\t3 - Editer un personnage" +
                            "\n\t5 - Arène" +
                            "\n\n\t7 - Quitter");

            switch (intChoice()) {
                case 1:
                    createCharacter();
                    break;
                case 2:
                    listCharacters();
                    break;
                case 3:
                    editCharacter();
                    break;
                case 4:
                    break;
                case 5:
                    arena(selectCharacter());
                    break;
                case 7:
                    quit = true;
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Choix inconnu");
                    break;
            }
        } while (!quit);
    }

    private static int intChoice() {
        boolean quit = false;
        int result = 0;
        do {
            try {
                result = sc.nextInt();
                quit = true;
            } catch (InputMismatchException e) {
                System.out.println("Veuillez saisir un chiffre");
                sc.nextLine();
            }
        } while (!quit);
        return result;
    }

    // Personnage

    private static void createCharacter() {
        boolean quit = false;
        do {
            String name, image;
            int life, strength;
            Character character;

            switch (chooseType()) {
                case 1: //Guerrier
                    switch (chooseConstructor()) {
                        case 1: //tout
                            sc.nextLine();
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
                            sc.nextLine();
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
                            quit = true;
                            break;
                    }
                    break;
                case 2: //Magicien
                    switch (chooseConstructor()) {
                        case 1: //tout
                            sc.nextLine();
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
                            sc.nextLine();
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
                            quit = true;
                            break;
                    }
                    break;
                case 3: //retour
                    quit = true;
                    break;
            }
        } while (!quit);
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
                    System.out.println("Choix inconnu");
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
                    System.out.println("Choix inconnu");
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
                i = intChoice();
                try {
                    character = characters.get(i);
                    quit = true;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Le personnage n'existe pas");
                }
            } else {
                System.out.println("Il n'y as pas de personnage");
                createCharacter();
                quit = true;
            }
        } while (!quit);

        return character;
    }

    private static void editCharacter() {
        boolean quit = false;
        Character character = selectCharacter();

        if (!(character == null)) {
            do {
                System.out.println(
                        "Modifier : " +
                                "\n\t1 - Nom : " + character.getNom() +
                                "\n\t2 - Image : " + character.getImage() +
                                "\n\t3 - Vie : " + character.getLife() +
                                "\n\t4 - Force : " + character.getStrength() +
                                "\n\t5 - Arme(s) : " + character.getWeapons() +
                                "\n\t6 - Utilitaire : " + character.getSecondary() +
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
                    case 5:
                        editWeapon(character);
                        break;
                    case 6:
                        System.out.println("utilitaire :");
                        System.out.println(character.getSecondary());
                        break;
                    case 7:
                        quit = true;
                        break;
                    default:
                        System.out.println("Choix inconnu");
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

    private static void createWeapon() {
        do {
            System.out.println(
                    "Creation d'une arme :" +
                            "\n\t1 - Epée" +
                            "\n\t2 - Sort" +
                            "\n\t3 - Retour");
            switch (intChoice()) {
                case 1:
                    Sword sword = new Sword();
                    weapons.add(sword);
                    break;
                case 2:
                    Spell spell = new Spell();
                    weapons.add(spell);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Choix inconnu");
                    break;
            }
        } while (true);
    }

    private static Weapon selectWeapon() {
        Weapon weapon = null;
        do {
            if (weapons.size() > 0) {
                System.out.println("Selectionner une arme :");
                listWeapons();
                i = intChoice();
                try {
                    weapon = weapons.get(i);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("L'arme n'existe pas");
                }
            } else {
                System.out.println("Il n'y as pas d'armes");
                createWeapon();
            }
        } while (weapon == null);
        return weapon;
    }

    private static void editWeapon(Character character) {
        boolean quit = false;

        do {
            System.out.println(
                    "Menu :" +
                            "\n\t1 - Ajouter une arme" +
                            "\n\t2 - Enlever une arme" +
                            "\n\n\t7 - Quitter");

            switch (intChoice()) {
                case 1:
                    character.addWeapon(selectWeapon());
                    break;
                case 2:
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Choix inconnu");
                    break;
            }
        } while (!quit);
    }

    private static void listWeapons() {
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println("\t" + i + " - " + weapons.get(i).toString());
        }
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
                    character.hit();
                    break;
                case 2:
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Choix inconnu");
                    break;
            }
        } while (!quit);
    }

}
