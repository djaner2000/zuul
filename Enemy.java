package zuul;

	public class Enemy extends Monster{

	    public Enemy(int leveled){
	        super("Filler", "Filler");
	        this.level = 1;
	        this.setName(randomName());
	        this.setRole(randomRole());

	        rollStats();
	        if(leveled > 1){
	            for(int i = 1; i < leveled; i++){
	                levelUp();
	            }
	        }
	        this.curHp = maxHp;

	    }
	    //pulls a random name from an array
	    public String randomName(){
	        String[] names = {"Spooky", "Scary", "Yup"};
	        int index = (int)(Math.random() * names.length);

	        return names[index];

	    }
	    //pulls a random role from an array, these are pased to roleToNumber
	    public String randomRole(){
	        String[] roles = {"Orc", "Goblin", "Dragon"};
	        int index = (int)(Math.random() * roles.length);

	        return roles[index];
	    }
	    public void rollStats(){
	        int hp = 0;
	        int att = 0;
	        switch(roleToNumber()){
	            case 1: hp = 16; att = 10; break;
	            case 2: hp = 13; att = 13; break;
	            case 3: hp = 12; att = 14; break;
	        }
	        maxHp = (roll(6) + hp);
	        maxAtt = (roll(6) + att); 
	        minAtt = (maxAtt - 3); 

	    }

	    private int roll(int sides){
	        int aRoll = (int)(Math.random() * sides + 1);
	        return aRoll;
	    }

	    private int roleToNumber(){
	        if(rolle.equalsIgnoreCase("Orc")){
	            return 1;
	        }else if(rolle.equalsIgnoreCase("Goblin")){
	            return 2;
	        }else if(rolle.equalsIgnoreCase("Dragon")){
	            return 3;
	        }else{
	            return 0;
	        }
	    }

	    public void levelUp(){
	        level++;
	        int hp = 0;
	        int att = 0;
	        switch(roleToNumber()){
	            case 1: hp = 24; att = 14; break;
	            case 2: hp = 19; att = 19; break;
	            case 3: hp = 16; att = 22; break;
	        }
	        maxHp += (hp * Math.random()/2 + .5);
	        maxAtt += (att * Math.random()/2 + .5);
	        minAtt = maxAtt - 3;
	        this.curHp = maxHp;
	    }
	}