package fr.dingepantere.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.dingepantere.HelpAPI;
import fr.dingepantere.Main;

public class Feed implements CommandExecutor {
	
	private Main Main;
	
	public Feed(Main main) {
		this.Main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				p.setFoodLevel(20);
				p.setSaturation(20);
				p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.feed").getString("feeded"));
				
			} else {
				if(HelpAPI.isConnectedPlayer(args[0])) {
					Player player = Bukkit.getPlayer(args[0]);
					player.setFoodLevel(20);
					player.setSaturation(20);
					player.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.feed").getString("feeded"));
					p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.feed").getString("withother")+ player.getName());
				} else {
					p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd").getString("playernotfind"));
				}
			}
			
		} else {
			sender.sendMessage(Main.getConfig().getConfigurationSection("message.cmd").getString("isnotplayer"));
		}
		return false;
	}
}
