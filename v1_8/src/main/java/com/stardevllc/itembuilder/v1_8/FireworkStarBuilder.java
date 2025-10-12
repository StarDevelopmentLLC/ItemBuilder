package com.stardevllc.itembuilder.v1_8;

import com.stardevllc.itembuilder.ItemBuilder;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;

public class FireworkStarBuilder extends ItemBuilder<FireworkStarBuilder, FireworkEffectMeta> {
    
    private FireworkEffect effect;
    
    public FireworkStarBuilder() {
        super(Material.FIREWORK_CHARGE);
    }
    
    public FireworkStarBuilder(ItemStack itemStack) {
        super(itemStack);
        
        FireworkEffectMeta itemMeta = (FireworkEffectMeta) itemStack.getItemMeta();
        if (itemMeta != null) {
            this.effect = itemMeta.getEffect();
        }
    }
    
    public FireworkStarBuilder(FireworkStarBuilder builder) {
        super(builder);
        this.effect = builder.effect;
    }
    
    public FireworkStarBuilder(FireworkEffect effect) {
        effect(effect);
    }

    public FireworkStarBuilder effect(FireworkEffect effect) {
        this.effect = effect;
        return this;
    }

    @Override
    protected FireworkEffectMeta createItemMeta() {
        FireworkEffectMeta itemMeta = super.createItemMeta();
        itemMeta.setEffect(this.effect);
        return itemMeta;
    }

    @Override
    public FireworkStarBuilder clone() {
        return new FireworkStarBuilder(this);
    }
}
