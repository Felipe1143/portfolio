package Felipe221.EDLB.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Felipe221.EDLB.Stats.StatsAPI;

public enum Kit {	
	PRINCIPIANTE, INGENIERO, ARQUERO, GUERRERO ,CAPATAZ, LEÑADOR, RUSHER, CAMUFLADO, VIP;
	
	static List<Player> prin = new ArrayList<>();
	static List<Player> ingeniero = new ArrayList<>();
	static List<Player> arquero = new ArrayList<>();
	static List<Player> guerrero = new ArrayList<>();
	static List<Player> capataz = new ArrayList<>();
	static List<Player> leñador = new ArrayList<>();
	static List<Player> rusher = new ArrayList<>();
	static List<Player> camuflado = new ArrayList<>();
	
	public static Kit getKit(Player player) {
		Kit kit = null;
		
		if (prin.contains(player)) {			
			kit = PRINCIPIANTE;
		}
		
		if (ingeniero.contains(player)) {			
			kit = INGENIERO;
		}
		
		if (arquero.contains(player)) {			
			kit = ARQUERO;
		}
		
		if (guerrero.contains(player)) {			
			kit = GUERRERO;
		}
		
		if (capataz.contains(player)) {			
			kit = CAPATAZ;
		}
		
		if (leñador.contains(player)) {			
			kit = LEÑADOR;
		}
		
		if (rusher.contains(player)) {			
			kit = RUSHER;
		}
		
		if (camuflado.contains(player)) {			
			kit = CAMUFLADO;
		}				
		return kit;
	}
	
	public static String getNameKit(Player player) {
		String kit = "Ninguno";
		
		if (prin.contains(player)) {			
			kit = "Principiante";
		}
		
		if (ingeniero.contains(player)) {			
			kit = "Ingeniero";
		}
		
		if (arquero.contains(player)) {			
			kit = "Arquero";
		}
		
		if (guerrero.contains(player)) {			
			kit = "Guerrero";
		}
		
		if (capataz.contains(player)) {			
			kit = "Capataz";
		}
		
		if (leñador.contains(player)) {			
			kit = "Leñador";
		}
		
		if (rusher.contains(player)) {			
			kit = "Rusher";
		}
		
		if (camuflado.contains(player)) {			
			kit = "Camuflado";
		}				
		return kit;
	}
	
	public static void giveKit(Player player, Kit kit) {
		if (kit == Kit.PRINCIPIANTE) {
			player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));			
			player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			
			player.getInventory().addItem(new ItemStack(Material.WOOD_SWORD));
			player.getInventory().addItem(new ItemStack(Material.WOOD_PICKAXE));
			player.getInventory().addItem(new ItemStack(Material.APPLE, 6));
		}
	}
	
	public static void setKit(Player player, Kit kit) {
		if (kit == PRINCIPIANTE) {
			prin.add(player);
		}
		
		if (kit == INGENIERO) {
			ingeniero.add(player);
		}
		
		if (kit == ARQUERO) {
			arquero.add(player);
		}
		
		if (kit == GUERRERO) {
			guerrero.add(player);
		}
		
		if (kit == CAPATAZ) {
			capataz.add(player);
		}
		
		if (kit == LEÑADOR) {
			leñador.add(player);
		}
		
		if (kit == RUSHER) {
			rusher.add(player);
		}
		
		if (kit == CAMUFLADO) {
			camuflado.add(player);
		}				
	}
	
	public static void removeKit(Player player) {
		if (prin.contains(player)) {
			prin.remove(player);
		}
		
		if (ingeniero.contains(player)) {
			ingeniero.remove(player);
		}
		
		if (arquero.contains(player)) {
			arquero.remove(player);
		}
		
		if (guerrero.contains(player)) {
			guerrero.remove(player);
		}
		
		if (capataz.contains(player)) {
			capataz.remove(player);
		}
		
		if (leñador.contains(player)) {
			leñador.remove(player);
		}
		
		if (rusher.contains(player)) {
			rusher.remove(player);
		}
		
		if (camuflado.contains(player)) {
			camuflado.remove(player);
		}
	}
		
	public static void menuKit(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 36, "Kits");
        
		ItemStack locked = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta locked1 = locked.getItemMeta();
		ArrayList<String> locked2= new ArrayList<String>();
	
		locked2.add("§7¡Compra este kit en la tienda!");
		locked2.add("");
		locked2.add("§7Para poder ganar puntos y");
		locked2.add("§7poder acceder a este kit deberás");
		locked2.add("§7asesinar o ganar partidas");
		locked2.add("");
		locked2.add("§7Tus puntos:§c " + StatsAPI.getCoins(player));
		locked2.add("§7Estado: §c§lBLOQUEADO");
		
		locked1.setLore(locked2);
		locked1.setDisplayName("§cKit bloqueado");			               

		locked.setItemMeta(locked1);				
		
		ItemStack prin = new ItemStack(Material.WOOD_SWORD);
		ItemMeta prinmeta = prin.getItemMeta();
		ArrayList<String> lore= new ArrayList<String>();
		
		prinmeta.setDisplayName("§aKit principiante");			               
		lore.add("§7¡Demuestra que puedes con poco!");
		lore.add("");
		lore.add("§7Contenido:");
		lore.add("     §a- §7Espada de madera");
		lore.add("     §a- §7Pico de madera");
		lore.add("     §a- §7Casco de cuero");
		lore.add("     §a- §7Botas de cuero");
		lore.add("     §a- §7Manzanas x6");
		lore.add("");
		lore.add("§7Estado: §a§lDESBLOQUEADO");
		
		prinmeta.setLore(lore);
		
		prin.setItemMeta(prinmeta);
		
		ItemStack arq = new ItemStack(Material.BOW);
		ItemMeta arq2 = prin.getItemMeta();
		ArrayList<String> lore2= new ArrayList<String>();
		
		arq2.setDisplayName("§aKit arquero");			               
		lore2.add("§7¡Demuestra tus habilidades con el arco!");
		lore2.add("");
		lore2.add("§7Contenido:");
		lore2.add("     §a- §7Arco (Infinidad I)");
		lore2.add("     §a- §7Flechas x1");
		lore2.add("     §a- §7Pantalones de cuero");
		lore2.add("");
		lore2.add("§7Estado: §a§lDESBLOQUEADO");
		
		arq2.setLore(lore2);
		
		arq.setItemMeta(arq2);
		
		ItemStack rusher = new ItemStack(Material.SUGAR);
		ItemMeta rusher2 = rusher.getItemMeta();
		ArrayList<String> lore3= new ArrayList<String>();
		
		rusher2.setDisplayName("§aKit rusher");
		
		lore3.add("§7¡Mata a todos rápido!");
		lore3.add("");
		lore3.add("§7Contenido:");
		lore3.add("     §a- §7Madera x20");
		lore3.add("     §a- §7Hacha de hierro");
		lore3.add("     §a- §7Manzanas x6");
		lore3.add("");
		lore3.add("§7Habilidad especial: §aVelocidad II" );
		lore3.add("§7Estado: §a§lDESBLOQUEADO");
		
		rusher2.setLore(lore3);
		
		rusher.setItemMeta(rusher2);
		
	    if (player.hasPermission("kit.prin")) {       		  
	    	join.setItem(11, prin);
	    }else {
	    	join.setItem(11, locked);			    	
	    }
	    
	    if (player.hasPermission("kit.arq")) {       		  
	    	join.setItem(12, arq);
	    }else {
	    	join.setItem(12, locked);			    	
	    }
	    
	    if (player.hasPermission("kit.rusher")) {       		  
	    	join.setItem(15, rusher);
	    }else {
	    	join.setItem(15, locked);			    	
	    }
	    
		player.openInventory(join);	
	}
		
}
