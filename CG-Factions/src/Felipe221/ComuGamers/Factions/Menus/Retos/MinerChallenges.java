package Felipe221.ComuGamers.Factions.Menus.Retos;

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

import Felipe221.ComuGamers.Factions.APIs.StatsAPI;
import Felipe221.ComuGamers.Factions.Config.StatsManager;
import Felipe221.ComuGamers.Factions.Faction.RetosFaction;

public class MinerChallenges {
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 45, "§nRetos de minería");

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
		
		ItemStack hierro1 = new ItemStack(Material.IRON_ORE);
		ItemMeta metahierro1 = hierro1.getItemMeta();
		
		metahierro1.setDisplayName("§eHierro #1");
		
		ArrayList<String> lorehierro1= new ArrayList<String>();		
					
		lorehierro1.add("§f");
		lorehierro1.add("§fMisión: Mina §a50 §fbloques de hierro");
		lorehierro1.add("§fRecompensa:");
		lorehierro1.add("§a  - Libro encantado (Eficiencia II)");
		lorehierro1.add("§a  - 500$");
		lorehierro1.add("§f");
		lorehierro1.add("§fHierro minado: §a" + StatsAPI.getOre(player, Material.IRON_ORE));
		lorehierro1.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.IRON_ORE), 50) + "%");
		
		metahierro1.setLore(lorehierro1);
								
		hierro1.setItemMeta(metahierro1);	
		
		ItemStack hierro2 = new ItemStack(Material.STAINED_GLASS_PANE);
		hierro2.setDurability((short) 5);
		ItemMeta metahierro2 = hierro2.getItemMeta();
		
		metahierro2.setDisplayName("§eHierro #2");
		
		ArrayList<String> lorehierro2= new ArrayList<String>();		
					
		lorehierro2.add("§f");
		lorehierro2.add("§fMisión: Mina §a150 §fbloques de hierro");
		lorehierro2.add("§fRecompensa:");
		lorehierro2.add("§a  - Manzana dorada x2");
		lorehierro2.add("§a  - Libro encantado (Eficiencia III)");
		lorehierro2.add("§a  - 1000$");
		lorehierro2.add("§f");
		lorehierro2.add("§fHierro minado: §a" + StatsAPI.getOre(player, Material.IRON_ORE));
		lorehierro2.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.IRON_ORE), 150) + "%");
		
		metahierro2.setLore(lorehierro2);
								
		hierro2.setItemMeta(metahierro2);	
		
		ItemStack hierro3 = new ItemStack(Material.STAINED_GLASS_PANE);
		hierro3.setDurability((short) 5);
		ItemMeta metahierro3 = hierro3.getItemMeta();
		
		metahierro3.setDisplayName("§eHierro #3");
		
		ArrayList<String> lorehierro3= new ArrayList<String>();		
					
		lorehierro3.add("§f");
		lorehierro3.add("§fMisión: Mina §a400 §fbloques de hierro");
		lorehierro3.add("§fRecompensa:");
		lorehierro3.add("§a  - Manzana dorada x5");
		lorehierro3.add("§a  - Libro encantado (Eficiencia IV)");
		lorehierro3.add("§a  - 2000$");
		lorehierro3.add("§f");
		lorehierro3.add("§fHierro minado: §a" + StatsAPI.getOre(player, Material.IRON_ORE));
		lorehierro3.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.IRON_ORE), 400) + "%");
		
		metahierro3.setLore(lorehierro3);
								
		hierro3.setItemMeta(metahierro3);
		
		ItemStack hierro4 = new ItemStack(Material.STAINED_GLASS_PANE);
		hierro4.setDurability((short) 5);
		ItemMeta metahierro4 = hierro4.getItemMeta();
		
		metahierro4.setDisplayName("§eHierro #4");
		
		ArrayList<String> lorehierro4= new ArrayList<String>();		
					
		lorehierro4.add("§f");
		lorehierro4.add("§fMisión: Mina §a1000 §fbloques de hierro");
		lorehierro4.add("§fRecompensa:");
		lorehierro4.add("§a  - Obsidiana x32");
		lorehierro4.add("§a  - Pico misterioso");
		lorehierro4.add("§a  - 3000$");
		lorehierro4.add("§f");
		lorehierro4.add("§fHierro minado: §a" + StatsAPI.getOre(player, Material.IRON_ORE));
		lorehierro4.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.IRON_ORE), 1000) + "%");
		
		metahierro4.setLore(lorehierro4);
								
		hierro4.setItemMeta(metahierro4);
		
		ItemStack hierro5 = new ItemStack(Material.STAINED_GLASS_PANE);
		hierro5.setDurability((short) 5);
		ItemMeta metahierro5 = hierro5.getItemMeta();
		
		metahierro5.setDisplayName("§eHierro #5");
		
		ArrayList<String> lorehierro5= new ArrayList<String>();		
					
		lorehierro5.add("§f");
		lorehierro5.add("§fMisión: Mina §a2500 §fbloques de hierro");
		lorehierro5.add("§fRecompensa:");
		lorehierro5.add("§a  - Sorpresa...");
		lorehierro5.add("§f");
		lorehierro5.add("§fHierro minado: §a" + StatsAPI.getOre(player, Material.IRON_ORE));
		lorehierro5.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.IRON_ORE), 2500) + "%");
		
		metahierro5.setLore(lorehierro5);
								
		hierro5.setItemMeta(metahierro5);
		
		ItemStack redstone1 = new ItemStack(Material.REDSTONE_ORE);
		ItemMeta metaredstone1 = redstone1.getItemMeta();
		
		metaredstone1.setDisplayName("§eRedstone #1");
		
		ArrayList<String> loreredstone1= new ArrayList<String>();		
					
		loreredstone1.add("§f");
		loreredstone1.add("§fMisión: Mina §a50 §fbloques de redstone");
		loreredstone1.add("§fRecompensa:");
		loreredstone1.add("§a  - Libro encantado (Eficiencia II)");
		loreredstone1.add("§a  - 500$");
		loreredstone1.add("§f");
		loreredstone1.add("§fRedstone minado: §a" + StatsAPI.getOre(player, Material.REDSTONE_ORE));
		loreredstone1.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.REDSTONE_ORE), 50) + "%");
		
		metaredstone1.setLore(loreredstone1);
								
		redstone1.setItemMeta(metaredstone1);	
		
		ItemStack redstone2 = new ItemStack(Material.STAINED_GLASS_PANE);
		redstone2.setDurability((short) 5);
		ItemMeta metaredstone2 = redstone2.getItemMeta();
		
		metaredstone2.setDisplayName("§eRedstone #2");
		
		ArrayList<String> loreredstone2= new ArrayList<String>();		
					
		loreredstone2.add("§f");
		loreredstone2.add("§fMisión: Mina §a150 §fbloques de redstone");
		loreredstone2.add("§fRecompensa:");
		loreredstone2.add("§a  - Manzana dorada x2");
		loreredstone2.add("§a  - Libro encantado (Eficiencia III)");
		loreredstone2.add("§a  - 1000$");
		loreredstone2.add("§f");
		loreredstone2.add("§fRedstone minado: §a" + StatsAPI.getOre(player, Material.REDSTONE_ORE));
		loreredstone2.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.REDSTONE_ORE), 150) + "%");
		
		metaredstone2.setLore(loreredstone2);
								
		redstone2.setItemMeta(metaredstone2);	
		
		ItemStack redstone3 = new ItemStack(Material.STAINED_GLASS_PANE);
		redstone3.setDurability((short) 5);
		ItemMeta metaredstone3 = redstone3.getItemMeta();
		
		metaredstone3.setDisplayName("§eRedstone #3");
		
		ArrayList<String> loreredstone3= new ArrayList<String>();		
					
		loreredstone3.add("§f");
		loreredstone3.add("§fMisión: Mina §a400 §fbloques de redstone");
		loreredstone3.add("§fRecompensa:");
		loreredstone3.add("§a  - Manzana dorada x5");
		loreredstone3.add("§a  - Libro encantado (Eficiencia IV)");
		loreredstone3.add("§a  - 2000$");
		loreredstone3.add("§f");
		loreredstone3.add("§fRedstone minado: §a" + StatsAPI.getOre(player, Material.REDSTONE_ORE));
		loreredstone3.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.REDSTONE_ORE), 400) + "%");
		
		metaredstone3.setLore(loreredstone3);
								
		redstone3.setItemMeta(metaredstone3);
		
		ItemStack redstone4 = new ItemStack(Material.STAINED_GLASS_PANE);
		redstone4.setDurability((short) 5);
		ItemMeta metaredstone4 = redstone4.getItemMeta();
		
		metaredstone4.setDisplayName("§eRedstone #4");
		
		ArrayList<String> loreredstone4= new ArrayList<String>();		
					
		loreredstone4.add("§f");
		loreredstone4.add("§fMisión: Mina §a1000 §fbloques de redstone");
		loreredstone4.add("§fRecompensa:");
		loreredstone4.add("§a  - Obsidiana x32");
		loreredstone4.add("§a  - Pico misterioso");
		loreredstone4.add("§a  - 3000$");
		loreredstone4.add("§f");
		loreredstone4.add("§fRedstone minado: §a" + StatsAPI.getOre(player, Material.REDSTONE_ORE));
		loreredstone4.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.REDSTONE_ORE), 1000) + "%");
		
		metaredstone4.setLore(loreredstone4);
								
		redstone4.setItemMeta(metaredstone4);
		
		ItemStack redstone5 = new ItemStack(Material.STAINED_GLASS_PANE);
		redstone5.setDurability((short) 5);
		ItemMeta metaredstone5 = redstone5.getItemMeta();
		
		metaredstone5.setDisplayName("§eRedstone #5");
		
		ArrayList<String> loreredstone5= new ArrayList<String>();		
					
		loreredstone5.add("§f");
		loreredstone5.add("§fMisión: Mina §a2500 §fbloques de redstone");
		loreredstone5.add("§fRecompensa:");
		loreredstone5.add("§a  - Sorpresa...");
		loreredstone5.add("§f");
		loreredstone5.add("§fRedstone minado: §a" + StatsAPI.getOre(player, Material.REDSTONE_ORE));
		loreredstone5.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.REDSTONE_ORE), 2500) + "%");
		
		metaredstone5.setLore(loreredstone5);
								
		redstone5.setItemMeta(metaredstone5);
		
		ItemStack oro1 = new ItemStack(Material.GOLD_ORE);
		ItemMeta metaoro1 = oro1.getItemMeta();
		metaoro1.setDisplayName("§eOro #1");
		
		ArrayList<String> loreoro1= new ArrayList<String>();		
					
		loreoro1.add("§f");
		loreoro1.add("§fMisión: Mina §a50 §fbloques de oro");
		loreoro1.add("§fRecompensa:");
		loreoro1.add("§a  - Libro encantado (Eficiencia II)");
		loreoro1.add("§a  - 500$");
		loreoro1.add("§f");
		loreoro1.add("§fOro minado: §a" + StatsAPI.getOre(player, Material.GOLD_ORE));
		loreoro1.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.GOLD_ORE), 50) + "%");
		
		metaoro1.setLore(loreoro1);
								
		oro1.setItemMeta(metaoro1);	
		
		ItemStack oro2 = new ItemStack(Material.STAINED_GLASS_PANE);
		oro2.setDurability((short) 5);
		ItemMeta metaoro2 = oro2.getItemMeta();
		
		metaoro2.setDisplayName("§eOro #2");
		
		ArrayList<String> loreoro2= new ArrayList<String>();		
					
		loreoro2.add("§f");
		loreoro2.add("§fMisión: Mina §a150 §fbloques de oro");
		loreoro2.add("§fRecompensa:");
		loreoro2.add("§a  - Manzana dorada x2");
		loreoro2.add("§a  - Libro encantado (Eficiencia III)");
		loreoro2.add("§a  - 1000$");
		loreoro2.add("§f");
		loreoro2.add("§fOro minado: §a" + StatsAPI.getOre(player, Material.GOLD_ORE));
		loreoro2.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.GOLD_ORE), 150) + "%");
		
		metaoro2.setLore(loreoro2);
								
		oro2.setItemMeta(metaoro2);	
		
		ItemStack oro3 = new ItemStack(Material.STAINED_GLASS_PANE);
		oro3.setDurability((short) 5);
		ItemMeta metaoro3 = oro3.getItemMeta();
		
		metaoro3.setDisplayName("§eOro #3");
		
		ArrayList<String> loreoro3= new ArrayList<String>();		
					
		loreoro3.add("§f");
		loreoro3.add("§fMisión: Mina §a400 §fbloques de oro");
		loreoro3.add("§fRecompensa:");
		loreoro3.add("§a  - Manzana dorada x5");
		loreoro3.add("§a  - Libro encantado (Eficiencia IV)");
		loreoro3.add("§a  - 2000$");
		loreoro3.add("§f");
		loreoro3.add("§fOro minado: §a" + StatsAPI.getOre(player, Material.GOLD_ORE));
		loreoro3.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.GOLD_ORE), 400) + "%");
		
		metaoro3.setLore(loreoro3);
								
		oro3.setItemMeta(metaoro3);
		
		ItemStack oro4 = new ItemStack(Material.STAINED_GLASS_PANE);
		oro4.setDurability((short) 5);
		ItemMeta metaoro4 = oro4.getItemMeta();
		
		metaoro4.setDisplayName("§eOro #4");
		
		ArrayList<String> loreoro4= new ArrayList<String>();		
					
		loreoro4.add("§f");
		loreoro4.add("§fMisión: Mina §a1000 §fbloques de oro");
		loreoro4.add("§fRecompensa:");
		loreoro4.add("§a  - Obsidiana x32");
		loreoro4.add("§a  - Pico misterioso");
		loreoro4.add("§a  - 3000$");
		loreoro4.add("§f");
		loreoro4.add("§fOro minado: §a" + StatsAPI.getOre(player, Material.GOLD_ORE));
		loreoro4.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.GOLD_ORE), 1000) + "%");
		
		metaoro4.setLore(loreoro4);
								
		oro4.setItemMeta(metaoro4);
		
		ItemStack oro5 = new ItemStack(Material.STAINED_GLASS_PANE);
		oro5.setDurability((short) 5);
		ItemMeta metaoro5 = oro5.getItemMeta();
		
		metaoro5.setDisplayName("§eOro #5");
		
		ArrayList<String> loreoro5= new ArrayList<String>();		
					
		loreoro5.add("§f");
		loreoro5.add("§fMisión: Mina §a2500 §fbloques de oro");
		loreoro5.add("§fRecompensa:");
		loreoro5.add("§a  - Sorpresa...");
		loreoro5.add("§f");
		loreoro5.add("§fOro minado: §a" + StatsAPI.getOre(player, Material.GOLD_ORE));
		loreoro5.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.GOLD_ORE), 2500) + "%");
		
		metaoro5.setLore(loreoro5);
								
		oro5.setItemMeta(metaoro5);
		
		ItemStack diamante1 = new ItemStack(Material.DIAMOND_ORE);
		ItemMeta metadiamante1 = diamante1.getItemMeta();
		metadiamante1.setDisplayName("§eDiamante #1");
		
		ArrayList<String> lorediamante1= new ArrayList<String>();		
					
		lorediamante1.add("§f");
		lorediamante1.add("§fMisión: Mina §a50 §fbloques de diamante");
		lorediamante1.add("§fRecompensa:");
		lorediamante1.add("§a  - Libro encantado (Eficiencia II)");
		lorediamante1.add("§a  - 500$");
		lorediamante1.add("§f");
		lorediamante1.add("§fDiamante minado: §a" + StatsAPI.getOre(player, Material.DIAMOND_ORE));
		lorediamante1.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.DIAMOND_ORE), 50) + "%");
		
		metadiamante1.setLore(lorediamante1);
								
		diamante1.setItemMeta(metadiamante1);	
		
		ItemStack diamante2 = new ItemStack(Material.STAINED_GLASS_PANE);
		diamante2.setDurability((short) 5);
		ItemMeta metadiamante2 = diamante2.getItemMeta();
		
		metadiamante2.setDisplayName("§eDiamante #2");
		
		ArrayList<String> lorediamante2= new ArrayList<String>();		
					
		lorediamante2.add("§f");
		lorediamante2.add("§fMisión: Mina §a150 §fbloques de diamante");
		lorediamante2.add("§fRecompensa:");
		lorediamante2.add("§a  - Manzana dorada x2");
		lorediamante2.add("§a  - Libro encantado (Eficiencia III)");
		lorediamante2.add("§a  - 1000$");
		lorediamante2.add("§f");
		lorediamante2.add("§fDiamante minado: §a" + StatsAPI.getOre(player, Material.DIAMOND_ORE));
		lorediamante2.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.DIAMOND_ORE), 150) + "%");
		
		metadiamante2.setLore(lorediamante2);
								
		diamante2.setItemMeta(metadiamante2);	
		
		ItemStack diamante3 = new ItemStack(Material.STAINED_GLASS_PANE);
		diamante3.setDurability((short) 5);
		ItemMeta metadiamante3 = diamante3.getItemMeta();
		
		metadiamante3.setDisplayName("§eDiamante #3");
		
		ArrayList<String> lorediamante3= new ArrayList<String>();		
					
		lorediamante3.add("§f");
		lorediamante3.add("§fMisión: Mina §a400 §fbloques de diamante");
		lorediamante3.add("§fRecompensa:");
		lorediamante3.add("§a  - Manzana dorada x5");
		lorediamante3.add("§a  - Libro encantado (Eficiencia IV)");
		lorediamante3.add("§a  - 2000$");
		lorediamante3.add("§f");
		lorediamante3.add("§fDiamante minado: §a" + StatsAPI.getOre(player, Material.DIAMOND_ORE));
		lorediamante3.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.DIAMOND_ORE), 400) + "%");
		
		metadiamante3.setLore(lorediamante3);
								
		diamante3.setItemMeta(metadiamante3);
		
		ItemStack diamante4 = new ItemStack(Material.STAINED_GLASS_PANE);
		diamante4.setDurability((short) 5);
		ItemMeta metadiamante4 = diamante4.getItemMeta();
		
		metadiamante4.setDisplayName("§eDiamante #4");
		
		ArrayList<String> lorediamante4= new ArrayList<String>();		
					
		lorediamante4.add("§f");
		lorediamante4.add("§fMisión: Mina §a1000 §fbloques de diamante");
		lorediamante4.add("§fRecompensa:");
		lorediamante4.add("§a  - Obsidiana x32");
		lorediamante4.add("§a  - Pico misterioso");
		lorediamante4.add("§a  - 3000$");
		lorediamante4.add("§f");
		lorediamante4.add("§fDiamante minado: §a" + StatsAPI.getOre(player, Material.DIAMOND_ORE));
		lorediamante4.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.DIAMOND_ORE), 1000) + "%");
		
		metadiamante4.setLore(lorediamante4);
								
		diamante4.setItemMeta(metadiamante4);
		
		ItemStack diamante5 = new ItemStack(Material.STAINED_GLASS_PANE);
		diamante5.setDurability((short) 5);
		ItemMeta metadiamante5 = diamante5.getItemMeta();
		
		metadiamante5.setDisplayName("§eDiamante #5");
		
		ArrayList<String> lorediamante5= new ArrayList<String>();		
					
		lorediamante5.add("§f");
		lorediamante5.add("§fMisión: Mina §a2500 §fbloques de diamante");
		lorediamante5.add("§fRecompensa:");
		lorediamante5.add("§a  - Sorpresa...");
		lorediamante5.add("§f");
		lorediamante5.add("§fDiamante minado: §a" + StatsAPI.getOre(player, Material.DIAMOND_ORE));
		lorediamante5.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.DIAMOND_ORE), 2500) + "%");
		
		metadiamante5.setLore(lorediamante5);
								
		diamante5.setItemMeta(metadiamante5);
		
		ItemStack esmeralda1 = new ItemStack(Material.EMERALD_ORE);
		ItemMeta metaesmeralda1 = esmeralda1.getItemMeta();
		metaesmeralda1.setDisplayName("§eEsmeralda #1");
		
		ArrayList<String> loreesmeralda1= new ArrayList<String>();		
					
		loreesmeralda1.add("§f");
		loreesmeralda1.add("§fMisión: Mina §a50 §fbloques de esmeralda");
		loreesmeralda1.add("§fRecompensa:");
		loreesmeralda1.add("§a  - Libro encantado (Eficiencia II)");
		loreesmeralda1.add("§a  - 500$");
		loreesmeralda1.add("§f");
		loreesmeralda1.add("§fEsmeralda minada: §a" + StatsAPI.getOre(player, Material.EMERALD_ORE));
		loreesmeralda1.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.EMERALD_ORE), 50) + "%");
		
		metaesmeralda1.setLore(loreesmeralda1);
								
		esmeralda1.setItemMeta(metaesmeralda1);	
		
		ItemStack esmeralda2 = new ItemStack(Material.STAINED_GLASS_PANE);
		esmeralda2.setDurability((short) 5);
		ItemMeta metaesmeralda2 = esmeralda2.getItemMeta();
		
		metaesmeralda2.setDisplayName("§eEsmeralda #2");
		
		ArrayList<String> loreesmeralda2= new ArrayList<String>();		
					
		loreesmeralda2.add("§f");
		loreesmeralda2.add("§fMisión: Mina §a150 §fbloques de esmeralda");
		loreesmeralda2.add("§fRecompensa:");
		loreesmeralda2.add("§a  - Manzana dorada x2");
		loreesmeralda2.add("§a  - Libro encantado (Eficiencia III)");
		loreesmeralda2.add("§a  - 1000$");
		loreesmeralda2.add("§f");
		loreesmeralda2.add("§fEsmeralda minada: §a" + StatsAPI.getOre(player, Material.EMERALD_ORE));
		loreesmeralda2.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.EMERALD_ORE), 150) + "%");
		
		metaesmeralda2.setLore(loreesmeralda2);
								
		esmeralda2.setItemMeta(metaesmeralda2);	
		
		ItemStack esmeralda3 = new ItemStack(Material.STAINED_GLASS_PANE);
		esmeralda3.setDurability((short) 5);
		ItemMeta metaesmeralda3 = esmeralda3.getItemMeta();
		
		metaesmeralda3.setDisplayName("§eEsmeralda #3");
		
		ArrayList<String> loreesmeralda3= new ArrayList<String>();		
					
		loreesmeralda3.add("§f");
		loreesmeralda3.add("§fMisión: Mina §a400 §fbloques de esmeralda");
		loreesmeralda3.add("§fRecompensa:");
		loreesmeralda3.add("§a  - Manzana dorada x5");
		loreesmeralda3.add("§a  - Libro encantado (Eficiencia IV)");
		loreesmeralda3.add("§a  - 2000$");
		loreesmeralda3.add("§f");
		loreesmeralda3.add("§fEsmeralda minada: §a" + StatsAPI.getOre(player, Material.EMERALD_ORE));
		loreesmeralda3.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.EMERALD_ORE), 400) + "%");
		
		metaesmeralda3.setLore(loreesmeralda3);
								
		esmeralda3.setItemMeta(metaesmeralda3);
		
		ItemStack esmeralda4 = new ItemStack(Material.STAINED_GLASS_PANE);
		esmeralda4.setDurability((short) 5);
		ItemMeta metaesmeralda4 = esmeralda4.getItemMeta();
		
		metaesmeralda4.setDisplayName("§eEsmeralda #4");
		
		ArrayList<String> loreesmeralda4= new ArrayList<String>();		
					
		loreesmeralda4.add("§f");
		loreesmeralda4.add("§fMisión: Mina §a1000 §fbloques de esmeralda");
		loreesmeralda4.add("§fRecompensa:");
		loreesmeralda4.add("§a  - Obsidiana x32");
		loreesmeralda4.add("§a  - Pico misterioso");
		loreesmeralda4.add("§a  - 3000$");
		loreesmeralda4.add("§f");
		loreesmeralda4.add("§fEsmeralda minada: §a" + StatsAPI.getOre(player, Material.EMERALD_ORE));
		loreesmeralda4.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.EMERALD_ORE), 1000) + "%");
		
		metaesmeralda4.setLore(loreesmeralda4);
								
		esmeralda4.setItemMeta(metaesmeralda4);
		
		ItemStack esmeralda5 = new ItemStack(Material.STAINED_GLASS_PANE);
		esmeralda5.setDurability((short) 5);
		ItemMeta metaesmeralda5 = esmeralda5.getItemMeta();
		
		metaesmeralda5.setDisplayName("§eEsmeralda #5");
		
		ArrayList<String> loreesmeralda5= new ArrayList<String>();		
					
		loreesmeralda5.add("§f");
		loreesmeralda5.add("§fMisión: Mina §a2500 §fbloques de esmeralda");
		loreesmeralda5.add("§fRecompensa:");
		loreesmeralda5.add("§a  - Sorpresa...");
		loreesmeralda5.add("§f");
		loreesmeralda5.add("§fEsmeralda minada: §a" + StatsAPI.getOre(player, Material.EMERALD_ORE));
		loreesmeralda5.add("§fEstado: §a" + RetosFaction.getP(StatsAPI.getOre(player, Material.EMERALD_ORE), 2500) + "%");
		
		metaesmeralda5.setLore(loreesmeralda5);
								
		esmeralda5.setItemMeta(metaesmeralda5);
						
		ItemStack back = new ItemStack(Material.MAGMA_CREAM);
   	 	ItemMeta back1 = back.getItemMeta();	
   	 		
		back1.setDisplayName("§aVolver al menú anterior");
		 											
		back.setItemMeta(back1);
		
		join.setItem(2, hierro1);
		join.setItem(11, oro1);
		join.setItem(20, redstone1);
		join.setItem(29, diamante1);
		join.setItem(38, esmeralda1);
		join.setItem(18, back);
		
		if (StatsAPI.getOre(player, Material.IRON_ORE) >= 150) { 
			join.setItem(3, hierro2);
		}else {
			join.setItem(3, glass);
		}
		
		if (StatsAPI.getOre(player, Material.IRON_ORE) >= 400) { 
			join.setItem(4, hierro3);
		}else {
			join.setItem(4, glass);
		}		
		
		if (StatsAPI.getOre(player, Material.IRON_ORE) >= 1000) { 
			join.setItem(5, hierro4);
		}else {
			join.setItem(5, glass);
		}
		
		if (StatsAPI.getOre(player, Material.IRON_ORE) >= 2500) { 
			join.setItem(6, hierro5);
		}else {
			join.setItem(6, glass);
		}	
		
		if (StatsAPI.getOre(player, Material.GOLD_ORE) >= 150) { 
			join.setItem(12, oro2);
		}else {
			join.setItem(12, glass);
		}
		
		if (StatsAPI.getOre(player, Material.GOLD_ORE) >= 400) { 
			join.setItem(13, oro3);
		}else {
			join.setItem(13, glass);
		}		
		
		if (StatsAPI.getOre(player, Material.GOLD_ORE) >= 1000) { 
			join.setItem(14, oro4);
		}else {
			join.setItem(14, glass);
		}
		
		if (StatsAPI.getOre(player, Material.GOLD_ORE) >= 2500) { 
			join.setItem(15, oro5);
		}else {
			join.setItem(15, glass);
		}	
		
		if (StatsAPI.getOre(player, Material.REDSTONE_ORE) >= 150) { 
			join.setItem(21, redstone2);
		}else {
			join.setItem(21, glass);
		}
		
		if (StatsAPI.getOre(player, Material.REDSTONE_ORE) >= 400) { 
			join.setItem(22, redstone3);
		}else {
			join.setItem(22, glass);
		}		
		
		if (StatsAPI.getOre(player, Material.REDSTONE_ORE) >= 1000) { 
			join.setItem(23, redstone4);
		}else {
			join.setItem(23, glass);
		}
		
		if (StatsAPI.getOre(player, Material.REDSTONE_ORE) >= 2500) { 
			join.setItem(24, redstone5);
		}else {
			join.setItem(24, glass);
		}	
				
		if (StatsAPI.getOre(player, Material.DIAMOND_ORE) >= 150) { 
			join.setItem(30, diamante2);
		}else {
			join.setItem(30, glass);
		}
		
		if (StatsAPI.getOre(player, Material.DIAMOND_ORE) >= 400) { 
			join.setItem(31, diamante3);
		}else {
			join.setItem(31, glass);
		}		
		
		if (StatsAPI.getOre(player, Material.DIAMOND_ORE) >= 1000) { 
			join.setItem(32, diamante4);
		}else {
			join.setItem(32, glass);
		}
		
		if (StatsAPI.getOre(player, Material.DIAMOND_ORE) >= 2500) { 
			join.setItem(33, diamante5);
		}else {
			join.setItem(33, glass);
		}	
		
		if (StatsAPI.getOre(player, Material.EMERALD_ORE) >= 150) { 
			join.setItem(39, esmeralda2);
		}else {
			join.setItem(39, glass);
		}
		
		if (StatsAPI.getOre(player, Material.EMERALD_ORE) >= 400) { 
			join.setItem(40, esmeralda3);
		}else {
			join.setItem(40, glass);
		}		
		
		if (StatsAPI.getOre(player, Material.EMERALD_ORE) >= 1000) { 
			join.setItem(41, esmeralda4);
		}else {
			join.setItem(41, glass);
		}
		
		if (StatsAPI.getOre(player, Material.EMERALD_ORE) >= 2500) { 
			join.setItem(42, esmeralda5);
		}else {
			join.setItem(42, glass);
		}			
		
		player.openInventory(join);	
	}
}
