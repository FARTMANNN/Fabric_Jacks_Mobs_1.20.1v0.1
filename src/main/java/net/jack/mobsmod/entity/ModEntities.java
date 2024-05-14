package net.jack.mobsmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.jack.mobsmod.entity.custom.EndguinEntity;
import net.jack.mobsmod.jacksMobs;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEntities {
    public static final EntityType<EndguinEntity> ENDGUIN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(jacksMobs.MOD_ID, "endguin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EndguinEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());;
}
