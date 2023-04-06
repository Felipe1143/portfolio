package Felipe221.EDLB.Chest;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import Felipe221.EDLB.Arenas.ArenaManager;
import net.md_5.bungee.api.ChatColor;

public class ChestManager implements Listener{

	@EventHandler
	public void onBreak (BlockBreakEvent e) {
		Block block = e.getBlock();
		Player player = e.getPlayer();
		
		String arena = ArenaManager.getPlayerArena(player);
		
		if (ArenaManager.getInGamePlayers(arena).contains(e.getPlayer())) {			
			if (block.getType() == Material.CHEST) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "¡No puedes romper los cofres!");
			}
		}else if (ArenaManager.getEspectadores(arena).contains(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.RED + "¡No puedes romper bloques en modo espectador!");
		}
	}
	
	@EventHandler
	public void onPlace (BlockPlaceEvent e) {
		Block block = e.getBlock();
		Player player = e.getPlayer();
		
		String arena = ArenaManager.getPlayerArena(player);
		
		if (ArenaManager.getInGamePlayers(arena).contains(e.getPlayer())) {			
			if (block.getType() == Material.CHEST) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "¡No puedes colocar los cofres!");
			}
		}else if (ArenaManager.getEspectadores(arena).contains(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.RED + "¡No puedes colocar bloques en modo espectador!");
		}
		
	}
	
}
