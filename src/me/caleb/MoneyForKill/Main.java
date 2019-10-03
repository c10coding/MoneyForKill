package me.caleb.MoneyForKill;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.caleb.MoneyForKill.listener.MoneyForKill;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {

	public static Economy economy = null;

    @Override
    public void onEnable(){
        if (!setupEconomy()) {
            this.getLogger().severe("Disabled due to no Vault dependency found!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        saveDefaultConfig();
        new MoneyForKill(this);
    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    public static Economy getEconomy() {
        return economy;
    }


}