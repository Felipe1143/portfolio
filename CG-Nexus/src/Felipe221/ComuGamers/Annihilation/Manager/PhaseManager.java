/*******************************************************************************
 * Copyright 2014 stuntguy3000 (Luke Anderson) and coasterman10.
 *  
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 ******************************************************************************/
package Felipe221.ComuGamers.Annihilation.Manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import Felipe221.ComuGamers.Annihilation.ActionAPI;
import Felipe221.ComuGamers.Annihilation.Annihilation;
import Felipe221.ComuGamers.Annihilation.Util;
import Felipe221.ComuGamers.Annihilation.Chat.ChatUtil;
import Felipe221.ComuGamers.Annihilation.Game.GameManager;
import Felipe221.ComuGamers.Annihilation.Game.GameManager.GamePhase;
import Felipe221.ComuGamers.Annihilation.Game.GameManager.GameState;
import Felipe221.ComuGamers.Annihilation.Object.GameTeam;

public class PhaseManager {
	public static long time;
	public static long startTime;
	public static long phaseTime;
	public static int phase;
	public static boolean isRunning;

	public static Annihilation plugin;

	public static int taskID;

	public PhaseManager(Annihilation plugin, int start, int period) {
		this.plugin = plugin;
		startTime = start;
		phaseTime = period;
		phase = 0;
	}

	public void start() {
		if (!isRunning) {
			BukkitScheduler scheduler = plugin.getServer().getScheduler();
			taskID = scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
				public void run() {
					onSecond();
				}
			}, 20L, 20L);
			isRunning = true;
		}
		
		time = -startTime;
	}

	public void stop() {
		if (isRunning) {
			isRunning = false;
			Bukkit.getServer().getScheduler().cancelTask(taskID);
		}
	}

	public void reset() {
		stop();
		time = -startTime;
		phase = 0;
	}

	public long getTime() {
		return time;
	}
	
	public static long getTimeFal() {
		return -time ;
	}

	public static long getRemainingPhaseTime() {
		if (phase == 5) {
			return phaseTime;
		}
		if (phase >= 1) {
			return time % phaseTime;
		}
		return -time;
	}

	public int getPhase() {
		return phase;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public static void onSecond() {
		time++;

		if (getRemainingPhaseTime() == 0) {
			if (GameManager.getPhase() == GamePhase.NULL) {
				GameManager.setPhase(GamePhase.I);
				GameManager.setState(GameState.EN_JUEGO);
			}
			
			if (GameManager.getPhase() == GamePhase.IV) {
				GameManager.setPhase(GamePhase.V);
			}
			
			phase++;
			plugin.advancePhase();
		}

		plugin.onSecond();
	}
	
	public static String timeString(long time) {
		long hours = time / 3600L;
		long minutes = (time - hours * 3600L) / 60L;
		long seconds = time - hours * 3600L - minutes * 60L;
		
		if (hours == 1) {
			return String.format("%02d" + ":" + "%02d" + ":" + "%02d", hours, minutes, seconds).replace("-", "");
		}else {
			return String.format("%02d" + ":" + "%02d", minutes, seconds).replace("-", "");
		}
	}
}
