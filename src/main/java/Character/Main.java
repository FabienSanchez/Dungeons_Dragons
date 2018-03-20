package Character;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String str;
    static int i;

    public static void main(String[] agrs) {
        boolean quit = false;
        Character character = null;

        do {
            System.out.println("" +
                    "Menu :" +
                    "\n\t1 - Créer un personnage" +
                    "\n\t2 - Afficher le personnage" +
                    "\n\t3 - Editer le personnage" +
                    "\n\t7 - Quitter" +
                    "");

            i = sc.nextInt();
            switch (i) {
                case 1:
                    character = createCharacter();
                    break;
                case 2:
                    System.out.println(character != null ? character.toString() : null);
                    break;
                case 3:
                    editCharacter(character);
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

    public static Character createCharacter() {
        boolean quit = false;
        Character character = null;

        do {
            System.out.println("Creation de personnage :" +
                    "\n\t1 - Guerrier" +
                    "\n\t2 - Magicien" +
                    "\n\t3 - Retour");
            i = sc.nextInt();
            switch (i) {
                case 1:
                    character = new Warrior();
                    break;
                case 2:
                    character = new Magician();
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Choix inconnu");
                    break;
            }
        } while (!quit);

        return character;
    }

    public static void editCharacter(Character character) {
        boolean quit = false;

        do {
            System.out.println(
                    "Modifier : " +
                            "\n\t1 - Nom" +
                            "\n\t2 - Image" +
                            "\n\t3 - Vie" +
                            "\n\t4 - Force" +
                            "\n\t5 - Arme(s)" +
                            "\n\t6 - Utilitaire" +
                            "\n\t7 - Retour");

            i = sc.nextInt();
            sc.nextLine();
            switch (i) {
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
                    i = sc.nextInt();
                    character.setLife(i);
                    System.out.println(character.getLife());
                    break;
                case 4:
                    System.out.println("Nouvelle force :");
                    i = sc.nextInt();
                    character.setStrength(i);
                    System.out.println(character.getStrength());
                    break;
                case 5:
                    System.out.println("Arme(s) :");
                    System.out.println(character.getWeapon());
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
