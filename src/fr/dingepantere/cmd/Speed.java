package fr.dingepantere.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.dingepantere.HelpAPI;
import fr.dingepantere.Main;

public class Speed implements CommandExecutor {
	
	private Main Main;
	
	public Speed(Main main) {
		this.Main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.getWalkSpeed() == 0.2) {
					p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed").getString("wrong"));
				} else {
					p.setWalkSpeed((float) 0.2);
					p.setFlySpeed((float) 0.1);
					p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed").getString("reset"));
				}
			}
			
			if(args.length == 1) {
				if(HelpAPI.isInteger(args[0])) {
					Float speed = Float.valueOf(args[0]);
					if(speed >= 0) {
						p.setWalkSpeed(speed/10);
						p.setFlySpeed((speed/10)/2);
						p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed").getString("now")+ speed);
					} else {
						p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed").getString("below"));
					}
					
					
				} else if(HelpAPI.isConnectedPlayer(args[0])) {
					Player player  = Bukkit.getPlayer(args[0]);
					
					if(player.getWalkSpeed() == 0.2) {
						p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed.withother").getString("wrong"));
					} else {
						player.setWalkSpeed((float) 0.2);
						player.setFlySpeed((float) 0.1);
						player.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed").getString("reset"));
						p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed.withother").getString("reset")+ player.getDisplayName());
					}
					
				} else {
					p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed").getString("wrong"));
				}
			}
			
			if(args.length >= 2) {
				if(HelpAPI.isConnectedPlayer(args[0])) {
					Player player  = Bukkit.getPlayer(args[0]);
					if(HelpAPI.isInteger(args[1])) {
						Float speed = Float.valueOf(args[1]);
						if(speed >= 0) {
							player.setWalkSpeed(speed/10);
							player.setFlySpeed((speed/10)/2);
							player.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed").getString("now")+ speed);
							p.sendMessage(player.getName() +Main.getConfig().getConfigurationSection("message.cmd.speed.withother").getString("now")+ speed);
						}
					} else {
						p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.speed.withother").getString("wrong"));
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
