package fr.dingepantere.cmd;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import fr.dingepantere.HelpAPI;
import fr.dingepantere.Main;

public class InvSee implements CommandExecutor {
	
	private Main Main;
	
	public InvSee(Main main) {
		this.Main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			
			Player p = (Player)sender;
			Player player;
			
			if(args.length >= 1 && HelpAPI.isConnectedPlayer(args[0])) {
				player = Bukkit.getServer().getPlayer(args[0]);
			} else {
				p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd").getString("playernotfind"));
				return false;
			}

			if(p==player) {
				p.sendMessage(Main.getConfig().getConfigurationSection("message.cmd.invsee").getString("sameplayer"));
				return false;
			}
			Inventory inv = player.getInventory();
			Inventory invs = Bukkit.createInventory(null, 54, "Inventaire de " + args[0]);
			
			ItemStack gg = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
			ItemMeta ggM = gg.getItemMeta();
			ggM.setDisplayName("񗝣");
			gg.setItemMeta(ggM);
			
			double v = player.getHealth();
			double vm = player.getMaxHealth();
			double vp = v/vm*100;
			ItemStack ih = new ItemStack(Material.RED_ROSE, 1);
			ItemMeta ihM = ih.getItemMeta();
			ihM.setDisplayName("Vie");
			ihM.setLore(Arrays.asList(" Vie : " + v + "("+vp+"%)"));
			ih.setItemMeta(ihM);
			
			ItemStack ib = new ItemStack(Material.COOKED_BEEF,1);
			ItemMeta ibM = ib.getItemMeta();
			ibM.setDisplayName("�6Nourriture");
			ibM.setLore(Arrays.asList("�6 Nourriturre : " + player.getFoodLevel(),"�6Saturation : " + player.getSaturation()));
			ib.setItemMeta(ibM);
			
			ItemStack il = new ItemStack(Material.EXP_BOTTLE,1);			
			ItemMeta ilM = il.getItemMeta();
			ilM.setDisplayName("Level");
			ilM.setLore(Arrays.asList(" Niveaux : " + player.getLevel()));
			il.setItemMeta(ilM);
						
			ItemStack effect = new ItemStack(Material.POTION, 1);
			ItemMeta effectM = effect.getItemMeta();
			effectM.setDisplayName("Effect");
			ArrayList<PotionEffect> Effect = new ArrayList<PotionEffect>(player.getActivePotionEffects());
			ArrayList<String> ES = new ArrayList<String>();
			int ET = Effect.size();
			int ETS = ET;
			int ET0 = ETS;
			if(ET0==0) {
				ET0++;
			}
			effect.setAmount(ET0);
			if (ETS != 0) {
				while(ET != 0) {
					String type = Effect.get(ET-1).getType().getName();
					String time = Integer.toString(Effect.get(ET-1).getDuration());
					String Amplifier = Integer.toString(Effect.get(ET-1).getAmplifier());
					String tot = type+" : "+time+" ("+Amplifier+")";
					ES.add(tot);
					ET--;
				}
				if(ETS == 1) {
					effectM.setLore(Arrays.asList(""+ES.get(0)));
				}
				if(ETS == 2) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1)));
				}
				if(ETS == 3) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)));
				}
				if(ETS == 4) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)));
				}
				if(ETS == 5) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)));
				}
				if(ETS == 6) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)));
				}
				if(ETS == 7) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)));
				}
				if(ETS == 8) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)));
				}
				if(ETS == 9) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)));
				}
				if(ETS == 10) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)));
				}
				if(ETS == 11) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)));
				}
				if(ETS == 12) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)));
				}
				if(ETS == 13) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)));
				}
				if(ETS == 14) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)));
				}
				if(ETS == 15) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)+""+ES.get(14)));
				}
				if(ETS == 16) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)+""+ES.get(14)+""+ES.get(15)));
				}
				if(ETS == 17) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)+""+ES.get(14)+""+ES.get(15)+""+ES.get(16)));
				}
				if(ETS == 18) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)+""+ES.get(14)+""+ES.get(15)+""+ES.get(16)+""+ES.get(17)));
				}
				if(ETS == 19) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)+""+ES.get(14)+""+ES.get(15)+""+ES.get(16)+""+ES.get(17)+""+ES.get(18)));
				}
				if(ETS == 20) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)+""+ES.get(14)+""+ES.get(15)+""+ES.get(16)+""+ES.get(17)+""+ES.get(18)+""+ES.get(19)));
				}
				if(ETS == 21) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)+""+ES.get(14)+""+ES.get(15)+""+ES.get(16)+""+ES.get(17)+""+ES.get(18)+""+ES.get(19)+""+ES.get(20)));
				}
				if(ETS == 22) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)+""+ES.get(14)+""+ES.get(15)+""+ES.get(16)+""+ES.get(17)+""+ES.get(18)+""+ES.get(19)+""+ES.get(20)+""+ES.get(21)));
				}
				if(ETS == 23) {
					effectM.setLore(Arrays.asList(""+ES.get(0),""+ES.get(1),""+ES.get(2)+""+ES.get(3)+""+ES.get(4)+""+ES.get(5)+""+ES.get(6)+""+ES.get(7)+""+ES.get(8)+""+ES.get(9)+""+ES.get(10)+""+ES.get(11)+""+ES.get(12)+""+ES.get(13)+""+ES.get(14)+""+ES.get(15)+""+ES.get(16)+""+ES.get(17)+""+ES.get(18)+""+ES.get(19)+""+ES.get(20)+""+ES.get(21)+""+ES.get(22)));
				}
			}
			effect.setItemMeta(effectM);
			
			invs.setItem(0, inv.getItem(39));
			invs.setItem(1, inv.getItem(38));
			invs.setItem(2, inv.getItem(37));
			invs.setItem(3, inv.getItem(36));
			
			invs.setItem(4, gg);
			
			invs.setItem(5, effect);
			invs.setItem(6, il);
			invs.setItem(7, ib);
			invs.setItem(8, ih);
			
			invs.setItem(9, gg);
			invs.setItem(10, gg);
			invs.setItem(11, gg);
			invs.setItem(12, gg);
			invs.setItem(13, gg);
			invs.setItem(14, gg);
			invs.setItem(15, gg);
			invs.setItem(16, gg);
			invs.setItem(17, gg);
			
			invs.setItem(18, inv.getItem(0));
			invs.setItem(19, inv.getItem(1));
			invs.setItem(20, inv.getItem(2));
			invs.setItem(21, inv.getItem(3));
			invs.setItem(22, inv.getItem(4));
			invs.setItem(23, inv.getItem(5));
			invs.setItem(24, inv.getItem(6));
			invs.setItem(25, inv.getItem(7));
			invs.setItem(26, inv.getItem(8));
			
			invs.setItem(27, inv.getItem(9));
			invs.setItem(28, inv.getItem(10));
			invs.setItem(29, inv.getItem(11));
			invs.setItem(30, inv.getItem(12));
			invs.setItem(31, inv.getItem(13));
			invs.setItem(32, inv.getItem(14));
			invs.setItem(33, inv.getItem(15));
			invs.setItem(34, inv.getItem(16));
			invs.setItem(35, inv.getItem(17));
			
			invs.setItem(36, inv.getItem(18));
			invs.setItem(37, inv.getItem(19));
			invs.setItem(38, inv.getItem(20));
			invs.setItem(39, inv.getItem(21));
			invs.setItem(40, inv.getItem(22));
			invs.setItem(41, inv.getItem(23));
			invs.setItem(42, inv.getItem(24));
			invs.setItem(43, inv.getItem(25));
			invs.setItem(44, inv.getItem(26));
			
			invs.setItem(45, inv.getItem(27));
			invs.setItem(46, inv.getItem(28));
			invs.setItem(47, inv.getItem(29));
			invs.setItem(48, inv.getItem(30));
			invs.setItem(49, inv.getItem(31));
			invs.setItem(50, inv.getItem(32));
			invs.setItem(51, inv.getItem(33));
			invs.setItem(52, inv.getItem(34));
			invs.setItem(53, inv.getItem(35));
			p.openInventory(invs);
			p.sendMessage(invs.getName());
		} else {
			sender.sendMessage(Main.getConfig().getConfigurationSection("message.cmd").getString("isnotplayer"));
		}
		return false;
	}

	public static void uc(Inventory invs) {
		String pis = invs.getName();
		String pisp = pis.substring(14, pis.length());
		Player pi = Bukkit.getServer().getPlayer(pisp);
		Inventory inv = pi.getInventory();
		inv.setItem(39, invs.getItem(0));
		inv.setItem(38, invs.getItem(1));
		inv.setItem(37, invs.getItem(2));
		inv.setItem(36, invs.getItem(3));
		
		inv.setItem(0, invs.getItem(18));
		inv.setItem(1, invs.getItem(19));
		inv.setItem(2, invs.getItem(20));
		inv.setItem(3, invs.getItem(21));
		inv.setItem(4, invs.getItem(22));
		inv.setItem(5, invs.getItem(23));
		inv.setItem(6, invs.getItem(24));
		inv.setItem(7, invs.getItem(25));
		inv.setItem(8, invs.getItem(26));
		
		inv.setItem(9, invs.getItem(27));
		inv.setItem(10, invs.getItem(28));
		inv.setItem(11, invs.getItem(29));
		inv.setItem(12, invs.getItem(30));
		inv.setItem(13, invs.getItem(31));
		inv.setItem(14, invs.getItem(32));
		inv.setItem(15, invs.getItem(33));
		inv.setItem(16, invs.getItem(34));
		inv.setItem(17, invs.getItem(35));
		
		inv.setItem(18, invs.getItem(36));
		inv.setItem(19, invs.getItem(37));
		inv.setItem(20, invs.getItem(38));
		inv.setItem(21, invs.getItem(39));
		inv.setItem(22, invs.getItem(40));
		inv.setItem(23, invs.getItem(41));
		inv.setItem(24, invs.getItem(42));
		inv.setItem(25, invs.getItem(43));
		inv.setItem(26, invs.getItem(44));
		
		inv.setItem(27, invs.getItem(45));
		inv.setItem(28, invs.getItem(46));
		inv.setItem(29, invs.getItem(47));
		inv.setItem(30, invs.getItem(48));
		inv.setItem(31, invs.getItem(49));
		inv.setItem(32, invs.getItem(50));
		inv.setItem(33, invs.getItem(51));
		inv.setItem(34, invs.getItem(52));
		inv.setItem(35, invs.getItem(53));
	}
}
