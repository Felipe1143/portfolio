package Felipe221.ComuGamers.Factions.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

public class FactionWarMenu {
	public static void openMenu(Player player) {
		Inventory join = Bukkit.getServer().createInventory(player, 27, "�nGuerras");

		FPlayer p = FPlayers.getInstance().getByPlayer(player);
        
		ItemStack mif = new ItemStack(Material.SIGN);
		ItemMeta meta = mif.getItemMeta();
		
		meta.setDisplayName("�eGuerreros");
		
		ArrayList<String> lore= new ArrayList<String>();		
					
		lore.add("�f");
		lore.add("�f�Selecciona los �eguerreros �fde");
		lore.add("�ft� facci�n que quieres que �apeleen�f!");
		lore.add("�fEl �bm�ximo �fde peleadores es �b5, �fmientras");
		lore.add("�fque el �bminimo �fes �b3 �f�Suerte!");
		lore.add("�f");
		lore.add("�b�Haz click para visualizar!");
		
		meta.setLore(lore);
								
		mif.setItemMeta(meta);
		
		ItemStack enviar = new ItemStack(Material.ENDER_PEARL);
		ItemMeta metaenviar = enviar.getItemMeta();
		
		metaenviar.setDisplayName("�eEnviar petici�n");
		
		ArrayList<String> loreenviar= new ArrayList<String>();		
					
		loreenviar.add("�f");
		loreenviar.add("�f�Envia una petici�n de �aguerra �fa una");
		loreenviar.add("�ffacci�n para poder �ccombatir�f!");
		loreenviar.add("");
		loreenviar.add("�fAtenci�n: �Deber�s �describir �fel nombre en el chat!");
		loreenviar.add("");
		loreenviar.add("�b�Haz click para enviar!");
		
		metaenviar.setLore(loreenviar);
								
		enviar.setItemMeta(metaenviar);
							
		ItemStack back = new ItemStack(Material.MAGMA_CREAM);
   	 	ItemMeta back1 = back.getItemMeta();	
   	 		
		back1.setDisplayName("�aVolver al men� principal");
		 											
		back.setItemMeta(back1);
		
		join.setItem(11, enviar);
		join.setItem(15, mif);

		join.setItem(13, back);
		
		player.openInventory(join);	
	}
}
