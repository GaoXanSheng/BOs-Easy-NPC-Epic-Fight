/*
 * Copyright 2023 Markus Bordihn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusbordihn.easynpcepicfight.client.renderer;

import de.markusbordihn.easynpc.client.renderer.entity.standard.*;
import de.markusbordihn.easynpcepicfight.Constants;
import de.markusbordihn.easynpcepicfight.entity.ModEntityType;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class ClientRenderer {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  private ClientRenderer() {}

  public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {

    log.info("{} Entity Renders ...", Constants.LOG_REGISTER_PREFIX);

    event.registerEntityRenderer(ModEntityType.EVOKER.get(), IllagerModelRenderer::new);
    event.registerEntityRenderer(
        ModEntityType.HUMANOID.get(),
        context -> new HumanoidModelRenderer(context, HumanoidArmorLayer.class));
    event.registerEntityRenderer(
        ModEntityType.HUMANOID_SLIM.get(),
        context -> new HumanoidSlimModelRenderer(context, HumanoidArmorLayer.class));
    event.registerEntityRenderer(
        ModEntityType.HUSK.get(),
        context -> new ZombieModelRenderer(context, HumanoidArmorLayer.class));
    event.registerEntityRenderer(ModEntityType.ILLUSIONER.get(), IllagerModelRenderer::new);
    event.registerEntityRenderer(ModEntityType.IRON_GOLEM.get(), IronGolemModelRenderer::new);
    event.registerEntityRenderer(
        ModEntityType.SKELETON.get(),
        context -> new SkeletonModelRenderer(context, HumanoidArmorLayer.class));
    event.registerEntityRenderer(
        ModEntityType.STRAY.get(),
        context -> new SkeletonModelRenderer(context, HumanoidArmorLayer.class));
    event.registerEntityRenderer(ModEntityType.PILLAGER.get(), IllagerModelRenderer::new);
    event.registerEntityRenderer(ModEntityType.VINDICATOR.get(), IllagerModelRenderer::new);
    event.registerEntityRenderer(
        ModEntityType.WITHER_SKELETON.get(),
        context -> new SkeletonModelRenderer(context, HumanoidArmorLayer.class));
    event.registerEntityRenderer(
        ModEntityType.ZOMBIE.get(),
        context -> new HumanoidModelRenderer(context, HumanoidArmorLayer.class));
    event.registerEntityRenderer(
        ModEntityType.ZOMBIE_VILLAGER.get(),
        context -> new ZombieVillagerModelRenderer(context, HumanoidArmorLayer.class));
  }
}
