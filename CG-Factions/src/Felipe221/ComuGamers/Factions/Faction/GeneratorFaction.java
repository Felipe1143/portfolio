package Felipe221.ComuGamers.Factions.Faction;

import java.util.HashMap;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.Config.ConfigManager;

public class GeneratorFaction {	
	public static HashMap<String, String> gene = new HashMap<String, String>();
	public static HashMap<String, String> genera = new HashMap<String, String>();
	public static HashMap<String, String> isru = new HashMap<String, String>();
	
	public static HashMap<String, Long> speed = new HashMap<String, Long>();
	public static HashMap<String, Integer> time = new HashMap<String, Integer>();

	public static void generate(String tag) {
		if (!ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Chest.World").equals("Vacio")){
			String m = ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Material").toUpperCase();
			Material mat = Material.getMaterial(m);
			
			String world = ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Chest.World");
			int x = ConfigManager.getStats().getInt("Facciones." + tag + ".Generadores.Chest.X");	
			int y = ConfigManager.getStats().getInt("Facciones." + tag + ".Generadores.Chest.Y");	
			int z = ConfigManager.getStats().getInt("Facciones." + tag + ".Generadores.Chest.Z");					
			
			Location chestloc = new Location(Bukkit.getWorld(world), x,y,z);
			
			Block block = Bukkit.getWorld(ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Chest.World")).getBlockAt(chestloc);

			if (mat != Material.AIR) {
				Chest chest = (Chest) block.getState();
				
				chest.getBlockInventory().addItem(new ItemStack(mat));
			}
		}
	}
	
//	if (materia.equals("gold_ingot")) {
//		if (leve == 1) {
//			GeneratorFaction.time.put(faction.getTag(), 100);
//		}else if (leve == 2) {
//			GeneratorFaction.time.put(faction.getTag(), 90);
//		}else if (leve == 3) {
//			GeneratorFaction.time.put(faction.getTag(), 80);
//		}else if (leve == 4) {
//			GeneratorFaction.time.put(faction.getTag(), 70);
//		}else if (leve == 5) {
//			GeneratorFaction.time.put(faction.getTag(), 60);
//		}
//	}else if (materia.equals("redstone")) {	
//		if (leve == 1) {
//			GeneratorFaction.time.put(faction.getTag(), 120);
//		}else if (leve == 2) {
//			GeneratorFaction.time.put(faction.getTag(), 110);
//		}else if (leve == 3) {
//			GeneratorFaction.time.put(faction.getTag(), 100);
//		}else if (leve == 4) {
//			GeneratorFaction.time.put(faction.getTag(), 90);
//		}else if (leve == 5) {
//			GeneratorFaction.time.put(faction.getTag(), 80);
//		}
//	}else if (materia.equals("obsidian")) {	
//		if (leve == 1) {
//			GeneratorFaction.time.put(faction.getTag(), 300);
//		}else if (leve == 2) {
//			GeneratorFaction.time.put(faction.getTag(), 270);
//		}else if (leve == 3) {
//			GeneratorFaction.time.put(faction.getTag(), 250);
//		}else if (leve == 4) {
//			GeneratorFaction.time.put(faction.getTag(), 200);
//		}else if (leve == 5) {
//			GeneratorFaction.time.put(faction.getTag(), 180);
//		}
//	}else if (materia.equals("iron_ingot")) {		
//		if (leve == 1) {
//			GeneratorFaction.time.put(faction.getTag(), 60);
//		}else if (leve == 2) {
//			GeneratorFaction.time.put(faction.getTag(), 50);
//		}else if (leve == 3) {
//			GeneratorFaction.time.put(faction.getTag(), 40);
//		}else if (leve == 4) {
//			GeneratorFaction.time.put(faction.getTag(), 30);
//		}else if (leve == 5) {
//			GeneratorFaction.time.put(faction.getTag(), 25);
//		}
//	}else if (materia.equals("diamond")) {			
//		if (leve == 1) {
//			GeneratorFaction.time.put(faction.getTag(), 350);
//		}else if (leve == 2) {
//			GeneratorFaction.time.put(faction.getTag(), 320);
//		}else if (leve == 3) {
//			GeneratorFaction.time.put(faction.getTag(), 300);
//		}else if (leve == 4) {
//			GeneratorFaction.time.put(faction.getTag(), 260);
//		}else if (leve == 5) {
//			GeneratorFaction.time.put(faction.getTag(), 220);
//		}
//	}else if (materia.equals("emerald")) {
//		if (leve == 1) {
//			GeneratorFaction.time.put(faction.getTag(), 550);
//		}else if (leve == 2) {
//			GeneratorFaction.time.put(faction.getTag(), 500);
//		}else if (leve == 3) {
//			GeneratorFaction.time.put(faction.getTag(), 475);
//		}else if (leve == 4) {
//			GeneratorFaction.time.put(faction.getTag(), 420);
//		}else if (leve == 5) {
//			GeneratorFaction.time.put(faction.getTag(), 350);
//		}				
//	}

	public static void GenerateFinal() {
		new BukkitRunnable() {
			@Override
			public void run() {	
				for(Faction faction : Factions.getInstance().getAllFactions()) {
					String tag = faction.getTag();
					
					if (tag.contains("-") || tag.contains("segura") || tag.contains("peligro")) {	
								 
					}else {
						if (!ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Chest.World").equals("Vacio")){
							if(gene.get(tag).equals("Si")) {	
								if (time.get(tag) == 0) {					
									int leve = ConfigManager.getStats().getInt("Facciones." + tag + ".Generadores.Nivel");	
									String materia = ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Material");	
									
									//NIVEL 1
									if (leve == 1) {		
										if (materia.equals("iron_ingot")) {					
											time.put(tag, 60);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("redstone")) {					
											time.put(tag, 120);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("emerald")) {					
											time.put(tag, 550);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("gold_ingot")) {								
											time.put(tag, 100);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("diamond")) {								
											time.put(tag, 350);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("obsidian")) {								
											time.put(tag, 300);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}
									//NIVEL 2
									}else if (leve == 2) {
										if (materia.equals("iron_ingot")) {					
											time.put(tag, 50);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("redstone")) {					
											time.put(tag, 110);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("emerald")) {					
											time.put(tag, 500);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("gold_ingot")) {								
											time.put(tag, 90);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("diamond")) {								
											time.put(tag, 320);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("obsidian")) {								
											time.put(tag, 270);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}
									//NIVEL 3
									}else if (leve == 3) {
										if (materia.equals("iron_ingot")) {					
											time.put(tag, 40);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("redstone")) {					
											time.put(tag, 100);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("emerald")) {					
											time.put(tag, 475);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("gold_ingot")) {								
											time.put(tag, 80);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("diamond")) {								
											time.put(tag, 300);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("obsidian")) {								
											time.put(tag, 250);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}
									//NIVEL 4
									}else if (leve == 4) {
										if (materia.equals("iron_ingot")) {					
											time.put(tag, 30);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("redstone")) {					
											time.put(tag, 90);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("emerald")) {					
											time.put(tag, 420);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("gold_ingot")) {								
											time.put(tag, 70);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("diamond")) {								
											time.put(tag, 260);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("obsidian")) {								
											time.put(tag, 200);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}
									//NIVEL 5
									}else if (leve == 5) {
										if (materia.equals("iron_ingot")) {					
											time.put(tag, 25);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("redstone")) {					
											time.put(tag, 80);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("emerald")) {					
											time.put(tag, 350);
													
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}	
										}else if (materia.equals("gold_ingot")) {								
											time.put(tag, 60);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("diamond")) {								
											time.put(tag, 220);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}else if (materia.equals("obsidian")) {								
											time.put(tag, 180);
																
											if(gene.get(tag).equals("Si")) {	
												generate(tag);									
											}
										}
									}
								}else {
									time.put(tag, time.get(tag) - 1);
								}
							}
						}
					}	
				}
			}
		}.runTaskTimer(Main.plugin, 20L, 20L);
	}		
}
