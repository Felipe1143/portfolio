package Felipe221.ComuGamers.Factions.Menus;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.struct.Role;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.Config.ConfigManager;
import Felipe221.ComuGamers.Factions.Config.StatsManager;
import Felipe221.ComuGamers.Factions.Config.StatsManager.StatsType;
import Felipe221.ComuGamers.Factions.War.WarManager;

public class FactionPlayersMenu {	
	public static HashMap<FPlayer, Integer> list2 = new HashMap<FPlayer, Integer>();
	public static ArrayList<Integer> list3 = new ArrayList<Integer>();
	
	public static int a, back;

	
	public static void openMenu(Player player, String tag) {	
		FactionMenu.open.put(player, "a1");
		
		int z = 9;
		back = 17;
		a = 9;
		int rows = 0;
		
		for(FPlayer games : Factions.getInstance().getByTag(tag).getFPlayers()) {	
			if (z <= 16) {
				z = z + 1;			
			}
			
			if (z == 17) {
				z = 18;
			}
			
			if (z == 25) {
				z = 27;
			}
			
			if (z >= 18 && z <= 25){
				z = z + 1;
			}
			
			if (z >= 27 && z <= 34){
				z = z + 1;				
			}
			
			if (z >= 36 && z <= 43){
				z = z + 1;				
			}
		}

		if (z <= 16) {
			rows = 3;
			back = 18;
		}
			
		if (z >= 18 && z <= 25){
			rows = 4;
			back = 27;
		}
		
		if (z >= 27 && z <= 34){
			rows = 5;
			back = 36;
		}
		
		if (z >= 36 && z <= 43){
			rows = 6;
			back = 45;
		}

		Inventory join = Bukkit.getServer().createInventory(player, rows * 9, "§nJugadores de " + tag);	
		
		for(FPlayer games : Factions.getInstance().getByTag(tag).getFPlayers()) {	
			if (a <= 16) {
				a = a + 1;				
			}
			
			if (a == 17) {
				a = 18;
			}
			
			if (a == 25) {
				a = 27;
			}
			
			if (a >= 18 && a <= 25){
				a = a + 1;
			}
			
			if (a >= 27 && a <= 34){
				a = a + 1;				
			}
			
			if (a >= 36 && a <= 43){
				a = a + 1;				
			}
			
			list3.add(a);
			list2.put(games, a);
		}	
		
		new BukkitRunnable() {
			 @Override
	         public void run() {
				 if (FactionMenu.open.containsKey(player)) {			
					for(FPlayer games : Factions.getInstance().getByTag(tag).getFPlayers()) {										
						ItemStack arena = new ItemStack(Material.PAPER);
						ItemMeta arenameta = arena.getItemMeta();
							
						arenameta.setDisplayName("§e" + games.getName());
							 
						ArrayList<String> lore= new ArrayList<String>();
							
						if (games.getRole() == Role.ADMIN) {
							lore.add("§FRol: §aFundador");
						}else if (games.getRole() == Role.MODERATOR) {
							lore.add("§FRol: §aComandante");
						}else if (games.getRole() == Role.NORMAL) {
							lore.add("§FRol: §aReclutado");
						}else if (games.getRole() == Role.COLEADER) {
							lore.add("§FRol: §aCo-Lider");
						}else if (games.getRole() == Role.NORMAL) {
							lore.add("§FRol: §aMilitar");
						}
						
						lore.add("§f");
						lore.add("§fAsesinatos: §a" + StatsManager.getStatsFrom(games.getName(), StatsType.KILLS));
						lore.add("§fMuertes: §a" + StatsManager.getStatsFrom(games.getName(), StatsType.DEATHS));
						lore.add("§fPoder: §a" + StatsManager.getStatsFrom(games.getName(), StatsType.POWER));
						
						OfflinePlayer p = games.getPlayer();
						
						lore.add("§fDinero: §a" + (int) Main.getEconomy().getBalance(p)+ "$");
						lore.add("§FAciertos con arco: §a" + StatsManager.getStatsFrom(games.getName(), StatsType.ARROWS));
						lore.add("");
						
						if (ConfigManager.getStats().getString("Facciones." + tag + ".En guerra." + games.getName()).equals("Si")){
							lore.add("§fParticipa en guerra: §bSi");
						}else {
							lore.add("§fParticipa en guerra: §bNo");
						}
						
						lore.add("§fGuerras ganadas: §b" + StatsManager.getStatsFrom(games.getName(), StatsType.WINS));
						lore.add("§f");
						lore.add("§b¡Por favor, no reveles estos datos a otros usuarios!");
						arenameta.setLore(lore);
							
						arena.setItemMeta(arenameta);
									
						join.setItem(list2.get(games), arena);	
							
					}		
					
					ItemStack backa = new ItemStack(Material.MAGMA_CREAM);
			   	 	ItemMeta back1 = backa.getItemMeta();	
			   	 		
					back1.setDisplayName("§aVolver al menú anterior");
					 											
					backa.setItemMeta(back1);
					
					join.setItem(back + 4, backa);	
				}else {
					cancel();
				}
			 }
		}.runTaskTimer(Main.plugin, 0, 2);
		
		player.openInventory(join);	
	}
}
