package Felipe221.ComuGamers.Factions.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import Felipe221.ComuGamers.Factions.Faction.GeneratorFaction;

public class PlayerLeaveEvent implements Listener{

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e){
		Player player = e.getPlayer();
		FPlayer mf = FPlayers.getInstance().getByPlayer(player);
		
		String tag = mf.getFaction().getTag();
		
		if (tag.contains("-") || tag.contains("segura") || tag.contains("peligro")) {	
			 
		}else {
			if (mf.getFaction().getOnlinePlayers().size() == 0) {
				GeneratorFaction.gene.put(tag, "No");
			}else{
				GeneratorFaction.gene.put(tag, "Si");
			}		
		}
	}
}
