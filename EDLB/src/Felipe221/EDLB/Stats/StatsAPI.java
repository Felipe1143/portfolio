package Felipe221.EDLB.Stats;

import org.bukkit.entity.Player;

import Felipe221.EDLB.Main;

public class StatsAPI {	
	public static int getLevel(Player player) {
		return Main.plugin.getConfig().getInt("Jugadores." + player.getName() + ".Level");
	}
	
	public static int getXP(Player player) {
		return Main.plugin.getConfig().getInt("Jugadores." + player.getName() + ".XP");
	}
	
	public static int getCoins(Player player) {
		return Main.plugin.getConfig().getInt("Jugadores." + player.getName() + ".Coins");
	}
		
	public static void addXP(Player player, int value) {
		Main.plugin.getConfig().set("Jugadores." + player.getName() + ".XP", getXP(player)+value);
		
		if (getXP(player) == 100) {
			addLevel(player, 1);
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".XP", 0);			
		}
		
	    Main.plugin.saveConfig();
		
	}
	public static void addCoins(Player player, int value) {
		Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Coins", getCoins(player)+value);
		
	    Main.plugin.saveConfig();
	}
	
	public static void addLauch(Player player, int value) {
		Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Disparos", getLauch(player)+value);
		
	    Main.plugin.saveConfig();
	}
	
	public static void addLevel(Player player, int value) {
		Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Level", getLevel(player)+value);
		
	    Main.plugin.saveConfig();
	}
	
	public static int getKills(Player player) {
		return Main.plugin.getConfig().getInt("Jugadores." + player.getName() + ".Kills");
	}
	
	public static void addKills(Player player, int value) {
		Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Kills", getKills(player)+value);
		
		if (getKills(player) == 15) {
			
		}
		
		if (getKills(player) == 30) {
			
		}
		
		if (getKills(player) == 50) {
			
		}
		
	    Main.plugin.saveConfig();
	}
	
	public static int getWins(Player player) {
		return Main.plugin.getConfig().getInt("Jugadores." + player.getName() + ".Wins");		
	}
	
	public static int getLauch(Player player) {
		return Main.plugin.getConfig().getInt("Jugadores." + player.getName() + ".Disparos");		
	}
	
	public static void addWins(Player player, int value) {
		Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Wins", getWins(player)+value);
		
		if (getWins(player) == 15) {
			
		}
		
		if (getWins(player) == 30) {
			
		}
		
		if (getWins(player) == 50) {
			
		}
		
	    Main.plugin.saveConfig();
	}	
}
