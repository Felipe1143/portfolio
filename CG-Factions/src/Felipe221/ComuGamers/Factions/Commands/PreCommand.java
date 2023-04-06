package Felipe221.ComuGamers.Factions.Commands;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.struct.Role;

import Felipe221.ComuGamers.Factions.Menus.FactionMainMenu;
import Felipe221.ComuGamers.Factions.War.WarManager;
import Felipe221.ComuGamers.Factions.War.WarSystem;
import Felipe221.ComuGamers.Factions.War.WarSystem.WarState;

public class PreCommand implements Listener{

	@EventHandler
	public void onPreCommandEvent(PlayerCommandPreprocessEvent e) {
		Player player = e.getPlayer();
		
		if (e.getMessage().equalsIgnoreCase("/f")){
			e.setCancelled(true);
			
			player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
			FactionMainMenu.openMenu(player);
		}else if (e.getMessage().equalsIgnoreCase("/no")) {
			e.setCancelled(true);
			
			if (WarSystem.invite.containsKey(player)) {				
				String tagenemy = WarSystem.invite.get(player);
							
				for (FPlayer dueñoenemy : Factions.getInstance().getByTag(tagenemy).getFPlayersWhereRole(Role.ADMIN)) {
					dueñoenemy.sendMessage("§e§l>> §f¡La solicitud de §bguerra §ffue §crechazada§f!");
				}
							
				player.sendMessage("§e§l>> §f¡La solicitud de §bguerra §ffue §crechazada§f!");
							
				WarSystem.invite.remove(player);
							
			}else {
				player.sendMessage("§e§l>> §f¡No tienes una §binvitación §fde guerra esperando!");
			}
		}
	}
}
