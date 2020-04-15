package fr.dingepantere.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.dingepantere.HelpAPI;
import fr.dingepantere.Main;

public class Clear implements CommandExecutor {
	
	private Main Main;
	
	public Clear(Main main) {
		this.Main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length >= 1) {
				if(HelpAPI.isConnectedPlayer(args[0])) {
					
				Player player = Bukkit.getPlayer(args[0]);
				ItemStack AIR = new ItemStack(Material.AIR);
				player.getInventory().clear();
				player.getInventory().setItem(36, AIR);
				player.getInventory().setItem(37, AIR);
				player.getInventory().setItem(38, AIR);
				player.getInventory().setItem(39, AIR);
				player.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.clear").getString("cleared"));
				p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.clear").getString("withother")+ player.getName());
				
				} else {
					p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd").getString("playernotfind"));
				}
				
			} else {
				ItemStack AIR = new ItemStack(Material.AIR);
				p.getInventory().clear();
				p.getInventory().setItem(36, AIR);
				p.getInventory().setItem(37, AIR);
				p.getInventory().setItem(38, AIR);
				p.getInventory().setItem(39, AIR);
				p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.clear").getString("cleared"));
			}
			
		} else {
			sender.sendMessage(Main.getConfig().getConfigurationSection("message.cmd").getString("isnotplayer"));
		}
		return false;
	}

}















