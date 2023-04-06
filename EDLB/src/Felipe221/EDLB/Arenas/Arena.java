package Felipe221.EDLB.Arenas;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import Felipe221.EDLB.ActionAPI;
import Felipe221.EDLB.Main;
import Felipe221.EDLB.Kits.Clima;
import Felipe221.EDLB.Kits.Kit;
import net.md_5.bungee.api.ChatColor;

public class Arena {	
	public static int taskId = -1;
	public static int taskId3 = -1;
	public static int time = 15;
	public static int time2 = 0;
	public static String bajando = "No";
	
	public static String ArenaStatus(String arena) {
		String estado = "";
		
		if (arena.equalsIgnoreCase("Olimpo")) {
			if (ArenaManager.getEsperaPlayers("Olimpo").size() == 0){
				if (ArenaManager.getInGamePlayers("Olimpo").size() > 1) {						
					estado = "En juego";
				}
			}
			
			if (ArenaManager.getInGamePlayers("Olimpo").size() == 1){
					if (ArenaManager.getEsperaPlayers("Olimpo").size() == 0) {
						estado = "Reinicio";
					}
				}
			
			if (ArenaManager.listo.equals("No")){
				if (bajando.equals("No")) {
					estado = "Comenzando";
				}
			}
					
			if(ArenaManager.getEsperaPlayers("Olimpo").size() > 0) { 
				if (ArenaManager.getInGamePlayers("Olimpo").size() == 0) {
					if (ArenaManager.getEspectadores("Olimpo").size() == 0) {
						estado = "Espera";
					}
				}
			}
			
			if(ArenaManager.getPlayers("Olimpo") == 0) {		
				estado = "Espera";
			}
			
		}else{
			estado = "Error";
		}
		
		return estado;		
	}
	
	public static void checkStart(String arena) {
		if (arena.equals("Olimpo")) {
			if (ArenaManager.getEsperaPlayers("Olimpo").size() >= 2) {
				bajando = "Si";
				time2 = 1;
				code("Olimpo");
				Bukkit.getScheduler().cancelTask(taskId3);
			}else{
				bajando = "No";
				Bukkit.getScheduler().cancelTask(taskId);
				time2 = 0;
				code1("Olimpo");
			}
		}
	}
	
	public static void code1(String arena) {
		if (arena.equals("Olimpo")) {
			if (bajando.equals("No")) {
				taskId3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
					@Override
					public void run() {
							for (Player players : ArenaManager.getListPlayers("Olimpo")) {
								ActionAPI.sendActionBar(players, "§a> §f¡Falta §a1 §fjugador para iniciar la partida!");				              				
								}
							}
									
					}, 0L, 20L);
			}
		}
	}
	
	public static void code(String arena) {
		if (arena.equals("Olimpo")) {
			if (bajando.equals("Si")) {	
					taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
						@Override
						public void run() {		
							    System.out.println("Se está haciendo el code (Arena)");
							    if (time == 0) {
									Bukkit.getScheduler().cancelTask(taskId);
																		
									bajando = "No se";
									ArenaManager.startGame("Olimpo");									
								}else{
									for (Player players : ArenaManager.getListPlayers("Olimpo")) {
										ActionAPI.sendActionBar(players, "§a> §f¡La partida comenzará en §a" + time +  " §fsegundos!");				                
										players.playSound(players.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);						               				           			
									}
								}
								time--;
							}																				
						}, 0L, 20L);
					}
				
			}		
		}
	}
