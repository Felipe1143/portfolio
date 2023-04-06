package Felipe221.EDLB.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Felipe221.EDLB.Main;
import Felipe221.EDLB.Arenas.Arena;
import Felipe221.EDLB.Arenas.ArenaManager;
import Felipe221.EDLB.Kits.Kit;
import Felipe221.EDLB.Menus.GamesMenu;
import Felipe221.EDLB.Stats.PlayersTop;
import Felipe221.EDLB.Stats.StatsAPI;
import net.md_5.bungee.api.ChatColor;

public class SkywarsCommand implements CommandExecutor {
	static StatsAPI stats;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		Player player = (Player) sender;
		if (alias.equalsIgnoreCase("join")){
			if (args[0].equalsIgnoreCase("olimpo")) {			
				ArenaManager.PlayerAdd(player, "Olimpo");
			}else if (args[0].equalsIgnoreCase("start")) {
				if (ArenaManager.getPlayers("Olimpo") >= 1) {
					ArenaManager.startGame("Olimpo");
				}else {
					player.sendMessage(ChatColor.RED + "¡No puedes iniciar una partida sin un jugador!");
				}
			}else if (args[0].equalsIgnoreCase("top")) {
				String[] top = PlayersTop.getTop5();
	            int score1 = Main.plugin.getConfig().getInt("Jugadores."+top[0]+".Kills");
	            int score2 = Main.plugin.getConfig().getInt("Jugadores."+top[1]+".Kills");
	            int score3 = Main.plugin.getConfig().getInt("Jugadores."+top[2]+".Kills");
	            int score4 = Main.plugin.getConfig().getInt("Jugadores."+top[3]+".Kills");
	            int score5 = Main.plugin.getConfig().getInt("Jugadores."+top[4]+".Kills");
	            player.sendMessage(ChatColor.GREEN + "#1 " + ChatColor.WHITE + top[0] + ChatColor.GREEN + " " + score1);
	            player.sendMessage(ChatColor.GREEN + "#2 " + ChatColor.WHITE + top[1] + ChatColor.GREEN + " " + score2);
	            player.sendMessage(ChatColor.GREEN + "#3 " + ChatColor.WHITE + top[2] + ChatColor.GREEN + " " + score3);
	            player.sendMessage(ChatColor.GREEN + "#4 " + ChatColor.WHITE + top[3] + ChatColor.GREEN + " " + score4);
	            player.sendMessage(ChatColor.GREEN + "#5 " + ChatColor.WHITE + top[4] + ChatColor.GREEN + " " + score5);
	                 
			}else if (args[0].equalsIgnoreCase("arena")) {
				GamesMenu.openMenu(player);			
			}else if (args[0].equalsIgnoreCase("kill")) {
				StatsAPI.addKills(player, 1);
				player.sendMessage("Kills: " + StatsAPI.getKills(player));
			}			
		}
		
		if (alias.equalsIgnoreCase("estado")){
			if (args.length == 0) {			
				player.sendMessage("§fMapas:");				
				
				if (Arena.ArenaStatus("Olimpo").equalsIgnoreCase("Espera")) {
					player.sendMessage("§e   - §fOlimpo: §e§lESPERA §f- §e(" + ArenaManager.getPlayers("Olimpo") + "/12)");
				}else if (Arena.ArenaStatus("Olimpo").equalsIgnoreCase("En juego")) {
					player.sendMessage("§e   - §fOlimpo: §e§lEN JUEGO §f- §e(" + ArenaManager.getPlayers("Olimpo") + "/12)");
				}else if (Arena.ArenaStatus("Olimpo").equalsIgnoreCase("Reinicio")) {
					player.sendMessage("§e   - §fOlimpo: §e§lREINICIO §f- §e(" + ArenaManager.getPlayers("Olimpo") + "/12)");
				}else if (Arena.ArenaStatus("Olimpo").equalsIgnoreCase("Error")) {
					player.sendMessage("§e   - §fOlimpo: §e§lERROR §f- §e(" + ArenaManager.getPlayers("Olimpo") + "/12)");
				}
				player.sendMessage("§fKit:");
				if (Kit.getKit(player) == Kit.PRINCIPIANTE) {
					player.sendMessage("§e   - §fPrincipiante: §e§lON");
				}else if (Kit.getKit(player) == Kit.VIP) {
					player.sendMessage("§e   - §FVIP: §e§lON");
				}
			}
		}
		
		if (alias.equalsIgnoreCase("leave")){
			if (args.length == 0) {			
				String arena = ArenaManager.getPlayerArena(player);
				
				ArenaManager.RemovePlayer(player, arena);			
			}
		}
		return false;
	}
}
