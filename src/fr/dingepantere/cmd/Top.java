package fr.dingepantere.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.dingepantere.HelpAPI;
import fr.dingepantere.Main;

public class Top implements CommandExecutor {

	private Main Main;
	
	public Top(Main main) {
		this.Main = main;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				Location NLoc = p.getLocation();
				int height = p.getWorld().getMaxHeight();
			    Block block;
			    Material.AIR.name();
			    while (height >= 2) {
			    	height--;
			    	NLoc.setY(height);
			        block = NLoc.getBlock();
			        if (!block.getType().isTransparent()) {
			        	NLoc.setY(block.getLocation().getY()+1);
			        	break;
			        }
			    }
				p.teleport(NLoc);
				p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.top").getString("teleport"));
				
			} else {
				if(HelpAPI.isConnectedPlayer(args[0])) {
					Player player = Bukkit.getPlayer(args[0]);
					Location NLoc = player.getLocation();
					int height = player.getWorld().getMaxHeight();
				    Block block;

				    while (height >= 3) {
				    	height--;
				    	NLoc.setY(height);
				        block = NLoc.getBlock();
				        if (!block.isEmpty()) {
				        	NLoc = block.getLocation().add(0, 1, 0);
				        	break;
				        }
				    }
					player.teleport(NLoc);
					player.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.top").getString("teleport"));
					p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.top.withother").getString("1")+ player.getName() +Main.getConfig().getConfigurationSection("message.cmd.top.havebeen").getString("2"));
					
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
