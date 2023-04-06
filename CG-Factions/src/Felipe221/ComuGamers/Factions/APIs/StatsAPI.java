package Felipe221.ComuGamers.Factions.APIs;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import Felipe221.ComuGamers.Factions.Config.ConfigManager;

public class StatsAPI implements Listener{	
	ArrayList<Location> placed = new ArrayList<Location>();
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		
		if (!placed.contains(e.getBlockPlaced().getLocation())) {
			if (e.getBlock().getType() == Material.OBSIDIAN) {
				addBlock(player, Material.OBSIDIAN);
			}	
			
			if (e.getBlock().getType() == Material.COBBLESTONE) {
				addBlock(player, Material.COBBLESTONE);
			}	
			
			if (e.getBlock().getType() == Material.BEACON) {
				addBlock(player, Material.BEACON);
			}	
		}
		
		placed.add(e.getBlockPlaced().getLocation());
	}
		
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player player = e.getPlayer();
		
		if (!placed.contains(e.getBlock().getLocation())) {
			if (e.getBlock().getType() == Material.IRON_ORE) {
				addOre(player, Material.IRON_ORE);
			}
			
			if (e.getBlock().getType() == Material.GOLD_ORE) {
				addOre(player, Material.GOLD_ORE);
			}
			
			if (e.getBlock().getType() == Material.DIAMOND_ORE) {
				addOre(player, Material.DIAMOND_ORE);
			}
			
			if (e.getBlock().getType() == Material.EMERALD_ORE) {
				addOre(player, Material.EMERALD_ORE);
			}
			
			if (e.getBlock().getType() == Material.REDSTONE_ORE) {
				addOre(player, Material.REDSTONE_ORE);
			}
		}else {
			placed.remove(e.getBlock().getLocation());
		}
	}

	public static void addOre(Player player, Material type) {
		ConfigManager.getStats().set("Jugadores." + player.getName() + "." + type.toString().toLowerCase(), getOre(player, type) + 1);
				
	    ConfigManager.saveStats();
		
	}
	
	public static void addBlock(Player player, Material type) {
		ConfigManager.getStats().set("Jugadores." + player.getName() + "." + type.toString().toLowerCase(), getOre(player, type) + 1);
				
	    ConfigManager.saveStats();
		
	}
	
	public static int getOre(Player player, Material type) {
		return ConfigManager.getStats().getInt("Jugadores." + player.getName() + "." + type.toString().toLowerCase());
	}
	
	public static int getBlock(Player player, Material type) {
		return ConfigManager.getStats().getInt("Jugadores." + player.getName() + "." + type.toString().toLowerCase());
	}
	
	
		
//		if (getLevel(player) == 5) {
//	         StatsAPI.addLogros(player, 1);
//	         player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
//	         player.sendMessage("§a¡Logro completado!");
//	         player.sendMessage("");
//	         player.sendMessage("§6+1000 Coins");
//	         player.sendMessage("§3+30 XP");
//	         player.sendMessage("");
//	         player.sendMessage("§f¡Completaste el logro §aNIVEL #1§f!");
//	         player.sendMessage("§a¡Felicidades!");
//	         StatsAPI.addLogros(player, 1);
//	         StatsAPI.addCoins(player, 1000);
//	         StatsAPI.addXP(player, 30);	
//		}
//	}
}
