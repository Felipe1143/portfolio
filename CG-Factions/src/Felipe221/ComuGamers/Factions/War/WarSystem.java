package Felipe221.ComuGamers.Factions.War;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

public class WarSystem {
	public static HashMap<String, String> war = new HashMap<String, String>();

	public static ArrayList<Player> inWar = new ArrayList<Player>();
	
	public static HashMap<Player, String> invite = new HashMap<Player, String>();
	
	public static HashMap<Player, String> ingame = new HashMap<Player, String>();
	public static HashMap<Player, Location> getpos = new HashMap<Player, Location>();
	
	public static HashMap<String, WarState> warstate = new HashMap<String, WarState>();

	public enum WarState{
		ESPERANDO, INICIANDO, EN_JUEGO, REINICIANDO, ERROR;
	}
	
	public static WarState getState() {
		WarState state = warstate.get("a");
		
		return state;		
	}
	
	public static void setState(WarState mode) {
		warstate.put("a", mode);
	}
	
	public static boolean isExist(String name) {
		boolean exist = false;
		
		for (Faction factions : Factions.getInstance().getAllFactions()) {
			String tag = factions.getTag();
			
			if (tag.contains(name)) {
				exist = true;
			}else {
				exist = false;
			}		
		}
		
		return exist;
	}
	
	public static String getFaction(int a) {
		String faction = null;
		
		String f1 = null;
		String f2 = null;
		
		for (Map.Entry <String, String> entry : war.entrySet()) {
			f1 = entry.getKey();
			f2 = entry.getValue();
		}
		 
		if (a == 1) {
			faction = f1;
		}else {
			faction = f2;
		}
		
		return faction;	
	}
}
