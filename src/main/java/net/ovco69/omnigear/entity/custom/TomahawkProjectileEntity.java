package net.ovco69.omnigear.entity.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import net.ovco69.omnigear.entity.ModEntities;
import net.ovco69.omnigear.item.ModItems;

public class TomahawkProjectileEntity extends AbstractArrow {
    private float rotation;
    public Vec2 groundedOffset;

    public TomahawkProjectileEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public TomahawkProjectileEntity(LivingEntity shooter, Level level) {
        super(ModEntities.TOMAHAWK.get(), shooter, level, new ItemStack(ModItems.TOMAHAWK.get()), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.TOMAHAWK.get());
    }

    public float getRenderingRotation() {
        rotation += .5f;
        if (rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 4);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        if (result.getDirection() == Direction.SOUTH) {
            groundedOffset = new Vec2(215, 180);
        }
        if (result.getDirection() == Direction.NORTH) {
            groundedOffset = new Vec2(215, 0);
        }
        if (result.getDirection() == Direction.EAST) {
            groundedOffset = new Vec2(215, -90);
        }
        if (result.getDirection() == Direction.WEST) {
            groundedOffset = new Vec2(215, 90);
        }

        if (result.getDirection() == Direction.DOWN) {
            groundedOffset = new Vec2(115, 180);
        }
        if (result.getDirection() == Direction.UP) {
            groundedOffset = new Vec2(285, 180);
        }
    }
}
