package net.jack.mobsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jack.mobsmod.entity.ModEntities;
import net.jack.mobsmod.entity.client.EndguinModel;
import net.jack.mobsmod.entity.client.EndguinRenderer;
import net.jack.mobsmod.entity.client.ModModelLayers;

public class jacksMobsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ENDGUIN, EndguinModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ENDGUIN, EndguinRenderer::new);

    }
}
