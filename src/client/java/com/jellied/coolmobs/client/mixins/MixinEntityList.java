package com.jellied.coolmobs.client.mixins;

import com.jellied.coolmobs.entity.EntityFireZombie;
import net.minecraft.src.game.entity.Entity;
import net.minecraft.src.game.entity.EntityList;
import net.minecraft.src.game.level.World;
import net.minecraft.src.game.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(EntityList.class)
public class MixinEntityList {
    @Inject(method = "createEntityFromNBT", at = @At("HEAD"), cancellable = true)
    private static void getEntityClass(NBTTagCompound nbt, World world, CallbackInfoReturnable<Entity> cir) {
        if (nbt.hasKey("id") && nbt.getString("id").equals("FireZombie")) {
            EntityFireZombie zombie = new EntityFireZombie(world);
            zombie.readFromNBT(nbt);

            cir.setReturnValue(zombie);
            cir.cancel();
        }
    }
}
