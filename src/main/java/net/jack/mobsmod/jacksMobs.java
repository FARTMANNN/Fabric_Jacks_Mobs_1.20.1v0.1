package net.jack.mobsmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.jack.mobsmod.entity.ModEntities;
import net.jack.mobsmod.entity.custom.EndguinEntity;
import net.jack.mobsmod.item.ModItemGroups;
import net.jack.mobsmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class jacksMobs implements ModInitializer {
	public static final String MOD_ID = "jacks_mobs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        FabricDefaultAttributeRegistry.register(ModEntities.ENDGUIN, EndguinEntity.createEndguinAttributes());
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}