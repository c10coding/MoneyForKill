package me.caleb.MoneyForKill.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.caleb.MoneyForKill.Main;
import me.caleb.MoneyForKill.utils.Utils;


public class MoneyForKill implements Listener{
	
	private Main plugin;
		
	public MoneyForKill(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		//Player that was killed
		Player p = e.getEntity();
		//Player that killed someone
		Player killer = p.getKiller();
		//Player's name of the killer
		String playerName = p.getName();
		
		String worldName = p.getWorld().getName();
		
		//CHANGE THIS VALUE
		final double REWARDINT = 100.0;
		final String REWARD = String.valueOf(REWARDINT);
		
		if(worldName.equals("kitpvp")) {
			Main.getEconomy().depositPlayer(killer, 100.0);
			killer.sendMessage(Utils.chat(plugin.getConfig().getString("reward_message").replaceAll("<reward>", REWARD).replaceAll("<player>",playerName)));
		}
	}
}
