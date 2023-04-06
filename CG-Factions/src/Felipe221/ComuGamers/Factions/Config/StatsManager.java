package Felipe221.ComuGamers.Factions.Config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

import Felipe221.ComuGamers.Factions.Main;

public class StatsManager {
	private static Connection connection;
	
	public enum StatsType{
		DEATHS, KILLS, WARS, WINS, POWER, CLAIMS, FACTION, ARROWS;
	}
	
	public static void createStats(Player player) {
		Main.getDatabaseHandler().query("INSERT IGNORE INTO `Factions` (`username`, `kills`, "
					+ "`deaths`, `wins`, `wars`, `power`, `claims`, `faction`, `arrows` ) VALUES "
					+ "('"
					+ player.getName()
					+ "', '0', '0', '0', '0', '0', '0', '-', '0');");
		
	}
	
	public static int getStatsFrom(Player player, StatsType type) {
		int stat = 0;
		
		try {
			ResultSet rs = Main.getDatabaseHandler().query("SELECT * FROM `Factions` WHERE `username`='"
					+ player.getName() + "'").getResultSet();
					
			while (rs.next()) {
				stat = rs.getInt(type.name().toLowerCase());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			stat = 0;
		}			
		
		return stat;
	}

	public static void upStatsFrom(Player player, StatsType type, int value) {
		int data = getStatsFrom(player, type) + 1;
		Main.getDatabaseHandler().query(
				"UPDATE `Factions` SET `" + type.name().toLowerCase()
				+ "`='" +  + data + "' WHERE `username`='"
				+ player.getName() + "';");
		
	}

	public static int getStatsFrom(String string, StatsType type) {
		int stat = 0;

		try {
			ResultSet rs = Main.getDatabaseHandler().query("SELECT * FROM `Factions` WHERE `username`='"
					+ string + "'").getResultSet();
					
			while (rs.next()) {
				stat = rs.getInt(type.name().toLowerCase());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			stat = 0;
		}
		
		return stat;
	}
}
