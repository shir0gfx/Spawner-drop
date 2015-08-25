package shiro.was.there;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author Shiro
 *
 */

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Block b = (Block) e.getBlock();
		Player p = (Player) e.getPlayer();
		
		if (b.getType() == Material.MOB_SPAWNER) {
			if (p.hasPermission("spawner.drop")) {
				if (p.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
					p.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.MOB_SPAWNER));
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			return;
		}
	}
}
