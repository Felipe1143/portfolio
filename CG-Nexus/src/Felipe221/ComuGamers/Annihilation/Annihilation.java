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
package Felipe221.ComuGamers.Annihilation;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scoreboard.Team;

import Felipe221.ComuGamers.Annihilation.Translation;
import Felipe221.ComuGamers.Annihilation.APIs.GameStartEvent;
import Felipe221.ComuGamers.Annihilation.APIs.PhaseChangeEvent;
import Felipe221.ComuGamers.Annihilation.Chat.ChatListener;
import Felipe221.ComuGamers.Annihilation.Chat.ChatUtil;
import Felipe221.ComuGamers.Annihilation.Commands.AnnihilationCommand;
import Felipe221.ComuGamers.Annihilation.Commands.ClassCommand;
import Felipe221.ComuGamers.Annihilation.Commands.DistanceCommand;
import Felipe221.ComuGamers.Annihilation.Commands.MapCommand;
import Felipe221.ComuGamers.Annihilation.Commands.StatsCommand;
import Felipe221.ComuGamers.Annihilation.Commands.TeamCommand;
import Felipe221.ComuGamers.Annihilation.Commands.TeamShortcutCommand;
import Felipe221.ComuGamers.Annihilation.Commands.VoteCommand;
import Felipe221.ComuGamers.Annihilation.Game.GameManager;
import Felipe221.ComuGamers.Annihilation.Game.GameManager.GamePhase;
import Felipe221.ComuGamers.Annihilation.Game.GameManager.GameState;
import Felipe221.ComuGamers.Annihilation.Game.GameScoreboard;
import Felipe221.ComuGamers.Annihilation.Listener.BossListener;
import Felipe221.ComuGamers.Annihilation.Listener.ClassAbilityListener;
import Felipe221.ComuGamers.Annihilation.Listener.CraftingListener;
import Felipe221.ComuGamers.Annihilation.Listener.EnderBrewingStandListener;
import Felipe221.ComuGamers.Annihilation.Listener.EnderChestListener;
import Felipe221.ComuGamers.Annihilation.Listener.EnderFurnaceListener;
import Felipe221.ComuGamers.Annihilation.Listener.PlayerListener;
import Felipe221.ComuGamers.Annihilation.Listener.ResourceListener;
import Felipe221.ComuGamers.Annihilation.Listener.SoulboundListener;
import Felipe221.ComuGamers.Annihilation.Listener.WandListener;
import Felipe221.ComuGamers.Annihilation.Listener.WorldListener;
import Felipe221.ComuGamers.Annihilation.Listeners.PlayerJoinListener;
import Felipe221.ComuGamers.Annihilation.Manager.BossManager;
import Felipe221.ComuGamers.Annihilation.Manager.ConfigManager;
import Felipe221.ComuGamers.Annihilation.Manager.DatabaseManager;
import Felipe221.ComuGamers.Annihilation.Manager.MapManager;
import Felipe221.ComuGamers.Annihilation.Manager.PhaseManager;
import Felipe221.ComuGamers.Annihilation.Manager.RestartHandler;
import Felipe221.ComuGamers.Annihilation.Manager.ScoreboardManager;
import Felipe221.ComuGamers.Annihilation.Manager.VotingManager;
import Felipe221.ComuGamers.Annihilation.Maps.MapRollback;
import Felipe221.ComuGamers.Annihilation.Object.Boss;
import Felipe221.ComuGamers.Annihilation.Object.GameTeam;
import Felipe221.ComuGamers.Annihilation.Object.Kit;
import Felipe221.ComuGamers.Annihilation.Object.PlayerMeta;
import Felipe221.ComuGamers.Annihilation.Object.Shop;
import Felipe221.ComuGamers.Annihilation.Stats.StatType;
import Felipe221.ComuGamers.Annihilation.Stats.StatsManager;

public final class Annihilation extends JavaPlugin {
	private ConfigManager configManager;
	private VotingManager voting;
	private MapManager maps;
	private PhaseManager timer;
	private ResourceListener resources;
	private EnderFurnaceListener enderFurnaces;
	private EnderBrewingStandListener enderBrewingStands;
	private EnderChestListener enderChests;
	private StatsManager stats;
	private ScoreboardManager sb;
	private DatabaseManager db;
	private BossManager boss;
	public static Plugin plugin;

	public static HashMap<String, String> messages = new HashMap<String, String>();

	public int build = 1;
	public int lastJoinPhase = 2;
	public int respawn = 10;

	public boolean runCommand = false;
	public List<String> commands = new ArrayList<String>();

	public String mysqlName = "annihilation";

	@Override
	public void onEnable() {
		plugin = this;
		
		configManager = new ConfigManager(this);
		configManager.loadConfigFiles("config.yml", "maps.yml", "shops.yml", "stats.yml", "messages.yml");

		runCommand = getConfig().contains("commandsToRunAtEndGame");

		if (runCommand) {
			commands = getConfig().getStringList("commandsToRunAtEndGame");
		} else {
			commands = null;
		}

		Configuration shops = configManager.getConfig("shops.yml");
		new Shop(this, "Weapon", shops);
		new Shop(this, "Brewing", shops);

		stats = new StatsManager(this, configManager);
		resources = new ResourceListener(this);
		enderFurnaces = new EnderFurnaceListener(this);
		enderBrewingStands = new EnderBrewingStandListener(this);
		enderChests = new EnderChestListener();
		Configuration config = configManager.getConfig("config.yml");
		timer = new PhaseManager(this, config.getInt("start-delay"), config.getInt("phase-period"));
		voting = new VotingManager(this);
		sb = new ScoreboardManager();
		boss = new BossManager(this);

		PluginManager pm = getServer().getPluginManager();

		File messagesFile = new File("plugins/" + getDescription().getName() + "/messages.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(messagesFile);

		for (String id : yml.getKeys(false)) {
			messages.put(id, yml.getString(id));
		}

		build = this.getConfig().getInt("build", 5);
		lastJoinPhase = this.getConfig().getInt("lastJoinPhase", 2);
		respawn = this.getConfig().getInt("bossRespawnDelay", 10);
		
		MapRollback mapRollback = new MapRollback(getLogger(), getDataFolder());		

		maps = new MapManager(this, mapRollback, configManager.getConfig("maps.yml"));

		pm.registerEvents(resources, this);
		pm.registerEvents(enderFurnaces, this);
		pm.registerEvents(enderBrewingStands, this);
		pm.registerEvents(enderChests, this);
		pm.registerEvents(new ChatListener(this), this);
		pm.registerEvents(new PlayerListener(this), this);
		pm.registerEvents(new WorldListener(), this);
		pm.registerEvents(new SoulboundListener(), this);
		pm.registerEvents(new WandListener(this), this);
		pm.registerEvents(new CraftingListener(), this);
		pm.registerEvents(new ClassAbilityListener(this), this);
		pm.registerEvents(new BossListener(this), this);
		pm.registerEvents(new PlayerJoinListener(), this);

		getCommand("annihilation").setExecutor(new AnnihilationCommand(this));
		getCommand("class").setExecutor(new ClassCommand());
		getCommand("stats").setExecutor(new StatsCommand(stats));
		getCommand("team").setExecutor(new TeamCommand(this));
		getCommand("vote").setExecutor(new VoteCommand(voting));
		getCommand("red").setExecutor(new TeamShortcutCommand());
		getCommand("green").setExecutor(new TeamShortcutCommand());
		getCommand("yellow").setExecutor(new TeamShortcutCommand());
		getCommand("blue").setExecutor(new TeamShortcutCommand());
		getCommand("distance").setExecutor(new DistanceCommand(this));
		getCommand("map").setExecutor(new MapCommand(this, mapRollback));


		String host = "45.35.32.53";
		Integer port = 3306;
		String name = "s2404_Factions";
		String user = "u2404_r81PcBQVVD";
		String pass = "TN6yer1e9JECrs7W";
		db = new DatabaseManager(host, port, name, user, pass, this);

		db.query("CREATE TABLE IF NOT EXISTS `" + mysqlName + "` ( `username` varchar(16) NOT NULL, " + "`kills` int(16) NOT NULL, `deaths` int(16) NOT NULL, `wins` int(16) NOT NULL, " + "`losses` int(16) NOT NULL, `nexus_damage` int(16) NOT NULL, " + "UNIQUE KEY `username` (`username`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;");
		

		if (getServer().getPluginManager().isPluginEnabled("Vault")) {
			VaultHooks.vault = true;
			if (!VaultHooks.instance().setupPermissions()) {
				VaultHooks.vault = false;
				getLogger().warning("--> �Error en los permisos!");
			} else {
				if (!VaultHooks.instance().setupChat()) {
					VaultHooks.vault = false;
					getLogger().warning("--> �Error en el chat!");
				} else {
					getLogger().info("--> VaultAPI hookeado correctamente");
				}
			}
		} else {
			getLogger().warning("--> �Instala Vault!");
		}

		reset();

		ChatUtil.setRoman(getConfig().getBoolean("roman", false));
		
		GameManager.setState(GameState.ESPERANDO);
		GameManager.setPhase(GamePhase.NULL);
		
		for (Player player : Bukkit.getOnlinePlayers()) {
	        if(ScoreboardAPI.hasScore(player)) {
	            ScoreboardAPI.removeScore(player);
	        }
	        
			ScoreboardAPI helper = ScoreboardAPI.createScore(player);
			helper.setTitle("�e�lCOMU�6�lGAMERS");
		}
		
		GameScoreboard.setScoreboard();
	}

	public boolean startTimer() {
		if (timer.isRunning()) {
			return false;
		}

		timer.start();
		GameManager.setState(GameState.INICIANDO);

		return true;
	}

	public void loadMap(final String map) {
		FileConfiguration config = configManager.getConfig("maps.yml");
		ConfigurationSection section = config.getConfigurationSection(map);

		World w = getServer().getWorld(map);
		for (GameTeam team : GameTeam.teams()) {
			String name = team.name().toLowerCase();
			if (section.contains("spawns." + name)) {
				for (String s : section.getStringList("spawns." + name)) {
					team.addSpawn(Util.parseLocation(getServer().getWorld(map), s));
				}
			}
			if (section.contains("nexuses." + name)) {
				Location loc = Util.parseLocation(w, section.getString("nexuses." + name));
				team.loadNexus(loc, 75);
			}
			if (section.contains("furnaces." + name)) {
				Location loc = Util.parseLocation(w, section.getString("furnaces." + name));
				enderFurnaces.setFurnaceLocation(team, loc);
				loc.getBlock().setType(Material.FURNACE);
			}
			if (section.contains("brewingstands." + name)) {
				Location loc = Util.parseLocation(w, section.getString("brewingstands." + name));
				enderBrewingStands.setBrewingStandLocation(team, loc);
				loc.getBlock().setType(Material.BREWING_STAND);
			}
			if (section.contains("enderchests." + name)) {
				Location loc = Util.parseLocation(w, section.getString("enderchests." + name));
				enderChests.setEnderChestLocation(team, loc);
				loc.getBlock().setType(Material.ENDER_CHEST);
			}
		}

		if (section.contains("bosses")) {
			HashMap<String, Boss> bosses = new HashMap<String, Boss>();
			ConfigurationSection sec = section.getConfigurationSection("bosses");
			for (String boss : sec.getKeys(false)) {
				bosses.put(boss, new Boss(boss, sec.getInt(boss + ".hearts") * 2, sec.getString(boss + ".name"), Util.parseLocation(w, sec.getString(boss + ".spawn")), Util.parseLocation(w, sec.getString(boss + ".chest"))));
			}
			boss.loadBosses(bosses);
		}

		if (section.contains("diamonds")) {
			Set<Location> diamonds = new HashSet<Location>();
			for (String s : section.getStringList("diamonds")) {
				diamonds.add(Util.parseLocation(w, s));
			}
			resources.loadDiamonds(diamonds);
		}
	}

	public void startGame() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			for (Player pp : Bukkit.getOnlinePlayers()) {
				p.showPlayer(pp);
				pp.showPlayer(p);
			}
		}

		Bukkit.getPluginManager().callEvent(new GameStartEvent(maps.getCurrentMap()));

		for (Player p : getServer().getOnlinePlayers()) {
			if (PlayerMeta.getMeta(p).getTeam() != GameTeam.NONE) {
				Util.sendPlayerToGame(p, this);
			}
		}

		getServer().getScheduler().runTaskTimer(this, new Runnable() {
			public void run() {
				for (Player p : getServer().getOnlinePlayers()) {
					if (PlayerMeta.getMeta(p).getKit() == Kit.SCOUT) {
						PlayerMeta.getMeta(p).getKit().addScoutParticles(p);
					}
				}
			}
		}, 0L, 1200L);

		getServer().getScheduler().runTaskTimer(this, new Runnable() {
			public void run() {
				for (GameTeam t : GameTeam.values()) {
					if (t != GameTeam.NONE && t.getNexus().isAlive()) {
						Location nexus = t.getNexus().getLocation().clone();
						nexus.add(0.5, 0, 0.5);
						ParticleEffects.sendToLocation(ParticleEffects.ENDER, nexus, 1F, 1F, 1F, 0, 20);
						ParticleEffects.sendToLocation(ParticleEffects.DRIP_LAVA, nexus, 1F, 1F, 1F, 0, 10);
						ParticleEffects.sendToLocation(ParticleEffects.ENCHANTMENT_TABLE, nexus, 1F, 1F, 1F, 0, 20);
					}
				}
			}
		}, 100L, 5L);
	}

	public void advancePhase() {
		ChatUtil.phaseMessage(timer.getPhase());

		if (timer.getPhase() == 2) {
			GameManager.setPhase(GamePhase.II);
			
			boss.spawnBosses();
		}

		if (timer.getPhase() == 3) {
			GameManager.setPhase(GamePhase.III);
			
			resources.spawnDiamonds();
		}
		
		if (timer.getPhase() == 4) {
			GameManager.setPhase(GamePhase.IV);
		}

		Bukkit.getPluginManager().callEvent(new PhaseChangeEvent(timer.getPhase()));
	}

	public void onSecond() {
		long time = timer.getTime();

		if (time == -5L) {
			String winner = voting.getWinner();
			maps.selectMap(winner);
			getServer().broadcastMessage(ChatColor.GREEN + WordUtils.capitalize(winner) + " was chosen!");
			loadMap(winner);

			voting.end();
		}

		if (time == 0L) {
			startGame();			
		}
	}

	public int getPhase() {
		return timer.getPhase();
	}

	public MapManager getMapManager() {
		return maps;
	}

	public StatsManager getStatsManager() {
		return stats;
	}

	public DatabaseManager getDatabaseHandler() {
		return db;
	}

	public ConfigManager getConfigManager() {
		return configManager;
	}

	public int getPhaseDelay() {
		return configManager.getConfig("config.yml").getInt("phase-period");
	}

	public void log(String m, Level l) {
		getLogger().log(l, m);
	}

	public VotingManager getVotingManager() {
		return voting;
	}

	public ScoreboardManager getScoreboardHandler() {
		return sb;
	}

	public void endGame(GameTeam winner) {
		if (winner == null) {
			return;
		}

		ChatUtil.winMessage(winner);
		timer.stop();

		for (Player p : getServer().getOnlinePlayers()) {
			if (PlayerMeta.getMeta(p).getTeam() == winner) {
				stats.incrementStat(StatType.WINS, p);
			}
		}

		long restartDelay = configManager.getConfig("config.yml").getLong("restart-delay");
		RestartHandler rs = new RestartHandler(this, restartDelay);
		rs.start(timer.getTime(), winner.getColor(winner));
	}

	public void reset() {
		maps.reset();
		timer.reset();
		PlayerMeta.reset();
		
		for (Player p : getServer().getOnlinePlayers()) {
			PlayerMeta.getMeta(p).setTeam(GameTeam.NONE);
			p.teleport(maps.getLobbySpawnPoint());
			p.setMaxHealth(20D);
			p.setHealth(20D);
			p.setFoodLevel(20);
			p.setSaturation(20F);
		}

		voting.start();
		
		GameManager.setState(GameState.ESPERANDO);
		GameManager.setPhase(GamePhase.NULL);

		for (Player p : Bukkit.getOnlinePlayers()) {
			for (Player pp : Bukkit.getOnlinePlayers()) {
				p.showPlayer(pp);
				pp.showPlayer(p);
			}
		}

		Bukkit.getScheduler().runTaskLater(this, new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				for (Player p : getServer().getOnlinePlayers()) {
					PlayerInventory inv = p.getInventory();
					inv.setHelmet(null);
					inv.setChestplate(null);
					inv.setLeggings(null);
					inv.setBoots(null);

					p.getInventory().clear();

					for (PotionEffect effect : p.getActivePotionEffects()) {
						p.removePotionEffect(effect.getType());
					}

					p.setLevel(0);
					p.setExp(0);
					p.setSaturation(20F);

					ItemStack selector = new ItemStack(Material.NETHER_STAR);
					ItemMeta itemMeta = selector.getItemMeta();
					itemMeta.setDisplayName("�bKits �7(Click derecho)");
					selector.setItemMeta(itemMeta);
					
					ItemStack maps = new ItemStack(Material.MAP);
					ItemMeta mapsmeta = maps.getItemMeta();
					mapsmeta.setDisplayName("�6Mapas �7(Click derecho)");
					maps.setItemMeta(mapsmeta);
					
					ItemStack teams = new ItemStack(Material.getMaterial(386));
					ItemMeta teamsmeta = teams.getItemMeta();
					teamsmeta.setDisplayName("�eEquipos �7(Click derecho)");
					teams.setItemMeta(teamsmeta);
					
					ItemStack options = new ItemStack(Material.EYE_OF_ENDER);
					ItemMeta optionsmeta = options.getItemMeta();
					optionsmeta.setDisplayName("�aPreferencias �7(Click derecho)");
					options.setItemMeta(optionsmeta);

					p.getInventory().setItem(0, selector);
					p.getInventory().setItem(1, maps);
					p.getInventory().setItem(2, teams);
					p.getInventory().setItem(8, options);

					p.updateInventory();
				}

				checkStarting();
			}
		}, 2L);
	}

	public void checkWin() {
		int alive = 0;
		GameTeam aliveTeam = null;
		for (GameTeam t : GameTeam.teams()) {
			if (t.getNexus().isAlive()) {
				alive++;
				aliveTeam = t;
			}
		}
		if (alive == 1) {
			endGame(aliveTeam);
		}
	}

	public void checkStarting() {
		if (!timer.isRunning()) {
			if (Bukkit.getOnlinePlayers().size() >= getConfig().getInt("requiredToStart"))
				timer.start();
		}
	}

	public BossManager getBossManager() {
		return boss;
	}

	public PhaseManager getPhaseManager() {
		return timer;
	}

	public void listTeams(CommandSender sender) {
		sender.sendMessage(ChatColor.GRAY + "============[ " + ChatColor.DARK_AQUA + "Teams" + ChatColor.GRAY + " ]============");
		sender.sendMessage(ChatColor.GRAY + "===============================");
	}

	@SuppressWarnings("deprecation")
	public void joinTeam(Player player, String team) {
		PlayerMeta meta = PlayerMeta.getMeta(player);
		if (meta.getTeam() != GameTeam.NONE) {
//			player.sendMessage(ChatColor.DARK_AQUA + _("ERROR_PLAYER_NOSWITCHTEAM"));
			return;
		}

		GameTeam target;
		try {
			target = GameTeam.valueOf(team.toUpperCase());
		} catch (IllegalArgumentException e) {
			//player.sendMessage(ChatColor.RED + Translation._("ERROR_GAME_INVALIDTEAM"));
			listTeams(player);
			return;
		}

		if (Util.isTeamTooBig(target) && !player.hasPermission("annihilation.bypass.teamlimit")) {
			//player.sendMessage(ChatColor.RED + _("ERROR_GAME_TEAMFULL"));
			return;
		}

		if (target.getNexus() != null) {
			if (target.getNexus().getHealth() == 0 && getPhase() > 1) {
				//player.sendMessage(ChatColor.RED + _("ERROR_GAME_TEAMNONEXUS"));
				return;
			}
		}

		if (getPhase() > lastJoinPhase && !player.hasPermission("annhilation.bypass.phaselimiter")) {
			player.kickPlayer(ChatColor.RED + "You cannot join the game in this phase!");
			return;
		}

		player.sendMessage(ChatColor.DARK_AQUA + "You joined " + target.coloredName());
		meta.setTeam(target);

		getScoreboardHandler().teams.get(team.toUpperCase()).addPlayer(player);

		if (getPhase() > 0) {
			Util.sendPlayerToGame(player, this);
		}

	}
}
