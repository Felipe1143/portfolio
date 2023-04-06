package Felipe221.ComuGamers.Factions.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.Config.ConfigManager;
import Felipe221.ComuGamers.Factions.Faction.KitFaction;

public class FactionKitsMenu {
	public static void openMenu(Player player) {
		FactionMenu.open.put(player, "a1");
		
		Inventory join = Bukkit.getServer().createInventory(player, 45, "§nKits");
		
		OfflinePlayer p = player;
		
		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
		glass.setDurability((short) 14);
		ItemMeta metaglass = glass.getItemMeta();
		
		metaglass.setDisplayName("§cBloqueado §lX");
		
		ArrayList<String> loreglass= new ArrayList<String>();		
					
		loreglass.add("§f");
		loreglass.add("§f¡No tienes comprado este kit!");
		loreglass.add("");
		loreglass.add("§fCosto: §c4000$");
		loreglass.add("§fTú dinero: §c" + (int) Main.getEconomy().getBalance(p)+ "$");
		loreglass.add("§f");
		loreglass.add("§c¡Haz click para comprar este kit!");
		
		metaglass.setLore(loreglass);
								
		glass.setItemMeta(metaglass);	
		
		new BukkitRunnable() {
			 @Override
	         public void run() {
				 if (FactionMenu.open.containsKey(player)) {	
					FPlayer p = FPlayers.getInstance().getByPlayer(player);
			        
					ItemStack mif = new ItemStack(Material.WOOD_PICKAXE);
					ItemMeta meta = mif.getItemMeta();
					
					meta.setDisplayName("§eNovato");
					
					ArrayList<String> lore= new ArrayList<String>();		
					
					lore.add("§fContiene lo necesario para sobrevivir...");
					lore.add("§f");
					lore.add("§fContenido:");
					lore.add("§a  - §fArmadura de hierro");
					lore.add("§a  - §fManzanas x12");
					lore.add("§a  - §fEspada de hierro (Fuego I)");
					lore.add("§a  - §fPico de piedra");
					lore.add("§a  - §fHacha de piedra");
					lore.add("");
					
					if (ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown.novato") == -50 || !ConfigManager.getStats().contains("Jugadores." + player.getName() + ".Cooldown.novato")){
						lore.add("§fEstado: §aDisponible");
						lore.add("");
						lore.add("§b¡Haz click para seleccionar el kit novato!");
					}else {
						lore.add("§fEstado: §aBloqueado");			
						long time = ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown.novato");		
						lore.add("§fTiempo de espera: §a" + KitFaction.timeString(time));
					}
					
					meta.setLore(lore);
											
					mif.setItemMeta(meta);
					
					ItemStack avan = new ItemStack(Material.IRON_CHESTPLATE);
					ItemMeta metaavan = avan.getItemMeta();
					
					metaavan.setDisplayName("§eAvanzado");
					
					ArrayList<String> loreavan= new ArrayList<String>();		
					
					loreavan.add("§f¡Utiliza tús objetos para vencer!");
					loreavan.add("§f");
					loreavan.add("§fContenido:");
					loreavan.add("§a  - §fArmadura de hierro (Protección I)");
					loreavan.add("§a  - §fManzanas doradas x3");
					loreavan.add("§a  - §fEspada de diamante (Filo I)");
					loreavan.add("§a  - §fPico de hierro");
					loreavan.add("§a  - §fHacha de hierro");
					loreavan.add("");
					
					if (ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown.avanzado") == -50 || !ConfigManager.getStats().contains("Jugadores." + player.getName() + ".Cooldown.avanzado")){
						loreavan.add("§fEstado: §aDisponible");
						loreavan.add("");
						loreavan.add("§b¡Haz click para seleccionar el kit avanzado!");
					}else {
						loreavan.add("§fEstado: §aBloqueado");			
						long time = ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown.avanzado");		
						loreavan.add("§fTiempo de espera: §a" + KitFaction.timeString(time));
					}
					
					metaavan.setLore(loreavan);
											
					avan.setItemMeta(metaavan);		
					
					ItemStack coman = new ItemStack(Material.DIAMOND_AXE);
					ItemMeta metacoman = coman.getItemMeta();
					
					metacoman.setDisplayName("§eComandante");
					
					ArrayList<String> lorecoman= new ArrayList<String>();		
					
					lorecoman.add("§f¿Tienes lo necesario para dominar?");
					lorecoman.add("§f");
					lorecoman.add("§fContenido:");
					lorecoman.add("§a  - §fArmadura de hierro (Protección 3)");
					lorecoman.add("§a  - §fManzanas doradas x5");
					lorecoman.add("§a  - §fEspada de diamante (Filo I)");
					lorecoman.add("§a  - §fPico de diamante");
					lorecoman.add("§a  - §fHacha de diamante");
					lorecoman.add("");
					
					if (ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown.comandante") == -50 || !ConfigManager.getStats().contains("Jugadores." + player.getName() + ".Cooldown.comandante")){
						lorecoman.add("§fEstado: §aDisponible");
						lorecoman.add("");
						lorecoman.add("§b¡Haz click para seleccionar el kit comandante!");
					}else {
						lorecoman.add("§fEstado: §aBloqueado");			
						long time = ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown.comandante");		
						lorecoman.add("§fTiempo de espera: §a" + KitFaction.timeString(time));
					}
					
					metacoman.setLore(lorecoman);
											
					coman.setItemMeta(metacoman);		
					
					ItemStack back = new ItemStack(Material.MAGMA_CREAM);
			   	 	ItemMeta back1 = back.getItemMeta();	
			   	 		
					back1.setDisplayName("§aVolver al menú principal");
					 											
					back.setItemMeta(back1);
					
					join.setItem(10, mif);
					
					if (player.hasPermission("kit.avanzado")) {
						join.setItem(11, avan);
					}else {
						join.setItem(11, glass);
					}		
					
					if (player.hasPermission("kit.comandante")) {
						join.setItem(12, coman);
					}else {
						join.setItem(12, glass);
					}		
			
					join.setItem(31, back);
				 }else {
					 cancel();
				 }
			 }
		}.runTaskTimer(Main.plugin, 0, 2);
		
		player.openInventory(join);
	}
}
