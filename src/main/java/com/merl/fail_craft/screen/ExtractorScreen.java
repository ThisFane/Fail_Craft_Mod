package com.merl.fail_craft.screen;

import com.merl.fail_craft.Fail_Craft;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;



public class ExtractorScreen extends AbstractContainerScreen<ExtractorMenu> {
    private  static final ResourceLocation TEXTURE = new ResourceLocation(Fail_Craft.MOD_ID, "textures/gui/extractor_gui.png");

    public ExtractorScreen(ExtractorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        inventoryLabelY = 9001;
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.isCrafting()) {
            blit(pPoseStack, x + 102, y + 41, 176, 0, 8, menu.getScaledProgress());
        }

        blit(pPoseStack, x + 8, y + 7, 176, 3, 16, menu.getHeatLevel());
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
        font.draw(pPoseStack, String.valueOf(menu.energy()),100,100,1);

    }

}
