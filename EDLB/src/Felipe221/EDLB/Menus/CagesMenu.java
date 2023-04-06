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
import Felipe221.EDLB.Stats.StatsAPI;

public class CagesMenu {
	
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 36, "Cajas");
					
		ItemStack amarillo = Utils.get("95:4");			
		ItemMeta meta = amarillo.getItemMeta();	
		meta.setDisplayName("§eCaja amarilla");
		
		ArrayList<String> lore= new ArrayList<String>();
					
		lore.add("§7¡Cambia tú caja de espera!");
		lore.add("");
		lore.add("§7Seleccionando aquí tús cristales");
		lore.add("§7cambiarán a un color §eAmarillo");
		lore.add("§7");
		lore.add("§7Tús puntos: §e" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.amarilla")) {
			lore.add("§7Estado: §e§lDESBLOQUEADO");
		}else {
			lore.add("§7Estado: §e§lBLOQUEADO");
		}
		    	 								
		meta.setLore(lore);
								
		amarillo.setItemMeta(meta);
		
		ItemStack naranja = Utils.get("95:1");			
		ItemMeta meta1 = naranja.getItemMeta();	
		meta1.setDisplayName("§cCaja naranja");
		
		ArrayList<String> lore1= new ArrayList<String>();
					
		lore1.add("§7¡Cambia tú caja de espera!");
		lore1.add("");
		lore1.add("§7Seleccionando aquí tús cristales");
		lore1.add("§7cambiarán a un color §cNaranja");
		lore1.add("§7");
		lore1.add("§7Tús puntos: §c" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.naranja")) {
			lore1.add("§7Estado: §c§lDESBLOQUEADO");
		}else {
			lore1.add("§7Estado: §c§lBLOQUEADO");
		}
		    	 								
		meta1.setLore(lore1);
								
		naranja.setItemMeta(meta1);
		
		ItemStack azul = Utils.get("95:3");			
		ItemMeta meta2 = azul.getItemMeta();	
		meta2.setDisplayName("§bCaja azul claro");
		
		ArrayList<String> lore3= new ArrayList<String>();
					
		lore3.add("§7¡Cambia tú caja de espera!");
		lore3.add("");
		lore3.add("§7Seleccionando aquí tús cristales");
		lore3.add("§7cambiarán a un color §BAzul claro");
		lore3.add("§7");
		lore3.add("§7Tús puntos: §b" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.azulclaro")) {
			lore3.add("§7Estado: §b§lDESBLOQUEADO");
		}else {
			lore3.add("§7Estado: §b§lBLOQUEADO");
		}
		    	 								
		meta2.setLore(lore3);
								
		azul.setItemMeta(meta2);
		
		ItemStack violeta = Utils.get("95:2");			
		ItemMeta meta3 = violeta.getItemMeta();	
		meta3.setDisplayName("§5Caja violeta");
		
		ArrayList<String> lore2= new ArrayList<String>();
					
		lore2.add("§7¡Cambia tú caja de espera!");
		lore2.add("");
		lore2.add("§7Seleccionando aquí tús cristales");
		lore2.add("§7cambiarán a un color §5Violeta");
		lore2.add("§7");
		lore2.add("§7Tús puntos: §5" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.violeta")) {
			lore2.add("§7Estado: §5§lDESBLOQUEADO");
		}else {
			lore2.add("§7Estado: §5§lBLOQUEADO");
		}
		    	 								
		meta3.setLore(lore2);
								
		violeta.setItemMeta(meta3);
		
		ItemStack verdeclaro = Utils.get("95:5");			
		ItemMeta meta4 = verdeclaro.getItemMeta();	
		meta4.setDisplayName("§aCaja verde claro");
		
		ArrayList<String> lore4= new ArrayList<String>();
					
		lore4.add("§7¡Cambia tú caja de espera!");
		lore4.add("");
		lore4.add("§7Seleccionando aquí tús cristales");
		lore4.add("§7cambiarán a un color §aVerde claro");
		lore4.add("§7");
		lore4.add("§7Tús puntos: §a" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.verdec")) {
			lore4.add("§7Estado: §a§lDESBLOQUEADO");
		}else {
			lore4.add("§7Estado: §a§lBLOQUEADO");
		}
		    	 								
		meta4.setLore(lore4);
								
		verdeclaro.setItemMeta(meta4);
		
		ItemStack rojo = Utils.get("95:14");			
		ItemMeta meta5 = rojo.getItemMeta();	
		meta5.setDisplayName("§cCaja roja");
		
		ArrayList<String> lore5= new ArrayList<String>();
					
		lore5.add("§7¡Cambia tú caja de espera!");
		lore5.add("");
		lore5.add("§7Seleccionando aquí tús cristales");
		lore5.add("§7cambiarán a un color §cRojo");
		lore5.add("§7");
		lore5.add("§7Tús puntos: §c" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.rojo")) {
			lore5.add("§7Estado: §c§lDESBLOQUEADO");
		}else {
			lore5.add("§7Estado: §c§lBLOQUEADO");
		}
		    	 								
		meta5.setLore(lore5);
								
		rojo.setItemMeta(meta5);
		
		ItemStack azul2 = Utils.get("95:11");			
		ItemMeta meta6 = azul2.getItemMeta();	
		meta6.setDisplayName("§3Caja azul");
		
		ArrayList<String> lore6= new ArrayList<String>();
					
		lore6.add("§7¡Cambia tú caja de espera!");
		lore6.add("");
		lore6.add("§7Seleccionando aquí tús cristales");
		lore6.add("§7cambiarán a un color §3Azul");
		lore6.add("§7");
		lore6.add("§7Tús puntos: §3" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.azul")) {
			lore6.add("§7Estado: §3§lDESBLOQUEADO");
		}else {
			lore6.add("§7Estado: §3§lBLOQUEADO");
		}
		    	 								
		meta6.setLore(lore6);
								
		azul2.setItemMeta(meta6);
		
		ItemStack cian = Utils.get("95:11");			
		ItemMeta meta7 = cian.getItemMeta();	
		meta7.setDisplayName("§9Caja cian");
		
		ArrayList<String> lore7= new ArrayList<String>();
					
		lore7.add("§7¡Cambia tú caja de espera!");
		lore7.add("");
		lore7.add("§7Seleccionando aquí tús cristales");
		lore7.add("§7cambiarán a un color §9Cian");
		lore7.add("§7");
		lore7.add("§7Tús puntos: §9" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.cian")) {
			lore7.add("§7Estado: §9§lDESBLOQUEADO");
		}else {
			lore7.add("§7Estado: §9§lBLOQUEADO");
		}
		    	 								
		meta7.setLore(lore7);
								
		cian.setItemMeta(meta7);
		
		ItemStack blanco = new ItemStack(Material.STAINED_GLASS);			
		ItemMeta meta8 = blanco.getItemMeta();	
		meta8.setDisplayName("§fCaja blanca");
		
		ArrayList<String> lore8= new ArrayList<String>();
					
		lore8.add("§7¡Cambia tú caja de espera!");
		lore8.add("");
		lore8.add("§7Seleccionando aquí tús cristales");
		lore8.add("§7cambiarán a un color §fBlanco");
		lore8.add("§7");
		lore8.add("§7Tús puntos: §f" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.blanca")) {
			lore8.add("§7Estado: §f§lDESBLOQUEADO");
		}else {
			lore8.add("§7Estado: §f§lBLOQUEADO");
		}
		    	 								
		meta8.setLore(lore8);
								
		blanco.setItemMeta(meta8);
		
		ItemStack vere = Utils.get("95:13");		
		ItemMeta meta9 = vere.getItemMeta();	
		meta9.setDisplayName("§aCaja verde");
		
		ArrayList<String> lore9= new ArrayList<String>();
					
		lore9.add("§7¡Cambia tú caja de espera!");
		lore9.add("");
		lore9.add("§7Seleccionando aquí tús cristales");
		lore9.add("§7cambiarán a un color §aVerde");
		lore9.add("§7");
		lore9.add("§7Tús puntos: §a" + StatsAPI.getCoins(player));
		if (player.hasPermission("caja.verde")) {
			lore9.add("§7Estado: §a§lDESBLOQUEADO");
		}else {
			lore9.add("§7Estado: §a§lBLOQUEADO");
		}
		    	 								
		meta9.setLore(lore9);
								
		vere.setItemMeta(meta9);
		
		join.setItem(10, amarillo);
		join.setItem(11, naranja);
		join.setItem(12, violeta);
		join.setItem(13, azul);
		join.setItem(14, verdeclaro);
		join.setItem(15, rojo);
		join.setItem(16, azul2);
		join.setItem(19, cian);
		join.setItem(20, blanco);
		join.setItem(21, vere);

		player.openInventory(join);					
	}
}
