package Felipe221.EDLB.Chest;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Felipe221.EDLB.ActionAPI;
import Felipe221.EDLB.Main;
import net.md_5.bungee.api.ChatColor;

public class ChestFilled implements Listener{
	
	static List<Location> fill = new ArrayList<>();
	static List<Chest> refill = new ArrayList<>();
	
	public static List<Location> getChests(){
		return fill;
	}
	   
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock().getType().equals(Material.CHEST)){
			if(!fill.contains(event.getClickedBlock().getLocation())){
				BlockState block = event.getClickedBlock().getState();        
				if(block instanceof Chest){
					Chest chest = (Chest) block;
						if(chest.getInventory().getName().equalsIgnoreCase("Nothing")){
							return;
						}
						ChestFilled.Fill(chest);
						fill.add(event.getClickedBlock().getLocation());
						}
	               }
	         }
     }
	 
	public static void Fill (Chest chest) {    
        Inventory inventory = chest.getBlockInventory();
        
        if (!refill.contains(chest)){
	        for(int i = 0; i <= 27; i++){
	        	Random r = new Random();
	
	        	if(i == r.nextInt(27)){
	        		inventory.setItem(i, new ItemStack(Material.STONE));
	        	}
	        	
	        	if(i == r.nextInt(27)){
	        		inventory.setItem(i, new ItemStack(Material.DIAMOND));
	        	}
	        	
	        	if(i == r.nextInt(27)){
	        		inventory.setItem(i, new ItemStack(Material.COAL));
	        	}
	        	
	        	if(i == r.nextInt(27)){
	        		inventory.setItem(i, new ItemStack(Material.REDSTONE));
	        	}
	        	
	        	if(i == r.nextInt(27)){
	        		inventory.setItem(i, new ItemStack(Material.BOW));
	        	}
	    	}
        }
        
        Bukkit.getScheduler().runTaskTimer(Main.plugin, new Runnable() {
            int time = 20;

            @Override
            public void run() {
                if (this.time == 0) {
                    if (!refill.contains(chest)){
                    	refill.add(chest);
                    	
	                	for(int i = 0; i <= 27; i++){
	                    	Random r = new Random();
	
	                    	if(i == r.nextInt(27)){
	                    		inventory.setItem(i, new ItemStack(Material.STONE));
	                    	}
	                    	
	                    	if(i == r.nextInt(27)){
	                    		inventory.setItem(i, new ItemStack(Material.DIAMOND));
	                    	}
	                    	
	                    	if(i == r.nextInt(27)){
	                    		inventory.setItem(i, new ItemStack(Material.COAL));
	                    	}
	                    	
	                    	if(i == r.nextInt(27)){
	                    		inventory.setItem(i, new ItemStack(Material.REDSTONE));
	                    	}
	                    	
	                    	if(i == r.nextInt(27)){
	                    		inventory.setItem(i, new ItemStack(Material.BOW));
	                    	}
	                	}
                    }
                    return;
                }
               
                for (final Player player : Bukkit.getOnlinePlayers()) {
                	ActionAPI.sendActionBar(player, ChatColor.RED + "¡El cofre se llenará en " + time + " segundos!");
                }
               
                this.time--;
            }
        }, 0L, 20L);
        
        }
        //for (int i = 0; i < amountOfItems; i++) {
          //  Material material = chestItems[random.nextInt(chestItems.length)]; //An array of materials that you specify
            //if (inventory.contains(material)) {
              // inventory.addItem(new ItemStack(material, material.getMaxStackSize() != 1 ? random.nextInt(maxStackSize) + 1 /* in case nextInt() returns 0*/ : 1)); // addItem() rather than setItem() to a random slot to prevent overriding already filled slots
               //continue;
           // } else {
             //  inventory.setItem(random.nextInt(inventory.getSize(), new ItemStack(material, material.getMaxStackSize() != 1 ? random.nextInt(maxStackSize) + 1 : 1)));
              // continue;
            //}
         //}
	
	
    public static int getRandom(int min, int max) {
        Random srnd = new Random();
        int num = srnd.nextInt(max) + min;
       
        return num;
    }
}
