package net.jack.mobsmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jack.mobsmod.entity.ModEntities;
import net.jack.mobsmod.jacksMobs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ENDGUIN_BEAK = registerItem("endguin_beak",
            new Item(new FabricItemSettings()));

    public static final Item ENDGUIN_FEATHER = registerItem("endguin_feather",
            new Item(new FabricItemSettings()));

    public static final Item ENDGUIN_SPAWN_EGG = registerItem("endguin_spawn_egg",
            new SpawnEggItem(ModEntities.ENDGUIN, 0x1b1c26, 0xe4efae, new FabricItemSettings()));

    public static final Item END_AXE = registerItem("end_axe",
            new Item(new FabricItemSettings().maxCount(1)));



    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENDGUIN_BEAK);
        entries.add(ENDGUIN_FEATHER);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(jacksMobs.MOD_ID, name), item);
    }

    public static void registerModItems() {
        jacksMobs.LOGGER.info("Registering Mod Items For" + jacksMobs.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
