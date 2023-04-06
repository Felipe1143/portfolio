package Felipe221.ComuGamers.Factions.Menus;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import Felipe221.ComuGamers.Factions.Main;
import Felipe221.ComuGamers.Factions.Config.ConfigManager;
import Felipe221.ComuGamers.Factions.War.WarSystem;
import Felipe221.ComuGamers.Factions.War.WarSystem.WarState;

public class FactionMenu {
	public static HashMap<Player, String> open = new HashMap<Player, String>();

	public static void openMenu(Player player) {
		open.put(player, "a1");
		
		Inventory join = Bukkit.getServer().createInventory(player, 54, "§nMi facción");
		
		new BukkitRunnable() {
			 @Override
	         public void run() {
				 if (open.containsKey(player)) {		
					FPlayer mp = FPlayers.getInstance().getByPlayer(player);
			
					ItemStack power = new ItemStack(Material.POTION);		
					ItemMeta power1 = power.getItemMeta();	
					power1.setDisplayName("§ePoder");
					
					ArrayList<String> lorepower= new ArrayList<String>();
								
					lorepower.add("");
					lorepower.add("§fEl §epoder §fse consigue completando §bretos§f,");
					lorepower.add("§fasesinando §cenemigos§f, estando §aconectado§f y");
					lorepower.add("§fabriendo los diferentes §dcrates");
					lorepower.add("");
					lorepower.add("§fPoder: §b" + mp.getFaction().getPowerRounded() + "/" + mp.getFaction().getPowerMaxRounded());
					power1.setLore(lorepower);
											
					power.setItemMeta(power1);
					
					ItemStack eliminar = new ItemStack(Material.BARRIER);		
					ItemMeta eliminar1 = eliminar.getItemMeta();	
					eliminar1.setDisplayName("§eEliminar facción");
					
					ArrayList<String> loreeliminar= new ArrayList<String>();
								
					loreeliminar.add("");
					loreeliminar.add("§fEliminar tu facción significa");
					loreeliminar.add("§fperder todo tú §eterritorio§f, además");
					loreeliminar.add("§fdel §adinero §fconseguido y el respectivo §bELO");
					loreeliminar.add("§f¡Esta acción es irrevertible!");
					loreeliminar.add("");
					loreeliminar.add("§b¡Haz click para elimar tú facción!");
					eliminar1.setLore(loreeliminar);
											
					eliminar.setItemMeta(eliminar1);
					
					ItemStack open = new ItemStack(Material.CHEST);		
					ItemMeta open1 = open.getItemMeta();	
					open1.setDisplayName("§eModo de ingreso");
					
					ArrayList<String> loreopen= new ArrayList<String>();
								
					loreopen.add("");
					loreopen.add("§fPuedes cambiar el modo de que");
					loreopen.add("§flos demás §ejugadores §fpueden ingresar");
					loreopen.add("§fa tú facción, esto permitirá un acceso");
					loreopen.add("§fmás §arápido §fo §dprivado §f(por invitación)");
					loreopen.add("");
					
					if (mp.getFaction().getOpen() == true) {
						loreopen.add("§fModo de ingreso: §bAbierto");
					}else {
						loreopen.add("§fModo de ingreso: §bPor invitación");
					}
					
					loreopen.add("");
					loreopen.add("§b¡Haz click para cambiar el modo!");
					open1.setLore(loreopen);
											
					open.setItemMeta(open1);
					
					ItemStack salir = new ItemStack(Material.NETHER_STAR);		
					ItemMeta salir1 = salir.getItemMeta();	
					salir1.setDisplayName("§eSalir de la facción");
					
					ArrayList<String> loresalir= new ArrayList<String>();
								
					loresalir.add("");
					loresalir.add("§fPodrás §csalir §fy continuar tú camino...");
					loresalir.add("§fLa facción perderá §apoder §fy §bELO §fpor tú salida");
					loresalir.add("§f¡Esta acción es irrevertible!");
					loresalir.add("");
					loresalir.add("§b¡Haz click para salir de tú facción!");
					salir1.setLore(loresalir);
					
					salir.setItemMeta(salir1);
					
					ItemStack players = new ItemStack(Material.LEATHER_CHESTPLATE);		
					ItemMeta players1 = players.getItemMeta();	
					players1.setDisplayName("§eMiembros");
					
					ArrayList<String> loreplayers= new ArrayList<String>();
								
					loreplayers.add("");
					loreplayers.add("§fPodrás observar los §emiembros §fde");
					loreplayers.add("§fla §bfacción§f, además de poder");
					loreplayers.add("§fconsultar sus §aestadisticas §fy §aaportes");
					loreplayers.add("");
					loreplayers.add("§b¡Haz click para ver los miembros!");
					players1.setLore(loreplayers);
											
					players.setItemMeta(players1);
					
					ItemStack invita = new ItemStack(Material.BOOK);		
			   	 	ItemMeta invita1 = invita.getItemMeta();	
					invita1.setDisplayName("§eInvitaciones");
					 
					ArrayList<String> loreinvita= new ArrayList<String>();
								
					loreinvita.add("");
					loreinvita.add("§f¿Quieres reunir más §ejugadores §fen tú");
					loreinvita.add("§ffacción y hacerla más §apoderosa§f?");
					loreinvita.add("§f¡Puedes §binvitar §fa que otros jugadores");
					loreinvita.add("§fse unan!");
					loreinvita.add("");
					loreinvita.add("§fJugadores: §e" + mp.getFaction().getOnlinePlayers().size() + "/" + mp.getFaction().getFPlayers().size());
					loreinvita.add("§fAtención: ¡Escribe el §dnombre del jugador §fen el chat!");	
					loreinvita.add("");
					loreinvita.add("§b¡Haz click para realizar una invitación!");
					    	 
					invita1.setLore(loreinvita);
											
					invita.setItemMeta(invita1);		
					
					ItemStack gene = new ItemStack(Material.OBSIDIAN);		
					ItemMeta gene1 = gene.getItemMeta();	
					gene1.setDisplayName("§eGeneradores");
					
					ArrayList<String> loregene= new ArrayList<String>();
								
					loregene.add("");
					loregene.add("§fLos §egeneradores §fte permitirán");
					loregene.add("§fobtener §arecursos §fde manera §agratuita");
					loregene.add("§fTen en cuenta que §bsiempre §fdeberá haber");
					loregene.add("§fun miembro §aen-línea §fpara generar");
					loregene.add("");
					loregene.add("§b¡Haz click para ver los generadores!");
					gene1.setLore(loregene);
											
					gene.setItemMeta(gene1);				
					
					ItemStack name = new ItemStack(Material.SIGN);		
					ItemMeta name1 = name.getItemMeta();	
					name1.setDisplayName("§eNombre");
					
					ArrayList<String> lorename= new ArrayList<String>();
								
					lorename.add("");
					lorename.add("§fEl §enombre §fde tú facción");
					lorename.add("§fes la que te §arepresentará §fen");
					lorename.add("§ftodos lados.");
					lorename.add("");
					lorename.add("§fNombre actual: §e" + mp.getFaction().getTag());
					lorename.add("§fAtención: ¡Deberás §describir §fel nombre en el chat!");
					lorename.add("");
					lorename.add("§b¡Haz click para cambiar el nombre!");
					name1.setLore(lorename);
											
					name.setItemMeta(name1);
					
					ItemStack siglas = new ItemStack(Material.NAME_TAG);		
					ItemMeta siglas1 = siglas.getItemMeta();	
					siglas1.setDisplayName("§eSiglas");
					
					ArrayList<String> loresiglas= new ArrayList<String>();
								
					loresiglas.add("");
					loresiglas.add("§fLas §esiglas §fde tú facción");
					loresiglas.add("§fson la que te §arepresentará §fen");
					loresiglas.add("§ftodos lados de una manera sencilla.");
					loresiglas.add("");
					
					if (!ConfigManager.getStats().contains("Facciones." + mp.getFaction().getTag() + ".Siglas")) {
						loresiglas.add("§fSiglas actuales: §a-");
					}else {
						loresiglas.add("§fSiglas actuales: §a" + ConfigManager.getStats().getString("Facciones." + mp.getFaction().getTag()  + ".Siglas"));
					}
					
					loresiglas.add("§fAtención: ¡Deberás §describir §flas siglas en el chat!");
					loresiglas.add("");
					loresiglas.add("§b¡Haz click para cambiar las siglas!");
					siglas1.setLore(loresiglas);
											
					siglas.setItemMeta(siglas1);
									
					
					ItemStack desc = new ItemStack(Material.PAPER);		
					ItemMeta desc1 = desc.getItemMeta();	
					desc1.setDisplayName("§eDescripción");
					
					ArrayList<String> loredesc= new ArrayList<String>();
								
					loredesc.add("");
					loredesc.add("§fLa §edescripción §fservirá");
					loredesc.add("§fpara darles a los usuarios");
					loredesc.add("§funa breve §ainformación §fsobre tú facción.");
					loredesc.add("");
					loredesc.add("§fAtención: ¡Deberás §describir §fla descripción en el chat!");
					loredesc.add("");
					loredesc.add("§b¡Haz click para cambiar la descripción!");
					desc1.setLore(loredesc);
											
					desc.setItemMeta(desc1);
					
					ItemStack modo = new ItemStack(Material.DIAMOND_SWORD);		
					ItemMeta modo1 = modo.getItemMeta();	
					modo1.setDisplayName("§eSeleccionar modo");
					
					ArrayList<String> loremodo= new ArrayList<String>();
								
					loremodo.add("");
					
					if (mp.getFaction().isPeaceful()) {
						loremodo.add("§fPacífico: No podrás §aatacar");
						loremodo.add("§fni entrar en §aguerra§f, al mismo tiempo");
						loremodo.add("§fque no podrán §aromper §ftú facción.");
						loremodo.add("");
						loremodo.add("§a-> §fEstado: §aPacífico");
					}else {
						loremodo.add("§fProfesional: Podrás §aatacar");
						loremodo.add("§fy entrar en §aguerra§f, al mismo tiempo");
						loremodo.add("§fque podrán §aromper §ftú facción.");
						loremodo.add("");
						loremodo.add("§a-> §fEstado: §aProfesional");
					}
					
					loremodo.add("");
					loremodo.add("§fSolo para rangos §a§lVIP§f, §6§lELITE§f y §d§lULTIMATE");
					loremodo.add("§b¡Haz click para cambiar de modo!");
					modo1.setLore(loremodo);
											
					modo.setItemMeta(modo1);
					
					ItemStack back = new ItemStack(Material.MAGMA_CREAM);
			   	 	ItemMeta back1 = back.getItemMeta();	
			   	 		
					back1.setDisplayName("§aVolver al menú principal");
					 											
					back.setItemMeta(back1);
				
					join.setItem(10, name);
					join.setItem(11, desc);
					join.setItem(12, siglas);
					join.setItem(19, open);
					join.setItem(14, invita);
					join.setItem(13, players);
					join.setItem(15, power);
					join.setItem(20, modo);
					join.setItem(16, gene);
					join.setItem(39, back);	
					join.setItem(40, eliminar);	
					join.setItem(41, salir);	
				 }else {
					 cancel();
				 }
			 }
		}.runTaskTimer(Main.plugin, 0, 2);
		
		player.openInventory(join);	
	}
}
