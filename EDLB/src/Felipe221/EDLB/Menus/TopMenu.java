package Felipe221.EDLB.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Felipe221.EDLB.Main;
import Felipe221.EDLB.Utils;
import Felipe221.EDLB.Stats.PlayersTop;
import Felipe221.EDLB.Stats.StatsAPI;
import net.md_5.bungee.api.ChatColor;

public class TopMenu {
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 45, "Mejores jugadores");

		ItemStack cofres = new ItemStack(Material.DIAMOND_SWORD);	
   	 	ItemMeta cofres1 = cofres.getItemMeta();	
		cofres1.setDisplayName("§aTOP Asesinatos");
		 
		ArrayList<String> lore= new ArrayList<String>();
		
		String[] top = PlayersTop.getTop5();
		
        int score1 = Main.plugin.getConfig().getInt("Jugadores."+top[0]+".Kills");
        int score2 = Main.plugin.getConfig().getInt("Jugadores."+top[1]+".Kills");
        int score3 = Main.plugin.getConfig().getInt("Jugadores."+top[2]+".Kills");
        int score4 = Main.plugin.getConfig().getInt("Jugadores."+top[3]+".Kills");
        int score5 = Main.plugin.getConfig().getInt("Jugadores."+top[4]+".Kills");
        
        
		lore.add("§7¡Asesina y sube al podio!");
		lore.add("");
		lore.add("§7Jugadores con más asesinatos:");
		lore.add("   §a#1 §a" + top[0] + " §7-§a" +" (" + score1 + ")");
		lore.add("   §a#2 §a" + top[1] + " §7-§a" +" (" + score2 + ")");
		lore.add("   §a#3 §a" + top[2] + " §7-§a" +" (" + score3 + ")");
		lore.add("   §a#4 §a" + top[3] + " §7-§a" +" (" + score4 + ")");
		lore.add("   §a#5 §a" + top[4] + " §7-§a" +" (" + score5 + ")");
		lore.add("");
		lore.add("§7Tús asesinatos: §a" + StatsAPI.getKills(player));
		    	 
		cofres1.setLore(lore);
								
		cofres.setItemMeta(cofres1);
		

		ItemStack wins = new ItemStack(Material.GOLDEN_APPLE);	
   	 	ItemMeta wins1 = wins.getItemMeta();	
		wins1.setDisplayName("§aTOP Ganadas");
		 
		ArrayList<String> lore1= new ArrayList<String>();
		
		String[] top1 = PlayersTop.getTopWins5();
		
        int score11 = Main.plugin.getConfig().getInt("Jugadores."+top1[0]+".Wins");
        int score21 = Main.plugin.getConfig().getInt("Jugadores."+top1[1]+".Wins");
        int score31 = Main.plugin.getConfig().getInt("Jugadores."+top1[2]+".Wins");
        int score41 = Main.plugin.getConfig().getInt("Jugadores."+top1[3]+".Wins");
        int score51 = Main.plugin.getConfig().getInt("Jugadores."+top1[4]+".Wins");
        
        
		lore1.add("§7¡Gana partidas y sube al podio!");
		lore1.add("");
		lore1.add("§7Jugadores con más partidas ganadas:");
		lore1.add("   §a#1 §a" + top1[0] + " §7-§a" +" (" + score11 + ")");
		lore1.add("   §a#2 §a" + top1[1] + " §7-§a" +" (" + score21 + ")");
		lore1.add("   §a#3 §a" + top1[2] + " §7-§a" +" (" + score31 + ")");
		lore1.add("   §a#4 §a" + top1[3] + " §7-§a" +" (" + score41 + ")");
		lore1.add("   §a#5 §a" + top1[4] + " §7-§a" +" (" + score51 + ")");
		lore1.add("");
		lore1.add("§7Tús partidas ganadas: §a" + StatsAPI.getWins(player));
		    	 
		wins1.setLore(lore1);
								
		wins.setItemMeta(wins1);
		
		ItemStack level = new ItemStack(Material.EXP_BOTTLE);	
   	 	ItemMeta level1 = level.getItemMeta();	
		level1.setDisplayName("§aTOP Nivel");
		 
		ArrayList<String> lore2= new ArrayList<String>();
		
		String[] top2 = PlayersTop.getTopLevel5();
		
        int score111 = Main.plugin.getConfig().getInt("Jugadores."+top2[0]+".Level");
        int score211 = Main.plugin.getConfig().getInt("Jugadores."+top2[1]+".Level");
        int score311 = Main.plugin.getConfig().getInt("Jugadores."+top2[2]+".Level");
        int score411 = Main.plugin.getConfig().getInt("Jugadores."+top2[3]+".Level");
        int score511 = Main.plugin.getConfig().getInt("Jugadores."+top2[4]+".Level");
        
        
		lore2.add("§7¡Gana nivel y sube al podio!");
		lore2.add("");
		lore2.add("§7Jugadores con más nivel:");
		lore2.add("   §a#1 §a" + top2[0] + " §7-§a" +" (" + score111 + ")");
		lore2.add("   §a#2 §a" + top2[1] + " §7-§a" +" (" + score211 + ")");
		lore2.add("   §a#3 §a" + top2[2] + " §7-§a" +" (" + score311 + ")");
		lore2.add("   §a#4 §a" + top2[3] + " §7-§a" +" (" + score411 + ")");
		lore2.add("   §a#5 §a" + top2[4] + " §7-§a" +" (" + score511 + ")");
		lore2.add("");
		lore2.add("§7Tú nivel: §a" + StatsAPI.getLevel(player));
		    	 
		level1.setLore(lore2);
								
		level.setItemMeta(level1);
		
		ItemStack volver = new ItemStack(Material.SLIME_BALL);	
   	 	ItemMeta volver1 = volver.getItemMeta();	
		volver1.setDisplayName("§aRegresar");
		 
		ArrayList<String> lore3= new ArrayList<String>();
		
		lore3.add("§7¡Haz click aquí para regresar!");
		lore3.add("§7");
		lore3.add("§7Volverás al menú de §aestadisticas");
		
		volver1.setLore(lore3);
		
		volver.setItemMeta(volver1);
				
		join.setItem(13, cofres);	
		join.setItem(11, wins);
		join.setItem(15, level);
		join.setItem(31, volver);
		
		player.openInventory(join);		
	}
}
