package Felipe221.EDLB.Sign;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

import Felipe221.EDLB.Main;
import Felipe221.EDLB.Stats.PlayersTop;

public class SignManager implements Listener {
	public static List<Location> signs = new ArrayList<>();	
	
	public static void update(Location loc) {    
	    World w = loc.getWorld();
	    Block b = w.getBlockAt(loc);
			
		String[] top = PlayersTop.getTop5();
				
		int score1 = Main.plugin.getConfig().getInt("Jugadores."+top[0]+".Kills");
		int score2 = Main.plugin.getConfig().getInt("Jugadores."+top[1]+".Kills");
		int score3 = Main.plugin.getConfig().getInt("Jugadores."+top[2]+".Kills");
		int score4 = Main.plugin.getConfig().getInt("Jugadores."+top[3]+".Kills");
		int score5 = Main.plugin.getConfig().getInt("Jugadores."+top[4]+".Kills");
				
		if(b.getTypeId() == Material.SIGN_POST.getId() || b.getTypeId() == Material.WALL_SIGN.getId()) {			
			Sign sign = (Sign) b.getState();
			
	    		
			sign.setLine(0, "TOP: Asesinos");
			sign.setLine(1, "Puesto §a#1");
			sign.setLine(2, "" + top[0]);
			sign.setLine(3, "Asesinatos: §a" + score1);
			sign.update();		
		}
	}
	
	public static void updateAll() {
		new BukkitRunnable() {
		     public void run() {
		    	for (int a=0; a < signs.size(); a++) {
			    	Location sign = signs.get(a);
			    	update(sign);
		    	}
		    }   
		}.runTaskTimer(Main.plugin, 0, 200L);		  				
	}
	
	
	@EventHandler
	public void setBlock(SignChangeEvent e) {
		Block block = e.getBlock();
		
			Sign sign = (Sign) block.getState();
			
			String line1 = sign.getLine(0);
			String line2 = sign.getLine(1);					
			
			String[] top = PlayersTop.getTop5();
			
	        int score1 = Main.plugin.getConfig().getInt("Jugadores."+top[0]+".Kills");
	        int score2 = Main.plugin.getConfig().getInt("Jugadores."+top[1]+".Kills");
	        int score3 = Main.plugin.getConfig().getInt("Jugadores."+top[2]+".Kills");
	        int score4 = Main.plugin.getConfig().getInt("Jugadores."+top[3]+".Kills");
	        int score5 = Main.plugin.getConfig().getInt("Jugadores."+top[4]+".Kills");
			
	        if (e.getLine(0).equalsIgnoreCase("Top kills"))
	        	if (e.getLine(1).equalsIgnoreCase("1")) {
					e.setLine(0, "TOP: Asesinos");
					e.setLine(1, "Puesto §a#1");
					e.setLine(2, "" + top[0]);
					e.setLine(3, "Asesinatos: §a" + score1);		
					sign.update(true);
					
		            Location b = e.getBlock().getLocation();
					
					signs.add(b);
					
					int numbers = Main.plugin.getConfig().getInt("Carteles.Cantidad");
					
					numbers++;
					
					Main.plugin.getConfig().set("Carteles.Cantidad", numbers);
					Main.plugin.getConfig().set("Carteles." + numbers, b);
					Main.plugin.saveConfig();
	        	}
	}
}
