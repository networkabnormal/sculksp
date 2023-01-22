package al.sculksp.event;

import org.bukkit.GameEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.GenericGameEvent;

public class ON_Sculk_SHIRK implements Listener {
    private void SetBlock(Block block){
        if (block.getType() == Material.SCULK_SHRIEKER){
            BlockData blockData = block.getBlockData();
            org.bukkit.block.data.type.SculkShrieker sculkShrieker = (org.bukkit.block.data.type.SculkShrieker) blockData;
            sculkShrieker.setCanSummon(true);
            blockData = sculkShrieker.clone();
            block.setBlockData(blockData,true);
        }
    }
    @EventHandler
    public void onGenericGameEvent(GenericGameEvent event){
        if (event.getEvent() == GameEvent.SHRIEK) {
            Location location = event.getLocation();
            Block block = location.getBlock();
            if (block.getType()== Material.SCULK_SHRIEKER) {
                SetBlock(block);
            }
        }
    }
}