package Felipe221.EDLB.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import Felipe221.EDLB.Main;
import Felipe221.EDLB.Utils;
import Felipe221.EDLB.Arenas.Arena;
import Felipe221.EDLB.Arenas.ArenaManager;
import Felipe221.EDLB.Kits.Clima;

public class GamesMenu {	
	
		public static void openMenu(Player player) {
			Inventory join = Bukkit.getServer().createInventory(player, 36, "Arenas");
						
			new BukkitRunnable() {
			     public void run() {
			    	 ItemStack olim = Utils.get("160:14");	
						
			    	 ArrayList<String> lore= new ArrayList<String>();
						
			    	 lore.add("§7¡Uff que gran coliseo!");
			    	 lore.add("");
			    	 
			    	 ItemMeta olimpo = olim.getItemMeta();	
						
			    	 if (Arena.ArenaStatus("Olimpo").equals("Espera")) {
			    		 olimpo.setDisplayName("§aMapa olimpo");
			    		 lore.add("§7Estado: §a§lESPERANDO");
			    		 lore.add("§7Jugadores: §a" + ArenaManager.getPlayers("Olimpo") + "/12");
			    		 olim = Utils.get("159:5");
			    	 }else if (Arena.ArenaStatus("Olimpo").equals("En juego")||Arena.ArenaStatus("Olimpo").equals("Reinicio")) {
			    		 olimpo.setDisplayName("§cMapa olimpo");
			    		 lore.add("§7Estado: §C§lEN JUEGO");
			    		 lore.add("§7Jugadores: §c" + ArenaManager.getPlayers("Olimpo") + "/12");
			    		 olim = Utils.get("159:14");
			    	 }else if (Arena.ArenaStatus("Olimpo").equals("Comenzando")) {
				    	 olimpo.setDisplayName("§6Mapa olimpo");
			    		 lore.add("§7Estado: §6§LCOMENZANDO");
			    		 lore.add("§7Jugadores: §6" + ArenaManager.getPlayers("Olimpo") + "/12");
			    		 olim = Utils.get("159:4");
			    	 }
									
			    	 olimpo.setLore(lore);
									
			    	 olim.setItemMeta(olimpo);
			    	 join.setItem(10, olim);
			     }  	     
			}.runTaskTimer(Main.plugin, 0, 20L);
			
			player.openInventory(join);					
		}
}	
