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

    do {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Crear personatge manual");
        System.out.println("2. Crear personatge automàtic");
        System.out.println("3. Llistar personatges");
        System.out.println("4. Crear arma");
        System.out.println("5. Assignar arma");
        System.out.println("0. Sortir");

        option = getInt();

        switch (option) {
            case 1:
                // crear personaje
                break;
            case 2:
                // auto personaje
                break;
            case 3:
                listCharacters();
                break;
            case 4:
                // crear arma
                break;
            case 5:
                // asignar arma
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
        if(pointsLeft > 0){
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
            boolean valid = true;
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
                        System.out.println("Opció incorrecta");;
                        break;
                }
            } while (!valid);
            System.out.println("És màgica (s/n)");
            char answer = sc.next().charAt(0);
            boolean magic = false;
            if(answer == 's'){
                magic = true;
            }
            System.out.println("quin valor d'atac tindrà?");
            double power = sc.nextDouble();
            createNewWeapon(name, wType, magic, power);
            pj.addWeapon(weapons.get(weapons.size()-1));
        }
        else {
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

    public void listCharacters() {
        for(int i = 0; i < personatges.size(); i++) {
            System.out.println("Personatge " + (i+1));
            System.out.println(personatges.get(i).toString());
        }
    }

}
