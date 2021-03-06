package hextec.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class PalladiumOreGenerator implements IWorldGenerator
{
	private Block block;
	
	public PalladiumOreGenerator(Block block)
	{
		this.block = block;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,IChunkProvider chunkProvider) 
	{
		if(world.provider.getDimensionId() == 0)
		{
			chunkX *= 16;
			chunkZ *= 16;
			
			for(int i=0;i<2;i++)	//schleife fuer 30mal versuchen ore zu generieren
			{
				int posX = chunkX+random.nextInt(16);
				int posZ = chunkZ+random.nextInt(16);
				int posY = random.nextInt(10); //h�he auf der ore spawnt
				
				WorldGenMinable wgm = new WorldGenMinable(block.getDefaultState(),4);
				
				wgm.generate(world, random, new BlockPos(posX, posY, posZ));
			}
		}
	}
}
