package fr.dingepantere;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

public class HelpAPI {

	public static boolean isConnectedPlayer(String s) {
		try {
			if(Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(s))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isInteger(String s) {
		try {
			@SuppressWarnings("unused")
			int a = Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean ItemExist(ItemStack Item) {
		try {
			Item.getItemMeta().getDisplayName();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
