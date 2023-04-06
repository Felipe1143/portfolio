package Felipe221.EDLB.Arenas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import Felipe221.EDLB.ActionAPI;
import Felipe221.EDLB.Main;
import Felipe221.EDLB.Utils;
import Felipe221.EDLB.Kits.Cages;
import Felipe221.EDLB.Kits.Clima;
import Felipe221.EDLB.Kits.Kit;
import Felipe221.EDLB.Stats.StatsAPI;

public class ArenaManager implements Listener{
	static StatsAPI stats;
	
    private static List<Player> espectadores = new ArrayList<>();
    private static List<Player> ingame = new ArrayList<>();
    private static List<Player> espera = new ArrayList<>();
    private static List<Player> lobby = new ArrayList<>();
	
	//ESPECTADOR
    private static List<Player> olimpoes = new ArrayList<>();
	//EN JUEGO
    private static List<Player> olimpoga = new ArrayList<>();
	//ESPERA
    private static List<Player> olimpowa = new ArrayList<>();
	
	
    private static  List<String> arenas = new ArrayList<>();
	
    private static List<Player> kit = new ArrayList<>();
	
    public static int time = 30;
    public static int time1 = 15;
    public static String listo = "";
    
    private static int taskId = -1;
    private static int taskId2 = -1;
	
	public static List<Player> getEspectadores(String arena) {	
		List<Player> total = new ArrayList<>();
		
		if (arena.equalsIgnoreCase("Olimpo")) {
			for (Player players : olimpoes) {
				total.add(players);
			}
		}
		
		return total;
	}
	
	public static List<Player> getLobbyPlayers() {
		return lobby;
	}
	
	public static List<Player> getInGamePlayers(String arena) {
		List<Player> total = new ArrayList<>();
		
		if (arena.equalsIgnoreCase("Olimpo")) {
			for (Player players : olimpoga) {
				total.add(players);
			}
		}
		
		return total;
	}
	
	public static List<Player> getEsperaPlayers(String arena) {
		List<Player> total = new ArrayList<>();
		
		if (arena.equalsIgnoreCase("Olimpo")) {
			for (Player players : olimpowa) {
				total.add(players);
			}
		}
		
		return total;
	}
	
	public static List<Player> getListPlayers(String arena) {
		List<Player> players = new ArrayList<>();
		
		if (arena.equalsIgnoreCase("Olimpo")) {
			List<Player> inGame = getInGamePlayers(arena);
			List<Player> Espera = getEsperaPlayers(arena);
			List<Player> Espectador = getEspectadores(arena);
			
			for (Player ingame : inGame) {
				players.add(ingame);
			}
			
			for (Player espectador : Espectador) {
				players.add(espectador);
			}
			
			for (Player espera : Espera) {
				players.add(espera);
			}
		}
		return players;
	}
		
	public static int getPlayers(String arena) {
		int players = 0;
		
		if (arena.equalsIgnoreCase("Olimpo")) {
			int inGame = getInGamePlayers("Olimpo").size();
			int Espera = getEsperaPlayers("Olimpo").size();
			
			players = inGame + Espera;
		}
		
		return players;
	}		
	
	public static String getPlayerArena(Player player) {
		String arena = "";
		
		if (getLobbyPlayers().contains(player)) {
			arena = "";
		}
		
		if (olimpowa.contains(player) || olimpoes.contains(player) || olimpoga.contains(player)) {
			arena = "Olimpo";
		}
		
		return arena;
	}
	
	public static void PlayerAdd(Player player, String arena) {
		if (!getInGamePlayers(arena).contains(player) && !getEsperaPlayers(arena).contains(player) && !getEspectadores(arena).contains(player)) {
			if (getLobbyPlayers().contains(player)) {
				if (arena.equals("Olimpo")) {
					if (Arena.ArenaStatus("Olimpo").equals("Espera")) {
						if (Arena.bajando.equals("No")) {
							player.teleport(new Location(Bukkit.getWorld("Olimpo"), 12, 186, 14));
						}else {
							player.teleport(new Location(Bukkit.getWorld("Olimpo"), 12, 186, 14));
						}
						getLobbyPlayers().remove(player);
						
						player.setMaxHealth(20);
						player.setHealth(20);
						player.setGameMode(GameMode.SURVIVAL);
						player.setLevel(0);
						player.setFoodLevel(20);
											
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);	
						
						player.getInventory().clear();
						
						if (Clima.votantes.contains(player)) {
							Clima.votantes.remove(player);								
						}
															
						olimpowa.add(player);
								
						Arena.checkStart("Olimpo");
													
						for (Player players : getListPlayers("Olimpo")) {
							players.sendMessage("§a>> §f¡El jugador §a" + player.getName() + " §fse unió! §a(" + getPlayers("Olimpo") + "/12)");
						}
								
						player.sendMessage("§a");
						player.sendMessage("¿Tendrás lo necesario para §aganar§f?");
						
						}else{
							player.sendMessage("§c¡La partida ya comenzó!");
						}
				}
			
			}else{
				player.sendMessage(ChatColor.RED + "¡Ya estás en una partida!");
			}
		}	
	}
	
	public static void RemovePlayer(Player player, String arena) {
			if (getInGamePlayers(arena).contains(player) || getEspectadores(arena).contains(player) || getEsperaPlayers(arena).contains(player)) {
				if (!getLobbyPlayers().contains(player)) {
					
					getInGamePlayers(arena).remove(player);
					getEsperaPlayers(arena).remove(player);
					getEspectadores(arena).remove(player);
					
					getLobbyPlayers().add(player);
					
					player.setHealth(20);
					player.setGameMode(GameMode.SURVIVAL);
					player.setLevel(0);
					player.setFoodLevel(20);
					
					Kit.removeKit(player);
					kit.remove(player);
														
					player.getInventory().clear();
					
					player.sendMessage("");			
					player.sendMessage("");			
					player.sendMessage("");			
					player.sendMessage("");					
					player.sendMessage("§a>> §f¡Saliste de la §apartida§f!");
					player.sendMessage("");
					player.sendMessage("§aTeletransportando al lobby...");
					
					ItemStack games = new ItemStack(Material.EYE_OF_ENDER);
					ItemMeta games2 = games.getItemMeta();
						
					games2.setDisplayName("§eArenas §7(Click derecho)");			               				
					games.setItemMeta(games2);
						
					ItemStack shop = new ItemStack(Material.NETHER_STAR);
					ItemMeta shop2 = shop.getItemMeta();
						
					shop2.setDisplayName("§bTienda §7(Click derecho)");			               
						
					shop.setItemMeta(shop2);
					
					ItemStack shop1 = new ItemStack(Material.SLIME_BALL);
					ItemMeta shop21 = shop1.getItemMeta();
						
					shop21.setDisplayName("§aVanidad §7(Click derecho)");			               
						
					shop1.setItemMeta(shop21);
					
					ItemStack stats = new ItemStack(Material.PAPER);
					ItemMeta stats1 = stats.getItemMeta();
						
					stats1.setDisplayName("§6Estadisticas §7(Click derecho)");			               
						
					stats.setItemMeta(stats1);
						
					player.getInventory().setItem(0, games);
					player.getInventory().setItem(1, stats);
					player.getInventory().setItem(4, shop);
					player.getInventory().setItem(8, shop1);				
					
					if (arena.equals("Olimpo")) {						
						if (time > 0 && listo.equals("No")){
							Cages.removeBlock(player);
						}
						
						olimpoga.remove(player);
						olimpowa.remove(player);
						olimpoes.remove(player);
						
						getInGamePlayers("Olimpo").remove(player);
						getEsperaPlayers("Olimpo").remove(player);
						getEspectadores("Olimpo").remove(player);
						
						if (Clima.votantes.contains(player)) {
							Clima.votantes.remove(player);
						}
						
						for (Player players : getListPlayers("Olimpo")) {
							if (Arena.ArenaStatus("Olimpo") == "Espera") {
								players.sendMessage("§a>> §f¡El jugador §a" + player.getName() + " §fsalió! §a(" + getPlayers("Olimpo") + "/12)");
							}
						}
						
						if (getPlayers("Olimpo") == 1) {
							for (Player ingame : getInGamePlayers("Olimpo")) {
								GameWinner("Olimpo", ingame);
							}
						}
						
						if (getPlayers("Olimpo") == 0) {
							Clima.resetVotes("Olimpo");
							
							reset();
						}
					}					
					player.teleport(new Location(Bukkit.getWorld("Lobby"), 167, 176, -201, -0.1F, -16F));
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
				}
			}					
		}
	
	public static void reset() {
		Bukkit.getScheduler().cancelTask(taskId2);
		Bukkit.getScheduler().cancelTask(taskId);
		Bukkit.getScheduler().cancelTask(Arena.taskId);
		
		listo = "No";
		taskId = -1;
		time = 30;
		
		Arena.taskId = -1;
		Arena.time = 15;
		Arena.bajando = "No se";
		
		time1 = 15;
	}

	
	public static void addEspectador(Player player, String arena) {
		if (arena.equals("Olimpo")) {
			player.sendMessage("");
			player.sendMessage("§a>> §f¡Entraste en el modo §aespectador§f!");
			player.sendMessage("");
			player.sendMessage("Para salir utiliza §a/leave");
			player.sendMessage("");
			
			player.sendTitle(ChatColor.RED +  "" + ChatColor.BOLD + "¡HAS MUERTO!", "Para salir de la arena usa " + ChatColor.RED + "/leave");
			
			//player.playSound(player.getLocation(), Sound.PIG_DEATH, 1, 1);
			
			olimpoga.remove(player);
			olimpowa.remove(player);
			
			olimpoes.add(player);
			
			getInGamePlayers("Olimpo").remove(player);
			getEsperaPlayers("Olimpo").remove(player);
			getEspectadores("Olimpo").add(player);
		}
	}
	public static void GameWinner(String arena, Player player) {
		if (arena.equals("Olimpo")) {
			StatsAPI.addCoins(player, 50);
			StatsAPI.addWins(player, 1);
			StatsAPI.addXP(player, 20);
			
			taskId2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
				@Override
				public void run() {
					if (time1 == 0) {
						time1 = 15;
						Bukkit.getScheduler().cancelTask(taskId2);
						taskId=-1;
						for (Player players : getListPlayers("Olimpo")) {
							RemovePlayer(players, "Olimpo");
						}
					}		
					
					for (Player players : getListPlayers("Olimpo")) {
						ActionAPI.sendActionBar(players, "§a> §f¡La partida acabará en §a" + time1 +  " §fsegundos!");								
					}
						
					Utils.spawnFireworks(player.getLocation(), 5);
					time1--;					
				}
			}, 0L, 20L);
			 
			
			player.sendMessage("");
			player.sendMessage("§a>> §f¡Felicidades por la victoria!");
			player.sendMessage("§f");
			player.sendMessage("§6+50 Coins");
			player.sendMessage("§3+20 XP");
			player.sendMessage("");
			
			player.playSound(player.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
			
			Bukkit.broadcastMessage("§a>> §f¡El jugador §a" + player.getName() + "§f ganó en §aOlimpo§f!");
		}
	}
	public static void startGame (String arena) {
		if (arena.equalsIgnoreCase("Olimpo")) {		
			if (listo.equals("No")) {
				Arena.bajando = "No se";
				Bukkit.getScheduler().cancelTask(Arena.taskId);
				Bukkit.getScheduler().cancelTask(Arena.taskId3);
				taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
		            @Override
		            public void run() {		            	
		            	if (time <= 5 && time > 1) {
		            		for (Player players : getListPlayers("Olimpo")) {
			                	if (getInGamePlayers("Olimpo").contains(players)){
				                	players.sendMessage("§a>> §f¡La partida comenzará en §a" + time + "§f segundos!");
			                	}
		            		}
		            	}
		            	
		            	if (time == 1) {
		            		for (Player players : getListPlayers("Olimpo")) {
			                	if (getInGamePlayers("Olimpo").contains(players)){
				                	players.sendMessage("§a>> §f¡La partida comenzará en §a" + time + "§f segundo!");
			                	}
		            		}
		            	}
		            	
		            	if (time == 0) {
	                		Clima.setClima("Olimpo");
	                			 
	                		Bukkit.getScheduler().cancelTask(taskId);
	                		listo = "Si";
	                		
	            			for (Player players : getListPlayers("Olimpo")) {
			                	if (getInGamePlayers("Olimpo").contains(players)){
			                		Clima.votantes.remove(players);
				                	players.playSound(players.getLocation(), Sound.ANVIL_USE, 1, 1);
				                	
				                	players.sendTitle(ChatColor.GREEN + "¡Buena suerte!", "");
				                	
				                	players.sendMessage("");						                	
				                	players.sendMessage("§c§l¡A LUCHAR!");
				                	players.sendMessage("");				                	
				                	players.sendMessage("Información:");
				                	players.sendMessage("§a  - §fTú kit seleccionado es: §a" + Kit.getNameKit(players));
				                	
				                	if (Clima.getWinner("Olimpo").equals("Tormenta")) {
				                		players.sendMessage("§b  - §fEl clima seleccionado es: §b" +Clima.getWinner("Olimpo"));
				                	}else if (Clima.getWinner("Olimpo").equals("Nevado")) {
				                		players.sendMessage("§7  - §fEl clima seleccionado es: §7" +Clima.getWinner("Olimpo"));
				                	}else if (Clima.getWinner("Olimpo").equals("Despejado")) {
				                		players.sendMessage("§e  - §fEl clima seleccionado es: §e" +Clima.getWinner("Olimpo"));
				                	}
				                					                	
				                	if (!kit.contains(players)) {
			                			players.getInventory().clear();
				                		kit.add(players);
				                		if (!(Kit.getKit(players) == null)) {
				                			Kit.giveKit(players, Kit.getKit(players));
				                		}				                						                		
				                	}			                	
				                	Cages.removeBlock(players);
				                }
	            			}		                
				        }	
		            	
						for (Player players : getListPlayers("Olimpo")) {
					           ActionAPI.sendActionBar(players, "§a> §f¡La partida comenzará en §a" + time +  " §fsegundos!");				                
					            players.playSound(players.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);						               									            		
				        }
						
		            	time--;
		            }	                       
				}, 0, 20L);
			}

		for (Player players : getListPlayers("Olimpo")) {
			olimpowa.remove(players);
			olimpoga.add(players);
								
			ItemStack kits = new ItemStack(Material.NETHER_STAR);
			ItemMeta kit2 = kits.getItemMeta();
				
			kit2.setDisplayName("§aKits §7(Click derecho)");			               				
			kits.setItemMeta(kit2);
			
			ItemStack cages = new ItemStack(Material.ARROW);
			ItemMeta cages2 = cages.getItemMeta();
				
			cages2.setDisplayName("§6Opciones §7(Click derecho)");			               				
			cages.setItemMeta(cages2);
				
			ItemStack clima = new ItemStack(Material.PAPER);
			ItemMeta clima2 = clima.getItemMeta();
				
			clima2.setDisplayName("§eVotación §7(Click derecho)");			               
				
			clima.setItemMeta(clima2);
			
			ItemStack salir = new ItemStack(Material.MAGMA_CREAM);
			ItemMeta salir2 = salir.getItemMeta();
				
			salir2.setDisplayName("§cSalir §7(Click derecho)");			               
				
			salir.setItemMeta(salir2);
				
			players.getInventory().addItem(kits);
			players.getInventory().addItem(clima);
			players.getInventory().addItem(cages);
			players.getInventory().setItem(8, salir);
				
			}		
		
			for (int a=0; a < getPlayers("Olimpo"); a++) {
				if (getListPlayers("Olimpo").get(a) != null) {
					Player player1 = getListPlayers("Olimpo").get(a);
					player1.teleport(new Location(Bukkit.getWorld("Olimpo"), 10.500, 196, 17.500));
					
					if (Cages.normal.contains(player1)) {
						Cages.giveCage(player1, Cages.NORMAL);
					}
					
					if (Main.plugin.getConfig().get("Jugadores." + player1.getName() + ".Caja") == "Amarilla") {
						Cages.giveCage(player1, Cages.AMARILLA);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Blanca") {
						Cages.giveCage(player1, Cages.BLANCA);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Naranja") {
						Cages.giveCage(player1, Cages.NARANJA);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Violeta") {
						Cages.giveCage(player1, Cages.VIOLETA);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Azul claro") {
						Cages.giveCage(player1, Cages.AZUL_CLARO);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Verde claro") {
						Cages.giveCage(player1, Cages.VERDE_CLARO);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Rosa") {
						Cages.giveCage(player1, Cages.ROSA);
					}	
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Gris") {
						Cages.giveCage(player1, Cages.GRIS);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Gris oscuro") {
						Cages.giveCage(player1, Cages.GRIS_OSCURO);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Cian") {
						Cages.giveCage(player1, Cages.CIAN);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Purpura") {
						Cages.giveCage(player1, Cages.PURPURA);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Azul") {
						Cages.giveCage(player1, Cages.AZUL);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Marron") {
						Cages.giveCage(player1, Cages.MARRON);
					}	
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Verde") {
						Cages.giveCage(player1, Cages.VERDE);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Roja") {
						Cages.giveCage(player1, Cages.ROJA);
					}		
					
					if (Main.plugin.getConfig().get("Jugadores."  + player1.getName() + ".Caja") == "Negra") {
						Cages.giveCage(player1, Cages.NEGRA);
					}		
				
				}			
			}
		}
	}
	
	
	@EventHandler
	public void PlayerDeath (EntityDeathEvent e) {		
		e.setDroppedExp(0);
	}
	
	@EventHandler
	public void cancelMesssage(PlayerDeathEvent e) {
		e.setDeathMessage("");		
	}

	@EventHandler
	public void damage(EntityDamageEvent event) {
	    if (event.getEntity() instanceof Player) {
	        Player player = (Player)event.getEntity();
	        	        
			if (!(event.getCause() == DamageCause.ENTITY_ATTACK)) {
				if (getInGamePlayers("Olimpo").contains(player)) {
					if (player.getHealth() - event.getFinalDamage() <= 0.0D) {								
						event.setCancelled(true);
						
						for (Player demas : ArenaManager.getListPlayers("Olimpo")) {
							demas.sendMessage("§a" + player.getName() + "(" + Kit.getNameKit(player) + ")" + " §fmurió!");
						}
					        	
						addEspectador(player, "Olimpo");
						
						player.setGameMode(GameMode.SPECTATOR);
												        				        							
						player.spigot().playEffect(player.getLocation(), Effect.HEART, 0, 0, 0.0F, 0.0F, 0.0F, 0.0F, 5, 30);													        
						
						Bukkit.getWorld(player.getWorld().getName()).strikeLightningEffect(player.getLocation());
					    	 
						if (ArenaManager.getInGamePlayers("Olimpo").size() == 1) {
							for (Player winner : ArenaManager.getInGamePlayers("Olimpo")){
								GameWinner("Olimpo", winner);
							}
						}
						
						for (ItemStack itemStack : player.getInventory().getContents()) {
							if(itemStack != null) {
								Bukkit.getWorld("Olimpo").dropItem(player.getLocation(), itemStack);
							}				      		
						}
						        					        	
						for (ItemStack itemStack2 : player.getInventory().getArmorContents()) {
							if(itemStack2 != null) {
								player.getWorld().dropItem(player.getLocation(), itemStack2);
							}
						}
						
						player.getInventory().clear();
					}
				}			
			}else{
				if (event.getCause() == DamageCause.ENTITY_ATTACK) {
					if (getInGamePlayers("Olimpo").contains(player.getKiller())) {
						if (!getLobbyPlayers().contains(player.getKiller())) {
							if ((player.getHealth() - event.getFinalDamage() <= 0.0D) && ((event.getEntity() instanceof Player))) {
								event.setCancelled(true);
								
								for (Player demas : ArenaManager.getListPlayers("Olimpo")) {
									demas.sendMessage("§c" + player.getName() + " §fmurió a manos de §a" + player.getKiller().getName());
								}
								
								addEspectador(player, "Olimpo");
								
								player.setGameMode(GameMode.SPECTATOR);
														        				        							
								player.spigot().playEffect(player.getLocation(), Effect.HEART, 0, 0, 0.0F, 0.0F, 0.0F, 0.0F, 5, 30);
																		
								Bukkit.getWorld(player.getKiller().getWorld().getName()).strikeLightningEffect(player.getLocation());
											
								player.getKiller().sendMessage(ChatColor.GOLD + "+10 Coins");
											
								StatsAPI.addCoins(player.getKiller(), 10);
								StatsAPI.addKills(player.getKiller(), 1);
																						
								if (ArenaManager.getInGamePlayers("Olimpo").size() == 1) {
									GameWinner("Olimpo", player.getKiller());
								}			
								
								for (ItemStack itemStack : player.getInventory().getContents()) {
									if(itemStack != null) {
										Bukkit.getWorld("Olimpo").dropItem(player.getLocation(), itemStack);
									}				      		
								}
								        					        	
								for (ItemStack itemStack2 : player.getInventory().getArmorContents()) {
									if(itemStack2 != null) {
										player.getWorld().dropItem(player.getLocation(), itemStack2);
									}
								}
								
								player.getInventory().clear();
							}
						}
					}
				}
	        }
	    }
	}			    
}
