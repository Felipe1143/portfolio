package Felipe221.ComuGamers.Factions.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.APIs.VaultAPI;
import Felipe221.ComuGamers.Factions.Faction.RetosFaction;
import Felipe221.ComuGamers.Factions.War.WarSystem;
import Felipe221.ComuGamers.Factions.War.WarSystem.WarState;
import net.milkbowl.vault.economy.EconomyResponse;

public class FactionMainMenu {
	
		public static void openMenu(Player player) {
			Inventory join = Bukkit.getServer().createInventory(player, 45, "§nFacciones");

			FPlayer mp = FPlayers.getInstance().getByPlayer(player);
		
			ItemStack mif = new ItemStack(Material.getMaterial(386));		
			ItemMeta mif1 = mif.getItemMeta();	
			mif1.setDisplayName("§eTú facción");
			
			ArrayList<String> lore= new ArrayList<String>();
						
			lore.add("");
			lore.add("§fAquí podrás ver toda la información");
			lore.add("§fde tú §afacción §fen un solo lugar.");
			lore.add("§f¡Además tendrás acceso a §cfunciones §fde");
			lore.add("§funa manera mucho más fácil!");
			lore.add("");
			lore.add("§b¡Haz click para visualizar!");
			mif1.setLore(lore);
			
			mif.setItemMeta(mif1);
			
			ItemStack retos = new ItemStack(Material.DIAMOND);		
			ItemMeta retos1 = retos.getItemMeta();	
			retos1.setDisplayName("§eRetos");
			
			ArrayList<String> loreretos= new ArrayList<String>();
						
			loreretos.add("");
			loreretos.add("§f¿Quieres ganar valiosas recompensas");
			loreretos.add("§fpor §ajugar §fy §ecompletar §fdivertidos retos?");
			loreretos.add("§f¡Explora y obtén benefinicos!");
			loreretos.add("");
			loreretos.add("§b¡Haz click para visualizar los retos!");
			retos1.setLore(loreretos);
									
			retos.setItemMeta(retos1);	
			
			ItemStack kits = new ItemStack(Material.BOW);		
			ItemMeta kits1 = kits.getItemMeta();	
			kits1.setDisplayName("§eKits");
			
			ArrayList<String> lorekits= new ArrayList<String>();
						
			lorekits.add("");
			lorekits.add("§f¡Compra y utiliza §akits §fpara");
			lorekits.add("§fobtener §eventajas §fy dominar!");
			lorekits.add("§fTen en cuenta que mientras");
			lorekits.add("§fmás §bjuegues §f¡mejor serán los kits!");
			lorekits.add("");
			lorekits.add("§b¡Haz click para visualizar los kits!");
			kits1.setLore(lorekits);
									
			kits.setItemMeta(kits1);	
			
			ItemStack shop = new ItemStack(Material.EYE_OF_ENDER);		
			ItemMeta shop1 = shop.getItemMeta();	
			shop1.setDisplayName("§eTienda");
			
			ArrayList<String> loreshop= new ArrayList<String>();
						
			loreshop.add("");
			loreshop.add("§f¡Compra los §aobjetos §fy §abloques §fque te falten");
			loreshop.add("§fpara obtener §eventajas §fy poder hacer");
			loreshop.add("§ftodo mucho más §brápido §fque otros!");
			loreshop.add("");
			loreshop.add("§fAtención: ¡Compra con §ccuidado§f!");
			loreshop.add("");
			loreshop.add("§b¡Haz click para visualizar la tienda!");
			shop1.setLore(loreshop);
									
			shop.setItemMeta(shop1);	

			ItemStack crear = new ItemStack(Material.getMaterial(386));		
	   	 	ItemMeta crear1 = crear.getItemMeta();	
			crear1.setDisplayName("§eCrear facción");
			 
			ArrayList<String> lorecrear= new ArrayList<String>();
						
			lorecrear.add("");
			lorecrear.add("§f¡Aquí podrás crear tú facción");
			lorecrear.add("§fy empezar la gran aventura!");
			lorecrear.add("§fHaz §aclick §fy luego escribe el nombre");
			lorecrear.add("§fde tú nueva §bfacción §fen el chat.");
			lorecrear.add("");
			lorecrear.add("§b¡Haz click para crear!");
			    	 
			crear1.setLore(lorecrear);
									
			crear.setItemMeta(crear1);		
			
			ItemStack top = new ItemStack(Material.SIGN);		
	   	 	ItemMeta top1 = top.getItemMeta();	
			top1.setDisplayName("§eMejores facciones");
			 
			ArrayList<String> loretop= new ArrayList<String>();
						
			loretop.add("");
			loretop.add("§f¡Lleva tu §efacción §fa la cima!");
			loretop.add("§fPodrás observas las §amejores");
			loretop.add("§ffacciones del momento, dependiendo");
			loretop.add("§fde su §bpoder§f, §casesinatos§f y §aclaimeos...");
			loretop.add("");
			loretop.add("§b¡Haz click para visualizar!");
			    	 
			top1.setLore(loretop);
									
			top.setItemMeta(top1);		
			
			ItemStack facs = new ItemStack(Material.PAPER);		
	   	 	ItemMeta facs1 = facs.getItemMeta();	
			facs1.setDisplayName("§eLista de facciones");
			 
			ArrayList<String> lorefacs= new ArrayList<String>();
						
			lorefacs.add("");
			lorefacs.add("§fAquí podrás ver la §einformación §fde");
			lorefacs.add("§fotras facciones, además de incluir");
			lorefacs.add("§fsu §cpoder§f, sus §ajugadores §fy §bdinero§f.");
			lorefacs.add("");
			lorefacs.add("§fSolo disponible para el rango §d§lULTIMATE");
			lorefacs.add("");
			lorefacs.add("§b¡Haz click para visualizar!");
			    	 
			facs1.setLore(lorefacs);
									
			facs.setItemMeta(facs1);		
			
			ItemStack war = new ItemStack(Material.DIAMOND_SWORD);		
	   	 	ItemMeta war1 = war.getItemMeta();	   	 
	   	 	
			war1.setDisplayName("§eGuerras " + "\u2691");
			 
			ArrayList<String> lore1= new ArrayList<String>();
				
			lore1.add("");
			lore1.add("§f¿Quieres demostrar tú §cpoder §fy poder");
			lore1.add("§fganar jugosas recompensas?");
			lore1.add("§f¡Prueba éste §bsistema de guerras §fy");
			lore1.add("§fsorprende a tú enemigo!");
			lore1.add("");
			
			if (WarSystem.getState() == WarState.ESPERANDO) {
				lore1.add("§fEstado de guerra: §aEsperando...");	
			}else if (WarSystem.getState() == WarState.INICIANDO) {
				lore1.add("§fEstado de guerra: §aComenzando - (" + WarSystem.getFaction(1) + " VS " + WarSystem.getFaction(2) + ")");	
			}else if (WarSystem.getState() == WarState.EN_JUEGO) {
				lore1.add("§fEstado de guerra: §a¡Combatiendo! - ("  + WarSystem.getFaction(1) + " VS " + WarSystem.getFaction(2) + ")");	
			}else if (WarSystem.getState() == WarState.REINICIANDO) {
				lore1.add("§fEstado de guerra: §cReiniciando");	
			}
			
			lore1.add("");
			lore1.add("§b¡Haz click para obtener información!");
			    	 
			war1.setLore(lore1);
									
			war.setItemMeta(war1);	
						
			if (mp.hasFaction()) {
				join.setItem(10, mif);
			}else {
				join.setItem(10, crear);
			}
			
			join.setItem(12, retos);
			join.setItem(14, kits);
			join.setItem(16, shop);
			join.setItem(29, war);
			join.setItem(31, top);
			join.setItem(33, facs);
			
			player.openInventory(join);	
		}
	
}
