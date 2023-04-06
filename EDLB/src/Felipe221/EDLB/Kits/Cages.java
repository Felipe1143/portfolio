package Felipe221.EDLB.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import Felipe221.EDLB.Main;
import Felipe221.EDLB.Utils;
import net.md_5.bungee.api.ChatColor;

public enum Cages {
	NARANJA, BLANCA, ROJA, CIAN, VIOLETA, VERDE_CLARO, ROSA, NEGRA, GRIS, GRIS_OSCURO, AZUL_CLARO, MARRON, PURPURA, AMARILLA,  VERDE, AZUL, NORMAL;
		
	public static List<Player> amarilla = new ArrayList<>();
	public static List<Player> naranja = new ArrayList<>();
	public static List<Player> blanca = new ArrayList<>();
	public static List<Player> roja = new ArrayList<>();
	public static List<Player> cian = new ArrayList<>();
	public static List<Player> violeta = new ArrayList<>();
	public static List<Player> verdeclaro = new ArrayList<>();
	public static List<Player> rosa = new ArrayList<>();
	public static List<Player> negra = new ArrayList<>();
	public static List<Player> gris = new ArrayList<>();
	public static List<Player> grisoscuro = new ArrayList<>();
	public static List<Player> azulclaro = new ArrayList<>();
	public static List<Player> marron = new ArrayList<>();
	public static List<Player> purpura = new ArrayList<>();
	public static List<Player> verde = new ArrayList<>();
	public static List<Player> azul = new ArrayList<>();
	public static List<Player> normal = new ArrayList<>();

	
	public static Cages getCage(Player player) {
		Cages cages = NORMAL;
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Amarilla") {			
			cages = AMARILLA;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Naranja") {			
			cages = NARANJA;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Blanca") {			
			cages = BLANCA;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Roja") {			
			cages = ROJA;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Cian") {			
			cages = CIAN;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Violeta") {			
			cages = VIOLETA;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Verde claro") {			
			cages = VERDE_CLARO;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Rosa") {			
			cages = ROSA;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." +player.getName() + ".Caja") == "Negra") {			
			cages = NEGRA;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Gris") {			
			cages = GRIS;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Gris oscuro") {			
			cages = GRIS_OSCURO;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Marron") {			
			cages = MARRON;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Purpura") {			
			cages = PURPURA;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." +player.getName() + ".Caja") == "Verde") {			
			cages = VERDE;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Azul") {			
			cages = AZUL;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." +player.getName() + ".Caja") == "Azul claro") {			
			cages = AZUL_CLARO;
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Por defecto") {		
			cages = NORMAL;
		}
		
		return cages;
	}
	
	public static String getNameCage(Player player) {
		String cages = "Por defecto";
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Amarilla") {			
			cages = "Amarilla";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Naranja") {			
			cages = "Naranja";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." +player.getName() + ".Caja") == "Blanca") {			
			cages = "Blanca";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Roja") {			
			cages = "Roja";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Cian") {			
			cages = "Cian";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Violeta") {			
			cages = "Violeta";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." +player.getName() + ".Caja") == "Verde claro") {			
			cages = "Verde claro";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Rosa") {			
			cages = "Rosa";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Negra") {			
			cages = "Negra";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Gris") {			
			cages = "Gris";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Gris oscuro") {			
			cages = "Gris oscuro";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Marron") {			
			cages = "Marrón";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Purpura") {			
			cages = "Purpura";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Verde") {			
			cages = "Verde";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Azul") {			
			cages = "Azul";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Azul claro") {			
			cages = "Azul claro";
		}
		
		if (Main.plugin.getConfig().get("Jugadores." + player.getName() + ".Caja") == "Por defecto") {			
			cages = "Por defecto";
		}
		
		return cages;
	}
	
	public static void removeBlock(Player player) {
		Location loc = player.getLocation();
		
		//ABAJO
		Block a = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY() -1, loc.getBlockZ());
		//ADELANTE-1
		Block b = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX() + 1, loc.getBlockY(), loc.getBlockZ());
		//ATRAS-1
		Block c = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX() - 1, loc.getBlockY(), loc.getBlockZ());
		//COSTADOS-1
		Block d = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ() + 1);
		Block e = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ() - 1);
		//COSTADOS-2
		Block f = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ() + 1);
		Block g = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ() - 1);
		//ADELANTE-2
		Block h = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX() + 1, loc.getBlockY() + 1, loc.getBlockZ());
		//ATRAS-2
		Block i = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX() - 1, loc.getBlockY() + 1, loc.getBlockZ());
		
		BlockState a1 = a.getState();
		a1.setType(Material.AIR);
		a1.update(true);
		
		BlockState b1 = b.getState();
		b1.setType(Material.AIR);
		b1.update(true);
		
		BlockState c1 = c.getState();
		c1.setType(Material.AIR);
		c1.update(true);
		
		BlockState d1 = d.getState();
		d1.setType(Material.AIR);
		d1.update(true);
		
		BlockState e1 = e.getState();
		e1.setType(Material.AIR);
		e1.update(true);
		
		BlockState f1 = f.getState();
		f1.setType(Material.AIR);
		f1.update(true);
		
		BlockState g1 = g.getState();
		g1.setType(Material.AIR);
		g1.update(true);
		
		BlockState h1 = h.getState();
		h1.setType(Material.AIR);
		h1.update(true);
		
		BlockState i1 = i.getState();
		i1.setType(Material.AIR);
		i1.update(true);
	
	}
	
	@SuppressWarnings("deprecation")
	public static void giveCage(Player player, Cages cage) {
		Location loc = player.getLocation();
		
		//ABAJO
		Block a = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY() -1, loc.getBlockZ());
		//ADELANTE-1
		Block b = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX() + 1, loc.getBlockY(), loc.getBlockZ());
		//ATRAS-1
		Block c = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX() - 1, loc.getBlockY(), loc.getBlockZ());
		//COSTADOS-1
		Block d = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ() + 1);
		Block e = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ() - 1);
		//COSTADOS-2
		Block f = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ() + 1);
		Block g = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ() - 1);
		//ADELANTE-2
		Block h = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX() + 1, loc.getBlockY() + 1, loc.getBlockZ());
		//ATRAS-2
		Block i = Bukkit.getWorld(player.getWorld().getName()).getBlockAt(loc.getBlockX() - 1, loc.getBlockY() + 1, loc.getBlockZ());
		
		if (cage == Cages.AMARILLA) {
			byte id = 4;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.VERDE_CLARO) {
			byte id = 5;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
				
				BlockState b1 = b.getState();
				b1.setType(Material.STAINED_GLASS);
				MaterialData b2 = b1.getData();
				b2.setData(id);
				b1.update(true);
				
				BlockState c1 = c.getState();
				c1.setType(Material.STAINED_GLASS);
				MaterialData c2 = c1.getData();
				c2.setData(id);
				c1.update(true);
				
				BlockState d1 = d.getState();
				d1.setType(Material.STAINED_GLASS);
				MaterialData d2 = d1.getData();
				d2.setData(id);
				d1.update(true);
				
				BlockState e1 = e.getState();
				e1.setType(Material.STAINED_GLASS);
				MaterialData e2 = e1.getData();
				e2.setData(id);
				e1.update(true);
				
				BlockState f1 = f.getState();
				f1.setType(Material.STAINED_GLASS);
				MaterialData f2 = f1.getData();
				f2.setData(id);
				f1.update(true);
				
				BlockState g1 = g.getState();
				g1.setType(Material.STAINED_GLASS);
				MaterialData g2 = g1.getData();
				g2.setData(id);
				g1.update(true);
				
				BlockState h1 = h.getState();
				h1.setType(Material.STAINED_GLASS);
				MaterialData h2 = h1.getData();
				h2.setData(id);
				h1.update(true);
				
				BlockState i1 = i.getState();
				i1.setType(Material.STAINED_GLASS);
				MaterialData i2 = i1.getData();
				i2.setData(id);
				i1.update(true);
				
		}else if (cage == Cages.CIAN){
			byte id = 9;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.BLANCA) {
			byte id = 0;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.NORMAL) {
			BlockState a1 = a.getState();
			a1.setType(Material.GLASS);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.GLASS);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.GLASS);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.GLASS);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.GLASS);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.GLASS);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.GLASS);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.GLASS);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.GLASS);
			i1.update(true);
		}else if (cage == Cages.NARANJA) {
			byte id = 1;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.VIOLETA) {
			byte id = 2;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.AZUL_CLARO) {
			byte id = 3;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.ROSA) {
			byte id = 6;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.GRIS) {
			byte id = 8;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.GRIS_OSCURO) {
			byte id = 7;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.PURPURA) {
			byte id = 10;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.AZUL) {
			byte id = 11;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.MARRON) {
			byte id = 12;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.VERDE) {
			byte id = 13;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.NEGRA) {
			byte id = 15;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}else if (cage == Cages.ROJA) {
			byte id = 14;
			BlockState a1 = a.getState();
			a1.setType(Material.STAINED_GLASS);
			MaterialData a2 = a1.getData();
			a2.setData(id);
			a1.update(true);
			
			BlockState b1 = b.getState();
			b1.setType(Material.STAINED_GLASS);
			MaterialData b2 = b1.getData();
			b2.setData(id);
			b1.update(true);
			
			BlockState c1 = c.getState();
			c1.setType(Material.STAINED_GLASS);
			MaterialData c2 = c1.getData();
			c2.setData(id);
			c1.update(true);
			
			BlockState d1 = d.getState();
			d1.setType(Material.STAINED_GLASS);
			MaterialData d2 = d1.getData();
			d2.setData(id);
			d1.update(true);
			
			BlockState e1 = e.getState();
			e1.setType(Material.STAINED_GLASS);
			MaterialData e2 = e1.getData();
			e2.setData(id);
			e1.update(true);
			
			BlockState f1 = f.getState();
			f1.setType(Material.STAINED_GLASS);
			MaterialData f2 = f1.getData();
			f2.setData(id);
			f1.update(true);
			
			BlockState g1 = g.getState();
			g1.setType(Material.STAINED_GLASS);
			MaterialData g2 = g1.getData();
			g2.setData(id);
			g1.update(true);
			
			BlockState h1 = h.getState();
			h1.setType(Material.STAINED_GLASS);
			MaterialData h2 = h1.getData();
			h2.setData(id);
			h1.update(true);
			
			BlockState i1 = i.getState();
			i1.setType(Material.STAINED_GLASS);
			MaterialData i2 = i1.getData();
			i2.setData(id);
			i1.update(true);
		}
	}
	
	public static void setCage(Player player, Cages cage) {
		if (cage == NORMAL) {
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Por defecto");
			Main.plugin.saveConfig();
		}
		
		if (cage == BLANCA) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Blanca");
			Main.plugin.saveConfig();
		}
		
		if (cage == NARANJA) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Naranja");
			Main.plugin.saveConfig();
		}
		
		if (cage == AMARILLA) {					
			Main.plugin.getConfig().set("Jugadores." +player.getName() + ".Caja", "Amarilla");
			Main.plugin.saveConfig();
		}
		
		if (cage == VIOLETA) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Violeta");
			Main.plugin.saveConfig();
		}
		
		if (cage == AZUL_CLARO) {						
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Azul claro");
			Main.plugin.saveConfig();
		}
		
		if (cage == VERDE_CLARO) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Verde claro");
			Main.plugin.saveConfig();
		}
		
		if (cage == ROSA) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Rosa");
			Main.plugin.saveConfig();
		}
		
		if (cage == NEGRA) {						
			Main.plugin.getConfig().set("Jugadores." +player.getName() + ".Caja", "Negra");
			Main.plugin.saveConfig();
		}
		
		if (cage == GRIS) {			
			Main.plugin.getConfig().set("Jugadores." +player.getName() + ".Caja", "Gris");
			Main.plugin.saveConfig();
		}
		
		if (cage == GRIS_OSCURO) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Gris oscuro");
			Main.plugin.saveConfig();
		}
		
		if (cage == CIAN) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Cian");
			Main.plugin.saveConfig();
		}
		
		if (cage == PURPURA) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Purpura");
			Main.plugin.saveConfig();
		}
		
		if (cage == AZUL) {				
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Azul");
			Main.plugin.saveConfig();
		}
		
		if (cage == MARRON) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Marron");
			Main.plugin.saveConfig();
		}
		
		if (cage == VERDE) {					
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Verde");
			Main.plugin.saveConfig();
		}
		
		if (cage == ROJA) {					
			Main.plugin.getConfig().set("Jugadores." +player.getName() + ".Caja", "Roja");
			Main.plugin.saveConfig();
		}
	}
	
	public static void removeCage(Player player) {
		if (blanca.contains(player)) {
			blanca.remove(player);
		}
		
		if (naranja.contains(player)) {
			naranja.remove(player);
		}
		
		if (violeta.contains(player)) {
			violeta.remove(player);
		}
		
		if (azulclaro.contains(player)) {
			azulclaro.remove(player);
		}
		
		if (amarilla.contains(player)) {
			amarilla.remove(player);
		}
		
		if (verdeclaro.contains(player)) {
			verdeclaro.remove(player);
		}
		
		if (rosa.contains(player)) {
			rosa.remove(player);
		}
		
		if (grisoscuro.contains(player)) {
			grisoscuro.remove(player);
		}
		
		if (gris.contains(player)) {
			gris.remove(player);
		}
		
		if (cian.contains(player)) {
			cian.remove(player);
		}
		
		if (purpura.contains(player)) {
			purpura.remove(player);
		}
		
		if (marron.contains(player)) {
			marron.remove(player);
		}
		
		if (roja.contains(player)) {
			roja.remove(player);
		}
		
		if (negra.contains(player)) {
			negra.remove(player);
		}
		
		if (normal.contains(player)) {
			normal.remove(player);
		}
		
		if (verde.contains(player)) {
			verde.remove(player);
		}
		
		if (azul.contains(player)) {
			azul.remove(player);
		}

	}
	
	public static void setCageList(Player player) {
		if (!Main.plugin.getConfig().contains("Jugadores." + player.getName() + ".Caja")) {
			Main.plugin.getConfig().set("Jugadores." + player.getName() + ".Caja", "Por defecto");
			Main.plugin.saveConfig();
			normal.add(player);
		}
	}
}
