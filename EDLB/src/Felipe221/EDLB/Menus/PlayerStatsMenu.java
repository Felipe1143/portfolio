package Felipe221.EDLB.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Felipe221.EDLB.Main;
import Felipe221.EDLB.Stats.PlayersTop;
import Felipe221.EDLB.Stats.StatsAPI;
import Felipe221.EDLB.Stats.StatsType;

public class PlayerStatsMenu {
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 45, "Tús estadisticas");

		ItemStack cofres = new ItemStack(Material.DIAMOND_SWORD);	
   	 	ItemMeta cofres1 = cofres.getItemMeta();	
		cofres1.setDisplayName("§aAsesinatos");
		 
		ArrayList<String> lore= new ArrayList<String>();
              
		lore.add("§7Forma de agregar asesinatos:");
		lore.add("   §a- §7Matar jugadores");
		lore.add("");
		lore.add("§7Tús asesinatos: §a" + StatsAPI.getKills(player));
		    	 
		cofres1.setLore(lore);
								
		cofres.setItemMeta(cofres1);
		

		ItemStack wins = new ItemStack(Material.GOLDEN_APPLE);	
   	 	ItemMeta wins1 = wins.getItemMeta();	
		wins1.setDisplayName("§aPartidas ganadas");
		 
		ArrayList<String> lore1= new ArrayList<String>();
		      
		lore1.add("§7Forma de agregar partidas ganadas:");
		lore1.add("   §a- §7Ganar partidas (cualquier modo)");
		lore1.add("");
		lore1.add("§7Tús partidas ganadas: §a" + StatsAPI.getWins(player));
		
		wins1.setLore(lore1);
		
		wins.setItemMeta(wins1);
		
		ItemStack level = new ItemStack(Material.CHEST);	
   	 	ItemMeta level1 = level.getItemMeta();	
		level1.setDisplayName("§aCofres abiertos");
		 
		ArrayList<String> lore2= new ArrayList<String>();
		
		lore2.add("§7Forma de agregar cofres abiertos:");
		lore2.add("   §a- §7Abrir cofres (cualquier modo)");
		lore2.add("");
		lore2.add("§7Tús cofres abiertos: §a" + StatsType.getStatics(player, "chest"));
		    	 
		level1.setLore(lore2);
								
		level.setItemMeta(level1);
		
		ItemStack muertes = new ItemStack(Material.REDSTONE);	
   	 	ItemMeta muertes1 = muertes.getItemMeta();	
		muertes1.setDisplayName("§aDaño causado");
		 
		ArrayList<String> lore3= new ArrayList<String>();
		
		lore3.add("§7Forma de agregar daño causado:");
		lore3.add("   §a- §7Pegarles a otros jugadores");
		lore3.add("   §a- §7Matar enemigos");
		lore3.add("");
		lore3.add("§7Tú daño causado: §a" + StatsType.getStatics(player, "dmg"));
		    	 
		muertes1.setLore(lore3);
								
		muertes.setItemMeta(muertes1);
		
		ItemStack dmg = new ItemStack(Material.LEATHER_CHESTPLATE);	
   	 	ItemMeta dmgr = dmg.getItemMeta();	
		dmgr.setDisplayName("§aDaño recibido");
		 
		ArrayList<String> lore5= new ArrayList<String>();
		
		lore5.add("§7Forma de agregar daño recibido:");
		lore5.add("   §a- §7Recibir daño de jugadores");
		lore5.add("");
		lore5.add("§7Tú daño recibido: §a" + StatsType.getStatics(player, "dmgrecibido"));
		    	 
		dmgr.setLore(lore5);
								
		dmg.setItemMeta(dmgr);
		
		ItemStack craft = new ItemStack(Material.WORKBENCH);	
   	 	ItemMeta craft1 = craft.getItemMeta();	
		craft1.setDisplayName("§aItems crafteados");
		 
		ArrayList<String> lore6= new ArrayList<String>();
		
		lore6.add("§7Forma de agregar items crafteados:");
		lore6.add("   §a- §7Craftear cualquier item");
		lore6.add("");
		//lore6.add("§7Tús items crafteados: §a" + StatsType.getStatics(player, "crafted"));
		    	 
		craft1.setLore(lore6);
								
		craft.setItemMeta(craft1);
		
		ItemStack nivel = new ItemStack(Material.EXP_BOTTLE);	
   	 	ItemMeta nivel1 = nivel.getItemMeta();	
		nivel1.setDisplayName("§aNivel");
		 
		ArrayList<String> lore7= new ArrayList<String>();
		
		lore7.add("§7Forma de agregar nivel:");
		lore7.add("   §a- §7Ganar partidas");
		lore7.add("   §a- §7Matar jugadores");
		lore7.add("   §a- §7Completar logros");
		lore7.add("");
		lore7.add("§7Tú nivel: §a" + StatsAPI.getLevel(player));
		    	 
		nivel1.setLore(lore7);
								
		nivel.setItemMeta(nivel1);
		
		ItemStack arco = new ItemStack(Material.ARROW);	
   	 	ItemMeta arco1 = arco.getItemMeta();	
		arco1.setDisplayName("§aFlechas disparadas");
		 
		ArrayList<String> lore8= new ArrayList<String>();
		
		lore8.add("§7Forma de agregar flechas disparadas:");
		lore8.add("   §a- §7Lanzar flechas");
		lore8.add("");
		lore8.add("§7Tús flechas disparadas: §a" + StatsAPI.getLauch(player));
		    	 
		arco1.setLore(lore8);
								
		arco.setItemMeta(arco1);
		
		ItemStack volver = new ItemStack(Material.SLIME_BALL);	
   	 	ItemMeta volver1 = volver.getItemMeta();	
		volver1.setDisplayName("§aRegresar");
		 
		ArrayList<String> lore4= new ArrayList<String>();
		
		lore4.add("§7¡Haz click aquí para regresar!");
		lore4.add("§7");
		lore4.add("§7Volverás al menú de §aestadisticas");
		
		volver1.setLore(lore4);
		
		volver.setItemMeta(volver1);
				
		join.setItem(10, cofres);	
		join.setItem(12, wins);
		join.setItem(11, level);
		join.setItem(13, muertes);	
		join.setItem(14, dmg);
		join.setItem(16, arco);
		join.setItem(15, nivel);
		join.setItem(31, volver);
		
		player.openInventory(join);		
	}
}
