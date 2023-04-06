package Felipe221.EDLB.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Felipe221.EDLB.Utils;
import Felipe221.EDLB.Arenas.ArenaManager;
import Felipe221.EDLB.Stats.StatsAPI;

public enum Clima {
	TORMENTA, SOLEADO, NEVADO;

	public static HashMap<String, Integer> votes = new HashMap<String, Integer>();
	public static List<Player> votantes = new ArrayList();

	int tormentaV = 0;
	int soleadoV = 0;
	int nevadoV = 0;
	
	public static void setClima(String arena) {
		if (arena.equals("Olimpo")) {
			if (getWinner("Olimpo") == "Tormenta") {
				Bukkit.getWorld("Olimpo").setStorm(true);
				Bukkit.getWorld("Olimpo").setThundering(true);
			}
			
			if (getWinner("Olimpo") == "Despejado") {
				Bukkit.getWorld("Olimpo").setStorm(false);
				Bukkit.getWorld("Olimpo").setThundering(false);
			}
			
			if (getWinner("Olimpo") == "Nevado") {
				Bukkit.getWorld("Olimpo").setBiome(1, 1, Biome.SKY);
			}
		}
	}
	
	public static void addVote(Player player, Clima clima) {
		String arena = ArenaManager.getPlayerArena(player);
		
		if (arena.equals("Olimpo")) {
			if (player.hasPermission("clima.vote")) {
				if (clima == Clima.TORMENTA) {
					if (votantes.contains(player)) {
						player.sendMessage(ChatColor.RED + "¡Tú voto no puede ser cambiado!");
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
						player.closeInventory();
					}else{
						votantes.add(player);
						player.closeInventory();
						player.playSound(player.getLocation(), Sound.LAVA_POP, 1, 1);
						votes.put("OlimpoTormenta", votes.get("OlimpoTormenta")+1);
						player.sendMessage("§f¡Tú voto fue §aagregado §fcorrectamente!");
						player.sendMessage("§f");
						player.sendMessage("§fVotación:");
						player.sendMessage("   §a- §fTormenta: §a" + getVotes("Olimpo", Clima.TORMENTA));
						player.sendMessage("   §a- §fDespejado: §a" + getVotes("Olimpo", Clima.SOLEADO));
						player.sendMessage("   §a- §fNevado: §a" + getVotes("Olimpo", Clima.NEVADO));
						player.sendMessage("");
						for (Player players : ArenaManager.getListPlayers("Olimpo")) {
							if (getVotes("Olimpo", Clima.TORMENTA) == 1) {
								players.sendMessage("§a>> §fEl jugador §a" + player.getName() + " §fvotó por §aTormenta §f- §a(" + getVotes("Olimpo", Clima.TORMENTA) + " voto)");				
							}else{
								players.sendMessage("§a>> §fEl jugador §a" + player.getName() + " §fvotó por §aTormenta §f- §a(" + getVotes("Olimpo", Clima.TORMENTA) + " votos)");				
							}
						}
					}
				}
				
				if (clima == Clima.SOLEADO) {
					if (votantes.contains(player)) {
						player.closeInventory();
						player.sendMessage(ChatColor.RED + "¡Tú voto no puede ser cambiado!");
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
					}else{
						votantes.add(player);
						player.closeInventory();
						player.playSound(player.getLocation(), Sound.LAVA_POP, 1, 1);
						votes.put("OlimpoSoleado", votes.get("OlimpoSoleado")+1);
						player.sendMessage("§f¡Tú voto fue §aagregado §fcorrectamente!");
						player.sendMessage("§f");
						player.sendMessage("§fVotación:");
						player.sendMessage("   §a- §fTormenta: §a" + getVotes("Olimpo", Clima.TORMENTA));
						player.sendMessage("   §a- §fDespejado: §a" + getVotes("Olimpo", Clima.SOLEADO));
						player.sendMessage("   §a- §fNevado: §a" + getVotes("Olimpo", Clima.NEVADO));
						player.sendMessage("");
						for (Player players : ArenaManager.getListPlayers("Olimpo")) {
							if (getVotes("Olimpo", Clima.SOLEADO) == 1) {
								players.sendMessage("§a>> §fEl jugador §a" + player.getName() + " §fvotó por §aDespejado §f- §a(" + getVotes("Olimpo", Clima.SOLEADO) + " voto)");				
							}else{
								players.sendMessage("§a>> §fEl jugador §a" + player.getName() + " §fvotó por §aDespejado §f- §a(" + getVotes("Olimpo", Clima.SOLEADO) + " votos)");				
							}
						}
					}
				}
				
				if (clima == Clima.NEVADO) {
					if (votantes.contains(player)) {
						player.closeInventory();
						player.sendMessage(ChatColor.RED + "¡Tú voto no puede ser cambiado!");
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
					}else{
						votantes.add(player);
						player.closeInventory();
						player.playSound(player.getLocation(), Sound.LAVA_POP, 1, 1);
						votes.put("OlimpoNevado", votes.get("OlimpoNevado")+1);
						player.sendMessage("§f¡Tú voto fue §aagregado §fcorrectamente!");
						player.sendMessage("§f");
						player.sendMessage("§fVotación:");
						player.sendMessage("   §a- §fTormenta: §a" + getVotes("Olimpo", Clima.TORMENTA));
						player.sendMessage("   §a- §fSoleado: §a" + getVotes("Olimpo", Clima.SOLEADO));
						player.sendMessage("   §a- §fNevado: §a" + getVotes("Olimpo", Clima.NEVADO));
						player.sendMessage("§f");
						for (Player players : ArenaManager.getListPlayers("Olimpo")) {
							if (getVotes("Olimpo", Clima.NEVADO) == 1) {
								players.sendMessage("§a>> §fEl jugador §a" + player.getName() + " §fvotó por §aNevado §f- §a(" + getVotes("Olimpo", Clima.NEVADO) + " voto)");				
							}else{
								players.sendMessage("§a>> §fEl jugador §a" + player.getName() + " §fvotó por §aNevado §f- §a(" + getVotes("Olimpo", Clima.NEVADO) + " votos)");				
							}
						}
					}
				}
			}else{
				player.closeInventory();
				player.sendMessage("§a>> §fPara poder usar ésta función deberás tener §a§lVIP");
				player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
			}
		}
	}
	
	public static int getVotes(String arena, Clima clima) {
		int vote = 0;		
		if (arena.equalsIgnoreCase("Olimpo")) {
			if (clima == Clima.TORMENTA) {
				if (!votes.containsKey("OlimpoTormenta")) {
					votes.put("OlimpoTormenta", 0);
					vote = 0;
				}else {
					vote = votes.get("OlimpoTormenta");
				}
			}
			
			if (clima == Clima.SOLEADO) {
				if (!votes.containsKey("OlimpoSoleado")) {
					votes.put("OlimpoSoleado", 0);
					vote = 0;
				}else {
					vote = votes.get("OlimpoSoleado");
				}
			}
			
			if (clima == Clima.NEVADO) {
				if (!votes.containsKey("OlimpoNevado")) {
					votes.put("OlimpoNevado", 0);
					vote = 0;
				}else {
					vote = votes.get("OlimpoNevado");
				}
			}
		}
		return vote;
	}
	
	public static String getWinner(String arena) {
		String winner = null;
		
		if (arena.equalsIgnoreCase("Olimpo")) {
			int tormenta = getVotes("Olimpo", Clima.TORMENTA);
			int nevado = getVotes("Olimpo", Clima.NEVADO);
			int soleado = getVotes("Olimpo", Clima.SOLEADO);
			
			if (nevado == tormenta) {
				if (nevado == soleado) {
					if (soleado == tormenta) {
						if (soleado == nevado) {
							if (tormenta == nevado) {
								if (tormenta == soleado) {
				                    Random r = new Random();
				                    
				                    int nueve = r.nextInt(90);				    
				                    
				                    if(nueve < 30){
				                    	votes.put("OlimpoTormenta", votes.get("OlimpoTormenta")+1);
				                    }
				                    
				                    if (nueve <= 60) {
				                    	if (nueve >= 30) {
				                    		votes.put("OlimpoSoleado", votes.get("OlimpoSoleado")+1);
				                    	}
				                    }
				                    if (nueve <= 90) {
				                    	if (nueve > 60) {
				                    		votes.put("OlimpoNevado", votes.get("OlimpoNevado")+1);
				                    	}
				                    }
								}
							}
						}
					}
				}
			}
			
			if (tormenta > nevado) {
				if (tormenta > soleado) {
					winner = "Tormenta";
				}
			}
			
			if (soleado > nevado) {
				if (soleado > tormenta) {
					winner = "Despejado";
				}
			}
			
			if (nevado > tormenta) {
				if (nevado > soleado) {
					winner = "Nevado";
				}
			}
			
			//YA TENEMOS:
			//TORMENTA == NEVADO -
			//TORMENTA == SOLEADO -
			//--------------------
			//SOLEADO == NEVADO -
			//SOLEADO == TORMENTA --> NO SE HACE, DUPLICADO
			//--------------------
			//NEVADO == SOLEADO --> NO SE HACE, DUPLICADO
			//NEVADO == TORMENTA --> NO SE HACE, DUPLICADO
			
			//TORMENTA Y NEVADO 1-1
			if (nevado == tormenta) {
				if (nevado > soleado) {
					if (tormenta > soleado) {
						Random r = new Random();
	                    
	                    int i = 30;
	                    int i2 = 60;
	                    
	                    if(r.nextInt(60) <= i){
	                    	winner = "Tormenta";
	                    }else if (r.nextInt(60) <= i2) {
	                    	winner = "Nevado";
	                    }
					}
				}
			}
			
			//TORMENTA Y SOLEADO 1-1
			if (tormenta == soleado) {
				if (tormenta > nevado) {
					if (soleado > nevado) {
						Random r = new Random();
	                    
	                    int i = 30;
	                    int i2 = 60;
	                    
	                    if(r.nextInt(60) <= i){
	                    	winner = "Tormenta";
	                    }else if (r.nextInt(60) <= i2) {
	                    	winner = "Despejado";
	                    }
					}
				}
			}
			
			//SOLEADO Y NEVADO 1-1
			if (nevado == soleado) {
				if (nevado > tormenta) {
					if (soleado > tormenta) {
						Random r = new Random();
	                    
	                    int i = 30;
	                    int i2 = 60;
	                    
	                    if(r.nextInt(60) <= i){
	                    	winner = "Nevado";
	                    }else if (r.nextInt(60) <= i2) {
	                    	winner = "Despejado";
	                    }
					}
				}
			}			
		}		
		return winner;
	}
	
	public static void resetVotes(String arena) {
		if (arena.equals("Olimpo")) {
			votes.put("OlimpoTormenta", 0);
			votes.put("OlimpoNevado", 0);
			votes.put("OlimpoSoleado", 0);
		}
	}
	
	public static void menuClima(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 27, "Clima");
        			
		ItemStack tormen = new ItemStack(Material.WATER_BUCKET);
		ItemMeta tormenta = tormen.getItemMeta();
		ArrayList<String> lore= new ArrayList<String>();
		
		tormenta.setDisplayName("§bTormenta");		
		
		lore.add("§7¡No salgas sin tú paraguas!");
		lore.add("");
		lore.add("§7¡Si §bTormenta §7gana la votación");
		lore.add("§7se activará un gran diluvio");
		lore.add("§7durante toda la partida!");
		lore.add("");
		lore.add("§7Votos: §b" + getVotes("Olimpo", Clima.TORMENTA));
		
		tormenta.setLore(lore);
		
		tormen.setItemMeta(tormenta);
		
	    join.setItem(11, tormen);		
	    
	    ItemStack solea = Utils.get("349:3");
		ItemMeta soleado = solea.getItemMeta();
		ArrayList<String> lore1= new ArrayList<String>();
		
		soleado.setDisplayName("§eDespejado");		
		
		lore1.add("§7¿Y las nubes donde están?");
		lore1.add("");
		lore1.add("§7¡Si §eDespejado §7gana la votación");
		lore1.add("§7se desactivará cualquier tipo de");
		lore1.add("§7lluvia/nube durante toda la partida!");
		lore1.add("");
		lore1.add("§7Votos: §e" + getVotes("Olimpo", Clima.SOLEADO));
		
		soleado.setLore(lore1);
		
		solea.setItemMeta(soleado);
		
	    join.setItem(13, solea);	
	    
	    ItemStack nevado = Utils.get("351:15");;
		ItemMeta nevado2 = nevado.getItemMeta();
		ArrayList<String> lore2= new ArrayList<String>();
		
		nevado2.setDisplayName("§fNevado");		
		
		lore2.add("§7¡El sol está quemando!");
		lore2.add("");
		lore2.add("§7¡Si §fNevado §7gana la votación");
		lore2.add("§7se activará una gran tormenta de");
		lore2.add("§7nieve durante toda la partida!");
		lore2.add("");
		lore2.add("§7Votos: §f" + getVotes("Olimpo", Clima.NEVADO));
		
		nevado2.setLore(lore2);
		
		nevado.setItemMeta(nevado2);
		
	    join.setItem(15, nevado);	
	    
		player.openInventory(join);	
	}
}
