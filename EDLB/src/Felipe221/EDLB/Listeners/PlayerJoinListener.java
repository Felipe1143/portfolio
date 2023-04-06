package Felipe221.EDLB.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Felipe221.EDLB.Main;
import Felipe221.EDLB.ScoreboardAPI;
import Felipe221.EDLB.Arenas.ArenaManager;
import Felipe221.EDLB.Kits.Cages;
import Felipe221.EDLB.Sign.SignManager;
import Felipe221.EDLB.Stats.RankType;
import Felipe221.EDLB.Stats.StatsAPI;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoinListener implements Listener{
	public Main plugin;
	static StatsAPI stats;
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
        ScoreboardAPI helper = ScoreboardAPI.createScore(p);
        helper.setTitle("&e&lSKYWARS");
        
		ArenaManager.getLobbyPlayers().add(p);
		
		p.setMaxHealth(20);
		p.setHealth(20);
		p.setGameMode(GameMode.SURVIVAL);
		p.setLevel(0);
		p.setFoodLevel(20);
							
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);	
		
		p.getInventory().clear();
		
		ItemStack games = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta games2 = games.getItemMeta();
			
		games2.setDisplayName("§eArenas §7(Click derecho)");			               				
		games.setItemMeta(games2);
			
		ItemStack shop = new ItemStack(Material.NETHER_STAR);
		ItemMeta shop2 = shop.getItemMeta();
			
		shop2.setDisplayName("§bTienda §7(Click derecho)");			               
			
		shop.setItemMeta(shop2);
		
		ItemStack shop1 = new ItemStack(Material.SLIME_BALL);
		ItemMeta shop21 = shop1.getItemMeta();
			
		shop21.setDisplayName("§aVanidad §7(Click derecho)");			               
			
		shop1.setItemMeta(shop21);
		
		ItemStack stats = new ItemStack(Material.PAPER);
		ItemMeta stats1 = stats.getItemMeta();
			
		stats1.setDisplayName("§6Estadisticas §7(Click derecho)");			               
			
		stats.setItemMeta(stats1);
			
		p.getInventory().setItem(0, games);
		p.getInventory().setItem(1, stats);
		p.getInventory().setItem(4, shop);
		p.getInventory().setItem(8, shop1);
		
		p.teleport(new Location(Bukkit.getWorld("Lobby"), 167, 176, -201, -0.1F, -16F));
		
		p.sendTitle("§e§lSKYWARS", "§f¡Disfruta del servidor!");		
		
		if (!Main.plugin.getConfig().contains("Jugadores." + p.getName()+ ".XP")){			
		    Main.plugin.getConfig().addDefault("Jugadores." + p.getName() + ".XP", 0);
		    Main.plugin.getConfig().addDefault("Jugadores." + p.getName() + ".Level", 0);
		    Main.plugin.getConfig().addDefault("Jugadores." + p.getName() + ".Coins", 200);
		    Main.plugin.getConfig().addDefault("Jugadores." + p.getName() + ".Kills", 0);
		    Main.plugin.getConfig().addDefault("Jugadores." + p.getName() + ".Wins", 0);
		    Main.plugin.getConfig().addDefault("Jugadores." + p.getName() + ".Disparos", 0);

		    Main.plugin.getConfig().options().copyDefaults();
		    Main.plugin.getConfig().options().copyDefaults(true);
		    
		    Main.plugin.saveConfig();
		}
		
		Cages.setCageList(p);
		
		Cages.normal.add(p);
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Amarilla") {
			Cages.amarilla.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Blanca") {
			Cages.blanca.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Naranja") {
			Cages.naranja.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Violeta") {
			Cages.violeta.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Azul claro") {
			Cages.azulclaro.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." +p.getName() + ".Caja") == "Verde claro") {
			Cages.verdeclaro.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Rosa") {
			Cages.rosa.add(p);
		}	
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Gris") {
			Cages.gris.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Gris oscuro") {
			Cages.grisoscuro.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Cian") {
			Cages.cian.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Purpura") {
			Cages.purpura.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Azul") {
			Cages.azul.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Marron") {
			Cages.marron.add(p);
		}	
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Verde") {
			Cages.verde.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Roja") {
			Cages.roja.add(p);
		}		
		
		if (Main.plugin.getConfig().get("Jugadores." + p.getName() + ".Caja") == "Negra") {
			Cages.negra.add(p);
		}		
		
		setRank(p);
			
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");			
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");			
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");			
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		
		e.setJoinMessage(null);
		for (Player send : ArenaManager.getLobbyPlayers()) {
			send.sendMessage("§a[+] §f" + p.getName());
		}
	}
	
	public void setRank(Player p) {
		if (!Main.plugin.getConfig().contains("Jugadores." + p.getName()+ ".Rango")){
			if (p.hasPermission("rango.mod")) {
				RankType.setRank(RankType.MOD, p);
				Main.plugin.getConfig().set("Jugadores." + p.getName()+ ".Rango", "Mod");
			    Main.plugin.saveConfig();
			}
			
			if (p.hasPermission("rango.admin")) {
				RankType.setRank(RankType.ADMIN, p);
				Main.plugin.getConfig().set("Jugadores." + p.getName()+ ".Rango", "Admin");
			    Main.plugin.saveConfig();
			}
			
			if (p.hasPermission("rango.developer")) {
				RankType.setRank(RankType.DEVELOPER, p);
				Main.plugin.getConfig().set("Jugadores." +p.getName()+ ".Rango", "Developer");
			    Main.plugin.saveConfig();
			}
			
			if (p.hasPermission("rango.owner")) {
				RankType.setRank(RankType.OWNER, p);
				Main.plugin.getConfig().set("Jugadores." +p.getName()+ ".Rango", "Owner");
			    Main.plugin.saveConfig();
			}
			
			if (p.hasPermission("rango.manager")) {
				RankType.setRank(RankType.MANAGER, p);
				Main.plugin.getConfig().set("Jugadores." + p.getName()+ ".Rango", "Manager");
			    Main.plugin.saveConfig();
			}
			
			if (p.hasPermission("rango.builder")) {
				RankType.setRank(RankType.BUILDER, p);
				Main.plugin.getConfig().set("Jugadores." + p.getName()+ ".Rango", "Builder");
			    Main.plugin.saveConfig();
			}
					
			if (!p.hasPermission("rango.mod") && 
					!p.hasPermission("rango.admin") && 
					!p.hasPermission("rango.owner") && 
					!p.hasPermission("rango.developer") && 
					!p.hasPermission("rango.builder") && 
					!p.hasPermission("rango.manager")) {
					RankType.setRank(RankType.USER, p);
					Main.plugin.getConfig().set("Jugadores." + p.getName()+ ".Rango", "User");
				    Main.plugin.saveConfig();
			}
		}
	}
}
	

