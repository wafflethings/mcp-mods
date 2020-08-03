package clientname.mods.impl;

import java.util.UUID;
import com.mojang.authlib.GameProfile;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import clientname.utils.PlayerRenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;

public class ModBossbar extends ModDraggable{

	/*
	 *█▀▄▀█ █▀▀█ █▀▀▄ █▀▀   █▀▀▄ █░░█   █░░░█ █▀▀█ █▀▀ █▀▀ █░░ █▀▀ █
	 *█░▀░█ █▄▄█ █░░█ █▀▀   █▀▀▄ █▄▄█   █▄█▄█ █▄▄█ █▀▀ █▀▀ █░░ █▀▀ ▀
	 *▀░░░▀ ▀░░▀ ▀▀▀░ ▀▀▀   ▀▀▀░ ▄▄▄█   ░▀░▀░ ▀░░▀ ▀░░ ▀░░ ▀▀▀ ▀▀▀ ▄
	 *
	 * Please credit. Although I can't make you do it, it'd be nice.
	 *         The save and load methods are commented out,
	 *                 so it works with FileIO.
	 *              Just add them back if you want.
	 * It might error when you save this class, just press save as UTF-8.
	 */
	
	protected float zLevelFloat;
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 182;
	}
	
	public int getX() {
		return pos.getAbsoluteX();
	}

	@Override
	public int getHeight() {
		return 18;
	}

	int offset = 13;
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		this.mc.getTextureManager().bindTexture(Gui.icons);
        --BossStatus.statusBarTime;
        FontRenderer fontrenderer = this.mc.fontRendererObj;
        this.mc.getTextureManager().bindTexture(Gui.icons);
        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
        int i = scaledresolution.getScaledWidth();
        int j = 182;
        this.mc.getTextureManager().bindTexture(Gui.icons);
        int k = i / 2 - j / 2;            
        int l = (int)(BossStatus.healthScale * (float)(j + 1));
        int i1 = 12;
        drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + offset + 1, 0, 74, j, 5);
        drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + offset + 1, 0, 74, j, 5);
        if (l > 0)
        {
            drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + offset + 1, 0, 79, l, 5);
        }
        this.mc.getTextureManager().bindTexture(Gui.icons);
        
        String s = "Bossbar";
        
        font.drawStringWithShadow(s, (((this.getWidth() / 2) - (font.getStringWidth(s) / 2)) + pos.getAbsoluteX()), (pos.getAbsoluteY() - 10) + offset, 16777215);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Gui.icons);	
	}
	
	@Override
	public void render(ScreenPosition pos) {	
		if (BossStatus.bossName != null && BossStatus.statusBarTime > 0)
        {
            this.mc.getTextureManager().bindTexture(Gui.icons);
            --BossStatus.statusBarTime;
            FontRenderer fontrenderer = this.mc.fontRendererObj;
            this.mc.getTextureManager().bindTexture(Gui.icons);
            ScaledResolution scaledresolution = new ScaledResolution(this.mc);
            int i = scaledresolution.getScaledWidth();
            int j = 182;
            this.mc.getTextureManager().bindTexture(Gui.icons);
            int k = i / 2 - j / 2;            int l = (int)(BossStatus.healthScale * (float)(j + 1));
            int i1 = 12;
            drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + offset, 0, 74, j, 5);
            drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + offset, 0, 74, j, 5);
            if (l > 0)
            {
                drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + offset, 0, 79, l, 5);
            }
            this.mc.getTextureManager().bindTexture(Gui.icons);
            
            String s = BossStatus.bossName;
            
            font.drawStringWithShadow(s, (((this.getWidth() / 2) - (font.getStringWidth(s) / 2)) + pos.getAbsoluteX()), (pos.getAbsoluteY() - 10) + offset, 16777215);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.getTextureManager().bindTexture(Gui.icons);
        }
	}
	
	  public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height)
	    {
	        float f = 0.00390625F;
	        float f1 = 0.00390625F;
	        Tessellator tessellator = Tessellator.getInstance();
	        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
	        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
	        worldrenderer.pos((double)(x + 0), (double)(y + height), (double)this.zLevelFloat).tex((double)((float)(textureX + 0) * f), (double)((float)(textureY + height) * f1)).endVertex();
	        worldrenderer.pos((double)(x + width), (double)(y + height), (double)this.zLevelFloat).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + height) * f1)).endVertex();
	        worldrenderer.pos((double)(x + width), (double)(y + 0), (double)this.zLevelFloat).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + 0) * f1)).endVertex();
	        worldrenderer.pos((double)(x + 0), (double)(y + 0), (double)this.zLevelFloat).tex((double)((float)(textureX + 0) * f), (double)((float)(textureY + 0) * f1)).endVertex();
	        tessellator.draw();
	    }

    public FontRenderer getFontRenderer()
    {
        return this.mc.fontRendererObj;
    }
}
