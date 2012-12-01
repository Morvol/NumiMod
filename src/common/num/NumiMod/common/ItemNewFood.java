//Package info
package num.NumiMod.common;
 
//Minecraft imports
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;

//Forge and FML imports
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

//NumiMod imports
import num.NumiMod.client.ClientProxy;
 

public class ItemNewFood extends ItemFood
	{

	/** Number of ticks to run while 'EnumAction'ing until result. */
    public final int itemUseDuration;
 
    /** The amount this food item heals the player. */
    private final int healAmount;
 
    /** Whether wolves like this food (true for raw and cooked porkchop). */
    private final boolean isWolfsFavoriteMeat;
    
    //Food constructor
    public ItemNewFood(int par1, int par2, boolean par3)
    {
    	super(par1, par2, 0.6F, par3);
    	this.itemUseDuration = 32;
        this.healAmount = par2;
        this.isWolfsFavoriteMeat = par3;
        this.setCreativeTab(NumiMod.tabNumiMod);
    }

    
    //Getting the textures
    @Override
    public String getTextureFile()
    {
            return ClientProxy.ITEMS_PNG;
    }


}