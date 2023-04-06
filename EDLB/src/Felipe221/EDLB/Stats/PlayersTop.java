package Felipe221.EDLB.Stats;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import Felipe221.EDLB.Main;

public class PlayersTop {
    public static HashMap<String, Integer> Scores = new HashMap<String,Integer>();
    public static HashMap<String, Integer> Wins = new HashMap<String,Integer>();
    public static HashMap<String, Integer> Level = new HashMap<String,Integer>();
    
    public static String countdown(HashMap<String, Integer> map){
        String top = null;
        int maxValueInMap=(Collections.max(Scores.values()));  // This will return max value in the Hashmap
        for (Entry<String, Integer> entry : Scores.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {    // Print the key with max value
                top = entry.getKey();
            }
        }
       
        return top;
    }
	
	 public static String[] getTop5(){	       
		 for(String user : Main.plugin.getConfig().getConfigurationSection("Jugadores").getKeys(true)) {
			 if(!user.contains(".")){
				 Scores.put(user, Main.plugin.getConfig().getInt("Jugadores." + user + ".Kills"));
			 }
		 }
		 
	     if(Scores.size()<6){
	    	 Scores.put(" ", 0);
	    	 Scores.put("  ", 0);
	    	 Scores.put("  ", 0);
	    	 Scores.put("    ", 0);
	    	 Scores.put("    ", 0);
	     }
	     
	     String name1 = countdown(Scores);
	     Scores.remove(name1);
	     String name2 = countdown(Scores);
	     Scores.remove(name2);
	     String name3 = countdown(Scores);
	     Scores.remove(name3);
	     String name4 = countdown(Scores);
	     Scores.remove(name4);
	     String name5 = countdown(Scores);
	     Scores.remove(name5);
	     String[] top ={name1,name2,name3,name4,name5};
	     System.out.println(top);
	     return top;
	    }
	 
	 public static String countdownWins(HashMap<String, Integer> map){
	        String top = null;
	        int maxValueInMap=(Collections.max(Wins.values()));  // This will return max value in the Hashmap
	        for (Entry<String, Integer> entry : Wins.entrySet()) {  // Itrate through hashmap
	            if (entry.getValue()==maxValueInMap) {    // Print the key with max value
	                top = entry.getKey();
	            }
	        }
	       
	        return top;
	    }
		
		 public static String[] getTopWins5(){	       
			 for(String user : Main.plugin.getConfig().getConfigurationSection("Jugadores").getKeys(true)) {
				 if(!user.contains(".")){
					 Wins.put(user, Main.plugin.getConfig().getInt("Jugadores." + user + ".Wins"));
				 }
			 }
			 
		     if(Wins.size()<6){
		    	 Wins.put(" ", 0);
		    	 Wins.put("  ", 0);
		    	 Wins.put("  ", 0);
		    	 Wins.put("    ", 0);
		    	 Wins.put("    ", 0);
		     }
		     
		     String name1 = countdownWins(Wins);
		     Wins.remove(name1);
		     String name2 = countdownWins(Wins);
		     Wins.remove(name2);
		     String name3 = countdownWins(Wins);
		     Wins.remove(name3);
		     String name4 = countdownWins(Wins);
		     Wins.remove(name4);
		     String name5 = countdownWins(Wins);
		     Wins.remove(name5);
		     String[] top ={name1,name2,name3,name4,name5};
		     System.out.println(top);
		     return top;
		    }
		 
		 public static String countdownLevel(HashMap<String, Integer> map){
		        String top = null;
		        int maxValueInMap=(Collections.max(Level.values()));  // This will return max value in the Hashmap
		        for (Entry<String, Integer> entry : Level.entrySet()) {  // Itrate through hashmap
		            if (entry.getValue()==maxValueInMap) {    // Print the key with max value
		                top = entry.getKey();
		            }
		        }
		       
		        return top;
		    }
			
			 public static String[] getTopLevel5(){	       
				 for(String user : Main.plugin.getConfig().getConfigurationSection("Jugadores").getKeys(true)) {
					 if(!user.contains(".")){
						 Level.put(user, Main.plugin.getConfig().getInt("Jugadores." + user + ".Level"));
					 }
				 }
				 
			     if(Level.size()<6){
			    	 Level.put(" ", 0);
			    	 Level.put("  ", 0);
			    	 Level.put("  ", 0);
			    	 Level.put("    ", 0);
			    	 Level.put("    ", 0);
			     }
			     
			     String name1 = countdownLevel(Level);
			     Level.remove(name1);
			     String name2 = countdownLevel(Level);
			     Level.remove(name2);
			     String name3 = countdownLevel(Level);
			     Level.remove(name3);
			     String name4 = countdownLevel(Level);
			     Level.remove(name4);
			     String name5 = countdownLevel(Level);
			     Level.remove(name5);
			     String[] top ={name1,name2,name3,name4,name5};
			     System.out.println(top);
			     return top;
			    }
}
