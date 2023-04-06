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

public class VotacionMenu {
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 27, "Votaciones");

		ItemStack cofres = new ItemStack(Material.CHEST);	
   	 	ItemMeta cofres1 = cofres.getItemMeta();	
		cofres1.setDisplayName("§aVotar cofres");
		 
		ArrayList<String> lore= new ArrayList<String>();
					
		lore.add("§7¡Escoje el nivel de los cofres!");
		lore.add("");
		lore.add("§7Puedes votar entre los cofres:");
		lore.add("   §a- §7OPs");
		lore.add("   §a- §7Normales");
		lore.add("   §a- §7Básicos");
		lore.add("");
		lore.add("§7¡Recuerda que el que tenga");
		lore.add("§7más §avotos §7será el ganador!");
		    	 
		cofres1.setLore(lore);
								
		cofres.setItemMeta(cofres1);
		
		ItemStack clima = new ItemStack(Material.WATER_BUCKET);	
   	 	ItemMeta clima1 = clima.getItemMeta();	
		clima1.setDisplayName("§aVotar clima");
		 
		ArrayList<String> lore1= new ArrayList<String>();
					
		lore1.add("§7¡Escoje el clima de la partida!");
		lore1.add("");
		lore1.add("§7Puedes votar entre el clima:");
		lore1.add("   §a- §7Tormenta");
		lore1.add("   §a- §7Despejado");
		lore1.add("   §a- §7Nevado");
		lore1.add("");
		lore1.add("§7¡Recuerda que el que tenga");
		lore1.add("§7más §avotos §7será el ganador!");
		    	 
		clima1.setLore(lore1);
								
		clima.setItemMeta(clima1);
		
		ItemStack tiempo = Utils.get("347");	
   	 	ItemMeta tiempo1 = clima.getItemMeta();	
		tiempo1.setDisplayName("§aVotar tiempo");
		 
		ArrayList<String> lore2= new ArrayList<String>();
					
		lore2.add("§7¡Escoje el horario de la partida!");
		lore2.add("");
		lore2.add("§7Puedes votar entre el horario:");
		lore2.add("   §a- §7Noche 12PM");
		lore2.add("   §a- §7Atardecer 7PM");
		lore2.add("   §a- §7Mediodía 1PM");
		lore2.add("");
		lore2.add("§7¡Recuerda que el que tenga");
		lore2.add("§7más §avotos §7será el ganador!");
		    	 
		tiempo1.setLore(lore2);
								
		tiempo.setItemMeta(tiempo1);
		
		join.setItem(11, cofres);
		join.setItem(13, clima);
		join.setItem(15, tiempo);		
	
		player.openInventory(join);					
	}
}
