package Felipe221.ComuGamers.Factions.Faction;

import java.util.HashMap;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Factions;

import Felipe221.ComuGamers.Factions.Config.ConfigManager;

public class ChatFaction implements Listener{
	public static HashMap<Player, String> chat = new HashMap<Player, String>();
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent e) {
		Player player = e.getPlayer();
		String msg = e.getMessage();
		
		FPlayer fp = FPlayers.getInstance().getByPlayer(player);
		
		if (chat.containsKey(player)){	
			if (chat.get(e.getPlayer()).equals("create")) {
				e.setCancelled(true);
				
				e.getPlayer().performCommand("f create " + msg);
				
				chat.remove(e.getPlayer());
			}else if (chat.get(e.getPlayer()).equals("nombre")) {
				e.setCancelled(true);
				
				e.getPlayer().performCommand("f rename " + msg);	
				
				if (fp.getFaction().getTag().equals(msg)) {
					for (Player fplayers : Factions.getInstance().getByTag(fp.getFaction().getTag()).getOnlinePlayers()) {
						if (!fplayers.getName().equals(e.getPlayer().getName())) {
							fplayers.sendMessage("§c§lSUPREMO >> §fNuevo nombre de tú facción: §c" + msg);
						}
					}
				}
				
				chat.remove(e.getPlayer());
			}else if (chat.get(e.getPlayer()).equals("desc")) {
				e.setCancelled(true);
				
				e.getPlayer().performCommand("f desc " + msg);	
				
				if (fp.getFaction().getDescription().equals(msg)) {
					for (Player fplayers : Factions.getInstance().getByTag(fp.getFaction().getTag()).getOnlinePlayers()) {
						if (!fplayers.getName().equals(e.getPlayer().getName())) {
							fplayers.sendMessage("§c§lSUPREMO >> §fNueva descripción de tú facción:");
							fplayers.sendMessage("§c-> §f" + msg);
						}
					}
				}

				chat.remove(e.getPlayer());
			}else if (chat.get(e.getPlayer()).equals("war")) {
				e.setCancelled(true);
				
				e.getPlayer().performCommand("war duel " + msg);	

				chat.remove(e.getPlayer());
			}else if (chat.get(e.getPlayer()).equals("invi")) {
				e.setCancelled(true);
				
				e.getPlayer().performCommand("f invite " + msg);	

				chat.remove(e.getPlayer());
			}else if (chat.get(e.getPlayer()).equals("tag")) {
				e.setCancelled(true);

				if (msg.length() == 2 || msg.length() == 3) {
					ConfigManager.getStats().set("Facciones." + fp.getFaction().getTag() + ".Siglas", msg.toUpperCase());
		    		ConfigManager.saveStats();
		    		
					e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 1, 1);
					e.getPlayer().sendMessage("§c§lSUPREMO >> §fNuevas siglas de la facción: §c" + msg.toUpperCase());
					
					for (Player fplayers : Factions.getInstance().getByTag(fp.getFaction().getTag()).getOnlinePlayers()) {
						if (!fplayers.getName().equals(e.getPlayer().getName())) {
							fplayers.sendMessage("§c§lSUPREMO >> §fNuevas siglas de tú facción: §c" + msg);
						}
					}
				}else {
					e.getPlayer().sendMessage("§e>> §f¡Utiliza solamente §b3 §fo §b2 §fsiglas!");
					e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.VILLAGER_NO, 1, 1);
				}

				chat.remove(e.getPlayer());
			}
		}
	}
}
