package Felipe221.EDLB.Stats;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class StatsType {
	
	public static int getStatics(Player player, String stat) {
		int string = 0;
		
		if (stat.equals("chest")) {
			string = player.getStatistic(Statistic.CHEST_OPENED);			
		}
		
		if (stat.equals("dmg")) {
			string = player.getStatistic(Statistic.DAMAGE_DEALT);			
		}
		
		if (stat.equals("dmgrecibido")) {
			string = player.getStatistic(Statistic.DAMAGE_TAKEN);			
		}
		
		if (stat.equals("crafted")) {
			string = player.getStatistic(Statistic.CRAFT_ITEM);			
		}
		
		return string;
	}
}
