package Felipe221.ComuGamers.Factions.Menus;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic.Type;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import Felipe221.ComuGamers.Factions.APIs.SkullCreatorAPI;
import Felipe221.ComuGamers.Factions.Faction.EloFaction;
import Felipe221.ComuGamers.Factions.War.WarSystem;
import Felipe221.ComuGamers.Factions.War.WarSystem.WarState;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;

public class FactionEloMenu {		
	static HashMap<String, Integer> to = new HashMap<String, Integer>();
	
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 45, "§nMejores facciones");

		String[] top = EloFaction.getAllELO();		
		
		FPlayer p = FPlayers.getInstance().getByPlayer(player);
	    
		ItemStack mif = new ItemStack(Material.getMaterial(159));
		mif.setDurability((short) 5);

		ItemMeta meta = mif.getItemMeta();
		
		meta.setDisplayName("§e-> Posición #1");
		
		ArrayList<String> lore= new ArrayList<String>();
		
		Faction top1 = Factions.getInstance().getByTag(top[0]);
					
		lore.add("§f");
		lore.add("§fFacción: §a" + top[0]);
		lore.add("§fELO: §b" + EloFaction.getElo(top1));
		meta.setLore(lore);
								
		mif.setItemMeta(meta);	
		
		ItemStack mif2 = new ItemStack(Material.getMaterial(159));
		mif2.setDurability((short) 5);
		ItemMeta t2 = mif2.getItemMeta();	
		t2.setDisplayName("§e-> Posición #2");
		
		ArrayList<String> lore2= new ArrayList<String>();
		
		Faction top2 = Factions.getInstance().getByTag(top[1]);
					
		lore2.add("§f");
		lore2.add("§fFacción: §a" + top[1]);
		lore2.add("§fELO: §b" + EloFaction.getElo(top2));
		t2.setLore(lore2);
								
		mif2.setItemMeta(t2);	
		
		ItemStack mif3 = new ItemStack(Material.getMaterial(159));
		mif3.setDurability((short) 5);
		ItemMeta t3 = mif3.getItemMeta();	
		t3.setDisplayName("§e-> Posición #3");
		
		ArrayList<String> lore3= new ArrayList<String>();
		
		Faction top3 = Factions.getInstance().getByTag(top[2]);
					
		lore3.add("§f");
		lore3.add("§fFacción: §a" + top[2]);
		lore3.add("§fELO: §b" + EloFaction.getElo(top3));
		t3.setLore(lore3);
								
		mif3.setItemMeta(t3);	
		
		ItemStack mif4 = new ItemStack(Material.getMaterial(159));
		mif4.setDurability((short) 5);
		ItemMeta t4 = mif4.getItemMeta();	
		t4.setDisplayName("§e-> Posición #4");
		
		ArrayList<String> lore4= new ArrayList<String>();
		
		Faction top4 = Factions.getInstance().getByTag(top[3]);
					
		lore4.add("§f");
		lore4.add("§fFacción: §a" + top[3]);
		lore4.add("§fELO: §b" + EloFaction.getElo(top4));
		t4.setLore(lore4);
								
		mif4.setItemMeta(t4);	
		
		ItemStack mif5 = new ItemStack(Material.getMaterial(159));
		mif5.setDurability((short) 5);
		ItemMeta t5 = mif5.getItemMeta();	
		t5.setDisplayName("§e-> Posición #5");
		
		ArrayList<String> lore5= new ArrayList<String>();
		
		Faction top5 = Factions.getInstance().getByTag(top[4]);
					
		lore5.add("§f");
		lore5.add("§fFacción: §a" + top[4]);
		lore5.add("§fELO: §b" + EloFaction.getElo(top5));
		t5.setLore(lore5);
								
		mif5.setItemMeta(t5);	
		
		ItemStack playerf = new ItemStack(Material.getMaterial(159));
		playerf.setDurability((short) 4);
		ItemMeta playert = playerf.getItemMeta();	
		playert.setDisplayName("§e-> Tú facción");
		
		ArrayList<String> loreplayer= new ArrayList<String>();
						
		loreplayer.add("§f");
		
		if (p.getFaction().getTag().contains("-")) {
			loreplayer.add("§fNombre: §a¡No tienes una facción!");
		}else {
			loreplayer.add("§fNombre: §a" + p.getFaction().getTag());
		}
		
		loreplayer.add("§fELO: §b" + EloFaction.getElo(p.getFaction()));
		loreplayer.add("§f");
		if (!p.getFaction().getTag().contains("-")) {
			loreplayer.add("§b¡Haz click para ver tú información!");
		}
		
		playert.setLore(loreplayer);
								
		playerf.setItemMeta(playert);
		
		to.put(top[0], 11);
		to.put(top[1], 12);
		to.put(top[2], 13);
		to.put(top[3], 14);
		to.put(top[4], 15);
		
		ItemStack back = new ItemStack(Material.MAGMA_CREAM);
   	 	ItemMeta back1 = back.getItemMeta();	
   	 		
		back1.setDisplayName("§aVolver al menú principal");
		 											
		back.setItemMeta(back1);
		
		join.setItem(11, mif);
		join.setItem(12, mif2);
		join.setItem(13, mif3);
		join.setItem(14, mif4);
		join.setItem(15, mif5);
		join.setItem(30, back);
		join.setItem(31, playerf);
		
		player.openInventory(join);	
	}
}
