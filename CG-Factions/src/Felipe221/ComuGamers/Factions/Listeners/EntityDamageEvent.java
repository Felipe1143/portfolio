package Felipe221.ComuGamers.Factions.Listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import Felipe221.ComuGamers.Factions.Config.StatsManager;
import Felipe221.ComuGamers.Factions.Config.StatsManager.StatsType;

public class EntityDamageEvent implements Listener{

	@EventHandler
	public void onDamageArrow(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
				
			if (e.getCause() == DamageCause.PROJECTILE) {
				Arrow a = (Arrow) e.getDamager();
				
				if (a.getShooter() instanceof Player) {
					Player damager = (Player) a.getShooter();
					
					StatsManager.upStatsFrom(damager, StatsType.ARROWS, 1);
						
					player.playSound(player.getLocation(), Sound.ZOMBIE_METAL, 1, 1);
				}
			}
		}
	}
}
