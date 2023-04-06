package Felipe221.ComuGamers.Factions.Config;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.Faction.GeneratorFaction;
import Felipe221.ComuGamers.Factions.Faction.KitFaction;
import Felipe221.ComuGamers.Factions.Faction.KitFaction.KitType;

public class ConfigManager {
	public static File stats = new File(Main.plugin.getDataFolder(), "stats.yml");
	
	public static FileConfiguration statsyml = YamlConfiguration.loadConfiguration(stats);
	
	public static void createFiles() {
		if (!stats.exists()) {
			stats.getParentFile().mkdirs();
			Main.plugin.saveResource("stats.yml", false);
		}	
		
		try {
			statsyml.load(stats);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void onStart() {
		new BukkitRunnable() {
			 @Override
	         public void run() {
				 for (Player player : Bukkit.getOnlinePlayers()) {		    	
			    	FPlayer playerF = FPlayers.getInstance().getByPlayer(player);
			    	
			    	String tag = playerF.getFaction().getTag();
			    	
			    	if (!ConfigManager.getStats().contains("Facciones." + tag + ".En guerra." + player.getName())) {
			    		ConfigManager.getStats().set("Facciones." + tag + ".En guerra." + player.getName(), "No");
			    		
			    		ConfigManager.saveStats();
			    	}
			    	
			    	if (!ConfigManager.getStats().contains("Facciones." + tag + ".Generadores")) {
			    		ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Material", "iron_ingot");
			    		ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Nivel", 1);
			    		ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Chest.World", "Vacio");
			    		
			    		GeneratorFaction.time.put(tag, 60);
			    		
			    		ConfigManager.saveStats();
			    	}
				 }
				 
				 for(Faction faction : Factions.getInstance().getAllFactions()) {	
					 String tag = faction.getTag();
					 
					 if (tag.contains("-") || tag.contains("segura") || tag.contains("peligro")) {	
						 
					 }else {
						 String materia = ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Material");
						 GeneratorFaction.genera.put(tag, materia);
						 
						 if (faction.getOnlinePlayers().size() != 0) {
							 GeneratorFaction.gene.put(tag, "Si");
						 }else {
							 GeneratorFaction.gene.put(tag, "No"); 
						 }
					 }
				 }
			 }
		}.runTaskTimer(Main.plugin, 2L, 2L);
		
		if (ConfigManager.getStats().contains("Jugadores")) {
			for(String players : getStats().getConfigurationSection("Jugadores").getKeys(false)) {				
				if (ConfigManager.getStats().getInt("Jugadores." + players + ".Cooldown.novato") != -50 || ConfigManager.getStats().contains("Jugadores." + players + ".Cooldown.novato")){
					int time = ConfigManager.getStats().getInt("Jugadores." + players + ".Cooldown.novato");
					
					KitFaction.startCooldown(players, KitType.NOVATO, time);
				}
				
				if (ConfigManager.getStats().getInt("Jugadores." + players + ".Cooldown.avanzado") != -50 || ConfigManager.getStats().contains("Jugadores." + players + ".Cooldown.avanzado")){
					int time = ConfigManager.getStats().getInt("Jugadores." + players + ".Cooldown.avanzado");
					
					KitFaction.startCooldown(players, KitType.AVANZADO, time);
				}
			}
		}
		
		for(Faction faction : Factions.getInstance().getAllFactions()) {	
			 String tag = faction.getTag();
			 
			 if (tag.contains("-") || tag.contains("segura") || tag.contains("peligro")) {	
				 
			 }else {
				String materia = ConfigManager.getStats().getString("Facciones." + faction.getTag() + ".Generadores.Material");	
				int leve = ConfigManager.getStats().getInt("Facciones." + faction.getTag() + ".Generadores.Nivel");	
				
				if (materia.equals("gold_ingot")) {
					if (leve == 1) {
						GeneratorFaction.time.put(faction.getTag(), 100);
					}else if (leve == 2) {
						GeneratorFaction.time.put(faction.getTag(), 90);
					}else if (leve == 3) {
						GeneratorFaction.time.put(faction.getTag(), 80);
					}else if (leve == 4) {
						GeneratorFaction.time.put(faction.getTag(), 70);
					}else if (leve == 5) {
						GeneratorFaction.time.put(faction.getTag(), 60);
					}
				}else if (materia.equals("redstone")) {	
					if (leve == 1) {
						GeneratorFaction.time.put(faction.getTag(), 120);
					}else if (leve == 2) {
						GeneratorFaction.time.put(faction.getTag(), 110);
					}else if (leve == 3) {
						GeneratorFaction.time.put(faction.getTag(), 100);
					}else if (leve == 4) {
						GeneratorFaction.time.put(faction.getTag(), 90);
					}else if (leve == 5) {
						GeneratorFaction.time.put(faction.getTag(), 80);
					}
				}else if (materia.equals("obsidian")) {	
					if (leve == 1) {
						GeneratorFaction.time.put(faction.getTag(), 300);
					}else if (leve == 2) {
						GeneratorFaction.time.put(faction.getTag(), 270);
					}else if (leve == 3) {
						GeneratorFaction.time.put(faction.getTag(), 250);
					}else if (leve == 4) {
						GeneratorFaction.time.put(faction.getTag(), 200);
					}else if (leve == 5) {
						GeneratorFaction.time.put(faction.getTag(), 180);
					}
				}else if (materia.equals("iron_ingot")) {		
					if (leve == 1) {
						GeneratorFaction.time.put(faction.getTag(), 60);
					}else if (leve == 2) {
						GeneratorFaction.time.put(faction.getTag(), 50);
					}else if (leve == 3) {
						GeneratorFaction.time.put(faction.getTag(), 40);
					}else if (leve == 4) {
						GeneratorFaction.time.put(faction.getTag(), 30);
					}else if (leve == 5) {
						GeneratorFaction.time.put(faction.getTag(), 25);
					}
				}else if (materia.equals("diamond")) {			
					if (leve == 1) {
						GeneratorFaction.time.put(faction.getTag(), 350);
					}else if (leve == 2) {
						GeneratorFaction.time.put(faction.getTag(), 320);
					}else if (leve == 3) {
						GeneratorFaction.time.put(faction.getTag(), 300);
					}else if (leve == 4) {
						GeneratorFaction.time.put(faction.getTag(), 260);
					}else if (leve == 5) {
						GeneratorFaction.time.put(faction.getTag(), 220);
					}
				}else if (materia.equals("emerald")) {
					if (leve == 1) {
						GeneratorFaction.time.put(faction.getTag(), 550);
					}else if (leve == 2) {
						GeneratorFaction.time.put(faction.getTag(), 500);
					}else if (leve == 3) {
						GeneratorFaction.time.put(faction.getTag(), 475);
					}else if (leve == 4) {
						GeneratorFaction.time.put(faction.getTag(), 420);
					}else if (leve == 5) {
						GeneratorFaction.time.put(faction.getTag(), 350);
					}				
				}
			}
		}
	}
	
	public static FileConfiguration getStats() {
		return statsyml;
	}
		
	public static void saveStats() {
		try {
			statsyml.save(stats);
		} catch (Exception e) {
			printException(e, "stats.yml");
        }
    }
    
    private static void printException(Exception e, String filename) {
        if (e instanceof IOException) {
           Main.sendLog("I/O exception while handling " + filename);
        } else if (e instanceof InvalidConfigurationException) {
           Main.sendLog("Invalid statsuration in " + filename);
        }
        e.printStackTrace();
    }
}
