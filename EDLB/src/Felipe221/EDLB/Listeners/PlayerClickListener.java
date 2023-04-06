package Felipe221.EDLB.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Felipe221.EDLB.Arenas.ArenaManager;
import Felipe221.EDLB.Kits.Clima;
import Felipe221.EDLB.Kits.Kit;
import Felipe221.EDLB.Menus.CagesMenu;
import Felipe221.EDLB.Menus.EstadisticasMenu;
import Felipe221.EDLB.Menus.GamesMenu;
import Felipe221.EDLB.Menus.OpcionesMenu;
import Felipe221.EDLB.Menus.VotacionMenu;

public class PlayerClickListener implements Listener{
	
	@EventHandler
	public static void VoteItemInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Vot")
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Vot")){			
					VotacionMenu.openMenu(player);
		}
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Opc")
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Opc")){			
					OpcionesMenu.openMenu(player);
		}
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Aren")
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Aren")){			
					event.setCancelled(true);
					GamesMenu.openMenu(player);
		}
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Kit")
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Kit")){			
					Kit.menuKit(player);
		}		
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Caj")
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Caj")){			
					CagesMenu.openMenu(player);
		}		
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Sal")
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Sal")){			
					ArenaManager.RemovePlayer(player, ArenaManager.getPlayerArena(player));
		}	
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Est")
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Est")){			
					EstadisticasMenu.openMenu(player);
		}	
	}		
}
