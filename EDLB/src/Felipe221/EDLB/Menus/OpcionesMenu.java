package Felipe221.EDLB.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Felipe221.EDLB.Utils;
import Felipe221.EDLB.Kits.Cages;

public class OpcionesMenu {
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 27, "Opciones");

		ItemStack cofres = new ItemStack(Material.STAINED_GLASS);	
   	 	ItemMeta cofres1 = cofres.getItemMeta();	
		cofres1.setDisplayName("§aEscojer caja");
		 
		ArrayList<String> lore= new ArrayList<String>();
					
		lore.add("§7¡Escoje tú caja de espera!");
		lore.add("");
		lore.add("§7Puedes elegir entre una gran");
		lore.add("§7cantidad de cajas, todas");
		lore.add("§7totalmente distitas.");
		lore.add("");
		lore.add("§7Caja seleccionada: §a" + Cages.getNameCage(player));
		    	 
		cofres1.setLore(lore);
								
		cofres.setItemMeta(cofres1);
		
		ItemStack clima = new ItemStack(Material.ARROW);	
   	 	ItemMeta clima1 = clima.getItemMeta();	
		clima1.setDisplayName("§aEscojer trail");
		 
		ArrayList<String> lore1= new ArrayList<String>();
					
		lore1.add("§7¡Escoje el trail que usarás!");
		lore1.add("");
		lore1.add("§7Puedes elegir entre una gran");
		lore1.add("§7cantidad de trails, todos");
		lore1.add("§7totalmente distitos.");
		lore1.add("");
		lore1.add("§7Trail seleccionado: §aPor defecto");
		    	 
		clima1.setLore(lore1);
								
		clima.setItemMeta(clima1);
		
		ItemStack tiempo = new ItemStack(Material.DIAMOND_SWORD);	
   	 	ItemMeta tiempo1 = clima.getItemMeta();	
		tiempo1.setDisplayName("§aEscojer efecto de asesinato");
		 
		ArrayList<String> lore2= new ArrayList<String>();
					
		lore2.add("§7¡Escoje el efecto que usarás!");
		lore2.add("");
		lore2.add("§7Puedes elegir entre una gran");
		lore2.add("§7cantidad de efectos, todos");
		lore2.add("§7totalmente distitos.");
		lore2.add("");
		lore2.add("§7Efecto seleccionado: §aPor defecto");
		    	 
		tiempo1.setLore(lore2);
								
		tiempo.setItemMeta(tiempo1);
		
		join.setItem(11, cofres);
		join.setItem(13, clima);
		join.setItem(15, tiempo);		
	
		player.openInventory(join);					
	}
}
