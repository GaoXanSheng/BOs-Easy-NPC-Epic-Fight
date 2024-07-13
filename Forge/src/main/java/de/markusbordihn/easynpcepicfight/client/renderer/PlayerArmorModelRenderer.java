package de.markusbordihn.easynpcepicfight.client.renderer;

import de.markusbordihn.easynpc.Constants;
import de.markusbordihn.easynpc.entity.easynpc.EasyNPC;
import de.markusbordihn.easynpc.entity.easynpc.data.ModelData;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import yesman.epicfight.api.client.model.armor.CustomModelBakery;
import yesman.epicfight.api.client.model.armor.VanillaArmor;

public class PlayerArmorModelRenderer<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends HumanoidArmorLayer<T, M, A> {
    private final VanillaArmor vanillaArmor = new VanillaArmor();

    public PlayerArmorModelRenderer(RenderLayerParent<T, M> p_117075_, A innerModel, A outerModel) {
        super(p_117075_, innerModel, outerModel);
        CustomModelBakery.registerNewTransformer(vanillaArmor);
    }

    public ResourceLocation getArmorResource(Entity entity, ArmorItem itemStack, EquipmentSlot equipmentSlot, String type) {
        if (entity instanceof EasyNPC<?> easyNPC) {
            ModelData<?> modelData = easyNPC.getEasyNPCModelData();
            if (modelData != null && (equipmentSlot == EquipmentSlot.CHEST && modelData.isModelChestplateVisible() || equipmentSlot == EquipmentSlot.LEGS && modelData.isModelLeggingsVisible() || equipmentSlot == EquipmentSlot.FEET && modelData.isModelBootsVisible() || equipmentSlot == EquipmentSlot.HEAD && modelData.isModelHelmetVisible())) {
                vanillaArmor.transformModel(super.getParentModel(),itemStack,equipmentSlot,true);
                return super.getArmorResource(entity, itemStack.getDefaultInstance(), equipmentSlot, type);
            }
        }

        return Constants.BLANK_ENTITY_TEXTURE;
    }
}
