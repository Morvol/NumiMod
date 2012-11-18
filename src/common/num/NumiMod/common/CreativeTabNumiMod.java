//Package
package num.NumiMod.common;

//Minecraft imports
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

//Forge and FML imports
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;


public class CreativeTabNumiMod extends CreativeTabs{
	//Main constructor
	public CreativeTabNumiMod(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
	//Client side texture for the tab
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return new ItemStack(Item.beefCooked);
	}
	
	//Name of the label of the tab
	@Override
	public String getTabLabel() {
        return "NumiMod";
    }

	//Name of the translated label of the tab
	@Override
	public String getTranslatedTabLabel() {
        return getTabLabel();
    }
}
