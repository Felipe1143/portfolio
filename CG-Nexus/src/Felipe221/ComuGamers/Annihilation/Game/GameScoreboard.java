package Felipe221.ComuGamers.Annihilation.Game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import Felipe221.ComuGamers.Annihilation.ActionAPI;
import Felipe221.ComuGamers.Annihilation.Annihilation;
import Felipe221.ComuGamers.Annihilation.ScoreboardAPI;
import Felipe221.ComuGamers.Annihilation.Game.GameManager.GamePhase;
import Felipe221.ComuGamers.Annihilation.Game.GameManager.GameState;
import Felipe221.ComuGamers.Annihilation.Manager.PhaseManager;
import Felipe221.ComuGamers.Annihilation.Object.GameTeam;
import Felipe221.ComuGamers.Annihilation.Object.PlayerMeta;


public class GameScoreboard {	
	public static PhaseManager phase;
	
	public static void setScoreboard() {
		new BukkitRunnable() {
			 @Override
	         public void run() {
				 for (Player player : Bukkit.getOnlinePlayers()) {						 
					 if(ScoreboardAPI.hasScore(player)) {		
						 if (GameManager.getState() == GameState.ESPERANDO) {
							 ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);  
							 
							 List<String> scoreboard = new ArrayList<>();
						            
							 scoreboard.add("");
							 scoreboard.add("§a> §fSala: §a#1");
							 scoreboard.add("§a> §fTú XP: §a250");
							 scoreboard.add("");
							 scoreboard.add("§fMapas:");
							 scoreboard.add("  §a- §fCoastal §a(0 votos)");
							 scoreboard.add("  §a- §fCanyon§a (0 votos)");
							 scoreboard.add("  §a- §fCherokee§a (0 votos)");
							 scoreboard.add("");
							 scoreboard.add("§a> §fJugadores: §a" + Bukkit.getOnlinePlayers().size() + "/4");
							 scoreboard.add("");
							 scoreboard.add("  §emc.comugamers.com ");
							 
							 helper.setSlotsFromList(scoreboard);
							 
							 ActionAPI.sendAnnouncement(player, "§a> §fJugadores faltantes: §a" + (4 - Bukkit.getOnlinePlayers().size()));
						 }else if (GameManager.getState() == GameState.INICIANDO) {
							 ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);  
							 
							 List<String> scoreboard = new ArrayList<>();
						            
							 scoreboard.add("");
							 scoreboard.add("§a> §fSala: §a#1");
							 scoreboard.add("§a> §fTú XP: §a250");
							 scoreboard.add("");
							 scoreboard.add("§fMapas:");
							 scoreboard.add("  §a- §fCoastal §a(0 votos)");
							 scoreboard.add("  §a- §fCanyon§a (0 votos)");
							 scoreboard.add("  §a- §fCherokee§a (0 votos)");
							 scoreboard.add("");
							 scoreboard.add("§a> §fIniciando en: §a" + PhaseManager.getTimeFal() + "s");
							 scoreboard.add("");
							 scoreboard.add("  §emc.comugamers.com  ");
							 
							 helper.setSlotsFromList(scoreboard);
							 
							 ActionAPI.sendAnnouncement(player, "§a> §fIniciando en: §a" + PhaseManager.getTimeFal() + "s");
						 }else if(GameManager.getState() == GameState.EN_JUEGO) {
							 if (GameManager.getPhase() == GamePhase.I) {
								 ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);  
								 
								 List<String> scoreboard = new ArrayList<>();
							            
								 scoreboard.add("");
								 scoreboard.add("§a> §fMapa: §a#1");
								 scoreboard.add("§a> §fFase: §aI - (" + PhaseManager.timeString(PhaseManager.time)+ ")" );
								 scoreboard.add("");
								 scoreboard.add("§fNexos:");
								 scoreboard.add("  §a- §fVerde:§a 75");
								 scoreboard.add("  §c- §fRojo: §c75");
								 scoreboard.add("  §9- §fAzul: §975");
								 scoreboard.add("  §e- §fAmarillo: §e75");
								 scoreboard.add("");
								 scoreboard.add("§a> §fClase: §a" + PlayerMeta.getMeta(player).getKit().getName());
								 scoreboard.add("");
								 scoreboard.add("  §emc.comugamers.com  ");
								 
								 helper.setSlotsFromList(scoreboard);
								 
								 ActionAPI.sendAnnouncement(player, "§aFase I - " + PhaseManager.timeString(PhaseManager.time));
							 }else if (GameManager.getPhase() == GamePhase.II) {
								 ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);  
								 
								 List<String> scoreboard = new ArrayList<>();
							            
								 scoreboard.add("");
								 scoreboard.add("§a> §fMapa: §a#1");
								 scoreboard.add("§a> §fFase: §aII - (" + PhaseManager.timeString(PhaseManager.time)+ ")" );
								 scoreboard.add("");
								 scoreboard.add("§fNexos:");
								 scoreboard.add("  §a- §fVerde:§a 75");
								 scoreboard.add("  §c- §fRojo: §c75");
								 scoreboard.add("  §9- §fAzul: §975");
								 scoreboard.add("  §e- §fAmarillo: §e75");
								 scoreboard.add("");
								 scoreboard.add("§a> §fClase: §a" + PlayerMeta.getMeta(player).getKit().getName());
								 scoreboard.add("");
								 scoreboard.add("  §emc.comugamers.com  ");
								 
								 helper.setSlotsFromList(scoreboard);
								 
								 ActionAPI.sendAnnouncement(player, "§bFase II - " + PhaseManager.timeString(PhaseManager.time));
							 }else if (GameManager.getPhase() == GamePhase.III) {
								 ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);  
								 
								 List<String> scoreboard = new ArrayList<>();
							            
								 scoreboard.add("");
								 scoreboard.add("§a> §fMapa: §a#1");
								 scoreboard.add("§a> §fFase: §aIII - (" + PhaseManager.timeString(PhaseManager.time)+ ")" );
								 scoreboard.add("");
								 scoreboard.add("§fNexos:");
								 scoreboard.add("  §a- §fVerde:§a 75");
								 scoreboard.add("  §c- §fRojo: §c75");
								 scoreboard.add("  §9- §fAzul: §975");
								 scoreboard.add("  §e- §fAmarillo: §e75");
								 scoreboard.add("");
								 scoreboard.add("§a> §fClase: §a" + PlayerMeta.getMeta(player).getKit().getName());
								 scoreboard.add("");
								 scoreboard.add("  §emc.comugamers.com  ");
								 
								 helper.setSlotsFromList(scoreboard);
								 
								 ActionAPI.sendAnnouncement(player, "§EFase III - " + PhaseManager.timeString(PhaseManager.time));
							 }else if (GameManager.getPhase() == GamePhase.IV) {
								 ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);  
								 
								 List<String> scoreboard = new ArrayList<>();
							            
								 scoreboard.add("");
								 scoreboard.add("§a> §fMapa: §a#1");
								 scoreboard.add("§a> §fFase: §aIV - (" + PhaseManager.timeString(PhaseManager.time)+ ")" );
								 scoreboard.add("");
								 scoreboard.add("§fNexos:");
								 scoreboard.add("  §a- §fVerde:§a 75");
								 scoreboard.add("  §c- §fRojo: §c75");
								 scoreboard.add("  §9- §fAzul: §975");
								 scoreboard.add("  §e- §fAmarillo: §e75");
								 scoreboard.add("");
								 scoreboard.add("§a> §fClase: §a" + PlayerMeta.getMeta(player).getKit().getName());
								 scoreboard.add("");
								 scoreboard.add("  §emc.comugamers.com  ");
								 
								 helper.setSlotsFromList(scoreboard);
								 
								 ActionAPI.sendAnnouncement(player, "§6Fase IV - " + PhaseManager.timeString(PhaseManager.time));
							 }else if (GameManager.getPhase() == GamePhase.IV) {
								 ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);  
								 
								 List<String> scoreboard = new ArrayList<>();
							            
								 scoreboard.add("");
								 scoreboard.add("§a> §fMapa: §a#1");
								 scoreboard.add("§a> §fFase: §aV - (" + PhaseManager.timeString(PhaseManager.time)+ ")" );
								 scoreboard.add("");
								 scoreboard.add("§fNexos:");
								 scoreboard.add("  §a- §fVerde:§a 75");
								 scoreboard.add("  §c- §fRojo: §c75");
								 scoreboard.add("  §9- §fAzul: §975");
								 scoreboard.add("  §e- §fAmarillo: §e75");
								 scoreboard.add("");
								 scoreboard.add("§a> §fClase: §a" + PlayerMeta.getMeta(player).getKit().getName());
								 scoreboard.add("");
								 scoreboard.add("  §emc.comugamers.com  ");
								 
								 helper.setSlotsFromList(scoreboard);
								 
								 ActionAPI.sendAnnouncement(player, "§cFase V - " + PhaseManager.timeString(PhaseManager.time));
							 }
						 }
					 }
				 }
			 }
		}.runTaskTimer(Annihilation.plugin, 20L, 2);
	}
}
