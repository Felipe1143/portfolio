package Felipe221.EDLB.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import Felipe221.EDLB.Arenas.ArenaManager;
import net.md_5.bungee.api.ChatColor;

public class PlayerInventoryListener implements Listener{
		
	@EventHandler
	public void Move(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
	    if (ArenaManager.getLobbyPlayers().contains(player)) {
	    	e.setCancelled(true);
			player.updateInventory();
	    }
	    	
	    String arena = ArenaManager.getPlayerArena(player);
	    
	    if (ArenaManager.getEsperaPlayers(arena).contains(player)) {
			e.setCancelled(true);
			player.updateInventory();	
	    }
	}
}
