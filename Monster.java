package zuul;

public class Monster{

    public String name;
    public String rolle;
    public int maxHp;
    public int maxAtt;
    public int minAtt;
    public int level;
    public int curHp;

    public Monster(String name, String rolle){
        this.name = name;
        this.rolle = rolle;
    }

    public int attack(Monster other){
        int att = (int)(Math.random() * (this.maxAtt - this.minAtt + 1) + this.minAtt);
        other.curHp -= att;
        return att;
    }

    public boolean isDead(){
        if(this.curHp <= 0){
            return true;
        }else{
            return false;
        }
    }
    public int getCurHp(){
        return curHp;
    }
    public void setCurHp(int hp){
        if(hp >= maxHp - curHp){
            curHp = maxHp;
        }else{
            curHp = hp;
        }
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name; 
    }
    public String getRole(){
        return rolle;
    }
    public void setRole(String rolle){
        this.rolle = rolle;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public int getLevel(){
        return level;
    }
    public String status(){
        return name + " hat " + curHp + "/" + maxHp + " HP.";
    }

    public String toString(){
        return name +  " die " + rolle + " ist Level " + level + " mit " + curHp + "/" + maxHp + " HP und hat ein Attack von " + maxAtt + "-" + minAtt;
    }

}