package com.spybot.mod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.spybot.mod.items.CBelt;
import com.spybot.mod.items.CLens;
import com.spybot.mod.items.CPlate;
import com.spybot.mod.items.RGear;
import com.spybot.mod.lib.ProxyCommon;
import com.spybot.mod.lib.References;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = References.MODID, version = References.VERSION)
public class SpyBot
{
	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
	public static ProxyCommon proxy;
	
	//Items
	    public static Item CBelt = new CBelt(150000);
	    public static Item CLens = new CLens(150001);
	    public static Item CPlate = new CPlate(150002);
	    public static Item RGear = new RGear(150003);
	    
	//CreativeTabs
	    public static CreativeTabs botMaterials = new CreativeTabs("spyMaterials"){	    	
			public Item getTabIconItem() {
				return SpyBot.RGear;
			}
	    	
	    };
	    	
	    
    @EventHandler
    public void init(FMLInitializationEvent event){
    
    }
    @EventHandler
    public void load(FMLInitializationEvent event){
    
      	proxy.registerRenderInformation();
    }
    
    public SpyBot (){
    	//Item Registry
    	    //GameReg
                GameRegistry.registerItem(CBelt, "Conveyor Belt");
                GameRegistry.registerItem(CLens, "Camera Lens");
                GameRegistry.registerItem(CPlate, "Carbon Plate");
                GameRegistry.registerItem(RGear, "Gear");
            //LangReg   
                LanguageRegistry.addName(CBelt, "Conveyor Belt");
                LanguageRegistry.addName(CLens, "Camera Lens");
                LanguageRegistry.addName(CPlate, "Carbon Plate");
                LanguageRegistry.addName(RGear, "Gear");
    	//Recipes
            //Crafting
                	GameRegistry.addRecipe(new ItemStack(SpyBot.CBelt), new Object[]{
                		"XYX",
                        "ZZZ",
                        "XYX",
                        'X', Items.leather, 'Y', new ItemStack(Items.dye, 1, 0), 'Z', Items.iron_ingot
            });
                    
                	GameRegistry.addRecipe(new ItemStack(SpyBot.CLens), new Object[]{
                		"ABA",
                		"ACA",
                		"ABA",
                		'A', Items.iron_ingot, 'B', Blocks.glass, 'C', Blocks.glass_pane
            });    		
                    //Smelting
                		FurnaceRecipes.smelting().func_151396_a(Items.flint, new ItemStack(SpyBot.CPlate), 0.1F);
                			
    }
}
