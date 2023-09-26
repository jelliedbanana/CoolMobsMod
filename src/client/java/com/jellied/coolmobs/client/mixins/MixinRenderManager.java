package com.jellied.coolmobs.client.mixins;

import com.jellied.coolmobs.entity.EntityFireZombie;
import net.minecraft.src.client.model.ModelZombie;
import net.minecraft.src.client.renderer.entity.Render;
import net.minecraft.src.client.renderer.entity.RenderBiped;
import net.minecraft.src.client.renderer.entity.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RenderManager.class)
public class MixinRenderManager {
    @Shadow private Map<Class<?>, Render> entityRenderMap;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void onInit(CallbackInfo ci) {
        RenderManager instance = (RenderManager) (Object) this;

        Render zombieRenderer = new RenderBiped(new ModelZombie(), 0.5F);
        zombieRenderer.setRenderManager(instance);
        this.entityRenderMap.put(EntityFireZombie.class, zombieRenderer);
    }
}
