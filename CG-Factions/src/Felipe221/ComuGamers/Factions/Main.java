package Felipe221.ComuGamers.Factions;

import java.sql.Connection;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import Felipe221.ComuGamers.Factions.APIs.StatsAPI;
import Felipe221.ComuGamers.Factions.APIs.VaultAPI;
import Felipe221.ComuGamers.Factions.Commands.PreCommand;
import Felipe221.ComuGamers.Factions.Commands.WarCommand;
import Felipe221.ComuGamers.Factions.Config.ConfigManager;
import Felipe221.ComuGamers.Factions.Config.DatabaseManager;
import Felipe221.ComuGamers.Factions.Faction.ChatFaction;
import Felipe221.ComuGamers.Factions.Faction.GeneratorFaction;
import Felipe221.ComuGamers.Factions.Listeners.EntityDamageEvent;
import Felipe221.ComuGamers.Factions.Listeners.PlayerLeaveEvent;
import Felipe221.ComuGamers.Factions.Listeners.PlayerLoginEvent;
import Felipe221.ComuGamers.Factions.Menus.ClickMenu;
import Felipe221.ComuGamers.Factions.War.WarManager;
import Felipe221.ComuGamers.Factions.War.WarSystem;
import Felipe221.ComuGamers.Factions.War.WarSystem.WarState;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin implements Listener{
	public static Plugin plugin;
	
	private static Economy econ = null;
	private static Permission perms = null;
	private static Chat chat = null;
	    
	private Connection connection;
    private String host, database, username, password;
    private int port;
    private static DatabaseManager db;

	public static void sendLog(String msg) {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
	public static void command(Player player, String cmd) {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmd.replaceAll("%player%", player.getName()));
	}
	
	@Override
	public void onEnable() {
		plugin = this;
		
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new PreCommand(), this);
		pm.registerEvents(new ChatFaction(), this);
		pm.registerEvents(new ClickMenu(), this);
		pm.registerEvents(new WarManager(), this);
		pm.registerEvents(new StatsAPI(), this);
		
		pm.registerEvents(new EntityDamageEvent(), this);
		pm.registerEvents(new PlayerLeaveEvent(), this);
		pm.registerEvents(new PlayerLoginEvent(), this);
		
		getCommand("war").setExecutor(new WarCommand());
		getCommand("si").setExecutor(new WarCommand());	
			    
		ConfigManager.createFiles();		
		ConfigManager.onStart();
		 
	    GeneratorFaction.GenerateFinal();
		
	    Main.sendLog("&a&m------------------------------------------");
	    Main.sendLog("&a-> &fFactions desarrollado por &aFelipe221");
	    Main.sendLog("&a-> &fVersión: &a1.0");
	    if (setupEconomy()){
	    	Main.sendLog("&a-> &f¡&aVaultAPI &fhookeado &acorrectamente&f!");
	    }else {
	    	Main.sendLog("&c-> &fError con Vault - &cCONTACTAR A FELIPE221");
	    }    
	    Main.sendLog("&a&m------------------------------------------");
	    
		host = "45.35.32.53";
		port = 3306;
		database = "s2404_Factions";
		username = "u2404_r81PcBQVVD";
		password = "TN6yer1e9JECrs7W";  
		
		db = new DatabaseManager(host, port, database, username, password, this);

		db.query("CREATE TABLE IF NOT EXISTS `Factions` ( `username` varchar(16) NOT NULL, "
				+ "`kills` int(16) NOT NULL, `faction` varchar(16) NOT NULL, `deaths` int(16) NOT NULL, `wins` int(16) NOT NULL, "
				+ "`wars` int(16) NOT NULL,`claims` int(16) NOT NULL, `arrows` int(16) NOT NULL, `power` int(16) NOT NULL, "
				+ "UNIQUE KEY `username` (`username`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;");
		
		WarSystem.war.clear();
		WarSystem.setState(WarState.ESPERANDO);
	}
	
	@Override
	public void onDisable() {
		
	}

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            econ = economyProvider.getProvider();
        }
 
        return (econ != null);
    }
		
	public static DatabaseManager getDatabaseHandler() {
        return db;
    }
	
	public static Economy getEconomy() {
        return econ;
    }
    
    public static Permission getPermissions() {
        return perms;
    }
    
    public static Chat getChat() {
        return chat;
    }
}
