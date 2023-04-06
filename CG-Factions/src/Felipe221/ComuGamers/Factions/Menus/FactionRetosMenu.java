package Felipe221.ComuGamers.Factions.Menus;

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
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import Felipe221.ComuGamers.Factions.Faction.EloFaction;
import Felipe221.ComuGamers.Factions.Faction.RetosFaction;

public class FactionRetosMenu {
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 45, "§nRetos");

		FPlayer p = FPlayers.getInstance().getByPlayer(player);
        
		ItemStack mif = new ItemStack(Material.BOAT);
		ItemMeta meta = mif.getItemMeta();
		
		meta.setDisplayName("§eRetos de exploración");
		
		ArrayList<String> lore= new ArrayList<String>();		
					
		lore.add("§f");
		lore.add("§f¡Explora el §amundo §fy obtén");
		lore.add("§festos §blogros§f que te harán conocer todo!");
		lore.add("§fTendrás una gran variedad de objetivos");
		lore.add("§fque lograrás completar en la §aexploración§f.");
		lore.add("§f");
		lore.add("§fNivel de recompensa: §c§lALTO");
		
		meta.setLore(lore);
								
		mif.setItemMeta(meta);	
		
		ItemStack kill = new ItemStack(Material.ITEM_FRAME);
		ItemMeta killmeta = kill.getItemMeta();
		
		killmeta.setDisplayName("§eRetos de combate");
		
		ArrayList<String> lorekill= new ArrayList<String>();		
					
		lorekill.add("§f");
		lorekill.add("§f¡Tendrás una gran lista de §aretos §fpor");
		lorekill.add("§fcompletar si eres amante de los §bcombates§f!");
		lorekill.add("§f");
		lorekill.add("§fNivel de recompensa: §6§lMEDIO");

		killmeta.setLore(lorekill);
								
		kill.setItemMeta(killmeta);	
				
		ItemStack agri = new ItemStack(Material.WHEAT);
		ItemMeta agrimeta = agri.getItemMeta();
		
		agrimeta.setDisplayName("§eRetos de agricultura");
		
		ArrayList<String> loreagri= new ArrayList<String>();		
					
		loreagri.add("§f");
		loreagri.add("§f¡Obtén recompensas por §acultivar§f,");
		loreagri.add("§aaparear§f y más cosas relacionadas con");
		loreagri.add("§fla §bagricultura");
		loreagri.add("§f");
		loreagri.add("§fNivel de recompensa: §a§lBAJO");

		agrimeta.setLore(loreagri);
								
		agri.setItemMeta(agrimeta);	
		
		ItemStack builder = new ItemStack(Material.WOOD_AXE);
		ItemMeta buildermeta = builder.getItemMeta();
		
		buildermeta.setDisplayName("§eRetos de construcción");
		
		ArrayList<String> lorebuilder= new ArrayList<String>();		
					
		lorebuilder.add("§f");
		lorebuilder.add("§f¿Te gusta §aconstruir §fy quieres");
		lorebuilder.add("§frecibir §brecompensas §fpor hacerlo?");
		lorebuilder.add("§f¡Estás en el lugar correcto, aquí dentro");
		lorebuilder.add("§fencontrarás §aretos §fmuy divertidos para tí!");
		lorebuilder.add("§f");
		lorebuilder.add("§fNivel de recompensa: §c§lALTO");

		buildermeta.setLore(lorebuilder);
								
		builder.setItemMeta(buildermeta);	
		
		ItemStack minero = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta minerometa = minero.getItemMeta();
		
		minerometa.setDisplayName("§eRetos de minería");
		
		ArrayList<String> loreminero= new ArrayList<String>();		
					
		loreminero.add("§f");
		loreminero.add("§f¿Te gusta §aadentrarte §fen las §bminas§f?");
		loreminero.add("§f¡Mina ciertos §amateriales§f y completa");
		loreminero.add("§festos divertidos retos!");
		loreminero.add("§f");
		loreminero.add("§fNivel de recompensa: §6§lMEDIO");

		minerometa.setLore(loreminero);
								
		minero.setItemMeta(minerometa);	
				
		
		ItemStack back = new ItemStack(Material.MAGMA_CREAM);
   	 	ItemMeta back1 = back.getItemMeta();	
   	 		
		back1.setDisplayName("§aVolver al menú principal");
		 											
		back.setItemMeta(back1);
		
		join.setItem(10, kill);
		join.setItem(12, agri);
		join.setItem(14, builder);
		join.setItem(29, mif);
		join.setItem(16, minero);

		join.setItem(31, back);
		
		player.openInventory(join);	
	}
}
