package Felipe221.ComuGamers.Factions.Menus;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.struct.Role;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.Config.ConfigManager;
import Felipe221.ComuGamers.Factions.Faction.ChatFaction;
import Felipe221.ComuGamers.Factions.Faction.EloFaction;
import Felipe221.ComuGamers.Factions.Faction.GeneratorFaction;
import Felipe221.ComuGamers.Factions.Faction.KitFaction;
import Felipe221.ComuGamers.Factions.Faction.KitFaction.KitType;
import Felipe221.ComuGamers.Factions.Menus.Retos.CombatChallenges;
import Felipe221.ComuGamers.Factions.Menus.Retos.MinerChallenges;
import Felipe221.ComuGamers.Factions.War.WarManager;

public class ClickMenu implements Listener{
	public HashMap<Player, String> get = new HashMap<Player, String>();
	public ArrayList<Player> chest = new ArrayList<Player>();
	
	@EventHandler
	public void CloseMenu(InventoryCloseEvent e) {
		if (FactionMenu.open.containsKey(e.getPlayer())) {
			FactionMenu.open.remove(e.getPlayer());
		}		
	}
	
	@EventHandler
	public void PlayerBreakChest(BlockBreakEvent e) {
		Block block = e.getBlock();
		
		if (block.getType() == Material.CHEST) {
			Location chest = block.getLocation();
			
			for (Faction factions : Factions.getInstance().getAllFactions()) {	
				String tag = factions.getTag();
				 
				if (tag.contains("-") || tag.contains("segura") || tag.contains("peligro")) {	
					
				}else {			
					String world = ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Chest.World");
					int x = ConfigManager.getStats().getInt("Facciones." + tag + ".Generadores.Chest.X");
					int y = ConfigManager.getStats().getInt("Facciones." + tag + ".Generadores.Chest.Y");
					int z = ConfigManager.getStats().getInt("Facciones." + tag + ".Generadores.Chest.Z");
					
					Location newchest = new Location(Bukkit.getWorld(world),x,y,z);
					
					if (chest.equals(newchest)) {
			    		ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Chest.World", "Vacio");
			    		ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Chest.X", null);
			    		ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Chest.Y", null);
			    		ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Chest.Z", null);
			    		
			    		GeneratorFaction.time.put(tag, 60);
			    		
			    		ConfigManager.saveStats();
					}
				}
			}
		}
	}
	
	@EventHandler
	public void PlayerClickChest(PlayerInteractEvent event){
		Player player = event.getPlayer();
						 
		Action a = event.getAction();
					
		if (a == Action.RIGHT_CLICK_BLOCK) {
			Block chestItem = event.getClickedBlock();
						
			if (chestItem != null) {
				if (chestItem.getType() == Material.CHEST) {
					if (chest.contains(player)) {
						event.setCancelled(true);
						
						chest.remove(player);
						
						FPlayer mf = FPlayers.getInstance().getByPlayer(player);
						
						String tag = mf.getFaction().getTag();
						
						String world = chestItem.getLocation().getWorld().getName();
						int x = chestItem.getLocation().getBlockX();
						int y = chestItem.getLocation().getBlockY();
						int z = chestItem.getLocation().getBlockZ();
						
						ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Chest.World", world);
						ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Chest.X", x);
						ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Chest.Y", y);
						ConfigManager.getStats().set("Facciones." + tag + ".Generadores.Chest.Z", z);
						
						ConfigManager.saveStats();
						
						player.playSound(player.getLocation(), Sound.ANVIL_USE, 1, 1);
						
						player.sendMessage("§e§l>> §fUbicación de cofre de deposito: §a" + ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Chest.World") + " (X: " + ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Chest.X") + "/Y: " + ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Chest.Y") + "/Z: " + ConfigManager.getStats().getString("Facciones." + tag + ".Generadores.Chest.Z") + ")");
					}
				}
			}
		}
	}
	
	@EventHandler
	public void InteractMenu(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
		
		//MEJORES FACCIONES POR ELO
		if (e.getInventory().getTitle().equals("§nMejores facciones")){
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver al menú prin")) {
				e.setCancelled(true);
	
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionMainMenu.openMenu(player);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Tú facción")){
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
				
				String tag = mf.getFaction().getTag();
				 
				if (tag.contains("-") || tag.contains("segura") || tag.contains("peligro")) {	
					e.setCancelled(true);
				}else {
					e.setCancelled(true);
					
					player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
					player.closeInventory();
					
					FactionMenu.openMenu(player);
				}
			}else {
				e.setCancelled(true);
			}
		}else if (e.getInventory().getTitle().contains("§nRetos")){
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("combate")) {
				e.setCancelled(true);

				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				CombatChallenges.openMenu(player);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("minería")) {
				e.setCancelled(true);

				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				MinerChallenges.openMenu(player);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver al menú prin")) {
				e.setCancelled(true);
	
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionMainMenu.openMenu(player);
			}
		}else if (e.getInventory().getTitle().equals("§nKits")){
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Novat")) {
				e.setCancelled(true);
						
				KitFaction.giveKit(player, KitType.NOVATO);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Avan")) {
				e.setCancelled(true);
						
				KitFaction.giveKit(player, KitType.AVANZADO);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Coman")) {
				e.setCancelled(true);
						
				KitFaction.giveKit(player, KitType.COMANDANTE);
			}else {
				e.setCancelled(true);
				
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
						
				FactionMainMenu.openMenu(player);
			}
		}else if (e.getInventory().getTitle().contains("Jugadores de")){
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver al menú an")) {
				e.setCancelled(true);

				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				if (get.get(player).equals("lista")) {
					FactionListMenu.openMenu(player);						
				}else if (get.get(player).equals("fac")){
					FactionMenu.openMenu(player);
				}else {
					FactionEloMenu.openMenu(player);
				}
			}else {
				e.setCancelled(true);
			}
		}else if (e.getInventory().getTitle().equals("§nGeneradores")){		
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver al menú an")) {	
				e.setCancelled(true);

				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionMenu.openMenu(player);	
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Ubicac")){
				e.setCancelled(true);
				
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);					
				player.closeInventory();
				
				player.sendMessage("§e§l>> §f¡Haz §aclick §fen el §bcofre §fdonde quieres depositar lo generado!");
				chest.add(player);			
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Subir")){
				e.setCancelled(true);
				
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
				Faction faction = mf.getFaction();
				
				OfflinePlayer p1 = player;
				
				int leve = ConfigManager.getStats().getInt("Facciones." + mf.getFaction().getTag() + ".Generadores.Nivel");
				String materia = ConfigManager.getStats().getString("Facciones." + mf.getFaction().getTag() + ".Generadores.Material");
				
				if (leve == 1) {
					if (Main.getEconomy().getBalance(p1) >= 8000) {
						ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Nivel", 2);

						ConfigManager.saveStats();
						
						Main.getEconomy().withdrawPlayer(p1, 8000);
						
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
						
						for (Player players : mf.getFaction().getOnlinePlayers()) {
							players.sendMessage("§c§lSUPREMO >> §f¡El jugador §c" + player.getName() + " §fsubió el generador al nivel §c2§f!");
							
							players.playSound(players.getLocation(), Sound.ANVIL_USE, 1, 1);
						}
						
						player.sendMessage("§a§o- 8000$");
					}else {
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
						
						player.sendMessage("§c§lSUPREMO >> §f¡Debes conseguir §c8000$ §fpara subir de nivel el generador!");
					}
				}else if (leve == 2) {
					if (Main.getEconomy().getBalance(p1) >= 20000) {
						ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Nivel", 3);

						ConfigManager.saveStats();
	
						Main.getEconomy().withdrawPlayer(p1, 20000);
						
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
						
						for (Player players : mf.getFaction().getOnlinePlayers()) {
							players.sendMessage("§c§lSUPREMO >> §f¡El jugador §c" + player.getName() + " §fsubió el generador al nivel §c3§f!");
							
							players.playSound(players.getLocation(), Sound.ANVIL_USE, 1, 1);
						}
						
						player.sendMessage("§a§o- 20000$");
					}else {
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
						
						player.sendMessage("§c§lSUPREMO >> §f¡Debes conseguir §c20000$ §fpara subir de nivel el generador!");
					}
				}else if (leve == 3) {
					if (player.hasPermission("comugamers.vip") || player.hasPermission("comugamers.elite") || player.hasPermission("comugamers.ultimate")) {
						if (Main.getEconomy().getBalance(p1) >= 30000) {
							ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Nivel", 4);
	
							ConfigManager.saveStats();
		
							Main.getEconomy().withdrawPlayer(p1, 30000);
							
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
							
							for (Player players : mf.getFaction().getOnlinePlayers()) {
								players.sendMessage("§c§lSUPREMO >> §f¡El jugador §c" + player.getName() + " §fsubió el generador al nivel §c4§f!");
								
								players.playSound(players.getLocation(), Sound.ANVIL_USE, 1, 1);
							}
							
							player.sendMessage("§a§o- 30000$");
						}else {
							player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
							
							player.sendMessage("§c§lSUPREMO >> §f¡Debes conseguir §c30000$ §fpara subir de nivel el generador!");
						}
					}else {
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
						
						player.sendMessage("§c§lSUPREMO >> §f¡No tienes el rango necesario para hacer esta acción!");
					}
				}else if (leve == 4) {
					if (player.hasPermission("comugamers.vip") || player.hasPermission("comugamers.elite") || player.hasPermission("comugamers.ultimate")) {
						if (Main.getEconomy().getBalance(p1) >= 50000) {
							ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Nivel", 5);
	
							ConfigManager.saveStats();
		
							Main.getEconomy().withdrawPlayer(p1, 50000);
							
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
							
							for (Player players : mf.getFaction().getOnlinePlayers()) {
								players.sendMessage("§c§lSUPREMO >> §f¡El jugador §c" + player.getName() + " §fsubió el generador al nivel §c5§f!");
								
								players.playSound(players.getLocation(), Sound.ANVIL_USE, 1, 1);
							}
							
							player.sendMessage("§a§o- 50000$");
						}else {
							player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
							
							player.sendMessage("§c§lSUPREMO >> §f¡Debes conseguir §c50000$ §fpara subir de nivel el generador!");
						}
					}else {
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
						
						player.sendMessage("§c§lSUPREMO >> §f¡No tienes el rango necesario para hacer esta acción!");
					}
				}			
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Seleccionar")){
				e.setCancelled(true);
				
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
				
				String materia = ConfigManager.getStats().getString("Facciones." + mf.getFaction().getTag() + ".Generadores.Material");	
				int leve = ConfigManager.getStats().getInt("Facciones." + mf.getFaction().getTag() + ".Generadores.Nivel");	
				
				if (materia.equals("iron_ingot")) {
					ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Material", "gold_ingot");
					
					if (leve == 1) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 100);
					}else if (leve == 2) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 90);
					}else if (leve == 3) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 80);
					}else if (leve == 4) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 70);
					}else if (leve == 5) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 60);
					}
				}else if (materia.equals("gold_ingot")) {
					ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Material", "redstone");
					
					if (leve == 1) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 120);
					}else if (leve == 2) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 110);
					}else if (leve == 3) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 100);
					}else if (leve == 4) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 90);
					}else if (leve == 5) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 80);
					}
				}else if (materia.equals("diamond")) {
					ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Material", "obsidian");
					
					if (leve == 1) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 300);
					}else if (leve == 2) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 270);
					}else if (leve == 3) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 250);
					}else if (leve == 4) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 200);
					}else if (leve == 5) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 180);
					}
				}else if (materia.equals("obsidian")) {
					ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Material", "iron_ingot");
					
					if (leve == 1) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 60);
					}else if (leve == 2) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 50);
					}else if (leve == 3) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 40);
					}else if (leve == 4) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 30);
					}else if (leve == 5) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 25);
					}
				}else if (materia.equals("emerald")) {
					ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Material", "diamond");
					
					if (leve == 1) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 350);
					}else if (leve == 2) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 320);
					}else if (leve == 3) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 300);
					}else if (leve == 4) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 260);
					}else if (leve == 5) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 220);
					}
				}else if (materia.equals("redstone")) {
					ConfigManager.getStats().set("Facciones." + mf.getFaction().getTag() + ".Generadores.Material", "emerald");
					
					if (leve == 1) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 550);
					}else if (leve == 2) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 500);
					}else if (leve == 3) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 475);
					}else if (leve == 4) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 420);
					}else if (leve == 5) {
						GeneratorFaction.time.put(mf.getFaction().getTag(), 350);
					}
				}
				
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);			
				
				ConfigManager.saveStats();
			}else {
				e.setCancelled(true);
			}
		}
		
		//LISTA DE FACCIONES
		if (e.getInventory().getTitle().equals("§nLista de facciones")){			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver al menú prin")) {
				e.setCancelled(true);
		
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
					
				FactionMainMenu.openMenu(player);
			}else {
				for(Faction faction : Factions.getInstance().getAllFactions()) {				
					String factiontag = faction.getTag();
					
					String tag = e.getCurrentItem().getItemMeta().getDisplayName().replaceAll("§e", "");
					
					if (tag.equals(factiontag)) {
						e.setCancelled(true);
						
						player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
						player.closeInventory();
							
						FactionPlayersMenu.openMenu(player, tag);
						get.put(player, "lista");
					}
				}
			}
		}else if (e.getInventory().getTitle().equals("§nGuerreros")){
			FPlayer mf = FPlayers.getInstance().getByPlayer(player);
			
			String tag = mf.getFaction().getTag();
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver al menú ante")) {
				e.setCancelled(true);
				
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionWarMenu.openMenu(player);
			}else {
				String title = e.getCurrentItem().getItemMeta().getDisplayName().replaceAll("§e", "");
				
				for(FPlayer players : mf.getFaction().getFPlayers()) {				
					int slot = FactionWarPMenu.list2.get(players);
						
					if (e.getSlot() == slot) {
						if (mf.getRole() == Role.ADMIN) {
							if (WarManager.playersForWar(tag).size() < 5) {
								if (ConfigManager.getStats().getString("Facciones." + tag + ".En guerra." + title).equals("Si")){
									e.setCancelled(true);
									player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);	
										
									ConfigManager.getStats().set("Facciones." + tag + ".En guerra." + title, "No");
							    		
									player.sendMessage("§c§lSUPREMO >> §f¡" + title + "§f ahora §cno participará §fen la próxima guerra!");
									
									for (Player fplayers : Factions.getInstance().getByTag(mf.getFaction().getTag()).getOnlinePlayers()) {
										if (!fplayers.getName().equals(player.getName())) {
											fplayers.sendMessage("§c§lSUPREMO >> §f¡" + title + "§f ahora §cno participará §fen la próxima guerra!");
										}
									}
									
									ConfigManager.saveStats();
								}else {
									e.setCancelled(true);
									player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);	
										
									ConfigManager.getStats().set("Facciones." + tag + ".En guerra." + title, "Si");
							    		
									player.sendMessage("§c§lSUPREMO >> §f¡" + title + "§f ahora §cparticipará §fen la próxima guerra!");
									
									for (Player fplayers : Factions.getInstance().getByTag(mf.getFaction().getTag()).getOnlinePlayers()) {
										if (!fplayers.getName().equals(player.getName())) {
											fplayers.sendMessage("§c§lSUPREMO >> §f¡" + title + "§f ahora §cparticipará §fen la próxima guerra!");
										}
									}
									
									ConfigManager.saveStats();
								}
							}else {
								e.setCancelled(true);
								
								player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);																    		
								player.sendMessage("§e§l>> §f¡Llegaste al límite de §b5 §fguerreros!");
							}
						}else {
							if (title.contains(player.getName())) {
								if (WarManager.playersForWar(tag).size() < 5) {
									if (ConfigManager.getStats().getString("Facciones." + tag + ".En guerra." + player.getName()).equals("Si")){
										e.setCancelled(true);
										player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);	
												
										ConfigManager.getStats().set("Facciones." + tag + ".En guerra." + player.getName(), "No");
											
										player.sendMessage("§c§lSUPREMO >> §f¡Tú participación en guerrra fue §cdesactivada§f!");	
										
										for (Player fplayers : Factions.getInstance().getByTag(mf.getFaction().getTag()).getOnlinePlayers()) {
											if (!fplayers.getName().equals(player.getName())) {
												fplayers.sendMessage("§c§lSUPREMO >> §f¡" + player.getName() + " §cdesactivo §fsu participación en guerra!");
											}
										}
											
										ConfigManager.saveStats();
									}else {
										e.setCancelled(true);
										player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);	
										
										ConfigManager.getStats().set("Facciones." + tag + ".En guerra." + player.getName(), "Si");
											
										player.sendMessage("§c§lSUPREMO >> §f¡Tú participación en guerrra fue §cactivada§f!");
										
										for (Player fplayers : Factions.getInstance().getByTag(mf.getFaction().getTag()).getOnlinePlayers()) {
											if (!fplayers.getName().equals(player.getName())) {
												fplayers.sendMessage("§c§lSUPREMO >> §f¡" + player.getName() + " §cactivo §fsu participación en guerra!");
											}
										}
									    		
										ConfigManager.saveStats();
									}
								}else {
									e.setCancelled(true);
									
									player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);																    		
									player.sendMessage("§e§l>> §f¡Tú facción ya llego al §blímite §fde guerreros!");
								}
							}else {
								e.setCancelled(true);
										
								player.sendMessage("§e§l>> §f¡Solo el §a§lLIDER §fpuede cambiar otro estado de guerra!");
								player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);							
							}																			
						}			
					}
				}			
			}
		}else if (e.getInventory().getTitle().equals("§nGuerras")){
			FPlayer mf = FPlayers.getInstance().getByPlayer(player);
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Guerrero")) {				
				e.setCancelled(true);
					
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
					
				FactionWarPMenu.openMenu(player, mf.getFaction().getTag());
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Enviar")){
				if (mf.getRole() == Role.ADMIN) {
					e.setCancelled(true);
	
					ChatFaction.chat.put(player, "war");
	
					player.sendMessage("§e§l>> §fPor favor, escribe el §anombre §fde la facción enemiga!");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);			
					player.closeInventory();
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§4§l>> §c¡Solo el §lLIDER §cpuede hacer esto!");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver al menú prin")) {
				e.setCancelled(true);
	
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionMainMenu.openMenu(player);
			}else{
				e.setCancelled(true);
			}
		}else if (e.getInventory().getTitle().equals("§nRetos de combate")){
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver")) {
				e.setCancelled(true);
				
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
					
				FactionRetosMenu.openMenu(player);
			}else {
				e.setCancelled(true);
			}
		}else if (e.getInventory().getTitle().equals("§nRetos de minería")){
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver")) {
				e.setCancelled(true);
				
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
					
				FactionRetosMenu.openMenu(player);
			}else {
				e.setCancelled(true);
			}
		}else if (e.getInventory().getTitle().equals("§nMi facción")){
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("modo")){
				if (player.hasPermission("comugamers.vip") || player.hasPermission("comugamers.elite") || player.hasPermission("comugamers.ultimate")) {
					e.setCancelled(true);
					
					FPlayer mf = FPlayers.getInstance().getByPlayer(player);
					
					if (mf.getRole() == Role.ADMIN) {
						player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);		
						
						if (mf.getFaction().isPeaceful() == false) {
							mf.getFaction().setPeaceful(true);
							player.sendMessage("§c§lSUPREMO >> §fNuevo estado de facción: §cPacífico");
							
							for (Player fplayers : Factions.getInstance().getByTag(mf.getFaction().getTag()).getOnlinePlayers()) {
								if (!fplayers.getName().equals(player.getName())) {
									fplayers.sendMessage("§c§lSUPREMO >> §fNuevo estado de tú facción: §cPacífico");
								}
							}
						}else {
							mf.getFaction().setPeaceful(false);
							player.sendMessage("§c§lSUPREMO >> §fNuevo estado de facción: §cProfesional");
							
							for (Player fplayers : Factions.getInstance().getByTag(mf.getFaction().getTag()).getOnlinePlayers()) {
								if (!fplayers.getName().equals(player.getName())) {
									fplayers.sendMessage("§c§lSUPREMO >> §fNuevo estado de tú facción: §cProfesional");
								}
							}
						}
					}else {
						e.setCancelled(true);
						
						player.sendMessage("§4§l>> §c¡Solo el §lLIDER §cpuede hacer esto!");	
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
					}
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§e§l>> §f¡Solo usuarios con §a§lVIP§f, §6§lELITE §fo §b§lULTIMATE §fpueden hacer esto!");	
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Modo")){
				e.setCancelled(true);			
				
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
					
				if (mf.getRole() == Role.ADMIN) {					
					player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);		
					
					if (mf.getFaction().getOpen() == false) {
						mf.getFaction().setOpen(true);
						player.sendMessage("§c§lSUPREMO >> §fNuevo modo de ingreso: §cAbierto");
						
						for (Player fplayers : Factions.getInstance().getByTag(mf.getFaction().getTag()).getOnlinePlayers()) {
							if (!fplayers.getName().equals(player.getName())) {
								fplayers.sendMessage("§c§lSUPREMO >> §fNuevo modo de ingreso de tú facción: §cAbierto");
							}
						}
					}else {
						mf.getFaction().setOpen(false);
						player.sendMessage("§c§lSUPREMO >> §fNuevo modo de ingreso: §cPor invitación");
						
						for (Player fplayers : Factions.getInstance().getByTag(mf.getFaction().getTag()).getOnlinePlayers()) {
							if (!fplayers.getName().equals(player.getName())) {
								fplayers.sendMessage("§c§lSUPREMO >> §fNuevo modo de ingreso de tú facción: §cPor invitación");
							}
						}
					}
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§4§l>> §c¡Solo el §lLIDER §cpuede hacer esto!");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Nombr")) {
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
				
				if (mf.getRole() == Role.ADMIN) {
					e.setCancelled(true);
	
					ChatFaction.chat.put(player, "nombre");
	
					player.sendMessage("§e§l>> §fPor favor, escribe el nuevo §anombre §fde la facción!");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);			
					player.closeInventory();
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§4§l>> §c¡Solo el §lLIDER §cpuede hacer esto!");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Desc")) {
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
				
				if (mf.getRole() == Role.ADMIN) {
					e.setCancelled(true);
	
					ChatFaction.chat.put(player, "desc");
	
					player.sendMessage("§e§l>> §fPor favor, ¡escribe la §adescripción §fde la facción!");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);			
					player.closeInventory();
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§4§l>> §c¡Solo el §lLIDER §cpuede hacer esto!");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Invi")) {
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
				
				if (mf.getRole() == Role.ADMIN || mf.getRole() == Role.COLEADER || mf.getRole() == Role.MODERATOR) {
					e.setCancelled(true);
	
					ChatFaction.chat.put(player, "invi");
	
					player.sendMessage("§e§l>> §fPor favor, escribe el §anombre de usuario §fdel jugador que quieras invitar.");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);			
					player.closeInventory();
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§4§l>> §c¡Solo el §lLIDER - COLIDER - MODERADOR §cpuede hacer esto!");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Sigl")) {
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
				
				if (mf.getRole() == Role.ADMIN || mf.getRole() == Role.COLEADER) {
					e.setCancelled(true);
	
					ChatFaction.chat.put(player, "tag");
	
					player.sendMessage("§e§l>> §fPor favor, ¡escribe las §asiglas §fde la facción! §a(Mínimo 2 letras - Máximo 3 letras)");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);			
					player.closeInventory();
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§4§l>> §c¡Solo el §lLIDER - COLIDER §cpuede hacer esto!");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Salir")) {
				e.setCancelled(true);
				
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);	
				player.performCommand("f leave");
				
				player.closeInventory();
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Volver al menú prin")) {
				e.setCancelled(true);
	
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionMainMenu.openMenu(player);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Miembro")) {
				e.setCancelled(true);
				
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
				player.closeInventory();
				
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);	
				
				get.put(player, "fac");
				FactionPlayersMenu.openMenu(player, mf.getFaction().getTag());
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Generador")) {
				e.setCancelled(true);
				
				player.closeInventory();
				
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);	
				
				FactionGeneratorMenu.openMenu(player);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Eliminar")) {
				FPlayer mf = FPlayers.getInstance().getByPlayer(player);
				
				if (mf.getRole() == Role.ADMIN) {
					e.setCancelled(true);
					
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);	
					player.performCommand("f disband");
					
					player.closeInventory();
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§4§l>> §c¡Solo el §lLIDER §cpuede hacer esto!");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}else {
				e.setCancelled(true);
			}
		}else if (e.getInventory().getTitle().equals("§nFacciones")){
			FPlayer mf = FPlayers.getInstance().getByPlayer(player);
			
			String tag = mf.getFaction().getTag();
			 
			if (tag.contains("-") || tag.contains("segura") || tag.contains("peligro")) {	
				if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Crear")) {
					e.setCancelled(true);
	
					ChatFaction.chat.put(player, "create");
	
					player.sendMessage("§e§l>> §fPor favor, escribe el §anombre §fde tú nueva facción!");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);			
					player.closeInventory();
				}
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eMejores facciones")) {
				e.setCancelled(true);

				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionEloMenu.openMenu(player);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eKits")) {
				e.setCancelled(true);

				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionKitsMenu.openMenu(player);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Guerra")) {		    	
				if (!tag.contains("-")) {
					e.setCancelled(true);
	
					player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
					player.closeInventory();
					
					FactionWarMenu.openMenu(player);
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§e§l>> §fPor favor, primero §acrea §funa facción!");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}				
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eLista de facciones")) {
				if (player.hasPermission("comugamers.ultimate")){
					e.setCancelled(true);
	
					player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
					player.closeInventory();
					
					FactionListMenu.openMenu(player);
				}else {
					e.setCancelled(true);
					
					player.sendMessage("§e§l>> §f¡Solo usuarios con §b§lULTIMATE §fpueden hacer esto!");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				
				}
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eTú facción")) {
				e.setCancelled(true);

				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionMenu.openMenu(player);
			}else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eRetos")) {
				e.setCancelled(true);

				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);					
				player.closeInventory();
				
				FactionRetosMenu.openMenu(player);
			}
		}
	}
}
