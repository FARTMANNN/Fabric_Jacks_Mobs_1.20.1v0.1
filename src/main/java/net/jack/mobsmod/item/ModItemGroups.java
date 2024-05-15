package net.jack.mobsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jack.mobsmod.jacksMobs;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup JACK_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(jacksMobs.MOD_ID, "mobmod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mobmod"))
                    .icon(() -> new ItemStack(ModItems.ENDGUIN_FEATHER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ENDGUIN_BEAK);
                        entries.add(ModItems.ENDGUIN_FEATHER);
                        entries.add(ModItems.ENDGUIN_SPAWN_EGG);
                        entries.add(ModItems.END_AXE);

                    }).build());


    public static void registerItemGroups() {
        jacksMobs.LOGGER.info("Registering Item Groups for " +jacksMobs.MOD_ID);
    }
}
