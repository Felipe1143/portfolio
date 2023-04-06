package Felipe221.ComuGamers.Factions.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Felipe221.ComuGamers.Factions.Config.StatsManager;

public class PlayerLoginEvent implements Listener{

	public void onJoin(PlayerJoinEvent e) {
		StatsManager.createStats(e.getPlayer());
	}
}
