package net.jack.mobsmod.world.gen;

import net.jack.mobsmod.jacksMobs;

public class ModWorldGen {
    public static void generateWorldGen() {
        jacksMobs.LOGGER.info("Adding Dinosaurs to world generation");
        ModEntitySpawn.addEntitySpawn();
    }
}


