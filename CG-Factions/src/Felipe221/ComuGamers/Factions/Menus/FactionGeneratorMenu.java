package Felipe221.ComuGamers.Factions.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.Config.ConfigManager;
import Felipe221.ComuGamers.Factions.Faction.GeneratorFaction;

public class FactionGeneratorMenu {	
	public static void openMenu(Player player) {
		FactionMenu.open.put(player, "a1");
				
		Inventory join = Bukkit.getServer().createInventory(player, 45, "§nGeneradores");
		
		new BukkitRunnable() {
			 @Override
	         public void run() {
				 if (FactionMenu.open.containsKey(player)) {		
					FPlayer p = FPlayers.getInstance().getByPlayer(player);
					
					String materia = ConfigManager.getStats().getString("Facciones." + p.getFaction().getTag() + ".Generadores.Material");		
					int leve = ConfigManager.getStats().getInt("Facciones." + p.getFaction().getTag() + ".Generadores.Nivel");		
			        
					ItemStack mif = new ItemStack(Material.LAVA_BUCKET);
					ItemMeta meta = mif.getItemMeta();
					
					meta.setDisplayName("§eGenerador");
					
					ArrayList<String> lore= new ArrayList<String>();		
								
					lore.add("§f");
					lore.add("§f¡Introduce el tipo de §ematerial");
					lore.add("§fque quieres §agenerar §fpara tú facción!");
					lore.add("§fTen en cuenta que mientras más §bdíficil §fsea");
					lore.add("§fconseguir el material §dmás tardará§f.");
					lore.add("");
					
					String gene = null;
					
					if (materia.equals("iron_ingot")) {
						gene = "Lingotes de hierro";
					}else if (materia.equals("gold_ingot")) {
						gene = "Lingotes de oro";
					}else if (materia.equals("diamond")) {
						gene = "Diamantes";
					}else if (materia.equals("obsidian")) {
						gene = "Obsidiana";
					}else if (materia.equals("emerald")) {
						gene = "Esmeralda";
					}else if (materia.equals("redstone")) {
						gene = "Redstone";
					}
					
					
					if (materia.equals("-")) {
						lore.add("§fGenerando: §b¡Selecciona un material!");
					}else {
						lore.add("§fGenerando: §b" + gene);
					}
			
					if (materia.equals("-")) {
						lore.add("§fNivel: §b-");		
					}else {
						lore.add("§fNivel: §b" + leve);						
					}				

					if (materia.equals("gold_ingot")) {
						if (leve == 1) {
							lore.add("§fTiempo de producción: §b1m 40s");
						}else if (leve == 2) {
							lore.add("§fTiempo de producción: §b1m 30s");
						}else if (leve == 3) {
							lore.add("§fTiempo de producción: §b1m 20s");
						}else if (leve == 4) {
							lore.add("§fTiempo de producción: §b1m 10s");
						}else if (leve == 5) {
							lore.add("§fTiempo de producción: §b1m");
						}
					}else if (materia.equals("redstone")) {	
						if (leve == 1) {
							lore.add("§fTiempo de producción: §b2m");
						}else if (leve == 2) {
							lore.add("§fTiempo de producción: §b1m 50s");
						}else if (leve == 3) {
							lore.add("§fTiempo de producción: §b1m 40s");
						}else if (leve == 4) {
							lore.add("§fTiempo de producción: §b1m 30s");
						}else if (leve == 5) {
							lore.add("§fTiempo de producción: §b1m 20s");
						}
					}else if (materia.equals("obsidian")) {	
						if (leve == 1) {
							lore.add("§fTiempo de producción: §b5m");
						}else if (leve == 2) {
							lore.add("§fTiempo de producción: §b4m 50s");
						}else if (leve == 3) {
							lore.add("§fTiempo de producción: §b4m 15s");
						}else if (leve == 4) {
							lore.add("§fTiempo de producción: §b3m 30s");
						}else if (leve == 5) {
							lore.add("§fTiempo de producción: §b3m");
						}
					}else if (materia.equals("iron_ingot")) {	
						if (leve == 1) {
							lore.add("§fTiempo de producción: §b1m");
						}else if (leve == 2) {
							lore.add("§fTiempo de producción: §b50s");
						}else if (leve == 3) {
							lore.add("§fTiempo de producción: §b40s");
						}else if (leve == 4) {
							lore.add("§fTiempo de producción: §b30s");
						}else if (leve == 5) {
							lore.add("§fTiempo de producción: §b25s");
						}
					}else if (materia.equals("diamond")) {			
						if (leve == 1) {
							lore.add("§fTiempo de producción: §b5m 50s");
						}else if (leve == 2) {
							lore.add("§fTiempo de producción: §b5m 20s");
						}else if (leve == 3) {
							lore.add("§fTiempo de producción: §b5m");
						}else if (leve == 4) {
							lore.add("§fTiempo de producción: §b4m 30s");
						}else if (leve == 5) {
							lore.add("§fTiempo de producción: §b3m 50s");
						}
					}else if (materia.equals("emerald")) {
						if (leve == 1) {
							lore.add("§fTiempo de producción: §b9m");
						}else if (leve == 2) {
							lore.add("§fTiempo de producción: §b8m 30s");
						}else if (leve == 3) {
							lore.add("§fTiempo de producción: §b7m 50s");
						}else if (leve == 4) {
							lore.add("§fTiempo de producción: §b7m");
						}else if (leve == 5) {
							lore.add("§fTiempo de producción: §b5m 50s");
						}
					}
					
					meta.setLore(lore);
											
					mif.setItemMeta(meta);
					
					ItemStack enviar = new ItemStack(Material.SIGN);
					ItemMeta metaenviar = enviar.getItemMeta();
					
					metaenviar.setDisplayName("§eSeleccionar material");
					
					ArrayList<String> loreenviar= new ArrayList<String>();		
								
					loreenviar.add("§f");
					loreenviar.add("§f¡Selecciona el §ematerial §fque quieres producir!");
					loreenviar.add("§fTen en cuenta que estos materiales");
					loreenviar.add("§fse §ageneran §fde manera §bgratuita§f.");
					loreenviar.add("");
					loreenviar.add("§fMateriales disponibles:");
			
					if (materia.equals("iron_ingot")) {
						loreenviar.add("  §a- Lingotes de hierro");
					}else {
						loreenviar.add("  §f- Lingotes de hierro");
					}
					
					if (materia.equals("gold_ingot")) {
						loreenviar.add("  §a- Lingotes de oro");
					}else {
						loreenviar.add("  §f- Lingotes de oro");
					}
					
					if (materia.equals("redstone")) {
						loreenviar.add("  §a- Redstone");
					}else {
						loreenviar.add("  §f- Redstone");
					}
					
					if (materia.equals("emerald")) {
						loreenviar.add("  §a- Esmeralda");
					}else {
						loreenviar.add("  §f- Esmeralda");
					}
					
					if (materia.equals("diamond")) {
						loreenviar.add("  §a- Diamante");
					}else {
						loreenviar.add("  §f- Diamante");
					}
					
					if (materia.equals("obsidian")) {
						loreenviar.add("  §a- Obsidiana");
					}else {
						loreenviar.add("  §f- Obsidiana");
					}
					
					loreenviar.add("");
					loreenviar.add("§b¡Haz click para cambiar!");
					
					metaenviar.setLore(loreenviar);
											
					enviar.setItemMeta(metaenviar);
					
					
					ItemStack chest = new ItemStack(Material.CHEST);
					ItemMeta metachest = chest.getItemMeta();
					
					metachest.setDisplayName("§eUbicación de cofre");
					
					ArrayList<String> lorechest= new ArrayList<String>();		
								
					lorechest.add("§f");
					lorechest.add("§f¡Selecciona el §ecofre §fdonde serán");
					lorechest.add("§fdepositados los §amateriales §fque se generen!");					
					lorechest.add("");
					
					if (ConfigManager.getStats().getString("Facciones." + p.getFaction().getTag() + ".Generadores.Chest.World").equals("Vacio")) {
						lorechest.add("§fUbicación: §bIndefinada");
					}else {
						lorechest.add("§fUbicación: §b" + ConfigManager.getStats().getString("Facciones." + p.getFaction().getTag() + ".Generadores.Chest.World") + " (X: " + ConfigManager.getStats().getString("Facciones." + p.getFaction().getTag() + ".Generadores.Chest.X") + "/Y: " + ConfigManager.getStats().getString("Facciones." + p.getFaction().getTag() + ".Generadores.Chest.Y") + "/Z: " + ConfigManager.getStats().getString("Facciones." + p.getFaction().getTag() + ".Generadores.Chest.Z") + ")");						
					}
					
					lorechest.add("");
					lorechest.add("§b¡Haz click para cambiar!");
					
					metachest.setLore(lorechest);
					
					chest.setItemMeta(metachest);
					
					ItemStack level = new ItemStack(Material.EXP_BOTTLE);
					ItemMeta metalevel = level.getItemMeta();
					
					metalevel.setDisplayName("§eSubir de nivel");
					
					ArrayList<String> lorelevel= new ArrayList<String>();		
								
					lorelevel.add("§f");
					lorelevel.add("§f¡Subir el §enivel §fsignifica tener acceso");
					lorelevel.add("§fa una producción más §brápida§f!");					
					lorelevel.add("§fLos usuarios §a§lVIP§f, §6§lELITE §fy §d§lULTIMATE");
					lorelevel.add("§fpodrán desbloquear el nivel §a4 §fy §a5§f.");
					lorelevel.add("§f");
					lorelevel.add("§fNivel: §b" + leve);
					
					if (leve == 1) {
						lorelevel.add("§fCosto de mejora: §b8000$");
					}else if (leve == 2) {
						lorelevel.add("§fCosto de mejora: §b20000$");
					}else if (leve == 3) {
						if (player.hasPermission("comugames.vip") || player.hasPermission("comugames.elite") || player.hasPermission("comugames.ultimate")) {
							lorelevel.add("§fCosto de mejora: §b30000$");
						}else {
							lorelevel.add("§fCosto de mejora: §bNivel máximo");
						}
					}else if (leve == 4) {
						if (player.hasPermission("comugames.vip") || player.hasPermission("comugames.elite") || player.hasPermission("comugames.ultimate")) {
							lorelevel.add("§fCosto de mejora: §b50000$");
						}else {
							lorelevel.add("§fCosto de mejora: §bNivel máximo");
						}
					}else if (leve == 5) {
						lorelevel.add("§fCosto de mejora: §bNivel máximo");
					}
					
					lorelevel.add("");
					lorelevel.add("§b¡Haz click para subir de nivel!");
					
					metalevel.setLore(lorelevel);
											
					level.setItemMeta(metalevel);
										
					ItemStack back = new ItemStack(Material.MAGMA_CREAM);
			   	 	ItemMeta back1 = back.getItemMeta();	
			   	 		
					back1.setDisplayName("§aVolver al menú anterior");
					 											
					back.setItemMeta(back1);
					
					join.setItem(10, mif);
					join.setItem(12, enviar);
					join.setItem(14, level);
					join.setItem(16, chest);
			
					join.setItem(31, back);
				 }else {
					 cancel();
				 }
			 }
		}.runTaskTimer(Main.plugin, 0, 2);
		
		player.openInventory(join);	
	}
}
