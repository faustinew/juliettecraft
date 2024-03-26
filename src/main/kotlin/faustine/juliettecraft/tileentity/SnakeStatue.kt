package faustine.juliettecraft.tileentity

import faustine.juliettecraft.registry.Blocks.SNAKE_STATUE
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.tileentity.TileEntity
import xyz.xenondevs.nova.world.block.context.BlockInteractContext
import xyz.xenondevs.nova.world.region.Region
import xyz.xenondevs.nova.data.config.entry
import java.util.Random

private val COOLDOWN: Int by SNAKE_STATUE.config.entry<Int>("cooldown")
private val ITEM_GIVEN: String by SNAKE_STATUE.config.entry<String>("item_given")
private val SOUND_GIVEN: String by SNAKE_STATUE.config.entry<String>("sound_given")
private val SOUND_IDLE: String by SNAKE_STATUE.config.entry<String>("sound_idle")

class SnakeStatue(blockState: NovaTileEntityState) : TileEntity(blockState) {
    private var counter = COOLDOWN
    private var random = Random()
    
    override fun handleAsyncTick() {
        if(counter > 0){
            counter -= 1
        }
        if(random.nextInt(200) == 0) {
            playSoundEffect(SOUND_IDLE,1f,1.2f)
        }
    }
    
    override fun handleRightClick(ctx: BlockInteractContext): Boolean {
        if(counter == 0) {
            val item = Material.getMaterial(ITEM_GIVEN)!!
            val stack = ItemStack(item, 1)
            val region = getBlockFrontRegion(1,1,1,1)
            val location = randomRange(region)
            world.dropItem(location, stack)
            playSoundEffect(SOUND_GIVEN,1f,0.6f)
            counter = COOLDOWN
        }
        return super.handleRightClick(ctx)
    }
    
    private fun randomRange(region: Region): Location {
        val x = random.nextDouble(region.min.x,region.max.x)
        val y = random.nextDouble(region.min.y,region.max.y)
        val z = random.nextDouble(region.min.z,region.max.z)
        return Location(region.world,x,y,z)
    }
}