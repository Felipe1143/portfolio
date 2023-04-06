package Felipe221.EDLB;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import Felipe221.EDLB.Arenas.Arena;
import Felipe221.EDLB.Arenas.ArenaManager;
import Felipe221.EDLB.Chest.ChestFilled;
import Felipe221.EDLB.Chest.ChestManager;
import Felipe221.EDLB.Commands.SkywarsCommand;
import Felipe221.EDLB.Kits.Cages;
import Felipe221.EDLB.Kits.Clima;
import Felipe221.EDLB.Kits.Kit;
import Felipe221.EDLB.Listeners.PlayerChatListener;
import Felipe221.EDLB.Listeners.PlayerClickListener;
import Felipe221.EDLB.Listeners.PlayerDropListener;
import Felipe221.EDLB.Listeners.PlayerInventoryListener;
import Felipe221.EDLB.Listeners.PlayerJoinListener;
import Felipe221.EDLB.Listeners.PlayerLeaveListener;
import Felipe221.EDLB.Menus.CagesMenu;
import Felipe221.EDLB.Menus.EstadisticasMenu;
import Felipe221.EDLB.Menus.PlayerStatsMenu;
import Felipe221.EDLB.Menus.TopMenu;
import Felipe221.EDLB.Sign.SignManager;
import Felipe221.EDLB.Stats.StatsAPI;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	public static Plugin plugin;
	public FileConfiguration config = getConfig();
	
	public void onEnable() {
		plugin = this;
		
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(this, this); 
		pm.registerEvents(new PlayerJoinListener(), this); 
		pm.registerEvents(new PlayerInventoryListener(), this); 
		pm.registerEvents(new PlayerLeaveListener(), this); 
		pm.registerEvents(new PlayerDropListener(), this); 
		pm.registerEvents(new PlayerClickListener(), this); 
		pm.registerEvents(new PlayerChatListener(), this); 
		
		pm.registerEvents(new ChestFilled(), this); 
		pm.registerEvents(new ChestManager(), this); 		
		
		pm.registerEvents(new SignManager(), this); 
		
		
		pm.registerEvents(new ArenaManager(), this); 
		
		SignManager.updateAll();
		new BukkitRunnable() {
		     public void run() {
		    	 for(Player player : Bukkit.getOnlinePlayers()) {
		    		 updateScoreboard(player);
		    		 
		    	 }
		     }  	     
		}.runTaskTimer(this, 0, 20L);
			  				
		getCommand("join").setExecutor(new SkywarsCommand());
		getCommand("leave").setExecutor(new SkywarsCommand());
		getCommand("estado").setExecutor(new SkywarsCommand());
		
		Config();
		
		ArenaManager.reset();		 
	}
	
	public void onDisable() {
		
	}
	
	public void Config() {
	    config.addDefault("Numero", 0);
	    
	    config.options().copyDefaults(true);
	    saveConfig();
	}
	
	public void SaveConfig() {
		config.options().copyDefaults(true);
		
		saveConfig();
	}
	
    private void updateScoreboard(Player player) { 	
    	String arena = ArenaManager.getPlayerArena(player);
        int time = player.getStatistic(Statistic.PLAY_ONE_TICK);
        
        if(ScoreboardAPI.hasScore(player)) {
        	if (ArenaManager.getLobbyPlayers().contains(player)) {
	            ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);
	            ArrayList<String> list = new ArrayList<>();
	            list.add("");
	            list.add("&fNombre: &A" + player.getName());
	            list.add("&fJugadares: &a" + Bukkit.getOnlinePlayers().size() + "/100");
	            list.add("");
	            list.add("Estadisticas:");
	            list.add("  &c- &fAsesinatos:&c " + StatsAPI.getKills(player));
	            list.add("  &a- &fGanadas:&a "+ StatsAPI.getWins(player));
	            
	            if (StatsAPI.getLevel(player) < 5) {
	            	list.add("  &b- &fRango:&b Iniciado");
	            }else if (StatsAPI.getLevel(player) < 10 && StatsAPI.getLevel(player) >= 5){	            
	            	list.add("  &b- &fRango:&b Guerrero");
	            }else if (StatsAPI.getLevel(player) < 20 && StatsAPI.getLevel(player) >= 10){
	            	list.add("  &b- &fRango:&b Avanzado");
	            }else if (StatsAPI.getLevel(player) < 35 && StatsAPI.getLevel(player) >= 20){
	            	list.add("  &b- &fRango:&b Experto");
	            }else if (StatsAPI.getLevel(player) >= 35){
	            	list.add("  &b- &fRango:&b Maestro");
	            }
	            
	            list.add("  &3- &fNivel:&3 " + StatsAPI.getLevel(player) + " ("+ StatsAPI.getXP(player)+ "/100) XP");
	            list.add("");
	            list.add("&fLogros completados:&a 0/30");
	            list.add("");
	            list.add("&emc.unknowngames.es");
	            helper.setSlotsFromList(list);
        	}else if (ArenaManager.getInGamePlayers(arena).contains(player)) {
	            ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);
	            ArrayList<String> list = new ArrayList<>();
        		int players = ArenaManager.getPlayers(arena);
        		int times = ArenaManager.time + 1;
	            list.add("");
	            list.add("&fMapa: &A" + player.getWorld().getName());
	            list.add("&fJugadares: &a" + players + "/14");
	            list.add("");
	            list.add("Partida:");
	            list.add("  &c- &fAsesinatos:&c 0");
	            list.add("  &b- &fCoins:&b +0");
	            list.add("  &3- &fExperiencia: &3+0");
	            list.add("  &6- &fModo:&6 Normal");
	            list.add("");
	            
	            if (ArenaManager.listo.equals("No")) {
		            list.add("&fSiguiente evento: &aInicio");
		            list.add("&fEl evento comenzará en:&a " + times);
	            }else {
		            list.add("&fSiguiente evento: &aRelleno");
	            }
	            list.add("");
	            list.add("&emc.unknowngames.es");
	            helper.setSlotsFromList(list);
        	}else if (ArenaManager.getEsperaPlayers(arena).contains(player)) {
        		int players = ArenaManager.getPlayers(arena);
        		
        		  
	            ScoreboardAPI helper = ScoreboardAPI.getByPlayer(player);
	            ArrayList<String> list = new ArrayList<>();
	            list.add("");
	            list.add("&fMapa: &A" + player.getWorld().getName());
	            list.add("&fJugadares: &a" + players + "/14");
	            list.add("");
	            list.add("Estadisticas:");	     
	            list.add("  &c- &fAsesinatos:&c " + StatsAPI.getKills(player));
	            list.add("  &6- &fCoins:&6 " + StatsAPI.getCoins(player));
	            list.add("  &b- &fExperiencia:&b " + StatsAPI.getXP(player));
	            list.add("  &3- &fNivel:&3 " + StatsAPI.getLevel(player));
	            list.add("");
	            list.add("&fModo:&a Normal");
	            list.add("&fLogros completados:&a 0/30");
	            list.add("");
	            list.add("&emc.unknowngames.es");
	            helper.setSlotsFromList(list);
        	}
        	
        }
    }
    
    @EventHandler
    public void mobs(CreatureSpawnEvent e) {
    	e.setCancelled(true);
    }
    
    @EventHandler
    public void arrow (EntityShootBowEvent e) {
    	Entity entity = e.getEntity();
    	
    	if (entity instanceof Player) {
    		StatsAPI.addLauch((Player) entity, 1);
    	}
    }
    
    @EventHandler
	public void InteractMenu(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		if (e.getInventory().getTitle().equals("Mejores jugadores") || e.getInventory().getTitle().equals("Tús estadisticas")) {
			if (e.getSlot() == 31){	
				e.setCancelled(true);
				player.closeInventory();
				EstadisticasMenu.openMenu(player);
			}
		}
		if (e.getInventory().getTitle().equals("Arenas")) {
			if (e.getSlot() == 10){	
				if (item.getTypeId() == 159) {
					if (item.getDurability() == 5){
						player.closeInventory();
						ArenaManager.PlayerAdd(player, "Olimpo");
					}else if(item.getDurability() == 14) {
						player.closeInventory();
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
						player.sendMessage("§a>> §f¡La partida comenzó, elije otra!");
					}else if(item.getDurability() == 4){
						player.closeInventory();
						ArenaManager.PlayerAdd(player, "Olimpo");
					}
				}
			}
		}
		if (e.getInventory().getTitle().equals("Kits")) {
				if (e.getSlot() == 11){		
					if (item.getItemMeta().getDisplayName().contains("bloqueado")) {
						e.setCancelled(true);
						player.closeInventory();
						player.sendMessage("§a>> §f¡Para poder usar ésta función deberás comprar el §a§lKIT §fen la tienda!");			
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
					}else{
						Kit.removeKit(player);
						Kit.setKit(player, Kit.PRINCIPIANTE);						
						player.closeInventory();
						player.playSound(player.getLocation(), Sound.ZOMBIE_METAL, 1, 1);
						player.sendMessage(ChatColor.YELLOW + "> " + ChatColor.RESET + "Kit seleccionado: "+ ChatColor.GOLD + ChatColor.BOLD + "PRINCIPIANTE");
					}
				}else if (e.getSlot() == 12) {
					if (item.getItemMeta().getDisplayName().contains("bloqueado")) {
						e.setCancelled(true);
						player.closeInventory();
						player.sendMessage("§a>> §f¡Para poder usar ésta función deberás comprar el §a§lKIT §fen la tienda!");			
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
					}else{
						Kit.removeKit(player);
						Kit.setKit(player, Kit.ARQUERO);
						player.playSound(player.getLocation(), Sound.ZOMBIE_METAL, 1, 1);
						player.closeInventory();				
						player.sendMessage(ChatColor.YELLOW + "> " + ChatColor.RESET + "Kit seleccionado: "+ ChatColor.GOLD + ChatColor.BOLD + "ARQUERO");
					}
				}else if (e.getSlot() == 15) {
					if (item.getItemMeta().getDisplayName().contains("bloqueado")) {
						e.setCancelled(true);
						player.closeInventory();
						player.sendMessage("§a>> §f¡Para poder usar ésta función deberás comprar el §a§lKIT §fen la tienda!");			
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
					}else{
						Kit.removeKit(player);
						Kit.setKit(player, Kit.RUSHER);
						player.playSound(player.getLocation(), Sound.ZOMBIE_METAL, 1, 1);
						player.closeInventory();				
						player.sendMessage(ChatColor.YELLOW + "> " + ChatColor.RESET + "Kit seleccionado: "+ ChatColor.GOLD + ChatColor.BOLD + "RUSHER");
					}					
				}
			}		
		
		if (e.getInventory().getTitle().equals("Clima")) {
			if (e.getSlot() == 11){						
				e.setCancelled(true);
				Clima.addVote(player, Clima.TORMENTA);
			}else if (e.getSlot() == 13) {
				e.setCancelled(true);
				Clima.addVote(player, Clima.SOLEADO);
			}else if (e.getSlot() == 15) {
				e.setCancelled(true);
				Clima.addVote(player, Clima.NEVADO);
			}
		}
		if (e.getInventory().getTitle().equals("Estadisticas")) {
			if (e.getSlot() == 15){	
				e.setCancelled(true);
				player.closeInventory();
				TopMenu.openMenu(player);
			}
			if (e.getSlot() == 11){	
				e.setCancelled(true);
				player.closeInventory();
				PlayerStatsMenu.openMenu(player);
			}
		}
		if (e.getInventory().getTitle().equals("Cajas")) {
			if (e.getSlot() == 10){			
				if (player.hasPermission("caja.amarilla")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.AMARILLA);
					Cages.giveCage(player, Cages.AMARILLA);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
			
			if (e.getSlot() == 11){			
				if (player.hasPermission("caja.naranja")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.NARANJA);
					Cages.giveCage(player, Cages.NARANJA);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
			
			if (e.getSlot() == 12){			
				if (player.hasPermission("caja.violeta")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.VIOLETA);
					Cages.giveCage(player, Cages.VIOLETA);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
			
			if (e.getSlot() == 13){			
				if (player.hasPermission("caja.azulclaro")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.AZUL_CLARO);
					Cages.giveCage(player, Cages.AZUL_CLARO);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
			
			if (e.getSlot() == 14){			
				if (player.hasPermission("caja.verdeclaro")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.VERDE_CLARO);
					Cages.giveCage(player, Cages.VERDE_CLARO);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
			
			if (e.getSlot() == 15){			
				if (player.hasPermission("caja.roja")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.ROJA);
					Cages.giveCage(player, Cages.ROJA);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
			
			if (e.getSlot() == 16){			
				if (player.hasPermission("caja.azul")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.AZUL);
					Cages.giveCage(player, Cages.AZUL);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
			
			if (e.getSlot() == 19){			
				if (player.hasPermission("caja.cian")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.CIAN);
					Cages.giveCage(player, Cages.CIAN);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
			
			if (e.getSlot() == 20){			
				if (player.hasPermission("caja.blanca")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.BLANCA);
					Cages.giveCage(player, Cages.BLANCA);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
			
			if (e.getSlot() == 21){			
				if (player.hasPermission("caja.verde")) {
					e.setCancelled(true);
					player.closeInventory();
					Cages.removeCage(player);
					Cages.setCage(player, Cages.VERDE);
					Cages.giveCage(player, Cages.VERDE);
				}else {
					e.setCancelled(true);
					player.closeInventory();
					player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
					player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
				}
			}
		}
		
		if (e.getInventory().getTitle().equals("Votaciones")) {
			if (e.getSlot() == 13){		
				e.setCancelled(true);
				player.closeInventory();
				Clima.menuClima(player);
			}
		}
		
		if (e.getInventory().getTitle().equals("Opciones")) {
			if (e.getSlot() == 11){		
				e.setCancelled(true);
				player.closeInventory();
				CagesMenu.openMenu(player);
			}
		}
    }
}
