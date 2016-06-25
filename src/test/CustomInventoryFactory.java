import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
/*
Code for this inventory generated by [official name of our project here].
Created by Zombie_Striker and Tecno_Wizard
*/
/** HOW TO ADD THIS TO YOUR CODE
 1. Create a new class and give it the same name as the generated code.
 2. Copy and paste the code into that class.
 3. Go to your main class that extends JavaPlugin and create a new field at the top of the class. This will hold the instance of the generated class.
 4. Inside the main class's onEnable method, set that field equal to a new instance of the generated class.

 Once you have done these four steps, you can access your inventory by using
 -[FieledName].getInventory()
 Where the [FieldName] is the field from step 3.
 **/


public class CustomInventoryFactory implements Listener{
    Inventory custominventory;

    public CustomInventoryFactory(JavaPlugin main){
        custominventory = Bukkit.createInventory(null, 27, "Custom Inventory");
        Bukkit.getPluginManager().registerEvents(this,main);
        initInventory();
    }

    public Inventory getInventory(){
        return custominventory;
    }
    public void initInventory(){
        List<String> loreBuffer = new ArrayList<>();
        Map<Enchantment,Integer> enchBuffer = new HashMap<Enchantment,Integer>();

        ItemStack stack0;
        stack0 = new ItemStack(Material.APPLE, 1);
        loreBuffer.add("dh dh");
        enchBuffer.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
        formatMeta(stack0, "xcgn", loreBuffer, enchBuffer);
        loreBuffer.clear();
        enchBuffer.clear();
        custominventory.setItem(0, stack0);
        //end stack


    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getInventory().getName().equals(custominventory.getName())){
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                switch(e.getSlot()){
                }
            }
        }
    }
    public Inventory cloneInventory(Inventory inv) {
        Inventory clone = Bukkit.createInventory(inv.getHolder(), inv.getSize(), inv.getName());
        clone.setContents(inv.getContents().clone());
        return clone;
    }

    public ItemStack formatMeta(ItemStack itemstack, String displayName, List<String> lore, Map<Enchantment,Integer> enchants) {
        ItemMeta meta = itemstack.getItemMeta();
        meta.setDisplayName(displayName);
        for(Entry<Enchantment, Integer> enchant : enchants.entrySet()) {
            meta.addEnchant(enchant.getKey(), enchant.getValue(), true);
        }
        meta.setLore(lore);
        itemstack.setItemMeta(meta);
        return itemstack;
    }
}
