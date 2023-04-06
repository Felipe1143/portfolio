package Felipe221.ComuGamers.Factions.Faction;

import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.APIs.ActionAPI;
import Felipe221.ComuGamers.Factions.Config.StatsManager;

public class RetosFaction implements Listener{
	public static final String currentColor = "§a&l";
	public static final String totalColor = "§c&l";
	public static final double length = 30;
	  
	public static void dynamicBar(Player p, double currentValue, double startValue){
	     double progress1 = currentValue / startValue * length;

	     String output = currentColor + StringUtils.repeat("\u2665", ( int ) ( progress1 ))
	             + totalColor + StringUtils.repeat("\u2665", ( int ) ( length - progress1 ));

	     ActionAPI.sendActionBar(p, "§f-> " + output + " §f<-" );
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
		if (getPlayerKM(e.getPlayer()) == 100) {
			
		}
		
		if (getPlayerKM(e.getPlayer()) == 250) {
			
		}
		
		if (getPlayerKM(e.getPlayer()) == 500) {
			
		}
		
		if (getPlayerKM(e.getPlayer()) == 750) {
			
		}
		
		if (getPlayerKM(e.getPlayer()) == 1000) {
			
		}
	}
	
	public static double getPlayerKM(Player player) {
		double cm = player.getStatistic(Statistic.WALK_ONE_CM);
		
		double km = cm / 100000;
		
		return km;
	}
	
	public static String getP(int a, int maxA) {
		double b = a;
		
		double c = b / maxA * 100;
		
		DecimalFormat df = new DecimalFormat("####0.00");
		String intf = df.format(c);
		
		return intf;
	}
	
	public static String getPlayerKMinP(Player player, int maxKm) {
		double cm = player.getStatistic(Statistic.WALK_ONE_CM);
		
		double km = cm / 100000;
		
		double f = km / maxKm * 100;
			
		DecimalFormat df = new DecimalFormat("####0.00");
		String intf = df.format(f);
		
		return intf;
	}
	
	public static double getPlayerKillsinP(Player player, int maxKills) {	
		double f = player.getStatistic(Statistic.PLAYER_KILLS);
		
		return f / maxKills * 100;
	}
	
	public static String getPlayerArrowsinP(Player player, int maxArrows) {
		double kills =	StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS);
		
		double f = kills / maxArrows * 100;
			
		DecimalFormat df = new DecimalFormat("####0.0");
		String intf = df.format(f);
		
		return intf;
	}
	
	public static String getPlayerWinsinP(Player player, int maxArrows) {
		double kills =	StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS);
		
		double f = kills / maxArrows * 100;
			
		DecimalFormat df = new DecimalFormat("####0.0");
		String intf = df.format(f);
		
		return intf;
	}
}
