package fr.dingepantere.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.dingepantere.HelpAPI;
import fr.dingepantere.Main;

public class Fly implements CommandExecutor {
	
	private Main Main;
	
	public Fly(Main main) {
		this.Main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				if (p.getAllowFlight()) {
					p.setAllowFlight(false);
					p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.fly").getString("can't"));
					
				} else {
					p.setAllowFlight(true);
					p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.fly").getString("can"));
				}
				
			} else {
				if(HelpAPI.isConnectedPlayer(args[0])) {
					Player player = Bukkit.getPlayer(args[0]);

					if (player.getAllowFlight()) {
						player.setAllowFlight(false);
						player.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.fly").getString("can't"));
						
					} else {
						player.setAllowFlight(true);
						player.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.fly").getString("can"));
					}
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
