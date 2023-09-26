package com.jellied.coolmobs.client.mixins;

import com.jellied.coolmobs.entity.EntityFireZombie;
import net.minecraft.src.game.level.SpawnListEntry;
import net.minecraft.src.game.level.biomes.BiomeGenBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(BiomeGenBase.class)
public class MixinBiomeGenBase {
    @Shadow protected List<SpawnListEntry> spawnableMonsterList;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void onInit(int arg1, CallbackInfo ci) {
        this.spawnableMonsterList.add(new SpawnListEntry(EntityFireZombie.class, 25));
    }
}
