package Felipe221.ComuGamers.Annihilation.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import Felipe221.ComuGamers.Annihilation.Annihilation;
import Felipe221.ComuGamers.Annihilation.ScoreboardAPI;
import Felipe221.ComuGamers.Annihilation.Game.GameManager;
import Felipe221.ComuGamers.Annihilation.Game.GameManager.GamePhase;
import Felipe221.ComuGamers.Annihilation.Object.PlayerMeta;

public class PlayerJoinListener implements Listener{
	Annihilation plugin;
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		final Player player = e.getPlayer();

		PlayerMeta meta = PlayerMeta.getMeta(player);
		
		ScoreboardAPI helper = ScoreboardAPI.createScore(player);
		helper.setTitle("§e§lCOMU§6§lGAMERS");

		if (meta.isAlive()) {
			player.teleport(meta.getTeam().getRandomSpawn());
		} else {
			PlayerInventory inv = player.getInventory();
			inv.setHelmet(null);
			inv.setChestplate(null);
			inv.setLeggings(null);
			inv.setBoots(null);

			player.getInventory().clear();

			for (PotionEffect effect : player.getActivePotionEffects()) {
				player.removePotionEffect(effect.getType());
			}

			player.setLevel(0);
			player.setExp(0);
			player.setSaturation(20F);

			ItemStack selector = new ItemStack(Material.NETHER_STAR);
			ItemMeta itemMeta = selector.getItemMeta();
			itemMeta.setDisplayName("§bKits §7(Click derecho)");
			selector.setItemMeta(itemMeta);
			
			ItemStack maps = new ItemStack(Material.MAP);
			ItemMeta mapsmeta = maps.getItemMeta();
			mapsmeta.setDisplayName("§6Mapas §7(Click derecho)");
			maps.setItemMeta(mapsmeta);
			
			ItemStack teams = new ItemStack(Material.getMaterial(386));
			ItemMeta teamsmeta = teams.getItemMeta();
			teamsmeta.setDisplayName("§eEquipos §7(Click derecho)");
			teams.setItemMeta(teamsmeta);
			
			ItemStack options = new ItemStack(Material.EYE_OF_ENDER);
			ItemMeta optionsmeta = options.getItemMeta();
			optionsmeta.setDisplayName("§aPreferencias §7(Click derecho)");
			options.setItemMeta(optionsmeta);

			player.getInventory().setItem(0, selector);
			player.getInventory().setItem(1, maps);
			player.getInventory().setItem(2, teams);
			player.getInventory().setItem(8, options);
			
			player.updateInventory();
		}

		plugin.getDatabaseHandler().query("INSERT IGNORE INTO `annihilation` (`username`, `kills`, " + "`deaths`, `wins`, `losses`, `nexus_damage`) VALUES " + "('" + player.getName() + "', '0', '0', '0', '0', '0');");

		if (GameManager.getPhase() == GamePhase.NULL && plugin.getVotingManager().isRunning()) {
			plugin.checkStarting();
		}
	}
}
