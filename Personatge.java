enum Race {
  ORC, ELF, DWARF, HUMAN
}

public class Personatge {
  private String name;
  private Race race;
  private int edat;
  private double hp;
  private double mp;
  private double str;
  private double dex;
  private double con;
  private double inte;
  private double wis;
  private double luck;

  public Personatge() {

  }
  public Personatge(String name, Race race, int edat, double hp, double mp, double str, double dex, double con, double inte, double wis, double luck) {
    this.name = name;
    this.race = race;
    this.edat = edat;
    this.hp = hp;
    this.mp = mp;
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

  public int getEdat() {
    return edat;
  }

  public void setEdat(int edat) {
    this.edat = edat;
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


}