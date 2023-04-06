package Felipe221.ComuGamers.Factions.Menus.Retos;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import Felipe221.ComuGamers.Factions.Config.StatsManager;
import Felipe221.ComuGamers.Factions.Faction.RetosFaction;

public class CombatChallenges {
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 45, "§nRetos de combate");

		FPlayer p = FPlayers.getInstance().getByPlayer(player);

		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
		glass.setDurability((short) 14);
		ItemMeta metaglass = glass.getItemMeta();
		
		metaglass.setDisplayName("§cBloqueado §lX");
		
		ArrayList<String> loreglass= new ArrayList<String>();		
					
		loreglass.add("§f");
		loreglass.add("§f¡Primero completa la misión anterior!");
		loreglass.add("");
		loreglass.add("§fEstado: §cEn espera");
		
		metaglass.setLore(loreglass);
								
		glass.setItemMeta(metaglass);	
		
		ItemStack kill1 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta metakill1 = kill1.getItemMeta();
		
		metakill1.setDisplayName("§eAsesinatos #1");
		
		ArrayList<String> lorekill1= new ArrayList<String>();		
					
		lorekill1.add("§f");
		lorekill1.add("§fMisión: Asesina a §a100 §fjugadores");
		lorekill1.add("§fRecompensa:");
		lorekill1.add("§a  - Manzana dorada x5");
		lorekill1.add("§a  - Libro encantado (Filo III)");
		lorekill1.add("§a  - 1000$");
		lorekill1.add("§f");
		lorekill1.add("§fAsesinatos: §a" + player.getStatistic(Statistic.PLAYER_KILLS));
		lorekill1.add("§fEstado: §a" + RetosFaction.getPlayerKillsinP(player, 100) + "%");
		
		metakill1.setLore(lorekill1);
								
		kill1.setItemMeta(metakill1);	
		
		ItemStack kill2 = new ItemStack(Material.STAINED_GLASS_PANE);
		kill2.setDurability((short) 5);
		ItemMeta metakill2 = kill2.getItemMeta();
		
		metakill2.setDisplayName("§eAsesinatos #2");
		
		ArrayList<String> lorekill2= new ArrayList<String>();		
					
		lorekill2.add("§f");
		lorekill2.add("§fMisión: Asesina a §a250 §fjugadores");
		lorekill2.add("§fRecompensa:");
		lorekill2.add("§a  - Manzana dorada x10");
		lorekill2.add("§a  - Libro encantado (Filo IV)");
		lorekill2.add("§a  - 2000$");
		lorekill2.add("§f");
		lorekill2.add("§fAsesinatos: §a" + player.getStatistic(Statistic.PLAYER_KILLS));
		lorekill2.add("§fEstado: §a" + RetosFaction.getPlayerKillsinP(player, 250) + "%");
		
		metakill2.setLore(lorekill2);
								
		kill2.setItemMeta(metakill2);	
		
		ItemStack kill3 = new ItemStack(Material.STAINED_GLASS_PANE);
		kill3.setDurability((short) 5);
		ItemMeta metakill3 = kill3.getItemMeta();
		
		metakill3.setDisplayName("§eAsesinatos #3");
		
		ArrayList<String> lorekill3= new ArrayList<String>();		
					
		lorekill3.add("§f");
		lorekill3.add("§fMisión: Asesina a §a500 §fjugadores");
		lorekill3.add("§fRecompensa:");
		lorekill3.add("§a  - Manzana dorada x15");
		lorekill3.add("§a  - Libro encantado (Fuego I)");
		lorekill3.add("§a  - Libro encantado (Infinidad I)");
		lorekill3.add("§a  - 4500$");
		lorekill3.add("§f");
		lorekill3.add("§fAsesinatos: §a" + player.getStatistic(Statistic.PLAYER_KILLS));
		lorekill3.add("§fEstado: §a" + RetosFaction.getPlayerKillsinP(player, 500) + "%");
		
		metakill3.setLore(lorekill3);
								
		kill3.setItemMeta(metakill3);	
		
		ItemStack kill4 = new ItemStack(Material.STAINED_GLASS_PANE);
		kill4.setDurability((short) 5);
		ItemMeta metakill4 = kill4.getItemMeta();
		
		metakill4.setDisplayName("§eAsesinatos #4");
		
		ArrayList<String> lorekill4= new ArrayList<String>();		
					
		lorekill4.add("§f");
		lorekill4.add("§fMisión: Asesina a §a1000 §fjugadores");
		lorekill4.add("§fRecompensa:");
		lorekill4.add("§a  - Poción de fuerza x5");
		lorekill4.add("§a  - Poción de velocidad x15");
		lorekill4.add("§a  - Libro encantado (Toque de seda I)");
		lorekill4.add("§a  - 7000$");
		lorekill4.add("§f");
		lorekill4.add("§fAsesinatos: §a" + player.getStatistic(Statistic.PLAYER_KILLS));
		lorekill4.add("§fEstado: §a" + RetosFaction.getPlayerKillsinP(player, 1000) + "%");
		
		metakill4.setLore(lorekill4);
								
		kill4.setItemMeta(metakill4);
		
		ItemStack kill5 = new ItemStack(Material.STAINED_GLASS_PANE);
		kill5.setDurability((short) 5);
		ItemMeta metakill5 = kill5.getItemMeta();
		
		metakill5.setDisplayName("§eAsesinatos #5");
		
		ArrayList<String> lorekill5= new ArrayList<String>();		
					
		lorekill5.add("§f");
		lorekill5.add("§fMisión: Asesina a §a5000 §fjugadores");
		lorekill5.add("§fRecompensa:");
		lorekill5.add("§a  - Sorpresa...");
		lorekill5.add("§f");
		lorekill5.add("§fAsesinatos: §a" + player.getStatistic(Statistic.PLAYER_KILLS));
		lorekill5.add("§fEstado: §a" + RetosFaction.getPlayerKillsinP(player, 5000) + "%");
		
		metakill5.setLore(lorekill5);
								
		kill5.setItemMeta(metakill5);

		ItemStack bow1 = new ItemStack(Material.BOW);
		ItemMeta metabow1 = bow1.getItemMeta();
		
		metabow1.setDisplayName("§eLanzamiento de flechas #1");
		
		ArrayList<String> loreflechas1= new ArrayList<String>();		
					
		loreflechas1.add("§f");
		loreflechas1.add("§fMisión: Acierta §a250 §fflechas");
		loreflechas1.add("§fRecompensa:");
		loreflechas1.add("§a  - 1000$");
		loreflechas1.add("§a  - Arco (Poder IV)");
		loreflechas1.add("§f");
		loreflechas1.add("§fAciertos: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS));
		loreflechas1.add("§fEstado: §a" + RetosFaction.getPlayerArrowsinP(player, 250) + "%");
		
		metabow1.setLore(loreflechas1);
								
		bow1.setItemMeta(metabow1);	
		
		ItemStack flechas2 = new ItemStack(Material.STAINED_GLASS_PANE);
		flechas2.setDurability((short) 5);
		ItemMeta metaflechas2 = flechas2.getItemMeta();
		
		metaflechas2.setDisplayName("§eLanzamiento de flechas #2");
		
		ArrayList<String> loreflechas2= new ArrayList<String>();		
					
		loreflechas2.add("§f");
		loreflechas2.add("§fMisión: Acierta §a500 §fflechas");
		loreflechas2.add("§fRecompensa:");
		loreflechas2.add("§a  - 2000$");
		loreflechas2.add("§a  - Arco (Flama I)");
		loreflechas2.add("§f");
		loreflechas2.add("§fAciertos: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS));
		loreflechas2.add("§fEstado: §a" + RetosFaction.getPlayerArrowsinP(player, 500) + "%");
		
		metaflechas2.setLore(loreflechas2);
								
		flechas2.setItemMeta(metaflechas2);	
		
		ItemStack flechas3 = new ItemStack(Material.STAINED_GLASS_PANE);
		flechas3.setDurability((short) 5);
		ItemMeta metaflechas3 = flechas3.getItemMeta();
		
		metaflechas3.setDisplayName("§eLanzamiento de flechas #3");
		
		ArrayList<String> loreflechas3= new ArrayList<String>();		
					
		loreflechas3.add("§f");
		loreflechas3.add("§fMisión: Acierta §a1000 §fflechas");
		loreflechas3.add("§fRecompensa:");
		loreflechas3.add("§a  - 4000$");
		loreflechas3.add("§a  - Arco (Poder IV - Infinidad I)");
		loreflechas3.add("§f");
		loreflechas3.add("§fAciertos: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS));
		loreflechas3.add("§fEstado: §a" + RetosFaction.getPlayerArrowsinP(player, 1000) + "%");
		
		metaflechas3.setLore(loreflechas3);
								
		flechas3.setItemMeta(metaflechas3);	
		
		ItemStack flechas4 = new ItemStack(Material.STAINED_GLASS_PANE);
		flechas4.setDurability((short) 5);
		ItemMeta metaflechas4 = flechas4.getItemMeta();
		
		metaflechas4.setDisplayName("§eLanzamiento de flechas #4");
		
		ArrayList<String> loreflechas4= new ArrayList<String>();		
					
		loreflechas4.add("§f");
		loreflechas4.add("§fMisión: Acierta §a2500 §fflechas");
		loreflechas4.add("§fRecompensa:");
		loreflechas1.add("§a  - Arco metralleta (único)");
		loreflechas1.add("§a  - Arco (Poder IV)");
		loreflechas4.add("§a  - 8000$");
		loreflechas4.add("§f");
		loreflechas4.add("§fVictorias de flechas: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS));
		loreflechas4.add("§fEstado: §a" + RetosFaction.getPlayerArrowsinP(player, 2500) + "%");
		
		metaflechas4.setLore(loreflechas4);
								
		flechas4.setItemMeta(metaflechas4);
		
		ItemStack flechas5 = new ItemStack(Material.STAINED_GLASS_PANE);
		flechas5.setDurability((short) 5);
		ItemMeta metaflechas5 = flechas5.getItemMeta();
		
		metaflechas5.setDisplayName("§eLanzamiento de flechas #5");
		
		ArrayList<String> loreflechas5= new ArrayList<String>();		
					
		loreflechas5.add("§f");
		loreflechas5.add("§fMisión: Acierta §a5000 §fflechass");
		loreflechas5.add("§fRecompensa:");
		loreflechas5.add("§a  - Sorpresa...");
		loreflechas5.add("§f");
		loreflechas5.add("§fAciertos: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS));
		loreflechas5.add("§fEstado: §a" + RetosFaction.getPlayerArrowsinP(player, 5000) + "%");
		
		metaflechas5.setLore(loreflechas5);
								
		flechas5.setItemMeta(metaflechas5);
		
		ItemStack guerra1 = new ItemStack(Material.NETHER_STAR);
		ItemMeta metaguerra1 = guerra1.getItemMeta();
		
		metaguerra1.setDisplayName("§eVictorias de guerra #1");
		
		ArrayList<String> loreguerra1= new ArrayList<String>();		
					
		loreguerra1.add("§f");
		loreguerra1.add("§fMisión: Gana §a5 §fguerras");
		loreguerra1.add("§fRecompensa:");
		loreguerra1.add("§a  - Obsidiana x32");
		loreguerra1.add("§a  - Poder +5");
		loreguerra1.add("§a  - 1000$");
		loreguerra1.add("§f");
		loreguerra1.add("§fVictorias de guerra: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS));
		loreguerra1.add("§fEstado: §a" + RetosFaction.getPlayerWinsinP(player, 5) + "%");
		
		metaguerra1.setLore(loreguerra1);
								
		guerra1.setItemMeta(metaguerra1);	
		
		ItemStack guerra2 = new ItemStack(Material.STAINED_GLASS_PANE);
		guerra2.setDurability((short) 5);
		ItemMeta metaguerra2 = guerra2.getItemMeta();
		
		metaguerra2.setDisplayName("§eVictorias de guerra #2");
		
		ArrayList<String> loreguerra2= new ArrayList<String>();		
					
		loreguerra2.add("§f");
		loreguerra2.add("§fMisión: Gana §a15 §fguerras");
		loreguerra2.add("§fRecompensa:");
		loreguerra2.add("§a  - Manzana dorada x1");
		loreguerra2.add("§a  - Obsidiana x32");
		loreguerra2.add("§a  - Poder +5");
		loreguerra2.add("§a  - 2000$");
		loreguerra2.add("§f");
		loreguerra2.add("§fVictorias de guerra: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS));
		loreguerra2.add("§fEstado: §a" + RetosFaction.getPlayerWinsinP(player, 15) + "%");
		
		metaguerra2.setLore(loreguerra2);
								
		guerra2.setItemMeta(metaguerra2);	
		
		ItemStack guerra3 = new ItemStack(Material.STAINED_GLASS_PANE);
		guerra3.setDurability((short) 5);
		ItemMeta metaguerra3 = guerra3.getItemMeta();
		
		metaguerra3.setDisplayName("§eVictorias de guerra #3");
		
		ArrayList<String> loreguerra3= new ArrayList<String>();		
					
		loreguerra3.add("§f");
		loreguerra3.add("§fMisión: Gana a §a50 §fguerras");
		loreguerra3.add("§fRecompensa:");
		loreguerra3.add("§a  - Manzana dorada x15");
		loreguerra3.add("§a  - Obsidiana x32");
		loreguerra3.add("§a  - Poder +10");
		loreguerra3.add("§a  - 4500$");
		loreguerra3.add("§f");
		loreguerra3.add("§fVictorias de guerra: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS));
		loreguerra3.add("§fEstado: §a" + RetosFaction.getPlayerWinsinP(player, 50) + "%");
		
		metaguerra3.setLore(loreguerra3);
								
		guerra3.setItemMeta(metaguerra3);	
		
		ItemStack guerra4 = new ItemStack(Material.STAINED_GLASS_PANE);
		guerra4.setDurability((short) 5);
		ItemMeta metaguerra4 = guerra4.getItemMeta();
		
		metaguerra4.setDisplayName("§eVictorias de guerra #4");
		
		ArrayList<String> loreguerra4= new ArrayList<String>();		
					
		loreguerra4.add("§f");
		loreguerra4.add("§fMisión: Gana §a100 §fguerras");
		loreguerra4.add("§fRecompensa:");
		loreguerra4.add("§a  - Poción de fuerza x5");
		loreguerra4.add("§a  - Poder +5");
		loreguerra4.add("§a  - Libro encantado (Toque de seda I)");
		loreguerra4.add("§a  - Libro encantado (Filo V)");
		loreguerra4.add("§a  - 8000$");
		loreguerra4.add("§f");
		loreguerra4.add("§fVictorias de guerra: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS));
		loreguerra4.add("§fEstado: §a" + RetosFaction.getPlayerWinsinP(player, 100) + "%");
		
		metaguerra4.setLore(loreguerra4);
								
		guerra4.setItemMeta(metaguerra4);
		
		ItemStack guerra5 = new ItemStack(Material.STAINED_GLASS_PANE);
		guerra5.setDurability((short) 5);
		ItemMeta metaguerra5 = guerra5.getItemMeta();
		
		metaguerra5.setDisplayName("§eVictorias de guerra #5");
		
		ArrayList<String> loreguerra5= new ArrayList<String>();		
					
		loreguerra5.add("§f");
		loreguerra5.add("§fMisión: Gana §a500 §fguerras");
		loreguerra5.add("§fRecompensa:");
		loreguerra5.add("§a  - Sorpresa...");
		loreguerra5.add("§f");
		loreguerra5.add("§fVictorias de guerra: §a" + StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS));
		loreguerra5.add("§fEstado: §a" + RetosFaction.getPlayerWinsinP(player, 500) + "%");
		
		metaguerra5.setLore(loreguerra5);
								
		guerra5.setItemMeta(metaguerra5);
		
		ItemStack back = new ItemStack(Material.MAGMA_CREAM);
   	 	ItemMeta back1 = back.getItemMeta();	
   	 		
		back1.setDisplayName("§aVolver al menú anterior");
		 											
		back.setItemMeta(back1);
		
		join.setItem(11, kill1);
		join.setItem(18, back);
		join.setItem(20, guerra1);
		join.setItem(29, bow1);
		
		if (player.getStatistic(Statistic.PLAYER_KILLS) >= 250) { 
			join.setItem(12, kill2);
		}else {
			join.setItem(12, glass);
		}
		
		if (player.getStatistic(Statistic.PLAYER_KILLS) >= 500) { 
			join.setItem(13, kill3);
		}else {
			join.setItem(13, glass);
		}		
		
		if (player.getStatistic(Statistic.PLAYER_KILLS) >= 1000) { 
			join.setItem(14, kill4);
		}else {
			join.setItem(14, glass);
		}
		
		if (player.getStatistic(Statistic.PLAYER_KILLS) >= 5000) { 
			join.setItem(15, kill5);
		}else {
			join.setItem(15, glass);
		}		
		
		if (StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS) >= 15) { 
			join.setItem(21, guerra2);
		}else {
			join.setItem(21, glass);
		}
		
		if (StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS) >= 50) { 
			join.setItem(22, guerra3);
		}else {
			join.setItem(22, glass);
		}		
		
		if (StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS) >= 100) { 
			join.setItem(23, guerra4);
		}else {
			join.setItem(23, glass);
		}
		
		if (StatsManager.getStatsFrom(player, StatsManager.StatsType.WINS) >= 500) { 
			join.setItem(24, guerra5);
		}else {
			join.setItem(24, glass);
		}		
		
		if (StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS) >= 500) { 
			join.setItem(30, flechas2);
		}else {
			join.setItem(30, glass);
		}
		
		if (StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS) >= 1000) { 
			join.setItem(31, flechas3);
		}else {
			join.setItem(31, glass);
		}		
		
		if (StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS) >= 2500) { 
			join.setItem(32, flechas4);
		}else {
			join.setItem(32, glass);
		}
		
		if (StatsManager.getStatsFrom(player, StatsManager.StatsType.ARROWS) >= 5000) { 
			join.setItem(33, flechas5);
		}else {
			join.setItem(33, glass);
		}		
		
		player.openInventory(join);	
	}
}
