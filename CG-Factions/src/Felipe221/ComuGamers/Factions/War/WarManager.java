package Felipe221.ComuGamers.Factions.War;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.APIs.ActionAPI;
import Felipe221.ComuGamers.Factions.Config.ConfigManager;
import Felipe221.ComuGamers.Factions.Config.StatsManager;
import Felipe221.ComuGamers.Factions.Config.StatsManager.StatsType;
import Felipe221.ComuGamers.Factions.War.WarSystem.WarState;
import net.md_5.bungee.api.ChatColor;

public class WarManager implements Listener {
	static int time = 30;
	static int timereset = 30;
    
    static HashMap<String, ArrayList<Player>> playerList = new HashMap<String, ArrayList<Player>>();
    	
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
    	Player player = e.getPlayer();
    	
    	FPlayer playerF = FPlayers.getInstance().getByPlayer(player);
    	
    	String tag = playerF.getFaction().getTag();
    	
    	if (!ConfigManager.getStats().contains("Facciones." + tag + ".En guerra." + player.getName())) {
    		ConfigManager.getStats().set("Facciones." + tag + ".En guerra." + player.getName(), "No");
    		
    		ConfigManager.saveStats();
    	}
    }
    
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
    	Player player = e.getPlayer();
    			
    	FPlayer playerF = FPlayers.getInstance().getByPlayer(player);
    	
    	String tag = playerF.getFaction().getTag();
    	
    	ArrayList<Player> inWar = new ArrayList<Player>();
    	
    	for (Player players : playerF.getFaction().getOnlinePlayers()) {
    		if (!players.getName().equals(player.getName())){
	    		if (ConfigManager.getStats().getString("Facciones." + tag + ".En guerra." + player.getName()).equals("Si")){
	    			inWar.add(players);
	    		}
    		}
    	}
    	
    	playerList.put(tag, inWar);
    }
    
    public static ArrayList<Player> playersForWar(String tag){
    	ArrayList<Player> forWar = new ArrayList<Player>();
    	
    	for (Player players : Factions.getInstance().getByTag(tag).getOnlinePlayers()) {
    		if (ConfigManager.getStats().getString("Facciones." + tag + ".En guerra." + players.getName()).equals("Si")){
    			forWar.add(players);	    		
    		}
    	}
    	
		return forWar;   	
    }
    
	@EventHandler
	public void PlayerDamageByPlayer(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getDamager() instanceof Player) {
		        Player player = (Player)e.getEntity();
		        Player killer = (Player)e.getDamager();
		        
		        if (WarSystem.inWar.contains(player)) {
		        	if (WarSystem.inWar.contains(killer)) {
				        FPlayer pf = FPlayers.getInstance().getByPlayer(player);
				        FPlayer pk = FPlayers.getInstance().getByPlayer(killer);
				        
				        Faction playerF = Factions.getInstance().getByTag(pf.getFaction().getTag());
				        Faction playerK = Factions.getInstance().getByTag(pk.getFaction().getTag());				        
				    	
				        ArrayList<Player> vivosF = new ArrayList<Player>();
				        ArrayList<Player> vivosK = new ArrayList<Player>();
				        
				        //JUGADORES VIVOS DE CADA TEAM
				        for (Player playersF : WarSystem.inWar) {
				        	FPlayer pf1 = FPlayers.getInstance().getByPlayer(playersF);				        
				        	
				        	if (pf1.getFaction().getTag().equals(playerF.getTag())) {
				        		vivosF.add(playersF);
				        	}
				        }
				        
				        for (Player playersK : WarSystem.inWar) {
				        	FPlayer pf1 = FPlayers.getInstance().getByPlayer(playersK);				        
				        	
				        	if (pf1.getFaction().getTag().equals(playerK.getTag())) {
				        		vivosK.add(playersK);
				        	}
				        }
				        
		        		if (WarSystem.getState() == WarState.INICIANDO || WarSystem.getState() == WarState.REINICIANDO) {
		        			e.setCancelled(true);
		        		}else if (WarSystem.getState() == WarState.EN_JUEGO) {
		    				if (e.getFinalDamage() >= player.getHealth()) {
		    					vivosF.remove(player);
		    					
		    					//CHECK WIN
		    					if (vivosF.size() == 0) {
		    						Winner(playerK);
		    						
		    						vivosK.clear();
		    						vivosF.clear();
		    					}else {
		    						vivosK.clear();
		    						vivosF.clear();
		    						
		    						player.setGameMode(GameMode.SPECTATOR);
		    					}
		    				}
		        		}
		        	}
		        }
			}
		}
	}
	
	public static void Winner(Faction winner) {
		WarSystem.setState(WarState.REINICIANDO);
		
		for (Player winners : playerList.get(winner.getTag())) {
			StatsManager.upStatsFrom(winners, StatsType.WARS, 1);
		}
		
		for (Player global : WarSystem.inWar) {
			global.setHealth(20);
			global.setGameMode(GameMode.SURVIVAL);
			
			StatsManager.upStatsFrom(global, StatsType.WINS, 1);
		}
		
		playerList.clear();
		
		new BukkitRunnable() {
			 @Override
	         public void run() {
				 if (WarSystem.getState() == WarState.REINICIANDO) {
					 if (timereset == 0) {
						 WarSystem.setState(WarState.ESPERANDO);
						 
						 timereset = 30;
					 }else {
						 for (Player player : WarSystem.inWar) {
							 ActionAPI.sendActionBar(player, "  §f¡La guerra terminará en §b" + timereset + " §fsegundos!");
						 }			
						 
						 timereset--;
					 }
				 }else {
					 for (Player player : WarSystem.inWar) {
						 Location anterior = WarSystem.getpos.get(player);
						 
						 player.teleport(anterior);
						 
						 WarSystem.inWar.clear();
					 }
					 
					 cancel();
				 }
			 }
		}.runTaskTimer(Main.plugin, 20L, 20L);
	}
	
	public static void Iniciar(String f1, String f2) {
		WarSystem.setState(WarState.INICIANDO);
		
		playerList.put(f1, playersForWar(f1));
		playerList.put(f2, playersForWar(f2));
		
		for (Player player : Factions.getInstance().getByTag(f1).getOnlinePlayers()) {
			 player.playSound(player.getLocation(), Sound.ANVIL_USE, 1, 1);		
			 
			 WarSystem.getpos.put(player, player.getLocation());		 
			 WarSystem.inWar.add(player);
		}
		
		for (Player player : Factions.getInstance().getByTag(f2).getOnlinePlayers()) {
			 player.playSound(player.getLocation(), Sound.ANVIL_USE, 1, 1);
			 
			 WarSystem.getpos.put(player, player.getLocation());
			 WarSystem.inWar.add(player);
		}
		
		//TELOPORT SALA DE ESPERA
		
		new BukkitRunnable() {
			 @Override
	         public void run() {
				 if (WarSystem.getState() == WarState.INICIANDO) {
					 if (playerList.get(f1).size() >= 3 && playerList.get(f2).size() >= 3) {
						 if (time == 0) {
							 WarSystem.setState(WarState.EN_JUEGO);
							 
							 time = 30;
							 
							 for (Player player : WarSystem.inWar) {
								 player.sendMessage("§4§l>> §c¡La guerra comenzó!");						 
								 player.sendTitle("§c§l¡A LUCHAR!", "");
								 player.playSound(player.getLocation(), Sound.ZOMBIE_METAL, 1, 1);
							 }							 
						 }else {
							 for (Player player : WarSystem.inWar) {
								 ActionAPI.sendActionBar(player, "  §f¡La guerra comenzará en §b" + time + " §fsegundos!");
							 }		

							 time--;
						 }
					 }else {	 
						 time = 30;
						 
						 for (Player player : Factions.getInstance().getByTag(f1).getOnlinePlayers()) {
							 player.sendMessage("§4§l>> §c¡La guerra se canceló por falta de guerreros!");						 
						 }
						 
						 for (Player player : Factions.getInstance().getByTag(f2).getOnlinePlayers()) {
							 player.sendMessage("§4§l>> §c¡La guerra se canceló por falta de guerreros!");	
							 player.sendMessage("§e§l>> §fDeben haber al menos §b3 §fjugadores en cada §afacción §fconectados.");	
						 }
						 
						 cancel();
					 }
				 }else {
					 cancel();
				 }
			 }
		}.runTaskTimer(Main.plugin, 20L, 20L);
	}
	
	public static void setEnd() {
		
	}	
}
