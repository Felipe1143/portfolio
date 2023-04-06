package Felipe221.ComuGamers.Factions.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.struct.Role;

import Felipe221.ComuGamers.Factions.Faction.KitFaction;
import Felipe221.ComuGamers.Factions.Faction.RetosFaction;
import Felipe221.ComuGamers.Factions.Faction.KitFaction.KitType;
import Felipe221.ComuGamers.Factions.War.WarManager;
import Felipe221.ComuGamers.Factions.War.WarSystem;
import Felipe221.ComuGamers.Factions.War.WarSystem.WarState;

public class WarCommand implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		Player player = (Player) sender;
		if (sender instanceof Player) {
			if (alias.equalsIgnoreCase("war")){
				if (args.length == 0) {
					player.sendMessage("§a§m---------------------------------");		
					player.sendMessage("§fSistema de guerras propio de §bComuGamers");
					player.sendMessage("§a§m---------------------------------");

					player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);

					return true;
				}
							
				if (args[0].equalsIgnoreCase("duel")){
					FPlayer mp = FPlayers.getInstance().getByPlayer(player);
					
					if (args.length == 1) {																			
						player.sendMessage("§4§l>> §cPor favor, utiliza /war duel <facción>");
						player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);
								
						return true;									
					}
					
					if (WarSystem.getState() == WarState.ESPERANDO) {
						if (Factions.getInstance().isTagTaken(args[1])) {
							if (!mp.getFaction().getTag().toLowerCase().equals(args[1].toLowerCase())) {
								for (FPlayer dueño : Factions.getInstance().getByTag(args[1]).getFPlayersWhereRole(Role.ADMIN)) {				
									if (dueño.isOnline() == true) {								
										if (Factions.getInstance().getByTag(args[1]).getOnlinePlayers().size() >= 3) {
											if (mp.getFaction().getOnlinePlayers().size() >= 3) {
												dueño.sendMessage("§e§l>> §f¡La facción §b" + mp.getFaction().getTag() + " §fte retó a una guerra!");
												dueño.sendMessage("§a-> Para aceptar escribe /si");
												dueño.sendMessage("§c-> Para rechazar escribe /no");
												
												WarSystem.invite.put(player, dueño.getFaction().getTag());
												//<AL QUE ENVIA> - <FACCIÓN QUE RETA> 
												
												player.sendMessage("§e§l>> §f¡Invitación a §aguerra §fenviada correctamente!");
												
												return true;
											}else {
												player.sendMessage("§e§l>> §f¡Tú facción no tiene §b3 §fjugadores conectados!");
												
												return true;										
											}
										}else {
											player.sendMessage("§e§l>> §f¡La facción §b" + args[1] + " §fno tiene §a3 §fjugadores conectados!");
											
											return true;
										}
									}else {
										player.sendMessage("§e§l>> §f¡El lider de la facción §b" + args[1] + "§f no está conectado!");
										
										return true;
									}
								}
							}else {
								player.sendMessage("§e§l>> §f¡No puedes §cretar §fa tú facción!");
								
								return true;
							}
						}else {
							player.sendMessage("§e§l>> §f¡La facción §b" + args[1] + "§f no existe!");
							player.sendMessage("§Por favor, también comprueba que estén bien escritas las §aMayúsculas");
							
							return true;
						}
					}else {
						player.sendMessage("§e§l>> §f¡Ya hay una §aguerra §factiva!");
						player.sendMessage("§fPor favor, espera que termine para §benviar §fla petición");
						
						return true;
					}
				}
			}
			
			if (alias.equalsIgnoreCase("si")){
				if (args.length == 0) {
					FPlayer mp = FPlayers.getInstance().getByPlayer(player);
					
					if (WarSystem.invite.containsKey(player)) {
						if (WarSystem.getState() == WarState.ESPERANDO) {
							String tagenemy = WarSystem.invite.get(player);
							
							for (FPlayer dueñoenemy : Factions.getInstance().getByTag(tagenemy).getFPlayersWhereRole(Role.ADMIN)) {
								dueñoenemy.sendMessage("§e§l>> §f¡La solicitud de §bguerra §ffue §aaceptada§f!");
								dueñoenemy.sendMessage("§e§l>> §fPreparando combate...");
							}
							
							player.sendMessage("§e§l>> §f¡La solicitud de §bguerra §ffue §aaceptada§f!");
							player.sendMessage("§e§l>> §fPreparando combate...");
							
							WarManager.Iniciar(mp.getFaction().getTag(), tagenemy);
							WarSystem.invite.remove(player);
							
							return true;
						}else {
							player.sendMessage("§e§l>> §f¡Ya hay una §aguerra §factiva!");
							player.sendMessage("§Por favor, espera que termine para §baceptar §fla petición");
							
							return true;						
						}
					}else {
						player.sendMessage("§e§l>> §f¡No tienes una §binvitación §fde guerra esperando!");
					}
				}					
			}		
		}
		
		return false;
	}
}
