package Felipe221.EDLB;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class Utils {
    public static ItemStack get(String string) {
        ItemStack s;
        if (string.contains(":")) {
            String[] parts = string.split(":");
            int itemTypeId = Integer.parseInt(parts[0]);
            short itemDur = Short.parseShort(parts[1]);
            s = new ItemStack(Material.getMaterial(itemTypeId));
            s.setDurability(itemDur);
        } else {
            s = new ItemStack(Material.getMaterial(Integer.parseInt(string)));
        }
        return s;
    }
    
    public static void spawnFireworks(Location location, int amount){
        Location loc = location;
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        
        fwm.setPower(2);
        fwm.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());
        
        fw.setFireworkMeta(fwm);
        fw.detonate();
        
        for(int i = 0;i<amount; i++){
            Firework fw2 = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
            fw2.setFireworkMeta(fwm);
        }
    }
}
