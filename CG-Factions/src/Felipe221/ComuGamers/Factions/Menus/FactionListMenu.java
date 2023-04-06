package Felipe221.ComuGamers.Factions.Menus;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.struct.Role;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.Faction.EloFaction;
public class FactionListMenu {
	public static HashMap<Faction, Integer> list2 = new HashMap<Faction, Integer>();
	public static ArrayList<Integer> list3 = new ArrayList<Integer>();

	public static void openMenu(Player player) {	
		int a = 9;
		int z = 9;
		int rows = 0;
		int back = 17;
		
		for(Faction games : Factions.getInstance().getAllFactions()) {	
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

		Inventory join = Bukkit.getServer().createInventory(player, rows * 9, "§nLista de facciones");	
		
		for(Faction games : Factions.getInstance().getAllFactions()) {	
			if (games.getTag().contains("-") || games.getTag().contains("Zona")) {
				
			}else {				
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
				
				ItemStack arena = new ItemStack(Material.PAPER);
				ItemMeta arenameta = arena.getItemMeta();
				
				arenameta.setDisplayName("§e" + games.getTag());
				 
				ArrayList<String> lore= new ArrayList<String>();
				
				lore.add("§f");
				lore.add("§fPoder: §a" + games.getPowerRounded() + "/" + games.getPowerMaxRounded());
				lore.add("§fClaimeos: §a" + games.getAllClaims().size());
				
				if (games.isPeaceful()) {
					lore.add("§fEstado: §aPacífico");
				}else {
					lore.add("§fEstado: §aProfesional");
				}
				
				lore.add("§fAsesinatos: §a" + games.getKills());
				lore.add("§fMuertes: §a" + games.getDeaths());
				lore.add("§fJugadores: §a" + games.getOnlinePlayers().size()  + "/" + games.getFPlayers().size());
				lore.add("§f");
				
				for (FPlayer playe : games.getFPlayersWhereRole(Role.ADMIN)) {
					lore.add("§fFundador: §b" + playe.getName());
				}
				
				lore.add("§fELO: §b" + EloFaction.getElo(games));
				lore.add("§f");
				lore.add("§b¡Haz click para ver sus jugadores!");
				
				arenameta.setLore(lore);
				
				arena.setItemMeta(arenameta);
						
				join.setItem(list2.get(games), arena);	
			}
		}		
		
		ItemStack backa = new ItemStack(Material.MAGMA_CREAM);
   	 	ItemMeta back1 = backa.getItemMeta();	
   	 		
		back1.setDisplayName("§aVolver al menú principal");
		 											
		backa.setItemMeta(back1);
		
		join.setItem(back + 4, backa);	
		player.openInventory(join);	
	}
}
