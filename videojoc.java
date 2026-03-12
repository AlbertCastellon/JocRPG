import java.util.ArrayList;
import java.util.Scanner;

public class videojoc {

    ArrayList<Personatge> personatges = new ArrayList<>();
    ArrayList<Arma> weapons = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        videojoc p = new videojoc();
        p.principal();
    }

    public void principal() {
        int option;
        String[] namePlayers = new String[2];
        Personatge[] pjs = new Personatge[2];
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gestionar Personatges");
            System.out.println("2. Gestionar armes");
            System.out.println("3. Jugar");
            System.out.println("0. Sortir");

            option = getInt();

            switch (option) {
                case 1:
                    pjManagement();
                    break;
                case 2:
                    weaponManagement();
                    break;
                case 3:
                    play(namePlayers, pjs);
                    break;
            }

        } while (option != 0);
    }

    public void createPJManual(String name, Race race, int age, double str, double dex, double con, double inte,
            double wis, double luck) {
        Personatge pj = new Personatge(name, race, age, str, dex, con, inte, wis, luck);
        personatges.add(pj);
    }

    public void createPJAutomatic(String name) {
        double[] arr = new double[6];
        double pointsLeft = 50;
        int raceNum = (int) (Math.random() * 4) + 1;
        int age = (int) (Math.random() * 60) + 18;
        for (int i = 0; i < arr.length; i++) {
            double increase = Math.random() * pointsLeft;
            arr[i] = 5 + increase;
            pointsLeft -= increase;
        }
        if (pointsLeft > 0) {
            arr[5] += pointsLeft;
            pointsLeft = 0;
        }
        Race race = Race.ORC;

        switch (raceNum) {
            case 1:
                race = Race.ORC;
                break;
            case 2:
                race = Race.ELF;
                break;
            case 3:
                race = Race.DWARF;
                break;
            case 4:
                race = Race.HUMAN;
                break;

            default:
                break;
        }
        Personatge pj = new Personatge(name, race, age, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
        personatges.add(pj);
        System.out.println("El nou personatge s'ha creat correctament");
        System.out.println(pj.toString());

    }

    public void assignWeapon(Personatge pj, int index) {
        if (index < 0) {
            System.out.println("Creació d'armes:");
            System.out.println("Com es dirà l'arma?");
            String name = sc.next();
            System.out.println("Quin tipus d'arma és?");
            System.out.println("1. Espasa");
            System.out.println("2. Destral");
            System.out.println("3. Maça");
            System.out.println("4. Arc");
            boolean valid = false;
            WeaponType wType = WeaponType.SWORD;
            do {
                int input = getInt();
                switch (input) {
                    case 1:
                        wType = WeaponType.SWORD;
                        valid = true;
                        break;
                    case 2:
                        wType = WeaponType.AXE;
                        valid = true;
                        break;
                    case 3:
                        wType = WeaponType.MACE;
                        valid = true;
                        break;
                    case 4:
                        wType = WeaponType.BOW;
                        valid = true;
                        break;

                    default:
                        System.out.println("Opció incorrecta");
                        ;
                        break;
                }
            } while (!valid);
            System.out.println("És màgica (s/n)");
            char answer = sc.next().charAt(0);
            boolean magic = false;
            if (answer == 's') {
                magic = true;
            }
            System.out.println("quin valor d'atac tindrà?");
            double power = sc.nextDouble();
            createNewWeapon(name, wType, magic, power);
            pj.addWeapon(weapons.get(weapons.size() - 1));
        } else {
            pj.addWeapon(weapons.get(index));
        }

    }

    public void createNewWeapon(String name, WeaponType type, boolean magic, double power) {
        Arma weapon = new Arma(name, type, magic, power);
        weapons.add(weapon);

    }

    public int getInt() {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                value = sc.nextInt();
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: introdueix un nombre enter vàlid.");
            }
        }
        return value;
    }

    public void listArrayList(boolean pj) {
        if (pj) {
            for (int i = 0; i < personatges.size(); i++) {
                System.out.println("Personatge " + (i + 1));
                System.out.println(personatges.get(i).toString());
            }
        } else {
            for (int i = 0; i < weapons.size(); i++) {
                System.out.println("Arma " + (i + 1));
                System.out.println(weapons.get(i).toString());
            }
        }

    }

    public void pjManagement() {
        int option;
        do {
            System.out.println("\n===== GESTIÓ DE PERSONATGES =====");
            System.out.println("1. Crear personatge manualment");
            System.out.println("2. Crear personatge automaticament");
            System.out.println("3. Llistar personatges");
            System.out.println("0. Sortir");

            option = getInt();
            String name;
            switch (option) {

                case 1:
                    System.out.println("Com vols que es digui el personatge?");
                    name = sc.next();
                    System.out.println("De quina raça és?");
                    boolean valid = false;
                    Race race = Race.ORC;
                    do {
                        System.out.println("1. Orc");
                        System.out.println("2. Elf");
                        System.out.println("3. Nan");
                        System.out.println("4. Humà");

                        int input = getInt();
                        switch (input) {
                            case 1:
                                race = Race.ORC;
                                valid = true;
                                break;
                            case 2:
                                race = Race.ELF;
                                valid = true;
                                break;
                            case 3:
                                race = Race.DWARF;
                                valid = true;
                                break;
                            case 4:
                                race = Race.HUMAN;
                                valid = true;
                                break;

                            default:
                                System.out.println("Opció incorrecta");
                                break;
                        }
                    } while (!valid);
                    System.out.println("Quina edat té?");
                    int age = getInt();
                    System.out.println("El valor màxim total d'atributs és 80");
                    System.out
                            .println("Cada atribut té com a mínim el valor 5 quants punts vols posar a cada atribut?");
                    double pointsLeft = 50;
                    double increase;
                    System.out.println("A força");
                    do {
                        increase = sc.nextDouble();
                        if (increase > pointsLeft) {
                            System.out.println("No tens suficients punts disponibles");
                        }
                    } while (increase > pointsLeft);

                    double str = increaseStats(increase);
                    pointsLeft = leftStatPoints(increase, pointsLeft);
                    System.out.println("A destresa");
                    do {
                        increase = sc.nextDouble();
                        if (increase > pointsLeft) {
                            System.out.println("No tens suficients punts disponibles");
                        }
                    } while (increase > pointsLeft);
                    double dex = increaseStats(increase);
                    pointsLeft = leftStatPoints(increase, pointsLeft);
                    System.out.println("A constitució");
                    do {
                        increase = sc.nextDouble();
                        if (increase > pointsLeft) {
                            System.out.println("No tens suficients punts disponibles");
                        }
                    } while (increase > pointsLeft);
                    double con = increaseStats(increase);
                    pointsLeft = leftStatPoints(increase, pointsLeft);
                    System.out.println("A inteligencia");
                    do {
                        increase = sc.nextDouble();
                        if (increase > pointsLeft) {
                            System.out.println("No tens suficients punts disponibles");
                        }
                    } while (increase > pointsLeft);
                    double inte = increaseStats(increase);
                    pointsLeft = leftStatPoints(increase, pointsLeft);
                    System.out.println("A sabiduria");
                    do {
                        increase = sc.nextDouble();
                        if (increase > pointsLeft) {
                            System.out.println("No tens suficients punts disponibles");
                        }
                    } while (increase > pointsLeft);
                    double wis = increaseStats(increase);
                    pointsLeft = leftStatPoints(increase, pointsLeft);
                    double luck = 5;
                    if (pointsLeft > 0) {
                        System.out.println("Els punts sobrants s'assignen a sort");
                        luck += pointsLeft;
                    }
                    System.out.println("Creant personatge...");
                    createPJManual(name, race, age, str, dex, con, inte, wis, luck);
                    System.out.println("S'ha creat el personatge correctament.");
                    System.out.println(personatges.get((personatges.size() - 1)).toString());
                    break;

                case 2:
                    System.out.println("Com vols que es digui el personatge?");
                    name = sc.next();
                    createPJAutomatic(name);
                    break;
                case 3:
                    listArrayList(true);
                    break;
            }

        } while (option != 0);

    }

    public double increaseStats(double increase) {
        return 5 + increase;
    }

    public double leftStatPoints(double increase, double points) {
        points -= increase;
        System.out.println("Tens " + points + " punts restants");
        return points;
    }

    public void weaponManagement() {
        int option;
        do {
            System.out.println("\n===== GESTIÓ DE PERSONATGES =====");
            System.out.println("1. Crear una nova arma");
            System.out.println("2. Crear i assignar una nova arma");
            System.out.println("3. Llistar armes");
            System.out.println("0. Sortir");

            option = getInt();
            String name;
            switch (option) {

                case 1:
                    System.out.println("Creació d'armes:");
                    System.out.println("Com es dirà l'arma?");
                    name = sc.next();
                    System.out.println("Quin tipus d'arma és?");
                    System.out.println("1. Espasa");
                    System.out.println("2. Destral");
                    System.out.println("3. Maça");
                    System.out.println("4. Arc");
                    boolean valid = false;
                    WeaponType wType = WeaponType.SWORD;
                    do {
                        int input = getInt();
                        switch (input) {
                            case 1:
                                wType = WeaponType.SWORD;
                                valid = true;
                                break;
                            case 2:
                                wType = WeaponType.AXE;
                                valid = true;
                                break;
                            case 3:
                                wType = WeaponType.MACE;
                                valid = true;
                                break;
                            case 4:
                                wType = WeaponType.BOW;
                                valid = true;
                                break;

                            default:
                                System.out.println("Opció incorrecta");
                                ;
                                break;
                        }
                    } while (!valid);
                    System.out.println("És màgica (s/n)");
                    char answer = sc.next().charAt(0);
                    boolean magic = false;
                    if (answer == 's') {
                        magic = true;
                    }
                    System.out.println("quin valor d'atac tindrà?");
                    double power = sc.nextDouble();
                    createNewWeapon(name, wType, magic, power);
                    break;
                case 2:
                    boolean correct = false;
                    int numWeapon = 0;
                    int numPj = 0;
                    System.out.println("A quin personatje li vols afegir l'arma, posa el número del personatge");
                    do {
                        numPj = getInt();
                        correct = true;
                        if (numPj <= 0 || numPj > personatges.size()) {
                            System.out.println("Personatge no vàlid");
                            correct = false;
                        }

                    } while (!correct);

                    System.out.println("Quina arma li vols assignar? Per crear una nova introdueix 0");
                    correct = false;
                    do {
                        numWeapon = getInt();
                        correct = true;
                        if (numWeapon < 0 || numWeapon > weapons.size()) {
                            System.out.println("Arma no vàlid");
                            correct = false;
                        }
                    } while (!correct);

                    assignWeapon(personatges.get(numPj - 1), (numWeapon - 1));
                    break;
                case 3:
                    listArrayList(false);
                    break;
            }

        } while (option != 0);
    }

    public void play(String[] players, Personatge[] pjs) {
        System.out.println("Introdueix el nom del primer jugador");
        players[0] = sc.next();
        System.out.println("Introdueix el nom del segon jugador");
        players[1] = sc.next();
        listArrayList(true);
        System.out.println("Introdueix el nombre del personatge que vols " + players[0]);
        pjs[0] = personatges.get((getInt() - 1));
        System.out.println("Introdueix el nombre del personatge que vols " + players[1]);
        pjs[1] = personatges.get((getInt() - 1));
        battle(players, pjs);
    }

    public void battle(String[] players, Personatge[] pjs) {
        System.out.println("Comença el combat!!!");
        do {
            turn(players, pjs);
            System.out.println("----- VIDA -----");
            System.out.println(pjs[0].getName() + ": " + pjs[0].getHp());
            System.out.println(pjs[1].getName() + ": " + pjs[1].getHp());
        } while (pjs[0].getHp() > 0 && pjs[1].getHp() > 0);
    }

    public void turn(String[] players, Personatge[] pjs) {
        boolean[] defend = new boolean[2];
        double[] damageCaused = new double[2];
        boolean[] dodge = new boolean[2];
        boolean[] crit = new boolean[2];
        actionChoice(players, pjs, defend, damageCaused, 0);
        actionChoice(players, pjs, defend, damageCaused, 1);
        int enemy;

        for (int i = 0; i < 2; i++) {

            if (i == 0) {
                enemy = 1;
            } else {
                enemy = 0;
            }

            if (!defend[enemy]) {
                pjs[enemy].setHp(pjs[enemy].getHp() - damageCaused[i]);
                System.out.println(players[i] + " fa " + damageCaused[i] + " de dany");
            } else {
                pjs[enemy].setHp(pjs[enemy].getHp() - (damageCaused[i]/2));
                System.out.println(players[enemy] + " s'ha defensat i ha rebut la meitat de dany");
            }

        }

    }

    public void actionChoice(String[] players, Personatge[] pjs, boolean[] defend, double[] damageCaused, int player) {
        boolean check = false;
        int action = 0;
        System.out.println(players[player] + "què vols fer?");
        do {
            System.out.println("1. Atacar");
            System.out.println("2. Defensar-te");
            action = getInt();
            if (action == 2 || action == 1) {
                check = true;
            } else {
                System.out.println("Opció invàlida");
            }
        } while (!check);
        switch (action) {
            case 1:
                damageCaused[player] = pjs[player].attack(pjs[player].getWeapon().isMagic());
                break;
            case 2:
                defend[player] = true;
                break;
            default:
                break;
        }
    }

}
