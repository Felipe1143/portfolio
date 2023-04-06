package Felipe221.EDLB.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Felipe221.EDLB.Utils;
import Felipe221.EDLB.Stats.StatsAPI;

public class EstadisticasMenu {
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 27, "Estadisticas");

		ItemStack cofres = Utils.get("397:3");
   	 	ItemMeta cofres1 = cofres.getItemMeta();	
		cofres1.setDisplayName("§aTús estadisticas");
		 
		ArrayList<String> lore= new ArrayList<String>();
					
		lore.add("§7¡Mira toda tú información!");
		lore.add("");
		lore.add("§7Aquí podrás ver todo tú progreso");
		lore.add("§7durante tú estadía en el servidor");
		lore.add("§7¡No olvides que siempre puedes");
		lore.add("§7mejorar en todo lo que desees!");
		lore.add("");
		lore.add("§7Tú nivel: §a" + StatsAPI.getLevel(player));
		    	 
		cofres1.setLore(lore);
								
		cofres.setItemMeta(cofres1);
		
		ItemStack clima = new ItemStack(Material.SIGN);	
   	 	ItemMeta clima1 = clima.getItemMeta();	
		clima1.setDisplayName("§aMejores jugadores");
		 
		ArrayList<String> lore1= new ArrayList<String>();
					
		lore1.add("§7¿Tienes lo necesario?");
		lore1.add("");
		lore1.add("§7TOP de jugadores disponibles:");
		lore1.add("   §a- §7Asesinatos");
		lore1.add("   §a- §7Partidas ganadas");
		lore1.add("   §a- §7Nivel");
		lore1.add("");
		lore1.add("§7Los §amejores §7serán recordados...");
		    	 
		clima1.setLore(lore1);
								
		clima.setItemMeta(clima1);
				
		join.setItem(11, cofres);
		join.setItem(15, clima);	
	
		player.openInventory(join);	
	}
}
