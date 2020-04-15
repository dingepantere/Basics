package fr.dingepantere;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import fr.dingepantere.cmd.Clear;
import fr.dingepantere.cmd.Feed;
import fr.dingepantere.cmd.Fly;
import fr.dingepantere.cmd.Gamemode;
import fr.dingepantere.cmd.Heal;
import fr.dingepantere.cmd.InvSee;
import fr.dingepantere.cmd.Speed;
import fr.dingepantere.cmd.Top;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		saveDefaultConfig();
		
		getCommand("fly").setExecutor(new Fly(this));
		getCommand("gmc").setExecutor(new Gamemode(this));
		getCommand("gms").setExecutor(new Gamemode(this));
		getCommand("gma").setExecutor(new Gamemode(this));
		getCommand("gmsp").setExecutor(new Gamemode(this));
		getCommand("gm1").setExecutor(new Gamemode(this));
		getCommand("gm0").setExecutor(new Gamemode(this));
		getCommand("gm2").setExecutor(new Gamemode(this));
		getCommand("gm3").setExecutor(new Gamemode(this));
		getCommand("gm").setExecutor(new Gamemode(this));
		getCommand("clear").setExecutor(new Clear(this));
		getCommand("invsee").setExecutor(new InvSee(this));
		getCommand("top").setExecutor(new Top(this));
		getCommand("feed").setExecutor(new Feed(this));
		getCommand("heal").setExecutor(new Heal(this));
		getCommand("speed").setExecutor(new Speed(this));

		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		if(HelpAPI.ItemExist(e.getCurrentItem())) {
			if(e.getCurrentItem().getType() != Material.AIR) {
				String currentName = e.getCurrentItem().getItemMeta().getDisplayName();
				if (inv.getName().contains("Inventaire de ")) {
					ArrayList<String> itemblocked = new ArrayList<String>();
					itemblocked.add("񗝣");
					itemblocked.add("Vie");
					itemblocked.add("�6Nourriture");
					itemblocked.add("Level");
					itemblocked.add("Effect");
					if(itemblocked.contains(currentName)) {
						e.setCancelled(true);
						
					} else {
						e.setCancelled(false);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		Inventory invs = e.getInventory();
		if (invs.getName().contains("Inventaire de ")) {
			InvSee.uc(invs);
		}
	}
}
