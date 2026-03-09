import java.util.ArrayList;

enum Race {
  ORC, ELF, DWARF, HUMAN
}

public class Personatge {
  private String name;
  private Race race;
  private int age;
  private double hp;
  private double mp;
  private double str;
  private double dex;
  private double con;
  private double inte;
  private double wis;
  private double luck;
  private ArrayList<Arma> weapons;
  private Arma equipedWeapon;

  public Personatge() {

  }
  public Personatge(String name, Race race, int age, double str, double dex, double con, double inte, double wis, double luck) {
    this.name = name;
    this.race = race;
    this.age = age;
    this.hp = con*50;
    this.mp = inte*30;
    this.str = str;
    this.dex = dex;
    this.con = con;
    this.inte = inte;
    this.wis = wis;
    this.luck = luck;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Race getRace() {
    return race;
  }

  public void setRace(Race race) {
    this.race = race;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getHp() {
    return hp;
  }

  public void setHp(double hp) {
    this.hp = hp;
  }

  public double getMp() {
    return mp;
  }

  public void setMp(double mp) {
    this.mp = mp;
  }

  public double getStr() {
    return str;
  }

  public void setStr(double str) {
    this.str = str;
  }

  public double getDex() {
    return dex;
  }

  public void setDex(double dex) {
    this.dex = dex;
  }

  public double getCon() {
    return con;
  }

  public void setCon(double con) {
    this.con = con;
  }

  public double getInte() {
    return inte;
  }

  public void setInte(double inte) {
    this.inte = inte;
  }

  public double getWis() {
    return wis;
  }

  public void setWis(double wis) {
    this.wis = wis;
  }

  public double getLuck() {
    return luck;
  }

  public void setLuck(double luck) {
    this.luck = luck;
  }

  public void equipWeapon(int index) {
    this.equipedWeapon = weapons.get(index);
  }

  public void addWeapon(Arma weapon) {
    this.weapons.add(weapon);
  }

  public double attack(boolean magic) {
    double damage = 0;
    if(this.equipedWeapon.isMagic()){
      damage = ((this.equipedWeapon.getPower() * this.inte)/100);
    }else {
      damage = this.str * ((1+this.equipedWeapon.getPower())/100);
    }
    return damage;
  }

  public void regenerateHp() {
    this.hp += this.con*3;
    if(this.hp > this.con*50){
      this.hp = this.con*50;
    }
  }

  public void regenerateMp() {
    this.mp += this.wis*2;
    if(this.mp > this.inte*30){
      this.mp = this.inte*30;
    }
  }

}