package net.jack.mobsmod.entity.client;

import net.jack.mobsmod.entity.custom.EndguinEntity;
import net.jack.mobsmod.jacksMobs;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class EndguinRenderer extends MobEntityRenderer<EndguinEntity, EndguinModel<EndguinEntity>> {
    private static final Identifier TEXTURE = new Identifier(jacksMobs.MOD_ID, "textures/entity/endguin.png");

    public EndguinRenderer(EntityRendererFactory.Context context) {
        super(context, new EndguinModel<>(context.getPart(ModModelLayers.ENDGUIN)), 0.4f);
    }

    @Override
    public Identifier getTexture(EndguinEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(EndguinEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }


            super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

