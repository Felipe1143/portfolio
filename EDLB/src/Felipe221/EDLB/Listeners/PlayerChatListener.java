package Felipe221.EDLB.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

import Felipe221.EDLB.Main;
import Felipe221.EDLB.Arenas.ArenaManager;
import Felipe221.EDLB.Stats.StatsAPI;

public class PlayerChatListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		String msg = e.getMessage();
		Player player = e.getPlayer();
		String arena = ArenaManager.getPlayerArena(player);
		int level = StatsAPI.getLevel(player);
		
		e.setCancelled(true);
		
		//NO ESTA EN LOBBY
		if (!(ArenaManager.getLobbyPlayers().contains(player))) {
				//SI ESTA EN ESPECTADORES
				if (ArenaManager.getEspectadores(arena).contains(player)) {
					//LISTA DE ESPECTADORES
					for (Player others : ArenaManager.getEspectadores(arena)) {
						if (Main.plugin.getConfig().getString("Jugadores." +player.getName()+ ".Rango").equals("User")) {
							others.sendMessage("§a(" + level + ") §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." +player.getName()+ ".Rango").equals("Owner")) {
							others.sendMessage("§c(" + level + ") §f" + "§C§lOWNER §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." +player.getName()+ ".Rango").equals("Mod")) {
							others.sendMessage("§3(" + level + ") §f" + "§3§lMOD §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." +player.getName()+ ".Rango").equals("Admin")) {
							others.sendMessage("§4(" + level + ") §f" + "§4§lADMIN §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Manager")) {
							others.sendMessage("§5(" + level + ") §f" + "§5§lMANAGER §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Builder")) {
							others.sendMessage("§6(" + level + ") §f" + "§6§lBUILDER §f" + player.getName() + ": " + msg);	
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Developer")) {
							others.sendMessage("§e(" + level + ") §f" + "§e§lDEVELOPER §f" + player.getName() + ": " + msg);	
						}
					}
					//SI NO ESTA EN ESPECTADORES
				}else if (ArenaManager.getInGamePlayers(arena).contains(player) 
						|| ArenaManager.getEsperaPlayers(arena).contains(player)) {
					for (Player others1 : ArenaManager.getListPlayers(arena)) {
						if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("User")) {
							others1.sendMessage("§a(" + level + ") §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Owner")) {
							others1.sendMessage("§c(" + level + ") §f" + "§C§lOWNER §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Mod")) {
							others1.sendMessage("§3(" + level + ") §f" + "§3§lMOD §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Admin")) {
							others1.sendMessage("§4(" + level + ") §f" + "§4§lADMIN §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." +player.getName()+ ".Rango").equals("Manager")) {
							others1.sendMessage("§5(" + level + ") §f" + "§5§lMANAGER §f" + player.getName() + ": " + msg);
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Builder")) {
							others1.sendMessage("§6(" + level + ") §f" + "§6§lBUILDER §f" + player.getName() + ": " + msg);	
						}
						
						if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Developer")) {
							others1.sendMessage("§e(" + level + ") §f" + "§e§lDEVELOPER §f" + player.getName() + ": " + msg);	
						}
					}			
			}
		}else{
			//EN LOBBY
			for (Player others : ArenaManager.getLobbyPlayers()) {				
				if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("User")) {
					others.sendMessage("§a(" + level + ") §f" + player.getName() + ": " + msg);
				}
				
				if (Main.plugin.getConfig().getString("Jugadores." +player.getName()+ ".Rango").equals("Owner")) {
					others.sendMessage("§c(" + level + ") §f" + "§C§lOWNER §f" + player.getName() + ": " + msg);
				}
				
				if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Mod")) {
					others.sendMessage("§3(" + level + ") §f" + "§3§lMOD §f" + player.getName() + ": " + msg);
				}
				
				if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Admin")) {
					others.sendMessage("§4(" + level + ") §f" + "§4§lADMIN §f" + player.getName() + ": " + msg);
				}
				
				if (Main.plugin.getConfig().getString("Jugadores." + player.getName()+ ".Rango").equals("Manager")) {
					others.sendMessage("§5(" + level + ") §f" + "§5§lMANAGER §f" + player.getName() + ": " + msg);
				}
				
				if (Main.plugin.getConfig().getString("Jugadores." +player.getName()+ ".Rango").equals("Builder")) {
					others.sendMessage("§6(" + level + ") §f" + "§6§lBUILDER §f" + player.getName() + ": " + msg);	
				}
				
				if (Main.plugin.getConfig().getString("Jugadores." +player.getName()+ ".Rango").equals("Developer")) {
					others.sendMessage("§e(" + level + ") §f" + "§e§lDEVELOPER §f" + player.getName() + ": " + msg);	
				}
			}
		}
	}

}
