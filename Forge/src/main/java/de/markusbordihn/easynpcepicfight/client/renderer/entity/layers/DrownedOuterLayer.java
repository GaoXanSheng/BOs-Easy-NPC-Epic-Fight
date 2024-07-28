package de.markusbordihn.easynpcepicfight.client.renderer.entity.layers;

import com.mojang.blaze3d.platform.NativeImage;
import de.markusbordihn.easynpcepicfight.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@OnlyIn(Dist.CLIENT)
public class DrownedOuterLayer {
    private ResourceLocation TEXTURE_BY_VARIANT;
    private ResourceLocation OUTER_TEXTURE_BY_VARIANT;
    private ResourceLocation OUT_TEXTURE;

    public DrownedOuterLayer(ResourceLocation TEXTURE_BY_VARIANT, ResourceLocation OUTER_TEXTURE_BY_VARIANT) {
        this.TEXTURE_BY_VARIANT = TEXTURE_BY_VARIANT;
        this.OUTER_TEXTURE_BY_VARIANT = OUTER_TEXTURE_BY_VARIANT;
        this.OUT_TEXTURE = textureCombination();
    }

    public ResourceLocation getTexture() {
        return OUT_TEXTURE;
    }

    private ResourceLocation textureCombination() {
        BufferedImage innerImage = loadImage(TEXTURE_BY_VARIANT);
        BufferedImage outerImage = loadImage(OUTER_TEXTURE_BY_VARIANT);
        try {
            if (null != innerImage && null != outerImage) {
                BufferedImage combinedImage = combineImages(innerImage, outerImage);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(combinedImage, "png", baos);
                byte[] imageBytes = baos.toByteArray();
                String base64String = Base64.getEncoder().encodeToString(imageBytes);
                return registerBufferedImageAsTexture(base64String, Constants.MOD_ID);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private ResourceLocation registerBufferedImageAsTexture(String image, String name) {
        try {
            DynamicTexture dynamicTexture = new DynamicTexture(NativeImage.fromBase64(image));
            ResourceLocation resourceLocation = new ResourceLocation(name);
            Minecraft.getInstance().getTextureManager().register(resourceLocation, dynamicTexture);
            return resourceLocation;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private BufferedImage loadImage(ResourceLocation textureByVariant) {
        try {
            return ImageIO.read(Minecraft.getInstance().getResourceManager().getResource(textureByVariant).getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private BufferedImage combineImages(BufferedImage TEXTURE_BY_VARIANT, BufferedImage OUTER_TEXTURE_BY_VARIANT) {
        BufferedImage combinedImage = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
        combinedImage.getGraphics().drawImage(TEXTURE_BY_VARIANT, 0, 0, null);
        combinedImage.getGraphics().drawImage(OUTER_TEXTURE_BY_VARIANT, 0, 0, null);
        combinedImage.getGraphics().drawImage(OUTER_TEXTURE_BY_VARIANT, 32, 0, null);
        return combinedImage;
    }
}
