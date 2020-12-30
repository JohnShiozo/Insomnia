package dev.joaoshiozo.insomnia.core.api.util.font;

import dev.joaoshiozo.insomnia.InsomniaMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import java.awt.*;

public class FontUtil
{
    private static final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

    public static int getStringWidth(String text)
    {
        return customFont() ? (InsomniaMod.customFontRenderer.getStringWidth(text) + 3) : fontRenderer.getStringWidth(text);
    }

    public static void drawString(String text, double x, double y, int color)
    {
        if (customFont())
        {
            InsomniaMod.customFontRenderer.drawString(text, x, y - 1, color, false);
        }
        else
        {
            fontRenderer.drawString(text, (int) (x), (int) (y), color);
        }
    }

    public static void drawStringWithShadow(String text, double x, double y, int color)
    {
        if (customFont())
        {
            InsomniaMod.customFontRenderer.drawStringWithShadow(text, x, y - 1, color);
        }
        else
        {
            fontRenderer.drawStringWithShadow(text, (float) (x), (float) (y), color);
        }
    }

    public static void drawCenteredStringWithShadow(String text, float x, float y, int color)
    {
        if (customFont())
        {
            InsomniaMod.customFontRenderer.drawCenteredStringWithShadow(text, x, y - 1, color);
        }
        else
        {
            fontRenderer.drawStringWithShadow(text, x - fontRenderer.getStringWidth(text) / 2f, y, color);
        }
    }

    public static void drawCenteredString(String text, float x, float y, int color)
    {
        if (customFont())
        {
            InsomniaMod.customFontRenderer.drawCenteredString(text, x, y - 1, color);
        }
        else
        {
            fontRenderer.drawString(text, (int) (x - getStringWidth(text) / 2), (int) (y), color);
        }
    }

    public static int getFontHeight()
    {
        return customFont() ? (InsomniaMod.customFontRenderer.fontHeight / 2) - 1 : fontRenderer.FONT_HEIGHT;
    }

    public static boolean validateFont(String font)
    {
        for (String s : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
        {
            if (s.equals(font))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean customFont()
    {
        return InsomniaMod.moduleManager.getModule("CustomFont").isEnabled();
    }
}