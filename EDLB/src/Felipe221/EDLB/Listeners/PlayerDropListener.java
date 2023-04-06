package Felipe221.EDLB.Listeners;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import Felipe221.EDLB.Arenas.ArenaManager;
import net.md_5.bungee.api.ChatColor;

public class PlayerDropListener implements Listener{
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getLobbyPlayers().contains(player)) {
			e.setCancelled(true);
			player.sendMessage(ChatColor.RED + "¡No puedes tirar los objetos!");
		}
		
		String arena = ArenaManager.getPlayerArena(player);
		
		if (ArenaManager.getInGamePlayers(arena).contains(player)) {
			if (ArenaManager.listo.equals("No")) {
				e.setCancelled(true);
				player.sendMessage(ChatColor.RED + "¡No puedes tirar los objetos!");
			}
		}
	}

}
