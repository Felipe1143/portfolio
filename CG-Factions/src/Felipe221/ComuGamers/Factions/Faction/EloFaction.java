package Felipe221.ComuGamers.Factions.Faction;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import Felipe221.ComuGamers.Factions.Main;

public class EloFaction {
	
	public static int getElo(Faction fac) {		
		//STATS NORMALES
		double power = fac.getPower();
		int kills = fac.getKills();
		int deaths = fac.getDeaths();
		int claims = fac.getAllClaims().size();
		
		//GENERACIÓN DE ELO
		int killsf = kills * 3;
		double powerf = power * 2;
		int deathsf = deaths * 3;
		int claimsf = claims * 3;
		
		//ELO FINAL
		int elo = 1000 - deathsf + claimsf + killsf + (int) powerf;
				
		if (fac.getTag().contains("-") || fac.getTag().contains("Zona")) {
			elo = 0;
		}
		
		return elo;
	}
	 
    public static HashMap<String, Integer> elo = new HashMap<String,Integer>(); 
	
    public static String EloGenerator(HashMap<String, Integer> map){
    	String top = null;        
    	
    	int maxValueInMap = Collections.max(elo.values());
	        
    	for (Entry<String, Integer> entry : elo.entrySet()) {
    		if (entry.getValue() == maxValueInMap) {
    			top = entry.getKey();
    		}
    	}
	       
    	return top;
    }
    
    public static String[] getAllELO(){	
		for(Faction faction : Factions.getInstance().getAllFactions()) {
			String name = faction.getTag();
			
			elo.put(name, getElo(faction));
		}
			 
		if(elo.size()<6){
			elo.put(" ", 0);
			elo.put("   ", 0);
			elo.put("    ", 0);
			elo.put("     ", 0);
			elo.put("      ", 0);
		}
			
		String name1 = EloGenerator(elo);
		elo.remove(name1);
		String name2 = EloGenerator(elo);
		elo.remove(name2);
		String name3 = EloGenerator(elo);
		elo.remove(name3);
		String name4 = EloGenerator(elo);
		elo.remove(name4);
		String name5 = EloGenerator(elo);
		elo.remove(name5);
		     
		String[] top = {name1,name2,name3,name4,name5};
		     
		return top;
	}
}
