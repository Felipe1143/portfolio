package Felipe221.EDLB.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import Felipe221.EDLB.Main;
import Felipe221.EDLB.ScoreboardAPI;
import Felipe221.EDLB.Arenas.ArenaManager;

public class PlayerLeaveListener implements Listener{
	
	@EventHandler
	public void PlayerLeave (PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
        if(ScoreboardAPI.hasScore(p)) {
            ScoreboardAPI.removeScore(p);

        }      	
        
		if (ArenaManager.getLobbyPlayers().contains(p)) {
			for (Player send : ArenaManager.getLobbyPlayers()) {
				send.sendMessage("§c[-] §f" + p.getName());
			}
		}
		
        String arena = ArenaManager.getPlayerArena(p);
        ArenaManager.RemovePlayer(p, arena);
        
		e.setQuitMessage(null);
	}
}
