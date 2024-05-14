package net.jack.mobsmod.entity.client;

import net.jack.mobsmod.entity.animation.ModAnimations;
import net.jack.mobsmod.entity.custom.EndguinEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.10.0
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class EndguinModel<T extends EndguinEntity> extends SinglePartEntityModel<T> {
	private final ModelPart root;
	private final ModelPart head;

	public EndguinModel(ModelPart root) {
		this.root = root.getChild("root");
		this.head = root.getChild("root").getChild("head");
    }
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.5F, -3.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(20, 9).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -1.5F, -3.0F, 6.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.5F, 0.0F));

		ModelPartData fin_left = body.addChild("fin_left", ModelPartBuilder.create().uv(12, 13).cuboid(0.0F, -0.5F, -2.5F, 1.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -1.0F, 0.0F));

		ModelPartData fin_right = body.addChild("fin_right", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -1.0F, 0.0F));

		ModelPartData cube_r1 = fin_right.addChild("cube_r1", ModelPartBuilder.create().uv(0, 13).cuboid(0.0F, -0.5F, -2.5F, 1.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData foot_left = body.addChild("foot_left", ModelPartBuilder.create().uv(19, 20).cuboid(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 5.5F, 0.0F));

		ModelPartData foot_right = body.addChild("foot_right", ModelPartBuilder.create().uv(18, 0).cuboid(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 5.5F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(EndguinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.ENDGUIN_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.ENDGUIN_IDLE, ageInTicks, 2f);


	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.head.yaw =headYaw * 0.017453292F;
		this.head.pitch =headPitch * 0.017453292F;

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return root;
	}
}