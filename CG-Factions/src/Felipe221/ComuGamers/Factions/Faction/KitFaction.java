package Felipe221.ComuGamers.Factions.Faction;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.Config.ConfigManager;

public class KitFaction {		
	public enum KitType{
		NOVATO, ULTIMATE, ELITE, VIP, AVANZADO, VETERANO, COMANDANTE; 
	}
	
	public static void startCooldown(String player, KitType kit, long l) {
		ConfigManager.getStats().set("Jugadores." + player + ".Cooldown." + kit.toString().toLowerCase(), l);
		 
		ConfigManager.saveStats();
		 
		new BukkitRunnable() {
			 @Override
	         public void run() {				 
				 int time = ConfigManager.getStats().getInt("Jugadores." + player + ".Cooldown." + kit.toString().toLowerCase());
					 
				 if (time == 0) {
					 ConfigManager.getStats().set("Jugadores." + player + ".Cooldown." + kit.toString().toLowerCase(), -50);
							 
					 ConfigManager.saveStats();
							 
					 cancel();
				 }else {					 						 
					 ConfigManager.getStats().set("Jugadores." + player + ".Cooldown." + kit.toString().toLowerCase(), time - 1);
						 
					 ConfigManager.saveStats();
				 }		 
		     }  	     
		}.runTaskTimer(Main.plugin, 20L, 20L);
	}
	
    public static String timeStringFor(long time) {
    	long days = (int) time / 86400L;
        long hours = time / 3600L - days * 24;
        long minutes = (time - (time / 3600L) * 3600L) / 60L;
        long seconds = time - (time / 3600L) * 3600L - minutes * 60L;
        
        String dias = null;
        String horas = null;
        String minutos = null;
        String segundos = null;

        if (days == 1) {
        	dias = "§c" + days + " §fdía ";
        }else if (days > 1) {
        	dias = "§c" + days + " §fdías ";
        }else{
        	dias = "";
        }
        
        if (hours == 1) {
        	horas = "§c" + hours + " §fhora ";
        }else if (hours > 1) {
        	horas = "§c" + hours + " §fhoras ";
        }else{
        	horas = "";
        }
        
        if (minutes == 1) {
        	minutos = "§c" + minutes + " §fminuto ";
        }else if (minutes > 1) {
        	minutos = "§c" + minutes + " §fminutos ";
        }else{
        	minutos = "";
        }
        
        if (seconds == 1) {
        	segundos = "§c" + seconds + " §fsegundo";
        }else if (seconds > 1) {
        	segundos = "§c" + seconds +" §fsegundos";
        }else{
        	segundos = "";
        }
              	
        return dias + horas + minutos + segundos;       
    }
    
    public static String timeString(long time) {
    	long days = (int) time / 86400L;
        long hours = time / 3600L - days * 24;
        long minutes = (time - (time / 3600L) * 3600L) / 60L;
        long seconds = time - (time / 3600L) * 3600L - minutes * 60L;
        
        String dias = null;
        String horas = null;
        String minutos = null;
        String segundos = null;

        if (days == 1) {
        	dias = days + "d ";
        }else if (days > 1) {
        	dias = days + "d ";
        }else{
        	dias = "";
        }
        
        if (hours == 1) {
        	horas =  hours + "h ";
        }else if (hours > 1) {
        	horas =  hours + "h ";
        }else{
        	horas = "";
        }
        
        if (minutes == 1) {
        	minutos =  minutes + "m ";
        }else if (minutes > 1) {
        	minutos =  minutes + "m ";
        }else{
        	minutos = "";
        }
        
        if (seconds == 1) {
        	segundos = seconds + "s";
        }else if (seconds > 1) {
        	segundos = seconds + "s";
        }else{
        	segundos = "";
        }
        
        return dias + horas + minutos + segundos;  
    }
	
	public static void giveKit(Player player, KitType kit) {
		if (kit == KitType.NOVATO) {
			if (ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown." + kit.toString().toLowerCase()) == -50 || !ConfigManager.getStats().contains("Jugadores." + player.getName() + ".Cooldown." + kit.toString().toLowerCase())){
				ItemStack firesword = new ItemStack(Material.IRON_SWORD);
				firesword.addEnchantment(Enchantment.FIRE_ASPECT, 1);
				player.getInventory().addItem(firesword);
				
				player.getInventory().addItem(new ItemStack(Material.APPLE, 12));
				player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
				player.getInventory().addItem(new ItemStack(Material.STONE_AXE));
				
				player.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
				player.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
				player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
				player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
				
				player.closeInventory();
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
				
				player.sendMessage("§c§lSUPREMO >> §f¡Ahora tienes el kit §cNOVATO§f, utilizalo bien!");
				
				startCooldown(player.getName(), KitType.NOVATO, 86400);
			}else {
				long time = ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown." + kit.toString().toLowerCase());
				
				player.sendMessage("§c§lSUPREMO >> §f¡Tienes que esperar §c" + timeStringFor(time) + "§f para recibir el kit!");
				
				player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
			}
		}else if (kit == KitType.AVANZADO) {
			if (ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown." + kit.toString().toLowerCase()) == -50 || !ConfigManager.getStats().contains("Jugadores." + player.getName() + ".Cooldown." + kit.toString().toLowerCase())){
				ItemStack botas = new ItemStack(Material.IRON_BOOTS);
				botas.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack casco = new ItemStack(Material.IRON_HELMET);
				casco.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack panta = new ItemStack(Material.IRON_LEGGINGS);
				panta.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack peche = new ItemStack(Material.IRON_CHESTPLATE);
				peche.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				
				ItemStack firesword = new ItemStack(Material.DIAMOND_SWORD);
				firesword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				
				player.getInventory().addItem(firesword);
				
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
				player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
				player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
				
				player.getInventory().addItem(casco);
				player.getInventory().addItem(peche);
				player.getInventory().addItem(panta);
				player.getInventory().addItem(botas);
				
				player.closeInventory();
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
				
				player.sendMessage("§c§lSUPREMO >> §f¡Ahora tienes el kit §cAVANZADO§f, utilizalo bien!");
				
				startCooldown(player.getName(), KitType.AVANZADO, 86400 * 2);
			}else {
				long time = ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown." + kit.toString().toLowerCase());
				
				player.sendMessage("§c§lSUPREMO >> §f¡Tienes que esperar §c" + timeStringFor(time) + "§f para recibir el kit!");
				
				player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
			}
		}else if (kit == KitType.COMANDANTE) {
			if (ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown." + kit.toString().toLowerCase()) == -50 || !ConfigManager.getStats().contains("Jugadores." + player.getName() + ".Cooldown." + kit.toString().toLowerCase())){
				ItemStack botas = new ItemStack(Material.IRON_BOOTS);
				botas.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				
				ItemStack casco = new ItemStack(Material.IRON_HELMET);
				casco.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				
				ItemStack panta = new ItemStack(Material.IRON_LEGGINGS);
				panta.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				
				ItemStack peche = new ItemStack(Material.IRON_CHESTPLATE);
				peche.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				
				ItemStack firesword = new ItemStack(Material.DIAMOND_SWORD);
				firesword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
				
				player.getInventory().addItem(firesword);
				
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 5));
				player.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE));
				player.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
				
				player.getInventory().addItem(casco);
				player.getInventory().addItem(peche);
				player.getInventory().addItem(panta);
				player.getInventory().addItem(botas);
				
				player.closeInventory();
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
				
				player.sendMessage("§c§lSUPREMO >> §f¡Ahora tienes el kit §cCOMANDANTE§f, utilizalo bien!");
				
				startCooldown(player.getName(), KitType.COMANDANTE, 86400 * 4);
			}else {
				long time = ConfigManager.getStats().getInt("Jugadores." + player.getName() + ".Cooldown." + kit.toString().toLowerCase());
				
				player.sendMessage("§c§lSUPREMO >> §f¡Tienes que esperar §c" + timeStringFor(time) + "§f para recibir el kit!");
				
				player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
			}
		}
	}
}
