package com.jellied.coolmobs.entity;

import net.minecraft.src.game.MathHelper;
import net.minecraft.src.game.entity.Entity;
import net.minecraft.src.game.entity.EntityMob;
import net.minecraft.src.game.item.Item;
import net.minecraft.src.game.level.World;

public class EntityFireZombie extends EntityMob {
    public EntityFireZombie(World world) {
        super(world);

        this.texture = "/mob/monsters/fire_zombie.png";
        this.moveSpeed = 0.5f;
        this.attackStrength = 3;
        this.scoreValue = 10;
    }

    public String getEntityString() {
        return "FireZombie";
    }

    @Override
    public Item getSpawnEgg() {
        return Item.zombieSpawnEgg;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    protected String getLivingSound() {
        return "mob.zombie";
    }

    @Override
    protected String getHurtSound() {
        return "mob.zombiehurt";
    }

    @Override
    protected String getDeathSound() {
        return "mob.zombiedeath";
    }

    @Override
    protected int getDropItemId() {
        return Item.feather.itemID;
    }

    public void attackEntity(Entity target, float distance) {
        if (this.attackTime <= 0 && distance < 2.0f && target.boundingBox.maxY > this.boundingBox.minY && target.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.swingItem();

            target.attackEntityFrom(this, this.attackStrength);
            target.fire = 300;
        }
    }
}
