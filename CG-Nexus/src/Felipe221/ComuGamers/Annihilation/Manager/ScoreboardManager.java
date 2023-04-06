package Felipe221.ComuGamers.Annihilation.Manager;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import Felipe221.ComuGamers.Annihilation.Object.GameTeam;

public class ScoreboardManager {
	public static Scoreboard sb;
	public static Objective obj;

	public static HashMap<String, Score> scores = new HashMap<String, Score>();
	public static HashMap<String, Team> teams = new HashMap<String, Team>();

	public static void resetScoreboard(String objName) {
		scores.clear();
		teams.clear();

		for (Player p : Bukkit.getOnlinePlayers()) {
			p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		}

		setTeam(GameTeam.RED);
		setTeam(GameTeam.BLUE);
		setTeam(GameTeam.GREEN);
		setTeam(GameTeam.YELLOW);
	}

	public static void setTeam(GameTeam t) {
		teams.put(t.name(), sb.registerNewTeam(t.name()));
		Team sbt = teams.get(t.name());
		sbt.setAllowFriendlyFire(false);
		sbt.setCanSeeFriendlyInvisibles(true);
		sbt.setPrefix(t.color().toString());
	}
}
