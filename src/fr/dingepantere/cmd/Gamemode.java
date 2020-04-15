package fr.dingepantere.cmd;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.dingepantere.HelpAPI;
import fr.dingepantere.Main;

public class Gamemode implements CommandExecutor {
	
	private Main Main;
	
	public Gamemode(Main main) {
		this.Main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length < 2) {
				if(cmd.getName().equalsIgnoreCase("gmc")||cmd.getName().equalsIgnoreCase("gm1")) {
					p.setGameMode(GameMode.CREATIVE);
					
				} else if(cmd.getName().equalsIgnoreCase("gms")||cmd.getName().equalsIgnoreCase("gm0")) {
					p.setGameMode(GameMode.SURVIVAL);

				} else if(cmd.getName().equalsIgnoreCase("gma")||cmd.getName().equalsIgnoreCase("gm2")) {
					p.setGameMode(GameMode.ADVENTURE);
					
				} else if(cmd.getName().equalsIgnoreCase("gmsp")||cmd.getName().equalsIgnoreCase("gm3")) {
					p.setGameMode(GameMode.SPECTATOR);
					
				} else if(cmd.getName().equalsIgnoreCase("gm")) {
					if(args.length > 0) {
						String gm = args[0];
						if (gm.equalsIgnoreCase("c")||gm.equalsIgnoreCase("1")) {
							p.setGameMode(GameMode.CREATIVE);
							
						} else if (gm.equalsIgnoreCase("s")||gm.equalsIgnoreCase("0")) {
							p.setGameMode(GameMode.SURVIVAL);

						} else if (gm.equalsIgnoreCase("a")||gm.equalsIgnoreCase("2")) {
							p.setGameMode(GameMode.ADVENTURE);

						} else if (gm.equalsIgnoreCase("sp")||gm.equalsIgnoreCase("3")) {
							p.setGameMode(GameMode.SPECTATOR);
							
						} else {
							p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.gamemode").getString("wrong"));
							return false;
						}
						
					} else {
						p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.gamemode").getString("wrong"));
						return false;
					}
				}
				p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.gamemode").getString("now")+ p.getGameMode());
				
			} else {
				if(HelpAPI.isConnectedPlayer(args[0])) {
					Player player = Bukkit.getPlayer(args[0]);
					
					if(cmd.getName().equalsIgnoreCase("gmc")||cmd.getName().equalsIgnoreCase("gm1")) {
						player.setGameMode(GameMode.CREATIVE);
						
					} else if(cmd.getName().equalsIgnoreCase("gms")||cmd.getName().equalsIgnoreCase("gm0")) {
						player.setGameMode(GameMode.SURVIVAL);

					} else if(cmd.getName().equalsIgnoreCase("gma")||cmd.getName().equalsIgnoreCase("gm2")) {
						player.setGameMode(GameMode.ADVENTURE);
						
					} else if(cmd.getName().equalsIgnoreCase("gmsp")||cmd.getName().equalsIgnoreCase("gm3")) {
						player.setGameMode(GameMode.SPECTATOR);
						
					} else if(cmd.getName().equalsIgnoreCase("gm")) {
						if(args.length > 0) {
							String gm = args[0];
							if (gm.equalsIgnoreCase("c")||gm.equalsIgnoreCase("1")) {
								player.setGameMode(GameMode.CREATIVE);
								
							} else if (gm.equalsIgnoreCase("s")||gm.equalsIgnoreCase("0")) {
								player.setGameMode(GameMode.SURVIVAL);

							} else if (gm.equalsIgnoreCase("a")||gm.equalsIgnoreCase("2")) {
								player.setGameMode(GameMode.ADVENTURE);

							} else if (gm.equalsIgnoreCase("sp")||gm.equalsIgnoreCase("3")) {
								player.setGameMode(GameMode.SPECTATOR);
								
							} else {
								p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.gamemode.withother").getString("wrong"));
								return false;
							}
							
						} else {
							p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.gamemode.withother").getString("wrong"));
							return false;
						}
					}
					player.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.gamemode").getString("now")+ player.getGameMode());
					p.sendMessage(player.getName()+ Main.getConfig().getConfigurationSection("message.cmd.gamemode.withother").getString("now")+ player.getGameMode());
					
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
