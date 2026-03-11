enum WeaponType {
    SWORD, AXE, MACE, BOW
}

public class Arma {
    private String name;
    private WeaponType type;
    private boolean magic;
    private double power;

    public Arma(String name, WeaponType type, boolean magic, double power) {
        this.name = name;
        this.type = type;
        this.magic = magic;
        this.power = power;
    }

    public Arma() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public boolean isMagic() {
        return magic;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "----- ARMA -----\n" +
                "Nom: " + name + "\n" +
                "Tipus: " + type + "\n" +
                "Màgica: " + magic + "\n" +
                "Power: " + power + "\n";
    }

}
