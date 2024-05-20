package net.jack.mobsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jack.mobsmod.entity.ModEntities;
import net.jack.mobsmod.entity.custom.EndguinEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                        BiomeKeys.END_HIGHLANDS,
                        BiomeKeys.END_BARRENS,
                        BiomeKeys.SMALL_END_ISLANDS,
                        BiomeKeys.END_MIDLANDS),
                SpawnGroup.MISC,
                ModEntities.ENDGUIN, 5, 8, 10);
        SpawnRestriction.register(ModEntities.ENDGUIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EndguinEntity::isValidNaturalSpawn);

    }
}
