package me.RyanLewis.Base;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Main extends JavaPlugin {
    public Logger log = Logger.getLogger("Minecraft");
    public ItemStack ironChest;
 
    @Override
    public void onDisable() {
        getServer().clearRecipes();
    }
 
    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        log.info("[IronChests]: Version "+pm.getPlugin("IronChests").getDescription().getVersion()+" enabled!");
     
        ItemStack iron_chest = new ItemStack(Material.CHEST);
        ItemMeta meta = iron_chest.getItemMeta();
        meta.setDisplayName("Iron Chest");
        iron_chest.setItemMeta(meta);
     
     
        ShapedRecipe recipe = new ShapedRecipe(new ItemStack(iron_chest));
        recipe.shape(new String[] {"III", "ICI", "III"});
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('C', Material.CHEST);
        getServer().addRecipe(recipe);
    }
}
