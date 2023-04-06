package Felipe221.EDLB.Stats;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public enum RankType {
	DEVELOPER, OWNER, USER, ADMIN, MOD, BUILDER, MANAGER;
	
	public static List<Player> developer = new ArrayList<Player>();
	public static List<Player> owner = new ArrayList<Player>();
	public static List<Player> user = new ArrayList<Player>();
	public static List<Player> admin = new ArrayList<Player>();
	public static List<Player> mod = new ArrayList<Player>();
	public static List<Player> builder = new ArrayList<Player>();
	public static List<Player> manager = new ArrayList<Player>();
	
	public static void setRank(RankType rank, Player player) {
		if (rank == RankType.USER) {
			user.add(player);
		}
		
		if (rank == RankType.DEVELOPER) {
			developer.add(player);
		}
		
		if (rank == RankType.OWNER) {
			owner.add(player);
		}
		
		if (rank == RankType.ADMIN) {
			admin.add(player);
		}
		
		if (rank == RankType.MOD) {
			mod.add(player);
		}
		
		if (rank == RankType.BUILDER) {
			builder.add(player);
		}
		
		if (rank == RankType.MANAGER) {
			manager.add(player);
		}		
	}
}
